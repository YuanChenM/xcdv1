package com.msk.so.logic;


import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yang_chunyan on 2016/3/22.
 */
@Service
public class SO151409Logic extends BaseLogic {
    private static Logger logger = LoggerFactory.getLogger(SO151409Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SqlId. 方法名
     */
    interface SqlId {
        String SAVESALESRANKING = "saveSalesRanking";
    }

    /**
     * 更新库存量
     * @param param
     */
    public int saveSalesRanking(BasePageParam param) {
        int result = super.modify(SqlId.SAVESALESRANKING, param);
        return result;
    }




}
