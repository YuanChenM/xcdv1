/**
 * IMS112103Logic.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.Md5Digest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * IMS112103Logic.
 *
 * @author rwf
 */
@Service
public class IMS112103Logic extends BaseLogic {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IMS112103Logic.class);
    /**
     * @param startTime 接收的开始日期
     * @param endTime 接收的结束日期
     * @param cardCode 查询出来的会员卡编号
     * @return String 返回url路径
     * @author rwf
     *         拼接通联路径的接口(含参数)
     */
    public String getUrl(Date startTime, Date endTime, String cardCode) {
        logger.info("获取通联接口路径");
        /** 获取当前时间 */
        Date nowDate = DateTimeUtil.getCustomerDate();
        String startFlag = "smallant1aopreq20150818110359rYrQQeEZ";
        String app_key = "smallant";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String startDate = simpleDateFormat.format(startTime);
        String endDate = simpleDateFormat.format(endTime);
        String format = "json";
        String method = "allinpay.ppcs.txnlog.search";
        String page_no = "1";
        String page_size = "100";
        String sign_v = "1";
        String status = "2";
        SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sim.format(nowDate);
        String v = "1.0";
        // 签名前
        String preSign = startFlag + "app_key" + app_key + "begin_date" + startDate + "card_id" + cardCode + "end_date"
                + endDate + "format" + format + "method" + method + "page_no" + page_no + "page_size" + page_size
                + "sign_v" + sign_v + "status" + status + "timestamp" + timestamp + "v" + v + startFlag;
        // 签名后
        String afterSign = Md5Digest.digest(preSign).toUpperCase();
        // 拼接访问路径
        String url = "http://wxtest.ulinkpay.com/aop/rest?app_key=" + app_key + "&begin_date=" + startDate + "&card_id="
                + cardCode + "&end_date=" + endDate + "&format=" + format + "&method=" + method + "&page_no=" + page_no
                + "&page_size=" + page_size + "&sign=" + afterSign + "&sign_v=" + sign_v + "&status=" + status
                + "&timestamp=" + timestamp + "&v=" + v;
        return url;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        logger.info("调用baseDao");
        super.setBaseDao(baseDao);
    }
}
