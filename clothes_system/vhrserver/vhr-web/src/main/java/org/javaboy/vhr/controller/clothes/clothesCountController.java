package org.javaboy.vhr.controller.clothes;

import org.javaboy.vhr.model.TakeClothesCount;
import org.javaboy.vhr.model.Turnover;
import org.javaboy.vhr.model.cloCount;
import org.javaboy.vhr.service.ClothesCountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: wangshichao
 * @Date: 2020/4/22 10:34
 * @Version 1.0
 */
@RestController
@RequestMapping("/basic/washedcloth")
public class ClothesCountController {
    @Resource
    private ClothesCountService clothescountService;

    /**
     * @return
     * @Date 2020/4/26 10:07
     * @Author jiangheng
     * @Description //TODO 收衣的数量
     **/
    @GetMapping("/listClothes")
    public List<cloCount> list() {
        return clothescountService.listClothes();
    }

    /**
     * @return
     * @Date 2020/4/26 10:08
     * @Author jiangheng
     * @Description //TODO 取衣的数量
     **/
    @GetMapping("/listTcCount")
    public List<TakeClothesCount> listTcCount() {
        return clothescountService.list();
    }

    /**
     * @return
     * @Date 2020/4/26 11:03
     * @Author jiangheng
     * @Description //TODO 获取营业额
     **/
    @GetMapping("/listTurnover")
    public List<Turnover> turnoverList() {
        return clothescountService.listTurnover();
    }

    @GetMapping("/listIntervalTurn")
    public Map<String, Object> listInterval() {
        return clothescountService.listIntervalTurn();
    }

    @GetMapping("/listServicefall")
    public Map<String, Object> listServicefall() {
        return clothescountService.listServicefall();
    }
}
