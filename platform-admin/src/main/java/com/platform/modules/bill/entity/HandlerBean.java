package com.platform.modules.bill.entity;

/**
 * @ClassName HandlerBean
 * @Deacription TODO
 * @Author lilong
 * @Date 2020/10/27 15:17
 * @Version 1.0
 **/
public class HandlerBean {
    private int channelType;
    private String handlerName;
    private String handlerPhoneNo;

    public int getChannelType() {
        return channelType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerPhoneNo() {
        return handlerPhoneNo;
    }

    public void setHandlerPhoneNo(String handlerPhoneNo) {
        this.handlerPhoneNo = handlerPhoneNo;
    }
}
