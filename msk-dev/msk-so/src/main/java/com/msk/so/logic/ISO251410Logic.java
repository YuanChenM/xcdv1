package com.msk.so.logic;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.so.bean.ISO251410RsParam;
import com.msk.so.bean.ISO251410RsResult;

/**
 * 
 * ISO251410Logic.
 *
 * @author pxg
 */
@Service
public class ISO251410Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    /**
     * 
     * SqlId.
     * 
     * @author pxg
     */
    interface SqlId {
        /** 订单主 */
        String SQL_ID_FIND_SAVE_SOORRDER = "saveSoOrder";
    }

    /**
     * @param param 保存参数
     * @return 返回值大小
     * @author pxg
     */
    @Transactional(readOnly = false,
        propagation = Propagation.REQUIRED,
        rollbackFor = Exception.class)
    public ISO251410RsResult findAllList(RsRequest<ISO251410RsParam> param) {
        ISO251410RsResult iSO251410RsResult=new ISO251410RsResult();
        iSO251410RsResult.setReturnId(NumberConst.IntDef.INT_ONE);
        iSO251410RsResult.setReturnCode("32323");
        iSO251410RsResult.setReturnStatus(NumberConst.IntDef.INT_ONE);
        iSO251410RsResult.setUpdTime(new Date());
        iSO251410RsResult.setVer(NumberConst.IntDef.INT_ONE);
        return iSO251410RsResult;
    }
}
