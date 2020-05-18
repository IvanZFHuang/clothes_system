package org.javaboy.vhr.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sir.song
 * ajax工具类用于返回ajax请求的响应，继承HashMap，本身即hashmap
 */
public class AjaxRusult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static AjaxRusult error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static AjaxRusult error(String msg) {
        return error(500, msg);
    }

    public static AjaxRusult error(int code, String msg) {
        AjaxRusult ajaxRusult = new AjaxRusult();
        ajaxRusult.put("code", code);
        ajaxRusult.put("msg", msg);
        return ajaxRusult;
    }

    public static AjaxRusult ok(String msg) {
        AjaxRusult ajaxRusult = new AjaxRusult();
        ajaxRusult.put("msg", msg);
        return ajaxRusult;
    }

    public static AjaxRusult ok(Map<String, Object> map) {
        AjaxRusult ajaxRusult = new AjaxRusult();
        ajaxRusult.putAll(map);
        return ajaxRusult;
    }

    public static AjaxRusult ok() {
        return new AjaxRusult();
    }

    @Override
    public AjaxRusult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}