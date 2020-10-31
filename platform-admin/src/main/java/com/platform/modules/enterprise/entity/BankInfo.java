package com.platform.modules.enterprise.entity;

import com.platform.modules.responseEntity.ChannelInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BankInfo
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/18 14:55
 **/
public class BankInfo {

    private Handler handler;

    private List<AuditResult> auditResult;

    private String comment;

    private Integer type;

    private Integer source;

    private String name;

    private String number;

    private String accountName;

    private String accountNumber;

    private String handlerName;

    private String handlerPhoneNo;

    private String handlerId;

    private String handlerEmail;

    private String handlerIdPicFrontUrl;//暂留字段

    private String handlerIdPicBackUrl;//暂留字段

    private String occBankChildCode;

    private String occBankChildName;

    private String occBankCnap;

    private String occBankCode;

    private String occBankName;

    private String provinceId;

    private String provinceName;

    private String cityId;

    private String cityName;

    private Integer applyStatus;

    private Date createTimeInMillis;

    private ChannelInfo channelInfo;

    private Map<String,ApplyStatus> applyStatusHistory;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public List<AuditResult> getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(List<AuditResult> auditResult) {
        this.auditResult = auditResult;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getHandlerPhoneNo() {
        return handlerPhoneNo;
    }

    public void setHandlerPhoneNo(String handlerPhoneNo) {
        this.handlerPhoneNo = handlerPhoneNo;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
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

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Date getCreateTimeInMillis() {
        return createTimeInMillis;
    }

    public void setCreateTimeInMillis(Date createTimeInMillis) {
        this.createTimeInMillis = createTimeInMillis;
    }

    public ChannelInfo getChannelInfo() {
        return channelInfo;
    }

    public void setChannelInfo(ChannelInfo channelInfo) {
        this.channelInfo = channelInfo;
    }

    public Map<String, ApplyStatus> getApplyStatusHistory() {
        return applyStatusHistory;
    }

    public void setApplyStatusHistory(Map<String, ApplyStatus> applyStatusHistory) {
        this.applyStatusHistory = applyStatusHistory;
    }
}
