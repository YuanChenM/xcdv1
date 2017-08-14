package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.pl.bean.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170208Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        //新增进货单数据
        static final String SQL_ID_FIND_BS_TASK_MAXID = "findBsTaskMaxId";//获取每日任务最大id
        static final String SQL_ID_FIND_PL_INFO_MAXID = "findPlInfoMaxId";//获取进货单最大id
        static final String SQL_ID_FIND_PL_INFO_ID = "findPlInfoId";//查询合伙人配送站ID
        static final String SQL_ID_FIND_BS_TASK_NUMBER = "findBsTaskNumber";//查询每日任务单是否存在
        static final String SQL_ID_FIND_PL_RULER_INFO = "findPlRulerInfo";//查询合伙人设置的填报次数
        static final String PL_SQL_ID_SAVE_PL_INFO = "savePlInfo";
        static final String PL_SQL_ID_SAVE_BD_TASK_INFO = "saveBsTaskInfo";
        static final String PL_SQL_ID_FIND_ONE_INCENTIVE_FEE_INFO = "findOneIncentiveFee";

        static final String PL_SQL_ID_FIND_ONE_BUYER_EXIST = "findOneBuyerExist";

        //修改进货单数据
        static final String PL_SQL_ID_UPDATE_BS_TASK = "updateBsTaskNumber";
        static final String PL_SQL_ID_UPDATE_PL_INFO = "updatePlInfo";
    }

    /**
     * 进货单新增
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public IPL20170208Result savePlInfo(IPL20170208Param param) {
        IPL20170208Result result = new IPL20170208Result();
        if(StringUtils.isBlank(param.getBuyerId())){
            PLInfo resultOne =  super.findOne(SqlId.PL_SQL_ID_FIND_ONE_BUYER_EXIST,param);
            if(null == resultOne) throw new BusinessException("未查询到当前买家对应信息！");
            param.setBuyerId(resultOne.getBuyerId());
        }

       //查询合伙人,配送站Id
        PLInfo plInfoIdTerPar = this.findId(param.getBsCode());
        if (null == plInfoIdTerPar || StringUtil.isEmpty(plInfoIdTerPar.getTerminalId().toString())||StringUtil.isEmpty(plInfoIdTerPar.getPartnerId().toString())) throw new BusinessException("未查询到当前买手所属配送站或合伙人，请联系合伙人设置对应信息");
        param.setFilter("terminalId", plInfoIdTerPar.getTerminalId().toString());
        param.setFilter("partnerId", plInfoIdTerPar.getPartnerId().toString());
        //获取合伙人设置填报数量
        param.setFilter("startTime", DateTimeUtil.formatDate("yyyy-MM-dd", param.getTaskTime()));
        PLRuler ruler = super.findOne(SqlId.SQL_ID_FIND_PL_RULER_INFO, param);
        if (null == ruler) throw new BusinessException("合伙人未设置填报规则信息，请联系合伙人设置对应信息！");
        //获取最大ID
        PLInfo plInfoId = super.findOne(SqlId.SQL_ID_FIND_PL_INFO_MAXID, param);
        PlBsTask taskId = super.findOne(SqlId.SQL_ID_FIND_BS_TASK_MAXID, param);

        param.setPlId(plInfoId.getPlId());
        param.setFilter("taskId", taskId.getTaskId().toString());
        //查询激励费用
        PLIncentiveFeeSetting feeSetting = super.findOne(SqlId.PL_SQL_ID_FIND_ONE_INCENTIVE_FEE_INFO,param);
        if (null == feeSetting || StringUtil.isEmpty(feeSetting.getIncentiveFee().toString())) throw new BusinessException("合伙人未设置激励费用规则信息，请联系合伙人设置对应信息.");
        param.setFilter("incentiveFee", feeSetting.getIncentiveFee().toString());
        taskId.setNowTime(param.getTaskTime());
        taskId.setNeedRecordNumber(ruler.getStatementNumber());
        taskId.setPartnerId(plInfoIdTerPar.getPartnerId());
        taskId.setBsCode(param.getBsCode());
        taskId.setTerminalId(plInfoIdTerPar.getTerminalId());
        taskId.setDomainId(param.getDomainId());
        taskId.setAlreadyRecordNumber(NumberConst.IntDef.INT_ONE);
        taskId.setStatus(NumberConst.IntDef.INT_ZERO);
        //查询每日填报数量
        PlBsTask number = super.findOne(SqlId.SQL_ID_FIND_BS_TASK_NUMBER, param);
        if(null == number){
            taskId.setAlreadyRecordNumber(NumberConst.IntDef.INT_ZERO);
            taskId.setStatus(NumberConst.IntDef.INT_ZERO);
            super.save(SqlId.PL_SQL_ID_SAVE_BD_TASK_INFO, taskId);
            super.save(SqlId.PL_SQL_ID_SAVE_PL_INFO, param);
            result.setPlId(plInfoId.getPlId());
            return result;
        }else{
            param.setFilter("taskId", number.getTaskId().toString());
            super.save(SqlId.PL_SQL_ID_SAVE_PL_INFO, param);
            result.setPlId(plInfoId.getPlId());
            return result;
        }
       /* if (number != null) {
            number.setAlreadyRecordNumber(number.getAlreadyRecordNumber() + NumberConst.IntDef.INT_ONE);
            if (number.getAlreadyRecordNumber() >= number.getNeedRecordNumber()) {
                number.setStatus(NumberConst.IntDef.INT_ONE);
            }
            number.setVer(number.getVer() + NumberConst.IntDef.INT_ONE);
            param.setFilter("taskId", String.valueOf(number.getTaskId()));
            super.modify(SqlId.PL_SQL_ID_UPDATE_BS_TASK, number);
        } else {
            super.save(SqlId.PL_SQL_ID_SAVE_BD_TASK_INFO, taskId);
        }*/
    }

    /**
     * 进货单修改
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public IPL20170208Result upDatePlInfo(IPL20170208Param param) {
        if (param == null) param = new IPL20170208Param();
        IPL20170208Result result = new IPL20170208Result();
        PLInfo plInfoId = super.findOne(SqlId.SQL_ID_FIND_PL_INFO_MAXID, param);
        param.setVer(plInfoId.getVer() + NumberConst.IntDef.INT_ONE);
         super.modify(SqlId.PL_SQL_ID_UPDATE_PL_INFO, param);
        result.setPlId(param.getPlId());
        return result;
    }

    /**
     * 共通方法查询合伙人,配送站ID
     *
     * @param bsCode
     * @return PLInfo
     */
    public PLInfo findId(String bsCode) {
        BaseParam param = new BaseParam();
        param.setFilter("bsCode", bsCode);
        return super.findOne(SqlId.SQL_ID_FIND_PL_INFO_ID, param);
    }

}
