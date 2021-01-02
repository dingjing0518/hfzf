package com.jinshipark.hfzf.service;


import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.vo.AdapayRequstVO;

public interface AdapayAliPayService {
    JinshiparkJSONResult alipayExecutePayment(AdapayRequstVO adapayRequstVO);
}
