package org.javaboy.vhr.model;

import java.io.Serializable;
import java.util.List;

public class MemberType implements Serializable {
    private Integer typeId;
    //会员名称
    private String typeName;
    //最低充值数
    private Double rechargeAcount;
    //会员折扣
    private String discount;
    //    会员特权
    private String remark;
    //总额说明
    private String total;
    //    成为会员的条件
    private String conditions;

    private List<String> remarks;
    //总额
    private Double totalMoney;

    public List<String> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<String> remarks) {
        this.remarks = remarks;
    }

    private static final long serialVersionUID = 1L;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getRechargeAcount() {
        return rechargeAcount;
    }

    public void setRechargeAcount(Double rechargeAcount) {
        this.rechargeAcount = rechargeAcount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
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
        MemberType other = (MemberType) that;
        return (getTypeId() == null ? other.getTypeId() == null : getTypeId().equals(other.getTypeId()))
                && (getTypeName() == null ? other.getTypeName() == null : getTypeName().equals(other.getTypeName()))
                && (getRechargeAcount() == null ? other.getRechargeAcount() == null : getRechargeAcount().equals(other.getRechargeAcount()))
                && (getDiscount() == null ? other.getDiscount() == null : getDiscount().equals(other.getDiscount()))
                && (getRemark() == null ? other.getRemark() == null : getRemark().equals(other.getRemark()))
                && (getTotal() == null ? other.getTotal() == null : getTotal().equals(other.getTotal()))
                && (getConditions() == null ? other.getConditions() == null : getConditions().equals(other.getConditions()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getRechargeAcount() == null) ? 0 : getRechargeAcount().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getConditions() == null) ? 0 : getConditions().hashCode());
        return result;
    }


    @Override
    public String toString() {
        return "MemberType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", rechargeAcount=" + rechargeAcount +
                ", discount='" + discount + '\'' +
                ", remark='" + remark + '\'' +
                ", total='" + total + '\'' +
                ", conditions='" + conditions + '\'' +
                ", remarks=" + remarks +
                ", totalMoney=" + totalMoney +
                '}';
    }
}