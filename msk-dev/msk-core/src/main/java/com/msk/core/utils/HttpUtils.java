package com.msk.core.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.msk.core.consts.SystemConst;
import com.msk.core.exception.BusinessException;

/**
 * HttpUtils
 *
 * @author jiang_nan
 * @version 1.0
 **/
public final class HttpUtils {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * Http Post请求方法
     * 
     * @param url 请求URL
     * @param param 请求参数
     * @return 返回JSON数据
     */
    @Deprecated
    public static JSONObject post(String url, Map<String, String> param) {
        logger.debug("请求URL:" + url);
        logger.debug("请求参数:" + param);
        JSONObject jsonObject = new JSONObject();
        if (!CollectionUtils.isEmpty(param)) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }
        }
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost method = new HttpPost(url);
        StringEntity entity = new StringEntity(jsonObject.toString(), SystemConst.Default.ENCODING);// 解决中文乱码问题
        method.setEntity(entity);
        entity.setContentEncoding(SystemConst.Default.ENCODING);
        entity.setContentType(SystemConst.ContentType.JSON);
        try {
            HttpResponse result = httpClient.execute(method);
            String resData = EntityUtils.toString(result.getEntity(), SystemConst.Default.ENCODING);
            logger.debug("返回数据:" + resData);
            JSONObject resultJsonData = new JSONObject(resData);
            return resultJsonData;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    /**
     * Http Post请求方法
     *
     * @param url 请求URL
     * @param param 请求参数
     * @return 返回JSON数据
     */
    public static JSONObject post(String url, Object param) {

        // if (!CollectionUtils.isEmpty(param)) {
        // for (Map.Entry<String, String> entry : param.entrySet()) {
        // jsonObject.put(entry.getKey(), entry.getValue());
        // }
        // }

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            JSONObject jsonObject = new JSONObject(param);
            StringEntity reqParam = new StringEntity(jsonObject.toString(), SystemConst.Default.ENCODING);// 解决中文乱码问题
            reqParam.setContentEncoding(SystemConst.Default.ENCODING);
            reqParam.setContentType(SystemConst.ContentType.JSON);
            httpPost.setEntity(reqParam);
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String resData = EntityUtils.toString(entity, SystemConst.Default.ENCODING);
            logger.debug("返回数据:" + resData);
            JSONObject resultJsonData = new JSONObject(resData);

            EntityUtils.consume(entity);
            return resultJsonData;
        } catch (Exception e) {
            logger.error("Http请求失败", e);
            throw new BusinessException("Http请求失败", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.warn("Http应答关闭失败", e);
                }
            }
        }
    }

    /**
     * 发送HTTP GET请求
     * 
     * @param url 请求url
     * @param param 请求参数
     * @return 请求结果
     */
    public static JSONObject get(String url, Map<String, String> param) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;

        // The underlying HTTP connection is still held by the response object
        // to allow the response content to be streamed directly from the network socket.
        // In order to ensure correct deallocation of system resources
        // the user MUST either fully consume the response content or abort request
        // execution by calling CloseableHttpResponse#close().
        // 建立的http连接，仍旧被response保持着，允许我们从网络socket中获取返回的数据
        // 为了释放资源，我们必须手动消耗掉response或者取消连接（使用CloseableHttpResponse类的close方法）

        try {
            response = httpclient.execute(httpGet);
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            String resData = EntityUtils.toString(entity, SystemConst.Default.ENCODING);
            logger.debug("返回数据:" + resData);
            JSONObject resultJsonData = new JSONObject(resData);

            EntityUtils.consume(entity);

            return resultJsonData;
        } catch (Exception e) {
            logger.error("Http请求失败", e);
            throw new BusinessException("Http请求失败", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.warn("Http应答关闭失败", e);
                }
            }
        }
    }
}
