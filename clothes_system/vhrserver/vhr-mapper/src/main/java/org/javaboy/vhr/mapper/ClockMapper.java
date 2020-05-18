package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Clock;

import java.util.List;

public interface ClockMapper {

    int deleteByPrimaryKey(Integer clockId);

    int insert(Clock record);


    int insertSelective(Clock record);


    Clock selectByPrimaryKey(Integer clockId);

    int updateByPrimaryKeySelective(Clock record);


    int updateByPrimaryKey(Clock record);


    /**
     * @return
     * @Date 2020/3/30 20:52
     * @Author jiangheng
     * @Description //TODO 打卡下班，即修改下班的状态
     **/
    int updateClock(@Param("empWorkid") Object empWorkID, @Param("clockDate") Object clockDate, @Param("endDate") String endDate);

    /**
     * @return 根据工号和时间查询是否打卡
     * @Date 2020/3/30 22:00
     * @Author jiangheng
     * @Description //TODO
     **/
    Clock selectClock(@Param("empWorkID") String empWorkID, @Param("clockDate") String clockDate);

    List<Clock> listClock(@Param("name") String name, @Param("date") String date);
}