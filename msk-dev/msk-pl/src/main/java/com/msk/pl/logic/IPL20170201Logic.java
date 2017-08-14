package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.pl.bean.IPL20170201Param;
import com.msk.pl.bean.IPL20170201Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170201Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        static final String PL_SQL_ID_FIND_USER_EXIST_PARTNER = "findUserExistPartner";
        static final String PL_SQL_ID_FIND_USER_EXIST_Bs = "findUserExistBs";
    }

    /**
     *
     * @param param
     * @return
     * 外勤登陆用户查询
     */
    @Transactional(readOnly = true)
    public IPL20170201Result findUserExist(IPL20170201Param param) {

        if (param == null) param = new IPL20170201Param();

        BaseParam params = new BaseParam();
        params.setFilter("userName", param.getUserName());
        params.setFilter("wqAccount", param.getWqAccount());
        params.setFilter("partnerFlg", String.valueOf(NumberConst.IntDef.INT_ONE));
        params.setFilter("bsFlg", String.valueOf(NumberConst.IntDef.INT_TWO));

        IPL20170201Result rsResult = super.findOne(SqlId.PL_SQL_ID_FIND_USER_EXIST_PARTNER, params);
        IPL20170201Result rsResultBs = super.findOne(SqlId.PL_SQL_ID_FIND_USER_EXIST_Bs, params);

        if (null == rsResultBs && null == rsResult) return rsResult;

        if (null != rsResultBs && rsResultBs.getBsCode() != "") {
            if(null == rsResult) rsResult = new  IPL20170201Result();
            rsResult.setBsCode(rsResultBs.getBsCode());
            rsResult.setIsBs(NumberConst.IntDef.INT_ONE);
        } else {
            rsResult.setIsBs(NumberConst.IntDef.INT_ZERO);
        }

        rsResult.setIsPartner(rsResult != null && rsResult.getPartnerId() != null ? NumberConst.IntDef.INT_ONE : NumberConst.IntDef.INT_ZERO);
        rsResult.setUserName(param.getUserName());

        return rsResult;
    }
}
