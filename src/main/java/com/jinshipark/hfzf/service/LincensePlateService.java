package com.jinshipark.hfzf.service;

import com.jinshipark.hfzf.model.vo.LincensePlateVO;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;

public interface LincensePlateService {
    JinshiparkJSONResult getLincensePlate(LincensePlateVO lincensePlateVO);

    void updateLincensePlate(String order_no, String pay_channel, String pay_amt, String paymentId);

    void updateLincensePlateForPrePay(String order_no, String pay_channel, String pay_amt, String paymentId);

    void updateLincensePlateForNoPlate(String order_no, String pay_channel, String pay_amt, String paymentId);

    JinshiparkJSONResult getLincensePlateByPlate(LincensePlateVO lincensePlateVO);

    JinshiparkJSONResult getLincensePlateByNoPlate(LincensePlateVO lincensePlateVO);

    JinshiparkJSONResult saveLincensePlate(LincensePlateVO lincensePlateVO);

    JinshiparkJSONResult getLincensePlateInfo(LincensePlateVO lincensePlateVO);
}
