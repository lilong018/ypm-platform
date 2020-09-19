package com.platform.modules.enterprise.entity;

import io.swagger.models.auth.In;

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
    //平台名称
    private String platformName;
    //渠道名称
    private String channelName;
    //角色
    private String roleName;
    //备注
    private String remark;
    //原因
    private String  reason;
    //客服id
    private String handlerId;
    //客服名称
    private String handlerName;
    //企业状态
    private Integer status;

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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
