package org.javaboy.vhr.model;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: wangshichao
 * @Date: 2020/4/22 10:11
 * @Version 1.0
 */
public class salaryCount {
    private String dateTime;

    private String salar;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSalar() {
        return salar;
    }

    public void setSalar(String salar) {
        this.salar = salar;
    }

    @Override
    public String toString() {
        return "salaryCount{" +
                "dateTime='" + dateTime + '\'' +
                ", salar='" + salar + '\'' +
                '}';
    }


}
