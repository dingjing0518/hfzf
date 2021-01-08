package com.jinshipark.hfzf.controller;

import com.alibaba.fastjson.JSONObject;
import com.huifu.adapay.core.AdapayCore;
import com.huifu.adapay.core.util.AdapaySign;
import com.jinshipark.hfzf.service.AdapayAliPayService;
import com.jinshipark.hfzf.service.AdapayWxPubService;
import com.jinshipark.hfzf.service.LincensePlateService;
import com.jinshipark.hfzf.service.PrePayService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
        JinshiparkJSONResult jinshiparkJSONResult = adapayWxPubService.wxPubExecutePayment(adapayRequstVO);
        System.out.println(jinshiparkJSONResult);
        return jinshiparkJSONResult;
    }

    /**
     * 预支付接口
     *
     * @param adapayRequstVO 请求参数实体
     * @return 处理结果
     */
    @CrossOrigin
    @RequestMapping(value = "/prePayExecutePayment", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult prePayExecutePayment(@RequestBody AdapayRequstVO adapayRequstVO) {
        JinshiparkJSONResult jinshiparkJSONResult = prePayService.prePayExecutePayment(adapayRequstVO);
        System.out.println(jinshiparkJSONResult);
        return jinshiparkJSONResult;
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
            logger.info("验签请参：data={}sign={}");
            //验签
            checkSign = AdapaySign.verifySign(data, sign, publicKey);
            if (checkSign) {
                //验签成功逻辑
                JSONObject jsonObject = JSONObject.parseObject(data);
                String order_no = jsonObject.getString("order_no");
                String pay_channel = jsonObject.getString("pay_channel");
                String pay_amt = jsonObject.getString("pay_amt");

                lincensePlateService.updateLincensePlate(order_no, pay_channel, pay_amt);
            }
        } catch (Exception e) {
            logger.info("异步回调开始，参数，request={}");
        }
    }
}
