package com.platform.modules.enterprise.entity;

import java.util.Date;
import java.util.Map;

/**
 * @ClassName BankInfo
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/18 14:55
 **/
public class BankInfo {

    private String accountName;

    private String accountNumber;

    private int applyStatus;

    private Map<String,Object> applyStatusHistory;

    private int channelType;

    private String cityId;

    private String cityName;

    private String comment;

    private Date createTimeInMillis;

    private String entId;

    private Handler handler;

    private String handlerEmail;

    private String handlerId;

    private String handlerName;

    private String handlerPhoneNo;

    private String name;

    private String number;

    private String occBankChildCode;

    private String occBankChildName;

    private String occBankCnap;

    private String occBankCode;

    private String occBankName;

    private String provinceId;

    private String provinceName;

    private int source;

    private int type;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Map<String, Object> getApplyStatusHistory() {
        return applyStatusHistory;
    }

    public void setApplyStatusHistory(Map<String, Object> applyStatusHistory) {
        this.applyStatusHistory = applyStatusHistory;
    }

    public int getChannelType() {
        return channelType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTimeInMillis() {
        return createTimeInMillis;
    }

    public void setCreateTimeInMillis(Date createTimeInMillis) {
        this.createTimeInMillis = createTimeInMillis;
    }

    public String getEntId() {
        return entId;
    }

    public void setEntId(String entId) {
        this.entId = entId;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public String getHandlerEmail() {
        return handlerEmail;
    }

    public void setHandlerEmail(String handlerEmail) {
        this.handlerEmail = handlerEmail;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerPhoneNo() {
        return handlerPhoneNo;
    }

    public void setHandlerPhoneNo(String handlerPhoneNo) {
        this.handlerPhoneNo = handlerPhoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOccBankChildCode() {
        return occBankChildCode;
    }

    public void setOccBankChildCode(String occBankChildCode) {
        this.occBankChildCode = occBankChildCode;
    }

    public String getOccBankChildName() {
        return occBankChildName;
    }

    public void setOccBankChildName(String occBankChildName) {
        this.occBankChildName = occBankChildName;
    }

    public String getOccBankCnap() {
        return occBankCnap;
    }

    public void setOccBankCnap(String occBankCnap) {
        this.occBankCnap = occBankCnap;
    }

    public String getOccBankCode() {
        return occBankCode;
    }

    public void setOccBankCode(String occBankCode) {
        this.occBankCode = occBankCode;
    }

    public String getOccBankName() {
        return occBankName;
    }

    public void setOccBankName(String occBankName) {
        this.occBankName = occBankName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
