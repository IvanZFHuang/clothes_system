package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.ClothesTypePrice;

import java.util.List;

public interface ClothesTypePriceMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(ClothesTypePrice record);

    int insertSelective(ClothesTypePrice record);

    ClothesTypePrice selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(ClothesTypePrice record);

    int updateByPrimaryKey(ClothesTypePrice record);

    /**
     * @return
     * @Date 2020/4/19 12:59
     * @Author jiangheng
     * @Description //TODO 获取所有的衣服类型
     **/
    List<ClothesTypePrice> listClothesTypePrice();
}