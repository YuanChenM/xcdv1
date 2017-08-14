package com.msk.so.logic;


import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.so.bean.ISO151407RsParam;
import com.msk.so.bean.OrderCountBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sunjiaju on 2016/8/10.
 */
@Service
public class ISO151407Logic extends BaseLogic {
    /**
     *
     * @param param
     * @return
     */
    public List<OrderCountBean> searchOrderSourceCount(ISO151407RsParam param){
        return super.findList(param);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
