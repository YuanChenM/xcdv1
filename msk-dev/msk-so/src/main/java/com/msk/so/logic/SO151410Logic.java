package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.core.entity.SoOrderRelation;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.*;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunjiaju
 * @version 创建时间：20160713
 */
@Service
public class SO151410Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SO151410Logic.class);

    /**
     * SqlId. 方法名
     *
     */
    interface SqlId {
        String SQL_ID_FIND_ORDER_SHIP_INFO = "findOrderShipInfo";
        String SQL_ID_FIND_ORDER_DETAIL_AVAILABILITY_INFO = "findSoOrderDetailAvailability";
        String SQL_ID_MODIFY_AVAILABILITY = "modifyAvailability";
        String SQL_ID_MODIFY_DETAIL = "modifyDetail";
        String SQL_ID_FIND_RELATION = "findRelation";
        String SQL_ID_FIND_ORDER_SHIP_INFO_BY_CHILD_ID = "findOrderShipInfoByChildId";
    }

    /**
     * 发货单详细
     *
     * @param orderId
     * @return 发货单详细
     */
    @Transactional(readOnly = true)
    public List<SO151410Bean> findOrderShipInfo(String orderId) {
        logger.debug("发货单详细查询");
        BaseParam param = new BaseParam();
        param.setFilter("orderId", orderId);
        List<SO151410Bean> so151410Beans = null;
        // 查询订单关联表
        SoOrderRelation sor = super.findOne(SqlId.SQL_ID_FIND_RELATION, param);
        if (sor == null){
           so151410Beans = super.findList(SqlId.SQL_ID_FIND_ORDER_SHIP_INFO, param);
        } else {
            so151410Beans = super.findList(SqlId.SQL_ID_FIND_ORDER_SHIP_INFO_BY_CHILD_ID, param);
        }
       if (CollectionUtils.isNotEmpty(so151410Beans)){
        for (SO151410Bean so151410Bean : so151410Beans) {
            param.setFilter("shipId", StringUtil.toString(so151410Bean.getShipId()));
            List<SoOrderDetailAvailability> soOrderDetailAvailabilities = super.findList(
                    SqlId.SQL_ID_FIND_ORDER_DETAIL_AVAILABILITY_INFO, param);
            so151410Bean.setSoOrderDetailAvailabilities(soOrderDetailAvailabilities);
        }
       }
        return so151410Beans;
    }

    /**
     * 发货单取消
     *
     * @param param
     */
    @Transactional
    public void cancel(SO151410Param param) {
        logger.debug("发货单取消");
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        // 更新订单发货主表
        super.modify(param);
        // 更新订单供货明细信息表
        super.modify(SqlId.SQL_ID_MODIFY_AVAILABILITY, param);
        // 更新订单明细表
        super.modify(SqlId.SQL_ID_MODIFY_DETAIL, param);
    }
}
