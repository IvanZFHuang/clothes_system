package org.javaboy.vhr.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer cusId;

    private String cusName;

    private String cusEmail;

    private String cusAddress;

    private String cusPhone;

    private static final long serialVersionUID = 1L;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
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

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
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
        Customer other = (Customer) that;
        return (this.getCusId() == null ? other.getCusId() == null : this.getCusId().equals(other.getCusId()))
            && (this.getCusName() == null ? other.getCusName() == null : this.getCusName().equals(other.getCusName()))
            && (this.getCusEmail() == null ? other.getCusEmail() == null : this.getCusEmail().equals(other.getCusEmail()))
            && (this.getCusAddress() == null ? other.getCusAddress() == null : this.getCusAddress().equals(other.getCusAddress()))
            && (this.getCusPhone() == null ? other.getCusPhone() == null : this.getCusPhone().equals(other.getCusPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCusId() == null) ? 0 : getCusId().hashCode());
        result = prime * result + ((getCusName() == null) ? 0 : getCusName().hashCode());
        result = prime * result + ((getCusEmail() == null) ? 0 : getCusEmail().hashCode());
        result = prime * result + ((getCusAddress() == null) ? 0 : getCusAddress().hashCode());
        result = prime * result + ((getCusPhone() == null) ? 0 : getCusPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cusId=").append(cusId);
        sb.append(", cusName=").append(cusName);
        sb.append(", cusEmail=").append(cusEmail);
        sb.append(", cusAddress=").append(cusAddress);
        sb.append(", cusPhone=").append(cusPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}