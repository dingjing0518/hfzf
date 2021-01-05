package com.jinshipark.hfzf.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.jinshipark.hfzf.config.ADAPayPropertyConfig;
import com.jinshipark.hfzf.model.vo.WxApiVO;
import com.jinshipark.hfzf.service.WxApiService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WxApiServiceImpl implements WxApiService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public JinshiparkJSONResult getOpenId(WxApiVO wxApiVO) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + ADAPayPropertyConfig.getProperty("appid") + "&secret=" + ADAPayPropertyConfig.getProperty("secret") + "&code=" + wxApiVO.getCode() + "&grant_type=authorization_code";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
            if (jsonObject.containsKey("openid")) {
                System.out.println(jsonObject.getString("openid"));
                return JinshiparkJSONResult.ok(jsonObject.getString("openid"));
            } else {
                return JinshiparkJSONResult.errorMsg(jsonObject.getString("errmsg"));
            }
        } else {
            return JinshiparkJSONResult.errorMsg("调用微信接口异常");
        }
    }
}
