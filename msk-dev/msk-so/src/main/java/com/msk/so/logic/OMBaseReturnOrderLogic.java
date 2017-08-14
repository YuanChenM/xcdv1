package com.msk.so.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.so.bean.BaseReturnOrder;

/**
 * 根据退货订单 OMBaseReturnOrder
 * 
 * @author hyx
 */
@Service
public class OMBaseReturnOrderLogic extends BaseLogic {

    /**
     * 
     * SqlId. 定义方法名
     *
     * @author xhy
     */
    interface SqlId {
        String SQL_ID_FIND_ONE_RETURN_ORDER_VALUE = "findOneReturnOrder";
    }

    /**
     * 根据id查询退货订单基本数据
     * 
     * @return BaseReturnOrderBean
     * @author hyx
     */

    public BaseReturnOrder getBaseReturnOrder() {
        BaseReturnOrder bean = new BaseReturnOrder();

        bean.setReturnCode("010-10111010110101-12");
        // 退货单编码
        bean.setOrderCode("001-10111010110101-12");
        // 需求订单编码
        bean.setReturnSource("神农客平台");
        // 退货单来源
        bean.setReturnMode("全退");
        // 退货方式
        bean.setRefundMode("部分退");
        // 退款方式
        bean.setReturnAmount("100.00");
        // 退款总金额
        bean.setIsInvoice("是");
        // 是否开票
        bean.setIsPaid("是");
        // 是否付款
        bean.setReturnActor("南江");
        // 退货处理人
        bean.setReturnStatus("未完成");
        // 退货单状态
        bean.setReturnTime("2016-1-4 18:12:29"); // 退货时间
        bean.setReturnReasonCode("保质期过期");
        // 退货原因
        bean.setReturnGoodsAllMoney("收到货物的时候,有10箱保质期刚好过期了!");
        // 退货原因描述

        return bean;
    }

    /**
     * 根据id查询退货订单基本数据
     * 
     * @param returnOrderId 订单id
     * @return BaseReturnOrderBean
     * @author hyx
     */
    @Transactional(readOnly = true)
    public BaseReturnOrder findoMBaseReturnOrder(String returnOrderId) {
        BaseParam param = new BaseParam();
        param.setFilter("returnId", returnOrderId);
        return super.findOne(SqlId.SQL_ID_FIND_ONE_RETURN_ORDER_VALUE, param);

    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
