package com.jinshipark.hfzf.service.impl;

import com.jinshipark.hfzf.mapper2.JinshiparkAdvertImageMapper;
import com.jinshipark.hfzf.model.JinshiparkAdvertImage;
import com.jinshipark.hfzf.model.JinshiparkAdvertImageExample;
import com.jinshipark.hfzf.service.JinshiparkAdvertImageService;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JinshiparkAdvertImageServiceImpl implements JinshiparkAdvertImageService {
    @Autowired
    private JinshiparkAdvertImageMapper jinshiparkAdvertImageMapper;

    @Override
    public JinshiparkJSONResult getJinshiparkAdvertImageByTypeAndArea(String parkId, String type) {
        JinshiparkAdvertImageExample example = new JinshiparkAdvertImageExample();
        JinshiparkAdvertImageExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(type);
        criteria.andAreaEqualTo(parkId.substring(0, 6));
        List<JinshiparkAdvertImage> jinshiparkAdvertImages = jinshiparkAdvertImageMapper.selectByExample(example);
        return JinshiparkJSONResult.ok(jinshiparkAdvertImages);
    }
}
