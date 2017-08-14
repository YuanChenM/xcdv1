package com.msk.batch.wq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 类描述：Md5加密
 * 用于调用外勤365的api时进行数据签名
 */
public class Md5 {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(Md5.class);

    /**
     * Md5加密
     *
     * @param param 加密前内容
     * @return 加密后的签名
     */
    public static String encode(String param) {
        if (param == null) {
            return null;
        }
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] result = md5.digest(param.getBytes("UTF-8"));
            return byte2String(result);
        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5签名失败。", e);
            return null;
        } catch (UnsupportedEncodingException e) {
            logger.error("MD5签名失败。", e);
            return null;
        }
    }

    /**
     * 字节数组转字符串
     *
     * @param in 字节数组
     * @return 字符串
     */
    private static String byte2String(byte[] in) {
        DataInputStream data = new DataInputStream(new ByteArrayInputStream(in));
        String str = "";
        try {
            for (int j = 0; j < in.length; j++) {
                String tmp = Integer.toHexString(data.readUnsignedByte());
                if (tmp.length() == 1) {
                    tmp = "0" + tmp;
                }
                str = str + tmp;
            }
        } catch (Exception ex) {
            logger.error("MD5签名失败。", ex);
        }
        return str;
    }

//	/**
//	 * Md5加密
//	 *
//	 * @param b 字节数组
//	 * @return 加密后的签名
//	 */
//	public static String encode(byte[] b)
//	{
//		MessageDigest md5 = null;
//		try
//		{
//			md5 = MessageDigest.getInstance("MD5");
//			byte[] result = md5.digest(b);
//			return byte2String(result);
//		}
//		catch (NoSuchAlgorithmException e)
//		{
//			return null;
//		}
//	}

}
