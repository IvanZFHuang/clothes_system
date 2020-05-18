package org.javaboy.vhr.record;

import org.javaboy.vhr.service.RecordService;
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
 * @Date: 2020/4/7 22:42
 * @Version 1.0
 */
@RestController
@RequestMapping("/record/basic")
public class RecordController {
    @Resource
    private RecordService recordService;

    @GetMapping("/listRecord")
    public Map<String, Object> listRecord(String keyWord, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return recordService.listRecord(keyWord, pageNum, pageSize);
    }

    @GetMapping("/listTopUp")
    public Map<String, Object> listTopUp(String keyWord, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return recordService.listTopUp(keyWord, pageNum, pageSize);
    }
}
