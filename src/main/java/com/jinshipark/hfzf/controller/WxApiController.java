package com.jinshipark.hfzf.controller;


import com.jinshipark.hfzf.model.vo.WxApiVO;
import com.jinshipark.hfzf.service.WxApiService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/wxApi")
public class WxApiController {
    @Autowired
    private WxApiService wxApiService;
    @CrossOrigin
    @RequestMapping(value = "/getOpenId", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult getOpenId(@RequestBody WxApiVO wxApiVO) {
        return wxApiService.getOpenId(wxApiVO);
    }
}
