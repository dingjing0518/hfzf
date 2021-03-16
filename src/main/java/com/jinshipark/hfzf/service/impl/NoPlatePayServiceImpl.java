package com.jinshipark.hfzf.service.impl;

import com.jinshipark.hfzf.mapper.JinshiparkCamerasMapper;
import com.jinshipark.hfzf.mapper.LincensePlateHistoryMapper;
import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.model.*;
import com.jinshipark.hfzf.service.AdapayWxPubService;
import com.jinshipark.hfzf.service.NoPlatePayService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.utils.KeyUtils;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Service
public class NoPlatePayServiceImpl implements NoPlatePayService {
    public static final Logger logger = LoggerFactory.getLogger(NoPlatePayServiceImpl.class);
    @Autowired
    private LincensePlateMapper lincensePlateMapper;

    @Autowired
    private JinshiparkCamerasMapper jinshiparkCamerasMapper;

    @Autowired
    private LincensePlateHistoryMapper lincensePlateHistoryMapper;

    @Autowired
    private AdapayWxPubService adapayWxPubService;

    @Override
    public JinshiparkJSONResult noPlatePayExecutePayment(AdapayRequstVO adapayRequstVO) {
        logger.error("无牌车应付金额:{}元", adapayRequstVO.getPay_amt());
        logger.error("结果：{}", adapayRequstVO.getPay_amt().equals("0"));
        if (adapayRequstVO.getPay_amt().equals("0")) {
            //无牌车应付金额为0的情况
            String orderId = KeyUtils.getOrderIdByPlate(adapayRequstVO.getPlate(), adapayRequstVO.getParkId());
            LincensePlateExample lincensePlateExample = new LincensePlateExample();
            LincensePlateExample.Criteria lincensePlateExampleCriteria = lincensePlateExample.createCriteria();
            lincensePlateExampleCriteria.andLpLincensePlateIdCarEqualTo(adapayRequstVO.getPlate());
            LincensePlate lincensePlate = new LincensePlate();
            lincensePlate.setLpOrderId(orderId);
            lincensePlate.setLpOrderState("支付成功");//订单状态
            lincensePlate.setLpPaymentType("扫码支付出场");//支付方式
            lincensePlate.setLpParkingRealCost("0");//实付金额
            lincensePlate.setLpDepartureTime(new Date());//离场时间
            lincensePlate.setLpDepartureCname(adapayRequstVO.getLpDepartureCname());//出场口
            int result = lincensePlateMapper.updateByExampleSelective(lincensePlate, lincensePlateExample);
            if (result > 0) {
                logger.error("===更新成功车牌：{}成功===", adapayRequstVO.getPlate());
            }
            List<LincensePlate> lincensePlateList = lincensePlateMapper.selectByExample(lincensePlateExample);
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
                    logger.error("===车牌：{}出场抬杆失败===", adapayRequstVO.getPlate());
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
                    logger.error("===车牌：{}出场抬杆失败===", adapayRequstVO.getPlate());
                }
            }
            //3.移动在场记录表里数据到在场历史表里
            LincensePlateHistory lincensePlateHistory = new LincensePlateHistory();
            BeanUtils.copyProperties(lp, lincensePlateHistory);
            lincensePlateHistory.setLpId(null);
            int count = lincensePlateHistoryMapper.insertSelective(lincensePlateHistory);
            if (count > 0) {
                lincensePlateMapper.deleteByExample(lincensePlateExample);
            }
            return JinshiparkJSONResult.errorMsg("支付成功");
        } else {
            //更新在场记录表的应付金额
            LincensePlateExample updateExample = new LincensePlateExample();
            LincensePlateExample.Criteria updateCriteria = updateExample.createCriteria();
            updateCriteria.andLpLincensePlateIdCarEqualTo(adapayRequstVO.getPlate());
            LincensePlate updateLincensePlate = new LincensePlate();
//        updateLincensePlate.setLpParkingCost(adapayRequstVO.getPay_amt());
            updateLincensePlate.setLpDepartureCname(adapayRequstVO.getLpDepartureCname());
            lincensePlateMapper.updateByExampleSelective(updateLincensePlate, updateExample);
            //设置汇付需要的参数
            adapayRequstVO.setOrder_no(KeyUtils.getOrderIdByPlate(adapayRequstVO.getPlate(), adapayRequstVO.getParkId()));
            adapayRequstVO.setPay_amt(new DecimalFormat("0.00").format(Float.parseFloat(adapayRequstVO.getPay_amt())));
            adapayRequstVO.setParkId(adapayRequstVO.getParkId());
            return adapayWxPubService.wxPubExecutePayment(adapayRequstVO);
        }
    }
}
