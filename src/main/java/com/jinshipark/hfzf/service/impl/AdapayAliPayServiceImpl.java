package com.jinshipark.hfzf.service.impl;

import com.huifu.adapay.core.exception.BaseAdaPayException;
import com.huifu.adapay.model.Payment;
import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.mapper2.JinshiparkApakeyMapper;
import com.jinshipark.hfzf.model.JinshiparkApakey;
import com.jinshipark.hfzf.model.JinshiparkApakeyExample;
import com.jinshipark.hfzf.model.LincensePlate;
import com.jinshipark.hfzf.model.LincensePlateExample;
import com.jinshipark.hfzf.service.AdapayAliPayService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.utils.KeyUtils;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdapayAliPayServiceImpl implements AdapayAliPayService {
    public static final Logger logger = LoggerFactory.getLogger(AdapayAliPayServiceImpl.class);
    @Autowired
    private JinshiparkApakeyMapper jinshiparkApakeyMapper;
    @Autowired
    private LincensePlateMapper lincensePlateMapper;


    @Override
    public JinshiparkJSONResult alipayExecutePayment(AdapayRequstVO adapayRequstVO) {
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
        paymentParams.put("pay_channel", "alipay");
        paymentParams.put("pay_amt", new DecimalFormat("0.00").format(Float.parseFloat(adapayRequstVO.getPay_amt())));
        paymentParams.put("currency", "cny");
        paymentParams.put("goods_title", "停车缴费");
        paymentParams.put("goods_desc", "停车缴费说明");
        paymentParams.put("notify_url", adapayRequstVO.getNotify_url());
        logger.error("===汇付支付支付宝渠道参数===");
        logger.error("app_id:{},订单号:{},支付金额:{}元", jinshiparkApakey.getAppid(), orderId, paymentParams.get("pay_amt"));
        try {
            payment = Payment.create(paymentParams, adapayRequstVO.getParkId());
        } catch (BaseAdaPayException e) {
            return JinshiparkJSONResult.errorMsg("调用汇付支付宝APP接口异常");
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
        return JinshiparkJSONResult.ok(payment);
    }

    public static void main(String[] args) {
        System.out.println(new DecimalFormat("0.00").format(Float.parseFloat("10")));
    }
}
