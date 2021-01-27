package com.jinshipark.hfzf.controller;

import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.mapper2.JinshiparkApakeyMapper;
import com.jinshipark.hfzf.model.JinshiparkApakey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    public static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private LincensePlateMapper lincensePlateMapper;
    @Autowired
    private JinshiparkApakeyMapper jinshiparkApakeyMapper;

    @GetMapping("/hello")
    public Object hello() {
        JinshiparkApakey jinshiparkApakey = jinshiparkApakeyMapper.selectByPrimaryKey(1);
        logger.error("===jinshiparkApakey====");
        logger.error("parkname:{},parkid:{}", jinshiparkApakey.getParkname(), jinshiparkApakey.getParkid());
        return "ok";
    }
}
