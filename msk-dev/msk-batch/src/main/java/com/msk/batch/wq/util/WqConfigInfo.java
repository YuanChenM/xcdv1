package com.msk.batch.wq.util;

import com.msk.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 外勤365调用相关的配置
 **/
@Component("wqConfigInfo")
public class WqConfigInfo {

    /**
     * 接口根地址
     */
    @Value("#{configProperties['wq.apiurl']}")
    private String apiurl;
    /**
     * 企业接入唯一授权标识
     */
    @Value("#{configProperties['wq.openid']}")
    private String openid;
    /**
     * 企业授权数据签名密钥
     */
    @Value("#{configProperties['wq.appkey']}")
    private String appkey;
    /**
     * 连接超时时间（毫秒）
     */
    @Value("#{configProperties['wq.connection.timeout']}")
    private String connectTimeout;
    /**
     * 请求超时时间（毫秒）
     */
    @Value("#{configProperties['wq.request.timeout']}")
    private String requestTimeout;
    /**
     * 代理主机（主机名或IP）
     */
    @Value("#{configProperties['wq.proxy.host']}")
    private String proxyHost;
    /**
     * 代理端口
     */
    @Value("#{configProperties['wq.proxy.port']}")
    private String proxyPort;
    /**
     * 外勤365系统中该流程的编码
     */
    @Value("#{configProperties['wq.formid']}")
    private String formid;

    /**
     * 外勤365系统中创建人id
     */
    @Value("#{configProperties['wq.creatorid']}")
    private String creatorid;

    /**
     * 外勤365系统子表id
     */
    @Value("#{configProperties['wq.id']}")
    private String wpid;

    /**
     * 获取API根地址
     *
     * @return API根地址
     */
    public String getApiUrl() {
        return apiurl;
    }

    /**
     * 获取企业接入唯一授权标识
     *
     * @return 企业接入唯一授权标识
     */
    public String getOpenId() {
        return openid;
    }

    /**
     * 获取企业授权数据签名密钥
     *
     * @return 企业授权数据签名密钥
     */
    public String getAppKey() {
        return appkey;
    }

    /**
     * 获取连接超时时间（毫秒）
     *
     * @return 连接超时时间（毫秒）
     */
    public int getConnectTimeout() {
        return StringUtil.toInteger(connectTimeout);
    }

    /**
     * 获取请求超时时间（毫秒）
     *
     * @return 请求超时时间（毫秒）
     */
    public int getRequestTimeout() {
        return StringUtil.toInteger(requestTimeout);
    }

    /**
     * 获取代理主机（主机名或IP）
     *
     * @return 代理主机（主机名或IP）
     */
    public String getProxyHost() { return proxyHost; }

    /**
     * 获取代理端口
     *
     * @return 代理端口
     */
    public int getProxyPort() { return StringUtil.isEmpty(proxyPort) ? 0 : StringUtil.toInteger(proxyPort); }

    /**
     * 获取外勤365系统中该流程的编码
     *
     * @return 外勤365系统中该流程的编码
     */
    public String getFormid() {
        return formid;
    }

    public String getCreatorid() {
        return creatorid;
    }

    public String getWpid() {
        return wpid;
    }
}
