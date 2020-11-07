package com.platform.modules.enterprise.entity;

/**
 * @ClassName CompanyInfo
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/18 14:51
 **/
public class CompanyInfo {
    //企业名称
    private String name;
    //统一社会信用代码-营业执照
    private String uscc;
    //注册省份
    private String regProvince;
    //注册城市
    private String regCity;
    //注册地区
    private String regArea;
    //注册详细地址
    private String regAddress;
    //省
    private String province;
    //市
    private String city;
    //公司详细地址（经营地址）
    private String address;
    //营业执照图片地址
    private String businessLicenseUrl;
    //开户许可证图片地址
    private String accountOpeningLicenseUrl;
    //法定代表人姓名
    private String legalRepName;
    //法定代表人身份证号
    private String legalRepId;
    //法定代表人手机号
    private String legalRepPhoneNo;
    //法定代表人正面截图base64
    private String legalRepIdPicFrontUrl;
    //法定代表人背面截图base64
    private String legalRepIdPicBackUrl;
    //经办人姓名
    private String handlerName;
    //经办人身份证号
    private String handlerId;
    //经办人手机号
    private String handlerPhoneNo;
    //经办人邮箱（已废弃）
    private String handlerEmail;
    //经办人微信号
    private String handlerWeChat;

    //营业执照到期时间
    private String businessExpirationDate;
    //法定代表人身份证到期时间
    private String idcardExpirationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUscc() {
        return uscc;
    }

    public void setUscc(String uscc) {
        this.uscc = uscc;
    }

    public String getRegProvince() {
        return regProvince;
    }

    public void setRegProvince(String regProvince) {
        this.regProvince = regProvince;
    }

    public String getRegCity() {
        return regCity;
    }

    public void setRegCity(String regCity) {
        this.regCity = regCity;
    }

    public String getRegArea() {
        return regArea;
    }

    public void setRegArea(String regArea) {
        this.regArea = regArea;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }

    public String getAccountOpeningLicenseUrl() {
        return accountOpeningLicenseUrl;
    }

    public void setAccountOpeningLicenseUrl(String accountOpeningLicenseUrl) {
        this.accountOpeningLicenseUrl = accountOpeningLicenseUrl;
    }

    public String getLegalRepName() {
        return legalRepName;
    }

    public void setLegalRepName(String legalRepName) {
        this.legalRepName = legalRepName;
    }

    public String getLegalRepId() {
        return legalRepId;
    }

    public void setLegalRepId(String legalRepId) {
        this.legalRepId = legalRepId;
    }

    public String getLegalRepPhoneNo() {
        return legalRepPhoneNo;
    }

    public void setLegalRepPhoneNo(String legalRepPhoneNo) {
        this.legalRepPhoneNo = legalRepPhoneNo;
    }

    public String getLegalRepIdPicFrontUrl() {
        return legalRepIdPicFrontUrl;
    }

    public void setLegalRepIdPicFrontUrl(String legalRepIdPicFrontUrl) {
        this.legalRepIdPicFrontUrl = legalRepIdPicFrontUrl;
    }

    public String getLegalRepIdPicBackUrl() {
        return legalRepIdPicBackUrl;
    }

    public void setLegalRepIdPicBackUrl(String legalRepIdPicBackUrl) {
        this.legalRepIdPicBackUrl = legalRepIdPicBackUrl;
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

    public String getHandlerWeChat() {
        return handlerWeChat;
    }

    public void setHandlerWeChat(String handlerWeChat) {
        this.handlerWeChat = handlerWeChat;
    }

    public String getBusinessExpirationDate() {
        return businessExpirationDate;
    }

    public void setBusinessExpirationDate(String businessExpirationDate) {
        this.businessExpirationDate = businessExpirationDate;
    }

    public String getIdcardExpirationDate() {
        return idcardExpirationDate;
    }

    public void setIdcardExpirationDate(String idcardExpirationDate) {
        this.idcardExpirationDate = idcardExpirationDate;
    }
}
