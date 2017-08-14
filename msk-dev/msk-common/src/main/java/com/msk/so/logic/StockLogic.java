package com.msk.so.logic;

import com.msk.common.consts.OrderConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoStockSl;
import com.msk.core.entity.SoStockSupp;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import com.msk.so.bean.BaseStockBean;
import com.msk.so.bean.ProductStock;
import com.msk.so.bean.StockBean;
import com.msk.so.bean.StockParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * 库存模块共通Logic.
 *
 * @author yuan_chen
 * @version 1.0
 */
@Service
public class StockLogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(StockLogic.class);

    @Autowired
    private ProductLogic productLogic;

    @Autowired
    private CommonLogic commonLogic;

    /**
     * 获得卖家基本的产品库存情况,包含价格
     *
     * @author yuan_chen
     */
    interface SqlId {
        String SQLID_GET_STOCK_SL = "getSoStockSl";
        String SQLID_GET_STOCK_SUPP = "getSoStockSupp";
        String SQLID_COUNT_SL_STOCKED = "countSlStocked";
        String SQLID_COUNT_STOCK_SL = "countSoStockSl";
        String SQLID_FROZEN_STOCK_SL = "frozenStockSl";
        String SQLID_CANCEL_FROZEN_STOCK_SL = "cancelFrozenStockSl";
        String SQLID_COUNT_SUPP_STOCKED = "countSuppStocked";
        String SQLID_COUNT_STOCK_SUPP = "countSoStockSupp";
        String SQLID_FROZEN_STOCK_SUPP = "frozenStockSupp";
        String SQLID_CANCEL_FROZEN_STOCK_SUPP = "cancelFrozenStockSupp";
        String SQLID_ADD_STOCK_SL_QTY = "addStockSlQty";
        String SQLID_ADD_STOCK_SUPP_QTY = "addStockSuppQty";
        String SQLID_INSERT_STOCK_SL = "insertStockSl";
        String SQLID_INSERT_STOCK_SUPP = "insertStockSupp";
        String SQLID_INSERT_STOCK_OCC_SL = "insertStockOccSl";
        String SQLID_INSERT_STOCK_OCC_SUPP = "insertStockOccSupp";
        String SQL_ID_FIND_PRODUCT_STOCK_LIST = "findProductStockList";
        String SQL_ID_COUNT_PRODUCT_STOCK = "countProductStock";
        /**获得卖家库存总数据*/
        String SQL_ID_FIND_SELLER_STOCK = "findSellerStock";
        /**查询卖家对应的库存信息*/
        String SQL_ID_FIND_SELLER_SUPPLIER_STOCK = "findSellerSupplierStock";

        String SQL_ID_INSERT_SO_STOCK_RECORD= "insertSoStockRecord";
        String SQL_ID_INSERT_SO_STOCK_SP_HISTORY= "insertSoStockSpHistory";
        String SQL_ID_INSERT_SO_STOCK_SP= "insertSoStockSp";
        String SQL_ID_UPDATE_SO_STOCK_SP= "updateSoStockSp";
        String SQL_ID_INSERT_SO_STOCK_SL= "insertSoStockSl";
        String SQL_ID_UPDATE_SO_STOCK_SL= "updateSoStockSl";
        String SQL_ID_GET_SALER_STOCK_NUM = "getSalerStockNum";
        String SQL_ID_GET_ORDER_LIST = "getOrderList";
        String SQL_ID_GET_CHILD_ORDER_LIST = "getChildOrderList";
        String SQL_ID_GET_TODAY_STOCK_NUM = "getTodayStockNum";
        String SQL_ID_GET_SP_STOCK_NUM = "getSpStockNum";
    }

    /**
     * 获得卖家所有的产品和库存信息
     * @param param 查询参数：必须参数物流区，卖家编号和供应平台
     * @return 卖家所有的产品和库存信息
     */
    @Transactional(readOnly = true)
    public List<SoStockSl> findSellerStock(StockParam param){
        return super.findList(SqlId.SQL_ID_FIND_SELLER_STOCK,param);
    }

    /**
     * 获得卖家对应的供应商库存信息
     * @param param 查询参数
     * @return 卖家对应的供应商所有库存信息
     */
    @Transactional(readOnly = true)
    public List<BaseStockBean> findSellerSupplierStock(StockParam param){
        return this.findList(SqlId.SQL_ID_FIND_SELLER_SUPPLIER_STOCK,param);
    }


    /**
     * 获得卖家基本的产品库存情况,包含价格
     * 
     * @param param 查询条件
     * @return 产品库存情况
     */
    @Transactional(readOnly = true)
    public PageResult<ProductStock> findProductStockPage(BasePageParam param) {
        int count = this.countProductStock(param);
        List<ProductStock> productStockList = null;
        if (count != NumberConst.IntDef.INT_ZERO) {
            productStockList = this.findProductStockList(param);
        } else {
            productStockList = new ArrayList<ProductStock>();
        }
        PageResult<ProductStock> result = new PageResult<ProductStock>();
        result.setData(productStockList);
        result.setRecordsTotal(count);
        return result;
    }

    /**
     * 分页查询获得产品库存Count
     *
     * @param param 查询条件
     * @return Count
     */
    @Transactional(readOnly = true)
    public int countProductStock(BasePageParam param) {
        return super.getCount(SqlId.SQL_ID_COUNT_PRODUCT_STOCK, param);
    }

    public List<ProductStock> findProductStockList(BasePageParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PRODUCT_STOCK_LIST, param);
    }

    /**
     * 检查卖家库存数量
     *
     * @param param
     * @return , 不足返回f库存充足返回truealse
     */
    public boolean checkStockQty(StockParam param) {
        logger.debug("检查卖家库存");
        int count = super.getCount(SqlId.SQLID_COUNT_SL_STOCKED, param);
        if (count > NumberConst.IntDef.INT_ZERO) {
            return true;
        }
        return false;
    }

    /**
     * 检查卖家是否有库存
     *
     * @param param
     * @return 库存存在返回true, 不存在返回false
     */
    public boolean checkStock(StockParam param) {
        logger.debug("检查卖家库存");
        int count = super.getCount(SqlId.SQLID_COUNT_STOCK_SL, param);
        if (count > NumberConst.IntDef.INT_ZERO) {
            return true;
        }
        return false;
    }

    /**
     * 查询卖家库存
     *
     * @param param StockParam
     * @return 卖家库存
     */
    @Transactional(readOnly = true)
    public StockBean getSlStock(StockParam param) {
        logger.debug("获得卖家库存");

        StockBean stockBean = new StockBean();
        List<SoStockSl> slStockList = super.findList(SqlId.SQLID_GET_STOCK_SL, param);
        stockBean.setSoSlStockList(slStockList);
        return stockBean;
    }

    /**
     * 更新库存（冻结卖家库存）
     *
     * @param param StockParam
     * @return 更新结果
     */
    @Transactional
    public int frozenStock(StockParam param) {
        logger.debug("冻结库存");
        return this.updateStock(SqlId.SQLID_COUNT_SL_STOCKED, SqlId.SQLID_FROZEN_STOCK_SL, param);
    }

    /**
     * 更新库存（取消冻结卖家库存）
     *
     * @param param StockParam
     * @return 更新结果
     */
    @Transactional
    public int cancelFrozenStock(StockParam param) {
        logger.debug("取消冻结库存");
        return this.updateStock(SqlId.SQLID_COUNT_STOCK_SL, SqlId.SQLID_CANCEL_FROZEN_STOCK_SL, param);
    }

    /**
     * 更新库存
     *
     * @param countSqlId count的sqlId
     * @param sqlId      更新sqlID
     * @param param      StockParam
     * @return 更新结果
     */
    private int updateStock(String countSqlId, String sqlId, StockParam param) {
        logger.debug("更新库存");
        int count = super.getCount(countSqlId, param);
        if (NumberConst.IntDef.INT_ONE == count) {
            return super.modify(sqlId, param);
        } else if (NumberConst.IntDef.INT_ZERO == count) {
            throw new BusinessException("无该产品库存或库存不足!");
        } else {
            throw new BusinessException("不允许同时更新多个产品的库存数量!");
        }
    }

    /**
     * 检查供应商库存数量
     *
     * @param param
     * @return 库存充足返回true, 不足返回false
     */
    public boolean checkSuppStockQty(StockParam param) {
        logger.debug("检查供应商库存");
        int count = super.getCount(SqlId.SQLID_COUNT_SUPP_STOCKED, param);
        if (count > NumberConst.IntDef.INT_ZERO) {
            return true;
        }
        return false;
    }

    /**
     * 检查供应商是否有库存
     *
     * @param param
     * @return 库存有返回true, 没有返回false
     */
    public boolean checkSuppStock(StockParam param) {
        logger.debug("检查供应商库存");
        int count = super.getCount(SqlId.SQLID_COUNT_STOCK_SUPP, param);
        if (count > NumberConst.IntDef.INT_ZERO) {
            return true;
        }
        return false;
    }

    /**
     * 查询供应商库存
     *
     * @param param StockParam
     * @return 供应商库存
     */
    @Transactional(readOnly = true)
    public StockBean getSuppStock(StockParam param) {
        logger.debug("获得供应商库存");

        StockBean stockBean = new StockBean();
        List<SoStockSupp> suppStockList = super.findList(SqlId.SQLID_GET_STOCK_SUPP, param);
        stockBean.setSoSuppStockList(suppStockList);
        return stockBean;
    }

    /**
     * 查询供应商库存数量
     *
     * @param param StockParam
     * @return 供应商库存
     */
    @Transactional(readOnly = true)
    public BigDecimal getSuppStockQty(StockParam param) {
        logger.debug("获得供应商库存数量");

        List<SoStockSupp> suppStockList = super.findList(SqlId.SQLID_GET_STOCK_SUPP, param);
        if (suppStockList != null) {
            int size = suppStockList.size();
            if (size == NumberConst.IntDef.INT_ONE) {
                return suppStockList.get(NumberConst.IntDef.INT_ZERO).getStockQty();
            } else {
                BigDecimal stockQty = BigDecimal.ZERO;
                for (SoStockSupp soStockSupp : suppStockList) {
                    stockQty = DecimalUtil.add(stockQty, soStockSupp.getStockQty());
                }
                return stockQty;
            }
        } else {
            throw new BusinessException("没有该产品的库存!");
        }
    }

    /**
     * 更新库存（冻结供应商库存）
     *
     * @param param StockParam
     * @return 更新结果
     */
    @Transactional
    public int frozenStockSupp(StockParam param) {
        logger.debug("冻结库存");
        return this.updateStock(SqlId.SQLID_COUNT_SUPP_STOCKED, SqlId.SQLID_FROZEN_STOCK_SUPP, param);
    }

    /**
     * 更新库存（取消冻结供应商库存）
     *
     * @param param StockParam
     * @return 更新结果
     */
    @Transactional
    public int cancelFrozenStockSupp(StockParam param) {
        logger.debug("取消冻结库存");
        return this.updateStock(SqlId.SQLID_COUNT_STOCK_SUPP, SqlId.SQLID_CANCEL_FROZEN_STOCK_SUPP, param);
    }

    /**
     * 增加库存数量或者新增一条库存信息
     *
     * @param stockParam StockParam
     */
    public void increaseStock(StockParam stockParam) {
        if (this.checkStock(stockParam)) {
            super.modify(SqlId.SQLID_ADD_STOCK_SL_QTY, stockParam);
        } else {
            super.save(SqlId.SQLID_INSERT_STOCK_SL, stockParam);
            super.save(SqlId.SQLID_INSERT_STOCK_OCC_SL, stockParam);
        }
        if (this.checkSuppStock(stockParam)) {
            super.modify(SqlId.SQLID_ADD_STOCK_SUPP_QTY, stockParam);
        } else {
            super.save(SqlId.SQLID_INSERT_STOCK_SUPP, stockParam);
            super.save(SqlId.SQLID_INSERT_STOCK_OCC_SUPP, stockParam);
        }
    }

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
     * 备份库存
     *
     * @param stockParam
     * @return 影响行数
     */
    public int saveStockHistory(StockParam stockParam) {
        logger.debug("备份库存");
        return super.save(SqlId.SQL_ID_INSERT_SO_STOCK_SP_HISTORY, stockParam);
    }

    /**
     * 保存库存变更履历
     * @param stockParam
     * @return 影响行数
     */
    public int saveStockRecord(StockParam stockParam){
        logger.debug("保存库存变更履历");
        //变更类型
        if (stockParam.getStockNum().compareTo(BigDecimal.ZERO) >= 0) {
            //增加库存
            stockParam.setChangeType("1");
        } else {
            //减少库存
            stockParam.setChangeType("2");
        }
        stockParam.setStockId(this.commonLogic.maxId("SO_STOCK_RECORD", "STOCK_ID"));
        stockParam.setCrtTime(DateTimeUtil.getCustomerDate());
        return super.save(SqlId.SQL_ID_INSERT_SO_STOCK_RECORD, stockParam);
    }

    /**
     * 保存卖家库存
     * @param stockParam
     * @return 影响行数
     */
    public int saveStockOfSeller(StockParam stockParam) {
        //影响行数
        int returnInt = 0;
        stockParam.setUpdTime(DateTimeUtil.getCustomerDate());
        returnInt = super.modify(SqlId.SQL_ID_UPDATE_SO_STOCK_SL, stockParam);
        //影响行数<=0时，说明数据库中不存在此商品，则新增卖家库存
        if (returnInt <= 0) {
            stockParam.setStockId(this.commonLogic.maxId("SO_STOCK_SL", "STOCK_ID"));
            stockParam.setCrtTime(DateTimeUtil.getCustomerDate());
            returnInt = super.save(SqlId.SQL_ID_INSERT_SO_STOCK_SL, stockParam);
        }
        return returnInt;
    }

    /**
     * 保存供应商库存
     * @param stockParam
     * @return 影响行数
     */
    @Transactional
    public int saveStockOfSupplier(StockParam stockParam){
        int returnInt = 0;

        setStockParam(stockParam);
        //更新供应商库存
        stockParam.setUpdTime(DateTimeUtil.getCustomerDate());
        returnInt = super.modify(SqlId.SQL_ID_UPDATE_SO_STOCK_SP, stockParam);
        //影响行数<=0时，说明供应商库存中不存在此商品，则新增供应商库存
        if (returnInt <= 0) {
            stockParam.setCrtTime(DateTimeUtil.getCustomerDate());
            returnInt = super.save(SqlId.SQL_ID_INSERT_SO_STOCK_SP, stockParam);
        }

        //更新卖家库存
        if (returnInt == 1) {
            returnInt = saveStockOfSeller(stockParam);
        } else {
            throw new BusinessException("更新卖家库存失败,请和管理员联系");
        }

        //保存库存变更履历
        if (returnInt == 1) {
            returnInt = saveStockRecord(stockParam);
        } else {
            throw new BusinessException("保存库存变更履历失败,请和管理员联系");
        }

        return returnInt;
    }

    /**
     * 保存供应商库存
     * @param stockParamList
     * @return 影响行数
     */
    @Transactional
    public void saveStockOfSupplierList(List<StockParam> stockParamList) {
        StockParam stockParam = null;

        for(int i =0;i < stockParamList.size(); i++) {

            stockParam = stockParamList.get(i);

            setStockParam(stockParam);

            if (stockParam.getSupplyPlatform() == OrderConst.OrderSource.DQS){
                stockParam.setSupplyPlatform(OrderConst.OrderSource.SNK);
            }

            int returnInt = 0;
            //更新供应商库存
            stockParam.setUpdTime(DateTimeUtil.getCustomerDate());
            returnInt = super.modify(SqlId.SQL_ID_UPDATE_SO_STOCK_SP, stockParam);
            //影响行数<=0时，说明供应商库存中不存在此商品，则新增供应商库存
            if (returnInt <= 0) {
                stockParam.setStockId(this.commonLogic.maxId("SO_STOCK_SP", "STOCK_ID"));
                stockParam.setCrtTime(DateTimeUtil.getCustomerDate());
                returnInt = super.save(SqlId.SQL_ID_INSERT_SO_STOCK_SP, stockParam);
            }

            //更新卖家库存
            if (returnInt == 1) {
                returnInt = saveStockOfSeller(stockParam);
            } else {
                throw new BusinessException("更新卖家库存失败,请和管理员联系");
            }

            //保存库存变更履历
            if (returnInt == 1) {
                returnInt = saveStockRecord(stockParam);
            } else {
                throw new BusinessException("保存库存变更履历失败,请和管理员联系");
            }
        }
    }

    /**
     * 设置 StockParam的相关参数
     * @param stockParam
     */
    private void setStockParam(StockParam stockParam){
        if(stockParam.getPdCode()==null || stockParam.getPdCode() ==""){
            throw new BusinessException("请输入符合要求的产品编号");
        }
        ProductBean product = this.productLogic.getProductInfo(stockParam.getPdCode());
        if (product == null) {
            logger.info("产品编号:" + stockParam.getPdCode() + "没有相关产品");
            throw new BusinessException("产品编号:" + stockParam.getPdCode() + "没有相关产品");
        }
        if(product.getPdBreed()==null || product.getPdClasses()==null ||product.getPdFeature() ==null || product.getPdGrade()==null){
            throw new BusinessException("没有相关产品参数");
        }
        //TODO
        //物流区名称
        //仓库名称
        //卖家名称
        //供应商名称
        //产品类型
        stockParam.setClassesCode(product.getPdClasses().getClassesCode());
        //产品类型名称
        stockParam.setClassesName(product.getPdClasses().getClassesName());
        //产品品种
        stockParam.setBreedCode(product.getPdBreed().getBreedCode());
        //产品品种名称
        stockParam.setBreedName(product.getPdBreed().getBreedName());
        //特征编码
        stockParam.setFeatureCode(product.getPdFeature().getFeatureCode());
        //特征编码名称
        stockParam.setFeatureName(product.getPdFeature().getFeatureName());
        //产品包装编码
        //stockParam.setNormsCode(product.getPdNormsStd().getNormsCode());
        //产品包装名称
        //产品名称
        //产品等级
        stockParam.setPdLevel(product.getPdGrade().getGradeCode());
        //产品单位
        //单箱体积
        //重量
        //体积
    }

    /**
     * 卖家可用库存
     * @param stockParam
     * @return
     */
    public BigDecimal getSalerStock(StockParam stockParam)
    {
        stockParam.setHistoryDate(getTodayTime());

        BigDecimal salerStockNum = (BigDecimal)this.findObject(SqlId.SQL_ID_GET_SALER_STOCK_NUM,stockParam);

        //得到主订单订单编号
        List salerOrderList = this.findList(SqlId.SQL_ID_GET_ORDER_LIST,stockParam);

        //得到子订单订单编号
        List childSalerOrderList = this.findList(SqlId.SQL_ID_GET_CHILD_ORDER_LIST,stockParam);

        //得到所有的订单编号
        List orderList = getOrderList(salerOrderList,childSalerOrderList);

        if(CollectionUtils.isEmpty(orderList))
        {
            return salerStockNum;
        }
        //得到所有今天订单的供货数量
        BigDecimal todayStockNum = getTodayStockNum(orderList,stockParam);

        return DecimalUtil.subtract(salerStockNum,todayStockNum);
    }

    /**
     * 供应商可用库存
     * @param stockParam
     * @return
     */
    public BigDecimal getSupplierStock(StockParam stockParam)
    {
        stockParam.setHistoryDate(getTodayTime());

        BigDecimal spStockNum = (BigDecimal)this.findObject(SqlId.SQL_ID_GET_SP_STOCK_NUM,stockParam);

        //得到主订单订单编号
        List spOrderList = this.findList(SqlId.SQL_ID_GET_ORDER_LIST,stockParam);

        //得到子订单订单编号
        List childSpOrderList = this.findList(SqlId.SQL_ID_GET_CHILD_ORDER_LIST,stockParam);

        //得到所有的订单编号（问题：当主子订单数量比较大的时候不建议用这种方式可以分批处理）
        List orderList = getOrderList(spOrderList,childSpOrderList);

        if(CollectionUtils.isEmpty(orderList))
        {
            return spStockNum;
        }
        //得到所有今天订单的供货数量
        BigDecimal todayStockNum = getTodayStockNum(orderList,stockParam);

        return DecimalUtil.subtract(spStockNum,todayStockNum);
    }

    /**
     * 得到所有今天订单的供货数量
     * @param orderList
     * @param stockParam
     * @return
     */
    public BigDecimal getTodayStockNum(List orderList,StockParam stockParam)
    {
        Map<String,Object> paramsMap = new HashMap<String,Object>();

        paramsMap.put("orderList",orderList);
        paramsMap.put("pdCode",stockParam.getPdCode());

        BaseParam baseParam = new BaseParam();
        baseParam.setFilterMap(paramsMap);

        return (BigDecimal)this.findObject(SqlId.SQL_ID_GET_TODAY_STOCK_NUM,baseParam);
    }
    /**
     * 编译订单主和子订单List
     * @param OrderList
     * @param childOrderList
     * @return
     */
    public List getOrderList(List OrderList,List childOrderList)
    {
        if (CollectionUtils.isEmpty(childOrderList))
        {
            return OrderList;
        }

        for(int i = 0 ;i < childOrderList.size();i++)
        {
            OrderList.add(childOrderList.get(i));
        }
        return OrderList;
    }

    /**
     * 得到当前日期参数
     * @return
     */
    public String getTodayTime()
    {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);//获取年份
        int month=ca.get(Calendar.MONTH) + 1;//获取月份
        int day=ca.get(Calendar.DATE);//获取日

        String monthStr = month +"";
        String dayStr = day + "";
        if(month>0 && month <10)
        {
            monthStr = "0"+month;
        }
        if(day>0 && day <10)
        {
            dayStr = "0"+day;
        }
        return year+"-"+monthStr+"-"+dayStr;
    }

    /**
     * 产品库存判断是否断货
     * @param param 库存参数
     */
    public boolean shortSupplyProduct(StockParam param){
        //标识是否断货
        boolean flag = false;
        param.setStockNum(BigDecimal.ZERO);

        //检查卖家是否有库存
        boolean isSellerQty = this.checkStock(param);
        //检查供应商是否有库存
        boolean isSupplyQty = this.checkSuppStock(param);

        if(isSellerQty || isSupplyQty)
        {
            flag = true;
        }
        return flag;
    }


}
