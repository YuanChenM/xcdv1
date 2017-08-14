package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.exception.BusinessException;
import com.msk.so.bean.ISO151434RsParam;
import com.msk.so.bean.ISO151434RsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jiang_tengfei on 2016/5/23.
 */
@Service
public class ISO151434Logic extends BaseLogic {
    private static Logger logger = LoggerFactory.getLogger(ISO151434Logic.class);

    /**
     * 查询本月上半月分销量
     * @param param
     * @return
     */
    public List<ISO151434RsResult> findAll(RsRequest<ISO151434RsParam> param){
        logger.info("");
        ISO151434RsParam iso151434RsParam = param.getParam();

        //将传入本月参数转换成 01 和 15日
        SimpleDateFormat sdfThisMonth = new SimpleDateFormat("yyyyMM");
        Date date = null;
        try {
            date = sdfThisMonth.parse(iso151434RsParam.getThisMonth());
        } catch (ParseException e) {
            throw new BusinessException("本月字段格式不正确！");
        }
        //转换成yyyy-MM 格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String formatDate = sdf.format(date);

        //拼接成01 和 15日
        String thisMonth01 = formatDate + "-01 00:00:00";
        String thisMonth15 = formatDate + "-15 23:59:59";

        iso151434RsParam.setThisMonth01(thisMonth01);
        iso151434RsParam.setThisMonth15(thisMonth15);

        List<ISO151434RsResult> iso151434RsResultList = super.findList(SqlId.SQL_ID_FIND_HALF_MONTH_COUNT, iso151434RsParam);

        if (!CollectionUtils.isEmpty(iso151434RsResultList)){
            return iso151434RsResultList;
        }else{
            throw new BusinessException("本月上半月分销量没有数据！");
        }
    }

    interface SqlId{
        String SQL_ID_FIND_HALF_MONTH_COUNT = "findHalfMonthCount";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
