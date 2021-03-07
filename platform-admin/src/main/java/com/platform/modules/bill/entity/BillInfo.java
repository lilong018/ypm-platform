package com.platform.modules.bill.entity;

import com.platform.modules.bank.entity.BankInfoRespond;
import com.platform.modules.employee.entity.Platform;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName BillInfo
 * @Deacription TODO
 * @Author lilong
 * @Date 2020/10/27 15:01
 * @Version 1.0
 **/
public class BillInfo {
    private String id;
    private Platform platform;
    private String number;
    private Integer type;
    private String drawerName;
    private String draweeName;
    private String acceptingBankName;
    private String acceptingBankNumber;
    private Integer acceptingBankType;
    private double amount;
    private String issueDate;
    private String dueDate;
    private String frontPictureUrl;
    private List<HashMap<String,String >> backPictures;
    private List<Integer> channelType;
    private BankInfoRespond transferBank;
    private BankInfoRespond endorseBank;
    private Integer returnDrawerCount;
    private Integer returnDraweeCount;
    private Integer returnEndorsementCount;
    private Integer doubleEndorsementCount;
    private Integer pledgeCount;
    private Integer guaranteeStatus;
    private Integer inconsistentStatus;
    private String customDefect;
    private Integer endorseCount;
    private boolean isDirectSell;
    private String directBuyerAccount;
    private String feeDeduction;
    private Integer status;
    private Date createTimeInMillis;
    private String publisherId;
    private PublisherBean publisher;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDrawerName() {
        return drawerName;
    }

    public void setDrawerName(String drawerName) {
        this.drawerName = drawerName;
    }

    public String getDraweeName() {
        return draweeName;
    }

    public void setDraweeName(String draweeName) {
        this.draweeName = draweeName;
    }

    public String getAcceptingBankName() {
        return acceptingBankName;
    }

    public void setAcceptingBankName(String acceptingBankName) {
        this.acceptingBankName = acceptingBankName;
    }

    public String getAcceptingBankNumber() {
        return acceptingBankNumber;
    }

    public void setAcceptingBankNumber(String acceptingBankNumber) {
        this.acceptingBankNumber = acceptingBankNumber;
    }

    public Integer getAcceptingBankType() {
        return acceptingBankType;
    }

    public void setAcceptingBankType(Integer acceptingBankType) {
        this.acceptingBankType = acceptingBankType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getFrontPictureUrl() {
        return frontPictureUrl;
    }

    public void setFrontPictureUrl(String frontPictureUrl) {
        this.frontPictureUrl = frontPictureUrl;
    }

    public List<HashMap<String, String>> getBackPictures() {
        return backPictures;
    }

    public void setBackPictures(List<HashMap<String, String>> backPictures) {
        this.backPictures = backPictures;
    }

    public List<Integer> getChannelType() {
        return channelType;
    }

    public void setChannelType(List<Integer> channelType) {
        this.channelType = channelType;
    }

    public BankInfoRespond getTransferBank() {
        return transferBank;
    }

    public void setTransferBank(BankInfoRespond transferBank) {
        this.transferBank = transferBank;
    }

    public BankInfoRespond getEndorseBank() {
        return endorseBank;
    }

    public void setEndorseBank(BankInfoRespond endorseBank) {
        this.endorseBank = endorseBank;
    }

    public Integer getReturnDrawerCount() {
        return returnDrawerCount;
    }

    public void setReturnDrawerCount(Integer returnDrawerCount) {
        this.returnDrawerCount = returnDrawerCount;
    }

    public Integer getReturnDraweeCount() {
        return returnDraweeCount;
    }

    public void setReturnDraweeCount(Integer returnDraweeCount) {
        this.returnDraweeCount = returnDraweeCount;
    }

    public Integer getReturnEndorsementCount() {
        return returnEndorsementCount;
    }

    public void setReturnEndorsementCount(Integer returnEndorsementCount) {
        this.returnEndorsementCount = returnEndorsementCount;
    }

    public Integer getDoubleEndorsementCount() {
        return doubleEndorsementCount;
    }

    public void setDoubleEndorsementCount(Integer doubleEndorsementCount) {
        this.doubleEndorsementCount = doubleEndorsementCount;
    }

    public Integer getPledgeCount() {
        return pledgeCount;
    }

    public void setPledgeCount(Integer pledgeCount) {
        this.pledgeCount = pledgeCount;
    }

    public Integer getGuaranteeStatus() {
        return guaranteeStatus;
    }

    public void setGuaranteeStatus(Integer guaranteeStatus) {
        this.guaranteeStatus = guaranteeStatus;
    }

    public Integer getInconsistentStatus() {
        return inconsistentStatus;
    }

    public void setInconsistentStatus(Integer inconsistentStatus) {
        this.inconsistentStatus = inconsistentStatus;
    }

    public String getCustomDefect() {
        return customDefect;
    }

    public void setCustomDefect(String customDefect) {
        this.customDefect = customDefect;
    }

    public Integer getEndorseCount() {
        return endorseCount;
    }

    public void setEndorseCount(Integer endorseCount) {
        this.endorseCount = endorseCount;
    }

    public boolean isDirectSell() {
        return isDirectSell;
    }

    public void setDirectSell(boolean directSell) {
        isDirectSell = directSell;
    }

    public String getDirectBuyerAccount() {
        return directBuyerAccount;
    }

    public void setDirectBuyerAccount(String directBuyerAccount) {
        this.directBuyerAccount = directBuyerAccount;
    }

    public String getFeeDeduction() {
        return feeDeduction;
    }

    public void setFeeDeduction(String feeDeduction) {
        this.feeDeduction = feeDeduction;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTimeInMillis() {
        return createTimeInMillis;
    }

    public void setCreateTimeInMillis(Date createTimeInMillis) {
        this.createTimeInMillis = createTimeInMillis;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public PublisherBean getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherBean publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "BillInfo{" +
                "id='" + id + '\'' +
                ", platform=" + platform +
                ", number='" + number + '\'' +
                ", type=" + type +
                ", drawerName='" + drawerName + '\'' +
                ", draweeName='" + draweeName + '\'' +
                ", acceptingBankName='" + acceptingBankName + '\'' +
                ", acceptingBankNumber='" + acceptingBankNumber + '\'' +
                ", acceptingBankType=" + acceptingBankType +
                ", amount=" + amount +
                ", issueDate='" + issueDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", frontPictureUrl='" + frontPictureUrl + '\'' +
                ", backPictures=" + backPictures +
                ", channelType=" + channelType +
                ", transferBank=" + transferBank +
                ", endorseBank=" + endorseBank +
                ", returnDrawerCount=" + returnDrawerCount +
                ", returnDraweeCount=" + returnDraweeCount +
                ", returnEndorsementCount=" + returnEndorsementCount +
                ", doubleEndorsementCount=" + doubleEndorsementCount +
                ", pledgeCount=" + pledgeCount +
                ", guaranteeStatus=" + guaranteeStatus +
                ", inconsistentStatus=" + inconsistentStatus +
                ", customDefect='" + customDefect + '\'' +
                ", endorseCount=" + endorseCount +
                ", isDirectSell=" + isDirectSell +
                ", directBuyerAccount='" + directBuyerAccount + '\'' +
                ", feeDeduction='" + feeDeduction + '\'' +
                ", status=" + status +
                ", createTimeInMillis=" + createTimeInMillis +
                ", publisherId='" + publisherId + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
