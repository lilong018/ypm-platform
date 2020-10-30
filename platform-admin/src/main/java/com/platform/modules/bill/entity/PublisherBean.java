package com.platform.modules.bill.entity;

import java.util.List;

/**
 * @ClassName PublisherBean
 * @Deacription TODO
 * @Author lilong
 * @Date 2020/10/27 15:17
 * @Version 1.0
 **/
public class PublisherBean {

    private String account;
    private String companyName;
    private String legalRepName;
    private List<HandlerBean> handler;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalRepName() {
        return legalRepName;
    }

    public void setLegalRepName(String legalRepName) {
        this.legalRepName = legalRepName;
    }

    public List<HandlerBean> getHandler() {
        return handler;
    }

    public void setHandler(List<HandlerBean> handler) {
        this.handler = handler;
    }
}
