package org.javaboy.vhr.model;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/2 17:41
 * @Version 1.0
 */
public class Type {
    private int id;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                '}';
    }
}
