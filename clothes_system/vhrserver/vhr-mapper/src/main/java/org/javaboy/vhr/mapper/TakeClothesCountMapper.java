package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.TakeClothesCount;

import java.util.List;

public interface TakeClothesCountMapper {
    /**
     * @return
     * @Date 2020/4/26 9:59
     * @Author jiangheng
     * @Description //TODO  取衣的数量
     **/
    List<TakeClothesCount> listTcCount(@Param("id") Integer id);

    List<TakeClothesCount> list(@Param("id") Integer id);
}