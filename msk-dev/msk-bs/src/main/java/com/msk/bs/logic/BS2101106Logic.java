package com.msk.bs.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlSeller;
import com.msk.core.entity.SlShopInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 买手店管家会员列表
 *
 * @author cx
 */
@Service
public class BS2101106Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_FIND_SLACCOUNT = "findSlBuyerhop";
        String SQL_ID_FIND_SLCODE = "findSlCode";

    }

    public int findSlBuyerhop(BaseParam baseParam) {
        return super.getCount(SqlId.SQL_ID_FIND_SLACCOUNT, baseParam);
    }
    public SlShopInfo findShopId(BaseParam baseParam) {
        return super.findOne(baseParam);
    }

    public SlSeller findSlCode(BaseParam baseParam) {
        return super.findOne(SqlId.SQL_ID_FIND_SLCODE,baseParam);
    }

}
