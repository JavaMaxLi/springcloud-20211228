package com.bean.user;

import java.io.Serializable;

/**
 * @author LiXiaoFeng
 * @date 2021年12月29日 09:45
 */
public class User implements Serializable {

    /**
     * 主键
     */
    private Integer puk;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 数据库来源
     */
    private String fromDatabase;

    public String getFromDatabase() {
        return fromDatabase;
    }

    public void setFromDatabase(String fromDatabase) {
        this.fromDatabase = fromDatabase;
    }

    public Integer getPuk() {
        return puk;
    }

    public void setPuk(Integer puk) {
        this.puk = puk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "User{" +
                "puk=" + puk +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", idCard='" + idCard + '\'' +
                ", fromDatabase='" + fromDatabase + '\'' +
                '}';
    }
}
