package com.platform.modules.enterprise.entity;

import java.util.Map;

/**
 * @ClassName Channels
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/18 14:52
 * @Update： 2020/10/31 10:12
 **/
public class Channels {
    private Map<String,BankInfo> banks;
    private Integer type;
    private Integer validEnt;
    private Integer entRole;

    public Map<String, BankInfo> getBanks() {
        return banks;
    }

    public void setBanks(Map<String, BankInfo> banks) {
        this.banks = banks;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValidEnt() {
        return validEnt;
    }

    public void setValidEnt(Integer validEnt) {
        this.validEnt = validEnt;
    }

    public Integer getEntRole() {
        return entRole;
    }

    public void setEntRole(Integer entRole) {
        this.entRole = entRole;
    }

    @Override
    public String toString() {
        return "Channels{" +
                "banks=" + banks +
                ", type=" + type +
                ", validEnt=" + validEnt +
                ", entRole=" + entRole +
                '}';
    }

}
