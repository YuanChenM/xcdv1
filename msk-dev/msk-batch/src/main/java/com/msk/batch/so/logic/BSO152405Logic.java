package com.msk.batch.so.logic;


import com.msk.batch.so.bean.BSO152405DetailResult;
import com.msk.batch.so.bean.BSO152405Param;
import com.msk.batch.so.bean.BSO152405Result;
import com.msk.batch.so.bean.BSO152405XMLTemplate;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrderShip;
import com.msk.core.entity.SoReturnStatus;
import com.msk.core.file.WmsFtpUtils;
import com.msk.core.file.xml.XmlWrite;
import com.msk.core.utils.DateTimeUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by wang_shuai on 2016/4/8.
 */
@Service
public class BSO152405Logic extends BaseLogic{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152405Logic.class);

    @Autowired
    private CommonLogic commonLogic;
    /**
     * sqlId
     */
    interface SqlId{
        static final String SQLID_FIND_RETURN_LIST = "findReturnList";
        static final String SQLID_FIND_RETURN_DETAIL_LIST  = "findReturnDetailList";
        static final String SQLID_UPDATE_RETURN_STATUS = "updateReturnStatus";
        static final String SQLID_UPDATE_RETURN_DETAIL_STATUS = "updateReturnDetailStatus";
        static final String SQL_ID_SAVE_SO_RETURN_STATUS = "saveSoReturnStatus";
        //Add by wang_jianzhou for bug#3809 at 2016/11/28 Start.
        static final String SQL_ID_FIND_SHIP_IDS = "findShipIds";
        static final String SQL_ID_FIND_SHIP_ID = "findShipId";
        //Add by wang_jianzhou for bug#3809 at 2016/11/28 end.
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
     * 退货入库单batch
     * @param bso152405Param param
     */
    @Transactional
    public void findReturnList(BSO152405Param bso152405Param){
        logger.debug("退货入库单batch开始");
        bso152405Param.setFilterObject("waitProcessStatus", StatusConst.SoReturnStatusDef.WAIT_PROCESS);
        bso152405Param.setFilterObject("lateReceiptStatus", StatusConst.SoReturnStatusDef.LATE_RECEIPT);
        List<BSO152405Result> bso152405Results = super.findList(SqlId.SQLID_FIND_RETURN_LIST,bso152405Param);
        if(CollectionUtils.isNotEmpty(bso152405Results)){
            for (BSO152405Result bso152405Result : bso152405Results){
                //Add by wang_jianzhou for bug#3809 at 2016/11/28 Start.
                bso152405Result.setShipId(getShipIds(bso152405Result));
                //Add by wang_jianzhou for bug#3809 at 2016/11/28 end.
                insertXml(bso152405Result);
            }
        }
    }
    /**
     * 更新状态，生成退货入库单xml
     * @param bso152405Result
     */
    @Transactional
    public void insertXml(BSO152405Result bso152405Result){
        BSO152405Param param = new BSO152405Param();
        param.setReturnId(bso152405Result.getReturnId());
        List<BSO152405DetailResult> returnDetailList = super.findList(SqlId.SQLID_FIND_RETURN_DETAIL_LIST,param);
        bso152405Result.setReturnDetailList(returnDetailList);
        // 更新退货单明细表
        updateReturnDetailStatus(bso152405Result);
        // 更新退货单主表
        updateReturnStatus(bso152405Result);
        List<BSO152405Result> bos152405ResultList = new ArrayList<BSO152405Result>();
        bso152405Result.setVer(bso152405Result.getVer()+1);
        bos152405ResultList.add(bso152405Result);
        // writeXML
        BSO152405XMLTemplate xmlTemplate = new BSO152405XMLTemplate();
        xmlTemplate.setData(bos152405ResultList);

        XmlWrite<BSO152405Result> xmlWrite = new XmlWrite<BSO152405Result>(xmlTemplate);
        InputStream inputStream = xmlWrite.createListTemplateXml(BSO152405XMLTemplate.class);
        boolean result = WmsFtpUtils.uploadXml("/","RE" + bso152405Result.getReturnId() + "-" + bso152405Result.getReturnCode() + ".xml",inputStream);
        if (logger.isDebugEnabled()) {
            if (result) {
                logger.debug("RE" + bso152405Result.getReturnId() + "-" + bso152405Result.getReturnCode() + ".xml" + "文件上传成功");
            } else {
                logger.debug("RE" + bso152405Result.getReturnId() + "-" + bso152405Result.getReturnCode() + ".xml" + "文件上传失败");
            }
        }
    }

    /**
     * 更新退货单状态
     *
     * @param bso152405Result bso152405Result
     */
    @Transactional
    private void updateReturnStatus(BSO152405Result bso152405Result) {
        logger.debug("更新退货单状态");
        // 更新退货单状态
        BSO152405Param bso152405Param = new BSO152405Param();
        bso152405Param.setReturnId(bso152405Result.getReturnId());
        bso152405Param.setReturnStatus(StatusConst.SoReturnStatusDef.PROCESS);
        bso152405Param.setUpdTime(DateTimeUtil.getCustomerDate());
        bso152405Param.setUpdId("admin");
        super.modify(SqlId.SQLID_UPDATE_RETURN_STATUS,bso152405Param);
        // 插入退货单状态表
        SoReturnStatus soReturnStatus = new SoReturnStatus();
        Long statusId = commonLogic.maxId("SO_RETURN_STATUS", "STATUS_ID");
        soReturnStatus.setStatusId(statusId);
        soReturnStatus.setReturnId(bso152405Result.getReturnId());
        soReturnStatus.setReturnCode(bso152405Result.getReturnCode());
        soReturnStatus.setReturnStatus(StatusConst.SoReturnStatusDef.PROCESS);
        soReturnStatus.setCrtId("admin");
        soReturnStatus.setCrtTime(DateTimeUtil.getCustomerDate());
        super.save(SqlId.SQL_ID_SAVE_SO_RETURN_STATUS, soReturnStatus);
    }

    /**
     * 更新退货单明细状态
     *
     * @param bso152405Result bso152405Result
     */
    @Transactional
    private int updateReturnDetailStatus(BSO152405Result bso152405Result){
        logger.debug("更新退货单明细状态");
        BSO152405Param bso152405Param = new BSO152405Param();
        bso152405Param.setReturnId(bso152405Result.getReturnId());
        bso152405Param.setReturnStatus(StatusConst.SoReturnStatusDef.PROCESS);
        bso152405Param.setUpdTime(DateTimeUtil.getCustomerDate());
        bso152405Param.setUpdId("admin");
        return super.modify(SqlId.SQLID_UPDATE_RETURN_DETAIL_STATUS,bso152405Param);
    }


    //Add by wang_jianzhou for bug#3809 at 2016/11/28 Start.
    /**
     * 根据订单ID查询SHIPID
     *
     * @param bso152405Result bso152405Result
     */
    @Transactional
    private String getShipIds(BSO152405Result bso152405Result){

        BaseParam param = new BaseParam();
        param.setFilterObject("orderId",bso152405Result.getOrderId());
        param.setFilterObject("returnId",bso152405Result.getReturnId());
        List<SoOrderShip> soOrderShips = new ArrayList<SoOrderShip>();
        String shipId = "";

        if(bso152405Result.getReturnType().equals(OrderConst.ReturnType.REJECT)){
            //现场退货对应单一SHIPID
            SoOrderShip soOrderShip = super.findOne(SqlId.SQL_ID_FIND_SHIP_ID,param);
            soOrderShips.add(soOrderShip);
        }else {
            //其他退货对应多个SHIPID
            param.setFilterObject("status1",StatusConst.OrderShipStatusDef.ALL_RECEIPT);
            param.setFilterObject("status2",StatusConst.OrderShipStatusDef.ALL_RETURN);
            soOrderShips = super.findList(SqlId.SQL_ID_FIND_SHIP_IDS,param);
        }

        if(CollectionUtils.isNotEmpty(soOrderShips)){
            for(SoOrderShip soOrderShip : soOrderShips) {
                if(null != soOrderShip && null != soOrderShip.getShipId()){
                    shipId += soOrderShip.getShipId() + ",";
                }
            }
        }

        if(shipId.length() > NumberConst.IntDef.INT_ZERO){
            shipId = shipId.substring(0,shipId.length()-1);
        }

        return shipId;
    }

    //Add by wang_jianzhou for bug#3809 at 2016/11/28 end.
}
