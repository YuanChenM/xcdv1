package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pl.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by xuhongyang on 2017/2/6.
 * 任务单列表查询
 */
@Service
public class IPL20170202Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        static final String SQL_ID_FIND_PL_INFO_ID = "findPlInfoId";//查询合伙人配送站ID
        static final String SQL_ID_FIND_NUMBER_DAY = "findPlRulerInfo";//查询合伙人设置的天数
    }

    /**
     * 每日任务单列表查询
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<IPL20170202Result> findTaskList(IPL20170202Param param) {


        //返回数据
        List<IPL20170202Result> thisObjectReturn = new ArrayList<IPL20170202Result>();
        List<IPL20170202Result> sqlresult = super.findList(param);
        Map<String, IPL20170202Result> mapDay = new HashMap<String, IPL20170202Result>();
        if (sqlresult == null) return null; //todu
        //不为空
        for (IPL20170202Result objectOne : sqlresult) {
            mapDay.put(objectOne.getReportDate().split("-")[2].toString(), objectOne);
        }


        //查询合伙人id
        PLInfo plInfoIdTerPar = this.findId(param.getBsCode());
        if (null == plInfoIdTerPar) throw new BusinessException("未查询到当前买手所属配送站或合伙人，请联系合伙人设置对应信息！");
        param.setFilter("terminalId", plInfoIdTerPar.getTerminalId().toString());
        param.setFilter("partnerId", plInfoIdTerPar.getPartnerId().toString());

        //查询合伙人设置的补报天数
        PLRuler ruler = super.findOne(SqlId.SQL_ID_FIND_NUMBER_DAY, param);
        if (null == ruler) throw new BusinessException("合伙人未设置填报规则信息，请联系合伙人设置对应信息！");

        //查询买手注册年月日
        PlDomainBs domainBs = super.findOne(param);
        if (null == domainBs) throw new BusinessException("买手注册时间异常，请联系管理员！");
        String nowDay = DateTimeUtil.formatDate("yyyy-MM", param.getNowMonth());//当前传入时间 月份

        //当前传入月份最大的天数时间
        Date monthLastDate = this.getMonthLastDay(param.getNowMonth());
        //当前时间
        Date nowDate = new Date();
        //获取循环次数
        int runNumbber = nowDate.getTime() >= monthLastDate.getTime() ? this.getDayNumber(monthLastDate):this.getDayNumber(nowDate);
        for (int i = 1; i <= runNumbber; i++) {
            String thisS = numberString(i);
           /* 1.无需填报*/
            if(DateTimeUtil.parseDate((DateTimeUtil.formatDate("yyyy-MM-dd", domainBs.getCrtTime())),"yyyy-MM-dd").getTime() > DateTimeUtil.parseDate(nowDay+"-"+ thisS,"yyyy-MM-dd").getTime()){
                IPL20170202Result resultOne = new IPL20170202Result();
                resultOne.setReportDate(nowDay + "-" + thisS);
                resultOne.setStatus(NumberConst.IntDef.INT_TWO);
                resultOne.setBsCode(param.getBsCode());
                thisObjectReturn.add(resultOne);
            }else if(mapDay.containsKey(thisS)&&mapDay.get(thisS).getStatus()==1){
                thisObjectReturn.add(mapDay.get(thisS));
            }else if(i >= runNumbber - ruler.getRepayDay() && i <= runNumbber ){
                //补报天数内
                if(mapDay.containsKey(thisS)){
                    mapDay.get(thisS).setStatus(NumberConst.IntDef.INT_THREE);
                    thisObjectReturn.add(mapDay.get(thisS));
                }else {
                    IPL20170202Result resultOne = new IPL20170202Result();
                    resultOne.setReportDate(nowDay + "-" + thisS);
                    resultOne.setStatus(NumberConst.IntDef.INT_THREE);
                    resultOne.setBsCode(param.getBsCode());
                    thisObjectReturn.add(resultOne);
                }
            }else{
                IPL20170202Result resultOne = new IPL20170202Result();
                resultOne.setReportDate(nowDay + "-" + thisS);
                resultOne.setStatus(NumberConst.IntDef.INT_ZERO);
                resultOne.setBsCode(param.getBsCode());
                thisObjectReturn.add(resultOne);
            }

        }
        return thisObjectReturn;
    }

    /**
     * 截取字符串
     *
     * @param date
     * @return
     */
    public static int getDayNumber(Date date) {
        return Integer.valueOf(DateTimeUtil.formatDate("yyyy-MM-dd", date).split("-")[NumberConst.IntDef.INT_TWO]);
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

    /**
     * 获取字符串数字
     *
     * @param number
     * @return
     */
    public String numberString(int number) {
        return number <= 9 && number >= NumberConst.IntDef.INT_ONE ? "0" + number : number + "";
    }

    /**
     * 当前月份的最后一天
     */
    public Date getMonthLastDay(Date date) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.add(Calendar.MONTH, 1);
        now.set(Calendar.DATE,0);
        return now.getTime();
    }


}
