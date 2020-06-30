package com.platform.modules.baidu;

import com.baidu.aip.ocr.AipOcr;

/**
 * @program: ypmm-platform
 * @description: 百度AipOcr单例
 * @author: LL
 * @create: 2020-06-29 20:34
 **/
public class BaiduAipOcr {
    private static BaiduAipOcr instance = new BaiduAipOcr();
    private  BaiduAipOcr(){}

    private static final String APP_ID = "11787672";
    private static final String API_KEY = "03pgfsGaTNfbGQwhHUEHaxsC";
    private static final String SECRET_KEY = "mRy8a66vAS7sNOh51y7gYwHYuLd5uZBh";
    private static AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

    public static AipOcr getInstance(){
        return BaiduAipOcr.client;
    }
}
