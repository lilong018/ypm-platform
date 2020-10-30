package com.platform.modules.enterprise.entity;

import com.platform.common.utils.ImageUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EnterpriseInfoVo
 * @Deacription TODO
 * @Author lilong
 * @Date 2020/10/30 16:06
 * @Version 1.0
 **/
public class EnterpriseInfoVo {

    /**
     * id
     */
    private String id;
    /**
     * 企业姓名
     */
    private String name;
    //企业账号
    private String account;

    /**
     * 统一社会信用代码-营业执照
     */
    private String uscc;
    /**
     * 公司详细地址
     */
    private String address;

    //角色
    private String roleName;


    /**
     * 经办人姓名
     */
    private String handlerName;
    /**
     * 经办人身份证号
     */
    private String handlerId;
    /**
     * 经办人手机号
     */
    private String handlerPhone;
    /**
     * 经办人邮箱地址
     */
    private String handlerEmail;
    //企业状态
    private Integer status;
    //创建时间
    private Date createTime;

    //平台id
    private String platformId;
    //平台名称
    private String platformName;
    //渠道名称
    private String channelName;

    /**
     * 营业执照图片
     */
    private String businesslicenseurl;
    /**
     * 法人姓名
     */
    private String legalrepname;
    /**
     * 法人身份证
     */
    private String legalrepid;
    /**
     * 法人手机号码
     */
    private String legalrepphoneno;
    /**
     * 法人身份证正面照片
     */
    private String legalrepidpicfronturl;
    /**
     * 法人身份证背面照片
     */
    private String legalrepidpicbackurl;

    /**
     * 营业执照到期时间
     */
    private String businessexpirationdate;
    /**
     * 法人身份证到期时间
     */
    private String idcardexpirationdate;


    public EnterpriseInfoVo() {
        super();
    }

    ;

    public EnterpriseInfoVo(EnterpriseResults enterpriseResults) {
        this.id = enterpriseResults.getId();
        CompanyInfo companyInfo = enterpriseResults.getCompanyInfo();
        this.name = companyInfo.getName();
        this.uscc = companyInfo.getUscc();
        this.address = companyInfo.getAddress();
        this.legalrepname = companyInfo.getLegalRepName();
        this.legalrepid = companyInfo.getLegalRepId();
        this.legalrepphoneno = companyInfo.getLegalRepPhoneNo();
        this.businessexpirationdate = companyInfo.getBusinessExpirationDate();
        this.idcardexpirationdate = companyInfo.getIdcardExpirationDate();
        Map<String, String> busMap = ImageUtil.getImageMap(companyInfo.getBusinessLicenseUrl());
        this.businesslicenseurl = busMap.get("imageData");
        Map<String, String> legalFMap = ImageUtil.getImageMap(companyInfo.getLegalRepIdPicFrontUrl());
        this.legalrepidpicfronturl = legalFMap.get("imageData");
        Map<String, String> legalBMap = ImageUtil.getImageMap(companyInfo.getLegalRepIdPicBackUrl());
        this.legalrepidpicbackurl = legalBMap.get("imageData");
        List<Channels> channels = enterpriseResults.getChannels();
        for (Channels channel : channels) {

        }
        //经办人信息
//        this.handlerId =

    }

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public String getHandlerPhone() {
        return handlerPhone;
    }

    public void setHandlerPhone(String handlerPhone) {
        this.handlerPhone = handlerPhone;
    }

    public String getHandlerEmail() {
        return handlerEmail;
    }

    public void setHandlerEmail(String handlerEmail) {
        this.handlerEmail = handlerEmail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getLegalrepname() {
        return legalrepname;
    }

    public void setLegalrepname(String legalrepname) {
        this.legalrepname = legalrepname;
    }

    public String getLegalrepid() {
        return legalrepid;
    }

    public void setLegalrepid(String legalrepid) {
        this.legalrepid = legalrepid;
    }

    public String getLegalrepphoneno() {
        return legalrepphoneno;
    }

    public void setLegalrepphoneno(String legalrepphoneno) {
        this.legalrepphoneno = legalrepphoneno;
    }

    public String getLegalrepidpicfronturl() {
        return legalrepidpicfronturl;
    }

    public void setLegalrepidpicfronturl(String legalrepidpicfronturl) {
        this.legalrepidpicfronturl = legalrepidpicfronturl;
    }

    public String getLegalrepidpicbackurl() {
        return legalrepidpicbackurl;
    }

    public void setLegalrepidpicbackurl(String legalrepidpicbackurl) {
        this.legalrepidpicbackurl = legalrepidpicbackurl;
    }

    public String getBusinessexpirationdate() {
        return businessexpirationdate;
    }

    public void setBusinessexpirationdate(String businessexpirationdate) {
        this.businessexpirationdate = businessexpirationdate;
    }

    public String getIdcardexpirationdate() {
        return idcardexpirationdate;
    }

    public void setIdcardexpirationdate(String idcardexpirationdate) {
        this.idcardexpirationdate = idcardexpirationdate;
    }

    public String getBusinesslicenseurl() {
        return businesslicenseurl;
    }

    public void setBusinesslicenseurl(String businesslicenseurl) {
        this.businesslicenseurl = businesslicenseurl;
    }
}
