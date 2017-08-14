package com.msk.sms.utils;

import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msk.core.consts.StringConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.StringUtil;

/**
 * Created by Administrator on 2016/3/28.
 */
public class SmsUtils {
    private static Logger logger = LoggerFactory.getLogger(SmsUtils.class);

    public static void sendCaptchaMessage(String mobile, String message) {
        logger.debug("手机号码：" + mobile + "短信内容：" + message);
        // 验证验证码是否有效
        if (!checkMessageValid(message)) {
            throw new BusinessException("该手机号码已经发送过信息");
        }
        // 判断手机号码是否已经发送过信息
        if (!checkCaptchaCode(mobile, message)) {
            throw new BusinessException("验证码错误");
        }
        // 判断手机号码是否已经发送过信息
        if (!isSendMessage(mobile)) {
            throw new BusinessException("该手机号码已经发送过信息");
        }
        try {
            HttpClient httpclient = new HttpClient();

            String proxyHost = ConfigManager.getProxyHost();
            // 针对内网服务器，设置代理
            if (!StringUtil.isEmpty(proxyHost)) {
                int proxyPort = StringUtil.toInteger(ConfigManager.getProxyPort());
                // 设置代理服务器的ip地址和端口
                httpclient.getHostConfiguration().setProxy(proxyHost, proxyPort);
                // 使用抢先认证
                httpclient.getParams().setAuthenticationPreemptive(true);
            }

            // PostMethod post = new PostMethod(ConfigManager.getSmsSendUrl());
            PostMethod post = new PostMethod(ConfigManager.getSmsUrl());
            post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "gbk");
            post.addParameter("SpCode", ConfigManager.getSmsSupplier());
            post.addParameter("LoginName", ConfigManager.getSmsUser());
            post.addParameter("Password", ConfigManager.getSmsPwd());
            post.addParameter("MessageContent", message);
            post.addParameter("UserNumber", mobile);
            post.addParameter("SerialNumber", StringConst.EMPTY);
            post.addParameter("ScheduleTime", StringConst.EMPTY);
            post.addParameter("ExtendAccessNum", StringConst.EMPTY);
            post.addParameter("f", "1");
            httpclient.executeMethod(post);
            String info = new String(post.getResponseBody(), "gbk");
            logger.debug(info);
        } catch (Exception e) {
            throw new BusinessException("验证码发送失败", e);
        }
    }

    public static boolean checkCaptchaCode(String message, String mobile) {
        return true;
    }

    public static boolean checkMessageValid(String message) {
        return true;
    }

    public static boolean isSendMessage(String mobile) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Date(1459351516246L));
    }

    /**
     * 创建指定数量的随机字符串
     * 
     * @param numberFlag 是否是数字
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;
    }

}
