package org.javaboy.vhr.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/3/31 22:21
 * @Version 1.0
 */
public class FormatDateUtil {

    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = format.format(new Date());
        return formatDate;
    }
}
