package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.MdLogisticsArea;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pd.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 首页产品楼层接口
 * Created by 任强 2016/11/04.
 */
@Service
public class IPD141151Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * SQL Map 中SQL ID定义
     *
     * @author xhy
     */
    interface SqlId {
        static final String SQL_ID_SELECT_FLOOR_PRO_DETAIL = "selectFloorProDetail";
        static final String SQL_ID_GET_USEFUL_PRICE_CYCLE_CODE = "getUsefulPriceCycleCode";//获取有效价盘周期
        static final String SQL_ID_GET_LATEST_PRICE_CYCLE_CODE = "getLatestPriceCycleCode";//获取最近有效价盘周期

    }

    @Transactional(readOnly = true)
    public  List<IPD141151Bean> findPdFloorList(IPD141151Param param){
        //param.setPaging(true);
        List<IPD141151Bean> list = new ArrayList<>();
        list = this.findPageList(param,IPD141151Bean.class);
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("pricePeriod",param.getPricePeriod());
        baseParam.setFilterObject("floorList",list);
        if(!CollectionUtils.isEmpty(list)){
            List<IPD141151Bean>  pros = this.findList(SqlId.SQL_ID_SELECT_FLOOR_PRO_DETAIL,baseParam);
            if(!CollectionUtils.isEmpty(list)){

                for(IPD141151Bean bean:list){
                    List<IPD14115102Bean> ipd14115102BeanList = new ArrayList<>();
                    for(IPD141151Bean bean1:pros){
                        if(bean.getFloorId().longValue()==bean1.getFloorId().longValue()){
                            IPD14115102Bean ipd14115102Bean = new IPD14115102Bean();
                            ipd14115102Bean.setAdvertisePrice(bean1.getAdvertisePrice());
                            ipd14115102Bean.setBreedName(bean1.getBreedName());
                            ipd14115102Bean.setPdLabel(bean1.getPdLabel());
                            ipd14115102Bean.setCoverImg(bean1.getCoverImg());
                            ipd14115102Bean.setPdCode(bean1.getPdCode());
                            ipd14115102Bean.setBreedCode(bean1.getBreedCode());
                            ipd14115102Bean.setFeatureCode(bean1.getFeatureCode());
                            ipd14115102Bean.setFeatureName(bean1.getFeatureName());
                            ipd14115102Bean.setWeightCode(bean1.getWeightCode());
                            ipd14115102Bean.setWeightName(bean1.getWeightName());
                            ipd14115102Bean.setGradeName(bean1.getGradeName());
                            ipd14115102Bean.setGradeCode(bean1.getGradeCode());
                            ipd14115102BeanList.add(ipd14115102Bean);
                        }
                    }
                    bean.setProducts(ipd14115102BeanList);
                }
            }
        }

        return  list;
    }

    /**
     * 获取有效价盘周期的列表
     * @return
     */
    @Transactional(readOnly = true)
    public List<IPD14115103Bean> getPriceUsefulCycleCode(){
        IPD141151Param param = new IPD141151Param();
        Date newDate = DateTimeUtil.getCustomerDate();
        param.setActTime(newDate);
        return this.findList(SqlId.SQL_ID_GET_USEFUL_PRICE_CYCLE_CODE,param);
    }

    /**
     * 获取有效价盘周期的列表
     * @return
     */
    @Transactional(readOnly = true)
    public List<IPD14115103Bean> getPriceLatestCycleCode(){
        IPD141151Param param = new IPD141151Param();
        return this.findList(SqlId.SQL_ID_GET_LATEST_PRICE_CYCLE_CODE,param);
    }

}
