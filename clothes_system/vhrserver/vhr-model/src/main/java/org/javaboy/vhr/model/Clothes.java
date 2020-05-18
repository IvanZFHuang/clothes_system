package org.javaboy.vhr.model;

import java.io.Serializable;

public class Clothes implements Serializable {
    private Integer clothesId;

    private String clothesColor;

    private String clothesNum;

    private Integer customerId;

    /**
     * 衣服瑕疵
     */
    private String clothesFlow;

    /**
     * 衣服附件
     */
    private String clothesAdjunct;

    private String clothesBrand;

    private Integer empId;
    /**
     * 收衣时间
     */
    private String putClothesTime;
    /**
     * 取衣时间
     */
    private String takeClothesTime;
    /**
     * 洗衣进度
     */
    private String progress;

    private String preTime;
    /**
     * 实际收费
     */
    private Double realPrice;

    private Integer typeId;

    private Integer isPay;

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public String getPreTime() {
        return preTime;
    }

    public void setPreTime(String preTime) {
        this.preTime = preTime;
    }

    private static final long serialVersionUID = 1L;

    public String getPutClothesTime() {
        return putClothesTime;
    }

    public void setPutClothesTime(String putClothesTime) {
        this.putClothesTime = putClothesTime;
    }

    public String getTakeClothesTime() {
        return takeClothesTime;
    }

    public void setTakeClothesTime(String takeClothesTime) {
        this.takeClothesTime = takeClothesTime;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getClothesId() {
        return clothesId;
    }

    public void setClothesId(Integer clothesId) {
        this.clothesId = clothesId;
    }

    public String getClothesColor() {
        return clothesColor;
    }

    public void setClothesColor(String clothesColor) {
        this.clothesColor = clothesColor;
    }

    public String getClothesNum() {
        return clothesNum;
    }

    public void setClothesNum(String clothesNum) {
        this.clothesNum = clothesNum;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getClothesFlow() {
        return clothesFlow;
    }

    public void setClothesFlow(String clothesFlow) {
        this.clothesFlow = clothesFlow;
    }

    public String getClothesAdjunct() {
        return clothesAdjunct;
    }

    public void setClothesAdjunct(String clothesAdjunct) {
        this.clothesAdjunct = clothesAdjunct;
    }

    public String getClothesBrand() {
        return clothesBrand;
    }

    public void setClothesBrand(String clothesBrand) {
        this.clothesBrand = clothesBrand;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
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
        Clothes other = (Clothes) that;
        return (getClothesId() == null ? other.getClothesId() == null : getClothesId().equals(other.getClothesId()))
                && (getClothesColor() == null ? other.getClothesColor() == null : getClothesColor().equals(other.getClothesColor()))
                && (getClothesNum() == null ? other.getClothesNum() == null : getClothesNum().equals(other.getClothesNum()))
                && (getCustomerId() == null ? other.getCustomerId() == null : getCustomerId().equals(other.getCustomerId()))
                && (getClothesFlow() == null ? other.getClothesFlow() == null : getClothesFlow().equals(other.getClothesFlow()))
                && (getClothesAdjunct() == null ? other.getClothesAdjunct() == null : getClothesAdjunct().equals(other.getClothesAdjunct()))
                && (getClothesBrand() == null ? other.getClothesBrand() == null : getClothesBrand().equals(other.getClothesBrand()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClothesId() == null) ? 0 : getClothesId().hashCode());
        result = prime * result + ((getClothesColor() == null) ? 0 : getClothesColor().hashCode());
        result = prime * result + ((getClothesNum() == null) ? 0 : getClothesNum().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getClothesFlow() == null) ? 0 : getClothesFlow().hashCode());
        result = prime * result + ((getClothesAdjunct() == null) ? 0 : getClothesAdjunct().hashCode());
        result = prime * result + ((getClothesBrand() == null) ? 0 : getClothesBrand().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "clothesId=" + clothesId +
                ", clothesColor='" + clothesColor + '\'' +
                ", clothesNum='" + clothesNum + '\'' +
                ", customerId=" + customerId +
                ", clothesFlow='" + clothesFlow + '\'' +
                ", clothesAdjunct='" + clothesAdjunct + '\'' +
                ", clothesBrand='" + clothesBrand + '\'' +
                ", empId=" + empId +
                ", putClothesTime='" + putClothesTime + '\'' +
                ", takeClothesTime='" + takeClothesTime + '\'' +
                ", progress='" + progress + '\'' +
                ", preTime='" + preTime + '\'' +
                ", realPrice=" + realPrice +
                ", typeId=" + typeId +
                ", isPay=" + isPay +
                '}';
    }
}