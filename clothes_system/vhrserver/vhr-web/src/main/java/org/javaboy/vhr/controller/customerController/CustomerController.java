package org.javaboy.vhr.controller.customerController;

import org.javaboy.vhr.model.Customer;
import org.javaboy.vhr.service.CustomerService;
import org.javaboy.vhr.utils.AjaxRusult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/7 13:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/customer/basic")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    /**
     * @return
     * @Date 2020/4/7 14:38
     * @Author jiangheng
     * @Description //TODO 查询该手机号是否注册过
     **/
    @RequestMapping("/getCountByPhone")
    public AjaxRusult getCountByPhone(String phone) {
        return customerService.getCountByPhone(phone);
    }

    /**
     * @return
     * @Date 2020/4/7 14:39
     * @Author jiangheng
     * @Description //TODO  添加顾客
     **/
    @PostMapping("/insertCus")
    public AjaxRusult insertCus(@RequestBody Customer customer) {
        return customerService.insertCus(customer);
    }

    /**
     * @return
     * @Date 2020/4/18 23:29
     * @Author jiangheng
     * @Description //TODO 查询所有的顾客
     **/
    @RequestMapping("/listCustomer")
    public AjaxRusult listCustomer() {
        return AjaxRusult.ok().put("obj", customerService.listCustomer());
    }

    /**
     * @return
     * @Date 2020/4/19 22:10
     * @Author jiangheng
     * @Description //TODO 根据id 查询
     **/
    @RequestMapping("/selectCustomer")
    public Map<String, Object> selectCustomer(Integer customerId, Integer price) {
        return customerService.selectCustomer(customerId, price);
    }

}
