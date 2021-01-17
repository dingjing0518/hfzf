package com.jinshipark.hfzf.mapper2;

import com.jinshipark.hfzf.model.JinshiparkAdvertImage;
import com.jinshipark.hfzf.model.JinshiparkAdvertImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JinshiparkAdvertImageMapper {
    long countByExample(JinshiparkAdvertImageExample example);

    int deleteByExample(JinshiparkAdvertImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JinshiparkAdvertImage record);

    int insertSelective(JinshiparkAdvertImage record);

    List<JinshiparkAdvertImage> selectByExample(JinshiparkAdvertImageExample example);

    JinshiparkAdvertImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JinshiparkAdvertImage record, @Param("example") JinshiparkAdvertImageExample example);

    int updateByExample(@Param("record") JinshiparkAdvertImage record, @Param("example") JinshiparkAdvertImageExample example);

    int updateByPrimaryKeySelective(JinshiparkAdvertImage record);

    int updateByPrimaryKey(JinshiparkAdvertImage record);
}