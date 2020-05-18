package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.cloCount;

import java.util.List;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: wangshichao
 * @Date: 2020/4/22 14:09
 * @Version 1.0
 */
@Mapper
public interface clothesCountMapper {
    List<cloCount> listClothes(@Param("id") Integer id);

    List<cloCount> listClothe(@Param("id") Integer id);
}
