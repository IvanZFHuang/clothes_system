package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.TakeClothes;

public interface TakeClothesMapper {
    int deleteByPrimaryKey(Integer takeId);

    int insert(TakeClothes record);

    int insertSelective(TakeClothes record);

    TakeClothes selectByPrimaryKey(Integer takeId);

    int updateByPrimaryKeySelective(TakeClothes record);

    int updateByPrimaryKey(TakeClothes record);
}