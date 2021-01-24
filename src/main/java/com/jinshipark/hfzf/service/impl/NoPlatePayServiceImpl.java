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
        Integer dateOften = getDateOften(new Date(), lincense.getLpInboundTime());
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
        Double rent = getRent(tempDate, lincense.getLpInboundTime(), jinshiParkSettings.get(0));
        String rentStr = new DecimalFormat("0.00").format(rent);
        //更新在场记录表的应付金额
        LincensePlateExample updateExample = new LincensePlateExample();
        LincensePlateExample.Criteria updateCriteria = example.createCriteria();
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

    public static Integer getDateOften(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;

        long resMin = diff / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return Math.toIntExact(resMin);
    }

    public Double getRent(Date endDate, Date nowDate, JinshiParkSetting jinshiParkSetting) {
        if (endDate == null) {
            return 0.0;
        }
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
//        long day = diff / nd;
//        // 计算差多少小时
//        long hour = diff % nd / nh;
//        // 计算差多少分钟
//        long min = diff % nd % nh / nm;
//        // 计算差多少秒//输出结果
//        long sec = diff % nd % nh % nm / ns;
        //总分钟数
        long allMin = diff / nm;
        double allDayMin = 1440;
        double dayCharge = 0;
//        double res = 0;
        double spareMin = allMin % allDayMin;
        if (allMin > allDayMin) {
            dayCharge = Math.floor(allMin / allDayMin) * jinshiParkSetting.getJpsAlldayLimit();
        }
        if (spareMin < jinshiParkSetting.getJpsFreeTime()) {
            return dayCharge;
        }
        if (spareMin <= jinshiParkSetting.getJpsFirstTime()) {
            return dayCharge + Double.valueOf(jinshiParkSetting.getJpsFirstCharge());
        } else {
            double sumTemp = Math.floor((spareMin - jinshiParkSetting.getJpsFirstTime()) / jinshiParkSetting.getJpsFollowTime()) + 1; //sumTemp是否能够取整数
            double nowCharge = sumTemp * jinshiParkSetting.getJpsFollowCharge() + jinshiParkSetting.getJpsFirstCharge();
            if (nowCharge > jinshiParkSetting.getJpsAlldayLimit()) {
                nowCharge = jinshiParkSetting.getJpsAlldayLimit();
            }   //当天费用大于20时取20
            return dayCharge + nowCharge;//之前天数的费用加上当天费用
        }
    }
}
