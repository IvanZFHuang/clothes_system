package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.RefoundCount;

import java.util.List;

public interface RefoundCountMapper {
    List<RefoundCount> listCount(@Param("id") Integer id);
}