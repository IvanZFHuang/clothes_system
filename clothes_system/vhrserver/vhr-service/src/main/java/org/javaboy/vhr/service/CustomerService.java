package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.CustomerMapper;
import org.javaboy.vhr.mapper.MemberMapper;
import org.javaboy.vhr.model.Customer;
import org.javaboy.vhr.model.MemberDetailInfo;
import org.javaboy.vhr.utils.AjaxRusult;
import org.javaboy.vhr.utils.PriceUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/7 13:40
 * @Version 1.0
 */
@Service
public class CustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private MemberMapper memberMapper;

    /**
     * @return
     * @Date 2020/4/7 13:41
     * @Author jiangheng
     * @Description //TODO 根据手机号查询是否已经注册过
     **/
    public AjaxRusult getCountByPhone(String phone) {
        return AjaxRusult.ok().put("obj", customerMapper.getCountByPhone(phone));
    }

    public AjaxRusult insertCus(Customer customer) {
        int count = customerMapper.insertSelective(customer);
        int customerId = customerMapper.selectByPhone(customer.getCusPhone());
        if (count > 0) {
            return AjaxRusult.ok().put("obj", customerId);
        } else {
            return AjaxRusult.error(500, "添加失败");
        }
    }

    /**
     * @return
     * @Date 2020/4/18 23:24
     * @Author jiangheng
     **/
    public List<Customer> listCustomer() {
        return customerMapper.listCustomer();
    }

    /**
     * @return
     * @Date 2020/4/19 22:18
     * @Author jiangheng
     * @Description //TODO 查询客户
     **/
    public Map<String, Object> selectCustomer(Integer customerId, Integer price) {
        MemberDetailInfo memberDetailInfo = memberMapper.selectMember(customerId);
        double realPrice = PriceUtil.getRealPrice(price, memberDetailInfo.getMemberType().getDiscount());
        Map<String, Object> map = new HashMap<>();
        map.put("obj", memberDetailInfo);
        map.put("obj1", realPrice);
        return map;
    }
}
