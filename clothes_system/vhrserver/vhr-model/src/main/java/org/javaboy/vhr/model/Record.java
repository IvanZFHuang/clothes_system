package org.javaboy.vhr.model;

import java.io.Serializable;

public class Record implements Serializable {
    private Integer recordId;

    private Integer cusId;

    private Integer memId;

    private String recordTime;

    private Double recordMoney;

    private String recordDetail;

    private Customer customer;

    private Member member;
    //衣服id
    private Integer clothesId;

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    private static final long serialVersionUID = 1L;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public Double getRecordMoney() {
        return recordMoney;
    }

    public void setRecordMoney(Double recordMoney) {
        this.recordMoney = recordMoney;
    }

    public String getRecordDetail() {
        return recordDetail;
    }

    public void setRecordDetail(String recordDetail) {
        this.recordDetail = recordDetail;
    }

    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
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
        Record other = (Record) that;
        return (getRecordId() == null ? other.getRecordId() == null : getRecordId().equals(other.getRecordId()))
                && (getCusId() == null ? other.getCusId() == null : getCusId().equals(other.getCusId()))
                && (getMemId() == null ? other.getMemId() == null : getMemId().equals(other.getMemId()))
                && (getRecordTime() == null ? other.getRecordTime() == null : getRecordTime().equals(other.getRecordTime()))
                && (getRecordMoney() == null ? other.getRecordMoney() == null : getRecordMoney().equals(other.getRecordMoney()))
                && (getRecordDetail() == null ? other.getRecordDetail() == null : getRecordDetail().equals(other.getRecordDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordId() == null) ? 0 : getRecordId().hashCode());
        result = prime * result + ((getCusId() == null) ? 0 : getCusId().hashCode());
        result = prime * result + ((getMemId() == null) ? 0 : getMemId().hashCode());
        result = prime * result + ((getRecordTime() == null) ? 0 : getRecordTime().hashCode());
        result = prime * result + ((getRecordMoney() == null) ? 0 : getRecordMoney().hashCode());
        result = prime * result + ((getRecordDetail() == null) ? 0 : getRecordDetail().hashCode());
        return result;
    }


    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", cusId=" + cusId +
                ", memId=" + memId +
                ", recordTime='" + recordTime + '\'' +
                ", recordMoney=" + recordMoney +
                ", recordDetail='" + recordDetail + '\'' +
                ", customer=" + customer +
                ", member=" + member +
                ", clothesId=" + clothesId +
                '}';
    }
}