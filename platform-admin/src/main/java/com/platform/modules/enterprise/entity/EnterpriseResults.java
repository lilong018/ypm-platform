package com.platform.modules.enterprise.entity;

import com.platform.modules.employee.entity.Platform;

import java.util.List;

/**
 * @ClassName EnterpriseResults
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/18 14:49
 **/
public class EnterpriseResults {
    private String account;

    private List<Channels> channels;

    private CompanyInfo companyInfo;

    private String id;

    private Platform platform;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<Channels> getChannels() {
        return channels;
    }

    public void setChannels(List<Channels> channels) {
        this.channels = channels;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

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
}
