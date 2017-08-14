package com.msk.so.logic;

import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoComplain;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.ISO151420RsParam;
import com.msk.so.bean.ISO151420RsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 投诉提交ISO151420Logic.
 *
 * @author sjj
 */
@Service
public class ISO151420Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151420Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    /**
     * 投诉提交
     *
     * @param param param
     * @return 返回结果
     * @author sjj
     */
    public ISO151420RsResult complainOrder(ISO151420RsParam param) {
        logger.info("投诉提交logic");
        Date complainDate = DateTimeUtil.parseDate(param.getComplainDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS);
        if (complainDate == null) {
            throw new BusinessException("投诉时间传入格式错误！");
        }
        SoComplain soComplain = super.findOne(param);
        if (soComplain != null) {
            Long maxId = this.commonLogic.maxId("so_complain", "COMPLAIN_ID");
            soComplain.setComplainId(maxId);
            soComplain.setComplainCode(soComplain.getComplainCode() + "-" + maxId);
            soComplain.setComplainDate(complainDate);
            soComplain.setComplainStatus(StatusConst.OrderComplainStatusDef.COMPLAINING);
            soComplain.setCrtTime(DateTimeUtil.getCustomerDate());
        } else {
            throw new BusinessException("根据订单ID查询不到订单数据！");
        }
        Integer count = super.save(soComplain);
        if (count <= NumberConst.IntDef.INT_ZERO) {
            return null;
        }
        ISO151420RsResult result = new ISO151420RsResult();
        result.setComplainId(soComplain.getComplainId());
        result.setComplainCode(soComplain.getComplainCode());
        result.setOrderId(soComplain.getOrderId());
        return result;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
