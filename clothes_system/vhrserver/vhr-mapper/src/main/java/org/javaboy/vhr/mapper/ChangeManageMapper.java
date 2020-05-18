package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.ChangeManage;

import java.util.List;

public interface ChangeManageMapper {
    int deleteByPrimaryKey(Integer changeId);

    int insert(ChangeManage record);

    int insertSelective(ChangeManage record);

    ChangeManage selectByPrimaryKey(Integer changeId);

    int updateByPrimaryKeySelective(ChangeManage record);

    int updateByPrimaryKey(ChangeManage record);

    /**
     * @return 查询所有的交接信息
     * @Date 2020/3/31 13:43
     * @Author jiangheng
     * @Description //TODO
     **/
    List<ChangeManage> listChangemanage(@Param("currnetDate") String currnetDate, @Param("workId") String workId);

    /**
     * @return
     * @Date 2020/3/31 14:14
     * @Author jiangheng
     * @Description //TODO 修改对接状态
     **/
    int updateIsOver(@Param("isOver") Integer isOver, @Param("changeId") Integer changeId, @Param("overDate") String overDate);
}