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
        Integer pageNumber = 1;
        Integer pageSize = 10;
        Map<String, String> urlParams = new HashMap<String, String>();
        if (params.get("page")!=null){
            pageNumber = Integer.parseInt(String.valueOf(params.get("page")));
        }
        if (params.get("limit")!=null){
            pageSize = Integer.parseInt(String.valueOf(params.get("limit")));
        }
        Integer start = (pageNumber - 1) * pageSize;
        urlParams.put("start", String.valueOf(start));
        urlParams.put("count", String.valueOf(pageSize));
//        urlParams.put("count", "1");
        //票据查询相关字段 params.get(Constant.PAGE) != null
        if (params.get("platformId")!=null){
            urlParams.put("platformId", String.valueOf(params.get("platformId")));
        }else{
            urlParams.put("platformId", AuthService.getPlatformId());
        }
        if (params.get("billId")!=null){
            urlParams.put("billId", String.valueOf(params.get("billId")));
        }
        if (params.get("billType")!=null){
            urlParams.put("billType", String.valueOf(params.get("billType")));
        }
        if (params.get("billNum")!=null){
            urlParams.put("billNum", String.valueOf(params.get("billNum")));
        }
        if (params.get("minAmount")!=null){
            urlParams.put("minAmount", String.valueOf(params.get("minAmount")));
        }
        if (params.get("maxAmount")!=null){
            urlParams.put("maxAmount", String.valueOf(params.get("maxAmount")));
        }
        // TODO: 2020/10/27 格式  YYYYMMDD_YYYYMMDD
        if (params.get("dueDayRange")!=null){
            urlParams.put("dueDayRange", String.valueOf(params.get("dueDayRange")));
        }
        if (params.get("status")!=null){
            urlParams.put("status", String.valueOf(params.get("status")));
        }
        if (params.get("sellerCompanyName")!=null){
            urlParams.put("sellerCompanyName", String.valueOf(params.get("sellerCompanyName")));
        }
        if (params.get("sellerAccount")!=null){
            urlParams.put("sellerAccount", String.valueOf(params.get("sellerAccount")));
        }

        return urlParams;
    }
}
