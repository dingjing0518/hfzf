package com.jinshipark.hfzf.mapper;

import com.jinshipark.hfzf.model.JinshiParkSetting;
import com.jinshipark.hfzf.model.JinshiParkSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JinshiParkSettingMapper {
    long countByExample(JinshiParkSettingExample example);

    int deleteByExample(JinshiParkSettingExample example);

    int deleteByPrimaryKey(Integer jpsId);

    int insert(JinshiParkSetting record);

    int insertSelective(JinshiParkSetting record);

    List<JinshiParkSetting> selectByExample(JinshiParkSettingExample example);

    JinshiParkSetting selectByPrimaryKey(Integer jpsId);

    int updateByExampleSelective(@Param("record") JinshiParkSetting record, @Param("example") JinshiParkSettingExample example);

    int updateByExample(@Param("record") JinshiParkSetting record, @Param("example") JinshiParkSettingExample example);

    int updateByPrimaryKeySelective(JinshiParkSetting record);

    int updateByPrimaryKey(JinshiParkSetting record);
}