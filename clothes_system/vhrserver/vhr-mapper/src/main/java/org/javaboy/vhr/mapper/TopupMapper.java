package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Topup;

import java.util.List;

public interface TopupMapper {
    int deleteByPrimaryKey(Integer topupId);

    int insert(Topup record);

    int insertSelective(Topup record);

    Topup selectByPrimaryKey(Integer topupId);

    int updateByPrimaryKeySelective(Topup record);

    int updateByPrimaryKey(Topup record);

    List<Topup> listTopUp(@Param("info") String info, @Param("id") Integer id);
}