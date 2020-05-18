package org.javaboy.vhr.model;

import java.io.Serializable;

public class TakeClothesCount implements Serializable {
    private Integer takeId;

    private String takeDate;

    private Integer takeCount;

    private static final long serialVersionUID = 1L;

    public Integer getTakeId() {
        return takeId;
    }

    public void setTakeId(Integer takeId) {
        this.takeId = takeId;
    }

    public String getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(String takeDate) {
        this.takeDate = takeDate;
    }

    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
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
        TakeClothesCount other = (TakeClothesCount) that;
        return (this.getTakeId() == null ? other.getTakeId() == null : this.getTakeId().equals(other.getTakeId()))
            && (this.getTakeDate() == null ? other.getTakeDate() == null : this.getTakeDate().equals(other.getTakeDate()))
            && (this.getTakeCount() == null ? other.getTakeCount() == null : this.getTakeCount().equals(other.getTakeCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTakeId() == null) ? 0 : getTakeId().hashCode());
        result = prime * result + ((getTakeDate() == null) ? 0 : getTakeDate().hashCode());
        result = prime * result + ((getTakeCount() == null) ? 0 : getTakeCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", takeId=").append(takeId);
        sb.append(", takeDate=").append(takeDate);
        sb.append(", takeCount=").append(takeCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}