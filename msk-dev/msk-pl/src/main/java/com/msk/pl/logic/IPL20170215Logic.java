package com.msk.pl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pl.bean.IPL20170215Param;
import com.msk.pl.bean.IPL20170215RsResult;
import com.msk.pl.bean.IPL20170216RsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by gyh on 2017/2/7.
 */
@Service
public class IPL20170215Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_MODIFY_DATE = "modifyDate";
    }

    @Autowired
    private CommonLogic commonLogic;

    /**
     * 检查生效日期是否小于等于上次激励费用设置
     *
     * @param feeSetting 参数
     * @return 结果
     */
    public boolean checkFeeSetting(IPL20170215Param feeSetting) {
        IPL20170216RsParam param = new IPL20170216RsParam();
        param.setPartnerId(feeSetting.getPartnerId());
        //如果设置日期小于当天时间提示：生效日期必须大于等于当前日期
        String nowDate = DateTimeUtil.formatDate("yyyy-MM-dd", new Date());
        if (feeSetting.getEffectiveDate().getTime() < DateTimeUtil.parseDate(nowDate, "yyyy-MM-dd").getTime()) {
            return false;
        }
        //删除大于等于当前时间并且小于等于要设置的时间的数据
        this.modify(SqlId.SQL_ID_MODIFY_DATE, feeSetting);
        IPL20170215RsResult rsResult = this.findOne(param);
        if (rsResult != null) {
            rsResult.setUpdId(feeSetting.getCrtId());
            rsResult.setVer(rsResult.getVer() + 1);
            rsResult.setOverTime(feeSetting.getEffectiveDate());
            this.modify(rsResult);
        }
        return true;
    }

    /**
     * 合伙人激励费用设置保存
     *
     * @param feeSetting 参数
     * @return 结果
     */
    public int savePLIncentiveFeeSetting(IPL20170215Param feeSetting) {
        feeSetting.setIncentiveFeeId(commonLogic.maxId("PL_INCENTIVE_FEE_SETTING", "INCENTIVE_FEE_ID"));
        return this.save(feeSetting);
    }

    /**
     * 前次合伙人填报设置查询接口
     *
     * @param param 参数
     * @return 结果
     */
    public IPL20170215RsResult incentiveFeeSettingQuery(IPL20170216RsParam param) {
        return this.findOne(param);
    }
}
