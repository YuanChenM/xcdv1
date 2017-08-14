package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.DS173212Param;
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
public class DS173212Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC183102Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public PageResult<DS173212Param> findPageList(){
        PageResult<DS173212Param> pageResultList=new PageResult<DS173212Param>();
        List<DS173212Param> list=new ArrayList<DS173212Param>();
        DS173212Param ds173212Param1 = new DS173212Param();
        DS173212Param ds173212Param2 = new DS173212Param();
        DS173212Param ds173212Param3 = new DS173212Param();
        DS173212Param ds173212Param4 = new DS173212Param();
        ds173212Param1.setProductName("鸡产品");
        ds173212Param1.setProductCode("003");
        ds173212Param1.setProductTypeName("鸡腿");
        ds173212Param1.setProductFeature("01");
        ds173212Param1.setProductLevel("03");
        ds173212Param1.setNetWeight(new BigDecimal(10.0));
        ds173212Param1.setPackageCode("000");
        ds173212Param1.setProductSpecifical("11");
        ds173212Param2.setProductName("鸡产品");
        ds173212Param2.setProductCode("003");
        ds173212Param2.setProductTypeName("鸡头");
        ds173212Param2.setProductFeature("01");
        ds173212Param2.setProductLevel("03");
        ds173212Param2.setNetWeight(new BigDecimal(10.0));
        ds173212Param2.setPackageCode("000");
        ds173212Param2.setProductSpecifical("11");
        ds173212Param3.setProductName("鸭产品");
        ds173212Param3.setProductCode("003");
        ds173212Param3.setProductTypeName("鸭头");
        ds173212Param3.setProductFeature("01");
        ds173212Param3.setProductLevel("03");
        ds173212Param3.setNetWeight(new BigDecimal(10.0));
        ds173212Param3.setPackageCode("000");
        ds173212Param3.setProductSpecifical("11");
        ds173212Param4.setProductName("鸭产品");
        ds173212Param4.setProductCode("003");
        ds173212Param4.setProductTypeName("鸭腿");
        ds173212Param4.setProductFeature("01");
        ds173212Param4.setProductLevel("03");
        ds173212Param4.setNetWeight(new BigDecimal(10.0));
        ds173212Param4.setPackageCode("000");
        ds173212Param4.setProductSpecifical("11");
        list.add(ds173212Param1);
        list.add(ds173212Param2);
        list.add(ds173212Param3);
        list.add(ds173212Param4);
        pageResultList.setData(list);
        return pageResultList;
    }
}
