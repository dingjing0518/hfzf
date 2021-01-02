package com.jinshipark.hfzf.mapper;


import com.jinshipark.hfzf.model.LincensePlate;
import com.jinshipark.hfzf.model.LincensePlateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface LincensePlateMapper {
    long countByExample(LincensePlateExample example);

    int deleteByExample(LincensePlateExample example);

    int deleteByPrimaryKey(Integer lpId);

    int insert(LincensePlate record);

    int insertSelective(LincensePlate record);

    List<LincensePlate> selectByExample(LincensePlateExample example);

    LincensePlate selectByPrimaryKey(Integer lpId);

    int updateByExampleSelective(@Param("record") LincensePlate record, @Param("example") LincensePlateExample example);

    int updateByExample(@Param("record") LincensePlate record, @Param("example") LincensePlateExample example);

    int updateByPrimaryKeySelective(LincensePlate record);

    int updateByPrimaryKey(LincensePlate record);
}