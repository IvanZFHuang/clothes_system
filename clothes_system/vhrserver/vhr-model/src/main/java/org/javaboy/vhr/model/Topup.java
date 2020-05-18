package org.javaboy.vhr.model;

import java.io.Serializable;

public class Topup implements Serializable {
    private Integer topupId;

    private String topupTime;

    private Double topupMoney;

    private Integer cusId;

    private Integer memberId;

    private Customer customer;

    private Member member;

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private static final long serialVersionUID = 1L;

    public Integer getTopupId() {
        return topupId;
    }

    public void setTopupId(Integer topupId) {
        this.topupId = topupId;
    }

    public String getTopupTime() {
        return topupTime;
    }

    public void setTopupTime(String topupTime) {
        this.topupTime = topupTime;
    }

    public Double getTopupMoney() {
        return topupMoney;
    }

    public void setTopupMoney(Double topupMoney) {
        this.topupMoney = topupMoney;
    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Topup other = (Topup) that;
        return (getTopupId() == null ? other.getTopupId() == null : getTopupId().equals(other.getTopupId()))
                && (getTopupTime() == null ? other.getTopupTime() == null : getTopupTime().equals(other.getTopupTime()))
                && (getTopupMoney() == null ? other.getTopupMoney() == null : getTopupMoney().equals(other.getTopupMoney()))
                && (getCusId() == null ? other.getCusId() == null : getCusId().equals(other.getCusId()))
                && (getMemberId() == null ? other.getMemberId() == null : getMemberId().equals(other.getMemberId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTopupId() == null) ? 0 : getTopupId().hashCode());
        result = prime * result + ((getTopupTime() == null) ? 0 : getTopupTime().hashCode());
        result = prime * result + ((getTopupMoney() == null) ? 0 : getTopupMoney().hashCode());
        result = prime * result + ((getCusId() == null) ? 0 : getCusId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        return result;
    }


    @Override
    public String toString() {
        return "Topup{" +
                "topupId=" + topupId +
                ", topupTime='" + topupTime + '\'' +
                ", topupMoney=" + topupMoney +
                ", cusId=" + cusId +
                ", memberId=" + memberId +
                ", customer=" + customer +
                ", member=" + member +
                '}';
    }
}