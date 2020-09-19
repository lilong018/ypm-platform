package com.platform.modules.enterprise.entity;

/**
 * @ClassName EnterpriseRespond
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/18 14:47
 **/
public class EnterpriseRespond {
    private EnterprisePayload payload;

    private int statusCode;

    public EnterprisePayload getPayload() {
        return payload;
    }

    public void setPayload(EnterprisePayload payload) {
        this.payload = payload;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
