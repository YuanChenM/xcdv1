package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.PdNormsStd;
import com.msk.so.bean.ProductStock;
import com.msk.so.bean.StockParam;
import com.msk.so.bean.SuppStock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * SO151408Logic
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service
public class SO15140801Logic extends BaseLogic{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SO15140801Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_FIND_PRODUCT_STOCK_LIST = "findProductStockList";
        String SQL_ID_FIND_PRODUCT_STOCK_LIST2 = "findProductStockList2";
        String SQL_ID_COUNT_PRODUCT_STOCK = "countProductStock";
        String SQL_ID_COUNT_PRODUCT_STOCK2 = "countProductStock2";
        String SQL_ID_FIND_SUPP_STOCK_LIST = "findSuppStockList";
        String SQL_ID_FIND_SUPP_STOCK_LIST2 = "findSuppStockList2";
        String SQL_ID_COUNT_SUPP_STOCK = "countSuppStock";
        String SQL_ID_COUNT_SUPP_STOCK2 = "countSuppStock2";
        String SQL_ID_FIND_NORMS_INFO = "findNormsInfo";
    }

    /**
     * 获得卖家基本的产品库存情况,包含价格
     *
     * @param param 查询条件
     * @return 产品库存情况
     */
    @Transactional(readOnly = true)
    public PageResult<ProductStock> findSuppStock(BasePageParam param) {
        int count = super.getCount(SqlId.SQL_ID_COUNT_PRODUCT_STOCK, param);
        List<ProductStock> productStockList = null;
        if (count != NumberConst.IntDef.INT_ZERO) {
            productStockList = super.findList(SqlId.SQL_ID_FIND_PRODUCT_STOCK_LIST, param);
        } else {
            productStockList = new ArrayList<ProductStock>();
        }
        PageResult<ProductStock> result = new PageResult<ProductStock>();
        result.setData(productStockList);
        result.setRecordsTotal(count);
        return result;
    }

    /**
     * 获得卖家基本的产品库存情况,包含价格
     *
     * @param param 查询条件
     * @return 产品库存情况
     */
    @Transactional(readOnly = true)
    public PageResult<ProductStock> findProductStockPage(BasePageParam param) {
        int count = super.getCount(SqlId.SQL_ID_COUNT_PRODUCT_STOCK, param);
        List<ProductStock> productStockList = null;
        if (count != NumberConst.IntDef.INT_ZERO) {
            productStockList = super.findList(SqlId.SQL_ID_FIND_PRODUCT_STOCK_LIST, param);
        } else {
            productStockList = new ArrayList<ProductStock>();
        }
        PageResult<ProductStock> result = new PageResult<ProductStock>();
        result.setData(productStockList);
        result.setRecordsTotal(count);
        return result;
    }


    @Transactional(readOnly = true)
    public PageResult<ProductStock> findProductStockPage2(BasePageParam param) {
        int count = super.getCount(SqlId.SQL_ID_COUNT_PRODUCT_STOCK2, param);
        List<ProductStock> productStockList = null;
        if (count != NumberConst.IntDef.INT_ZERO) {
            productStockList = super.findList(SqlId.SQL_ID_FIND_PRODUCT_STOCK_LIST2, param);
            for (ProductStock productStock:productStockList){
                StockParam stockParam = new StockParam();
                stockParam.setPdCode(productStock.getPdCode());
                PdNormsStd pdNormsStd = super.findOne(SqlId.SQL_ID_FIND_NORMS_INFO,stockParam);
                if(null != pdNormsStd){
                    productStock.setPackingVolume(pdNormsStd.getNormsVolume().divide(BigDecimal.valueOf(1000000)));
                    productStock.setNetWeightOut(pdNormsStd.getNetweightOut());
                    productStock.setNormsName(pdNormsStd.getNormsOut());
                }
            }
        } else {
            productStockList = new ArrayList<ProductStock>();
        }
        PageResult<ProductStock> result = new PageResult<ProductStock>();
        result.setData(productStockList);
        result.setRecordsTotal(count);
        return result;
    }

    /**
     * 获取供应商列表
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public PageResult<SuppStock> findSuppStockPage(BasePageParam param) {
        int count = super.getCount(SqlId.SQL_ID_COUNT_SUPP_STOCK, param);
        List<SuppStock> productStockList = null;
        if (count != NumberConst.IntDef.INT_ZERO) {
            productStockList = super.findList(SqlId.SQL_ID_FIND_SUPP_STOCK_LIST, param);
            for (SuppStock productStock:productStockList){
                StockParam stockParam = new StockParam();
                stockParam.setPdCode(productStock.getPdCode());
                PdNormsStd pdNormsStd = super.findOne(SqlId.SQL_ID_FIND_NORMS_INFO,stockParam);
                if(null != pdNormsStd){
                    productStock.setPackingVolume(pdNormsStd.getNormsVolume().divide(BigDecimal.valueOf(1000000)));
                    productStock.setNetWeightOut(pdNormsStd.getNetweightOut());
                    productStock.setNormsName(pdNormsStd.getNormsOut());
                }
            }
        } else {
            productStockList = new ArrayList<SuppStock>();
        }
        PageResult<SuppStock> result = new PageResult<SuppStock>();
        result.setData(productStockList);
        result.setRecordsTotal(count);
        return result;
    }


    @Transactional(readOnly = true)
    public PageResult<SuppStock> findSuppStockPage2(BasePageParam param) {
        int count = super.getCount(SqlId.SQL_ID_COUNT_SUPP_STOCK2, param);
        List<SuppStock> productStockList = null;
        if (count != NumberConst.IntDef.INT_ZERO) {
            productStockList = super.findList(SqlId.SQL_ID_FIND_SUPP_STOCK_LIST2, param);
        } else {
            productStockList = new ArrayList<SuppStock>();
        }
        PageResult<SuppStock> result = new PageResult<SuppStock>();
        result.setData(productStockList);
        result.setRecordsTotal(count);
        return result;
    }

}
