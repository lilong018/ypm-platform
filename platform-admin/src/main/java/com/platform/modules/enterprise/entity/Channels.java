package com.platform.modules.enterprise.entity;

import java.util.Map;

/**
 * @ClassName Channels
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/18 14:52
 **/
public class Channels {
    private Map<String,BankInfo> banks;
    private int type;

    public Map<String, BankInfo> getBanks() {
        return banks;
    }

    public void setBanks(Map<String, BankInfo> banks) {
        this.banks = banks;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Channels{" +
                "banks=" + banks +
                ", type=" + type +
                '}';
    }
}
