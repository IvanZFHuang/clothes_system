package org.javaboy.vhr.service;

import org.javaboy.vhr.utils.AjaxRusult;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: @Company：众阳健康 @Author: jiangheng @Date: 2020/4/10 22:51 @Version 1.0
 */
@Service
public class EmailService {
    @Resource
    private JavaMailSender mailSender;

    public AjaxRusult sendMail(String email) {
        // 根据邮箱获取密码
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jiangheng0223@qq.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("领取衣服");
        simpleMailMessage.setText("您好，你的的衣服已经洗完，请您有时间来取一下，如有什么疑问，及时与我们沟通。祝您身体健康，工作顺心！");
        mailSender.send(simpleMailMessage);
        return AjaxRusult.ok().put("msg", "已经通知顾客取衣");
    }
}
