package com.platform.modules.auth;

/**
 * @ClassName AuthRespon
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/11 8:47
 **/
public class AuthRespond {

    private AuthPayload payload;

    private int statusCode;

    public AuthPayload getPayload() {
        return payload;
    }

    public void setPayload(AuthPayload payload) {
        this.payload = payload;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
