package org.javaboy.vhr.model;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: wangshichao
 * @Date: 2020/4/22 10:08
 * @Version 1.0
 */
public class cloCount {

    private String dateTime;

    private String clothCount;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getClothCount() {
        return clothCount;
    }

    public void setClothCount(String clothCount) {
        this.clothCount = clothCount;
    }


    @Override
    public String toString() {
        return "cloCount{" +
                "dateTime='" + dateTime + '\'' +
                ", clothCount='" + clothCount + '\'' +
                '}';
    }




}
