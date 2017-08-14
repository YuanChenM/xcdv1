package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.SlAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fjm on 2016/1/28.
 */
@Service
public class SL24110101Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao){
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        String SQL_ID_MODIFY_ONE = "modifyOne";
    }

    public int update(SlAccount slAccount){

        return super.modify(SqlId.SQL_ID_MODIFY_ONE, slAccount);
    }

    /**
     *修改卖家账户
     * @param slAccount
     * @return
     */
    public int updatePort(SlAccount slAccount){

        return super.modify(slAccount);
    }

}
