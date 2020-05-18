package org.javaboy.vhr.model;

import java.io.Serializable;

public class Refound implements Serializable {
    private Integer refoundId;

    private String reason;

    private Integer clothesId;

    private String time;

    private Double refoundAmount;

    private static final long serialVersionUID = 1L;

    public Integer getRefoundId() {
        return refoundId;
    }

    public void setRefoundId(Integer refoundId) {
        this.refoundId = refoundId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getRefoundAmount() {
        return refoundAmount;
    }

    public void setRefoundAmount(Double refoundAmount) {
        this.refoundAmount = refoundAmount;
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
        Refound other = (Refound) that;
        return (this.getRefoundId() == null ? other.getRefoundId() == null : this.getRefoundId().equals(other.getRefoundId()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getClothesId() == null ? other.getClothesId() == null : this.getClothesId().equals(other.getClothesId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getRefoundAmount() == null ? other.getRefoundAmount() == null : this.getRefoundAmount().equals(other.getRefoundAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRefoundId() == null) ? 0 : getRefoundId().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getClothesId() == null) ? 0 : getClothesId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getRefoundAmount() == null) ? 0 : getRefoundAmount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", refoundId=").append(refoundId);
        sb.append(", reason=").append(reason);
        sb.append(", clothesId=").append(clothesId);
        sb.append(", time=").append(time);
        sb.append(", refoundAmount=").append(refoundAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}