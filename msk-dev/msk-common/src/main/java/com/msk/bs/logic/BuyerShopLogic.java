package com.msk.bs.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *买手店共通信息
 * *@author jiang_nan
 * *@version 1.0
 **/
@Service
public class BuyerShopLogic extends BaseLogic{

    /**
     * 冻品管家与买家的关系：申请状态
     * 1：申请中 2：专属会员
     * @author chen_xin
     */
    public interface SlApplyStatus {
        public String Type = "SlApplyStatus";
        /** 申请中 */
        public String Apply = "1";
        /** 专属会员 */
        public String Exclusive = "2";
    }

    interface SqlId{
        String SQL_ID_FIND_SELLER_BY_BUYERS_ID = "findSellerByBuyersId";
    }
    /**
     * 根据买家编码获得
     * @param buyersId
     * @return
     */
    public List<String> findSellerByBuyersId(String buyersId){
        BaseParam param = new BaseParam();
        param.setFilter("buyersId",buyersId);
        /** 专属会员 */
        param.setFilter("applyStatus",SlApplyStatus.Exclusive);
        return super.getBaseDao().getSqlSession().selectList(this.getSqlId(SqlId.SQL_ID_FIND_SELLER_BY_BUYERS_ID),param);
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
