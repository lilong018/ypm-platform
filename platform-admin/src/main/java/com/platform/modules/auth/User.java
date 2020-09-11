package com.platform.modules.auth;

import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/11 8:49
 **/
public class User {

    private List<String> controlPlatform;

    private boolean firstLogin;

    private boolean isFirstLoginReset;

    private boolean isNotAllowReset;

    private String userId;

    private UserInfo userInfo;

    private int userRole;

    public List<String> getControlPlatform() {
        return controlPlatform;
    }

    public void setControlPlatform(List<String> controlPlatform) {
        this.controlPlatform = controlPlatform;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public boolean isFirstLoginReset() {
        return isFirstLoginReset;
    }

    public void setFirstLoginReset(boolean firstLoginReset) {
        isFirstLoginReset = firstLoginReset;
    }

    public boolean isNotAllowReset() {
        return isNotAllowReset;
    }

    public void setNotAllowReset(boolean notAllowReset) {
        isNotAllowReset = notAllowReset;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
