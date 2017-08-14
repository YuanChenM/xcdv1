package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.SO15140701Bean;
import com.msk.so.bean.SO1514070402Bean;
import com.msk.so.bean.SO15140704Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * 退货订单明细
 * OM141102 Logic
 *
 * @author xhy
 * @version 1.0
 */
@Service
public class SO151407Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SqlId. 创建方法名
     *
     * @author xhy
     */
    interface SqlId {
        /**
         * 订单主
         */
        String SQL_ID_FIND_LIST_RETURN_ORDER = "findReturnOrderListByReturnId";
        String SQL_FIND_LIST_ORDER_DATEIL = "findOrderDateilList";
        String SQL_FIND_LIST_GOODS_DATEIL = "findGoodsDateilList";
        String SQL_MODIFY_ONE_RETURN_DATEIL_ONE = "modifyReturnDetail";
    }

    /**
     * 订单产品明细列表 DB(数据库查询)
     *
     * @param orderId 根据返回订单id 查询数据
     * @return List 返回list集合
     * @author xhy
     */
    @Transactional(readOnly = true)
    public SO1514070402Bean findOM14110704ListAll(String orderId) {
        // 获取订单列表
        BaseParam param = new BaseParam();
        param.setFilter("orderId", orderId);
        // 总金额

        BigDecimal allB = new BigDecimal("0");
        List<SO15140704Bean> list = super.findList(SqlId.SQL_ID_FIND_LIST_RETURN_ORDER, param);
        for (SO15140704Bean so25110704Bean : list) {
            BigDecimal pdPrice = so25110704Bean.getPdPrice();
            BigDecimal orderQty = so25110704Bean.getOrderQty();
            BigDecimal multiply = pdPrice.multiply(orderQty);
            allB = allB.add(multiply);
            String allMoney = multiply.toString();
            so25110704Bean.setOneAllMoney(allMoney.substring(IntDef.INT_ZERO, allMoney.length() - IntDef.INT_THREE));
            BaseParam paramDateil = new BaseParam();
            paramDateil.setFilter("orderId", orderId);
            paramDateil.setFilter("orderDetailId", so25110704Bean.getOrderDetailId().toString());
            List<SoOrderDetailAvailability> detailList = super.findList(SqlId.SQL_FIND_LIST_ORDER_DATEIL, paramDateil);
            so25110704Bean.setOrderDetail(detailList);
        }
        SO1514070402Bean bean = new SO1514070402Bean();
        BigDecimal s = new BigDecimal(0);
        int i = s.compareTo(allB);
        if (i == 0) {
            bean.setAllB("0");
        } else {
            bean.setAllB(allB.toString().substring(IntDef.INT_ZERO, allB.toString().length() - IntDef.INT_TWO));
        }

        bean.setList(list);
        return bean;
    }

    /**
     * 退货产品明细列表 DB(数据库查询)
     *
     * @param returnId 使用退货单id查询列表
     * @return List 返回list集合
     * @author xhy
     */
    @Transactional(readOnly = true)
    public List<SO15140701Bean> findOM14110704ListGoods(String returnId) {
        // 获取退货单列表
        BaseParam param = new BaseParam();
        param.setFilter("returnId", returnId);
        List<SO15140701Bean> list = super.findList(SqlId.SQL_FIND_LIST_GOODS_DATEIL, param);
        return list;
    }

    /**
     * 修改退货供应商的商品数量
     *
     * @param returnDetailId 退货明细id
     * @param returnQty      退货数量
     * @author xhy
     */
    @Transactional(readOnly = false)
    public int updateDetailQty(String returnDetailId, BigDecimal returnQty, String updId) {
        BaseParam param = new BaseParam();
        param.setFilter("returnDetailId", returnDetailId);
        param.setFilter("returnQty", returnQty.toString());
        param.setUpdId(updId);
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        return super.modify(SqlId.SQL_MODIFY_ONE_RETURN_DATEIL_ONE, param);


    }
}
