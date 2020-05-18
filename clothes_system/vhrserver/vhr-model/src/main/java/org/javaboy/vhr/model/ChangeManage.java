package org.javaboy.vhr.model;

import java.io.Serializable;

public class ChangeManage implements Serializable {
    private Integer changeId;
    //当天时间
    private String curentDate;
    //上班or 下班
    private Integer workStatus;
    //    对接信息
    private String overRemark;
    //是否对接
    private Integer isOver;
    //操作人姓名
    private String oparatorName;
    //操作人工号
    private String oparatorWorkid;
    //对接人姓名
    private String overName;
    // 对接人工号
    private String overWorkid;
    //对接时间
    private String overDate;

    private static final long serialVersionUID = 1L;

    public Integer getChangeId() {
        return changeId;
    }

    public void setChangeId(Integer changeId) {
        this.changeId = changeId;
    }

    public String getCurentDate() {
        return curentDate;
    }

    public void setCurentDate(String curentDate) {
        this.curentDate = curentDate;
    }

    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    public String getOverRemark() {
        return overRemark;
    }

    public void setOverRemark(String overRemark) {
        this.overRemark = overRemark;
    }

    public Integer getIsOver() {
        return isOver;
    }

    public void setIsOver(Integer isOver) {
        this.isOver = isOver;
    }

    public String getOparatorName() {
        return oparatorName;
    }

    public void setOparatorName(String oparatorName) {
        this.oparatorName = oparatorName;
    }

    public String getOparatorWorkid() {
        return oparatorWorkid;
    }

    public void setOparatorWorkid(String oparatorWorkid) {
        this.oparatorWorkid = oparatorWorkid;
    }

    public String getOverName() {
        return overName;
    }

    public void setOverName(String overName) {
        this.overName = overName;
    }

    public String getOverWorkid() {
        return overWorkid;
    }

    public void setOverWorkid(String overWorkid) {
        this.overWorkid = overWorkid;
    }

    public String getOverDate() {
        return overDate;
    }

    public void setOverDate(String overDate) {
        this.overDate = overDate;
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
        ChangeManage other = (ChangeManage) that;
        return (getChangeId() == null ? other.getChangeId() == null : getChangeId().equals(other.getChangeId()))
                && (getCurentDate() == null ? other.getCurentDate() == null : getCurentDate().equals(other.getCurentDate()))
                && (getWorkStatus() == null ? other.getWorkStatus() == null : getWorkStatus().equals(other.getWorkStatus()))
                && (getOverRemark() == null ? other.getOverRemark() == null : getOverRemark().equals(other.getOverRemark()))
                && (getIsOver() == null ? other.getIsOver() == null : getIsOver().equals(other.getIsOver()))
                && (getOparatorName() == null ? other.getOparatorName() == null : getOparatorName().equals(other.getOparatorName()))
                && (getOparatorWorkid() == null ? other.getOparatorWorkid() == null : getOparatorWorkid().equals(other.getOparatorWorkid()))
                && (getOverName() == null ? other.getOverName() == null : getOverName().equals(other.getOverName()))
                && (getOverWorkid() == null ? other.getOverWorkid() == null : getOverWorkid().equals(other.getOverWorkid()))
                && (getOverDate() == null ? other.getOverDate() == null : getOverDate().equals(other.getOverDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChangeId() == null) ? 0 : getChangeId().hashCode());
        result = prime * result + ((getCurentDate() == null) ? 0 : getCurentDate().hashCode());
        result = prime * result + ((getWorkStatus() == null) ? 0 : getWorkStatus().hashCode());
        result = prime * result + ((getOverRemark() == null) ? 0 : getOverRemark().hashCode());
        result = prime * result + ((getIsOver() == null) ? 0 : getIsOver().hashCode());
        result = prime * result + ((getOparatorName() == null) ? 0 : getOparatorName().hashCode());
        result = prime * result + ((getOparatorWorkid() == null) ? 0 : getOparatorWorkid().hashCode());
        result = prime * result + ((getOverName() == null) ? 0 : getOverName().hashCode());
        result = prime * result + ((getOverWorkid() == null) ? 0 : getOverWorkid().hashCode());
        result = prime * result + ((getOverDate() == null) ? 0 : getOverDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", changeId=").append(changeId);
        sb.append(", curentDate=").append(curentDate);
        sb.append(", workStatus=").append(workStatus);
        sb.append(", overRemark=").append(overRemark);
        sb.append(", isOver=").append(isOver);
        sb.append(", oparatorName=").append(oparatorName);
        sb.append(", oparatorWorkid=").append(oparatorWorkid);
        sb.append(", overName=").append(overName);
        sb.append(", overWorkid=").append(overWorkid);
        sb.append(", overDate=").append(overDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}