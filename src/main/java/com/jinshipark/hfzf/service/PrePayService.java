package com.jinshipark.hfzf.service;

import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.vo.AdapayRequstVO;

public interface PrePayService {
    JinshiparkJSONResult prePayExecutePayment(AdapayRequstVO adapayRequstVO);
}
