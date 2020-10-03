package com.platform.common.utils;

import com.alibaba.fastjson.JSON;
import com.platform.common.model.UrlConstans;
import com.platform.modules.enterprise.entity.ImagePayload;
import com.platform.modules.enterprise.entity.ImageRespond;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ImageUtil
 * @Description TODO
 * @Author: lilong
 * @Date: 2020/9/21 10:55
 **/
public class ImageUtil {

    public static Map<String,String> getImageMap(String imagePath) throws Exception {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-auth-token", AuthService.getToken());
        String address = UrlConstans.BASEURL + "/" + imagePath;
        String res = HttpUtil.get(address, headerMap, null);
        ImageRespond imageRespond = JSON.parseObject(res, ImageRespond.class);
        Map<String,String> imageMap = new HashMap<String,String>();
        if (imageRespond.getStatusCode() == 0){
            ImagePayload payload = imageRespond.getPayload();
            imageMap.put("type",payload.getType());
            imageMap.put("imageData",payload.getData());
        }
        return imageMap;
    }

    public static String checkImageBase64Format(String base64ImgData) {
        byte[] b = Base64.getDecoder().decode(base64ImgData);
        String type = "";
        if (0x424D == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "bmp";
        } else if (0x8950 == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "png";
        } else if (0xFFD8 == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "jpg";
        }
        return type;
    }



    public static void main(String[] args) {
        String url ="";
    }
}
