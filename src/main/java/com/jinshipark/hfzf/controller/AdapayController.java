package com.jinshipark.hfzf.controller;

import com.alibaba.fastjson.JSONObject;
import com.huifu.adapay.Adapay;
import com.huifu.adapay.core.AdapayCore;
import com.huifu.adapay.core.exception.BaseAdaPayException;
import com.huifu.adapay.core.util.AdapaySign;
import com.huifu.adapay.model.MerConfig;
import com.huifu.adapay.model.Refund;
import com.jinshipark.hfzf.config.ADAPayPropertyConfig;
import com.jinshipark.hfzf.mapper.LincensePlateHistoryMapper;
import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.mapper2.JinshiparkApakeyMapper;
import com.jinshipark.hfzf.model.*;
import com.jinshipark.hfzf.model.vo.JinshiparkApakeyVO;
import com.jinshipark.hfzf.service.*;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 汇付天下相关控制类
 */
@Controller
@RequestMapping("/adapay")
public class AdapayController {

    public static final Logger logger = LoggerFactory.getLogger(AdapayController.class);
    @Autowired
    private AdapayAliPayService adapayAliPayService;
    @Autowired
    private AdapayWxPubService adapayWxPubService;
    @Autowired
    private LincensePlateService lincensePlateService;

    @Autowired
    private PrePayService prePayService;

    @Autowired
    private NoPlatePayService noPlatePayService;
    @Autowired
    private JinshiparkApakeyMapper jinshiparkApakeyMapper;

    @Autowired
    private LincensePlateMapper lincensePlateMapper;

    @Autowired
    private LincensePlateHistoryMapper lincensePlateHistoryMapper;

    /**
     * 支付宝APP支付
     *
     * @param adapayRequstVO 请求参数实体
     * @return 处理结果
     */
    @CrossOrigin
    @RequestMapping(value = "/alipayExecutePayment", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult alipayExecutePayment(@RequestBody AdapayRequstVO adapayRequstVO) {
        adapayRequstVO.setNotify_url(ADAPayPropertyConfig.getStrValueByKey("notify_url"));
        return adapayAliPayService.alipayExecutePayment(adapayRequstVO);
    }

    /**
     * 微信公众号支付
     *
     * @param adapayRequstVO 请求参数实体
     * @return 处理结果
     */
    @CrossOrigin
    @RequestMapping(value = "/wxPubExecutePayment", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult wxPubExecutePayment(@RequestBody AdapayRequstVO adapayRequstVO) {
        adapayRequstVO.setNotify_url(ADAPayPropertyConfig.getStrValueByKey("notify_url"));
        return adapayWxPubService.wxPubExecutePayment(adapayRequstVO);
    }

    /**
     * 预支付接口
     *
     * @param adapayRequstVO 请求参数实体
     * @return 处理结果
     * @throws ParseException 异常
     */
    @CrossOrigin
    @RequestMapping(value = "/prePayExecutePayment", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult prePayExecutePayment(@RequestBody AdapayRequstVO adapayRequstVO) throws ParseException {
        adapayRequstVO.setNotify_url(ADAPayPropertyConfig.getStrValueByKey("pre_notify_url"));
        return prePayService.prePayExecutePayment(adapayRequstVO);
    }

    /**
     * 无牌车支付接口
     *
     * @param adapayRequstVO 请求参数实体
     * @return 处理结果
     */
    @CrossOrigin
    @RequestMapping(value = "/noPlatePayExecutePayment", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult noPlatePayExecutePayment(@RequestBody AdapayRequstVO adapayRequstVO) {
        adapayRequstVO.setNotify_url(ADAPayPropertyConfig.getStrValueByKey("no_notify_url"));
        return noPlatePayService.noPlatePayExecutePayment(adapayRequstVO);
    }

    /**
     * 汇付支付回调
     *
     * @param request 请求
     */
    @PostMapping("/callback")
    public void callback(HttpServletRequest request) {
        try {
            //验签请参data
            String data = request.getParameter("data");
            //验签请参sign
            String sign = request.getParameter("sign");
            //验签标记
            boolean checkSign;
            //验签请参publicKey
            String publicKey = AdapayCore.PUBLIC_KEY;
            logger.error("验签请参：data={},sign={}", data, sign);
            //验签
            checkSign = AdapaySign.verifySign(data, sign, publicKey);
            if (checkSign) {
                //验签成功逻辑
                JSONObject jsonObject = JSONObject.parseObject(data);
                String order_no = jsonObject.getString("order_no");
                String pay_channel = jsonObject.getString("pay_channel");
                String pay_amt = jsonObject.getString("pay_amt");
                String paymentId = jsonObject.getString("id");
                String status = jsonObject.getString("status");
                String adaorderid = jsonObject.getString("party_order_id");
                if (status.equals("succeeded")) {
                    lincensePlateService.updateLincensePlate(order_no, pay_channel, pay_amt, paymentId, adaorderid);
                }

            }
        } catch (Exception e) {
            logger.error("异步回调异常，Exception：{}", e.getMessage());
        }
    }

    /**
     * 汇付预支付回调
     *
     * @param request 请求
     */
    @PostMapping("/preCallback")
    public void preCallback(HttpServletRequest request) {
        try {
            //验签请参data
            String data = request.getParameter("data");
            //验签请参sign
            String sign = request.getParameter("sign");
            //验签标记
            boolean checkSign;
            //验签请参publicKey
            String publicKey = AdapayCore.PUBLIC_KEY;
            logger.error("验签请参：data={},sign={}", data, sign);
            //验签
            checkSign = AdapaySign.verifySign(data, sign, publicKey);
            if (checkSign) {
                //验签成功逻辑
                JSONObject jsonObject = JSONObject.parseObject(data);
                String order_no = jsonObject.getString("order_no");
                String pay_channel = jsonObject.getString("pay_channel");
                String pay_amt = jsonObject.getString("pay_amt");
                String paymentId = jsonObject.getString("id");
                String status = jsonObject.getString("status");
                String adaorderid = jsonObject.getString("party_order_id");
                if (status.equals("succeeded")) {
                    lincensePlateService.updateLincensePlateForPrePay(order_no, pay_channel, pay_amt, paymentId,adaorderid);
                }
            }
        } catch (Exception e) {
            logger.error("异步回调异常，Exception：{}", e.getMessage());
        }
    }

    /**
     * 无牌车支付回调
     *
     * @param request 请求
     */
    @PostMapping("/noCallback")
    public void noCallback(HttpServletRequest request) {
        try {
            //验签请参data
            String data = request.getParameter("data");
            //验签请参sign
            String sign = request.getParameter("sign");
            //验签标记
            boolean checkSign;
            //验签请参publicKey
            String publicKey = AdapayCore.PUBLIC_KEY;
            logger.error("验签请参：data={},sign={}", data, sign);
            //验签
            checkSign = AdapaySign.verifySign(data, sign, publicKey);
            if (checkSign) {
                //验签成功逻辑
                JSONObject jsonObject = JSONObject.parseObject(data);
                String order_no = jsonObject.getString("order_no");
                String pay_channel = jsonObject.getString("pay_channel");
                String pay_amt = jsonObject.getString("pay_amt");
                String paymentId = jsonObject.getString("id");
                String status = jsonObject.getString("status");
                String adaorderid = jsonObject.getString("party_order_id");
                if (status.equals("succeeded")) {
                    lincensePlateService.updateLincensePlateForNoPlate(order_no, pay_channel, pay_amt, paymentId, adaorderid);
                }
            }
        } catch (Exception e) {
            logger.error("异步回调异常，Exception：{}", e.getMessage());
        }
    }

    /**
     * 添加商户配置
     */
    @CrossOrigin
    @RequestMapping(value = "/addMerConfig", method = RequestMethod.GET)
    @ResponseBody
    public JinshiparkJSONResult addMerConfig(@RequestParam(value = "parkId") String parkId) {
        //判断parkId是否为空
        if (StringUtils.isBlank(parkId)) {
            return JinshiparkJSONResult.errorMsg("parkId不能为空");
        }
        List<JinshiparkApakey> jinshiparkApakeys = getJinshiparkApakeys(parkId);
        //判断是有存在要配置得记录
        if (jinshiparkApakeys.size() == 0) {
            return JinshiparkJSONResult.errorMsg("不存在该商户配置");
        }
        //判断需要配置得记录得参数是否正确
        JinshiparkApakey jinshiparkApakey = jinshiparkApakeys.get(0);
        if (jinshiparkApakey.getParkid() == null || jinshiparkApakey.getParkid().equals("")
                || jinshiparkApakey.getAppid() == null || jinshiparkApakey.getAppid().equals("")
                || jinshiparkApakey.getRsaprivatekey() == null || jinshiparkApakey.getRsaprivatekey().equals("")
                || jinshiparkApakey.getApikeylive() == null || jinshiparkApakey.getApikeylive().equals("")
                || jinshiparkApakey.getApikeytest() == null || jinshiparkApakey.getApikeytest().equals("")) {

            return JinshiparkJSONResult.errorMsg("商户参数配置不正确");
        }
        //判断商户配置是否已经初始化过
        MerConfig config = Adapay.getConfig(jinshiparkApakey.getParkid());
        if (config != null) {
            return JinshiparkJSONResult.errorMsg("商户已配置，请勿重复配置！");
        }
        MerConfig merConfig = new MerConfig();
        merConfig.setApiKey(jinshiparkApakey.getApikeylive());
        merConfig.setApiMockKey(jinshiparkApakey.getApikeytest());
        merConfig.setRSAPrivateKey(jinshiparkApakey.getRsaprivatekey());
        try {
            Adapay.addMerConfig(merConfig, jinshiparkApakey.getParkid());
        } catch (Exception e) {
            return JinshiparkJSONResult.errorMsg("增加商户配置异常");
        }
        return JinshiparkJSONResult.ok();
    }

    @CrossOrigin
    @RequestMapping(value = "/addJinshiparkApakey", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult addJinshiparkApakey(@RequestBody JinshiparkApakeyVO jinshiparkApakeyVO) {
        if (StringUtils.isBlank(jinshiparkApakeyVO.getParkId())
                || StringUtils.isBlank(jinshiparkApakeyVO.getParkName())
                || StringUtils.isBlank(jinshiparkApakeyVO.getAppId())
                || StringUtils.isBlank(jinshiparkApakeyVO.getApiKeyLive())
                || StringUtils.isBlank(jinshiparkApakeyVO.getApiKeyTest())
                || StringUtils.isBlank(jinshiparkApakeyVO.getRsaPrivateKey())) {
            return JinshiparkJSONResult.errorMsg("参数不能为空");
        }
        JinshiparkApakey jinshiparkApakey = new JinshiparkApakey();
        jinshiparkApakey.setParkid(jinshiparkApakeyVO.getParkId());
        jinshiparkApakey.setParkname(jinshiparkApakeyVO.getParkName());
        jinshiparkApakey.setAppid(jinshiparkApakeyVO.getAppId());
        jinshiparkApakey.setApikeylive(jinshiparkApakeyVO.getApiKeyLive());
        jinshiparkApakey.setApikeytest(jinshiparkApakeyVO.getApiKeyTest());
        jinshiparkApakey.setRsaprivatekey(jinshiparkApakeyVO.getRsaPrivateKey());
        jinshiparkApakey.setRemarks(jinshiparkApakeyVO.getRemarks());
        int result = jinshiparkApakeyMapper.insert(jinshiparkApakey);
        if (result < 1) {
            return JinshiparkJSONResult.errorMsg("新增失败！");
        }
        return JinshiparkJSONResult.ok();
    }

    /**
     * 退款接口
     */
    @CrossOrigin
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult refund(@RequestBody AdapayRequstVO adapayRequstVO) {
        if (StringUtils.isBlank(adapayRequstVO.getOrder_no())) {
            return JinshiparkJSONResult.errorMsg("参数不能为空");
        }
        String realCost = adapayRequstVO.getPay_amt();
        LincensePlateExample lincensePlateExample = new LincensePlateExample();
        LincensePlateExample.Criteria lincensePlateExampleCriteria = lincensePlateExample.createCriteria();
        lincensePlateExampleCriteria.andLpOrderIdEqualTo(adapayRequstVO.getOrder_no());
        List<LincensePlate> lincensePlates = lincensePlateMapper.selectByExample(lincensePlateExample);
        if (lincensePlates.size() > 0) {
            LincensePlate lincensePlate = lincensePlates.get(0);
            String parkId = lincensePlate.getLpParkingName();
            List<JinshiparkApakey> list = getJinshiparkApakeys(parkId);
            if (list.size() == 0) {
                return JinshiparkJSONResult.errorMsg("支付参数不正确");
            }
            String paymentId = lincensePlate.getPaymentid();
            String orderId = lincensePlate.getLpOrderId();
            String appId = list.get(0).getAppid();
            Map<String, Object> refundParams = getRefundParams(realCost, orderId, appId);
            try {
                Map<String, Object> response = Refund.create(paymentId, refundParams, parkId);
                if (response.get("status").equals("failed")) {
                    return JinshiparkJSONResult.errorMsg(String.valueOf(response.get("error_msg")));
                }
                LincensePlate plate = new LincensePlate();
                plate.setRefundstatus("2");//退款中
                lincensePlateMapper.updateByExampleSelective(plate, lincensePlateExample);
                return JinshiparkJSONResult.ok();

            } catch (BaseAdaPayException e) {
                return JinshiparkJSONResult.errorMsg("调用汇付退款接口异常");
            }
        } else {
            LincensePlateHistoryExample lincensePlateHistoryExample = new LincensePlateHistoryExample();
            LincensePlateHistoryExample.Criteria lincensePlateHistoryExampleCriteria = lincensePlateHistoryExample.createCriteria();
            lincensePlateHistoryExampleCriteria.andLpOrderIdEqualTo(adapayRequstVO.getOrder_no());
            List<LincensePlateHistory> lincensePlateHistories = lincensePlateHistoryMapper.selectByExample(lincensePlateHistoryExample);
            if (lincensePlateHistories.size() == 0) {
                return JinshiparkJSONResult.errorMsg("未查询到记录");
            }
            LincensePlateHistory lincensePlateHistory = lincensePlateHistories.get(0);
            String parkId = lincensePlateHistory.getLpParkingName();
            List<JinshiparkApakey> list = getJinshiparkApakeys(parkId);
            if (list.size() == 0) {
                return JinshiparkJSONResult.errorMsg("支付参数不正确");
            }
            String paymentId = lincensePlateHistory.getPaymentid();
            String orderId = lincensePlateHistory.getLpOrderId();
            String appId = list.get(0).getAppid();
            Map<String, Object> refundParams = getRefundParams(realCost, orderId, appId);
            try {
                Map<String, Object> response = Refund.create(paymentId, refundParams, parkId);
                if (response.get("status").equals("failed")) {
                    return JinshiparkJSONResult.errorMsg(String.valueOf(response.get("error_msg")));
                }
                LincensePlateHistory history = new LincensePlateHistory();
                history.setRefundstatus("2");//退款中
                lincensePlateHistoryMapper.updateByExampleSelective(history, lincensePlateHistoryExample);
                return JinshiparkJSONResult.ok();

            } catch (BaseAdaPayException e) {
                return JinshiparkJSONResult.errorMsg("调用汇付退款接口异常");
            }
        }
    }

    /**
     * 退款回调
     */
    @PostMapping("/refundCallback")
    public void refundCallback(HttpServletRequest request) {
        try {
            //验签请参data
            String data = request.getParameter("data");
            //验签请参sign
            String sign = request.getParameter("sign");
            //验签标记
            boolean checkSign;
            //验签请参publicKey
            String publicKey = AdapayCore.PUBLIC_KEY;
            logger.error("验签请参：data={},sign={}", data, sign);
            //验签
            checkSign = AdapaySign.verifySign(data, sign, publicKey);
            if (checkSign) {
                logger.error("===退款回调开始===");
                //验签成功逻辑
                JSONObject jsonObject = JSONObject.parseObject(data);
                String paymentId = jsonObject.getString("payment_id");
                String status = jsonObject.getString("status");
                String refund_amt = jsonObject.getString("refund_amt");
                logger.error("退款金额：{}", refund_amt);
                LincensePlateExample lincensePlateExample = new LincensePlateExample();
                LincensePlateExample.Criteria lincensePlateExampleCriteria = lincensePlateExample.createCriteria();
                lincensePlateExampleCriteria.andPaymentidEqualTo(paymentId);
                List<LincensePlate> lincensePlates = lincensePlateMapper.selectByExample(lincensePlateExample);
                if (lincensePlates.size() > 0) {
                    logger.error("退款详情：车牌:{},退款金额：{},订单号:{}", lincensePlates.get(0).getLpLincensePlateIdCar(),refund_amt,lincensePlates.get(0).getLpOrderId());
                    LincensePlate record = new LincensePlate();
                    if (status.equals("succeeded")) {
                        record.setRefundstatus("1");
                        record.setRefundmoney(refund_amt);
                    } else {
                        record.setRefundstatus("0");
                    }
                    lincensePlateMapper.updateByExampleSelective(record, lincensePlateExample);
                    logger.error("===退款回调更新在场记录表结束===");
                } else {
                    LincensePlateHistoryExample lincensePlateHistoryExample = new LincensePlateHistoryExample();
                    LincensePlateHistoryExample.Criteria lincensePlateHistoryExampleCriteria = lincensePlateHistoryExample.createCriteria();
                    lincensePlateHistoryExampleCriteria.andPaymentidEqualTo(paymentId);
                    List<LincensePlateHistory> lincensePlateHistories = lincensePlateHistoryMapper.selectByExample(lincensePlateHistoryExample);
                    if (lincensePlateHistories.size() > 0) {
                        logger.error("退款详情：车牌:{},退款金额：{},订单号:{}", lincensePlateHistories.get(0).getLpLincensePlateIdCar(), refund_amt, lincensePlateHistories.get(0).getLpOrderId());
                        LincensePlateHistory record = new LincensePlateHistory();
                        if (status.equals("succeeded")) {
                            record.setRefundstatus("1");
                            record.setRefundmoney(refund_amt);
                        } else {
                            record.setRefundstatus("0");
                        }
                        lincensePlateHistoryMapper.updateByExampleSelective(record, lincensePlateHistoryExample);
                        logger.error("===退款回调更新历史表结束===");
                    }
                }
            }
        } catch (Exception e) {
            logger.error("异步回调异常，Exception：{}", e.getMessage());
        }
    }

    private Map<String, Object> getRefundParams(String realCost, String orderId, String appId) {
        Map<String, Object> refundParams = new HashMap<String, Object>();
        refundParams.put("app_id", appId);
        refundParams.put("refund_amt", new DecimalFormat("0.00").format(Float.parseFloat(realCost)));
        refundParams.put("refund_order_no", orderId);
        refundParams.put("notify_url", ADAPayPropertyConfig.getStrValueByKey("refund_notify_url"));
        return refundParams;
    }

    private List<JinshiparkApakey> getJinshiparkApakeys(String parkId) {
        JinshiparkApakeyExample jinshiparkApakeyExample = new JinshiparkApakeyExample();
        JinshiparkApakeyExample.Criteria jinshiparkApakeyExampleCriteria = jinshiparkApakeyExample.createCriteria();
        jinshiparkApakeyExampleCriteria.andParkidEqualTo(parkId);
        return jinshiparkApakeyMapper.selectByExample(jinshiparkApakeyExample);
    }
}
