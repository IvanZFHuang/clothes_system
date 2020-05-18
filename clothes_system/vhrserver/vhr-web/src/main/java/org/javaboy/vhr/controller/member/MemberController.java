package org.javaboy.vhr.controller.member;

import org.javaboy.vhr.model.Member;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.UpdateMember;
import org.javaboy.vhr.service.MemberService;
import org.javaboy.vhr.utils.AjaxRusult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/3 10:31
 * @Version 1.0
 */
@RequestMapping("/member/basic")
@RestController
public class MemberController {
    @Resource
    private MemberService memberService;

    /**
     * @return
     * @Date 2020/4/3 10:37
     * @Author jiangheng
     * @Description //TODO 查询所有的会员信息
     **/
    @GetMapping("/listMembers")
    public RespBean listMembers(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, String keyWord) {
        return memberService.listMembers(pageNum, pageSize, keyWord);
    }

    /**
     * @return 设置会员号
     * @Date 2020/4/7 13:59
     * @Author jiangheng
     * @Description //TODO
     **/
    @RequestMapping("/getMemberNum")
    public AjaxRusult getMemberNum() {
        return memberService.getMemberNum();
    }

    /**
     * @return
     * @Date 2020/4/7 14:43
     * @Author jiangheng
     * @Description //TODO  添加会员信息
     **/
    @PostMapping("/insertMember")
    public AjaxRusult insertMember(@RequestBody Member member) {
        return memberService.insertMember(member);
    }

    /**
     * @return
     * @Date 2020/4/7 17:15
     * @Author jiangheng
     * @Description //TODO 注销会员
     **/
    @PutMapping("/logout")
    public AjaxRusult delete(@RequestBody Map<String, Object> map) {
        return memberService.delete((Integer) map.get("id"), (Integer) map.get("isLogout"));
    }

    @GetMapping("/selectMemberById")
    public AjaxRusult selectMemberById(int id) {
        return memberService.selectMemberById(id);
    }

    @PutMapping("/update")
    public AjaxRusult update(@RequestBody UpdateMember updateMember) {
        return memberService.update(updateMember);
    }

    /**
     * @return
     * @Date 2020/4/21 17:49
     * @Author jiangheng
     * @Description //TODO  查询会员的用户名
     **/
    @GetMapping("/listMember")
    public AjaxRusult listMember() {
        return memberService.listMember();
    }

    /**
     * @return
     * @Date 2020/4/21 18:27
     * @Author jiangheng
     * @Description //TODO 根据手机号查询会员信息
     **/
    @GetMapping("/findMemberByPhone")
    public AjaxRusult findMemberByPhone(String phone) {
        return memberService.findMemberByPhone(phone);
    }

}
