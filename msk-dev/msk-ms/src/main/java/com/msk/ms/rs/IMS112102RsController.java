/**
 * IMS112102RsController.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.rs;

import com.msk.core.web.consts.BusinessConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.MsCardmanager;
import com.msk.core.exception.BusinessException;
import com.msk.common.utils.*;
import com.msk.core.utils.StringUtil;
import com.msk.core.annotation.Validator;
import com.msk.ms.bean.*;
import com.msk.ms.logic.IMS112102Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * IMS112102RsController.
 *
 * @author rwf
 */
@RestController
public class IMS112102RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IMS112102RsController.class);
    @Autowired
    private RsClientUtil rsClientUtil;
    @Autowired
    private IMS112102Logic ims112102Logic;

    /**
     * SqlId.
     * 
     * @author rwf
     */
    interface SqlId {
        static final String SQL_ID_SEARCH_MSCARDNO_BY_BUYERCODE = "searchMsCardNoByBuyerCode";
    }

    /**
     * @return RsResponse<IMS112101RsResult>
     * @param param 参数
     * @author rwf
     * @throws IOException
     * @throws ClientProtocolException
     * 
     */
    @RequestMapping(value = "/api/v1/ms/msbasic",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.ms.validator.IMS112102Validator")
    public RsResponse<IMS112102RsResult> msbasic(@RequestBody RsRequest<IMS112102RsParam> param) {
        logger.info("会员卡基本信息查询");
        RsResponse<IMS112102RsResult> rs = new RsResponse<IMS112102RsResult>();
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("userId", param.getParam().getUserID());
        //根据用户userId查询用户是否存在 
        MsCardmanager ms = this.ims112102Logic.findOne(SqlId.SQL_ID_SEARCH_MSCARDNO_BY_BUYERCODE, baseParam);
        if (null == ms) {
            throw new BusinessException("不存在用户:" + param.getParam().getUserID());
        }
        // 查询会员卡表 查询用户cardNo buyerName ExpireDate MsNowpw
        IMS112102RsResult ims112102RsResult = new IMS112102RsResult();
        String card_code = StringUtil.toSafeString(ms.getMsCardno());
        ims112102RsResult.setCardNo(card_code);
        ims112102RsResult.setUserName(StringUtil.toSafeString(ms.getBuyerName()));
        ims112102RsResult.setExpireDate(ms.getExpireDate());
        ims112102RsResult.setPassword(StringUtil.toSafeString(ms.getMsNowpw()));
        //获取查询本月消费的每一条记录
        String string0 = this.ims112102Logic.getUrl0(card_code);
        if (null == string0) {
            throw new BusinessException("查询本月消费金额失败");
        }
        CIMS112103RsResult cims112103RsResult = this.rsClientUtil.getRsService(string0, CIMS112103RsResult.class);
        if (null == cims112103RsResult) {
            throw new BusinessException("查询本月消费金额失败");
        }
        if(null==cims112103RsResult.getPpcs_txnlog_search_response()){
            throw new BusinessException("查询本月消费金额失败");
        }
        if(null==cims112103RsResult.getPpcs_txnlog_search_response().getTxn_log_arrays()){
            throw new BusinessException("查询本月消费金额失败");
        }
        if(null==cims112103RsResult.getPpcs_txnlog_search_response().getTxn_log_arrays().getTxn_log()){
            throw new BusinessException("查询本月消费金额失败");
        }
        ArrayList<CIMS112103RsResultTxnLog> list = cims112103RsResult.getPpcs_txnlog_search_response().getTxn_log_arrays().getTxn_log();
        double d = 0;
        //循环求出本月消费总金额
        for (CIMS112103RsResultTxnLog t : list) {
            if (t.getTxn_cd().equals("B0020") && t.getTxn_sta_cd().equals("2")) {
                d = t.getTxn_at() + d;
            }
        }
        //获取查询会员信息的通联接口路径
        String string1 = this.ims112102Logic.getUrl1(card_code);
        if (null == string1) {
            throw new BusinessException("查询余额信息失败");
        }
        CIMS112102RsResult2 cims112102RsResult2 = this.rsClientUtil.getRsService(string1, CIMS112102RsResult2.class);
        if (null == cims112102RsResult2) {
            throw new BusinessException("查询余额信息失败");
        }
        if(null==cims112102RsResult2.getPpcs_cardinfo_get_response()){
            throw new BusinessException("查询余额信息失败");
        }
        if(null==cims112102RsResult2.getPpcs_cardinfo_get_response().getCard_info()){
            throw new BusinessException("查询余额信息失败");
        }
        if(null==cims112102RsResult2.getPpcs_cardinfo_get_response().getCard_info().getCard_product_info_arrays()){
            throw new BusinessException("查询余额信息失败");
        }
        if(null==cims112102RsResult2.getPpcs_cardinfo_get_response()
                .getCard_info().getCard_product_info_arrays().getCard_product_info()){
            throw new BusinessException("查询余额信息失败");
        }
        if(null==cims112102RsResult2.getPpcs_cardinfo_get_response()
                .getCard_info().getCard_product_info_arrays().getCard_product_info().get(0).getAccount_balance()){
            throw new BusinessException("查询余额信息失败");
        }
        //当返回结果不为空时，循环
        ims112102RsResult.setBalance(StringUtil.toBigDecimal(cims112102RsResult2.getPpcs_cardinfo_get_response()
            .getCard_info().getCard_product_info_arrays().getCard_product_info().get(0).getAccount_balance()));
        ims112102RsResult.setMonthUsedMoney(StringUtil.toBigDecimal(d));
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("处理成功！");
        rs.setResult(ims112102RsResult);

        return rs;

    }
}
