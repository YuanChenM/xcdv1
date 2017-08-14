package com.msk.so.logic;

import com.msk.common.consts.StockConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.so.bean.ISO151806ProductRsParam;
import com.msk.so.bean.ISO151806RsParam;
import com.msk.so.bean.ISO151806RsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * zhang_qiang1   库存调整 logic
 */
@Service
public class ISO151806Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151806Logic.class);


    @Autowired
    private OrderLogic orderLogic;

    @Autowired
    private CommonLogic commonLogic;

    /**
     * 库存调整 业务
     *
     * @param rsParam
     * @return
     */
    @Transactional(readOnly = false)
    public ISO151806RsResult adjustInventory(ISO151806RsParam rsParam) {
        logger.info("库存调整业务开始");
        ISO151806RsResult result = new ISO151806RsResult();
        if (this.checkAdjustInventoryService(rsParam)) {
            Long adjustId = this.updateStock(rsParam);
            result.setAdjustId(adjustId);// 调整业务单Id
            result.setAdjustCode(rsParam.getAdjustCode());//调整业务单Code
        }
        return result;
    }


    /**
     * 修改库存
     *
     * @param rsParam
     */
    private Long updateStock(ISO151806RsParam rsParam) {
        String slCode = rsParam.getSlCode();
        String lgcsCode = rsParam.getLgcsCode();
        String adjustCode = rsParam.getAdjustCode();
        String adjustDate = rsParam.getAdjustDate();
        String adjustPerson = rsParam.getAdjustPerson();
        String reasonCode = rsParam.getReasonCode();
        List<ISO151806ProductRsParam> productList = rsParam.getProductList();
        Long adjustId = null;// 业务主键   去插入stockRecord 中
        for (ISO151806ProductRsParam productRsParam : productList) {
            String fromInventoryStatus = productRsParam.getFromInventoryStatus();// 出仓
            String toInventoryStatus = productRsParam.getToInventoryStatus();// 进仓
            if (StockConst.Inventory_Status.INVENTORY_STATUS.equals(fromInventoryStatus) && StockConst.Inventory_Status.INVENTORY_STATUS.equals(toInventoryStatus)) {// 不做处理
                continue;
            }
            if (!StockConst.Inventory_Status.INVENTORY_STATUS.equals(fromInventoryStatus) && !StockConst.Inventory_Status.INVENTORY_STATUS.equals(toInventoryStatus)) {// 不做处理
                continue;
            }
            BigDecimal adjustQty = productRsParam.getAdjustQty();
            String supplierCode = productRsParam.getSupplierCode();
            String sku = productRsParam.getSkuCode();
            BaseParam baseParam = new BaseParam();
            Map<String, Object> filterMap = baseParam.getFilterMap();
            BigDecimal dbSpStockCnt = this.getCheckSpStockNum(slCode, lgcsCode, productRsParam);
            BigDecimal dbSlStockCnt = this.getCheckSlStockNum(slCode, lgcsCode, sku);
            if (StockConst.Inventory_Status.INVENTORY_STATUS.equals(fromInventoryStatus)) {//出仓
                if (DecimalUtil.isLess(dbSpStockCnt, adjustQty)) {
                    throw new BusinessException("出仓数量大于该商品存储的数量！出仓数量：" + adjustQty + "  存储数量： " + dbSpStockCnt + " 供应商编码：" + supplierCode + " 物流区编码：" + lgcsCode + " sku:" + sku);
                }
                filterMap.put("type", NumberConst.IntDef.INT_TWO);//2：减少
                adjustQty = DecimalUtil.subtract(new BigDecimal(0), adjustQty);
            } else if (StockConst.Inventory_Status.INVENTORY_STATUS.equals(toInventoryStatus)) {//入仓
                BigDecimal spStockQty = DecimalUtil.add(dbSpStockCnt, adjustQty);
                if (DecimalUtil.isGreater(spStockQty, new BigDecimal("999999999999999999.99"))) {
                    throw new BusinessException("供应商调整过后的库存值超出数据库设置范围最大为999999999999999999.99，库存调整后值：" + spStockQty + "，库存值：" + dbSpStockCnt + " 调整值：" + adjustQty);
                }
                BigDecimal slStockQty = DecimalUtil.add(dbSlStockCnt, adjustQty);
                if (DecimalUtil.isGreater(slStockQty, new BigDecimal("999999999999999999.99"))) {
                    throw new BusinessException("卖家调整过后的库存值超出数据库设置范围最大为999999999999999999.99，库存调整后值：" + slStockQty + "，库存值：" + dbSlStockCnt + " 调整值：" + adjustQty);
                }
                filterMap.put("type", NumberConst.IntDef.INT_ONE);//1:添加
            }
            filterMap.put("flowId", adjustCode);//业务编码
            filterMap.put("adjustDate", adjustDate);//业务修改时间
            filterMap.put("adjustPerson", adjustPerson);//业务修改人
            filterMap.put("adjustReason", reasonCode);//库存调整原因
            filterMap.put("inboundBatch", productRsParam.getInboundBatch());//采购入库批次
            filterMap.put("updId", rsParam.getUpdId());//修改人Id
            filterMap.put("crtId", rsParam.getUpdId());//添加人Id
            filterMap.put("updTime", DateTimeUtil.getCustomerDate());// 修改时间
            filterMap.put("crtTime", DateTimeUtil.getCustomerDate());// 创建时间
            filterMap.put("slCode", slCode);// 卖家编码
            filterMap.put("lgcsCode", lgcsCode);// 物流区
            filterMap.put("supplierCode", supplierCode);
            filterMap.put("unit", productRsParam.getUnit());
            String pdCode = this.getProductCode(sku);
            filterMap.put("pdCode", pdCode);
            filterMap.put("adjustQty", adjustQty);
            this.updateSpStock(baseParam);
            this.updateSlStock(baseParam);
            Long stockId = this.saveStockRecord(baseParam);
            adjustId = stockId;
        }
        return adjustId;
    }

    /**
     * 修改卖家库存
     */
    private void updateSlStock(BaseParam baseParam) {
        this.modify(SqlId.SQL_ID_UPDATE_SL_STOCK, baseParam);
    }


    /**
     * 保存记录
     *
     * @param baseParam
     * @return
     */
    private Long saveStockRecord(BaseParam baseParam) {
        Long maxId = this.commonLogic.maxId("so_stock_record", "STOCK_ID");
        Map<String, Object> filterMap = baseParam.getFilterMap();
        filterMap.put("stockId", maxId);
        this.modify(SqlId.SQL_ID_SAVE_STOCK_RECORD, baseParam);
        return maxId;
    }

    /**
     * 修改供应商 库存
     */
    private void updateSpStock(BaseParam baseParam) {
        this.modify(SqlId.SQL_ID_UPDATE_SP_STOCK, baseParam);
    }

    /**
     * 验证卖家编码，卖家库存是否存在，对应的供应商是否存在
     *
     * @return
     */
    private boolean checkAdjustInventoryService(ISO151806RsParam rsParam) {
        boolean checkFlg = true;
        String slCode = rsParam.getSlCode();
        String lgcsCode = rsParam.getLgcsCode();
        if (!StockConst.SL_Name.SL_CODE.equals(slCode)) {
            throw new BusinessException("卖家编码，目前应该为销售平台0000000");
        }
        List<ISO151806ProductRsParam> productList = rsParam.getProductList();    // 查询  供应商对应的库存是否存在
        for (ISO151806ProductRsParam product : productList) {
            BigDecimal adjustQty = product.getAdjustQty();
            if (DecimalUtil.isLess(adjustQty, new BigDecimal(0))) {
                throw new BusinessException("库存调整数值 不能小于0");
            }
            BigDecimal spStockCnt = this.getCheckSpStockNum(slCode, lgcsCode, product);
            if (spStockCnt == null) {
                throw new BusinessException("查询不到该供应商库存！ slCode:" + slCode + " lgcsCode:" + lgcsCode + " supplierCode:" + product.getSupplierCode() + " sku:" + product.getSkuCode());
            }
        }
        return checkFlg;
    }


    /**
     * @param slCode         卖家编码
     * @param lgcsCode       物流区
     * @param productRsParam 产品信息
     * @return
     */
    private BigDecimal getCheckSpStockNum(String slCode, String lgcsCode, ISO151806ProductRsParam productRsParam) {
        BaseParam baseParam = new BasePageParam();
        Map<String, Object> filterMap = baseParam.getFilterMap();
        filterMap.put("slCode", slCode);// 卖家编码
        filterMap.put("lgcsCode", lgcsCode);// 物流区
        filterMap.put("supplierCode", productRsParam.getSupplierCode());
        String pdCode = this.getProductCode(productRsParam.getSkuCode());
        filterMap.put("pdCode", pdCode);
        BigDecimal spStockCnt = (BigDecimal) this.findObject(SqlId.SQL_ID_CHECK_SP_STOCK_NUM, baseParam);
        return spStockCnt;
    }

    /**
     * 获取卖家产品库存
     *
     * @param slCode
     * @param lgcsCode
     * @param skuCode
     * @return
     */
    private BigDecimal getCheckSlStockNum(String slCode, String lgcsCode, String skuCode) {
        BaseParam baseParam = new BasePageParam();
        Map<String, Object> filterMap = baseParam.getFilterMap();
        filterMap.put("slCode", slCode);// 卖家编码
        filterMap.put("lgcsCode", lgcsCode);// 物流区
        String pdCode = this.getProductCode(skuCode);
        filterMap.put("pdCode", pdCode);
        BigDecimal slStockCnt = (BigDecimal) this.findObject(SqlId.SQL_ID_CHECK_SL_STOCK_NUM, baseParam);
        return slStockCnt;
    }

    /**
     * 根据sku  获取pdCode
     *
     * @param sku
     * @return
     */
    public String getProductCode(String sku) {
        String productCode = "";
        /** slCodeDis(1-7) */
        String slCodeDis = sku.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_SEVEN);
        /** slPdArtno(8-12) */
        String slPdArtno = sku.substring(NumberConst.IntDef.INT_SEVEN, NumberConst.IntDef.INT_TWELVE);
        //产品编码
        productCode = orderLogic.getPdCode(slPdArtno, slCodeDis);
        return productCode;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    interface SqlId {
        String SQL_ID_CHECK_SP_STOCK_NUM = "checkSpStockCnt";
        String SQL_ID_CHECK_SL_STOCK_NUM = "checkSlStockCnt";
        String SQL_ID_UPDATE_SP_STOCK = "updateSpStockCnt";
        String SQL_ID_UPDATE_SL_STOCK = "updateSlStockCnt";
        String SQL_ID_SAVE_STOCK_RECORD = "saveStockRecord";
    }
}
