/**
 * IMS112101Logic.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.MsCardmanager;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.ms.bean.IMS112101RsParam;
import com.msk.ms.bean.IMS112101RsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * IMS112101Logic.
 * 会员卡发放
 * @author rwf
 */
@Service
public class IMS112101Logic extends BaseLogic {
    /**
     * SqlId.
     * 
     * @author rwf
     */
    interface SqlId {
        static final String SQL_ID_UPDATE_MS_CARDMANAGER = "updateMsCardmanger";
        static final String SQL_ID_SEARCH_BUYER_CODE_IF_EXIST="searchUserIdIfExist";
    }

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IMS112101Logic.class);

    /** 获取当前时间 */
    Date nowDate = DateTimeUtil.getCustomerDate();

    /**
     * @return IMS112101RsResult 返回
     * @param param RsRequest<IMS112101RsParam>
     * 
     */
    @Transactional(readOnly = false,
        propagation = Propagation.REQUIRED,
        rollbackFor = Exception.class)
    public IMS112101RsResult findOneRecord(RsRequest<IMS112101RsParam> param) {
        logger.debug("查询一条没有发放的会员卡");
        IMS112101RsResult ims112101RsResult = new IMS112101RsResult();
        //用户传入的userID为会员卡 MSCode
        ims112101RsResult.setMSCode(StringUtil.toSafeString(param.getParam().getUserID()));
        BaseParam bp = new BaseParam();
        bp.setFilter("userId",StringUtil.toSafeString(param.getParam().getUserID()));
        //先查询该用户是否已经拥有会员卡
        MsCardmanager ms = super.findOne(SqlId.SQL_ID_SEARCH_BUYER_CODE_IF_EXIST,bp);
        if(null!=ms){
            throw new BusinessException("已经拥有会员卡卡号:"+ms.getMsCardno());
        }else{
            // 查询一个没有发放的会员卡 返回值中存放id/cardNO/Msnowpw等信息
            MsCardmanager msCardmanager = super.findOne(bp);
            if (null != msCardmanager) {
                ims112101RsResult.setMSCardNo(msCardmanager.getMsCardno());
                ims112101RsResult.setMSCardPassword(msCardmanager.getMsNowpw());
                msCardmanager.setBuyerCode(param.getParam().getUserID());
                msCardmanager.setMsCode(param.getParam().getUserID());
                msCardmanager.setBuyerName(param.getParam().getUserName());
                msCardmanager.setProvideDate(nowDate);
                msCardmanager.setIsProvide("1");
                // 会员卡发放后更新表操作
                super.modify(SqlId.SQL_ID_UPDATE_MS_CARDMANAGER, msCardmanager);
            }else{
                throw new BusinessException("抱歉!会员卡已经全部发放");
            }
        }
        return ims112101RsResult;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
