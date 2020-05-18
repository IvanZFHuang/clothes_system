package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Record;

import java.util.List;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    /**
     * @return
     * @Date 2020/4/7 21:51
     * @Author jiangheng
     * @Description //TODO  查询所有的消费记录
     **/
    List<Record> listRecord(@Param("info") String info, @Param("id") Integer id);
}