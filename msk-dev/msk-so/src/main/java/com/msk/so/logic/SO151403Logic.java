package com.msk.so.logic;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SoOrderDetailAvailability;

/**
 * OM141102 Logic
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service
public class SO151403Logic extends BaseLogic {
    @Autowired
    private SO151402Logic SO151402Logic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SqlId. 方法名
     *
     * @author Administrator
     */
    interface SqlId {
        String SQL_ID_UPDATE_ORDER_DETAIL_AVAILABILITY_INFO = "updateSoOrderDetailAvailability";
        String SQL_ID_FIND_ORDER_DETAIL_AVAILABILITY_INFO = "findSoOrderDetailAvailability";
    }
    /**
     *
     * 设置订单修改显示的界面假数据
     * 
     * @return SO25110201Bean
     * @author rwf
     */
    public SoOrderDetailAvailability getDetailAvailability() {
        // 设置修改界面的假数据
        SoOrderDetailAvailability SoOrderDetailAvailability = new SoOrderDetailAvailability();
        SoOrderDetailAvailability.setOrderId(1l);
        SoOrderDetailAvailability.setOrderDetailAvailabilityId(1l);
        SoOrderDetailAvailability.setSupplierCode("101020003");
        SoOrderDetailAvailability.setSupplierName("上海市黄浦区公司");
        SoOrderDetailAvailability.setSuppQty(new BigDecimal("50"));
        SoOrderDetailAvailability.setSendQty(new BigDecimal("50"));
        SoOrderDetailAvailability.setReceiveQty(new BigDecimal("40"));// 发货数量
        SoOrderDetailAvailability.setCancelQty(new BigDecimal("0"));// 取消数量
        SoOrderDetailAvailability.setReturnQty(new BigDecimal("10"));
        return SoOrderDetailAvailability;
    }

    /**
     * 根据订单明细供应商ID查询信息
     * 
     * @param orderDetailAvailabilityId 查询条件
     * @return SoOrderDetailAvailability
     * @author xhy
     * update gyh
     * updateTime 2016.1.6
     */
    public SoOrderDetailAvailability findOneAvailability(String orderDetailAvailabilityId) {
        BaseParam param = new BaseParam();
        param.setFilter("orderDetailAvailabilityId", orderDetailAvailabilityId);
        return SO151402Logic.findOne(SqlId.SQL_ID_FIND_ORDER_DETAIL_AVAILABILITY_INFO, param);
    }

    /**
     * 修改订单明细供应商信息
     * 
     * @param soOrderDetailAvailability 修改参数
     * @return int 结果
     * @author xhy
     * update gyh
     * updateTime 2016.1.6
     */
    @Transactional(readOnly=false)
    public int modifyOrder(SoOrderDetailAvailability soOrderDetailAvailability) {
        return super.modify(SqlId.SQL_ID_UPDATE_ORDER_DETAIL_AVAILABILITY_INFO, soOrderDetailAvailability);
    }
}
