package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlAccount;
import com.msk.core.entity.SlProduct;
import com.msk.core.exception.BusinessException;
import com.msk.sl.bean.ISL231105RsParam;
import com.msk.sl.bean.ISL231105RsResult;
import com.msk.sl.bean.ISL231118RsParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyh on 2016/1/14.
 */
public class ISL231105Logic extends BaseLogic {
    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
          static final String SQL_ID_FIND_SL_ACCOUNT = "findSlAccount";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public ISL231105RsResult querySlAccount(ISL231105RsParam iSL231105RsParam) {
        BaseParam param = new BaseParam();
        param.setFilter("slAccount", iSL231105RsParam.getSlAccount());
        param.setFilter("accountPsd", iSL231105RsParam.getAccountPsd());
        param.setFilter("slTel",iSL231105RsParam.getSlTel());
        ISL231105RsResult slAccounts = super.findOne(SqlId.SQL_ID_FIND_SL_ACCOUNT, param);
        return slAccounts;
    }
}
