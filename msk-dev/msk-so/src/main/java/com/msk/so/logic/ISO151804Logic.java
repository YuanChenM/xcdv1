package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.so.bean.ISO151804ReasonResult;
import com.msk.so.bean.ISO151804RsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ISO151804Logic.
 *
 * @author zhang_qiang1
 */
@Service
public class ISO151804Logic extends BaseLogic {


    /**
     * @param param
     * @return
     */
    public List<ISO151804ReasonResult> findReturnReasons(ISO151804RsParam param) {
        List<ISO151804ReasonResult> list = super.findList(SqlId.SQL_ID_FIND_RETURN_REASON, param);
        return list;
    }


    interface SqlId {
        String SQL_ID_FIND_RETURN_REASON = "findReturnReason";// 查询退货原因


    }


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


}
