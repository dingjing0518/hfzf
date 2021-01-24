package com.jinshipark.hfzf.service.impl;

import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.model.LincensePlate;
import com.jinshipark.hfzf.model.LincensePlateExample;
import com.jinshipark.hfzf.model.vo.LincensePlateVO;
import com.jinshipark.hfzf.service.LincensePlateService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.utils.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public void updateLincensePlate(String order_no, String pay_channel, String pay_amt) {
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpOrderIdEqualTo(order_no);
        LincensePlate lincensePlate = new LincensePlate();
        lincensePlate.setLpOrderState("支付成功");//订单状态
        lincensePlate.setLpPaymentType("扫码支付出场");//支付方式
        lincensePlate.setLpParkingRealCost(pay_amt);//实付金额
        lincensePlateMapper.updateByExampleSelective(lincensePlate, example);
    }

    @Override
    public void updateLincensePlateForPrePay(String order_no, String pay_channel, String pay_amt) {
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpOrderIdEqualTo(order_no);
        LincensePlate lincensePlate = new LincensePlate();
        lincensePlate.setLpOrderState("支付成功");//订单状态
        lincensePlate.setLpPaymentType("预付款出场");//支付方式
        lincensePlate.setLpParkingRealCost(pay_amt);//实付金额
        lincensePlate.setLpParkingCost(pay_amt);//应付金额
        lincensePlateMapper.updateByExampleSelective(lincensePlate, example);
    }

    @Override
    public JinshiparkJSONResult getLincensePlateByPlate(LincensePlateVO lincensePlateVO) {
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpLincensePlateIdCarEqualTo(lincensePlateVO.getLpLincensePlateIdCar());
        List<LincensePlate> lincensePlateList = lincensePlateMapper.selectByExample(example);
        if (lincensePlateList.size() == 0) {
            return JinshiparkJSONResult.errorMsg("未查询到车辆");
        }
        return JinshiparkJSONResult.ok(lincensePlateList.get(0));
    }

    @Override
    public JinshiparkJSONResult saveLincensePlate(LincensePlateVO lincensePlateVO) {
        //判断是否重复入场
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpLincensePlateIdCarEqualTo(lincensePlateVO.getLpLincensePlateIdCar());
        List<LincensePlate> lincensePlates = lincensePlateMapper.selectByExample(example);
        if (lincensePlates.size() > 0) {
            return JinshiparkJSONResult.errorMsg("车牌：" + lincensePlateVO.getLpLincensePlateIdCar() + "已入场,请勿重复入场");
        }
        String orderId = KeyUtils.getOrderIdByPlate(lincensePlateVO.getLpLincensePlateIdCar(), lincensePlateVO.getLpParkingName());
        LincensePlate lincensePlate = new LincensePlate();
        lincensePlate.setLpLincensePlateIdCar(lincensePlateVO.getLpLincensePlateIdCar());//车牌号
        lincensePlate.setLpServiceTypeCar("");
        lincensePlate.setLpInboundTime(new Date());//入场时间
        lincensePlate.setLpCreateTime(new Date());//创建时间
        lincensePlate.setLpOrderId(orderId);//订单Id
        lincensePlate.setLpCarType(lincensePlateVO.getLpCarType());//区域名称
        lincensePlate.setLpLincenseType("0");//车辆类型 默认0
        lincensePlate.setLpInboundCname(lincensePlateVO.getLpInboundCname());//入场口名
        lincensePlate.setLpParkingName(lincensePlateVO.getLpParkingName());//停车场名
        lincensePlate.setLpAgentName(lincensePlateVO.getLpParkingName().substring(0, 6));//代理商名
        lincensePlate.setLpOrderState("未付款");//订单状态
        lincensePlate.setLpLgId(0);//车牌组id 默认0
        lincensePlate.setLpLgType(0);//车牌收费类型 默认0
        int result = lincensePlateMapper.insertSelective(lincensePlate);
        if (result > 0) {
            //todo 修改摄像机表标志位抬杆
            return JinshiparkJSONResult.ok("入场成功");
        }
        return JinshiparkJSONResult.errorMsg("系统异常");
    }
}
