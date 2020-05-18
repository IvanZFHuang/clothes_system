package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Integer maxWorkID();

    Integer addEmps(@Param("list") List<Employee> list);

    Employee getEmployeeById(Integer id);

    List<Employee> getEmployeeByPageWithSalary(@Param("page") Integer page, @Param("size") Integer size);

    Integer updateEmployeeSalaryById(@Param("eid") Integer eid, @Param("sid") Integer sid);

    /**
     * @return
     * @Date 2020/3/27 11:04
     * @Author jiangheng
     * @Description //TODO  查询刚入职的员工姓名和 工号
     **/
    List<Employee> selectIsEntry();


    int getId(@Param("workID") String workID);

    /**
     * @return
     * @Date 2020/3/27 15:23
     * @Author jiangheng
     * @Description //TODO 修改入职状态
     **/
    void updateIsEntry(@Param("userid") int userid);

    /**
     * @return 逻辑删除
     * @Date 2020/3/27 21:12
     * @Author jiangheng
     * @Description //TODO
     **/
    Integer delete(@Param("id") Integer id);

    /**
     * @return
     * @Date 2020/3/30 15:51
     * @Author jiangheng
     * @Description //TODO 查询所有的员工信息
     **/
    List<Employee> listEmployee();

    /**
     * @return
     * @Date 2020/3/30 16:32
     * @Author jiangheng
     * @Description //TODO 根据workID 查询是否上班
     **/
    Integer clock(@Param("workID") String workID);

    /**
     * @return
     * @Date 2020/3/30 17:45
     * @Author jiangheng
     * @Description //TODO 打卡的操作
     **/
    Integer updateClock(@Param("workID") Object workID, @Param("isClock") Object isClock);

    /**
     * @return
     * @Date 2020/3/31 15:15
     * @Author jiangheng
     * @Description //TODO 根据工号查询姓名
     **/
    String getNameByWorkId(@Param("workID") String workID);

}