package com.msk.bs.logic;

import com.msk.bs.bean.BS2101113Param;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.TableNameDef;
import com.msk.core.entity.SlBsBuyer;
import com.msk.core.entity.SlBsBuyerGet;
import com.msk.core.entity.SlBsBuyerGetHis;
import com.msk.core.entity.SlBsBuyerHis;
import com.msk.core.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhu_kai1 on 2016/7/8.
 */
@Service
public class BS2101113Logic extends BaseLogic {


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
     private CommonLogic commonLogic;

    interface SqlId {
        // 更新买手店管家抢单会员表
        static String MODIFY_SL_BS_BUYER_GET="updateBuyerGet";
        // 更新买手店管家专属会员表
        static String MODIFY_SL_BS_BUYER="updateBuyer";
        // 新增买手店管家抢单会员履历表
        static String INSERT_SL_BS_BUYER_GET_HIS="insertBuyerGetHis";
        // 新增买手店管家买家关系履历表
        static String INSERT_SL_BS_BUYER_HIS="insertBuyerHis";
        // 更新冻品管家账户
        static String UPDATE_SL_HOUSE_ACCOUNT="updateHouseAccount";
        // 查询买手店管家抢单会员表
        static String FIND_SL_BS_BUYER_GET = "findBuyerGet";
        // 查询买手店管家专属会员表
        static String FIND_SL_BS_BUYER = "findBuyer";
    }

    @Transactional
    public void   deleteBuyerGet(BS2101113Param bs2101113Param){
        // 查询买手店管家抢单会员信息
        List<SlBsBuyerGet> buyerGetList = this.findList(SqlId.FIND_SL_BS_BUYER_GET,bs2101113Param);
        // 查询买手店管家专属会员信息
        List<SlBsBuyer> buyerList = this.findList(SqlId.FIND_SL_BS_BUYER,bs2101113Param);
        // 更新买手店管家抢单会员表
        bs2101113Param.getFilterMap().put("updateTime", DateTimeUtil.getCustomerDate());
        this.modify(SqlId.MODIFY_SL_BS_BUYER_GET, bs2101113Param);
        // 新增买手店管家抢单会员履历表
        SlBsBuyerGetHis buyerGetHis = null;
        for (SlBsBuyerGet slBsBuyerGet :buyerGetList ){
             buyerGetHis = new SlBsBuyerGetHis();
             buyerGetHis.setHisId(commonLogic.maxId(TableNameDef.SL_BS_BUYER_GET_HIS,"HIS_ID"));
             buyerGetHis.setSlCode(slBsBuyerGet.getSlCode());
             buyerGetHis.setHouseAccount(slBsBuyerGet.getHouseAccount());
             buyerGetHis.setBuyerId(slBsBuyerGet.getBuyerId());
             buyerGetHis.setStartTime(DateTimeUtil.getCustomerDate());
             buyerGetHis.setEndTime(DateTimeUtil.getCustomerDate());
            // 解除原因先写1
             buyerGetHis.setReason("1");
             buyerGetHis.setCrtId(bs2101113Param.getCrtId());
             buyerGetHis.setCrtTime(DateTimeUtil.getCustomerDate());
             buyerGetHis.setUpdId(bs2101113Param.getUpdId());
             buyerGetHis.setUpdTime(DateTimeUtil.getCustomerDate());
             buyerGetHis.setActId(bs2101113Param.getActId());
             buyerGetHis.setActTime(DateTimeUtil.getCustomerDate());
            this.save(SqlId.INSERT_SL_BS_BUYER_GET_HIS,buyerGetHis);
        }
        // 更新买手店管家专属会员表
        this.modify(SqlId.MODIFY_SL_BS_BUYER,bs2101113Param);
        // 新增买手店管家专属会员履历表
        SlBsBuyerHis buyerHis = null;
        for (SlBsBuyer slBsBuyer:buyerList ){
            buyerHis = new SlBsBuyerHis();
            buyerHis.setHisId(commonLogic.maxId(TableNameDef.SL_BS_BUYER_HIS,"HIS_ID"));
            buyerHis.setSlCode(slBsBuyer.getSlCode());
            buyerHis.setHouseCode(slBsBuyer.getHouseCode());
            buyerHis.setBuyerId(slBsBuyer.getBuyerId());
            buyerHis.setStartTime(DateTimeUtil.getCustomerDate());
            buyerHis.setEndTime(DateTimeUtil.getCustomerDate());
            buyerHis.setApplySide(slBsBuyer.getApplySide());
            buyerHis.setApplyStatus(slBsBuyer.getApplyStatus());
            buyerHis.setApplyTime(slBsBuyer.getApplyTime());
            buyerHis.setBuyershopReason("1");
            buyerHis.setBuyerReason("1");
            buyerHis.setCrtId(bs2101113Param.getCrtId());
            buyerHis.setCrtTime(DateTimeUtil.getCustomerDate());
            buyerHis.setUpdId(bs2101113Param.getUpdId());
            buyerHis.setUpdTime(DateTimeUtil.getCustomerDate());
            buyerHis.setActId(bs2101113Param.getActId());
            buyerHis.setActTime(DateTimeUtil.getCustomerDate());
            this.save(SqlId.INSERT_SL_BS_BUYER_HIS,buyerHis);
        }
        // 更新冻品管家账户
        this.modify(SqlId.UPDATE_SL_HOUSE_ACCOUNT,bs2101113Param);
    }
}
