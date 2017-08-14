package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.sl.bean.SL24110306Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by writer on 2016/2/3.
 */
@Service
public class SL2411030091Logic extends BaseLogic{
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        String SQL_ID_SAVEMANAGER = "saveManager";
    }

    public int saveMa(SL24110306Bean sl24110306Bean){
        return super.save(SqlId.SQL_ID_SAVEMANAGER,sl24110306Bean);
    }
}
