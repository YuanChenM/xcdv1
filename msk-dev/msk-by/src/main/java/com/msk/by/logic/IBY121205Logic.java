package com.msk.by.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.ByBuyerLicence;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * IBY121205Logic.
 *
 * @author zhou_yajun
 */
@Service
public class IBY121205Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121205Logic.class);

    @Autowired
    private CommonLogic commonLogic;
    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_yajun
     */
    interface SqlId {
        //买家证照信息获取
        static String SQL_FIND_LINECE = "findLinece";
        //买家证照信息更新
        static String SQL_BUYER_LINECE_MODIFY = "buyerLineceModify";
        //买家证照信息插入
        static String SQL_BUYER_LINECE_INSERT = "buyerLineceInsert";
    }
    /**
     * (non-Javadoc)
     *
     * @see BaseLogic#setBaseDao(BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 买家证照信息更新接口
     * @param param
     * @return
     */
    @Transactional
    public int buyerLicenceModify(ByBuyerLicence param){
        //根据传入参数获取买家证照信息
        BaseParam inParam = new BaseParam();
        inParam.setFilter("buyerId", param.getBuyerId());
        inParam.setFilter("delFlg","0");
        ByBuyerLicence licence = super.findOne(SqlId.SQL_FIND_LINECE, inParam);
        //获取到数据则更新表
        if(null != licence){
            param.setId(licence.getId());
            param.setUpdTime(DateTimeUtil.getCustomerDate());
            return super.modify(SqlId.SQL_BUYER_LINECE_MODIFY,param);
        }else {
            //未获取到数据则插入表
            return buyerLicenceSave(param);
        }
    }
    /**
     * 买家证照信息插入
     * @param insertParam
     * @return
     */
    @Transactional
    public int  buyerLicenceSave(ByBuyerLicence insertParam){
        Long id = commonLogic.maxId("by_buyer_Licence","ID");
        insertParam.setId(id);
        insertParam.setCrtId(insertParam.getUpdId());
        insertParam.setCrtTime(DateTimeUtil.getCustomerDate());
        insertParam.setUpdTime(DateTimeUtil.getCustomerDate());
        insertParam.setActId(insertParam.getUpdId());
        insertParam.setActTime(DateTimeUtil.getCustomerDate());
        insertParam.setUpdTime(DateTimeUtil.getCustomerDate());
        return super.save(SqlId.SQL_BUYER_LINECE_INSERT,insertParam);
    }

    /**
     * 获取买家证照信息
     * @param insertParam
     * @return
     */
    public ByBuyerLicence buyerLicenceFind(ByBuyerLicence insertParam){
        //根据传入参数获取买家证照信息
        BaseParam inParam = new BaseParam();
        inParam.setFilter("buyerId", insertParam.getBuyerId());
        inParam.setFilter("delFlg","0");
        ByBuyerLicence licence = super.findOne(SqlId.SQL_FIND_LINECE, inParam);
        return licence;
    }
}
