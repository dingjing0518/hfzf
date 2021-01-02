package com.jinshipark.hfzf.service.impl;

import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.model.LincensePlate;
import com.jinshipark.hfzf.model.LincensePlateExample;
import com.jinshipark.hfzf.model.vo.LincensePlateVO;
import com.jinshipark.hfzf.service.LincensePlateService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LincensePlateServiceImpl implements LincensePlateService {
    @Autowired
    private LincensePlateMapper lincensePlateMapper;

    @Override
    public JinshiparkJSONResult getLincensePlate(LincensePlateVO lincensePlateVO) {
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpDepartureCnameEqualTo(lincensePlateVO.getLpDepartureCname());
        criteria.andLpParkingNameEqualTo(lincensePlateVO.getLpParkingName());
        criteria.andLpOrderStateEqualTo("待支付");
        List<LincensePlate> lincensePlateList = lincensePlateMapper.selectByExample(example);
        if (lincensePlateList.size() == 0) {
            return JinshiparkJSONResult.errorMsg("此出口未查询到车辆");
        }
        return JinshiparkJSONResult.ok(lincensePlateList.get(0));
    }
}
