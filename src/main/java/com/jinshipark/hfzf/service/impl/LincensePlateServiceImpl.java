package com.jinshipark.hfzf.service.impl;

import com.jinshipark.hfzf.mapper.JinshiParkSettingMapper;
import com.jinshipark.hfzf.mapper.JinshiparkCamerasMapper;
import com.jinshipark.hfzf.mapper.LincensePlateHistoryMapper;
import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.mapper2.JinshiparkApakeyMapper;
import com.jinshipark.hfzf.model.*;
import com.jinshipark.hfzf.model.vo.LincensePlateVO;
import com.jinshipark.hfzf.service.LincensePlateService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.utils.KeyUtils;
import com.jinshipark.hfzf.utils.PayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
    @Autowired
    private JinshiParkSettingMapper jinshiParkSettingMapper;

    @Autowired
    private JinshiparkApakeyMapper jinshiparkApakeyMapper;

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
    public void updateLincensePlate(String order_no, String pay_channel, String pay_amt, String paymentId, String adaorderid) {
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpOrderIdEqualTo(order_no);
        LincensePlate lincensePlate = new LincensePlate();
        lincensePlate.setLpOrderState("支付成功");//订单状态
        lincensePlate.setLpPaymentType("扫码支付出场");//支付方式
        lincensePlate.setLpParkingRealCost(pay_amt);//实付金额
        lincensePlate.setPaymentid(paymentId);
        lincensePlate.setAdaorderid(adaorderid);
        logger.error("===扫码支付回调参数===");
        logger.error("订单号:{},支付金额:{}元", order_no, pay_amt);
        int result = lincensePlateMapper.updateByExampleSelective(lincensePlate, example);
        if (result > 0) {
            logger.error("===更新成功订单号:{}成功===", order_no);
        } else {
            logger.error("===更新成功订单号:{}失败===", order_no);
        }
    }

    @Override
    public void updateLincensePlateForPrePay(String order_no, String pay_channel, String pay_amt, String paymentId, String adaorderid) {
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpOrderIdEqualTo(order_no);
        LincensePlate lincensePlate = new LincensePlate();
        lincensePlate.setLpOrderState("支付成功");//订单状态
        lincensePlate.setLpPaymentType("预付款出场");//支付方式
        lincensePlate.setLpParkingRealCost(pay_amt);//实付金额
        lincensePlate.setPaymentid(paymentId);
        lincensePlate.setAdaorderid(adaorderid);
        logger.error("===预支付回调参数===");
        logger.error("订单号:{},支付金额:{}元", order_no, pay_amt);
        int result = lincensePlateMapper.updateByExampleSelective(lincensePlate, example);
        if (result > 0) {
            logger.error("===更新成功订单号:{}成功===", order_no);
        } else {
            logger.error("===更新成功订单号:{}失败===", order_no);
        }
    }

    @Override
    public void updateLincensePlateForNoPlate(String order_no, String pay_channel, String pay_amt, String paymentId, String adaorderid) {
        //1.更新在场记录表数据
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpOrderIdEqualTo(order_no);
        LincensePlate lincensePlate = new LincensePlate();
        lincensePlate.setLpOrderState("支付成功");//订单状态
        lincensePlate.setLpPaymentType("扫码支付出场");//支付方式
        lincensePlate.setLpParkingRealCost(pay_amt);//实付金额
        lincensePlate.setLpDepartureTime(new Date());//离场时间
        lincensePlate.setPaymentid(paymentId);
        lincensePlate.setAdaorderid(adaorderid);
        logger.error("===无牌车支付回调参数===");
        logger.error("订单号:{},支付金额:{}元", order_no, pay_amt);
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
        exampleCriteria.andParkidEqualTo(lp.getLpParkingName());//车场名称

        List<JinshiparkCameras> list = jinshiparkCamerasMapper.selectByExample(camerasExample);
        if (list.size() > 0) {
            JinshiparkCameras updateRecord = new JinshiparkCameras();
            updateRecord.setStatus("0");
            updateRecord.setCreatetime(new Date());
            int update = jinshiparkCamerasMapper.updateByExampleSelective(updateRecord, camerasExample);
            if (update < 1) {
                logger.error("===更新===");
                logger.error("===车牌：{}出场抬杆失败===", lp.getLpLincensePlateIdCar());
            }
        } else {
            JinshiparkCameras insertRecord = new JinshiparkCameras();
            insertRecord.setCameraid(lp.getLpDepartureCname());
            insertRecord.setParkid(lp.getLpParkingName());
            insertRecord.setCreatetime(new Date());
            insertRecord.setStatus("0");
            insertRecord.setInorout("出口");
            int insert = jinshiparkCamerasMapper.insertSelective(insertRecord);
            if (insert < 1) {
                logger.error("===新增===");
                logger.error("===车牌：{}出场抬杆失败===", lp.getLpLincensePlateIdCar());
            }
        }

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
    public JinshiparkJSONResult getLincensePlateByNoPlate(LincensePlateVO lincensePlateVO) {
        //根据车牌查询在场记录表
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpLincensePlateIdCarEqualTo(lincensePlateVO.getLpLincensePlateIdCar());
        List<LincensePlate> lincensePlateList = lincensePlateMapper.selectByExample(example);
        //是否为在场车辆
        if (lincensePlateList.size() == 0) {
            return JinshiparkJSONResult.errorMsg("未查询到车辆");
        }

        LincensePlate lincensePlate = lincensePlateList.get(0);
        LincensePlate lincense = new LincensePlate();
        //判断是否在该区域内
        if (!lincense.getLpParkingName().equals(lincensePlateVO.getLpParkingName()) || !lincense.getLpCarType().equals(lincensePlateVO.getLpCarType())) {
            return JinshiparkJSONResult.errorMsg("车辆不在该区域内");
        }
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
        //免费时间之内
        if (dateOften <= jinshiParkSettings.get(0).getJpsFreeTime()) {
            lincense.setLpDepartureTime(new Date());
            lincense.setLpParkingOften(String.valueOf(dateOften));
            lincense.setLpParkingCost("0");
            return JinshiparkJSONResult.ok(lincense);
        }
        Date tempDate = new Date();
        Double rent = PayUtils.getRent(tempDate, lincense.getLpInboundTime(), jinshiParkSettings.get(0));
        lincense.setLpDepartureTime(new Date());
        lincense.setLpParkingOften(String.valueOf(dateOften));
        lincense.setLpParkingCost(new DecimalFormat("0").format(rent));
        return JinshiparkJSONResult.ok(lincense);
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
            //1.根据入场口名和车场名称查询摄像机表是否存在
            JinshiparkCamerasExample camerasExample = new JinshiparkCamerasExample();
            JinshiparkCamerasExample.Criteria exampleCriteria = camerasExample.createCriteria();
            exampleCriteria.andCameraidEqualTo(lincensePlateVO.getLpInboundCname());//入场口名
            exampleCriteria.andParkidEqualTo(lincensePlateVO.getLpParkingName());//车场名称
            List<JinshiparkCameras> list = jinshiparkCamerasMapper.selectByExample(camerasExample);
            if (list.size() > 0) {
                JinshiparkCameras updateRecord = new JinshiparkCameras();
                updateRecord.setStatus("0");
                updateRecord.setCreatetime(new Date());
                int update = jinshiparkCamerasMapper.updateByExampleSelective(updateRecord, camerasExample);
                if (update < 1) {
                    return JinshiparkJSONResult.errorMsg("系统异常");
                }

            } else {
                JinshiparkCameras insertRecord = new JinshiparkCameras();
                insertRecord.setCameraid(lincensePlateVO.getLpInboundCname());
                insertRecord.setParkid(lincensePlateVO.getLpParkingName());
                insertRecord.setCreatetime(new Date());
                insertRecord.setStatus("0");
                insertRecord.setInorout("进口");
                int insert = jinshiparkCamerasMapper.insertSelective(insertRecord);
                if (insert < 1) {
                    return JinshiparkJSONResult.errorMsg("系统异常");
                }
            }
            return JinshiparkJSONResult.ok("入场成功");

        }
        return JinshiparkJSONResult.errorMsg("系统异常");
    }

    @Override
    public JinshiparkJSONResult getLincensePlateInfo(LincensePlateVO lincensePlateVO) {
        LincensePlateExample example = new LincensePlateExample();
        LincensePlateExample.Criteria criteria = example.createCriteria();
        criteria.andLpLincensePlateIdCarEqualTo(lincensePlateVO.getLpLincensePlateIdCar());
        List<LincensePlate> lincensePlates = lincensePlateMapper.selectByExample(example);

        LincensePlate lincensePlate = lincensePlates.get(0);

        JinshiparkApakeyExample jinshiparkApakeyExample = new JinshiparkApakeyExample();
        JinshiparkApakeyExample.Criteria jinshiparkApakeyExampleCriteria = jinshiparkApakeyExample.createCriteria();
        jinshiparkApakeyExampleCriteria.andParkidEqualTo(lincensePlate.getLpParkingName());
        List<JinshiparkApakey> jinshiparkApakeys = jinshiparkApakeyMapper.selectByExample(jinshiparkApakeyExample);

        BeanUtils.copyProperties(lincensePlate, lincensePlateVO);
        lincensePlateVO.setParkName(jinshiparkApakeys.get(0).getParkname());
        return JinshiparkJSONResult.ok(lincensePlateVO);
    }
}
