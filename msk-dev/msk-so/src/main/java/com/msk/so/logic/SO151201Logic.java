package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 分销正常库存
 */
@Service
public class SO151201Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SO151201Logic.class);

    /**
     * SqlId. 方法名
     */
    interface SqlId {
        String SAVESTOCKQTY = "saveStockQty";
    }

    /**
     * 更新库存量
     * @param param
     */
    public int saveStockQty(BasePageParam param) {
        int result = super.modify(SqlId.SAVESTOCKQTY, param);
        return result;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
