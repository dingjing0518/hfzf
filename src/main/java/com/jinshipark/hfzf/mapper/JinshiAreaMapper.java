package com.jinshipark.hfzf.mapper;


import com.jinshipark.hfzf.model.JinshiArea;
import com.jinshipark.hfzf.model.JinshiAreaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JinshiAreaMapper {
    long countByExample(JinshiAreaExample example);

    int deleteByExample(JinshiAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JinshiArea record);

    int insertSelective(JinshiArea record);

    List<JinshiArea> selectByExample(JinshiAreaExample example);

    JinshiArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JinshiArea record, @Param("example") JinshiAreaExample example);

    int updateByExample(@Param("record") JinshiArea record, @Param("example") JinshiAreaExample example);

    int updateByPrimaryKeySelective(JinshiArea record);

    int updateByPrimaryKey(JinshiArea record);
}