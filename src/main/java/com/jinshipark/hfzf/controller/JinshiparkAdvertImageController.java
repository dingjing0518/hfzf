package com.jinshipark.hfzf.controller;

import com.jinshipark.hfzf.model.vo.JinshiparkAdvertImageVO;
import com.jinshipark.hfzf.service.JinshiparkAdvertImageService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jinshiparkAdvertImage")
public class JinshiparkAdvertImageController {

    @Autowired
    private JinshiparkAdvertImageService jinshiparkAdvertImageService;

    @CrossOrigin
    @RequestMapping(value = "/getJinshiparkAdvertImageByTypeAndArea", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult getJinshiparkAdvertImageByTypeAndArea(@RequestBody JinshiparkAdvertImageVO jinshiparkAdvertImageVO) {
        return jinshiparkAdvertImageService.getJinshiparkAdvertImageByTypeAndArea(jinshiparkAdvertImageVO.getParkId(), jinshiparkAdvertImageVO.getType());
    }
}
