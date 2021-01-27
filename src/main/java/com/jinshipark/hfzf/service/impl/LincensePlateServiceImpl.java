package com.jinshipark.hfzf.service.impl;

import com.jinshipark.hfzf.mapper.JinshiparkCamerasMapper;
import com.jinshipark.hfzf.mapper.LincensePlateHistoryMapper;
import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.model.*;
import com.jinshipark.hfzf.model.vo.LincensePlateVO;
import com.jinshipark.hfzf.service.LincensePlateService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.utils.KeyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LincensePlateServiceImpl implements LincensePlateService {
    public static final Logger logger = LoggerFactory.getLogger(LincensePlateServiceImpl.class);
    @Autowired
    private LincensePlateMapper lincensePlateMapper;
    @Autowired
    private JinshiparkCamerasMapper jinshiparkCamerasMapper;
    @Autowired
    private LincensePlateHistoryMapper lincensePlateHistoryMapper;

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
        logger.error("===扫码支付回调参数===");
        logger.error("订单号:{}", "支付金额:{}元", order_no, pay_amt);
        int result = lincensePlateMapper.updateByExampleSelective(lincensePlate, example);
        if (result > 0) {
            logger.error("===更新成功订单号:{}成功===", order_no);
        } else {
            logger.error("===更新成功订单号:{}失败===", order_no);
        }
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
        logger.error("===预支付回调参数===");
        logger.error("订单号:{}", "支付金额:{}元", order_no, pay_amt);
        int result = lincensePlateMapper.updateByExampleSelective(lincensePlate, example);
        if (result > 0) {
            logger.error("===更新成功订单号:{}成功===", order_no);
        } else {
            logger.error("===更新成功订单号:{}失败===", order_no);
        }
    }

    @Override
    public void updateLincensePlateForNoPlate(String order_no, String pay_channel, String pay_amt) {
        //1.更新在场记录表数据
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpOrderIdEqualTo(order_no);
        LincensePlate lincensePlate = new LincensePlate();
        lincensePlate.setLpOrderState("支付成功");//订单状态
        lincensePlate.setLpPaymentType("扫码支付出场");//支付方式
        lincensePlate.setLpParkingRealCost(pay_amt);//实付金额
        lincensePlate.setLpParkingCost(pay_amt);//应付金额
        logger.error("===无牌车支付回调参数===");
        logger.error("订单号:{}", "支付金额:{}元", order_no, pay_amt);
        int result = lincensePlateMapper.updateByExampleSelective(lincensePlate, example);
        if (result > 0) {
            logger.error("===更新成功订单号:{}成功===", order_no);
        } else {
            logger.error("===更新成功订单号:{}失败===", order_no);
        }
        List<LincensePlate> lincensePlateList = lincensePlateMapper.selectByExample(example);
        LincensePlate lp = lincensePlateList.get(0);
        //2.抬杆
        JinshiparkCamerasExample camerasExample = new JinshiparkCamerasExample();
        JinshiparkCamerasExample.Criteria exampleCriteria = camerasExample.createCriteria();
        exampleCriteria.andCameraidEqualTo(lp.getLpDepartureCname());//出场口名
        exampleCriteria.andAreanameEqualTo(lp.getLpCarType());//区域名称
        JinshiparkCameras jinshiparkCameras = new JinshiparkCameras();
        jinshiparkCameras.setStatus("0");
        jinshiparkCamerasMapper.updateByExampleSelective(jinshiparkCameras, camerasExample);

        //3.移动在场记录表里数据到在场历史表里
        LincensePlateHistory lincensePlateHistory = new LincensePlateHistory();
        BeanUtils.copyProperties(lp, lincensePlateHistory);
        lincensePlateHistory.setLpId(null);
        int count = lincensePlateHistoryMapper.insertSelective(lincensePlateHistory);
        if (count > 0) {
            lincensePlateMapper.deleteByExample(example);
        }
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
            //修改摄像机表标志位抬杆
            JinshiparkCamerasExample camerasExample = new JinshiparkCamerasExample();
            JinshiparkCamerasExample.Criteria exampleCriteria = camerasExample.createCriteria();
            exampleCriteria.andCameraidEqualTo(lincensePlateVO.getLpInboundCname());//入场口名
            exampleCriteria.andAreanameEqualTo(lincensePlateVO.getLpCarType());//区域名称
            JinshiparkCameras jinshiparkCameras = new JinshiparkCameras();
            jinshiparkCameras.setStatus("0");
            int count = jinshiparkCamerasMapper.updateByExampleSelective(jinshiparkCameras, camerasExample);
            if (count > 0) {
                return JinshiparkJSONResult.ok("入场成功");
            } else {
                return JinshiparkJSONResult.ok("系统异常");
            }
        }
        return JinshiparkJSONResult.errorMsg("系统异常");
    }
}
