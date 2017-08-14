package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.SlEpCap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 更新企业生产能力信息
 * Created by Administrator on 2016/1/28.
 */
@Service
public class SL24110300502Logic extends BaseLogic{

    interface SqlId{
        static  final String SQL_ID_UPDATE_SLEpCap= "updateSlEpCap";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }
    //库容
    @Transactional
    public void updateSlEpCap(SlEpCap slEpCap) {
        super.modify(SqlId.SQL_ID_UPDATE_SLEpCap,slEpCap);
    }
}
