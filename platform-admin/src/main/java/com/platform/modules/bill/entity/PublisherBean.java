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
    private String companyInfo;
    private String legalRepName;
    private String inOrderId;
    private String outOrderId;
    private List<HandlerBean> handler;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getLegalRepName() {
        return legalRepName;
    }

    public void setLegalRepName(String legalRepName) {
        this.legalRepName = legalRepName;
    }

    public String getInOrderId() {
        return inOrderId;
    }

    public void setInOrderId(String inOrderId) {
        this.inOrderId = inOrderId;
    }

    public String getOutOrderId() {
        return outOrderId;
    }

    public void setOutOrderId(String outOrderId) {
        this.outOrderId = outOrderId;
    }

    public List<HandlerBean> getHandler() {
        return handler;
    }

    public void setHandler(List<HandlerBean> handler) {
        this.handler = handler;
    }
}
