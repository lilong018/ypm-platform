package com.platform.modules.platform.entity;

/**
 * @ClassName PlatformRespond
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/10 17:05
 **/
public class PlatformRespond {

    private PlatformPayload payload;

    private int statusCode;

    public PlatformPayload getPayload() {
        return payload;
    }

    public void setPayload(PlatformPayload payload) {
        this.payload = payload;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
