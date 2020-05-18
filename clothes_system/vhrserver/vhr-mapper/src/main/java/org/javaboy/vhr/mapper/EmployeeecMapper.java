package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Employeeec;

/**
 * @Date 2020/4/15 23:11
 * @Author jiangheng
 * @Description //TODO
 **/
public interface EmployeeecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);
}