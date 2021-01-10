package com.jinshipark.hfzf.mapper;

import com.jinshipark.hfzf.model.JinshiparkFee;
import com.jinshipark.hfzf.model.JinshiparkFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JinshiparkFeeMapper {
    long countByExample(JinshiparkFeeExample example);

    int deleteByExample(JinshiparkFeeExample example);

    int deleteByPrimaryKey(Integer jpsId);

    int insert(JinshiparkFee record);

    int insertSelective(JinshiparkFee record);

    List<JinshiparkFee> selectByExample(JinshiparkFeeExample example);

    JinshiparkFee selectByPrimaryKey(Integer jpsId);

    int updateByExampleSelective(@Param("record") JinshiparkFee record, @Param("example") JinshiparkFeeExample example);

    int updateByExample(@Param("record") JinshiparkFee record, @Param("example") JinshiparkFeeExample example);

    int updateByPrimaryKeySelective(JinshiparkFee record);

    int updateByPrimaryKey(JinshiparkFee record);
}