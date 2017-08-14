package com.msk.by.logic;

import java.util.UUID;

import com.msk.core.entity.ByAccessAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.by.bean.IBY121201RsParam;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.ByBuyerAccount;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;

/**
 * IBY121201Logic.
 *
 * @author zhou_yajun
 */
@Service
public class IBY121201Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121201Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_yajun
     */
    interface SqlId {
        // 查询账号表
        static String SQL_FIND_ACCOUNT_INFO = "findAccountInfo";
        // 插入主表
        static String SQL_SAVE_BUYER = "saveBuyer";
        // 插入账号表
        static String SQL_SAVE_ACCOUNT_INFO = "saveAccountInfo";
        // 重置密码
        static String SQL_RESET_PASSWORD = "resetPassword";
        // 通过买家id,买家账号,买家旧密码,更新新密码
        static String SQL_UPDATE_PASSWORD = "modifyPassword";
        // 前台手机验证成功后,通过手机号直接修改密码
        static String SQL_UPDATE_PASSWORD_TELNO = "modifyPasswordByTelNo";
        // 通路人员登录
        static String SQL_FIND_ACCESS_INFO = "findAccessInfo";
        //查询账号是否存在
        static String SQL_COUNT_ACCESS_INFO = "countAccountInfo";
        //根据账号名获取账号
        static String SQL_FIND_ACCOUNT_BY_NAME_AND_PWD = "findAccountByNameAndPwd";
    }

    /**
     * (non-Javadoc)
     *
     * @see com.msk.core.base.BaseLogic#setBaseDao(com.msk.core.base.BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 买家账号和基础信息注册
     *
     * @param param
     * @return
     */
    @Transactional
    public synchronized String buyerRegister(IBY121201RsParam param) {
        String message = "";
        // 根据手机号码查询买家的账号信息
        BaseParam findNameParam = new BaseParam();
        BaseParam findTelParam = new BaseParam();
        int nameNum = 0;
        if (!StringUtil.isNullOrEmpty(param.getAccountName())) {
            findNameParam.setFilter("accountName", param.getAccountName());
            nameNum = super.getCount(SqlId.SQL_COUNT_ACCESS_INFO, findNameParam);
        }
        findTelParam.setFilter("accountName", param.getTelNo());
        int telNum = super.getCount(SqlId.SQL_COUNT_ACCESS_INFO, findTelParam);
        // 如果查询不到账号信息，则将注册信息插入买家主表(By_buyer)和买家账号表(By_Account)
        if (nameNum == 0 && telNum == 0) {
            UUID uuid = UUID.randomUUID();
            IBY121201RsParam saveParam = new IBY121201RsParam();
            saveParam.setBuyerId(String.valueOf(uuid));
            saveParam.setRegisterSource(param.getRegisterSource());
            saveParam.setLgcsAreaCode(param.getLgcsAreaCode());
            saveParam.setCityCode(param.getCityCode());
            saveParam.setDistrictCode(param.getDistrictCode());
            saveParam.setCrtId(param.getUpdId());
            saveParam.setCrtTime(DateTimeUtil.getCustomerDate());
            saveParam.setUpdId(param.getUpdId());
            saveParam.setUpdTime(DateTimeUtil.getCustomerDate());
            saveParam.setActId(param.getUpdId());
            saveParam.setActTime(DateTimeUtil.getCustomerDate());
            // 先插入主表
            super.save(SqlId.SQL_SAVE_BUYER, saveParam);

            saveParam.setTelNo(param.getTelNo());
            Long id = commonLogic.maxId("by_buyer_account", "ID");
            saveParam.setId(id);
            // 如果账号名称不输入，则默认插入手机号码
            if (StringUtil.isNullOrEmpty(param.getAccountName())) {
                saveParam.setAccountName(param.getTelNo());
            } else {
                saveParam.setAccountName(param.getAccountName());
            }
            // 如果账号密码不输入，则默认插入手机号码
            if (StringUtil.isNullOrEmpty(param.getAccountPass())) {
                saveParam.setAccountPass(param.getTelNo().substring(param.getTelNo().length() - 8, param.getTelNo().length()));
            } else {
                saveParam.setAccountPass(param.getAccountPass());
            }
            // 插入账号表
            super.save(SqlId.SQL_SAVE_ACCOUNT_INFO, saveParam);
        } else if (telNum > 0) {
            message = "该手机号已被注册";
        } else if (nameNum > 0) {
            message = "该账号名已被注册";
        }
        return message;
    }

    /**
     * 根据买家账号名判断是否存在该买家
     *
     * @param param
     * @return
     */
    public int findAccountByName(ByBuyerAccount param) {
        BaseParam inParam = new BaseParam();
        inParam.setFilter("accountName", param.getAccountName());
        return super.getCount(SqlId.SQL_COUNT_ACCESS_INFO, inParam);
    }

    /**
     * 买家登录接口
     *
     * @param param
     * @return
     */
    @Transactional
    public synchronized ByBuyerAccount buyerLogin(ByBuyerAccount param) {
        BaseParam inParam = new BaseParam();
        inParam.setFilter("accountName", param.getAccountName());
        inParam.setFilter("accountPass", param.getAccountPass());
        ByBuyerAccount accountInfo = super.findOne(SqlId.SQL_FIND_ACCOUNT_BY_NAME_AND_PWD, inParam);

        return accountInfo;
    }

    /**
     * 接口获取参数
     *
     * @param param
     */
    public ByBuyerAccount getBuyerAccount(IBY121201RsParam param) {
        // 根据手机号码查询买家的账号信息
        BaseParam findParam = new BaseParam();
        findParam.setFilter("telNo", param.getTelNo());
        ByBuyerAccount findAccountInfo = super.findOne(SqlId.SQL_FIND_ACCOUNT_INFO, findParam);
        return findAccountInfo;
    }


    /**
     * 买家密码重置
     *
     * @param updateParam
     * @return
     */
    @Transactional
    public int resetPassword(ByBuyerAccount updateParam) {
        return super.save(SqlId.SQL_RESET_PASSWORD, updateParam);
    }

    /**
     * 通过买家id,买家账号,买家旧密码,更新新密码
     *
     * @param param
     * @return
     */
    @Transactional
    public int updatePassword(BaseParam param) {
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        return super.save(SqlId.SQL_UPDATE_PASSWORD, param);
    }

    /**
     * 前台手机验证成功后,通过手机号直接修改密码
     *
     * @param param
     * @return
     */
    @Transactional
    public int updatePasswordByTel(BaseParam param) {
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        return super.save(SqlId.SQL_UPDATE_PASSWORD_TELNO, param);
    }

    /**
     * 通路人员登录
     *
     * @param param
     * @return
     */
    public ByAccessAccount accessLogin(ByAccessAccount param) {
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("accountName", param.getAccountName());
        baseParam.setFilter("accountPwd", param.getAccountPwd());
        ByAccessAccount byAccessAccount = super.findOne(SqlId.SQL_FIND_ACCESS_INFO, baseParam);
        return byAccessAccount;
    }

    /**
     * 获取通路人员账号信息
     *
     * @param accountName
     * @return
     */
    public ByAccessAccount validateSSOLogin(String accountName) {
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("accountName", accountName);
        ByAccessAccount byAccessAccount = super.findOne(SqlId.SQL_FIND_ACCESS_INFO, baseParam);
        return byAccessAccount;
    }
}
