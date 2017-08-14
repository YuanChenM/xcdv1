package com.msk.batch.wq.util;

import org.apache.commons.httpclient.methods.PostMethod;

/**
 * HTTP请求POST方法
 * 用于调用外勤365的api的请求发送
 */
public class PostMethod1 extends PostMethod {
    public PostMethod1(String url) {
        super(url);
    }

    /**
     * 获取请求的字符集
     *
     * @return 请求的字符集
     */
    @Override
    public String getRequestCharSet() {
        return "UTF-8";
    }
}