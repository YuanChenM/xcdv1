package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.datasource.DatabaseContextHolder;
import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoOrderRelation;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.ISO151433RsParam;
import com.msk.so.bean.ISO151433RsResult;
import com.msk.so.bean.ModifyStatusParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by sunjiaju on 2016/7/14.
 */
@Service
public class ISO151433Logic extends BaseLogic {
    private static Logger logger = LoggerFactory.getLogger(ISO151433Logic.class);

    @Autowired
    private OrderStatusLogic orderStatusLogic;
    /**
     * 订单发货取消回传logic
     * @param param
     * @return
     */
    @Transactional
    public ISO151433RsResult cancelShipment(ISO151433RsParam param){
        logger.info("开始更新各表状态！");
        Date cancelTime = DateTimeUtil.parseDate(param.getCancelTime(),DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS);
        if (cancelTime == null){
            throw new BusinessException("取消时间传入格式错误！");
        }
        // 更新订单发货主表
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        int count = super.modify(param);
        if (NumberConst.IntDef.INT_ONE != count) {
            throw new BusinessException("根据传入参数查询不到取消中的发货单数据！");
        }
        // 更新订单供货明细信息表
        super.modify(SqlId.SQL_ID_MODIFY_AVAILABILITY, param);
        // 更新订单明细表
        super.modify(SqlId.SQL_ID_MODIFY_DETAIL, param);
        ISO151433RsResult result = super.findOne(param);
        ModifyStatusParam modifyStatusParam = new ModifyStatusParam();
        modifyStatusParam.setOrderId(result.getOrderId());
        modifyStatusParam.setUpdId(param.getUpdId());
        orderStatusLogic.modifyOrderStatusByOrderId(modifyStatusParam);
        return result;
    }

    interface SqlId{
        String SQL_ID_MODIFY_AVAILABILITY = "modifyAvailability";
        String SQL_ID_MODIFY_DETAIL = "modifyDetail";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
