package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.DS173204Param;
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
public class DS173204Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC183102Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public PageResult<DS173204Param> findPageList(){
        PageResult<DS173204Param> pageResultList=new PageResult<DS173204Param>();
        List<DS173204Param> list=new ArrayList<DS173204Param>();
        DS173204Param ds173204Param1 = new DS173204Param();
        DS173204Param ds173204Param2 = new DS173204Param();
        DS173204Param ds173204Param3 = new DS173204Param();
        DS173204Param ds173204Param4 = new DS173204Param();
        ds173204Param1.setProductName("鸡产品");
        ds173204Param1.setProductCode("003");
        ds173204Param1.setProductTypeName("鸡腿");
        ds173204Param1.setProductFeature("01");
        ds173204Param1.setProductLevel("03");
        ds173204Param1.setNetWeight(new BigDecimal(10.0));
        ds173204Param1.setPackageCode("000");
        ds173204Param1.setProductSpecifical("11");
        ds173204Param1.setProductOnWayQty_1(new BigDecimal(10.0));
        ds173204Param1.setProductOnWayQty_2(new BigDecimal(20.0));
        ds173204Param1.setProductOnWayQty_3(new BigDecimal(30.0));
        ds173204Param1.setProductOnWayQty_4(new BigDecimal(40.0));
        ds173204Param1.setProductOnWayQty_5(new BigDecimal(50.0));
        ds173204Param1.setProductOnWayQty_6(new BigDecimal(10.0));
        ds173204Param1.setSumProductOnWayQty(new BigDecimal(160.0));
        ds173204Param2.setProductName("鸡产品");
        ds173204Param2.setProductCode("003");
        ds173204Param2.setProductTypeName("鸡头");
        ds173204Param2.setProductFeature("01");
        ds173204Param2.setProductLevel("03");
        ds173204Param2.setNetWeight(new BigDecimal(10.0));
        ds173204Param2.setPackageCode("000");
        ds173204Param2.setProductSpecifical("11");
        ds173204Param2.setProductOnWayQty_1(new BigDecimal(20.0));
        ds173204Param2.setProductOnWayQty_2(new BigDecimal(20.0));
        ds173204Param2.setProductOnWayQty_3(new BigDecimal(30.0));
        ds173204Param2.setProductOnWayQty_4(new BigDecimal(40.0));
        ds173204Param2.setProductOnWayQty_5(new BigDecimal(50.0));
        ds173204Param2.setProductOnWayQty_6(new BigDecimal(10.0));
        ds173204Param2.setSumProductOnWayQty(new BigDecimal(170.0));
        ds173204Param3.setProductName("鸭产品");
        ds173204Param3.setProductCode("003");
        ds173204Param3.setProductTypeName("鸭头");
        ds173204Param3.setProductFeature("01");
        ds173204Param3.setProductLevel("03");
        ds173204Param3.setNetWeight(new BigDecimal(10.0));
        ds173204Param3.setPackageCode("000");
        ds173204Param3.setProductSpecifical("11");
        ds173204Param3.setProductOnWayQty_1(new BigDecimal(20.0));
        ds173204Param3.setProductOnWayQty_2(new BigDecimal(20.0));
        ds173204Param3.setProductOnWayQty_3(new BigDecimal(30.0));
        ds173204Param3.setProductOnWayQty_4(new BigDecimal(40.0));
        ds173204Param3.setProductOnWayQty_5(new BigDecimal(50.0));
        ds173204Param3.setProductOnWayQty_6(new BigDecimal(10.0));
        ds173204Param3.setSumProductOnWayQty(new BigDecimal(170.0));
        ds173204Param4.setProductName("鸭产品");
        ds173204Param4.setProductCode("003");
        ds173204Param4.setProductTypeName("鸭腿");
        ds173204Param4.setProductFeature("01");
        ds173204Param4.setProductLevel("03");
        ds173204Param4.setNetWeight(new BigDecimal(10.0));
        ds173204Param4.setPackageCode("000");
        ds173204Param4.setProductSpecifical("11");
        ds173204Param4.setProductOnWayQty_1(new BigDecimal(20.0));
        ds173204Param4.setProductOnWayQty_2(new BigDecimal(20.0));
        ds173204Param4.setProductOnWayQty_3(new BigDecimal(30.0));
        ds173204Param4.setProductOnWayQty_4(new BigDecimal(40.0));
        ds173204Param4.setProductOnWayQty_5(new BigDecimal(50.0));
        ds173204Param4.setProductOnWayQty_6(new BigDecimal(10.0));
        ds173204Param4.setSumProductOnWayQty(new BigDecimal(170.0));
        list.add(ds173204Param1);
        list.add(ds173204Param2);
        list.add(ds173204Param3);
        list.add(ds173204Param4);
        pageResultList.setData(list);
        return pageResultList;
    }
}
