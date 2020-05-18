package org.javaboy.vhr.model;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/22 22:39
 * @Version 1.0
 */
public class AlipayBeanMem {
    /*商户订单号，必填*/
    private String out_trade_no;
    /*订单名称，必填*/
    private String subject;
    /*付款金额，必填*/
    private String total_amount;
    /*商品描述，可空*/
    private String body;
    /*超时时间参数*/
    private String timeout_express = "10m";
    private String product_code = "FAST_INSTANT_TRADE_PAY";

    private Integer cusId;

    private Integer memberId;

    private Integer clothesId;

    private double balance;
    //    会员类型Id
    private Integer typeId;

    public Integer getCusId() {
        return cusId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public AlipayBeanMem setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public AlipayBeanMem setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public AlipayBeanMem setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
        return this;
    }

    public String getBody() {
        return body;
    }

    public AlipayBeanMem setBody(String body) {
        this.body = body;
        return this;
    }

    public String getTimeout_express() {
        return timeout_express;
    }

    public AlipayBeanMem setTimeout_express(String timeout_express) {
        this.timeout_express = timeout_express;
        return this;
    }

    public String getProduct_code() {
        return product_code;

    }

    public AlipayBeanMem setProduct_code(String product_code) {
        this.product_code = product_code;
        return this;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "AlipayBeanMem{" +
                "out_trade_no='" + out_trade_no + '\'' +
                ", subject='" + subject + '\'' +
                ", total_amount='" + total_amount + '\'' +
                ", body='" + body + '\'' +
                ", timeout_express='" + timeout_express + '\'' +
                ", product_code='" + product_code + '\'' +
                ", cusId=" + cusId +
                ", memberId=" + memberId +
                ", clothesId=" + clothesId +
                ", balance=" + balance +
                ", typeId=" + typeId +
                '}';
    }
}
