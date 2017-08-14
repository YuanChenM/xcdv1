package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.so.bean.ISO151425RsParam;
import com.msk.so.bean.ISO151425RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查询订单是否已投诉接口
 * Created by sun_jiaju on 2016/10/11.
 */
@Service
public class ISO151425Logic extends BaseLogic {

    /**
     * 查询投訴單數
     *
     * @param param param
     * @return 返回结果
     * @author sjj
     */
    public ISO151425RsResult findComplainCount(ISO151425RsParam param) {
        return super.findOne(param);
    }


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
