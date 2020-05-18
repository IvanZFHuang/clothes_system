package org.javaboy.vhr.model;

import java.io.Serializable;


public class Clock implements Serializable {

    private Integer clockId;

    private String empWorkID;

    private String clockDate;

    private Integer startWork;

    private Integer endWork;

    private String endClockDate;
    /*备注*/
    private String remark;
    //是否请假
    private Integer isLeave;

    //员工姓名
    private String name;

    private static final long serialVersionUID = 1L;


    public Integer getClockId() {
        return clockId;
    }


    public void setClockId(Integer clockId) {
        this.clockId = clockId;
    }


    public String getEmpWorkID() {
        return empWorkID;
    }

    public void setEmpWorkID(String empWorkID) {
        this.empWorkID = empWorkID;
    }

    public String getClockDate() {
        return clockDate;
    }

    public void setClockDate(String clockDate) {
        this.clockDate = clockDate;
    }

    public Integer getStartWork() {
        return startWork;
    }

    public void setStartWork(Integer startWork) {
        this.startWork = startWork;
    }


    public Integer getEndWork() {
        return endWork;
    }


    public void setEndWork(Integer endWork) {
        this.endWork = endWork;
    }

    public String getEndClockDate() {
        return endClockDate;
    }

    public void setEndClockDate(String endClockDate) {
        this.endClockDate = endClockDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsLeave() {
        return isLeave;
    }

    public void setIsLeave(Integer isLeave) {
        this.isLeave = isLeave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clock{" +
                "clockId=" + clockId +
                ", empWorkID='" + empWorkID + '\'' +
                ", clockDate='" + clockDate + '\'' +
                ", startWork=" + startWork +
                ", endWork=" + endWork +
                ", endClockDate='" + endClockDate + '\'' +
                ", remark='" + remark + '\'' +
                ", isLeave=" + isLeave +
                ", name='" + name + '\'' +
                '}';
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
        Clock other = (Clock) that;
        return (getClockId() == null ? other.getClockId() == null : getClockId().equals(other.getClockId()))
                && (getEmpWorkID() == null ? other.getEmpWorkID() == null : getEmpWorkID().equals(other.getEmpWorkID()))
                && (getClockDate() == null ? other.getClockDate() == null : getClockDate().equals(other.getClockDate()))
                && (getStartWork() == null ? other.getStartWork() == null : getStartWork().equals(other.getStartWork()))
                && (getEndWork() == null ? other.getEndWork() == null : getEndWork().equals(other.getEndWork()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClockId() == null) ? 0 : getClockId().hashCode());
        result = prime * result + ((getEmpWorkID() == null) ? 0 : getEmpWorkID().hashCode());
        result = prime * result + ((getClockDate() == null) ? 0 : getClockDate().hashCode());
        result = prime * result + ((getStartWork() == null) ? 0 : getStartWork().hashCode());
        result = prime * result + ((getEndWork() == null) ? 0 : getEndWork().hashCode());
        return result;
    }

}