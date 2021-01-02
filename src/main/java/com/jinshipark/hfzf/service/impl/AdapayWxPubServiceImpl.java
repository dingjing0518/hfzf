package com.jinshipark.hfzf.service.impl;


import com.huifu.adapay.core.exception.BaseAdaPayException;
import com.huifu.adapay.model.Payment;
import com.jinshipark.hfzf.config.ADAPayPropertyConfig;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import com.jinshipark.hfzf.service.AdapayWxPubService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdapayWxPubServiceImpl implements AdapayWxPubService {

    @Override
    public JinshiparkJSONResult wxPubExecutePayment(AdapayRequstVO adapayRequstVO) {
        Map<String, Object> payment = new HashMap<>();
        Map<String, Object> paymentParams = new HashMap<String, Object>();
        paymentParams.put("app_id", ADAPayPropertyConfig.getStrValueByKey("app_id"));
        paymentParams.put("order_no", adapayRequstVO.getOrder_no());
        paymentParams.put("open_id", adapayRequstVO.getOpen_id());
        paymentParams.put("pay_channel", "wx_pub");
        paymentParams.put("pay_amt", adapayRequstVO.getPay_amt());
        paymentParams.put("currency", "cny");
        paymentParams.put("goods_title", adapayRequstVO.getGoods_title());
        paymentParams.put("goods_desc", adapayRequstVO.getGoods_desc());
        paymentParams.put("notify_url", ADAPayPropertyConfig.getStrValueByKey("notify_url"));
        try {
            payment = Payment.create(paymentParams);
        } catch (BaseAdaPayException e) {
            return JinshiparkJSONResult.errorMsg("调用汇付微信公众号接口异常");
        }
        if (payment.get("status").equals("failed")) {
            return JinshiparkJSONResult.errorMsg(String.valueOf(payment.get("error_msg")));
        }
        return JinshiparkJSONResult.ok(payment);
    }
}
