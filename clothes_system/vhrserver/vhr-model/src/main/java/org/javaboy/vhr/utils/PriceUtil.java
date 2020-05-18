package org.javaboy.vhr.utils;

/**
 * @Description: 洗衣价格计算实际价格的工具类
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/20 7:59
 * @Version 1.0
 */
public class PriceUtil {
    public static double getRealPrice(Integer price, String discount) {
        double realPrice = 0.0;
        switch (discount) {
            case "不打折":
                realPrice = price;
                break;
            case "九五折":
                realPrice = price * 0.95;
                break;
            case "九折":
                realPrice = price * 0.9;
                break;
            case "八折":
                realPrice = price * 0.8;
                break;
            case "七折":
                realPrice = price * 0.7;
                break;
        }
        return realPrice;
    }
}
