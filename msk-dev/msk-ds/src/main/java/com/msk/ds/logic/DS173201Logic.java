package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.DS173102Bean;
import com.msk.ds.bean.DS173103Param;
import com.msk.ds.bean.DS173201Param;
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
public class DS173201Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC183102Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public PageResult<DS173201Param> findPageList(){
        PageResult<DS173201Param> pageResultList=new PageResult<DS173201Param>();
        List<DS173201Param> list=new ArrayList<DS173201Param>();
        DS173201Param ds173201Param1 = new DS173201Param();
        ds173201Param1.setAreaCode("01");
        ds173201Param1.setDistMonth("201602");
        ds173201Param1.setSellerCode("001");
        ds173201Param1.setSellerName("神农客");
        ds173201Param1.setAreaName("南京");
        DS173201Param ds173201Param2 = new DS173201Param();
        ds173201Param2.setAreaCode("02");
        ds173201Param2.setDistMonth("201601");
        ds173201Param2.setSellerCode("002");
        ds173201Param2.setSellerName("神农客");
        ds173201Param2.setAreaName("上海");
        DS173201Param ds173201Param3 = new DS173201Param();
        ds173201Param3.setAreaCode("03");
        ds173201Param3.setDistMonth("201603");
        ds173201Param3.setSellerCode("003");
        ds173201Param3.setSellerName("神农客");
        ds173201Param3.setAreaName("上海");
        list.add(ds173201Param1);
        list.add(ds173201Param2);
        list.add(ds173201Param3);
        pageResultList.setData(list);
        return pageResultList;
    }
}
