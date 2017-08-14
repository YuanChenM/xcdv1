package com.msk.bs.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.ByBuyerPdCla;
import com.msk.core.entity.ByBuyerSalestarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 买手店管家会员列表
 * @author cx
 */
@Service
public class BS2101103Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询买家经营产品类别表
     * @param param param
     * @return 结果
     */
    public List<ByBuyerPdCla> findByBuyerPdCla(BaseParam param){
        return this.findList(SqlId.SQL_ID_FIND_BY_BUYER_PD_CLA, param);
    }
    /**
     * 查询买家产品销售对象表
     * @param param param
     * @return 结果
     */
    public List<ByBuyerSalestarget> findByBuyerSalestarget(BaseParam param){
        return this.findList(SqlId.SQL_ID_FIND_BYBUYER_SALESTARGET, param);
    }

    interface SqlId {
        /**
         * 查询买家经营产品类别表
         */
        static final String SQL_ID_FIND_BY_BUYER_PD_CLA = "findByBuyerPdCla";
        /**
         * 查询买家产品销售对象表
         */
        static final String SQL_ID_FIND_BYBUYER_SALESTARGET = "findByBuyerSalestarget";
    }
}
