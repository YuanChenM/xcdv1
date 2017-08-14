package com.msk.so.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoCpAccountBook;
import com.msk.core.entity.SoCpTransactionDetail;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.BookKeepingParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 *
 * 资金池记账共通Logic
 * Created by zhang_xi on 2016/3/10.
 *
 * ver 0.1
 */
@Service
public class BookKeepingLogic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BookKeepingLogic.class);

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SqlId. sql定义
     *
     * @author pxg
     */
    interface SqlId {
        String SQL_ID_SAVE_TRANS_DETAIL = "saveTransactionDetail";
    }

    /**
     * 记账开始
     * @param param 详细请查看接口定义
     * @return 处理结果
     */
    @Transactional
    public boolean updateOrSaveAmountRecord(RsRequest<BookKeepingParam> param) {
        boolean ret = true;
        BookKeepingParam cond = param.getParam();

        if(cond == null || !validatorData(param)){
            return false;
        }

        //1.是否有账套
        //收款方
        Long payeeAccountId = initAccount(cond.getPayeeCode(),
                cond.getPayeeRole(),
                new BigDecimal(NumberConst.IntDef.INT_ZERO),
                param.getLoginId());
        //付款方
        Long payerAccountId = initAccount(cond.getPayerCode(),
                cond.getPayerRole(),
                new BigDecimal(NumberConst.IntDef.INT_ZERO),
                param.getLoginId());

        //3.是否结算:已结算的情况
        if(cond.getIsPayed() == 0) {
            //3.1 计算账套金额 更新账套表
            //收款方
            if(payeeAccountId != null) {
                updateAccount(payeeAccountId, cond.getPayAmount());
            } else {
                updateAccount(cond.getPayeeCode(),cond.getPayeeRole(), cond.getPayAmount());
            }
            //付款方
            if(payeeAccountId != null) {
                updateAccount(payerAccountId, cond.getPayAmount().multiply(new BigDecimal(-1)));
            } else {
                updateAccount(cond.getPayerCode(),cond.getPayerRole(), cond.getPayAmount().multiply(new BigDecimal(-1)));
            }
        }

        //4.保存到交易明细表
        saveTransactionDetail(cond);

        return ret;
    }

    /**
     * check param
     * @param request
     */
    private boolean validatorData(RsRequest<BookKeepingParam> request) {
        boolean ret = true;
        BookKeepingParam rsParam = request.getParam();
        int nullNums = 0;
        if(null!=rsParam){
            nullNums += validatorRequired ("业务主体编码", rsParam.getPayeeCode());
            nullNums += validatorRequired("业务主体角色", rsParam.getPayeeRole());
            nullNums += validatorRequired("业务副体编码", rsParam.getPayerCode());
            nullNums += validatorRequired("业务副体角色", rsParam.getPayerRole());
            nullNums += validatorRequired("是否结算", rsParam.getIsPayed());
            nullNums += validatorRequired("支付金额", rsParam.getPayAmount());
            //0 主订单 1管理费用清单
            nullNums += validatorRequired("查询类型", rsParam.getSearchType());
            //0 订单确认金额 1卖家收款金额 2平台仓储金额 3用户退款金额
            //Todo 后期需要调整 1,2,3
            nullNums += validatorRequired("金额类型", rsParam.getAmountType());
            //1:在线支付,2:线下支付
            nullNums += validatorRequired("支付方式", rsParam.getClearingForm());
            //0 神农客 1美食客
            nullNums += validatorRequired("平台类型", rsParam.getPlateFormType());
            //订单编码、管理费单编码
            nullNums += validatorRequired("查询编码", rsParam.getSearchCode());
        }

        if(nullNums > 0){
            ret = false;
        }
        return ret;
    }

    /**
     * 验证一行中指定的字段值是否为空
     *
     * @param fieldName 字段名称
     * @param value 验证的数据
     */
    private int validatorRequired(String fieldName, Object value) {
        int isNull = 0;
        if (value instanceof String) {
            if (StringUtil.isEmpty((String) value)) {
                isNull = 1;
            }
        } else if (null == value) {
            isNull = 1;
        }

        return isNull;
    }

    /**
     *
     * @param code
     * @param role
     * @return
     */
    private Long getAccountBookId(String code, String role){
        Long bookId = null;
        BaseParam params = new BaseParam();
        params.setFilter("userId", code);
        params.setFilter("userRole", role);
        SoCpAccountBook accountBook = findOne(params);
        if(accountBook != null && accountBook.getAccountBookId() != null){
            bookId = accountBook.getAccountBookId();
        }
        return bookId;
    }

    /**
     *初始化账套
     * @param code
     * @param role
     * @param amount
     * @return
     */
    private Long initAccount(String code, String role, BigDecimal amount,String loginId){
        Long accountId = getAccountBookId(code, role);
        if(accountId == null) {
            //1.1没有账套，则初始化账套信息
            SoCpAccountBook accountBook = new SoCpAccountBook();
            accountBook.setUserNo(code);
            accountBook.setUserRole(role);
            accountBook.setBalance(amount);
            accountBook.setCreId(loginId);

            Long accountBookId = commonLogic.maxId("so_cp_account_book", "ACCOUNT_BOOK_ID");
            accountBook.setAccountBookId(accountBookId);
            accountBook.setCrtTime(DateTimeUtil.getCustomerDate());
            save(accountBook);
        }
        return accountId;
    }

    /**
     *计算账套金额 更新账套表
     * @param accountId
     * @param payAmount
     */
    private void updateAccount(Long accountId, BigDecimal payAmount) {
        SoCpAccountBook accountBook = new SoCpAccountBook();
        accountBook.setAccountBookId(accountId);
        accountBook.setBalance(payAmount);
        accountBook.setUpdTime(DateTimeUtil.getCustomerDate());
        modify(accountBook);
    }

    /**
     * 计算账套金额 更新账套表
     * @param code
     * @param role
     * @param payAmount
     */
    private void updateAccount(String code, String role, BigDecimal payAmount) {
        SoCpAccountBook accountBook = new SoCpAccountBook();
        accountBook.setUserNo(code);
        accountBook.setUserRole(role);
        accountBook.setBalance(payAmount);
        accountBook.setUpdTime(DateTimeUtil.getCustomerDate());
        modify(accountBook);
    }

    /**
     *保存交易明细
     * @param data 交易明细
     */
    private void saveTransactionDetail(BookKeepingParam data) {

        SoCpTransactionDetail detail = new SoCpTransactionDetail();
        //主键
        Long transId = commonLogic.maxId("so_cp_transaction_detail", "TRANS_ID");
        detail.setTransId(transId.intValue());

        //业务副体，付款方编码
        detail.setBusinessAssistant(data.getPayerCode());
        //业务副体角色
        detail.setBusinessAssistantRole(data.getPayerRole());
        //业务主体，收款方编码
        detail.setBusinessMain(data.getPayeeCode());
        //业务主体角色
        detail.setBusinessManRole(data.getPayeeRole());
        //编码
        detail.setSelectCode(data.getSearchCode());
        //类型
        detail.setSelectType(data.getSearchType());
        //金额类型
        detail.setAmountType(data.getAmountType());
        //金额
        detail.setOrderAmount(data.getPayAmount());
        //是否支付
        detail.setSettlement(data.getIsPayed());
        //支付流水号
        detail.setPaidSeq(data.getPayCode());
        //创建人
        detail.setCrtId("init");
        detail.setVer(1);
        detail.setCrtTime(DateTimeUtil.getCustomerDate());
        save(SqlId.SQL_ID_SAVE_TRANS_DETAIL, detail);
    }

}
