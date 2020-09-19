package com.platform.modules.enterprise.entity;

import java.util.Date;

/**
 * @ClassName EnteroriseVo
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/18 16:08
 **/
public class EnteroriseVo {

    public EnteroriseVo(){

    }
    public EnteroriseVo(CompanyInfo companyInfo){
        this.name = companyInfo.getName();
        this.createtime = new Date();
    }
    //企业id
    private String id;
    //企业名称
    private String name;
    //企业账号
    private String account;
    //创建时间
    private Date createtime;
    //平台id
    private String platformId;
    //统一社会信用代码-营业执照
    private String uscc;
    //公司详细地址
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
    //法定代表人身份证正面照片地址
    private String legalRepIdPicFrontUrl;
    //法定代表人身份证背面照片地址
    private String legalRepIdPicBackUrl;
    //省
    private String province;
    //市
    private String city;
    //营业执照到期时间
    private String businessExpirationDate;
    //法定代表人身份证到期时间
    private String idcardExpirationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getUscc() {
        return uscc;
    }

    public void setUscc(String uscc) {
        this.uscc = uscc;
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
