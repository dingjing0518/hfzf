package com.jinshipark.hfzf.controller;

import com.jinshipark.hfzf.mapper.LincensePlateMapper;
import com.jinshipark.hfzf.mapper2.JinshiparkApakeyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private LincensePlateMapper lincensePlateMapper;
    @Autowired
    private JinshiparkApakeyMapper jinshiparkApakeyMapper;
    @GetMapping("/hello")
    public Object hello() {
        return jinshiparkApakeyMapper.selectByPrimaryKey(1);
    }
}
