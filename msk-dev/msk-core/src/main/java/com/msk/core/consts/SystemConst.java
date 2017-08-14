package com.msk.core.consts;

/**
 * SystemConst
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class SystemConst {

    /**
     * 默认值
     */
    public final static class Default {
        /** 时区 */
        public final static String TIMEZONE = "GMT+8";
        /** 显示日期格式 */
        public final static String FORMAT_DATE = "yyyy-MM-dd";
        /** 显示日期时间格式 */
        public final static String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
        /** 字符编码 */
        public final static String ENCODING = Encoding.UTF8;
    }

    /**
     * 字符编码
     */
    public final static class Encoding {
        /** UTF-8 */
        public final static String UTF8 = "UTF-8";
    }

    /**
     * 字符编码
     */
    public final static class ContentType {
        /** JSON */
        public final static String JSON = "application/json";
    }

    /**
     * 接口返回结果状态
     *
     * @author mabo
     */
    public final static class RsStatus {
        /** 处理成功 */
        public final static String SUCCESS = "S";
        /** 处理失败 */
        public final static String FAIL = "F";
    }

    /**
     * 删除标签
     *
     * @author mabo
     */
    public final static class DelFlg {
        /** 处理成功 */
        public final static String ENABLE = "0";
        /** 处理失败 */
        public final static String DISABLE = "1";
    }
}
