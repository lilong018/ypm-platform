package com.platform.modules.auth;

import java.util.List;

/**
 * @ClassName AuthPayload
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/11 8:48
 **/
public class AuthPayload {

    private String token;

    private User user;

    private List<String> userPrivileges;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getUserPrivileges() {
        return userPrivileges;
    }

    public void setUserPrivileges(List<String> userPrivileges) {
        this.userPrivileges = userPrivileges;
    }
}
