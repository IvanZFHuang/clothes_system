package org.javaboy.vhr.model;

import java.io.Serializable;

public class TakeClothes implements Serializable {
    private Integer takeId;

    private Integer clothesId;

    private String takeTime;

    private static final long serialVersionUID = 1L;

    public Integer getTakeId() {
        return takeId;
    }

    public void setTakeId(Integer takeId) {
        this.takeId = takeId;
    }

    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    public String getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(String takeTime) {
        this.takeTime = takeTime;
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
        TakeClothes other = (TakeClothes) that;
        return (this.getTakeId() == null ? other.getTakeId() == null : this.getTakeId().equals(other.getTakeId()))
            && (this.getClothesId() == null ? other.getClothesId() == null : this.getClothesId().equals(other.getClothesId()))
            && (this.getTakeTime() == null ? other.getTakeTime() == null : this.getTakeTime().equals(other.getTakeTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTakeId() == null) ? 0 : getTakeId().hashCode());
        result = prime * result + ((getClothesId() == null) ? 0 : getClothesId().hashCode());
        result = prime * result + ((getTakeTime() == null) ? 0 : getTakeTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", takeId=").append(takeId);
        sb.append(", clothesId=").append(clothesId);
        sb.append(", takeTime=").append(takeTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}