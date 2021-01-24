package com.jinshipark.hfzf.mapper;

import com.jinshipark.hfzf.model.LincensePlateHistory;
import com.jinshipark.hfzf.model.LincensePlateHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LincensePlateHistoryMapper {
    long countByExample(LincensePlateHistoryExample example);

    int deleteByExample(LincensePlateHistoryExample example);

    int deleteByPrimaryKey(Integer lpId);

    int insert(LincensePlateHistory record);

    int insertSelective(LincensePlateHistory record);

    List<LincensePlateHistory> selectByExample(LincensePlateHistoryExample example);

    LincensePlateHistory selectByPrimaryKey(Integer lpId);

    int updateByExampleSelective(@Param("record") LincensePlateHistory record, @Param("example") LincensePlateHistoryExample example);

    int updateByExample(@Param("record") LincensePlateHistory record, @Param("example") LincensePlateHistoryExample example);

    int updateByPrimaryKeySelective(LincensePlateHistory record);

    int updateByPrimaryKey(LincensePlateHistory record);
}