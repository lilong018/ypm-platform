package com.platform.common.utils;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.fastinfoset.Encoder;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpUtils {


    public static final String BASEURL = "https://192.168.129:8889";
    //统一配置
    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    private static final int MAX_TIMEOUT = 7000;
    static {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        connMgr.setMaxTotal(100);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        // 在提交请求之前 测试连接是否可用
        configBuilder.setStaleConnectionCheckEnabled(true);
        requestConfig = configBuilder.build();
    }

    /**
     * 发送get请求不带参数
     * @param url
     * @return
     */
    public static String doGet(String url){

        return doGet(BASEURL+url, null);
    }

    /**
     * @param url eg:http://localohost:8080/web/user/1
     *            http://localohost:8080/web/user?id=1
     * @return
     */
    public static String doGet(String url,Map<String, String> map) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 返回结果
        String result = null;
        // 执行url之后的响应
        CloseableHttpResponse response = null;
        StringBuffer params = null;
        url = BASEURL + url;
        if(null != map && !map.isEmpty()){
            //遍历map
            params = new StringBuffer();
            for(Map.Entry<String , String> entry:map.entrySet()){
                params.append("&"+entry.getKey()+"="+entry.getValue());
            }
            url = url + params.toString();
        }
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpClient.execute(httpGet);
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static String doGet(String url,Map<String, Object> map, Map<String,Object> headerMap) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 返回结果
        String result = null;
        // 执行url之后的响应
        CloseableHttpResponse response = null;
        StringBuffer params = null;
        url = BASEURL + url;
        if(null != map && !map.isEmpty()){
            //遍历map
            params = new StringBuffer();
            for(Map.Entry<String , Object> entry:map.entrySet()){
                params.append("&"+entry.getKey()+"="+String.valueOf(entry.getValue()));
            }
            url = url + params.toString();
        }
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            //创建请求header
            if(headerMap != null && headerMap.size() > 0) {
                for(Map.Entry<String, Object> entry : headerMap.entrySet()){
                    httpGet.setHeader(entry.getKey(), (String) entry.getValue());
                }
            }
            // 执行请求
            response = httpClient.execute(httpGet);
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * @param url  eg:http://localohost:8080/web/user
     * @param json eg:{"name":"aa","id":"1","password":"123"}
     * @return
     */
    public static String doPost(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
        url = BASEURL + url;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("","");
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), Encoder.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url 发送请求的 URL
     * @param reqStr 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param headerMap header请求参数 Map<String,String>
     * @return 所代表远程资源的响应结果
     */
    public static String doPost(String url, String reqStr, Map<String,Object> headerMap) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
        url = BASEURL + url;
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
//            httpPost.setHeader("accept", "*/*");
//            httpPost.setHeader("connection", "Keep-Alive");
//            httpPost.setHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
            //创建请求header
            if(headerMap != null && headerMap.size() > 0) {
                for(Map.Entry<String, Object> entry : headerMap.entrySet()){
                    httpPost.setHeader(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            // 创建请求内容
            StringEntity entity = new StringEntity(reqStr, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), Encoder.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送Put方法的请求
     *
     * @param url 发送请求的 URL
     * @param reqStr 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param headerMap header请求参数 Map<String,String>
     * @return 所代表远程资源的响应结果
     */
    public static String doPut(String url, String reqStr, Map<String,Object> headerMap){
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
        url = BASEURL + url;
        try {
            // 创建Http Post请求
            HttpPut httpPut = new HttpPut(url);
            //创建请求header
            if(headerMap != null && headerMap.size() > 0) {
                for(Map.Entry<String, Object> entry : headerMap.entrySet()){
                    httpPut.setHeader(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            // 创建请求内容
            StringEntity entity = new StringEntity(reqStr, ContentType.APPLICATION_JSON);
            httpPut.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPut);
            result = EntityUtils.toString(response.getEntity(), Encoder.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * @param url  eg:http://localohost:8080/web/user
     * @param json eg:{"name":"AA","id":"1"}
     * @return
     */
    public static String doPut(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
        url = BASEURL + url;
        try {
            // 创建Http Post请求
            HttpPut httpPut = new HttpPut(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPut.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPut);
            result = EntityUtils.toString(response.getEntity(), Encoder.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * @param url eg:http://localohost:8080/web/user/1
     *            http://localohost:8080/web/user?id=1
     *            http://localohost:8080/web/user?id=1,2,3
     * @return
     */
    public static String doDelete(String url) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
        url = BASEURL + url;
        try {
            // 创建Http Post请求
            HttpDelete httpDelete = new HttpDelete(url);
            // 执行http请求
            response = httpClient.execute(httpDelete);
            result = EntityUtils.toString(response.getEntity(), Encoder.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
