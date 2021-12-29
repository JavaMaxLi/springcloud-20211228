package com.bean;

import java.io.Serializable;

/**
 * @author LiXiaoFeng
 * @date 2021年12月29日 09:45
 */
public class User implements Serializable {

    private int puk;
    private String name;
    private int age;
    private String idCard;

    public int getPuk() {
        return puk;
    }

    public void setPuk(int puk) {
        this.puk = puk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
