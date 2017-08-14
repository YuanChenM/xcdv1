package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.sl.bean.SL241103081Bean;
import com.msk.sl.bean.SL241103082Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fjm on 2016/1/29.
 */
@Service
public class SL241103007Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        String SQL_ID_SAVEHONOR = "savehonor";
        String SQL_ID_SAVEBRAND = "savebrand";
        String SQL_ID_SAVEHONOR2 = "savehonor2";
        String SQL_ID_SAVEBRAND2 = "savebrand2";
        String SQL_ID_SAVEHONOR3 = "savehonor3";
        String SQL_ID_SAVEBRAND3 = "savebrand3";
    }

    public int saveSlEpHonor(SL241103082Bean sl241103082Bean){
        return super.save(SqlId.SQL_ID_SAVEHONOR,sl241103082Bean);
    }
    public int saveSlEpHonor2(SL241103082Bean sl241103082Bean){
        return super.save(SqlId.SQL_ID_SAVEHONOR2,sl241103082Bean);
    }
    public int saveSlEpHonor3(SL241103082Bean sl241103082Bean){
        return super.save(SqlId.SQL_ID_SAVEHONOR3,sl241103082Bean);
    }
    public int saveBrand(SL241103081Bean sl241103081Bean){
        return super.save(SqlId.SQL_ID_SAVEBRAND,sl241103081Bean);
    }
    public int saveBrand2(SL241103081Bean sl241103081Bean){
        return super.save(SqlId.SQL_ID_SAVEBRAND2,sl241103081Bean);
    }
    public int saveBrand3(SL241103081Bean sl241103081Bean){
        return super.save(SqlId.SQL_ID_SAVEBRAND3,sl241103081Bean);
    }


}