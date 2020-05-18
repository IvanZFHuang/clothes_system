package org.javaboy.vhr.controller.change;

import org.javaboy.vhr.model.ChangeManage;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.ChangeManageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/3/27 23:52
 * @Version 1.0
 */
@RequestMapping("/changed/basic")
@RestController
public class ChangedCrontroller {
    @Resource
    private ChangeManageService changeManageService;


    /**
     * @return
     * @Date 2020/3/30 11:02
     * @Author jiangheng
     * @Description //TODO 修改交接的状态
     **/
    @RequestMapping("/updateIsOver")
    public RespBean updateIsOver(@RequestBody Map<String, Integer> map) {
        return changeManageService.updateIsover(map.get("changeId"), map.get("isOver"));
    }

    /**
     * @return
     * @Date 2020/3/31 13:53
     * @Author jiangheng
     * @Description //TODO 获取全部的交接信息
     **/
    @RequestMapping("/listChanges")
    public Map<String, Object> listChangemanage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                String currentDate, String workId) {
        return changeManageService.listChangemanage(pageNum, pageSize, currentDate, workId);
    }

    @PostMapping("/addChange")
    public RespBean addChange(@RequestBody ChangeManage changeManage) {
        return changeManageService.addChange(changeManage);
    }

}
