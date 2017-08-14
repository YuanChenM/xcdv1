package com.msk.pl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pl.bean.*;
import com.msk.pl.util.beanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.list.PredicatedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tao_zhifa on 2017/4/17.
 */
@Service
public class IPL20170408Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    @Autowired
    private CommonLogic commonLogic;
    interface SqlId {
        static final String SQL_ID_select_Price_Period_Mst_By_New_Date = "selectPricePeriodMstByNewDate";
        static final String SQL_ID_SELECT_PRICE_PERIOD_MST_BY_PPID = "selectPricePeriodMstByPpId";
        static final String SQL_ID_SELECT_PERIODS = "selectPeriods";
        static final String SQL_ID_SELECT_DECLARE_INFO = "selectDeclareInfo";
        static final String SQL_ID_SELECT_PL_DOMAIN_BS = "selectPlDomainBs";
        static final String SQL_ID_SELECT_PL_TERMINAL_PARTNER = "selectPlTerminalPartner";
    }

    @Transactional(readOnly = true)
    public PlDeclarePriceperiodMst selectPricePeriodMstByNewDate(IPL20170408Param ipl20170408Param){
        PlDeclarePriceperiodMst plDeclarePriceperiodMst = findOne(SqlId.SQL_ID_select_Price_Period_Mst_By_New_Date,ipl20170408Param);
        return plDeclarePriceperiodMst;
    }

    @Transactional(readOnly = true)
    public PlDeclarePriceperiodMst selectPricePeriodMstByPpId(IPL20170408Param ipl20170408Param){
        PlDeclarePriceperiodMst plDeclarePriceperiodMst = findOne(SqlId.SQL_ID_SELECT_PRICE_PERIOD_MST_BY_PPID,ipl20170408Param);
        return plDeclarePriceperiodMst;
    }
    @Transactional(readOnly = true)
    public PlDeclareTask  selectPeriods(PlDeclarePriceperiodMst plDeclarePriceperiodMst,IPL20170408Param ipl20170408Param){
        PlDeclareTask param = new PlDeclareTask();
        param.setBsCode(ipl20170408Param.getBsCode());
        param.setPpId(plDeclarePriceperiodMst.getPpId());
        PlDeclareTask plDeclareTask = findOne(SqlId.SQL_ID_SELECT_PERIODS,param);
        return plDeclareTask;
    }

    @Transactional
    public PlDeclareTask saveDeclareTask( PlDeclarePriceperiodMst plDeclarePriceperiodMst,RsRequest<IPL20170408Param> ipl20170408Param){
        PlTerminalPartnerResult partnerResult = findOne(SqlId.SQL_ID_SELECT_PL_DOMAIN_BS,ipl20170408Param.getParam());
        PlDeclareTask plDeclareTask = beanUtils.toBean(plDeclarePriceperiodMst,PlDeclareTask.class);
        plDeclareTask.setDtId(commonLogic.maxId("PL_DECLARE_TASK", "DT_ID"));
        plDeclareTask.setPartnerId(partnerResult.getPartnerId());
        plDeclareTask.setBsName(partnerResult.getBsName());
        plDeclareTask.setDomainId(partnerResult.getDomainId());
        plDeclareTask.setTerminalId(partnerResult.getTerminalId());
        plDeclareTask.setDtDate(plDeclarePriceperiodMst.getCrtTime());
        plDeclareTask.setBsCode(ipl20170408Param.getParam().getBsCode());
        plDeclareTask.setCrtId(ipl20170408Param.getLoginId());
        plDeclareTask.setCrtTime(DateTimeUtil.getCustomerDate());
        plDeclareTask.setUpdId(ipl20170408Param.getLoginId());
        plDeclareTask.setUpdTime(DateTimeUtil.getCustomerDate());
        plDeclareTask.setActId(ipl20170408Param.getLoginId());
        plDeclareTask.setActTime(DateTimeUtil.getCustomerDate());
        save(plDeclareTask);
        return plDeclareTask;
    }

    /**
     *
     * @param param
     * @return
     * 查询master数据
     */
    @Transactional(readOnly = true)
    public List<PlPdMst> findMstAll(IPL20170408Param param) {
        List<PlPdMst> plPdMst = super.findList(param);
        return plPdMst;
    }


    /**
     *
     * @param
     * @return
     * 查询master数据
     */
    @Transactional
    public void savePlDeclareInfo(List<PlPdMst> plPdMstList, PlDeclareTask plDeclareTask,RsRequest<IPL20170408Param> rsRequest) {
        List<PlDeclareInfo> plDeclareInfoList = new ArrayList<>();
        Long maxId = commonLogic.maxId("PL_DECLARE_INFO", "DT_DETAIL_ID");
        for(PlPdMst param : plPdMstList){
            PlDeclareInfo declareInfo = new PlDeclareInfo();
            declareInfo.setBsCode(plDeclareTask.getBsCode());
            declareInfo.setDtId(plDeclareTask.getDtId());
            declareInfo.setPdId(param.getPdId());
            int declareInfoCount = getCount(SqlId.SQL_ID_SELECT_DECLARE_INFO,declareInfo);
            if(declareInfoCount != NumberConst.IntDef.INT_ZERO){
                continue;
            }
            PlDeclareInfo plDeclareInfo = beanUtils.toBean(param,PlDeclareInfo.class);
            plDeclareInfo.setDtDetailId(maxId);
            plDeclareInfo.setBsCode(plDeclareTask.getBsCode());
            plDeclareInfo.setBsName(plDeclareTask.getBsName());
            plDeclareInfo.setDtId(plDeclareTask.getDtId());
            plDeclareInfo.setPartnerId(plDeclareTask.getPartnerId());
            plDeclareInfo.setLgcsCode(plDeclareTask.getLgcsCode());
            plDeclareInfo.setLgcsName(plDeclareTask.getLgcsName());
            plDeclareInfo.setTerminalId(plDeclareTask.getTerminalId());
            plDeclareInfo.setDomainId(plDeclareTask.getDomainId());
            plDeclareInfo.setCrtId(rsRequest.getLoginId());
            plDeclareInfo.setCrtTime(DateTimeUtil.getCustomerDate());
            plDeclareInfo.setUpdId(rsRequest.getLoginId());
            plDeclareInfo.setUpdTime(DateTimeUtil.getCustomerDate());
            plDeclareInfo.setActId(rsRequest.getLoginId());
            plDeclareInfo.setActTime(DateTimeUtil.getCustomerDate());
            plDeclareInfoList.add(plDeclareInfo);
            maxId ++;
        }
        if(!CollectionUtils.isEmpty(plDeclareInfoList)){
            super.batchSave(plDeclareInfoList);
        }
    }

}
