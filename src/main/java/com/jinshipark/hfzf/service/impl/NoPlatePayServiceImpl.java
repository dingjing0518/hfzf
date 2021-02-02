package com.jinshipark.hfzf.service.impl;

import com.jinshipark.hfzf.mapper.JinshiParkSettingMapper;
import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.model.JinshiParkSetting;
import com.jinshipark.hfzf.model.JinshiParkSettingExample;
import com.jinshipark.hfzf.model.LincensePlate;
import com.jinshipark.hfzf.model.LincensePlateExample;
import com.jinshipark.hfzf.service.AdapayWxPubService;
import com.jinshipark.hfzf.service.NoPlatePayService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.utils.KeyUtils;
import com.jinshipark.hfzf.utils.PayUtils;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Service
public class NoPlatePayServiceImpl implements NoPlatePayService {
    @Autowired
    private LincensePlateMapper lincensePlateMapper;

    @Autowired
    private JinshiParkSettingMapper jinshiParkSettingMapper;

    @Autowired
    private AdapayWxPubService adapayWxPubService;

    @Override
    public JinshiparkJSONResult noPlatePayExecutePayment(AdapayRequstVO adapayRequstVO) {
        //更新在场记录表的应付金额
        LincensePlateExample updateExample = new LincensePlateExample();
        LincensePlateExample.Criteria updateCriteria = updateExample.createCriteria();
        updateCriteria.andLpLincensePlateIdCarEqualTo(adapayRequstVO.getPlate());
        LincensePlate updateLincensePlate = new LincensePlate();
        updateLincensePlate.setLpParkingCost(adapayRequstVO.getPay_amt());
        updateLincensePlate.setLpDepartureCname(adapayRequstVO.getLpDepartureCname());
        lincensePlateMapper.updateByExampleSelective(updateLincensePlate, updateExample);
        //设置汇付需要的参数
        adapayRequstVO.setOrder_no(KeyUtils.getOrderIdByPlate(adapayRequstVO.getPlate(), adapayRequstVO.getParkId()));
        adapayRequstVO.setPay_amt(new DecimalFormat("0.00").format(Float.parseFloat(adapayRequstVO.getPay_amt())));
        adapayRequstVO.setParkId(adapayRequstVO.getParkId());
        return adapayWxPubService.wxPubExecutePayment(adapayRequstVO);
    }
}
