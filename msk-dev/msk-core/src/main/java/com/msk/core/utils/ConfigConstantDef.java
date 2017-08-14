package com.msk.core.utils;

/**
 * ConfigConstantDef
 *
 * @author jiang_nan
 * @version 1.0
 **/
public interface ConfigConstantDef {
    /** 系统环境区分 */
    String SYS_ENV = "sys.env";
    /** 调试开关 */
    String SYS_ISDEBUG = "sys.isDebug";
    /** 权限控制开关 */
    String SYS_NEEDAUTHCHECK = "sys.needAuthCheck";
    String FTP_IP = "ftp.ip";
    String FTP_USER = "ftp.user";
    String FTP_PWD = "ftp.pwd";
    String FTP_HTTP = "ftp.http.url";
    String FTP_IMAGE_ROOT_PATH = "ftp.imageRootPath";
    String WMS_FTP_IP = "wms.ftp.ip";
    String WMS_FTP_USER = "wms.ftp.user";
    String WMS_FTP_PWD = "wms.ftp.pwd";
    String SUPPLIER_DEPT_ID = "supplier_dept_id";
    String SUPPLIER_ROLE_ID = "supplier_role_id";
    /** 短信API地址 */
    String SMS_URL = "SMS.URL";
    /** 短信供应商编码 */
    String SMS_SUPPLIER = "SMS.SUPPLIER";
    /** 短信用户 */
    String SMS_USER = "SMS.USER";
    /** 短信密码 */
    String SMS_PWD = "SMS.PWD";

    String BATCH_PLATE_URL = "batch.plateUrl";
    String BATCH_WAY_URL = "batch.wayUrl";
    String BATCH_DISTRIBUTE_URL = "batch.distributeUrl";

    String SMS_SEND_URL = "SMS.SEND.URL";
    String FILE_SERVER_UPLOAD = "file.server.upload";
    String FILE_SERVER = "file.server";

    /** SSO站点外网地址 */
    String SSO_URL_OUTSIDE = "sso.url.outside";
    /** SSO站点内网地址 */
    String SSO_URL_INSIDE = "sso.url.inside";
    /** HTTP正向代理主机IP（没设表示没有代理） */
    String PROXY_HOST = "http.proxyHost";
    /** HTTP正向代理主机端口（没设表示没有代理） */
    String PROXY_PORT = "http.proxyPort";
    /** Web站点地址 */
    String WEB_SERVER = "web.server.url";
    /** 内部API调用根地址 */
    String API_SERVER = "api.url.inside";
    /** 价盘查询箱价地址 */
    String API_URL_PRICE = "api.url.searchPrice";
    // #1129 add by sjj 20160712 start
    /** 查询打印订单详细信息接口地址 */
    String API_URL_SEARCH_PRINT_ORDER = "api.url.searchPrintOrder";
    /** 打印订单详细信息接口地址 */
    String API_URL_PRINT_ORDER = "api.url.printOrder";
    // #1129 add by sjj 20160712 end
    /** 价盘通道信息接口地址 */
    String API_URL_GET_PRICE_WAY = "api.url.getPriceWay";

    /** #1766 add by likai 20160811 start*/
    /** 查询打印发货入库单详细信息接口地址 */
    String API_URL_SEARCH_PRINT_Delivery = "api.url.searchPrintDelivery";
    /** 打印发货入库单详细信息接口地址 */
    String API_URL_PRINT_Ds = "api.url.printDs";
    /** #1766 add by likai 20160811 end */

    // Modify for bug#1410 at 2016/07/21 by wang_jianzhou Start.
    String TEMP_FILE_LOCALPATH = "temp.file.localPath";
    // Modify for bug#1410 at 2016/07/21 by wang_jianzhou end.
    // # add by sjj 20160725 start
    /** 交易明细接口地址 */
    String API_URL_CP_TRANSACTION = "api.url.transaction";
    /** 卖家计费项接口地址 */
    String API_URL_CP_SELLERCHARGING = "api.url.sellerCharging";
    // # add by sjj 20160725 end

    String ORG_SERVER = "org.server";
    String SELLER_SERVER = "seller.server";

    String API_URL_GET_BUYER_CODE = "api.url.getBuyerCode";
    String API_URL_GET_BUYER_ID = "api.url.getBuyerId";

    /** 取得收藏夹地址 */
    String FAVORITES_URL = "favorites.url";
    //是否强制修改密码
    String IS_FORCE_MODIFY_PASSWORD = "isForceModifyPassword.flag";
    //密码是否会过期开关
    String IS_CHECK_PASSWORD_TIME_SERIES = "isCheckPasswordTimeSeries.flag";
    //是否初始化密码开关
    String IS_INIT_PASSWORD = "isInitPassword.flag";

    /**邮件服务器**/
    // SMTP server host
    String MAIL_HOST = "mail.host";
    // SMTP server port
    String MAIL_PORT = "mail.port";
    String MAIL_FROM = "mail.from";
    // Login user of the SMTP server.
    String MAIL_USERNAME = "mail.username";
    //  Login password of the SMTP server
    String MAIL_PASSWORD = "mail.password";
    // 邮箱发送人名称
    String MAIL_SENDER = "mail.sender";
    // 是否启动ssl
    String MAIL_SSL = "mail.ssl";
    // 代理服务器
    String MAIL_PROXYHOST = "mail.proxyHost";
    // 代理服务器的端口
    String MAIL_PROXYPORT = "mail.proxyPort";

    /**文件上传(内网地址)*/
    String FILE_SERVER_UPLOAD_INSIDE="file.server.upload.inside";
    /**文件下载(内网地址)*/
    String FILE_SERVER_DOWNLOAD_INSIDE="file.server.download.inside";
    /**html格式邮件发送*/
    String MAIL_HTML_SEND = "mail.html.send";
    /**简单邮件发送*/
    String MAIL_SIMPLE_SEND = "mail.simple.send";
    /**模板邮件发送*/
    String MAIL_TEMPLATE_SEND = "mail.template.send";

}

