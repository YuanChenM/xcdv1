package com.msk.so.logic;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.msk.core.entity.SoStockSupp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.OrderStatusParam;

/**
 * OrderDetailStatusLogic
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service
public class OrderDetailStatusLogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderDetailStatusLogic.class);
    
    /**
     * SQL Map 中SQL ID定义
     * 
     * @author zhou_ling
     */
    interface SqlId {
        String SQLID_GET_CODE_AVAILABILITY = "getCodeAvailabilityCanel";
        String SQLID_GET_CODE_DETAIL = "getCodeDetailCanel";
        String SQL_ID_MODIFY_DETAIL_STATUS = "modifyDetailStatus";
        String SQL_ID_MODIFY_STATUS = "modifyStatus";
        String SQL_ID_FIND_ORDER_STATUS_BY_ORDER_ID = "findOrderStatusByOrderId";
        String SQL_ID_SAVE_STATUS_BY_ORDER_DETAIL = "saveStatusByOrderDetail";
        String SQL_ID_MODIFY_DETAIL_STATUS_BY_ORDER_ID="modifyStatusByOrderId";
    }

    /**
     * 更新状态
     * @param orderDetailId 订单明细ID
     * @param status 状态
     * @param updId 更新ID
     * @param updTime 更新时间
     */
    @Transactional
    public void modifyStatus(Long orderDetailId,Integer status,String updId,Date updTime) {
        logger.info("更新订单明细状态");
        BaseParam baseParam = new BaseParam();
        Map<String,Object> filterMap = baseParam.getFilterMap();
        filterMap.put("orderDetailId",orderDetailId);
        filterMap.put("status",status);
        filterMap.put("updId",updId);
        filterMap.put("updTime",updTime);
        super.modify(baseParam);
    }

    /**
     * 根据订单ID更新订单明细表中的状态和新增订单明细状态表中数据.
     * 这种更新只有在全部收货,全部取消,新增订单时候才容许调用改方法
     * @param orderId 订单编号
     * @param oldStatus 订单明细本次状态
     * @param newStatus 订单明细新状态
     * @param updId 更新者
     * @param updTime 更新时间
     */
    @Transactional
    public void modifyStatus(Long orderId,Integer oldStatus,Integer newStatus,String updId,Date updTime){
        //更新主表状态
        BaseParam orderDetailParam = new BaseParam();
        Map<String,Object> filterMap = orderDetailParam.getFilterMap();
        filterMap.put("orderId",orderId);
        filterMap.put("oldStatus",oldStatus);
        filterMap.put("status",newStatus);
        filterMap.put("updId",updId);
        filterMap.put("updTime",updTime);
        super.modify(SqlId.SQL_ID_MODIFY_DETAIL_STATUS,orderDetailParam);
        //更新明细状态
        BaseParam statusParam = new BaseParam();
        statusParam.setFilter("orderId",String.valueOf(orderId));
        statusParam.setFilter("status",String.valueOf(oldStatus));
        statusParam.setFilter("updId",updId);
        statusParam.setFilterObject("updTime",updTime);
        List<Map<String,Object>> statusListMap = this.getBaseDao().getSqlSession().selectList(getSqlId(SqlId.SQL_ID_FIND_ORDER_STATUS_BY_ORDER_ID),statusParam);
        if(!CollectionUtils.isEmpty(statusListMap)){
            //更新订单明细状态表
            super.modify(SqlId.SQL_ID_MODIFY_DETAIL_STATUS_BY_ORDER_ID,statusParam);
        }
        filterMap.put("crtId",updId);
        filterMap.put("crtTime", DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD,updTime));
        //新增明细状态
        super.save(SqlId.SQL_ID_SAVE_STATUS_BY_ORDER_DETAIL,orderDetailParam);

    }
    
    /**
     * 查询物流区编码，卖家编码，产品编码
     * 
     * @param orderStatusParam orderStatusParam
     * 
     * @return 物流区编码，卖家编码，产品编码
     */
    @Transactional(readOnly = true)
    public List<SoStockSupp> getCodeDetailCanel(OrderStatusParam orderStatusParam) {
        logger.debug("获得物流区编码,卖家编码,产品编码");
        List<SoStockSupp> suppStockList = super.findList(SqlId.SQLID_GET_CODE_DETAIL, orderStatusParam);
        return suppStockList;
    }
    /**
     * 查询物流区编码，卖家编码，产品编码
     * 
     * @param orderStatusParam orderStatusParam
     * 
     * @return 物流区编码，卖家编码，产品编码
     */
    @Transactional(readOnly = true)
    public List<SoStockSupp> getCodeAvailabilityCanel(OrderStatusParam orderStatusParam) {
        logger.debug("获得物流区编码,卖家编码,产品编码");
        List<SoStockSupp> suppStockList = super.findList(SqlId.SQLID_GET_CODE_AVAILABILITY, orderStatusParam);
        return suppStockList;
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
