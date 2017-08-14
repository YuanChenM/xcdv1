package com.msk.batch.so.logic;

import com.msk.batch.so.bean.BSO152404Bean;
import com.msk.batch.so.bean.BSO152404Param;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.consts.StockConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.StockParam;
import com.msk.so.logic.StockLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * StockTransferOfBuyerLogic
 *
 * @author zhang_lingbo
 * @version 1.0
 */
@Service
public class BSO152404Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152404Logic.class);

    @Autowired
    private StockLogic stockLogic;
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
     * 库存调拨
     */
    public void stockTransfer() {
        logger.debug("获取需要调拨的买手订单");
        List<BSO152404Bean> BSO152404BeanList = null;
        BaseParam baseParam = new BaseParam();
        Map<String, Object> filterMap = new HashMap<>();
        filterMap.put("orderType1", OrderConst.OrderType.BUYER_STOCKPILING_ORDER);
        filterMap.put("orderType2", OrderConst.OrderType.THIRD_BUYER_ORDER);
        filterMap.put("status", StatusConst.OrderStatusDef.CONFIRM);
        baseParam.setFilterMap(filterMap);
        //获取需要调拨的买手订单列表
        BSO152404BeanList = super.findList(SqlId.SQLID_SELECT_ORDER_NEEDS_TRANSFER, baseParam);

        //更新供应商库存和订单状态
        saveTransfer(BSO152404BeanList);
        logger.debug("库存调拨处理成功!");
    }

    /**
     * 保存到供应商库存,并更新订单状态
     *
     * @param BSO152404BeanList
     */
    @Transactional
    private void saveTransfer(List<BSO152404Bean> BSO152404BeanList) {

        List<StockParam> stockParamList = null;

        stockParamList = getStockParamList(BSO152404BeanList);

        logger.debug("更新供应商库存!");
        stockLogic.saveStockOfSupplierList(stockParamList);
        //去除重复数据
        List<BSO152404Param> BSO152404ParamList = new ArrayList<BSO152404Param>();
        BSO152404Param bso152404Param = null;
        for(int i=0;i<BSO152404BeanList.size();i++){
            bso152404Param = new BSO152404Param();
            bso152404Param.setOrderId(BSO152404BeanList.get(i).getOrderId());

            if(!BSO152404ParamList.contains(bso152404Param)){
                BSO152404ParamList.add(bso152404Param);
            }
        }

        saveStatus(BSO152404ParamList);
    }

    /**
     * 获取(设置)更新供应商库存所需要的参数列表
     * @param BSO152404BeanList
     * @return
     */
    private List<StockParam> getStockParamList(List<BSO152404Bean> BSO152404BeanList){
        List<StockParam> stockParamList = new ArrayList<StockParam>();
        for (int i = 0; i < BSO152404BeanList.size(); i++) {
            BSO152404Bean BSO152404Bean = BSO152404BeanList.get(i);
            StockParam stockParam = new StockParam();
            //物流区编号
            stockParam.setLgcsCode(BSO152404Bean.getDistrictCode());
            //仓库编号
            stockParam.setWarehouseCode(StockConst.WarehouseCode.SH_CODE);
            //仓库名称
            stockParam.setWarehouseName(StockConst.WarehouseName.SH_NAME);
            //供货平台
            stockParam.setSupplyPlatform(BSO152404Bean.getOrderSource());
            //库存类别
            stockParam.setStockType(StockConst.StockType.NORMAL_STOCK);
            //卖家编号
            stockParam.setSlCode(BSO152404Bean.getSellerCode());
            //卖家名称
            stockParam.setSlName(BSO152404Bean.getSellerName());
            //供应商编码
            stockParam.setSupplierCode(BSO152404Bean.getSupplierCode());
            //供应商名称
            stockParam.setSupplierName(BSO152404Bean.getSupplierName());
            //产品编号
            stockParam.setPdCode(BSO152404Bean.getPdCode());
            //产品名称
            stockParam.setPdName(BSO152404Bean.getPdName());
            //库存数量
            stockParam.setStockNum(BSO152404Bean.getSuppQty());
            //flowId
            stockParam.setFlowId(BSO152404Bean.getOrderCode());
            //原卖家编码
            //stockParam.setSourceSellerCode(BSO152404Bean.getSourceSellerCode());
            //原卖家名称
            //stockParam.setSourceSellerName(BSO152404Bean.getSourceSellerName());
            //产品类型
            stockParam.setClassesCode(BSO152404Bean.getClassesCode());
            //产品类型名称
            stockParam.setClassesName(BSO152404Bean.getClassesName());
            //产品品种
            stockParam.setBreedCode(BSO152404Bean.getBreedCode());
            //产品品种名称
            stockParam.setBreedName(BSO152404Bean.getBreedName());
            //特征编码
            stockParam.setFeatureCode(BSO152404Bean.getFeatureCode());
            //特征名称
            stockParam.setFeatureName(BSO152404Bean.getFeatureName());
            //产品包装编码
            stockParam.setNormsCode(BSO152404Bean.getNormsCode());
            //产品包装名称
            stockParam.setNormsName(BSO152404Bean.getNormsName());
            //产品等级
            stockParam.setPdLevel(BSO152404Bean.getPdLevel());
            //产品单位
            stockParam.setUnit(BSO152404Bean.getUnit());
            //单箱体积
            stockParam.setPackingVolume(BSO152404Bean.getPackingVolume());
            //重量
            stockParam.setWeight(BSO152404Bean.getWeight());
            //体积
            stockParam.setVolume(BSO152404Bean.getVolume());
            stockParam.setCrtId("batchBSO152404");
            stockParam.setUpdId("batchBSO152404");
            stockParam.setActId("batchBSO152404");
            stockParam.setCrtTime(DateTimeUtil.getCustomerDate());
            stockParam.setUpdTime(DateTimeUtil.getCustomerDate());
            stockParam.setActTime(DateTimeUtil.getCustomerDate());
            stockParamList.add(stockParam);
        }
        return stockParamList;
    }

    /**
     * 更新订单状态为完成(订单主表,订单明细表,订单供货明细信息表)
     * @param BSO152404ParamList
     * @return
     */
    private int saveStatus(List<BSO152404Param> BSO152404ParamList){
        int returnInt = 0;
        for(int i=0; i< BSO152404ParamList.size();i++) {
            BSO152404Param param = BSO152404ParamList.get(i);
            param.setFilter("status", String.valueOf(StatusConst.OrderDetailAvailabilityStatusDef.ALL_RECEIPT));
            param.setUpdTime(DateTimeUtil.getCustomerDate());
            returnInt = super.modify(SqlId.SQLID_MODIFY_DETAIL_AVAILABILITY_STATUS, param);
            if (returnInt > 0) {
                param.setFilter("status", String.valueOf(StatusConst.OrderDetailStatusDef.ALL_RECEIPT));
                returnInt = super.modify(SqlId.SQLID_MODIFY_DETAIL_STATUS, param);
            } else {
                return returnInt;
            }
            if (returnInt > 0) {
                param.setFilter("status", String.valueOf(StatusConst.OrderStatusDef.ALL_RECEIPT));
                returnInt = super.modify(SqlId.SQLID_MODIFY_STATUS, param);
            } else {
                return returnInt;
            }
        }
        return returnInt;
    }
    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhang_lingbo
     */
    public interface SqlId {
        // 获取订单供货明细信息表(订单状态:已确认,订单类型:买手囤货订单,第三方买手囤货订单)
        static final String SQLID_SELECT_ORDER_NEEDS_TRANSFER = "selectOrderNeedsTransfer";
        //更新订单供货明细信息表状态
        static final String SQLID_MODIFY_DETAIL_AVAILABILITY_STATUS = "modifyDetailAvailabilityStatus";
        //更新订单明细表状态
        static final String SQLID_MODIFY_DETAIL_STATUS = "modifyDetailStatus";
        //更新订单主表状态
        static final String SQLID_MODIFY_STATUS = "modifyStatus";
    }
}
