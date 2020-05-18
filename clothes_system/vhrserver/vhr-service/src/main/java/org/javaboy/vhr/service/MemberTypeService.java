package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.MemberTypeMapper;
import org.javaboy.vhr.model.MemberType;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.utils.AjaxRusult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/2 8:53
 * @Version 1.0
 */
@Service
public class MemberTypeService {
    @Resource
    private MemberTypeMapper memberTypeMapper;

    /**
     * @return
     * @Date 2020/4/2 13:13
     * @Author jiangheng
     * @Description //TODO 查询多有的会员类型
     **/
    public RespBean listMemberType() {
        List<MemberType> memberTypes = memberTypeMapper.listMemberType();

        for (MemberType me : memberTypes) {
            String[] array = me.getRemark().split("。");
            List<String> remark = Arrays.asList(array);
            me.setRemarks(remark);
        }
        if (memberTypes.size() > 0 && memberTypes != null) {
            return RespBean.ok("查询成功", memberTypes);
        } else {
            return RespBean.error("查询失败");
        }
    }


    public AjaxRusult listMember() {
        List<MemberType> memberTypes = memberTypeMapper.listMemberType();
        for (MemberType me : memberTypes) {
            String[] array = me.getRemark().split("。");
            List<String> remark = Arrays.asList(array);
            me.setRemarks(remark);
        }
        return AjaxRusult.ok().put("obj", memberTypes);
    }

    public AjaxRusult selectTotal(Integer typeId) {
        MemberType memberType = memberTypeMapper.selectByPrimaryKey(typeId);
        return AjaxRusult.ok().put("obj", memberType);
    }
}
