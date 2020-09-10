package com.platform.common.utils;

/**
 * @ClassName AuthService
 * @Description 获取用户信息 token
 * @Author: lilong
 * @Date: 2020/9/10 13:57
 **/
public class AuthService {

    private static String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2NvdW50IjoiYWRtaW4iLCJwYXNzd29yZCI6ImFkbWluIiwicm9sZSI6MSwiZXhwIjoxNTk5ODE4MTY1NTE0fQ.IogPUgDw1lQVXPgIbk-Td94AlKrwV9rmLx7i6Z49XjM";

    public static String getAuth(){
        return token;
    }

}
