package com.platform.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ParamsUtils
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/11 15:45
 **/
public class ParamsUtils {

    /**
     * @param params
     * @Description 转换参数
     * @Return
     * @Throws Exception
     * @Author lilong
     * @Date 2020/9/10 16:55
     **/
    public static Map<String, String> convertParams(Map<String, Object> params) {
        // TODO: 2020/9/10  判断参数是否为空 添加其他相关参数
        Map<String, String> urlParams = new HashMap<String, String>();
        Integer pageNumber = Integer.parseInt(String.valueOf(params.get("page")));
        Integer pageSize = Integer.parseInt(String.valueOf(params.get("limit")));
        Integer start = (pageNumber - 1) * pageSize;
        urlParams.put("start", String.valueOf(start));
        urlParams.put("count", String.valueOf(pageSize));
        return urlParams;

    }
}
