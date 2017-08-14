package com.msk.core.mail;

import com.msk.core.exception.SystemException;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.StringUtil;
import org.apache.commons.mail.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Properties;

/**
 * Mail对象的Factory.
 * 
 * @author jiang_nan
 */
public class MailFactory implements Serializable {
    private static Logger logger = LoggerFactory.getLogger(MailFactory.class);
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    private String hostName = ConfigManager.getMailHost();
    private int smtpPort = StringUtil.toInteger(ConfigManager.getMailServerPort());
    private String fromMail = ConfigManager.getMailFrom();
    private String authPwd = ConfigManager.getMailPassWord();
    private String authUserName = ConfigManager.getMailUserName();
    private int socketConnectionTimeout;
    private int socketTimeout;
    /** 邮件发送人名称 */
    private String sender = ConfigManager.getMailSender();
    /**是否启动ssl**/
    private Boolean mailSsl = Boolean.valueOf(ConfigManager.getMailSsl());
    // 代理服务器
    private String proxyHost= ConfigManager.getMailProxyHost();
    // 代理服务器的端口
    private int proxyPort=ConfigManager.getMailProxyPort();
    /**
     * The Constructors Method.
     * 
     * @author jiang_nan
     */
    public MailFactory(String hostName, int smtpPort, String fromMail, String authPwd, String authUserName,
        String sender) {
        this.hostName = hostName;
        this.smtpPort = smtpPort;
        this.fromMail = fromMail;
        this.authPwd = authPwd;
        this.authUserName = authUserName;
        this.sender = sender;
    }

    /**
     * The Constructors Method.
     * 
     * @author jiang_nan
     */
    public MailFactory() {

    }

    /**
     * 创建普通的Mail,只支持普通简单的邮件发送
     * 
     * @return simpleEmail
     * @throws org.apache.commons.mail.EmailException the EmailException
     *
     * @author jiang_nan
     */
    public Email createSimpleEmail() throws EmailException {
        Email simpleEmail = new SimpleEmail();
        this.initMailParam(simpleEmail);
        return simpleEmail;
    }

    /**
     * 创建包含附件的Mail
     *
     * @return MultiPartEmail
     * @throws org.apache.commons.mail.EmailException the EmailException
     *
     * @author jiang_nan
     */
    public Email createMultiPartEmail() throws EmailException {
        Email multiPartEmail = new MultiPartEmail();
        this.initMailParam(multiPartEmail);
        return multiPartEmail;
    }

    /**
     * 创建HTML格式的邮件
     *
     * @return HtmlEmail
     * @throws org.apache.commons.mail.EmailException the EmailException
     * @author jiang_nan
     */
    public Email createHtmlEmail() throws EmailException {
        Email htmlEmail = new HtmlEmail();
        this.initMailParam(htmlEmail);
        return htmlEmail;
    }

    /**
     * 初始化Mail参数
     *
     * @param mail Mail对象
     * @throws org.apache.commons.mail.EmailException the EmailException
     * @author jiang_nan
     */
    private void initMailParam(Email mail) throws EmailException {
        if (mail == null) {
            throw new SystemException("设置邮箱参数失败,邮箱对象为Null");
        }
        mail.setHostName(this.hostName);
        mail.setSmtpPort(this.smtpPort);
        mail.setAuthentication(this.authUserName, this.authPwd);// 邮件服务器验证：用户名/密码
        mail.setCharset("UTF-8");// 必须放在前面，否则乱码
        mail.setFrom(this.fromMail, this.sender);
        mail.setSSLOnConnect(this.mailSsl);
        mail.setSocketConnectionTimeout(socketConnectionTimeout);
        mail.setSocketTimeout(socketTimeout);
        if(!StringUtil.isEmpty(this.proxyHost) && this.proxyPort>0){
            Properties properties = System.getProperties();
            properties.setProperty("socksProxyHost",this.proxyHost);
            properties.setProperty("socksProxyPort",StringUtil.toString(this.proxyPort));
        }
        logger.info("邮件服务器Host：{},邮件服务端口：{},邮件服务器验证：用户名:{},密码:{},发送邮箱：{}，是否启用SSL:{},代理服务器Host：{},代理服务器端口：{}",
                this.hostName,this.smtpPort,this.authUserName,this.authPwd,this.fromMail,this.mailSsl,this.proxyHost,this.proxyPort);
    }
}
