package org.javaboy.vhr.model;

import java.io.Serializable;

public class Rewash implements Serializable {
    private Integer reId;

    private Integer clothesId;

    private String reason;

    private String preTime;


    public String getPreTime() {
        return preTime;
    }

    public void setPreTime(String preTime) {
        this.preTime = preTime;
    }

    private static final long serialVersionUID = 1L;

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
        Rewash other = (Rewash) that;
        return (getReId() == null ? other.getReId() == null : getReId().equals(other.getReId()))
                && (getClothesId() == null ? other.getClothesId() == null : getClothesId().equals(other.getClothesId()))
                && (getReason() == null ? other.getReason() == null : getReason().equals(other.getReason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReId() == null) ? 0 : getReId().hashCode());
        result = prime * result + ((getClothesId() == null) ? 0 : getClothesId().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reId=").append(reId);
        sb.append(", clothesId=").append(clothesId);
        sb.append(", reason=").append(reason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}