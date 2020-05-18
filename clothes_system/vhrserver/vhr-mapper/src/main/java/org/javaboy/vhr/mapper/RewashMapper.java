package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Rewash;

public interface RewashMapper {
    int deleteByPrimaryKey(Integer reId);

    int insert(Rewash record);

    int insertSelective(Rewash record);

    Rewash selectByPrimaryKey(Integer reId);

    int updateByPrimaryKeySelective(Rewash record);

    int updateByPrimaryKey(Rewash record);
}