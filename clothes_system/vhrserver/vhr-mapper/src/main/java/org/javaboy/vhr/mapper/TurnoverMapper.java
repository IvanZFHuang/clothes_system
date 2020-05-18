package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Turnover;

import java.util.List;

public interface TurnoverMapper {
    /**
     * @return
     * @Date 2020/4/26 10:59
     * @Author jiangheng
     * @Description //TODO 查询营业额
     **/
    List<Turnover> listTurnover(@Param("id") Integer id);


}