/**
 * IMS112103RsController.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.rs;

import com.msk.core.web.base.BaseRsController;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.MsCardmanager;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.common.utils.RsClientUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.annotation.Validator;
import com.msk.ms.bean.*;
import com.msk.ms.logic.IMS112103Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * IMS112103RsController.
 *
 * @author rwf
 */
@RestController
public class IMS112103RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IMS112103RsController.class);
    @Autowired
    private RsClientUtil rsClientUtil;
    @Autowired
    private IMS112103Logic ims112103Logic;

    /**
     * @return RsResponse<IMS112101RsResult>
     * @param param 参数
     * @author rwf
     * @throws java.text.ParseException string 格式化日期
     * @throws java.io.IOException
     * @throws org.apache.http.client.ClientProtocolException
     * 
     */
    @RequestMapping(value = "/api/v1/ms/msconsume",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.ms.validator.IMS112103Validator")
    public RsResponse<IMS112103RsResult> msConsume(@RequestBody RsRequest<IMS112103RsParam> param)
        throws ParseException {
        logger.info("会员卡消费信息查询");
        RsResponse<IMS112103RsResult> rsResponseList = new RsResponse<IMS112103RsResult>();
        IMS112103RsResult ims = new IMS112103RsResult();
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("userId", param.getParam().getUserID());
        MsCardmanager ms = this.ims112103Logic.findOne(baseParam);
        if (null == ms) {
            throw new BusinessException("没有查询到该用户会员卡信息");
        }
        Date startDate = param.getParam().getStartDate();
        Date endDate = param.getParam().getEndDate();
        String cardCode = ms.getMsCardno();
        if (endDate.getTime() - startDate.getTime() < 0) {
            throw new BusinessException("结束时间应该大于开始时间");
        }
        String url = this.ims112103Logic.getUrl(startDate, endDate, cardCode);
        CIMS112103RsResult cims = this.rsClientUtil.getRsService(url, CIMS112103RsResult.class);
        ArrayList<IMS112103RsResultArray> list = new ArrayList<IMS112103RsResultArray>();
        if (null == cims) {
            throw new BusinessException("查询消费信息失败");
        }
        if (null == cims.getPpcs_txnlog_search_response()) {
            throw new BusinessException("查询消费信息失败");
        }
        if (null == cims.getPpcs_txnlog_search_response().getTxn_log_arrays()) {
            throw new BusinessException("查询消费信息失败");
        }
        if (null == cims.getPpcs_txnlog_search_response().getTxn_log_arrays().getTxn_log()) {
            throw new BusinessException("查询消费信息失败");
        }
        for (CIMS112103RsResultTxnLog tx : cims.getPpcs_txnlog_search_response().getTxn_log_arrays().getTxn_log()) {
            IMS112103RsResultArray ims112103Arr = new IMS112103RsResultArray();
            String txn_dt = tx.getInt_txn_dt();
            // 截取时间字符串 获取年月日时分秒
            String year = txn_dt.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_FOUR);
            String month = txn_dt.substring(NumberConst.IntDef.INT_FOUR, NumberConst.IntDef.INT_SIX);
            String day = txn_dt.substring(NumberConst.IntDef.INT_SIX, NumberConst.IntDef.INT_EIGHT);
            String HH = tx.getInt_txn_tm().substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_TWO);
            String mm = tx.getInt_txn_tm().substring(NumberConst.IntDef.INT_TWO, NumberConst.IntDef.INT_FOUR);
            String ss = tx.getInt_txn_tm().substring(NumberConst.IntDef.INT_FOUR, NumberConst.IntDef.INT_SIX);
            // 拼接时间字符串
            String dateString = year + "-" + month + "-" + day + " " + HH + ":" + mm + ":" + ss;
            Date date = DateTimeUtil.parseDate(dateString, "yyyy-MM-dd HH:mm:ss");
            ims112103Arr.setConsumptionDate(date);
            ims112103Arr.setConsumptionAmount(StringUtil.toBigDecimal(tx.getTxn_at()));
            ims112103Arr.setConsumptionOrderNo(tx.getInt_txn_seq_id());
            list.add(ims112103Arr);
        }
        ims.setConsumptionlist(list);
        rsResponseList.setResult(ims);
        return rsResponseList;
    }

}
