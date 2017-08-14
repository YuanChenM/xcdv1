/**
 * IMS112102Logic.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.Md5Digest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * IMS112102Logic.
 *
 * @author rwf
 */
@Service
public class IMS112102Logic extends BaseLogic {
    /**
     * SqlId.
     * 
     * @author rwf
     */
    interface SqlId {
        static final String SQL_ID_SEARCH_MSCARDNO_BY_BUYERCODE = "searchMsCardNoByBuyerCode";
    }

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IMS112102Logic.class);
    /**拼接url地址*/
    String startFlag = "smallant1aopreq20150818110359rYrQQeEZ";
    String app_key = "smallant";
    String format = "json";
    String method = "allinpay.ppcs.cardinfo.get";
    String method2 = "allinpay.ppcs.txnlog.search";
    String page_no = "1";
    String page_size = "100";
    String sign_v = "1";
    String status = "2";
    
    /**
     * @param card_code 卡编号
     * @return String 本月消费金额字符串 拼接通联Url
     */
    public String getUrl0(String card_code) {
        /** 获取当前时间 */
        Date nowDate = DateTimeUtil.getCustomerDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = simpleDateFormat.format(nowDate);
        // 截取开始时间
        String beginDate = timestamp.substring(0, NumberConst.IntDef.INT_SIX) + "01";
        // 截取结束时间
        String endDate = timestamp.substring(0, NumberConst.IntDef.INT_EIGHT);
        // 签名前的查询本月卡消费总金额信息字符串
        String signSearch = startFlag + "app_key" + app_key + "begin_date" + beginDate + "card_id" + card_code
                + "end_date" + endDate + "format" + format + "method" + method2 + "page_no" + page_no + "page_size"
                + page_size + "sign_v" + sign_v + "status" + status + "timestamp" + timestamp + "v1.0" + startFlag;
        // 签名后查询本月卡消费总金额信息的字符串
        String preSignSearch = Md5Digest.digest(signSearch).toUpperCase();
        // 查询本月消费记录路径
        String afterSignSearch = "http://wxtest.ulinkpay.com/aop/rest?app_key=" + app_key + "&begin_date=" + beginDate
                + "&card_id=" + card_code + "&end_date=" + endDate + "&format=json&method=" + method2
                + "&page_no=1&page_size=100&sign=" + preSignSearch + "&sign_v=1&status=2&timestamp=" + timestamp
                + "&v=1.0";
        return afterSignSearch;
    }
    
    
    /**
     * @param card_code 卡编号
     * @return String 查询余额
     *         拼接通联Url
     */
    public String getUrl1(String card_code) {
        /** 获取当前时间 */
        Date nowDate = DateTimeUtil.getCustomerDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = simpleDateFormat.format(nowDate);
        // 签名前的查询余额字符串
        String preSignature = startFlag + "app_key" + app_key + "card_id" + card_code + "formatjsonmethod" + method
                + "sign_v1timestamp" + timestamp + "v1.0" + startFlag;
        // 签名后的查询余额sign
        String Signature = Md5Digest.digest(preSignature).toUpperCase();
        // 查询余额路径
        String afterSignSearchBalance = "http://wxtest.ulinkpay.com/aop/rest?app_key=" + app_key + "&card_id="
                + card_code + "&format=json&method=" + method + "&sign=" + Signature + "&sign_v=1&timestamp="
                + timestamp + "&v=1.0";
        return afterSignSearchBalance;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        logger.info("调用baseDao");
        super.setBaseDao(baseDao);
    }
}
