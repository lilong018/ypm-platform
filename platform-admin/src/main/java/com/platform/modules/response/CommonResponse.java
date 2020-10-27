package com.platform.modules.response;

import java.io.Serializable;

/**
 * @ClassName CommonResponse
 * @Deacription 公共返回头
 * @Author ll
 * @Date 2020/10/27 14:54
 * @Version 1.0
 **/
public class CommonResponse<T> implements Serializable {
    private Integer statusCode; // api 回传值
    private T payload;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "statusCode=" + statusCode +
                ", payload=" + payload +
                '}';
    }
}
