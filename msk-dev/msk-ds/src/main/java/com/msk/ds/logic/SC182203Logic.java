package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.*;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import com.msk.ds.bean.SC182203Bean;
/**
 * SC182203Logic.
 *
 * @author yi_qixiang
 * @version 1.0
 **/
@Service
public class SC182203Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC182203Logic.class);
    /**
     * SQL Map 中SQL ID定义
     *
     * @author pxg
     */
    private interface SqlId {
        String SQL_ID_FIND_MONTH = "findMonth";
        String SQL_GET_SUPP = "getSupp";  // 实际
        String SQL_GET_LGCS = "getLgcs";  // 实际
        String SQL_GET_PRODUCT_LOT_LIST = "getProductLotList";  // 实际
    }
    /**
     * 根据供应商Code获得月度
     * @param supCode 供应商编码
     * @return 月度信息
     */
    @Transactional
    public List<String> findMonth(String supCode){
        BaseParam param = new BaseParam();
        param.setFilter("supCode",supCode);
        return super.getBaseDao().getSqlSession().selectList(SqlId.SQL_ID_FIND_MONTH);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }



    /**
     * 根据用户账户查到供应商
     *
     * @return suppName
     */
    @Transactional
    public SC182203Bean getSupp(SC182203Param sc182203Param) {

        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("slAccount", sc182203Param.getSlAccount());

        List<SC182203Bean> slEnterpriseList = new ArrayList<SC182203Bean>();
        slEnterpriseList = this.findList(SqlId.SQL_GET_SUPP, sc182203Param);
        if(slEnterpriseList.size()>0){
            return slEnterpriseList.get(0);
        }else{
            return null;
        }

    }





}
