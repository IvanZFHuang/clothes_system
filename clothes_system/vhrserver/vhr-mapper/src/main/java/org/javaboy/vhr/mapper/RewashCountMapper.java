package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.RewashCount;

import java.util.List;

public interface RewashCountMapper {
    List<RewashCount> listCount(@Param("id") Integer id);
}