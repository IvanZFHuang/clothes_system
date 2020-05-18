package org.javaboy.vhr.controller;

import org.javaboy.vhr.service.EmailService;
import org.javaboy.vhr.utils.AjaxRusult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description: @Company：众阳健康 @Author: jiangheng @Date: 2020/4/10 22:05 @Version 1.0
 */
@Controller
public class EmailController {
    @Resource
    private EmailService emailService;

    @ResponseBody
    @RequestMapping("/sendEmail")
    public AjaxRusult sendMail(String email) {
        return emailService.sendMail(email);
    }
}
