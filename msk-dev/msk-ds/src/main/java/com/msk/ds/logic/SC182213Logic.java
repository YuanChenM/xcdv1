package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.ds.bean.SC182212Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by air on 2016/4/28.
 */
@Service
public class SC182213Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {

    }

    public void deleteInfo(Long lotId,String serialId){
        BaseParam baseParam = new BaseParam();
        String slotId = lotId.toString();
        baseParam.setFilter("lotId",slotId);
        baseParam.setFilter("serialId",serialId);
        super.remove(baseParam);
    }


}
