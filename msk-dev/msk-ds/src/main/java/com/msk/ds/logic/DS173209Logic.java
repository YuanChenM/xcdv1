package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.DS173209Bean;
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
public class DS173209Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DS173209Logic.class);

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
    public PageResult<DS173209Bean> findPageList(){
        PageResult<DS173209Bean> pagedS173209Bean=new PageResult<DS173209Bean>();
        List<DS173209Bean> list=new ArrayList<DS173209Bean>();
        DS173209Bean dS173209Bean=new DS173209Bean();
        dS173209Bean.setDistrict("浦东新区");
        dS173209Bean.setSellerCode("211010101");
        dS173209Bean.setClassCode("01");
        dS173209Bean.setClassName("鸡肉");
        dS173209Bean.setBreedCode("01");
        dS173209Bean.setBreedName("鸡大腿");
        dS173209Bean.setFeatureCode("01");
        dS173209Bean.setFeatureName("100g*20");
        dS173209Bean.setLevel("A1");
        dS173209Bean.setPdBarCode("");
        dS173209Bean.setPdCode("010201002");
        dS173209Bean.setComeTime("2016-01-12");
        dS173209Bean.setNormsCode("001");
        dS173209Bean.setPdBatchCode("342424232");
        DS173209Bean dS173209Bean2=new DS173209Bean();
        dS173209Bean2.setDistrict("浦东新区");
        dS173209Bean2.setSellerCode("211010101");
        dS173209Bean2.setClassCode("01");
        dS173209Bean2.setClassName("鸡肉");
        dS173209Bean2.setBreedCode("01");
        dS173209Bean2.setBreedName("鸡大腿");
        dS173209Bean2.setFeatureCode("01");
        dS173209Bean2.setFeatureName("100g*20");
        dS173209Bean2.setLevel("A1");
        dS173209Bean2.setPdBarCode("");
        dS173209Bean2.setPdCode("010201002");
        dS173209Bean2.setComeTime("2016-01-12");
        dS173209Bean2.setNormsCode("001");
        dS173209Bean2.setPdBatchCode("342424232");
        DS173209Bean dS173209Bean3=new DS173209Bean();
        dS173209Bean3.setDistrict("浦东新区");
        dS173209Bean3.setSellerCode("211010101");
        dS173209Bean3.setClassCode("01");
        dS173209Bean3.setClassName("鸡肉");
        dS173209Bean3.setBreedCode("01");
        dS173209Bean3.setBreedName("鸡大腿");
        dS173209Bean3.setFeatureCode("01");
        dS173209Bean3.setFeatureName("100g*20");
        dS173209Bean3.setLevel("A1");
        dS173209Bean3.setPdBarCode("");
        dS173209Bean3.setPdCode("010201002");
        dS173209Bean3.setComeTime("2016-01-12");
        dS173209Bean3.setNormsCode("001");
        dS173209Bean3.setPdBatchCode("342424232");
        DS173209Bean dS173209Bean4=new DS173209Bean();
        dS173209Bean4.setDistrict("浦东新区");
        dS173209Bean4.setSellerCode("211010101");
        dS173209Bean4.setClassCode("01");
        dS173209Bean4.setClassName("鸡肉");
        dS173209Bean4.setBreedCode("01");
        dS173209Bean4.setBreedName("鸡大腿");
        dS173209Bean4.setFeatureCode("01");
        dS173209Bean4.setFeatureName("100g*20");
        dS173209Bean4.setLevel("A1");
        dS173209Bean4.setPdBarCode("");
        dS173209Bean4.setPdCode("010201002");
        dS173209Bean4.setComeTime("2016-01-12");
        dS173209Bean4.setNormsCode("001");
        dS173209Bean4.setPdBatchCode("342424232");
        list.add(dS173209Bean4);
        list.add(dS173209Bean3);
        list.add(dS173209Bean2);
        list.add(dS173209Bean);
        pagedS173209Bean.setData(list);
        return pagedS173209Bean;
    }
}
