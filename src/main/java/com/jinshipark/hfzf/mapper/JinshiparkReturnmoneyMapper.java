package com.jinshipark.hfzf.mapper;

import com.jinshipark.hfzf.model.JinshiparkReturnmoney;
import com.jinshipark.hfzf.model.JinshiparkReturnmoneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JinshiparkReturnmoneyMapper {
    long countByExample(JinshiparkReturnmoneyExample example);

    int deleteByExample(JinshiparkReturnmoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JinshiparkReturnmoney record);

    int insertSelective(JinshiparkReturnmoney record);

    List<JinshiparkReturnmoney> selectByExample(JinshiparkReturnmoneyExample example);

    JinshiparkReturnmoney selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JinshiparkReturnmoney record, @Param("example") JinshiparkReturnmoneyExample example);

    int updateByExample(@Param("record") JinshiparkReturnmoney record, @Param("example") JinshiparkReturnmoneyExample example);

    int updateByPrimaryKeySelective(JinshiparkReturnmoney record);

    int updateByPrimaryKey(JinshiparkReturnmoney record);
}