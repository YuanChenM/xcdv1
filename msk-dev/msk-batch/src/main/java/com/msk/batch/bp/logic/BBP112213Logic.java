package com.msk.batch.bp.logic;

import com.msk.batch.bp.bean.BBP112213Param;
import com.msk.batch.bp.bean.BP112213Bean;
import com.msk.common.bean.PriceCycle;
import com.msk.common.logic.CommonLogic;
import com.msk.common.utils.PriceCycleUtils;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * BBP112213Logic
 *
 * @author Pneg_Hao
 * @version 1.0
 **/
@Service
public class BBP112213Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BBP112213Logic.class);
    /**
     * CommonLogic
     */
    @Autowired
    private CommonLogic commonLogic;


    /**
     * (non-Javadoc)
     *
     * @see com.msk.core.base.BaseLogic#setBaseDao(com.msk.core.base.BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     *  数据处理
     *
     * @return
     */
    @Transactional
    public void dataResolve(BaseParam param) {
        //将中标的价盘插入到价盘表
        BBP112213Param dataParam = new BBP112213Param();
        dataParam.setPriceCyclePeriod(getPriceCyclePeriod());
        Date customerDate = DateTimeUtil.getCustomerDate();

        //清空价盘周期
        super.modify(SqlId.SQLID_UPDATE_LOGIAREA, dataParam);

        //清空价盘周期
        List<BP112213Bean> rsResultList = super.findList(SqlId.SQLID_SELECT_SELLER_QUOTATION, dataParam);
        for (BP112213Bean logiAreaInfo : rsResultList) {
            Long pricecycleId = createLogiAreaId();
            //价盘ID
            dataParam.setPriceCycleId(pricecycleId);
            //价盘周期
            dataParam.setPriceCyclePeriod(logiAreaInfo.getPricecyclePeriod());
            //产品编码（组合码，不包含加工类型）
            dataParam.setPdCode(logiAreaInfo.getPdCode());
            //物流区编码
            dataParam.setLogiAreaCode(logiAreaInfo.getLogiareaCode());
            //物流区名称
            dataParam.setLogiAreaName(logiAreaInfo.getLogiareaName());
            //卖家编码
            dataParam.setSlCode(logiAreaInfo.getSlCode());
            //卖家名称
            dataParam.setSlName(logiAreaInfo.getSlName());
            //订单等级编码
            dataParam.setOrderLevelCode(logiAreaInfo.getOrderlevelCode());
            //订单等级编码
            dataParam.setOrderLevelName(logiAreaInfo.getOrderlevelName());
            //公斤价
            dataParam.setPriceOfKg(logiAreaInfo.getPriceofkg());
            //折扣率
            dataParam.setDisCount(logiAreaInfo.getDiscount());

            //箱价（净重*公斤价）
            dataParam.setPriceOfBox(logiAreaInfo.getPriceofbox());
            //净重（F数值）
            dataParam.setNetWeight(logiAreaInfo.getNetweight());
            //箱数取得
            BP112213Bean bp112213bean = super.findOne(SqlId.SQLID_GET_STOC_KNUM, dataParam);
            if (bp112213bean != null) {
                //箱数
                dataParam.setStockNum(bp112213bean.getStockNum());
            }
            //创建者ID
            dataParam.setCrtId("admin");
            //创建日时
            dataParam.setCrtTime(customerDate);
            //创建者ID
            dataParam.setUpdId("admin");
            //创建日时
            dataParam.setUpdTime(customerDate);
            //创建者ID
            dataParam.setActId("admin");
            //创建日时
            dataParam.setActTime(customerDate);
            //更新价盘表信息
            super.save(SqlId.SQLID_INSERT_LOGIAREA, dataParam);
        }
    }

    /**
     * 根据当前日期获得价盘周期
     * @return 价盘周期
     */
    public String getPriceCyclePeriod() {
        Date dateNow = DateTimeUtil.getCustomerDate();
        PriceCycle priceCycle = PriceCycleUtils.getPriceCycle(dateNow, NumberConst.IntDef.INT_ZERO);
        return priceCycle.getCycleCode();
    }

    /**
     * 创建美侍客卖家产品价盘ID
     *
     * @return 价盘ID
     */
    private long createLogiAreaId() {
        return commonLogic.maxId("BP_PRICEPRD_LOGIAREA", "PRICECYCLE_ID");
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author yuan_chen
     */
    public interface SqlId {
        static final String SQLID_UPDATE_LOGIAREA = "updateLogiarea";
        static final String SQLID_INSERT_LOGIAREA = "insertLogiarea";
        static final String SQLID_SELECT_SELLER_QUOTATION = "selectSellerQuotation";
        static final String SQLID_GET_STOC_KNUM = "getStockNum";
    }
}
