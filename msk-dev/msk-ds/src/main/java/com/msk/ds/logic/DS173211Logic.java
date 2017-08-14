package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.DS173211Param;
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
public class DS173211Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC183102Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public PageResult<DS173211Param> findPageList(){
        PageResult<DS173211Param> pageResultList=new PageResult<DS173211Param>();
        List<DS173211Param> list=new ArrayList<DS173211Param>();
        DS173211Param ds173211Param1 = new DS173211Param();
        DS173211Param ds173211Param2 = new DS173211Param();
        DS173211Param ds173211Param3 = new DS173211Param();
        DS173211Param ds173211Param4 = new DS173211Param();
        ds173211Param1.setProductName("鸡产品");
        ds173211Param1.setProductCode("003");
        ds173211Param1.setProductTypeName("鸡腿");
        ds173211Param1.setProductFeature("01");
        ds173211Param1.setProductLevel("03");
        ds173211Param1.setNetWeight(new BigDecimal(10.0));
        ds173211Param1.setPackageCode("000");
        ds173211Param1.setProductSpecifical("11");
        ds173211Param1.setProductStorageQty_1(new BigDecimal(10.0));
        ds173211Param1.setProductStorageQty_2(new BigDecimal(20.0));
        ds173211Param1.setProductStorageQty_3(new BigDecimal(30.0));
        ds173211Param1.setProductStorageQty_4(new BigDecimal(40.0));
        ds173211Param1.setProductStorageQty_5(new BigDecimal(50.0));
        ds173211Param1.setProductStorageQty_6(new BigDecimal(10.0));
        ds173211Param1.setSumProductStorageQty(new BigDecimal(160.0));
        ds173211Param2.setProductName("鸡产品");
        ds173211Param2.setProductCode("003");
        ds173211Param2.setProductTypeName("鸡头");
        ds173211Param2.setProductFeature("01");
        ds173211Param2.setProductLevel("03");
        ds173211Param2.setNetWeight(new BigDecimal(10.0));
        ds173211Param2.setPackageCode("000");
        ds173211Param2.setProductSpecifical("11");
        ds173211Param2.setProductStorageQty_1(new BigDecimal(20.0));
        ds173211Param2.setProductStorageQty_2(new BigDecimal(20.0));
        ds173211Param2.setProductStorageQty_3(new BigDecimal(30.0));
        ds173211Param2.setProductStorageQty_4(new BigDecimal(40.0));
        ds173211Param2.setProductStorageQty_5(new BigDecimal(50.0));
        ds173211Param2.setProductStorageQty_6(new BigDecimal(10.0));
        ds173211Param2.setSumProductStorageQty(new BigDecimal(170.0));
        ds173211Param3.setProductName("鸭产品");
        ds173211Param3.setProductCode("003");
        ds173211Param3.setProductTypeName("鸭头");
        ds173211Param3.setProductFeature("01");
        ds173211Param3.setProductLevel("03");
        ds173211Param3.setNetWeight(new BigDecimal(10.0));
        ds173211Param3.setPackageCode("000");
        ds173211Param3.setProductSpecifical("11");
        ds173211Param3.setProductStorageQty_1(new BigDecimal(20.0));
        ds173211Param3.setProductStorageQty_2(new BigDecimal(20.0));
        ds173211Param3.setProductStorageQty_3(new BigDecimal(30.0));
        ds173211Param3.setProductStorageQty_4(new BigDecimal(40.0));
        ds173211Param3.setProductStorageQty_5(new BigDecimal(50.0));
        ds173211Param3.setProductStorageQty_6(new BigDecimal(10.0));
        ds173211Param3.setSumProductStorageQty(new BigDecimal(170.0));
        ds173211Param4.setProductName("鸭产品");
        ds173211Param4.setProductCode("003");
        ds173211Param4.setProductTypeName("鸭腿");
        ds173211Param4.setProductFeature("01");
        ds173211Param4.setProductLevel("03");
        ds173211Param4.setNetWeight(new BigDecimal(10.0));
        ds173211Param4.setPackageCode("000");
        ds173211Param4.setProductSpecifical("11");
        ds173211Param4.setProductStorageQty_1(new BigDecimal(20.0));
        ds173211Param4.setProductStorageQty_2(new BigDecimal(20.0));
        ds173211Param4.setProductStorageQty_3(new BigDecimal(30.0));
        ds173211Param4.setProductStorageQty_4(new BigDecimal(40.0));
        ds173211Param4.setProductStorageQty_5(new BigDecimal(50.0));
        ds173211Param4.setProductStorageQty_6(new BigDecimal(10.0));
        ds173211Param4.setSumProductStorageQty(new BigDecimal(170.0));
        list.add(ds173211Param1);
        list.add(ds173211Param2);
        list.add(ds173211Param3);
        list.add(ds173211Param4);
        pageResultList.setData(list);
        return pageResultList;
    }
}
