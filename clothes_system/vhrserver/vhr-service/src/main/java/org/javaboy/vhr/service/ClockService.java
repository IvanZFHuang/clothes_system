package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.ClockMapper;
import org.javaboy.vhr.model.Clock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/3/30 18:03
 * @Version 1.0
 */
@Service
public class ClockService {
    @Resource
    ClockMapper clockMapper;

    public int insertClock(Clock clock) {
        return clockMapper.insertSelective(clock);
    }

    public int updateClock(Object empWorkid, Object clockDate, String date) {
        return clockMapper.updateClock(empWorkid, clockDate, date);
    }

    public Clock selectClock(String workID, String clockDate) {
        return clockMapper.selectClock(workID, clockDate);
    }

    public Map<String, Object> listClock(Integer pageNum, Integer pageSize, String name, String date) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Clock> clocks = clockMapper.listClock(name, date);
        PageInfo<Clock> pageInfo = new PageInfo<>(clocks);
        map.put("obj", pageInfo.getList());
        map.put("obj1", pageInfo.getTotal());
        map.put("msg", "查询成功");
        return map;
    }
}
