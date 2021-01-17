package com.jinshipark.hfzf.service;

import com.jinshipark.hfzf.utils.JinshiparkJSONResult;

public interface JinshiparkAdvertImageService {

    JinshiparkJSONResult getJinshiparkAdvertImageByTypeAndArea(String parkId, String type);
}
