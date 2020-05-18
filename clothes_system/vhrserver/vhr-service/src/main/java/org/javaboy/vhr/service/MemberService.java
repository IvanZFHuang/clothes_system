package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.CustomerMapper;
import org.javaboy.vhr.mapper.MemberMapper;
import org.javaboy.vhr.model.*;
import org.javaboy.vhr.utils.AjaxRusult;
import org.javaboy.vhr.utils.FormatDateUtil;
import org.javaboy.vhr.utils.HrUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/3 10:25
 * @Version 1.0
 */
@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private CustomerMapper customerMapper;

    /**
     * @return
     * @Date 2020/4/3 10:08
     * @Author jiangheng
     * @Description //TODO  查询所有的会员信息
     **/
    public RespBean listMembers(Integer pageNum, Integer pageSize, String keyWord) {
        Hr hr = HrUtils.getCurrentHr();
        List<Role> roles = hr.getRoles();
        List<String> listRoles = new ArrayList<>();
        for (Role role : roles) {
            listRoles.add(role.getNameZh());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Member> members = null;
        if (listRoles.contains("系统管理员")) {
            members = memberMapper.listMembers(keyWord, null);
        } else {
            members = memberMapper.listMembers(keyWord, hr.getId());
        }
        PageInfo<Member> memberPageInfo = new PageInfo<>(members);
        return RespBean.ok("查询成功", memberPageInfo.getList(), memberPageInfo.getTotal());
    }

    /**
     * @return
     * @Date 2020/4/3 10:08
     * @Author jiangheng
     * @Description //TODO  查询所有的会员信息
     **/
    public AjaxRusult listMember() {
        List<MemberDetailInfo> members = memberMapper.listMember();
        return AjaxRusult.ok().put("obj", members);
    }

    /**
     * @return
     * @Date 2020/4/7 14:08
     * @Author jiangheng
     * @Description //TODO 获取最大id 的会员号
     **/
    public AjaxRusult getMemberNum() {

        String memberNum = memberMapper.getMemberNum();
        String prefix = memberNum.substring(0, memberNum.lastIndexOf('0') + 1);
        memberNum = memberNum.substring(memberNum.lastIndexOf('0') + 1);
        System.out.println(memberNum);
        Integer num = Integer.parseInt(memberNum);
        num = num + 1;
        String finalNum = prefix + num;
        return AjaxRusult.ok().put("obj", finalNum);
    }

    /**
     * @return
     * @Date 2020/4/7 14:49
     * @Author jiangheng
     * @Description //TODO  添加
     **/
    public AjaxRusult insertMember(Member member) {
        member.setCreateTime(FormatDateUtil.formatDate(new Date()));
        member.setUserId(HrUtils.getCurrentHr().getId());
        int count = memberMapper.insertSelective(member);
        if (count > 0) {
            return AjaxRusult.ok();
        } else {
            return AjaxRusult.error(500, "添加失败");
        }
    }

    public AjaxRusult delete(Integer id, Integer isLogout) {
        int count = memberMapper.update(id, isLogout);
        if (count > 0) {
            return AjaxRusult.ok().put("msg", "操作成功");
        } else {
            return AjaxRusult.error(500, "操作失败");
        }

    }

    public AjaxRusult selectMemberById(int id) {
        return AjaxRusult.ok().put("obj", memberMapper.selectMemberById(id));
    }


    public AjaxRusult update(UpdateMember updateMember) {
        Customer cus = new Customer();
        cus.setCusEmail(updateMember.getCusEmail());
        cus.setCusPhone(updateMember.getCusPhone());
        cus.setCusName(updateMember.getCusName());
        cus.setCusId(updateMember.getCusId());
        int count = customerMapper.updateByPrimaryKey(cus);
        if (count > 0) {
            return AjaxRusult.ok().put("msg", "修改成功");
        } else {
            return AjaxRusult.error(500, "修改失败");
        }
    }

    /**
     * @return
     * @Date 2020/4/21 18:28
     * @Author jiangheng
     * @Description //TODO 根据手机号查询
     **/
    public AjaxRusult findMemberByPhone(String phone) {
        MemberDetailInfo member = memberMapper.selectByPhone(phone);
        return AjaxRusult.ok().put("obj", member);
    }
}
