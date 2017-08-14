package com.msk.batch.so.logic;

import com.msk.batch.so.bean.*;
import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.file.WmsFtpUtils;
import com.msk.core.file.xml.XmlWrite;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * *BSO152408Logic
 * *@author xu_wei
 * *@version 1.0
 */
@Service
public class BSO152408Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152408Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author yuan_chen
     */
    interface SqlId {
        static final String SQLID_FIND_SHIP_LIST = "findShipList";
        static final String SQLID_FIND_ORDER_DETAIL = "findOrderDetailList";
        static final String SQL_ID_MODIFY_SHIP_INFO = "modifyShipInfo";
    }

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
     * 根据订单信息进行分单操作
     *
     * @param bso152408Param param
     */
    @Transactional
    public void findOrderList(BSO152408Param bso152408Param) {
        logger.debug("WMS生成配送单开始");
        bso152408Param.setShipStatus(StatusConst.OrderShipStatusDef.WAIT_WMS);
        List<BSO152408Result> results = super.findList(SqlId.SQLID_FIND_SHIP_LIST, bso152408Param);

        if (!CollectionUtils.isEmpty(results)) {
            for (BSO152408Result result : results) {
                try {
                    createXml(result);
                } catch (Exception e) {
                    logger.error(e.getMessage());
                    continue;
                }
            }
        }
    }

    /**
     * 生成xml并且更新状态为待发货
     *
     * @param bso152408Result bso152408Result
     */
    @Transactional
    private void createXml(BSO152408Result bso152408Result) {
        //要求到货日期
        bso152408Result.setStrForecastReceiveTime(
                DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD,
                        bso152408Result.getForecastReceiveTime()));
        // 计划发货日期
        bso152408Result.setStrForecastSendTime(
                DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD,
                        bso152408Result.getForecastSendTime()));

        // 設置ReceiverInfo
        BSO152408ReceiverInfo receiver = new BSO152408ReceiverInfo();
        receiver.setReceiverName(bso152408Result.getReceiverName());
        receiver.setReceiverTel(bso152408Result.getReceiverTel());
        receiver.setReceiverWeixin(bso152408Result.getReceiverWeixin());
        receiver.setReceiverQq(bso152408Result.getReceiverQq());
        receiver.setReceiverMail(bso152408Result.getReceiverMail());
        receiver.setReceiverProvince(bso152408Result.getReceiverProvince());
        receiver.setReceiverCity(bso152408Result.getReceiverCity());
        receiver.setReceiverDistrict(bso152408Result.getReceiverDistrict());
        receiver.setReceiverAddr(bso152408Result.getReceiverAddr());
        receiver.setReceiverAddr2(bso152408Result.getReceiverAddr2());
        receiver.setReceiverAddrKey(bso152408Result.getReceiverAddrKey());
        if (bso152408Result.getReceiverDeType() == null) {
            receiver.setReceiverDeType("");
        } else {
            receiver.setReceiverDeType(bso152408Result.getReceiverDeType());
        }
        bso152408Result.setReceiver(receiver);

        // 設置产品信息
        BSO152408Param bso152408Param = new BSO152408Param();
        bso152408Param.setShipId(bso152408Result.getShipId());
        List<BSO152408DetailResult> productDetailList = super.findList(SqlId.SQLID_FIND_ORDER_DETAIL, bso152408Param);
        for (BSO152408DetailResult productDetail : productDetailList) {
            productDetail.setDistrictCode(bso152408Result.getDistrictCode());
            productDetail.setSellerCode(bso152408Result.getSellerCode());
            productDetail.setOrderSource(bso152408Result.getOrderSource().toString());
            productDetail.setUnit("CASE");
        }
        bso152408Result.setProductDetailList(productDetailList);

        List<BSO152408Result> xmlList = new ArrayList<BSO152408Result>();
        bso152408Result.setCrtId(null);
        bso152408Result.setCrtTime(null);
        bso152408Result.setUpdId(null);
        bso152408Result.setUpdTime(null);
        if (null != bso152408Result.getPayAmount() && bso152408Result.getPayAmount().compareTo(BigDecimal.ZERO) > NumberConst.IntDef.INT_ZERO) {
            bso152408Result.setPaymentType(NumberConst.IntDef.INT_THREE);
        }
        xmlList.add(bso152408Result);
        BSO152408XMLTemplate xmlTemplate = new BSO152408XMLTemplate();
        xmlTemplate.setData(xmlList);

        XmlWrite<BSO152408Result> xmlWrite = new XmlWrite<BSO152408Result>(xmlTemplate);
        InputStream inputStream = xmlWrite.createListTemplateXml(BSO152408XMLTemplate.class);
        boolean result = WmsFtpUtils.uploadXml("/", "SO" + bso152408Result.getOrderCode() + ".xml", inputStream);
        if (logger.isDebugEnabled()) {
            if (result) {
                logger.debug(bso152408Result.getOrderCode() + ".xml" + "文件上传成功");
                // 更新发货状态 待发货
                this.modify(SqlId.SQL_ID_MODIFY_SHIP_INFO, bso152408Result);
            } else {
                logger.debug(bso152408Result.getOrderCode() + ".xml" + "文件上传失败");
            }
        }
    }
}
