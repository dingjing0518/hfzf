package com.jinshipark.hfzf.service;

import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.vo.AdapayRequstVO;

import java.text.ParseException;

public interface NoPlatePayService {
    JinshiparkJSONResult noPlatePayExecutePayment(AdapayRequstVO adapayRequstVO);
}
