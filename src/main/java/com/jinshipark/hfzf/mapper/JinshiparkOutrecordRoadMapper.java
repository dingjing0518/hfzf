package com.jinshipark.hfzf.mapper;

import com.jinshipark.hfzf.model.JinshiparkOutrecordRoad;
import com.jinshipark.hfzf.model.JinshiparkOutrecordRoadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JinshiparkOutrecordRoadMapper {
    long countByExample(JinshiparkOutrecordRoadExample example);

    int deleteByExample(JinshiparkOutrecordRoadExample example);

    int deleteByPrimaryKey(Integer lpId);

    int insert(JinshiparkOutrecordRoad record);

    int insertSelective(JinshiparkOutrecordRoad record);

    List<JinshiparkOutrecordRoad> selectByExample(JinshiparkOutrecordRoadExample example);

    JinshiparkOutrecordRoad selectByPrimaryKey(Integer lpId);

    int updateByExampleSelective(@Param("record") JinshiparkOutrecordRoad record, @Param("example") JinshiparkOutrecordRoadExample example);

    int updateByExample(@Param("record") JinshiparkOutrecordRoad record, @Param("example") JinshiparkOutrecordRoadExample example);

    int updateByPrimaryKeySelective(JinshiparkOutrecordRoad record);

    int updateByPrimaryKey(JinshiparkOutrecordRoad record);
}