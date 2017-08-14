package com.msk.core.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msk.core.entity.CommConfig;

/**
 * ConfigManager
 *
 * @author jiang_nan
 * @version 1.0
 */
@Component("configManager")
public class ConfigManager {
    private static ConfigInfo config;
    private static Map<String, String> CONFIG_VALUES_MAP = new HashMap<>();
    /**
     * 表示开启的开关标志值
     */
    private static final String[] TRUE_FLAG = {"1", "on", "true"};

    @Autowired
    public void setConfigInfo(final ConfigInfo config) {
        ConfigManager.config = config;
    }

    /**
     * 初始化Config Map中数据
     *
     * @param configList
     */
    public static void initConfigValue(List<CommConfig> configList) {
        if (!CollectionUtils.isEmpty(configList)) {
            for (CommConfig config : configList) {
                CONFIG_VALUES_MAP.put(config.getSystemKey(), config.getSystemValue());
            }
        }
    }

    public static String getStandardCoefficientQuotiety() {
        return config.getStandardCoefficientQuotiety();
    }

    public static String getLevelStandMinZero() {
        return config.getLevelStandMinZero();
    }

    public static String getLevelStandMinOne() {
        return config.getLevelStandMinOne();
    }

    public static String getLevelStandMinTwo() {
        return config.getLevelStandMinTwo();
    }

    public static String getLevelStandMinThree() {
        return config.getLevelStandMinThree();
    }

    public static String getLevelStandMinFour() {
        return config.getLevelStandMinFour();
    }

    public static String getLevelStandMinFive() {
        return config.getLevelStandMinFive();
    }

    public static String getLevelStandMinSix() {
        return config.getLevelStandMinSix();
    }

    public static String getLevelStandMinSeven() {
        return config.getLevelStandMinSeven();
    }

    public static String getLevelStandMinEight() {
        return config.getLevelStandMinEight();
    }

    public static String getLevelStandMinNine() {
        return config.getLevelStandMinNine();
    }

    public static String getLevelStandMaxZero() {
        return config.getLevelStandMaxZero();
    }

    public static String getLevelStandMaxOne() {
        return config.getLevelStandMaxOne();
    }

    public static String getLevelStandMaxTwo() {
        return config.getLevelStandMaxTwo();
    }

    public static String getLevelStandMaxThree() {
        return config.getLevelStandMaxThree();
    }

    public static String getLevelStandMaxFour() {
        return config.getLevelStandMaxFour();
    }

    public static String getLevelStandMaxFive() {
        return config.getLevelStandMaxFive();
    }

    public static String getLevelStandMaxSix() {
        return config.getLevelStandMaxSix();
    }

    public static String getLevelStandMaxSeven() {
        return config.getLevelStandMaxSeven();
    }

    public static String getLevelStandMaxEight() {
        return config.getLevelStandMaxEight();
    }

    public static String getLevelStandMaxNine() {
        return config.getLevelStandMaxNine();
    }

    public static String getStandardCoefficientZero() {
        return config.getStandardCoefficientZero();
    }

    public static String getStandardCoefficientOne() {
        return config.getStandardCoefficientOne();
    }

    public static String getStandardCoefficientTwo() {
        return config.getStandardCoefficientTwo();
    }

    public static String getStandardCoefficientThree() {
        return config.getStandardCoefficientThree();
    }

    public static String getStandardCoefficientFour() {
        return config.getStandardCoefficientFour();
    }

    public static String getStandardCoefficientFive() {
        return config.getStandardCoefficientFive();
    }

    public static String getStandardCoefficientSix() {
        return config.getStandardCoefficientSix();
    }

    public static String getStandardCoefficientSeven() {
        return config.getStandardCoefficientSeven();
    }

    public static String getStandardCoefficientEight() {
        return config.getStandardCoefficientEight();
    }

    public static String getStandardCoefficientNine() {
        return config.getStandardCoefficientNine();
    }

    public static String getDisCountZero() {
        return config.getDisCountZero();
    }

    public static String getDisCountOne() {
        return config.getDisCountOne();
    }

    public static String getDisCountTwo() {
        return config.getDisCountTwo();
    }

    public static String getDisCountThree() {
        return config.getDisCountThree();
    }

    public static String getDisCountFour() {
        return config.getDisCountFour();
    }

    public static String getDisCountFive() {
        return config.getDisCountFive();
    }

    public static String getDisCountSix() {
        return config.getDisCountSix();
    }

    public static String getDisCountSeven() {
        return config.getDisCountSeven();
    }

    public static String getDisCountEight() {
        return config.getDisCountEight();
    }

    public static String getDisCountNine() {
        return config.getDisCountNine();
    }

    /**
     * 获得FTP IP地址
     *
     * @return FTP IP地址
     */
    public static String getFtpIp() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.FTP_IP);
    }

    /**
     * 获得FTP用户名
     *
     * @return FTP用户名
     */
    public static String getFtpUser() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.FTP_USER);
    }

    /**
     * 获得FTP密码
     *
     * @return FTP密码
     */
    public static String getFtpPwd() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.FTP_PWD);
    }

    /**
     * 获得FTP服务器HTTP的URL
     *
     * @return FTP服务器HTTP的URL
     */
    public static String getFtpHttpUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.FTP_HTTP);
    }

    /**
     * 获得FTP图片根目录
     *
     * @return FTP图片根目录
     */
    public static String getFtpImageRootPath() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.FTP_IMAGE_ROOT_PATH);
    }

    /**
     * 获得WMS FTP IP
     *
     * @return WMS FTP IP
     */
    public static String getWmsFtpIp() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.WMS_FTP_IP);
    }

    /**
     * 获得WMS FTP User
     *
     * @return WMS FTP User
     */
    public static String getWmsFtpUser() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.WMS_FTP_USER);
    }

    /**
     * 获得WMS FTP Pwd
     *
     * @return WMS FTP Pwd
     */
    public static String getWmsFtpPwd() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.WMS_FTP_PWD);
    }

    /**
     * 获得供应商的部门ID固定值
     *
     * @return 供应商的部门ID固定值
     */
    public static String getSupplierDeptId() {
        return config.getSupplierDeptId();
    }

    /**
     * 获得供应商的角色ID固定值
     *
     * @return 供应商的角色ID固定值
     */
    public static String getSupplierRoleId() {
        return config.getSupplierRoleId();
    }

    /**
     * 获得短信API地址
     *
     * @return 短信API地址
     */
    public static String getSmsUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.SMS_URL);
    }

    /**
     * 获得SMS供应商编码
     *
     * @return 供应商编码
     */
    public static String getSmsSupplier() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.SMS_SUPPLIER);
    }

    /**
     * 获得SMS用户名
     *
     * @return SMS用户名
     */
    public static String getSmsUser() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.SMS_USER);
    }

    /**
     * 获得SMS用户密码
     *
     * @return SMS用户密码
     */
    public static String getSmsPwd() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.SMS_PWD);
    }

    /**
     * 获得价盘同步URL
     *
     * @return WMS FTP IP
     */
    public static String getBatchPlateUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.BATCH_PLATE_URL);
    }

    /**
     * 获得价盘通道同步URL
     *
     * @return WMS FTP IP
     */
    public static String getBatchWayUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.BATCH_WAY_URL);
    }

    /**
     * 获得分单URL
     *
     * @return WMS FTP IP
     */
    public static String getDistributeUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.BATCH_DISTRIBUTE_URL);
    }

    /**
     * SMS發送的URL
     *
     * @return SMS發送的URL
     */
    public static String getSmsSendUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.SMS_SEND_URL);
    }

    /**
     * 文件服务器上传URL
     *
     * @return 文件服务器上传URL
     */
    public static String getFileServerUpload() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.FILE_SERVER_UPLOAD);
    }

    /**
     * 文件服务器下载URL
     *
     * @return 文件服务器下载URL
     */
    public static String getFileServer() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.FILE_SERVER);
    }

    /**
     * 获得系统版本
     *
     * @return 系统版本
     */
    public static String getSystemVersion() {

        // 系统版本：工程版本号.SVN版本号
        String projectVersion = config.getProjectVersion();
        String svnVersion = config.getSvnVersion();
        if ("-1".equals(svnVersion) || "${svn.revision}".equals(svnVersion)) {
            svnVersion = "0";
        }
        String subSvnVersion = config.getSvnSubVersion();
        if (StringUtil.isNullOrEmpty(subSvnVersion) || "-1".equals(subSvnVersion)
                || "${svn.committedRevision}".equals(subSvnVersion)) {
            subSvnVersion = "0";
        }
        String buildDate = config.getBuildTime();
        if ("${maven.timestamp}".equals(buildDate)) {
            buildDate = "0";
        }
        // 指定的系统版本标识
        String versionMark = config.getVersionMark();
        if (StringUtil.isEmpty(versionMark) || "${version.mark}".equals(versionMark)) {
            versionMark = "GM";
        }

        return StringUtil.formatMessage("{0}.{1}_{2}_{3} ({4})", projectVersion, buildDate, versionMark, svnVersion, subSvnVersion);
    }

    /**
     * 获得系统环境区分
     *
     * @return 系统环境区分
     */
    public static String getSystemEnvTitle() {
        // 系统环境区分
        String env = CONFIG_VALUES_MAP.get(ConfigConstantDef.SYS_ENV);
        String envTitle = "";
        if (!StringUtil.isEmpty(env) && !"prod".equalsIgnoreCase(env)) {
            envTitle = StringUtil.formatMessage("[{0}]", env.toUpperCase());
        }
        return envTitle;
    }

    /**
     * 是否调试模式
     *
     * @return true：调试模式
     */
    public static boolean isDebug() {
        boolean isDebug = false;

        String debugFlag = CONFIG_VALUES_MAP.get(ConfigConstantDef.SYS_ISDEBUG);
        for (String flag : TRUE_FLAG) {
            if (flag.equalsIgnoreCase(debugFlag)) {
                isDebug = true;
                break;
            }
        }

        return isDebug;
    }

    /**
     * 是否需要权限校验
     *
     * @return true：需要权限校验
     */
    public static boolean needAuthCheck() {
        boolean needAuthCheck = false;

        String authFlag = CONFIG_VALUES_MAP.get(ConfigConstantDef.SYS_NEEDAUTHCHECK);
        for (String flag : TRUE_FLAG) {
            if (flag.equalsIgnoreCase(authFlag)) {
                needAuthCheck = true;
                break;
            }
        }

        return needAuthCheck;
    }

    /**
     * 取得SSO服务器外网地址。
     *
     * @return SSO服务器地址
     */
    public static String getSsoUrlOutside() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.SSO_URL_OUTSIDE);
    }

    /**
     * 取得SSO服务器内网地址。
     *
     * @return SSO服务器地址
     */
    public static String getSsoUrlInside() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.SSO_URL_INSIDE);
    }

    /**
     * 取得收藏夹地址。
     *
     * @return 取得收藏夹地址。
     */
    public static String getFavoritesUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.FAVORITES_URL);
    }

    /**
     * 取得HTTP正向代理主机IP（没设表示没有代理）。
     *
     * @return HTTP正向代理主机IP
     */
    public static String getProxyHost() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.PROXY_HOST);
    }

    /**
     * 取得HTTP正向代理主机端口（没设表示没有代理）。
     *
     * @return HTTP正向代理主机端口
     */
    public static String getProxyPort() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.PROXY_PORT);
    }

    /**
     * 取得Web站点地址。
     *
     * @return Web站点地址
     */
    public static String getWebServerUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.WEB_SERVER);
    }

    /**
     * 取得内部API调用根地址。
     *
     * @return 内部API调用根地址
     */
    public static String getApiServerUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_SERVER);
    }

    /**
     * 获得价盘查询箱价接口的地址
     *
     * @return 查询箱价地址
     */
    public static String getApiSearchPriceUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_URL_PRICE);
    }
    // #1129 add by sjj 20160712 start

    /**
     * 获得查询打印订单详细信息接口地址
     *
     * @return 查询打印订单详细信息接口地址
     */
    public static String getApiSearchPrintOrderUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_URL_SEARCH_PRINT_ORDER);
    }

    /**
     * 获得打印订单详细信息接口地址
     *
     * @return 打印订单详细信息接口地址
     */
    public static String getApiPrintOrderUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_URL_PRINT_ORDER);
    }
    // #1129 add by sjj 20160712 end

    // Modify for bug#1410 at 2016/07/21 by wang_jianzhou Start.
    public static String getTempFileLoacalPath() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.TEMP_FILE_LOCALPATH);
    }
    // Modify for bug#1410 at 2016/07/21 by wang_jianzhou end.

    // # add by sjj 20160725 start

    /**
     * 获得交易明细接口地址
     *
     * @return 交易明细接口地址
     */
    public static String getCpTransactionUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_URL_CP_TRANSACTION);
    }

    /**
     * 获得卖家计费项接口地址
     *
     * @return 卖家计费项接口地址
     */
    public static String getCpSellerChargingUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_URL_CP_SELLERCHARGING);
    }
    // # add by sjj 20160725 end


    /**
     * 获得价盘通道信息接口地址
     *
     * @return 价盘通道信息接口地址
     */
    public static String getPriceWayListUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_URL_GET_PRICE_WAY);
    }


    // #1766 add by likai 20160811 start

    /**
     * 获得查询打印发货入库单详细信息接口地址
     *
     * @return 查询打印发货入库单详细信息接口地址
     */
    public static String getApiSearchPrintDeliveryUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_URL_SEARCH_PRINT_Delivery);
    }

    /**
     * 获得打印发货入库单详细信息接口地址
     *
     * @return 打印发货入库单详细信息接口地址
     */
    public static String getApiPrintDsUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_URL_PRINT_Ds);
    }
    // #1766 add by likai 20160811 end

    public static String getServerName() {
        return config.getServerName();
    }

    public static String getOrgServer() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.ORG_SERVER);
    }

    public static String getSellerServer() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.SELLER_SERVER);
    }

    /**
     * 获得买家编码接口地址
     *
     * @return 查询买家编码接口地址
     */
    public static String getBuyerCodeUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_URL_GET_BUYER_CODE);
    }

    /**
     * 获得买家ID接口地址
     *
     * @return 查询买家ID接口地址
     */
    public static String getBuyerIdUrl() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.API_URL_GET_BUYER_ID);
    }

    /**
     * 是否强制修改密码
     *
     * @return 是否强制修改密码
     */
    public static String isForceModifyPassword() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.IS_FORCE_MODIFY_PASSWORD);
    }

    /**
     * 密码是否会过期开关
     *
     * @return 密码是否会过期开关
     */
    public static String isCheckPasswordTimeSeries() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.IS_CHECK_PASSWORD_TIME_SERIES);
    }

    /**
     * 是否初始化密码开关
     *
     * @return 是否初始化密码开关
     */
    public static String isInitPassword() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.IS_INIT_PASSWORD);
    }

    /**
     * 获取smtp server
     * @return
     */
    public static String getMailHost(){
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_HOST);
    }

    /***
     * 获取登录邮箱的用户名
     * @return
     */
    public static String getMailUserName(){
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_USERNAME);
    }

    /**
     * 获取登录邮箱的用户名的密码
     * @return
     */
    public static String getMailPassWord(){
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_PASSWORD);
    }

    /***
     * 获取邮箱来源
     * @return
     */
    public static String getMailFrom(){
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_FROM);
    }

    /**
     * 获取邮箱服务器端口
     * @return
     */
    public static String getMailServerPort(){
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_PORT);
    }

    /**
     * 获取邮箱发送人名称
     * @return
     */
    public static String getMailSender(){
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_SENDER);
    }

    /**
     * 是否开启ssl
     * @return
     */
    public static String getMailSsl(){
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_SSL);
    }

    /**
     * 代理服务器的Host
     * @return
     */
    public static String getMailProxyHost(){
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_PROXYHOST);
    }

    /**
     * 代理服务器的端口
     * @return
     */
    public static int getMailProxyPort(){
        String port = CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_PROXYPORT);
        return StringUtil.toInteger(StringUtil.isNullOrEmpty(port)?0:port);
    }

    /**
     * 获得文件上传内网地址
     *
     * @return 文件上传内网地址
     */
    public static String getFileServerUploadInside() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.FILE_SERVER_UPLOAD_INSIDE);
    }

    /**
     * 获得文件下载内网地址
     *
     * @return 获得文件下载内网地址
     */
    public static String getFileServerDownloadInside() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.FILE_SERVER_DOWNLOAD_INSIDE);
    }

    /**
     * html格式邮件发送
     *
     * @return html格式邮件发送
     */
    public static String getMailHtmlSend() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_HTML_SEND);
    }

    /**
     * 简单邮件发送
     *
     * @return 简单邮件发送
     */
    public static String getMailSimpleSend() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_SIMPLE_SEND);
    }

    /**
     * 模板邮件发送
     *
     * @return 模板邮件发送
     */
    public static String getMailTemplateSend() {
        return CONFIG_VALUES_MAP.get(ConfigConstantDef.MAIL_TEMPLATE_SEND);
    }
}
