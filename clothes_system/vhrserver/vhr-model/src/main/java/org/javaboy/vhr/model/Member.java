package org.javaboy.vhr.model;

import java.io.Serializable;

public class Member implements Serializable {
    private Integer memberId;

    private String memberNum;

    private Integer typeId;

    private Integer customId;

    private String createTime;

    private Integer isLogout;

    private Double balance;

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    private static final long serialVersionUID = 1L;

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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCustomId() {
        return customId;
    }

    public void setCustomId(Integer customId) {
        this.customId = customId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getIsLogout() {
        return isLogout;
    }

    public void setIsLogout(Integer isLogout) {
        this.isLogout = isLogout;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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
        Member other = (Member) that;
        return (getMemberId() == null ? other.getMemberId() == null : getMemberId().equals(other.getMemberId()))
                && (getMemberNum() == null ? other.getMemberNum() == null : getMemberNum().equals(other.getMemberNum()))
                && (getTypeId() == null ? other.getTypeId() == null : getTypeId().equals(other.getTypeId()))
                && (getCustomId() == null ? other.getCustomId() == null : getCustomId().equals(other.getCustomId()))
                && (getCreateTime() == null ? other.getCreateTime() == null : getCreateTime().equals(other.getCreateTime()))
                && (getIsLogout() == null ? other.getIsLogout() == null : getIsLogout().equals(other.getIsLogout()))
                && (getBalance() == null ? other.getBalance() == null : getBalance().equals(other.getBalance()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getMemberNum() == null) ? 0 : getMemberNum().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getCustomId() == null) ? 0 : getCustomId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsLogout() == null) ? 0 : getIsLogout().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        return result;
    }


    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberNum='" + memberNum + '\'' +
                ", typeId=" + typeId +
                ", customId=" + customId +
                ", createTime='" + createTime + '\'' +
                ", isLogout=" + isLogout +
                ", balance=" + balance +
                '}';
    }
}