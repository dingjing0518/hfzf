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
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpLincensePlateIdCarEqualTo(adapayRequstVO.getPlate());
        List<LincensePlate> lincensePlateList = lincensePlateMapper.selectByExample(example);
        //第一步：是否为在场车辆
        if (lincensePlateList.size() == 0) {
            return JinshiparkJSONResult.errorMsg("未查询到车辆");
        }
        LincensePlate lincensePlate = lincensePlateList.get(0);
        LincensePlate lincense = new LincensePlate();

        BeanUtils.copyProperties(lincensePlate, lincense);
        Integer dateOften = PayUtils.getDateOften(new Date(), lincense.getLpInboundTime());
        String lpParkingName = lincense.getLpParkingName();

        String lpLincenseTypeStr = lincense.getLpLincenseType();
        Integer lpLincenseType = null;
        if (lpLincenseTypeStr == null || lpLincenseTypeStr.equals("")) {
            lpLincenseType = 0;
        } else {
            lpLincenseType = Integer.valueOf(lpLincenseTypeStr);
        }
        JinshiParkSettingExample jinshiParkSettingExample = new JinshiParkSettingExample();
        JinshiParkSettingExample.Criteria settingExampleCriteria = jinshiParkSettingExample.createCriteria();
        settingExampleCriteria.andJpsParkIdEqualTo(lpParkingName);
        settingExampleCriteria.andJpsCarTypeEqualTo(lpLincenseType);
        List<JinshiParkSetting> jinshiParkSettings = jinshiParkSettingMapper.selectByExample(jinshiParkSettingExample);
        //判断是否在免费时间之内
        if (dateOften <= jinshiParkSettings.get(0).getJpsFreeTime()) {
            return JinshiparkJSONResult.errorMsg("车牌为：" + lincensePlate.getLpLincensePlateIdCar() + "的用户您好，您还在免费时长之内哦~");
        }
        Date tempDate = new Date();
        Double rent = PayUtils.getRent(tempDate, lincense.getLpInboundTime(), jinshiParkSettings.get(0));
        String rentStr = new DecimalFormat("0.00").format(rent);
        //更新在场记录表的应付金额
        LincensePlateExample updateExample = new LincensePlateExample();
        LincensePlateExample.Criteria updateCriteria = updateExample.createCriteria();
        updateCriteria.andLpLincensePlateIdCarEqualTo(lincensePlate.getLpLincensePlateIdCar());
        LincensePlate updateLincensePlate = new LincensePlate();
        updateLincensePlate.setLpParkingCost(rentStr);
        updateLincensePlate.setLpDepartureCname(adapayRequstVO.getLpDepartureCname());
        lincensePlateMapper.updateByExampleSelective(updateLincensePlate, updateExample);
        //设置汇付需要的参数
        adapayRequstVO.setOrder_no(KeyUtils.getOrderIdByPlate(adapayRequstVO.getPlate(), adapayRequstVO.getParkId()));
        adapayRequstVO.setPay_amt(rentStr);
        adapayRequstVO.setParkId(lincense.getLpParkingName());
        return adapayWxPubService.wxPubExecutePayment(adapayRequstVO);
    }
}
