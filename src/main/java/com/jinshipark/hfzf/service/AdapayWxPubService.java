package com.jinshipark.hfzf.service;


import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.vo.AdapayRequstVO;

public interface AdapayWxPubService {
    JinshiparkJSONResult wxPubExecutePayment(AdapayRequstVO adapayRequstVO);
}
