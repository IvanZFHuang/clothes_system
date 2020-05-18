package org.javaboy.vhr.model;

/**
 * @Description: 衣服的详细信息
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/16 23:06
 * @Version 1.0
 */
public class ClothesDetail {
    private Integer clothesId;

    private String clothesColor;

    private String clothesNum;

    private String clothesFlow;

    private String clothesAdjunct;

    private String clothesBrand;

    private String typeName;

    private Integer typePrice;
    private String cusName;

    private String cusEmail;

    private String cusAddress;

    private String cusPhone;

    private String memTypeName;
    //最低充值数
    private Double rechargeAcount;
    //会员折扣
    private String discount;
    //    会员特权
    private String remark;
    //总额说明
    private String total;
    //总额
    private Double totalMoney;

    private String memberNum;

    private Double balance;

    private String name;

    /**
     * 预计完成时间
     */
    private String preTime;

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
    /**
     * 实际收费
     */
    private Double realPrice;

    private Integer isPay;

    private Integer cusId;

    private Integer memberId;
    private Integer isTake;

    private String washReason;

    private String foundReason;

    private double foundAmount;

    public String getWashReason() {
        return washReason;
    }

    public void setWashReason(String washReason) {
        this.washReason = washReason;
    }

    public String getFoundReason() {
        return foundReason;
    }

    public void setFoundReason(String foundReason) {
        this.foundReason = foundReason;
    }

    public double getFoundAmount() {
        return foundAmount;
    }

    public void setFoundAmount(double foundAmount) {
        this.foundAmount = foundAmount;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypePrice() {
        return typePrice;
    }

    public void setTypePrice(Integer typePrice) {
        this.typePrice = typePrice;
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

    public String getMemTypeName() {
        return memTypeName;
    }

    public void setMemTypeName(String memTypeName) {
        this.memTypeName = memTypeName;
    }

    public Double getRechargeAcount() {
        return rechargeAcount;
    }

    public void setRechargeAcount(Double rechargeAcount) {
        this.rechargeAcount = rechargeAcount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getIsTake() {
        return isTake;
    }

    public void setIsTake(Integer isTake) {
        this.isTake = isTake;
    }

    @Override
    public String toString() {
        return "ClothesDetail{" +
                "clothesId=" + clothesId +
                ", clothesColor='" + clothesColor + '\'' +
                ", clothesNum='" + clothesNum + '\'' +
                ", clothesFlow='" + clothesFlow + '\'' +
                ", clothesAdjunct='" + clothesAdjunct + '\'' +
                ", clothesBrand='" + clothesBrand + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typePrice=" + typePrice +
                ", cusName='" + cusName + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusPhone='" + cusPhone + '\'' +
                ", memTypeName='" + memTypeName + '\'' +
                ", rechargeAcount=" + rechargeAcount +
                ", discount='" + discount + '\'' +
                ", remark='" + remark + '\'' +
                ", total='" + total + '\'' +
                ", totalMoney=" + totalMoney +
                ", memberNum='" + memberNum + '\'' +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                ", preTime='" + preTime + '\'' +
                ", putClothesTime='" + putClothesTime + '\'' +
                ", takeClothesTime='" + takeClothesTime + '\'' +
                ", progress='" + progress + '\'' +
                ", realPrice=" + realPrice +
                ", isPay=" + isPay +
                ", cusId=" + cusId +
                ", memberId=" + memberId +
                '}';
    }
}
