package com.jinshipark.hfzf.controller;

import com.jinshipark.hfzf.model.vo.LincensePlateVO;
import com.jinshipark.hfzf.service.LincensePlateService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lincensePlate")
public class LincensePlateController {
    @Autowired
    private LincensePlateService lincensePlateService;


    @CrossOrigin
    @RequestMapping(value = "/getLincensePlate", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult getLincensePlate(@RequestBody LincensePlateVO lincensePlateVO) {
        return lincensePlateService.getLincensePlate(lincensePlateVO);
    }

    @CrossOrigin
    @RequestMapping(value = "/getLincensePlateByPlate", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult getLincensePlateByPlate(@RequestBody LincensePlateVO lincensePlateVO) {
        return lincensePlateService.getLincensePlateByPlate(lincensePlateVO);
    }

    /**
     * 无牌车入场
     *
     * @param lincensePlateVO 在场记录表实体类
     * @return 处理结果
     */
    @CrossOrigin
    @RequestMapping(value = "/saveLincensePlate", method = RequestMethod.POST)
    @ResponseBody
    public JinshiparkJSONResult saveLincensePlate(@RequestBody LincensePlateVO lincensePlateVO) {
        return lincensePlateService.saveLincensePlate(lincensePlateVO);
    }
}
