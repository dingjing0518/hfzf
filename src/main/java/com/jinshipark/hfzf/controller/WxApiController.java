package com.jinshipark.hfzf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/wxApi")
public class WxApiController {
    @Autowired
    private RestTemplate restTemplate;

    @CrossOrigin
    @RequestMapping(value = "/getOpenId", method = RequestMethod.GET)
    @ResponseBody
    public Object alipayExecutePayment(String code) {
        String appid = "wxf8d4e15b5a5a1ea0";
        String secret = "85a2981bc195f7a3a1cc38f473f846c3";
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
        Object object = restTemplate.getForObject(url, String.class);
        return object;
    }
}
