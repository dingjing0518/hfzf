package com.jinshipark.hfzf.service.impl;

import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.model.LincensePlate;
import com.jinshipark.hfzf.model.LincensePlateExample;
import com.jinshipark.hfzf.service.AdapayWxPubService;
import com.jinshipark.hfzf.service.PrePayService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrePayServiceImpl implements PrePayService {
    @Autowired
    private AdapayWxPubService adapayWxPubService;
    @Autowired
    private LincensePlateMapper lincensePlateMapper;

    @Override
    public JinshiparkJSONResult prePayExecutePayment(AdapayRequstVO adapayRequstVO) {
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpLincensePlateIdCarEqualTo(adapayRequstVO.getPlate());
        List<LincensePlate> lincensePlateList = lincensePlateMapper.selectByExample(example);
        if (lincensePlateList.size() == 0) {
            return JinshiparkJSONResult.errorMsg("未查询到车辆");
        }
        //todo 计算停车费
        adapayRequstVO.setOrder_no(lincensePlateList.get(0).getLpOrderId());
        adapayRequstVO.setPay_amt("0.01");
        return adapayWxPubService.wxPubExecutePayment(adapayRequstVO);
    }
}
