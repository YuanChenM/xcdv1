package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.DS173102Bean;
import com.msk.ds.bean.SC183104Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * DS174101Logic.
 *
 * @author pxg
 * @version 1.0
 **/
@Service
public class DS173102Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DS173102Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author pxg
     */
    interface SqlId {

    }
    public PageResult<DS173102Bean> findPageList(){
        PageResult<DS173102Bean> pageDS173102Bean=new PageResult<DS173102Bean>();
        List<DS173102Bean> list=new ArrayList<DS173102Bean>();
        DS173102Bean dS173102Bean=new DS173102Bean();
        dS173102Bean.setMonth("20160201");
        dS173102Bean.setProd("神农客");
        dS173102Bean.setDistrict("南京");
        DS173102Bean dS173102Bean1=new DS173102Bean();
        dS173102Bean1.setMonth("20160201");
        dS173102Bean1.setProd("神农客");
        dS173102Bean1.setDistrict("上海");
        DS173102Bean dS173102Bean2=new DS173102Bean();
        dS173102Bean2.setMonth("20160101");
        dS173102Bean2.setProd("神农客");
        dS173102Bean2.setDistrict("徐州");
        DS173102Bean dS173102Bean3=new DS173102Bean();
        dS173102Bean3.setMonth("20160201");
        dS173102Bean3.setProd("神农客");
        dS173102Bean3.setDistrict("无锡");
        list.add(dS173102Bean3);
        list.add(dS173102Bean2);
        list.add(dS173102Bean1);
        list.add(dS173102Bean);
        pageDS173102Bean.setData(list);
        return pageDS173102Bean;
    }
}
