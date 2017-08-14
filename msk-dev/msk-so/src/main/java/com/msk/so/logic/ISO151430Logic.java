package com.msk.so.logic;

import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.*;

import com.msk.so.bean.rs.PdStock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存查询接口
 *
 * @author zhang_qiang1
 */
@Service
public class ISO151430Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151430Logic.class);


    /**
     *
     * @param param
     * @return
     */
    public ISO151430RsResult queryUsedStock(ISO151430RsParam param){
        Map<String,Object>map=this.fillPar(param);
        logger.debug("为了保证数据的完整性，统一查询时间");

        ISO151430RsResult rsResult=this.getRsResult(map);
        return  rsResult;
    }


    /**
     *
     * @param map
     * @return
     */
    public ISO151430RsResult getRsResult(Map<String,Object>map){
        ISO151430RsResult rsResult=new ISO151430RsResult();
         List<PdStock>productStockList= this.getBaseDao().getSqlSession().selectList(SqlId.SQL_ID_FIND_PRODUCT_STOCK,map);
        if(productStockList!=null&&productStockList.size()>0){
            for(PdStock pdStock :productStockList){
                if(!map.containsKey("pdCode")){
                    map.put("pdCode",pdStock.getPdCode());
                }
                BigDecimal  orderStock=this.getOrderStock(map);
                pdStock.setOrderStock(orderStock==null?new BigDecimal(0.00):orderStock);
                BigDecimal returnStock =this.getReturnOrderInStock(map);
                pdStock.setReturnStock(returnStock==null?new BigDecimal(0.00):returnStock);
                map.remove("pdCode");
            }
        }
            rsResult.setPdStockList(productStockList);


        return  rsResult;
    }


    /**
     *如果不指定 pdcode  那么 orderStock 就是 卖家在物流区  入库的总和
     * @param map
     * @return
     */
    public BigDecimal getReturnOrderInStock(Map<String,Object>map){
        map.put("state", StatusConst.SoReturnStatusDef.STORAGE);// 退货入库的状态
        BigDecimal  returnStock= this.getBaseDao().getSqlSession().selectOne(SqlId.SQL_ID_FIND_RETURN_STOCK,map);
        return  returnStock;
    }


    /**
     *  如果不指定 pdcode  那么 orderStock 就是 卖家在物流区  已发货的总和     后期应该是  已发货 商品 明细
     * @param map
     * @return
     */

    public BigDecimal getOrderStock(Map<String,Object>map){
        map.put("orderState",StatusConst.OrderStatusDef.CANCEL);// 订单取消的状态
        map.put("confirm",StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);// 订单供货商  已确认
        map.put("wait_send",StatusConst.OrderDetailAvailabilityStatusDef.WAIT_SEND);// 订单供货商
        BigDecimal  orderStock= this.getBaseDao().getSqlSession().selectOne(SqlId.SQL_ID_FIND_ORDR_STOCK,map);
        return  orderStock;
    }


    /**
     *
     * @param returnStock
     * @param orderStock
     * @param productStockList
     * @return
     */
    public BigDecimal getUsedSumStock(BigDecimal returnStock ,BigDecimal orderStock,  List<PdStock>productStockList){
        BigDecimal sumStock=new BigDecimal(0);
        for(PdStock pdStock:productStockList){

            sumStock.add(pdStock.getStockQty());
        }
        sumStock.add(returnStock).subtract(orderStock);
        return  sumStock;
    }


    /*
     * @param param  把前台参数  封装到map 中
     * @return
     */
   public Map<String,Object> fillPar(ISO151430RsParam param){
       Map<String,Object>map=new HashMap<>();
       map.put("slCode",param.getSlCode());
       map.put("lgcsCode",param.getLgcsCode());
       if(param.getPdCode()!=null&&!"".equals(param.getPdCode())){
           map.put("pdCode",param.getPdCode()) ;
       }
       map.put("pdName",param.getPdName()) ;
       map.put("warehoseCode",param.getWarehoseCode()) ;
       map.put("classesCode",param.getClassesCode()) ;
       map.put("breedCode",param.getBreedCode()) ;
       map.put("classesName",param.getClassesName()) ;
       map.put("breedName",param.getBreedName()) ;
       map.put("startTime",null);// 开始时间
       DateTimeUtil.getCustomerDate();
       map.put("endTime",null);// 结束时间
       return map;
   }


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SqlId. sql定义
     *
     * @author zhang_qiang1
     */
    interface SqlId {
        String SQL_ID_FIND_PRODUCT_STOCK = "findProductStock";

        String SQL_ID_FIND_ORDR_STOCK="findOrderStock";

        String SQL_ID_FIND_RETURN_STOCK="findReturnStock";
    }



    public  static void main(String []args){

    }
}
