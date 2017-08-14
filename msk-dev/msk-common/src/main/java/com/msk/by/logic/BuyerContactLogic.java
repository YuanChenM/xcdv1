package com.msk.by.logic;

import java.util.ArrayList;
import java.util.List;

import com.msk.core.entity.ByBuyerBasicInfo;
import com.msk.core.entity.ByBuyerEmployee;
import com.msk.core.entity.ByBuyerRecAddr;
import com.msk.core.entity.ByBuyerRecTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.by.bean.BuyerContactInfo;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;

/**
 * *买家联系信息
 * *@author yuan_chen
 * *@version 1.0
 **/
@Service
public class BuyerContactLogic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BuyerContactLogic.class);

    /**
     * SqlId
     */
    interface SqlId {
        String SQL_ID_findBuyerContactInfo = "findBuyerContactInfo";
        String SQL_ID_findBuyerContactTel = "findBuyerContactTel";
        String SQL_ID_findBuyerContactAddr = "findBuyerContactAddr";
        String SQL_ID_findBuyerContactTime = "findBuyerContactTime";
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
     * 通过指定买家ID取得买家联系信息
     *
     * @param buyerId 买家ID
     * @return
     */
    public List<BuyerContactInfo> findBuyerContactInfo(String buyerId) {
        BaseParam param = new BaseParam();
        param.getFilterMap().put("companyId", buyerId);
        return this.findBuyerContactInfo(param);
    }

    /**
     * 取得全部买家联系信息
     *
     * @return
     */
    public List<BuyerContactInfo> findBuyerContactInfo() {
        BaseParam param = new BaseParam();
        return this.findBuyerContactInfo(param);
    }

    /**
     * 取得买家联系信息
     *
     * @return
     */
    private List<BuyerContactInfo> findBuyerContactInfo(BaseParam param) {
        logger.info("取得买家联系信息");

        List<BuyerContactInfo> resultList = super.findList(SqlId.SQL_ID_findBuyerContactInfo,param);
        for (BuyerContactInfo basicInfo : resultList) {
            BaseParam param1 = new BaseParam();
            param1.getFilterMap().put("companyId", basicInfo.getCompanyId());
            List<ByBuyerEmployee> employees = super.findList(SqlId.SQL_ID_findBuyerContactTel,param1);
            List<ByBuyerRecAddr> recAddrs = super.findList(SqlId.SQL_ID_findBuyerContactAddr,param1);
            List<ByBuyerRecTime> recTimes = super.findList(SqlId.SQL_ID_findBuyerContactTime,param1);

            basicInfo.setByBuyerEmployees(employees);
            basicInfo.setByBuyerRecAddrs(recAddrs);
            basicInfo.setByBuyerRecTimes(recTimes);
        }
        return resultList;
    }
}
