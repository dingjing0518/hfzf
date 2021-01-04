package com.jinshipark.hfzf.service;

import com.jinshipark.hfzf.model.vo.WxApiVO;
import com.jinshipark.hfzf.utils.JinshiparkJSONResult;

public interface WxApiService {
    JinshiparkJSONResult getOpenId(WxApiVO wxApiVO);
}
