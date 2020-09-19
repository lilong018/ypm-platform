package com.platform.common.utils;

import com.alibaba.fastjson.JSON;
import com.platform.common.model.UrlConstans;
import com.platform.modules.auth.AuthRespond;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AuthService
 * @Description 获取用户信息 token
 * @Author: lilong
 * @Date: 2020/9/10 13:57
 **/
public class AuthService {

    private static String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50IjoiMTExMTExMTExMTEiLCJwYXNzd29yZCI6ImFkbWluIiwicm9sZSI6MywiZXhwIjoxNTk5OTAyNDAzMDgxfQ.n0Rz2racubx65VAZbCbe0deQKI3AtretCUFwgBSELRw";

    public static String getAuth(){
        return token;
    }

    public static String getToken(){
        Map<String, String> headerMaps = new HashMap<String, String>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("account", "admin");
        params.put("password", "admin");
        params.put("isLoginSetting", true);
//        https://192.168.68.129:8889/users/login
        String address = UrlConstans.BASEURL + UrlConstans.LOGIN;
        try {
            String res = HttpUtil.post(address, headerMaps, JSON.toJSONString(params));
            AuthRespond authRespond = JSON.parseObject(res, AuthRespond.class);
            token = authRespond.getPayload().getToken();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return token;

    }
    public static String getToken(String account,String password,boolean isLoginSetting){
        Map<String, String> headerMaps = new HashMap<String, String>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("account", account);
        params.put("password",password);
        params.put("isLoginSetting", isLoginSetting);
//        https://192.168.68.129:8889/users/login
        String address = UrlConstans.BASEURL + UrlConstans.LOGIN;
        try {
            String res = HttpUtil.post(address, headerMaps, JSON.toJSONString(params));
            AuthRespond authRespond = JSON.parseObject(res, AuthRespond.class);
            token = authRespond.getPayload().getToken();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return token;

    }

}
