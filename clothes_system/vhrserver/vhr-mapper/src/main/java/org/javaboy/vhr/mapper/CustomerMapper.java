package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Customer;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer cusId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer cusId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    /**
     * @return
     * @Date 2020/4/7 13:43
     * @Author jiangheng
     * @Description //TODO根据手机号查询是否注册过
     **/
    Integer getCountByPhone(@Param("phone") String phone);

    /**
     * @return
     * @Date 2020/4/7 15:24
     * @Author jiangheng
     * @Description //TODO 根据手机号查询id
     **/
    int selectByPhone(@Param("cusPhone") String cusPhone);

    /**
     * @return
     * @Date 2020/4/18 23:24
     * @Author jiangheng
     **/
    List<Customer> listCustomer();
}