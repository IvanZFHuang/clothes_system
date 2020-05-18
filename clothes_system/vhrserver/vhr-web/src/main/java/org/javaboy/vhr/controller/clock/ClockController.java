package org.javaboy.vhr.controller.clock;

import org.javaboy.vhr.service.ClockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/3/31 23:22
 * @Version 1.0
 */
@RestController
@RequestMapping("/clock/basic")
public class ClockController {
    @Resource
    private ClockService clockService;

    @GetMapping("/listClock")
    public Map<String, Object> listClock(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                         String keyword, String currentDate) {
        return clockService.listClock(pageNum, pageSize, keyword, currentDate);

    }
}
