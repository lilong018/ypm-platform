package com.platform.modules.auth;

import com.platform.modules.platform.entity.PlatformResults;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/11 8:50
 **/
public class UserInfo {
    private int department;

    private String name;

    private PlatformResults platform;

    private String userInfoId;

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlatformResults getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformResults platform) {
        this.platform = platform;
    }

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }
}
