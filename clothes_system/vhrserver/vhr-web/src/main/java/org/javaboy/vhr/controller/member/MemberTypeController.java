package org.javaboy.vhr.controller.member;

import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.MemberTypeService;
import org.javaboy.vhr.utils.AjaxRusult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/2 13:19
 * @Version 1.0
 */
@RestController
@RequestMapping("/member/type")
public class MemberTypeController {
    @Resource
    private MemberTypeService memberTypeService;

    /**
     * @return
     * @Date 2020/4/2 13:22
     * @Author jiangheng
     * @Description //TODO 获取 所有的会员类型
     **/
    @GetMapping("/listMemberType")
    public RespBean listMemType() {
        return memberTypeService.listMemberType();
    }

    @GetMapping("/listMember")
    public AjaxRusult listMember() {
        return memberTypeService.listMember();
    }

    @GetMapping("/selectTotal")
    public AjaxRusult selectTotal(Integer typeId) {
        return memberTypeService.selectTotal(typeId);
    }

}
