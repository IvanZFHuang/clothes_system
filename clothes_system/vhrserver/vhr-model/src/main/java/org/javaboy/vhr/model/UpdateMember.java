package org.javaboy.vhr.model;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/7 20:49
 * @Version 1.0
 */
public class UpdateMember {
    private Integer memberId;

    private String memberNum;

    private String cusName;

    private String cusEmail;


    private String cusPhone;

    //总额说明
    private String total;

    private Integer cusId;

    public Integer getCusId() {
        return cusId;
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

    public String getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }


    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "UpdateMember{" +
                "memberId=" + memberId +
                ", memberNum='" + memberNum + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", cusPhone='" + cusPhone + '\'' +
                ", total='" + total + '\'' +
                ", cusId=" + cusId +
                '}';
    }
}
