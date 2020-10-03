package com.platform.common.model;

public enum ImageType {
    JPG("data:image/jpg;base64,","jpg"),
    JPEG("data:image/jpeg;base64,","jpeg"),
    PNG("data:image/png;base64,","png");

    private String code;
    private String name;

    private ImageType(String name,String code){
        this.name = name;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(String code){
        for (ImageType type: ImageType.values()) {
            if (type.getCode().equals(code)){
                return type.name;
            }
        }
        return null;
    }
}
