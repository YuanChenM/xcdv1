package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.sl.bean.SL24110501Bean;
import com.msk.sl.bean.SL241117Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * SL241104Logic
 *
 * @author yuan_chen
 * @version 1.0
 **/
@Service
public class SL241104Logic extends BaseLogic {
    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_FIND_SL_PD_TNC_STD = "findSlPdTncStd";
    }

    /**
     * 查询卖家产品加工质量标准信息
     * @param param 参数，卖家编码，卖家产品Id
     * @return
     */
    public List<SL241117Bean> findSlPdTncStd(BaseParam param){
        return this.findList(SqlId.SQL_ID_FIND_SL_PD_TNC_STD,param);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
