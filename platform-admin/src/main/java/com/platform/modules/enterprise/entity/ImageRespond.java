package com.platform.modules.enterprise.entity;

import java.awt.*;

/**
 * @ClassName ImageRespond
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/21 11:06
 **/
public class ImageRespond {
    private int statusCode;

    private ImagePayload payload;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public ImagePayload getPayload() {
        return payload;
    }

    public void setPayload(ImagePayload payload) {
        this.payload = payload;
    }
}
