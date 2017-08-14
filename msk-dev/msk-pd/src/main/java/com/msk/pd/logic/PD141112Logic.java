package com.msk.pd.logic;

import java.util.Map;

import com.msk.core.entity.PdNormsStd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.PdStandard;
import com.msk.pd.bean.PD141112Param;

/**
 * PD141112Logic
 * 
 * @author pxg
 */

@Service
public class PD141112Logic extends BaseLogic {

    /**
     * SQL Map 中SQL ID定义
     * 
     * @author gyh
     */
    interface SqlId {
        String SQL_ID_FIND_PD_STANDARD = "findPdStandard";
        String SQL_ID_FIND_COUNT = "findCount";
        String SQL_ID_FIND_MAX_CODE = "findMax";
    }

    /**
     * 根据产品标准ID查询查询产品标准表信息
     * @param param param
     * @return 标准表信息
     */

    public PdStandard findPdStandard(BaseParam param) {
        return super.findOne(SqlId.SQL_ID_FIND_PD_STANDARD, param);
    }

    /**
     * 根据根据对象查询数据库是否有相同的数据
     * @param param param
     * @return 返回查询的数量
     */

    public int findNum(Map<String, Object> param) {
        return super.getCount(SqlId.SQL_ID_FIND_COUNT, param);
    }

    /**
     * 根据最大的产品包装编码
     * @param param param
     * @return PD141112Param对象
     */
    public PdNormsStd findCodeMax(BaseParam param) {
        return super.findOne(SqlId.SQL_ID_FIND_MAX_CODE, param);
    }
    
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
