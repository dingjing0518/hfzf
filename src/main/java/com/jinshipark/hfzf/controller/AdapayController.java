package com.jinshipark.hfzf.controller;

import com.alibaba.fastjson.JSONObject;
import com.huifu.adapay.Adapay;
import com.huifu.adapay.core.AdapayCore;
import com.huifu.adapay.core.util.AdapaySign;
import com.huifu.adapay.model.MerConfig;
import com.jinshipark.hfzf.config.ADAPayPropertyConfig;
import com.jinshipark.hfzf.mapper2.JinshiparkApakeyMapper;
import com.jinshipark.hfzf.model.JinshiparkApakey;
import com.jinshipark.hfzf.model.JinshiparkApakeyExample;
import com.jinshipark.hfzf.model.vo.JinshiparkApakeyVO;
import com.jinshipark.hfzf.service.AdapayAliPayService;
import com.jinshipark.hfzf.service.AdapayWxPubService;
import com.jinshipark.hfzf.service.LincensePlateService;
import com.jinshipark.hfzf.service.PrePayService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import com.jinshipark.hfzf.vo.AdapayRequstVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

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
    private JinshiparkApakeyMapper jinshiparkApakeyMapper;

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
    public JinshiparkJSONResult prePayExecutePayment(@RequestBody AdapayRequstVO adapayRequstVO) throws ParseException {
        adapayRequstVO.setNotify_url(ADAPayPropertyConfig.getStrValueByKey("pre_notify_url"));
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
            logger.info("验签请参：data={}sign={}");
            //验签
            checkSign = AdapaySign.verifySign(data, sign, publicKey);
            if (checkSign) {
                //验签成功逻辑
                JSONObject jsonObject = JSONObject.parseObject(data);
                String order_no = jsonObject.getString("order_no");
                String pay_channel = jsonObject.getString("pay_channel");
                String pay_amt = jsonObject.getString("pay_amt");

                lincensePlateService.updateLincensePlateForPrePay(order_no, pay_channel, pay_amt);
            }
        } catch (Exception e) {
            logger.info("异步回调开始，参数，request={}");
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
        JinshiparkApakeyExample example = new JinshiparkApakeyExample();
        JinshiparkApakeyExample.Criteria criteria = example.createCriteria();
        criteria.andParkidEqualTo(parkId);
        List<JinshiparkApakey> jinshiparkApakeys = jinshiparkApakeyMapper.selectByExample(example);
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
}
