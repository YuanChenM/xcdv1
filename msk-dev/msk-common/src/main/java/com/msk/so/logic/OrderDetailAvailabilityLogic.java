package com.msk.so.logic;


import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * OrderDetailAvailability
 *
 * @author zhou_yajun
 * @version 1.0
 **/
public class OrderDetailAvailabilityLogic extends BaseLogic {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(OrderDetailAvailabilityLogic.class);
    /**
     * SQL Map 中SQL ID定义
     * 
     * @author zhou_yajun
     */
    interface SqlId {
        String SQLID_GET_ORDER_DETAIl_AVAILABILITY = "orderDetailAvailabilityList";
        String SQL_ID_MODIFY_ORDER_DETAIL_AVAILABILITY ="modifyOrderDetailAvailability";
    }

    /**
     * 更新订单供货明细信息
     * @param orderDetailAvailability 订单供货明细信息
     * @return 影响的行数
     */
    public int modifyOrderDetailAvailability(SoOrderDetailAvailability orderDetailAvailability){
        return super.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL_AVAILABILITY,orderDetailAvailability);
    }




    /**
     * 
     * 订单明细供货表信息取得
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<SoOrderDetailAvailability> getOrderDetailAvailabilityList(BaseParam param){
        logger.info("订单明细供货表信息取得");
        return super.findList(SqlId.SQLID_GET_ORDER_DETAIl_AVAILABILITY,param);
    }

    /**
     * 订单明细供货表状态变更
     * @param id 主键
     * @param status 状态值
     * @param updId 更新着
     * @param updTime 更新时间
     */
    @Transactional
    public void modifyOrderDetailAvailabilityStatus(Long id,Integer status,String updId,Date updTime){
        logger.info("订单明细供货表状态变更");
        BaseParam param = new BaseParam();
        Map<String,Object> filterMap = param.getFilterMap();
        filterMap.put("id",id);
        filterMap.put("status",status);
        filterMap.put("updId",updId);
        filterMap.put("updTime",updTime);
        super.modify(param);
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 根据订单详细信息取得订单明细供货信息
     * @param orderDetail SoOrderDetail
     * @return SoOrderDetailAvailability
     */
    public SoOrderDetailAvailability getEntity(SoOrderDetail orderDetail){
        logger.info("根据订单详细信息取得订单明细供货信息");
        SoOrderDetailAvailability availability = new SoOrderDetailAvailability();
        //BeanUtils.copyProperties(orderDetail, availability);
        availability.setOrderId((long)orderDetail.getOrderId());
        availability.setOrderCode(orderDetail.getOrderCode());
        availability.setOrderDetailId((long) orderDetail.getOrderDetailId());
        availability.setClassesCode(orderDetail.getClassesCode());
        availability.setClassesName(orderDetail.getClassesName());
        availability.setBreedCode(orderDetail.getBreedCode());
        availability.setBreedName(orderDetail.getBreedName());
        availability.setFeatureCode(orderDetail.getFeatureCode());
        availability.setFeatureName(orderDetail.getFeatureName());
        availability.setNormsCode(orderDetail.getNormsCode());
        availability.setNormsName(orderDetail.getNormsName());
        availability.setPdCode(orderDetail.getPdCode());
        availability.setPdName(orderDetail.getPdName());
        availability.setUnit(orderDetail.getUnit());
        availability.setPackingVolume(orderDetail.getPackingVolume());
        availability.setWeight(orderDetail.getWeight());
        availability.setVolume(orderDetail.getVolume());
        availability.setSuppQty(orderDetail.getOrderQty());
        if (orderDetail.getSendQty() == null){
            availability.setSendQty(BigDecimal.ZERO);
        }else {
            availability.setSendQty(orderDetail.getSendQty());
        }
        if(orderDetail.getReceiveQty() == null){
            availability.setReceiveQty(BigDecimal.ZERO);
        }else{
            availability.setReceiveQty(orderDetail.getReceiveQty());
        }
        if(orderDetail.getCancelQty() == null){
            availability.setCancelQty(BigDecimal.ZERO);
        }else{
            availability.setCancelQty(orderDetail.getCancelQty());
        }
        if(orderDetail.getReturnQty() == null){
            availability.setReturnQty(BigDecimal.ZERO);
        }else{
            availability.setReturnQty(orderDetail.getReturnQty());
        }
        availability.setRejectionQty(DecimalUtil.subtract(availability.getSendQty(), availability.getReceiveQty()));
        availability.setDelFlg("0");
        availability.setCrtId("batchBSO152402");
        availability.setCrtTime(DateTimeUtil.getCustomerDate());
        availability.setUpdId("batchBSO152402");
        availability.setUpdTime(DateTimeUtil.getCustomerDate());
        availability.setActId("batchBSO152402");
        availability.setActTime(DateTimeUtil.getCustomerDate());
        availability.setVer(1);
        //return super.save(availability);
        return availability;
    }
}
