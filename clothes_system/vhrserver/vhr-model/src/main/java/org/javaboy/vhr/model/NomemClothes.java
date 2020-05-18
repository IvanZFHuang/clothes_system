package org.javaboy.vhr.model;

/**
 * @Description: 非会员洗衣
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/20 20:48
 * @Version 1.0
 */
public class NomemClothes {
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

    private String cusName;

    private String cusPhone;

    private String cusEmail;

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

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

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

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getPreTime() {
        return preTime;
    }

    public void setPreTime(String preTime) {
        this.preTime = preTime;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    @Override
    public String toString() {
        return "NomemClothes{" +
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
                ", cusName='" + cusName + '\'' +
                ", cusPhone='" + cusPhone + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                '}';
    }
}
