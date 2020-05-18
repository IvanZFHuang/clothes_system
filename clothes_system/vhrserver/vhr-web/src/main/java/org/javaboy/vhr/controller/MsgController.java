package org.javaboy.vhr.controller;

import org.javaboy.vhr.service.MsgContentService;
import org.javaboy.vhr.utils.AjaxRusult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/24 18:15
 * @Version 1.0
 */
@RequestMapping("/msg/basic")
@RestController
public class MsgController {
    @Resource
    private MsgContentService msgContentService;

    @GetMapping("/listMsg")
    public AjaxRusult listMsg() {
        return AjaxRusult.ok().put("obj", msgContentService.listMsgContent());
    }
}
