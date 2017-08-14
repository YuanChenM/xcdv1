package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlSeller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fjm on 2016/1/27.
 */
@Service
public class SL241103002Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        String SQL_ID_SAVESELLER = "saveSeller";
        String SQL_ID_FINDSLCODE = "findAndCheck";
    }

    @Transactional
    public int saveSlSell(SlSeller slSeller){
        return super.save(SqlId.SQL_ID_SAVESELLER,slSeller);
    }

    @Transactional
        public SlSeller findAc(String slAccount){
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("slAccount",slAccount);
        return  super.findOne(SqlId.SQL_ID_FINDSLCODE,baseParam);
    }

    @Transactional
    public List<SlSeller> findlist(String slAreaCode){
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("slAreaCode",slAreaCode);
        return super.findList(baseParam);
    }

    @Transactional
    public  SlSeller findSlCode(String slAreaCode){
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("slAreaCode",slAreaCode);
        return super.findOne(SqlId.SQL_ID_FINDSLCODE,baseParam);
    }

}
