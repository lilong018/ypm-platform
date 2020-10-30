package com.platform.modules.bank.entity;

import com.platform.modules.responseEntity.ChannelInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BankInfoRespond {

    private String id;
    // 账户类型 1 提现户 2 签收户
    private Integer type;
    //银行新增来源 1：企业使命认证 2：银行卡管理
    private Integer source;
    //银行名称
    private String name;
    //银行行号
    private String number;
    //开户账户名
    private String accountName;
    //开户账号
    private String accountNumber;
    //
    private String handlerName;

    private String handlerId;

    private String handlerPhoneNo;

    private String handlerEmail;

    private String handlerIdPicFrontUrl;

    private String handlerIdPicBackUrl;

    private String occBankCode;

    private String occBankName;

    private String occBankCnap;

    private String occBankChildCode;

    private String occBankChildName;

    private String provinceId;

    private String provinceName;

    private String cityId;

    private String cityName;

    private Date createTimeInMillis;

    private Integer applyStatus;

    private ChannelInfo channelInfo;

    private List<HashMap<String,String>> applyStatusHistory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    public String getHandlerPhoneNo() {
        return handlerPhoneNo;
    }

    public void setHandlerPhoneNo(String handlerPhoneNo) {
        this.handlerPhoneNo = handlerPhoneNo;
    }

    public String getHandlerEmail() {
        return handlerEmail;
    }

    public void setHandlerEmail(String handlerEmail) {
        this.handlerEmail = handlerEmail;
    }

    public String getHandlerIdPicFrontUrl() {
        return handlerIdPicFrontUrl;
    }

    public void setHandlerIdPicFrontUrl(String handlerIdPicFrontUrl) {
        this.handlerIdPicFrontUrl = handlerIdPicFrontUrl;
    }

    public String getHandlerIdPicBackUrl() {
        return handlerIdPicBackUrl;
    }

    public void setHandlerIdPicBackUrl(String handlerIdPicBackUrl) {
        this.handlerIdPicBackUrl = handlerIdPicBackUrl;
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

    public String getOccBankCnap() {
        return occBankCnap;
    }

    public void setOccBankCnap(String occBankCnap) {
        this.occBankCnap = occBankCnap;
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

    public Date getCreateTimeInMillis() {
        return createTimeInMillis;
    }

    public void setCreateTimeInMillis(Date createTimeInMillis) {
        this.createTimeInMillis = createTimeInMillis;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public ChannelInfo getChannelInfo() {
        return channelInfo;
    }

    public void setChannelInfo(ChannelInfo channelInfo) {
        this.channelInfo = channelInfo;
    }

    public List<HashMap<String, String>> getApplyStatusHistory() {
        return applyStatusHistory;
    }

    public void setApplyStatusHistory(List<HashMap<String, String>> applyStatusHistory) {
        this.applyStatusHistory = applyStatusHistory;
    }
}
