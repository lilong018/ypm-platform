package com.platform.modules.enterprise.entity;

/**
 * @ClassName ChannelVo
 * @Deacription TODO
 * @Author lilong
 * @Date 2020/10/31 11:40
 * @Version 1.0
 **/
public class ChannelVo {
    private Integer type;
    private Integer validEnt;
    private Integer entRole;
    private String bankId;
    private String bankName;
    private String bankNumber;
    private String bankAccountNumber;
    private String bankAccountName;
    private Integer bankType;
    private Integer bankStatus;

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

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    public Integer getBankStatus() {
        return bankStatus;
    }

    public void setBankStatus(Integer bankStatus) {
        this.bankStatus = bankStatus;
    }
}
