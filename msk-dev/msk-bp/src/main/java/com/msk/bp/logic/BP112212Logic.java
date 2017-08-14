package com.msk.bp.logic;

import com.msk.bp.bean.*;
import com.msk.bp.utils.SellerQuotationUtil;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DecimalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by liu_tao2 on 2016/3/29.
 */
@Service
public class BP112212Logic extends BaseLogic {
    private static Logger logger = LoggerFactory.getLogger(BP112212Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    /**
     * 根据报价Id查询出报价明细信息
     * @param param
     * @return
     */
    public List<BP112212Bean> getSellerQuotationDetailList(BP112211Param param)
    {
        param.setCrtId(param.getLoginId());

        param.setLastPricecyclePeriod(getLastPricecyclePeriod(param));
        param.setStartDate(getDateStr(param.getStartDate()));
        param.setEndDate(getDateStr(param.getEndDate()));

        if (param.getPricecycleId() == NumberConst.IntDef.INT_ZERO)
        {
            return getSellerQuotationDetailInfo(param);
        }

        List<BP112212Bean> bp112212Beans = this.findList(SqlId.SQL_ID_GET_SELLER_QUOTATION_DETAIL_LIST,param);

        if (CollectionUtils.isEmpty(bp112212Beans))
        {
            return bp112212Beans;
        }

        for (BP112212Bean bp112212Bean : bp112212Beans)
        {
            param.setOrderLevelCode(bp112212Bean.getOrderLevelCode());
            BigDecimal lastPriceOfKg = (BigDecimal)this.findObject(SqlId.SQL_ID_GET_LAST_PRICE_OF_KG, param);
            bp112212Bean.setLastPriceOfKg(lastPriceOfKg);
        }

        return bp112212Beans;
    }

    public void dealBean(BP112212Bean bp112212Bean)
    {
        if(bp112212Bean.getLastPriceOfKg() != null)
        {
            BigDecimal mulNum = DecimalUtil.multiply(bp112212Bean.getLastPriceOfKg(), new BigDecimal(ConfigManager.getStandardCoefficientQuotiety()));
            bp112212Bean.setGuidePricesMin(DecimalUtil.subtract(bp112212Bean.getLastPriceOfKg() ,mulNum ));
            bp112212Bean.setGuidePricesMax(DecimalUtil.add(bp112212Bean.getLastPriceOfKg(),mulNum));
        }
    }

    /**
     *
     * @param date
     * @return
     */
    public String getDateStr(String date)
    {
        return date.substring(NumberConst.IntDef.INT_FIVE,NumberConst.IntDef.INT_SEVEN)+ "月"+date.substring(NumberConst.IntDef.INT_EIGHT)+"日";
    }

    /**
     * 得到上期价盘周期
     * @param param
     * @return
     */
    public String getLastPricecyclePeriod(BP112211Param param)
    {
        String cycleCode = param.getCycleCode();
        Integer dayAmount = Integer.valueOf(param.getDayAmount());
        cycleCode = cycleCode.substring(NumberConst.IntDef.INT_ZERO,NumberConst.IntDef.INT_FOUR);
        if(dayAmount == NumberConst.IntDef.INT_ONE)
        {
            Integer month = Integer.valueOf(cycleCode.substring(NumberConst.IntDef.INT_TWO, NumberConst.IntDef.INT_FOUR));
            Integer year = Integer.valueOf(cycleCode.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_TWO));
            if(month == NumberConst.IntDef.INT_ONE)
            {
                year = year - NumberConst.IntDef.INT_ONE;
                month = NumberConst.IntDef.INT_TWELVE;
                return "" + year + month + NumberConst.IntDef.INT_SIX  ;
            }

            month = month - NumberConst.IntDef.INT_ONE;

            if (month >= NumberConst.IntDef.INT_ONE && month < NumberConst.IntDef.INT_TEN)
            {
                return "" + year + NumberConst.IntDef.INT_ZERO + month + NumberConst.IntDef.INT_SIX ;
            }
            return "" + year + month + NumberConst.IntDef.INT_SIX ;
        }
        return cycleCode+String.valueOf(dayAmount - NumberConst.IntDef.INT_ONE);
    }


    @Transactional
    public void saveSellerQuotationInfo(BP112212Param param)
    {
        int count = this.getCount(SqlId.SQL_ID_GET_SELLER_QUOTATION_COUNT,param);

        List<BP112212Bean> bp112212Beans = param.getBp112212Beans();

        Long pricecycleId = this.commonLogic.maxId("bp_seller_quotation", "PRICECYCLE_ID");
        param.setPricecycleId(pricecycleId);

        if(count == NumberConst.IntDef.INT_ZERO)
        {
            addSellerQuotationInfo(param);
            addSellerQuotationDetailInfo(bp112212Beans,param);
            return ;
        }

        for(BP112212Bean bp112212Bean : bp112212Beans)
        {
            bp112212Bean.setUpdId(param.getUpdId());
            this.modify(SqlId.SQL_ID_MODIFY_SELLER_QUOTATION_INFO, bp112212Bean);
        }
    }

    /**
     * 新增报价表中的数据
     * @param param
     */
    public void addSellerQuotationInfo(BP112212Param param)
    {
        this.save(SqlId.SQL_ID_SAVE_SELLER_QUOTATION_INFO,param);
    }

    public void addSellerQuotationDetailInfo(List<BP112212Bean> bp112212Beans,BP112212Param param)
    {
        for (BP112212Bean bp112212Bean : bp112212Beans)
        {
            Long pricecycleDetailId = this.commonLogic.maxId("bp_seller_quotation_detail", "PRICECYCLE_DETAIL_ID");
            bp112212Bean.setPricecycleId(param.getPricecycleId());
            bp112212Bean.setPricecycleDetailId(pricecycleDetailId);
            bp112212Bean.setCrtId(param.getUpdId());
            bp112212Bean.setNetWeight(param.getWeightVal());

            this.save(SqlId.SQL_ID_SAVE_SELLER_QUOTATION_DETAIL_INFO,bp112212Bean);
        }
    }


    /**
     * 初始化报价明细表中的数据
     * @param param
     */
    public List<BP112212Bean> getSellerQuotationDetailInfo(BP112211Param param)
    {
        List<BP112212Bean> bp112212Beans = SellerQuotationUtil.getSellerQuotationList();

        for (BP112212Bean bp112212Bean : bp112212Beans)
        {
            Long pricecycleDetailId = this.commonLogic.maxId("bp_seller_quotation_detail", "PRICECYCLE_DETAIL_ID");
            bp112212Bean.setPricecycleId(Long.valueOf(param.getPricecycleId()));
            bp112212Bean.setPricecycleDetailId(pricecycleDetailId);
            bp112212Bean.setCrtId(param.getCrtId());
            param.setOrderLevelCode(bp112212Bean.getOrderLevelCode());

            BP112212Bean lastBP112212Bean = getLastSellerQuotationDetailInfo(param);

            if(lastBP112212Bean == null)
            {
                bp112212Bean.setGuidePricesMin(new BigDecimal("0.00"));
                bp112212Bean.setGuidePricesMax(new BigDecimal("0.00"));
                bp112212Bean.setPriceOfKg(new BigDecimal("0.00"));
            }else
            {
                bp112212Bean.setPriceOfKg(lastBP112212Bean.getPriceOfKg());
                bp112212Bean.setLastPriceOfKg(lastBP112212Bean.getPriceOfKg());
                bp112212Bean.setCurrentCoefficient(lastBP112212Bean.getCurrentCoefficient());
                dealBean(bp112212Bean);
            }

            if (!param.getPdWeight().isEmpty())
            {
                bp112212Bean.setNetWeight(param.getWeightVal());
            }
            bp112212Bean.setIsBidderFlg("0");
        }

        return bp112212Beans;

    }

    /**
     *
     * @param param
     * @return
     */
    public BP112212Bean getLastSellerQuotationDetailInfo(BP112211Param param)
    {
        return (BP112212Bean)this.findObject(SqlId.SQL_ID_GET_LAST_SELLER_QUOTATION_DETAIL_INFO,param);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId{
        String SQL_ID_GET_SELLER_QUOTATION_DETAIL_LIST = "getSellerQuotationDetailList";
        String SQL_ID_MODIFY_SELLER_QUOTATION_INFO = "modifySellerQuotationInfo";
        String SQL_ID_SAVE_SELLER_QUOTATION_INFO = "saveSellerQuotationInfo";
        String SQL_ID_SAVE_SELLER_QUOTATION_DETAIL_INFO = "saveSellerQuotationDetailInfo";
        String SQL_ID_GET_LAST_SELLER_QUOTATION_DETAIL_INFO = "getLastSellerQuotationDetailInfo";
        String SQL_ID_GET_LAST_PRICE_OF_KG = "getLastPriceOfKg";
        String SQL_ID_GET_SELLER_QUOTATION_COUNT = "getSellerQuotationCount";
    }
}
