package com.msk.core.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.msk.core.exception.SystemException;

/**
 * Md5Digest
 *
 * @author jiang_nan
 * @version 1.0
 **/
public final class Md5Digest {
    /**
     * Md5 加密
     * @param code 字符串
     * @return 加过密的文本
     */
    public static String digest(String code) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(code.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new SystemException("MD5加密出现错误");
        }
    }

}
