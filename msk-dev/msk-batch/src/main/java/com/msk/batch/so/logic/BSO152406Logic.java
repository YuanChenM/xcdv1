package com.msk.batch.so.logic;

import com.msk.batch.so.bean.BSO152406Param;
import com.msk.batch.so.bean.BSO152406Result;
import com.msk.batch.so.bean.BSO152406XMLTemplate;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.file.WmsFtpUtils;
import com.msk.core.file.xml.XmlWrite;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.logic.OrderLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * *BSO152406Logic
 * *@author sunjiaju
 * *@version 1.0
 **/
@Service
public class BSO152406Logic extends BaseLogic{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152406Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     */
    interface SqlId {
        static final String SQLID_FIND_SHIP_LIST = "findShipList";
    }
    
    @Autowired
    private OrderLogic orderLogic;
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
     * 根据订单发货主表操作
     *
     * @param bso152406Param param
     */
    @Transactional
    public void cancelShip(BSO152406Param bso152406Param) {
        logger.debug("发货单取消");
        List<BSO152406Result> bso152406Results = super.findList(SqlId.SQLID_FIND_SHIP_LIST, bso152406Param);
        if(!CollectionUtils.isEmpty(bso152406Results)) {
            for (BSO152406Result bso152406Result : bso152406Results) {
                    createXml(bso152406Result);
            }
        }
    }

    /**
     * 生成xml并且更新状态
     *
     * @param bso152406Result bso152406Result
     */
    @Transactional
    private void createXml(BSO152406Result bso152406Result){
        BSO152406Param param = new BSO152406Param();
        param.setShipId(bso152406Result.getShipId());
        // 更新订单发货主表
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        super.modify(param);

        BSO152406XMLTemplate xmlTemplate = new BSO152406XMLTemplate();
        xmlTemplate.setData(bso152406Result);

        XmlWrite<BSO152406Result> xmlWrite = new XmlWrite<BSO152406Result>(xmlTemplate);
        InputStream inputStream = xmlWrite.createEntityTemplateXml(BSO152406XMLTemplate.class);
        boolean result = WmsFtpUtils.uploadXml("/","OC" + bso152406Result.getShipCode() + ".xml",inputStream);
        if (logger.isDebugEnabled()) {
            if (result) {
                logger.debug("OC" + bso152406Result.getShipCode() + ".xml" + "文件上传成功");
            } else {
                logger.debug("OC" + bso152406Result.getShipCode() + ".xml" + "文件上传失败");
            }
        }
    }
}
