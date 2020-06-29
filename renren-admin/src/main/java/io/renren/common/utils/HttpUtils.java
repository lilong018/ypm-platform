package io.renren.common.utils;

import com.sun.xml.internal.fastinfoset.Encoder;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

public class HttpUtils {

    /**
     * @param url eg:http://localohost:8080/web/user/1
     *            http://localohost:8080/web/user?id=1
     * @return
     */
    public static String doGet(String url) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 返回结果
        String result = null;
        // 执行url之后的响应
        CloseableHttpResponse response = null;
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
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
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
     * @param url  eg:http://localohost:8080/web/user
     * @param json eg:{"name":"AA","id":"1"}
     * @return
     */
    public static String doPut(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String result = null;
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
