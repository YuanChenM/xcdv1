package com.msk.pl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pl.bean.IPL20170213RsParam;
import com.msk.pl.bean.IPL20170213RsResult;
import com.msk.pl.bean.IPL20170214RsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by gyh on 2017/2/6.
 */
@Service
public class IPL20170213Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    @Autowired
    private CommonLogic commonLogic;
    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_MODIFY_DATE = "modifyDate";
    }
    /**
     * 检查生效日期是否小于等于上次填报设置
     * @param plRuler 参数
     * @return 结果
     */
    public boolean checkEffectiveTime(IPL20170213RsParam plRuler){
        IPL20170214RsParam param=new IPL20170214RsParam();
        param.setPartnerId(plRuler.getPartnerId());
        //如果设置日期小于当天时间提示：生效日期必须大于等于当前日期
        String nowDate = DateTimeUtil.formatDate("yyyy-MM-dd", new Date());
        if (plRuler.getEffectiveDate().getTime() < DateTimeUtil.parseDate(nowDate, "yyyy-MM-dd").getTime()) {
            return false;
        }
        //删除大于等于当前时间并且小于等于要设置的时间的数据
        this.modify(SqlId.SQL_ID_MODIFY_DATE, plRuler);
        IPL20170213RsResult rsResult=this.findOne(param);
        if(rsResult!=null){
            rsResult.setUpdId(plRuler.getCrtId());
            rsResult.setVer(rsResult.getVer()+1);
            rsResult.setOverTime(plRuler.getEffectiveDate());
            this.modify(rsResult);
        }
        return true;
    }

    /**
     * 合伙人填报设置保存
     * @param plRuler 参数
     * @return 结果
     */
    public int savePlRuler(IPL20170213RsParam plRuler){
        plRuler.setStatementId(commonLogic.maxId("PL_RULER", "STATEMENT_ID"));
        return this.save(plRuler);
    }

    /**
     * 前次合伙人填报设置查询接口
     * @param param 参数
     * @return 结果
     */
    public IPL20170213RsResult partnerRulerQuery(IPL20170214RsParam param){
        return this.findOne(param);
    }
}
