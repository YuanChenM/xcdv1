package com.msk.so.logic;

import com.msk.common.consts.CapitalPoolConst;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StockConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.SO151411Bean;
import com.msk.so.bean.StockParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 申请退货页面Logic
 *
 * @author sunjiaju
 * @version 创建时间：20160929
 */
@Service
public class SO151411Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SO151411Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private OrderLogic orderLogic;

    @Autowired
    private StockLogic stockLogic;

    @Autowired
    private ISO151408Logic iso151408Logic;

    /**
     * SqlId. 方法名
     */
    interface SqlId {
        String SQL_ID_FIND_AVAILABILITY = "findOrderAvailability";
        String SQL_ID_FIND_RETURN = "findReturn";
        String SQL_ID_FIND_RETURN_DETAIL = "findReturnDetail";
        String SQL_ID_SAVE_RETURN_STATUS = "saveReturnStatus";
        String SQL_ID_UPDATE_AVA_DETAIL = "modifyAvaDetail";
        String SQL_ID_UPDATE_DETAIL = "modifyDetail";
        String SQL_ID_UPDATE_SO_STOCK_SP = "updateSoStockSp";
        String SQL_ID_UPDATE_SO_STOCK_SL = "updateSoStockSl";
        String SQL_ID_UPDATE_SO_ORDER = "updateSoOrder";
    }

    /**
     * 申请退货画面初始数据
     *
     * @param orderId
     * @return 申请退货画面初始数据
     */
    @Transactional(readOnly = true)
    public List<SO151411Bean> findReturnList(String orderId) {
        logger.info("申请退货画面初始数据查询");
        BaseParam param = new BaseParam();
        param.setFilter("orderId", orderId);
        List<SO151411Bean> so151411Beans = super.findList(SqlId.SQL_ID_FIND_AVAILABILITY, param);
        return so151411Beans;
    }

    /**
     * 申请退货
     *
     * @param beans
     * @param param
     * @param returnMode
     */
    @Transactional
    public void returnOrder( Collection<SO151411Bean> beans, BaseParam param, String returnMode) {
        SoReturn soReturn = null;
        List<SoReturnDetail> soReturnDetails = new ArrayList<>();
        BigDecimal returnAmount = null;
        checkReturnQty(beans);
        for (SO151411Bean bean : beans) {
            bean.setUpdId(param.getUpdId());
            bean.setUpdTime(DateTimeUtil.getCustomerDate());
            returnAmount = DecimalUtil.add(returnAmount, DecimalUtil.multiply(bean.getReturnQty(), bean.getPdPrice()));
            if (soReturn == null) {
                soReturn = super.findOne(SqlId.SQL_ID_FIND_RETURN, bean);
                soReturn.setReturnMode(returnMode);
                soReturn.setRoleType(CapitalPoolConst.RoleType.ROLE_BUYERE);// 角色 买手
                soReturn.setReturnId(commonLogic.maxId("so_return", "RETURN_ID"));
                soReturn.setReturnCode(orderLogic.getReturnOrderCode(soReturn.getReturnId()));
            }
            SoReturnDetail soReturnDetail = super.findOne(SqlId.SQL_ID_FIND_RETURN_DETAIL, bean);
            soReturnDetail.setDetailId(commonLogic.maxId("so_return_detail", "DETAIL_ID"));
            soReturnDetail.setReturnId(soReturn.getReturnId());
            soReturnDetail.setInboundBatch(soReturn.getReturnCode() + soReturn.getReturnId());
            //Add by wang_jianzhou for bug#3736 at 2016/11/25 Start.
            soReturnDetail.setWeight(soReturnDetail.getReturnQty().multiply(iso151408Logic.getPdInfo(soReturnDetail.getPdCode()).getNetweightOut()));
            soReturnDetail.setVolume(soReturnDetail.getReturnQty().multiply(soReturnDetail.getPackingVolume()));
            //Add by wang_jianzhou for bug#3736 at 2016/11/25 end.
            soReturnDetails.add(soReturnDetail);
            super.modify(SqlId.SQL_ID_UPDATE_AVA_DETAIL, bean);
            super.modify(SqlId.SQL_ID_UPDATE_DETAIL, bean);
        }
        soReturn.setReturnAmount(returnAmount);
        logger.info("保存退货数据");
        super.save(soReturn);
        super.batchSave(soReturnDetails);
        SoReturnStatus soReturnStatus = new SoReturnStatus();
        BeanUtils.copyProperties(soReturn, soReturnStatus);
        soReturnStatus.setStatusId(commonLogic.maxId("so_return_status", "STATUS_ID"));
        super.save(SqlId.SQL_ID_SAVE_RETURN_STATUS, soReturnStatus);
        // 更新order主表return_flg
        param.setFilterObject("orderId", soReturn.getOrderId());
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        super.modify(SqlId.SQL_ID_UPDATE_SO_ORDER, param);
        // 囤货订单回退库存
        this.updateStockForReturn(beans);
    }

    /**
     * check买手可用库存
     *
     * @param beans
     */
    public void checkReturnQty(Collection<SO151411Bean> beans) {
        logger.info("check买手可用库存");
        StockParam stockParam = new StockParam();
        SO151411Bean bean = beans.iterator().next();
        stockParam.setLgcsCode(bean.getLgcsCode());
        stockParam.setSlCode(bean.getSellerCode());
        if (OrderConst.OrderType.BUYER_STOCKPILING_ORDER == bean.getOrderType()) {
            stockParam.setSupplyPlatform(NumberConst.IntDef.INT_ONE);
        } else {
            stockParam.setSupplyPlatform(NumberConst.IntDef.INT_TWO);
        }
        List<SoStockSl> soStockSls = stockLogic.findSellerStock(stockParam);
        for (SO151411Bean stockBean : beans) {
            for (SoStockSl soStockSl : soStockSls) {
                if (soStockSl.getPdCode().equals(stockBean.getPdCode()) && DecimalUtil.isLess(soStockSl.getStockQty(), stockBean.getReturnQty())) {
                    throw new BusinessException("买手库存不足！");
                }
            }
        }
    }

    /**
     * 囤货订单回退库存
     *
     * @param beans
     */
    public void updateStockForReturn(Collection<SO151411Bean> beans) {
        logger.info("回退库存");
        for (SO151411Bean stockBean : beans) {
            StockParam stockParam = new StockParam();
            stockParam.setUpdId(stockBean.getUpdId());
            stockParam.setUpdTime(DateTimeUtil.getCustomerDate());
            stockParam.setLgcsCode(stockBean.getLgcsCode());
            stockParam.setPdCode(stockBean.getPdCode());
            stockParam.setSlCode(stockBean.getSellerCode());
            stockParam.setSupplierCode(stockBean.getSupplierCode());
            stockParam.setStockNum(stockBean.getReturnQty());
            stockParam.setStockType(StockConst.StockType.NORMAL_STOCK);
            stockParam.setWarehouseCode(StockConst.WarehouseCode.SH_CODE);
            if (OrderConst.OrderType.BUYER_STOCKPILING_ORDER == stockBean.getOrderType()) {
                stockParam.setSupplyPlatform(NumberConst.IntDef.INT_ONE);
            } else {
                stockParam.setSupplyPlatform(NumberConst.IntDef.INT_TWO);
            }
            super.modify(SqlId.SQL_ID_UPDATE_SO_STOCK_SP, stockParam);
            super.modify(SqlId.SQL_ID_UPDATE_SO_STOCK_SL, stockParam);
        }
    }
}
