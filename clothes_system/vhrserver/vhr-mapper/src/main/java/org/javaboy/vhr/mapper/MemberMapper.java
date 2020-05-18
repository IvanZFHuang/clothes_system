package org.javaboy.vhr.mapper;


import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Member;
import org.javaboy.vhr.model.MemberDetailInfo;
import org.javaboy.vhr.model.UpdateMember;

import java.util.List;

public interface MemberMapper {
    /**
     * @return
     * @Date 2020/4/21 15:49
     * @Author jiangheng
     * @Description //TODO 修改余额
     **/
    void updateBalance(@Param("memberId") int memberId, @Param("balance") double balance);


    int deleteByPrimaryKey(Integer memberId);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer memberId);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    /**
     * @return
     * @Date 2020/4/3 10:08
     * @Author jiangheng
     * @Description //TODO  查询所有的会员信息
     **/
    List<Member> listMembers(@Param("info") String info, @Param("id") Integer id);

    /**
     * @return
     * @Date 2020/4/7 14:02
     * @Author jiangheng
     * @Description //TODO 获取会员号
     **/
    String getMemberNum();

    int update(@Param("id") Integer id, @Param("isLogout") Integer isLogout);

    UpdateMember selectMemberById(@Param("id") int id);

    MemberDetailInfo selectMember(Integer cusId);

    /**
     * @return
     * @Date 2020/4/21 17:47
     * @Author jiangheng
     * @Description //TODO 查询会员信息
     **/
    List<MemberDetailInfo> listMember();

    /**
     * @return
     * @Date 2020/4/21 18:30
     * @Author jiangheng
     * @Description //TODO 根据手机号查询
     **/
    MemberDetailInfo selectByPhone(@Param("phone") String phone);

    /**
     * @return
     * @Date 2020/4/23 8:50
     * @Author jiangheng
     * @Description //TODO 修改会员类型
     **/
    int updateType(@Param("typeId") Integer typeId, @Param("memberId") int memberId);
}