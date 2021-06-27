package com.jinshipark.hfzf.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.huifu.adapay.core.exception.BaseAdaPayException;
import com.huifu.adapay.model.Payment;
import com.jinshipark.hfzf.mapper.JinshiparkInrecordRoadMapper;
import com.jinshipark.hfzf.mapper.JinshiparkOutrecordRoadMapper;
import com.jinshipark.hfzf.mapper.LincensePlateHistoryMapper;
import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.mapper2.JinshiparkApakeyMapper;
import com.jinshipark.hfzf.model.*;
import com.jinshipark.hfzf.service.AdapayWxPubService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.utils.KeyUtils;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdapayWxPubServiceImpl implements AdapayWxPubService {
    public static final Logger logger = LoggerFactory.getLogger(AdapayWxPubServiceImpl.class);
    @Autowired
    private JinshiparkApakeyMapper jinshiparkApakeyMapper;
    @Autowired
    private LincensePlateMapper lincensePlateMapper;
    @Autowired
    private LincensePlateHistoryMapper lincensePlateHistoryMapper;

    @Autowired
    private JinshiparkInrecordRoadMapper jinshiparkInrecordRoadMapper;

    @Autowired
    private JinshiparkOutrecordRoadMapper jinshiparkOutrecordRoadMapper;

    @Override
    public JinshiparkJSONResult wxPubExecutePayment(AdapayRequstVO adapayRequstVO) {
        JinshiparkApakeyExample example = new JinshiparkApakeyExample();
        JinshiparkApakeyExample.Criteria criteria = example.createCriteria();
        criteria.andParkidEqualTo(adapayRequstVO.getParkId());
        List<JinshiparkApakey> list = jinshiparkApakeyMapper.selectByExample(example);
        if (list.size() == 0) {
            return JinshiparkJSONResult.errorMsg("支付参数不正确");
        }
        String orderId = KeyUtils.getOrderIdByPlate(adapayRequstVO.getPlate(), adapayRequstVO.getParkId());
        JinshiparkApakey jinshiparkApakey = list.get(0);
        Map<String, Object> payment = new HashMap<>();
        Map<String, Object> paymentParams = new HashMap<String, Object>();
        paymentParams.put("app_id", jinshiparkApakey.getAppid());
        paymentParams.put("order_no", orderId);
        paymentParams.put("pay_channel", "wx_pub");
        paymentParams.put("expend", "{\"open_id\":\"" + adapayRequstVO.getOpen_id() + "\"}");
        paymentParams.put("pay_amt", new DecimalFormat("0.00").format(Float.parseFloat(adapayRequstVO.getPay_amt())));
        paymentParams.put("currency", "cny");
        paymentParams.put("goods_title", "停车缴费");
        paymentParams.put("goods_desc", "停车缴费说明");
        paymentParams.put("notify_url", adapayRequstVO.getNotify_url());
        logger.error("===汇付支付微信渠道参数===");
        logger.error("app_id:{},订单号:{},支付金额:{}元", jinshiparkApakey.getAppid(), orderId, paymentParams.get("pay_amt"));
        try {
            payment = Payment.create(paymentParams, adapayRequstVO.getParkId());
        } catch (BaseAdaPayException e) {
            return JinshiparkJSONResult.errorMsg("调用汇付微信公众号接口异常");
        }
        if (payment.get("status").equals("failed")) {
            return JinshiparkJSONResult.errorMsg(String.valueOf(payment.get("error_msg")));
        }
        LincensePlateExample lincensePlateExample = new LincensePlateExample();
        LincensePlateExample.Criteria lincensePlateExampleCriteria = lincensePlateExample.createCriteria();
        lincensePlateExampleCriteria.andLpLincensePlateIdCarEqualTo(adapayRequstVO.getPlate());
        LincensePlate lincensePlate = new LincensePlate();
        lincensePlate.setLpOrderId(orderId);
        lincensePlateMapper.updateByExampleSelective(lincensePlate, lincensePlateExample);
        JSONObject expand = (JSONObject) payment.get("expend");
        return JinshiparkJSONResult.ok(JSONObject.parse(expand.getString("pay_info")));
    }

    @Override
    public JinshiparkJSONResult wxPubExecutePaymentForRoad(AdapayRequstVO adapayRequstVO) {
        logger.error("道路停车应付金额:{}元", adapayRequstVO.getPay_amt());
        logger.error("结果：{}", adapayRequstVO.getPay_amt().equals("0"));
        if (adapayRequstVO.getPay_amt().equals("0")) {
            //道路停车应付金额为0的情况
            JinshiparkInrecordRoadExample jinshiparkInrecordRoadExample = new JinshiparkInrecordRoadExample();
            JinshiparkInrecordRoadExample.Criteria criteria = jinshiparkInrecordRoadExample.createCriteria();
            criteria.andLpLincensePlateIdCarEqualTo(adapayRequstVO.getPlate());
            JinshiparkInrecordRoad inrecordRoad = new JinshiparkInrecordRoad();
            inrecordRoad.setLpPaymentType("免费时长内出场");//支付方式
            inrecordRoad.setLpDepartureTime(new Date());//离场时间
            int result = jinshiparkInrecordRoadMapper.updateByExampleSelective(inrecordRoad, jinshiparkInrecordRoadExample);
            if (result > 0) {
                logger.error("===更新成功车牌：{}成功===", adapayRequstVO.getPlate());
            }

            List<JinshiparkInrecordRoad> jinshiparkInrecordRoads = jinshiparkInrecordRoadMapper.selectByExample(jinshiparkInrecordRoadExample);
            JinshiparkInrecordRoad road = jinshiparkInrecordRoads.get(0);
            //移动在场记录表里数据到在场历史表里
            JinshiparkOutrecordRoad outrecordRoad = new JinshiparkOutrecordRoad();
            BeanUtils.copyProperties(road, outrecordRoad);
            outrecordRoad.setLpId(null);
            int count = jinshiparkOutrecordRoadMapper.insertSelective(outrecordRoad);
            if (count > 0) {
                jinshiparkInrecordRoadMapper.deleteByExample(jinshiparkInrecordRoadExample);
            }
            return JinshiparkJSONResult.errorMsg("支付成功");
        } else {
            JinshiparkApakeyExample example = new JinshiparkApakeyExample();
            JinshiparkApakeyExample.Criteria criteria = example.createCriteria();
            criteria.andParkidEqualTo(adapayRequstVO.getParkId());
            List<JinshiparkApakey> list = jinshiparkApakeyMapper.selectByExample(example);
            if (list.size() == 0) {
                return JinshiparkJSONResult.errorMsg("支付参数不正确");
            }
            String orderId = KeyUtils.getOrderIdByPlate(adapayRequstVO.getPlate(), adapayRequstVO.getParkId());
            JinshiparkApakey jinshiparkApakey = list.get(0);
            Map<String, Object> payment = new HashMap<>();
            Map<String, Object> paymentParams = new HashMap<String, Object>();
            paymentParams.put("app_id", jinshiparkApakey.getAppid());
            paymentParams.put("order_no", orderId);
            paymentParams.put("pay_channel", "wx_pub");
            paymentParams.put("expend", "{\"open_id\":\"" + adapayRequstVO.getOpen_id() + "\"}");
            paymentParams.put("pay_amt", new DecimalFormat("0.00").format(Float.parseFloat(adapayRequstVO.getPay_amt())));
            paymentParams.put("currency", "cny");
            paymentParams.put("goods_title", "停车缴费");
            paymentParams.put("goods_desc", "停车缴费说明");
            paymentParams.put("notify_url", adapayRequstVO.getNotify_url());
            logger.error("===汇付支付微信渠道参数（道路停车）===");
            logger.error("app_id:{},订单号:{},支付金额:{}元", jinshiparkApakey.getAppid(), orderId, paymentParams.get("pay_amt"));
            try {
                payment = Payment.create(paymentParams, adapayRequstVO.getParkId());
            } catch (BaseAdaPayException e) {
                return JinshiparkJSONResult.errorMsg("调用汇付微信公众号接口异常");
            }
            if (payment.get("status").equals("failed")) {
                return JinshiparkJSONResult.errorMsg(String.valueOf(payment.get("error_msg")));
            }
            JinshiparkInrecordRoadExample inrecordRoadExample = new JinshiparkInrecordRoadExample();
            JinshiparkInrecordRoadExample.Criteria inrecordRoadExampleCriteria = inrecordRoadExample.createCriteria();
            inrecordRoadExampleCriteria.andLpLincensePlateIdCarEqualTo(adapayRequstVO.getPlate());
            JinshiparkInrecordRoad road = new JinshiparkInrecordRoad();
            road.setLpOrderId(orderId);
            jinshiparkInrecordRoadMapper.updateByExampleSelective(road, inrecordRoadExample);
            JSONObject expand = (JSONObject) payment.get("expend");
            return JinshiparkJSONResult.ok(JSONObject.parse(expand.getString("pay_info")));
        }
    }
}
