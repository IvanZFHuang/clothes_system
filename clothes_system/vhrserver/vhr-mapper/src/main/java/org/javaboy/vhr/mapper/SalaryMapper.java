package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Salary;

import java.util.List;

public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> getAllSalaries();

    /**
     * @return
     * @Date 2020/3/25 21:53
     * @Author jiangheng
     * @Description //TODO  查询员工的工资
     **/
    List<Salary> listSalary(@Param("keyword") String keyword);

    /**
     * @return
     * @Date 2020/3/27 15:15
     * @Author jiangheng
     * @Description //TODO 获取最大的id值
     **/
    int getId();

    /**
     * @return 根据id 查询
     * @Date 2020/3/27 16:57
     * @Author jiangheng
     * @Description //TODO
     **/
    Salary selectSalaryById(@Param("id") Integer id);
}