package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.SlEpCap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/1/28.
 */
@Service
public class SL2411010402Logic extends BaseLogic{

    interface SqlId{
        static  final String SQL_ID_SAVE_SLEPCAP = "saveSlEpCap";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    @Transactional
    public void updateSlEpCap(SlEpCap slEpCap, Long slEpId) {
        slEpCap.setEpId(slEpId);
        super.modify(SqlId.SQL_ID_SAVE_SLEPCAP,slEpCap);
    }
}
