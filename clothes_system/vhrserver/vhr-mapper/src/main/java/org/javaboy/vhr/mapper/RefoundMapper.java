package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Refound;

public interface RefoundMapper {
    int deleteByPrimaryKey(Integer refoundId);

    int insert(Refound record);

    int insertSelective(Refound record);

    Refound selectByPrimaryKey(Integer refoundId);

    int updateByPrimaryKeySelective(Refound record);

    int updateByPrimaryKey(Refound record);
}