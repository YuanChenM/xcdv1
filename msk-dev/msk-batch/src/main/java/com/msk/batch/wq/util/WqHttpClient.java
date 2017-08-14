package com.msk.batch.wq.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msk.batch.wq.bean.WqResponse;
import com.msk.core.utils.StringUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 外勤365调用工具类
 */
@Component
public class WqHttpClient {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(WqHttpClient.class);

    private static final SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmSS");

    private static WqConfigInfo config;

    @Autowired
    public void setConfigInfo(final WqConfigInfo config) {
        WqHttpClient.config = config;
    }

    /**
     * POST方式发送API请求
     *
     * @param url   应用URL（不含根地址和参数）
     * @param param 参数对象
     * @param msgId 请求ID
     * @return 请求结果
     */
    public static <T> WqResponse<T> httpPost(String url, Object param, String msgId, Class<T> resultType) {
        String timestamp = df.format(new Date());

        String body = parseObject(param);

        String key = Md5.encode(String.format("%s|%s|%s", body, config.getAppKey(), timestamp));

        StringBuffer postUrl = new StringBuffer(config.getApiUrl());
        postUrl.append("/").append(url).append("/").append(config.getOpenId()).append("/").append(timestamp).append("/")
                .append(key).append("/").append(msgId);
        String response = post(postUrl.toString(), body);

        WqResponse rs = parseJson(response, WqResponse.class);
        if (rs != null && !StringUtil.isEmpty(rs.getResponseData())) {
            if(rs.getResponseData().startsWith("[")){
                List<T> data = parseJsonList(rs.getResponseData(), resultType);
                rs.setData(data);
            }else{
                T resultTypeData=parseJson(rs.getResponseData(),resultType);
                List<T> data=new ArrayList<>();
                data.add(resultTypeData);
                rs.setData(data);
            }
        }
        return rs;
    }

    /**
     * POST方式发送API请求
     *
     * @param url  应用URL（全部）
     * @param body 应用参数
     * @return 请求结果
     */
    private static String post(String url, String body) {
        HttpClient http = new HttpClient();

        // 设置代理
        String proxyHost = config.getProxyHost();
        int proxyPort = config.getProxyPort();
        // 针对内网服务器，设置代理
        if (!StringUtil.isEmpty(proxyHost) && proxyPort > 0) {
            // 设置代理服务器的ip地址和端口
            http.getHostConfiguration().setProxy(proxyHost, proxyPort);
            // 使用抢先认证
            http.getParams().setAuthenticationPreemptive(true);
        }

        // 建立连接超时时间
        http.getHttpConnectionManager().getParams().setConnectionTimeout(config.getConnectTimeout());
        // 请求相应超时时间
        http.getHttpConnectionManager().getParams().setSoTimeout(config.getRequestTimeout());

        PostMethod method = new PostMethod1(url);
        try {
            logger.debug("请求URL：" + url);
            logger.debug("请求参数：" + body);
            method.setRequestEntity(new StringRequestEntity(body, "application/json", method.getRequestCharSet()));
            http.executeMethod(method);
            byte[] response = method.getResponseBody();
            String result = new String(response);
            logger.debug("响应：" + result);
            return result;
        } catch (HttpException e) {
            logger.error("外勤365接口调用异常", e);
        } catch (IOException e) {
            logger.error("外勤365接口调用异常", e);
        } catch (Exception e) {
            logger.error("外勤365接口调用异常", e);
        }
        return null;
    }

    /**
     * 将JSON字符串解析成指定类型对象
     *
     * @param json       json字符串
     * @param resultType 对象类型
     * @param <T>        对象类型
     * @return 对象
     */
    private static <T> T parseJson(String json, Class<T> resultType) {
        // get mapper
        ObjectMapper mapper = new ObjectMapper();
        // ignore
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            if(!StringUtil.isEmpty(json)) {
                T result = mapper.readValue(json, resultType);
                // logger.debug("{}:{}", StringUtil.toSafeString(result), json);
                return result;
            }
        } catch (IOException e) {
            logger.error("外勤365接口调用异常", e);
        }
        return null;
    }

    /**
     * 将JSON字符串解析成指定类型对象List
     *
     * @param json       json字符串
     * @param resultType 对象类型
     * @param <T>        对象类型
     * @return 对象
     */
    private static <T> List<T> parseJsonList(String json, Class<T> resultType) {
        // get mapper
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructCollectionType(List.class, resultType);
        // ignore
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            List<T> result = mapper.readValue(json, javaType);
            // logger.debug("{}:{}", StringUtil.toSafeString(result), json);
            return result;
        } catch (IOException e) {
            logger.error("外勤365接口调用异常", e);
        }
        return null;
    }

    /**
     * 将数据对象解析成JSON字符串
     *
     * @param data 数据对象
     * @return 对象
     */
    private static String parseObject(Object data) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{}";
        try {
            StringWriter sw = new StringWriter();
            JsonGenerator gen = new JsonFactory().createGenerator(sw);
            mapper.writeValue(gen, data);
            gen.close();
            json = sw.toString();
        } catch (IOException e) {
            logger.error("外勤365接口调用参数异常", e);
        }
        return json;
    }

}
