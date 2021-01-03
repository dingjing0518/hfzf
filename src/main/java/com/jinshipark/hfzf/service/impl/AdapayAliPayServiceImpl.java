package com.jinshipark.hfzf.service.impl;

import com.huifu.adapay.core.exception.BaseAdaPayException;
import com.huifu.adapay.model.Payment;
import com.jinshipark.hfzf.config.ADAPayPropertyConfig;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import com.jinshipark.hfzf.service.AdapayAliPayService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class AdapayAliPayServiceImpl implements AdapayAliPayService {

    @Override
    public JinshiparkJSONResult alipayExecutePayment(AdapayRequstVO adapayRequstVO) {
        Map<String, Object> payment = new HashMap<>();
        Map<String, Object> paymentParams = new HashMap<String, Object>();
        paymentParams.put("app_id", ADAPayPropertyConfig.getStrValueByKey("app_id"));
        paymentParams.put("order_no", adapayRequstVO.getOrder_no());
        paymentParams.put("pay_channel", "alipay");
        paymentParams.put("pay_amt", new DecimalFormat("0.00").format(Float.parseFloat(adapayRequstVO.getPay_amt())));
        paymentParams.put("currency", "cny");
        paymentParams.put("goods_title", "停车缴费");
        paymentParams.put("goods_desc", "停车缴费说明");
        paymentParams.put("notify_url", ADAPayPropertyConfig.getStrValueByKey("notify_url"));
        try {
            payment = Payment.create(paymentParams);
        } catch (BaseAdaPayException e) {
            return JinshiparkJSONResult.errorMsg("调用汇付支付宝APP接口异常");
        }
        if (payment.get("status").equals("failed")) {
            return JinshiparkJSONResult.errorMsg(String.valueOf(payment.get("error_msg")));
        }
        return JinshiparkJSONResult.ok(payment);
    }

    public static void main(String[] args) {
        System.out.println(new DecimalFormat("0.00").format(Float.parseFloat("10")));
    }
}
