package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by air on 2016/4/28.
 */
@Service
public class SC182212Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_REMOVE ="removeMore";
    }

    public void deleteInfo(Long lotId){
        BaseParam baseParam = new BaseParam();
        String slotId = lotId.toString();
        baseParam.setFilter("lotId",slotId);
        super.remove(baseParam);
    }

    public void deleteInfo2(Long lotId){
        BaseParam baseParam = new BaseParam();
        String slotId = lotId.toString();
        baseParam.setFilter("lotId",slotId);
        try {
            super.remove(baseParam);
            super.remove(SqlId.SQL_ID_REMOVE,baseParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
