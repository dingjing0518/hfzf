package com.jinshipark.hfzf.service.impl;

import com.huifu.adapay.core.exception.BaseAdaPayException;
import com.huifu.adapay.model.Payment;
import com.jinshipark.hfzf.config.ADAPayPropertyConfig;
import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.mapper2.JinshiparkApakeyMapper;
import com.jinshipark.hfzf.model.JinshiparkApakey;
import com.jinshipark.hfzf.model.JinshiparkApakeyExample;
import com.jinshipark.hfzf.model.LincensePlate;
import com.jinshipark.hfzf.model.LincensePlateExample;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.utils.KeyUtils;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import com.jinshipark.hfzf.service.AdapayAliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdapayAliPayServiceImpl implements AdapayAliPayService {
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
        JinshiparkApakey jinshiparkApakey = list.get(0);
        Map<String, Object> payment = new HashMap<>();
        Map<String, Object> paymentParams = new HashMap<String, Object>();
        paymentParams.put("app_id", jinshiparkApakey.getAppid());
        paymentParams.put("order_no", adapayRequstVO.getOrder_no());
        paymentParams.put("pay_channel", "alipay");
        paymentParams.put("pay_amt", new DecimalFormat("0.00").format(Float.parseFloat(adapayRequstVO.getPay_amt())));
        paymentParams.put("currency", "cny");
        paymentParams.put("goods_title", "停车缴费");
        paymentParams.put("goods_desc", "停车缴费说明");
        paymentParams.put("notify_url", adapayRequstVO.getNotify_url());
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
        LincensePlate lincensePlate=new LincensePlate();
        lincensePlate.setLpOrderId(adapayRequstVO.getOrder_no());
        lincensePlateMapper.updateByExampleSelective(lincensePlate,lincensePlateExample);
        return JinshiparkJSONResult.ok(payment);
    }

    public static void main(String[] args) {
        System.out.println(new DecimalFormat("0.00").format(Float.parseFloat("10")));
    }
}
