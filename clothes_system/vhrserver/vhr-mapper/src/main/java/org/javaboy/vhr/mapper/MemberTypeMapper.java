package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.MemberType;

import java.util.List;

public interface MemberTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(MemberType record);

    int insertSelective(MemberType record);

    MemberType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(MemberType record);

    int updateByPrimaryKey(MemberType record);

    /**
     * @return
     * @Date 2020/4/2 13:13
     * @Author jiangheng
     * @Description //TODO 查询多有的会员类型
     **/
    List<MemberType> listMemberType();
}