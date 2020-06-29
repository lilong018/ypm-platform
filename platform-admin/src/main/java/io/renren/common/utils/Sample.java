package io.renren.common.utils;

import com.baidu.aip.ocr.AipOcr;
import io.renren.modules.baidu.BaiduAipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @program: ypmm-platform
 * @description:
 * @author: LL
 * @create: 2020-06-29 20:27
 **/
public class Sample {
    //设置APPID/AK/SK


    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = BaiduAipOcr.getInstance();

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
     /*   client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理*/

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        String idCardSide = "front";

        // 参数为本地图片路径
        String image = "H://test.jpg";
        JSONObject res = client.idcard(image, idCardSide, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
//        byte[] file = readImageFile(image);
//        res = client.idcard(file, idCardSide, options);
//        System.out.println(res.toString(2));


    }
}