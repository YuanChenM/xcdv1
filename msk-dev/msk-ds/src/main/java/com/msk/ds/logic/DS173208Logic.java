package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.DS173208Bean;
import com.msk.ds.bean.DS173209Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DS173208Logic.
 *
 * @author pxg
 * @version 1.0
 **/
@Service
public class DS173208Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DS173208Logic.class);

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
    public PageResult<DS173208Bean> findPageList(){
        PageResult<DS173208Bean> pageDS173208Bean=new PageResult<DS173208Bean>();
        List<DS173208Bean> list=new ArrayList<DS173208Bean>();
        DS173208Bean dS173208Bean=new DS173208Bean();
        dS173208Bean.setDistrict("浦东新区");
        dS173208Bean.setSellerCode("211010101");
        dS173208Bean.setClassCode("01");
        dS173208Bean.setClassName("鸡肉");
        dS173208Bean.setBreedCode("01");
        dS173208Bean.setBreedName("鸡大腿");
        dS173208Bean.setFeatureCode("01");
        dS173208Bean.setFeatureName("100g*20");
        dS173208Bean.setLevel("A1");
        dS173208Bean.setPdBarCode("");
        dS173208Bean.setPdCode("010201002");
        dS173208Bean.setComeTime("2016-01-12");
        dS173208Bean.setNormsCode("001");
        dS173208Bean.setPdBatchCode("342424232");
        DS173208Bean dS173208Bean2=new DS173208Bean();
        dS173208Bean2.setDistrict("浦东新区");
        dS173208Bean2.setSellerCode("211010101");
        dS173208Bean2.setClassCode("01");
        dS173208Bean2.setClassName("鸡肉");
        dS173208Bean2.setBreedCode("01");
        dS173208Bean2.setBreedName("鸡大腿");
        dS173208Bean2.setFeatureCode("01");
        dS173208Bean2.setFeatureName("100g*20");
        dS173208Bean2.setLevel("A1");
        dS173208Bean2.setPdBarCode("");
        dS173208Bean2.setPdCode("010201002");
        dS173208Bean2.setComeTime("2016-01-12");
        dS173208Bean2.setNormsCode("001");
        dS173208Bean2.setPdBatchCode("342424232");
        DS173208Bean dS173208Bean3=new DS173208Bean();
        dS173208Bean3.setDistrict("浦东新区");
        dS173208Bean3.setSellerCode("211010101");
        dS173208Bean3.setClassCode("01");
        dS173208Bean3.setClassName("鸡肉");
        dS173208Bean3.setBreedCode("01");
        dS173208Bean3.setBreedName("鸡大腿");
        dS173208Bean3.setFeatureCode("01");
        dS173208Bean3.setFeatureName("100g*20");
        dS173208Bean3.setLevel("A1");
        dS173208Bean3.setPdBarCode("");
        dS173208Bean3.setPdCode("010201002");
        dS173208Bean3.setComeTime("2016-01-12");
        dS173208Bean3.setNormsCode("001");
        dS173208Bean3.setPdBatchCode("342424232");
        DS173208Bean dS173208Bean4=new DS173208Bean();
        dS173208Bean4.setDistrict("浦东新区");
        dS173208Bean4.setSellerCode("211010101");
        dS173208Bean4.setClassCode("01");
        dS173208Bean4.setClassName("鸡肉");
        dS173208Bean4.setBreedCode("01");
        dS173208Bean4.setBreedName("鸡大腿");
        dS173208Bean4.setFeatureCode("01");
        dS173208Bean4.setFeatureName("100g*20");
        dS173208Bean4.setLevel("A1");
        dS173208Bean4.setPdBarCode("");
        dS173208Bean4.setPdCode("010201002");
        dS173208Bean4.setComeTime("2016-01-12");
        dS173208Bean4.setNormsCode("001");
        dS173208Bean4.setPdBatchCode("342424232");
        list.add(dS173208Bean4);
        list.add(dS173208Bean3);
        list.add(dS173208Bean2);
        list.add(dS173208Bean);
        pageDS173208Bean.setData(list);
        return pageDS173208Bean;
    }
}
