package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.DS173203Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * zhou_yajun on 2016/1/28.
 */
@Service
public class DS173203Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC183102Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public PageResult<DS173203Param> findPageList(){
        PageResult<DS173203Param> pageResultList=new PageResult<DS173203Param>();
        List<DS173203Param> list=new ArrayList<DS173203Param>();
        DS173203Param dS173203Param1 = new DS173203Param();
        DS173203Param dS173203Param2 = new DS173203Param();
        DS173203Param dS173203Param3 = new DS173203Param();
        DS173203Param dS173203Param4 = new DS173203Param();
        dS173203Param1.setProductName("鸡产品");
        dS173203Param1.setProductCode("003");
        dS173203Param1.setProductTypeName("鸡腿");
        dS173203Param1.setProductFeature("01");
        dS173203Param1.setProductLevel("03");
        dS173203Param1.setNetWeight(new BigDecimal(10.0));
        dS173203Param1.setPackageCode("000");
        dS173203Param1.setProductSpecifical("11");
        dS173203Param2.setProductName("鸡产品");
        dS173203Param2.setProductCode("003");
        dS173203Param2.setProductTypeName("鸡头");
        dS173203Param2.setProductFeature("01");
        dS173203Param2.setProductLevel("03");
        dS173203Param2.setNetWeight(new BigDecimal(10.0));
        dS173203Param2.setPackageCode("000");
        dS173203Param2.setProductSpecifical("11");
        dS173203Param3.setProductName("鸭产品");
        dS173203Param3.setProductCode("003");
        dS173203Param3.setProductTypeName("鸭头");
        dS173203Param3.setProductFeature("01");
        dS173203Param3.setProductLevel("03");
        dS173203Param3.setNetWeight(new BigDecimal(10.0));
        dS173203Param3.setPackageCode("000");
        dS173203Param3.setProductSpecifical("11");
        dS173203Param4.setProductName("鸭产品");
        dS173203Param4.setProductCode("003");
        dS173203Param4.setProductTypeName("鸭腿");
        dS173203Param4.setProductFeature("01");
        dS173203Param4.setProductLevel("03");
        dS173203Param4.setNetWeight(new BigDecimal(10.0));
        dS173203Param4.setPackageCode("000");
        dS173203Param4.setProductSpecifical("11");
        list.add(dS173203Param1);
        list.add(dS173203Param2);
        list.add(dS173203Param3);
        list.add(dS173203Param4);
        pageResultList.setData(list);
        return pageResultList;
    }
}
