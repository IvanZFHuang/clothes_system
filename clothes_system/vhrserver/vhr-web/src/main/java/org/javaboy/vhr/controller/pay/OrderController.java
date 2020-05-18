package org.javaboy.vhr.controller.pay;

import com.alipay.api.AlipayApiException;
import org.javaboy.vhr.mapper.MemberTypeMapper;
import org.javaboy.vhr.model.AlipayBean;
import org.javaboy.vhr.model.AlipayBeanMem;
import org.javaboy.vhr.model.MemberType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/8 17:54
 * @Version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private PayService payService;//调用支付服务
    @Resource
    private MemberTypeMapper memberTypeMapper;

    /*阿里支付*/
//    @ResponseBody
//    @PostMapping(value = "/alipay")
//    public String alipay(String out_trade_no, String subject, String total_amount, String body) throws AlipayApiException {
//
//        return payService.aliPay(new AlipayBean()
//                .setBody(body)
//                .setOut_trade_no(out_trade_no)
//                .setTotal_amount(new StringBuffer().append(total_amount))
//                .setSubject(subject));
//    }

    /*阿里支付*/
    @ResponseBody
    @PostMapping(value = "/alipay")
    public String alipay(@RequestBody AlipayBean alipayBean) throws AlipayApiException {
        alipayBean.setOut_trade_no(System.currentTimeMillis() + "");
        return payService.aliPay(alipayBean);
    }

    /*阿里支付*/
    @ResponseBody
    @PostMapping(value = "/upMem")
    public String upMem(@RequestBody AlipayBeanMem alipayBeanMem) throws AlipayApiException {
        alipayBeanMem.setOut_trade_no(System.currentTimeMillis() + "");
        int typeId = alipayBeanMem.getTypeId();
        MemberType memberType = memberTypeMapper.selectByPrimaryKey(typeId);
        alipayBeanMem.setSubject(memberType.getTypeName());
        return payService.upmoney(alipayBeanMem);
    }

    @RequestMapping("/orderPage")
    public String getOrder() {
        return "orderPage";
    }
}

