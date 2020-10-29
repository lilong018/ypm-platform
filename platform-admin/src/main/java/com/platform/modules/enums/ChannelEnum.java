package com.platform.modules.enums;


import java.util.Objects;

/**
 * @ClassName ChannelEnum
 * @Description 渠道类型
 * @Author: lilong
 * @Date: 2020/10/17 10:40
 **/
public enum ChannelEnum {
//    |1|京东智票 |2|京东智付
    JDZP(1,"京东智票"),
    JDZF(2,"京东智票"),
    JDZPZF(3,"京东智付,京东智付");
    private ChannelEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    };
    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNameByCode(Integer code){
        for (ChannelEnum channelEnum : ChannelEnum.values()){
            if (Objects.equals(channelEnum.getCode(), code)){
                return channelEnum.getName();
            }
        }
        return null;
    }
}
