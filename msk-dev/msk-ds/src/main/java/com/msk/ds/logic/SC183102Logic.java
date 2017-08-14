package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.SC183101Param;
import com.msk.ds.bean.SC183102Bean;
import com.msk.ds.bean.SC183104Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * SC183102Logic.
 * @author fjm
 * @version 1.0
 **/
@Service
public class SC183102Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC183102Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {

        String SQL_ID_DELETE_PLANBEAN="deletePlanBean";
    }

    public int deleteBean(SC183102Bean sc183102Bean){
        return super.remove(SqlId.SQL_ID_DELETE_PLANBEAN,sc183102Bean);
    }

    /*public PageResult<DS173301Param> findPageList(){
        PageResult<DS173301Param> pageParam=new PageResult<DS173301Param>();
        List<DS173301Param> listAll=new ArrayList<DS173301Param>();
        DS173301Param dsParam1 = new DS173301Param();
        DS173301Param dsParam2 = new DS173301Param();
        DS173301Param dsParam3 = new DS173301Param();

        dsParam1.setAreaName("黄埔区");
        dsParam1.setPlanType("生产期");
        dsParam1.setPlanNumber1(new BigDecimal(10.0));
        dsParam1.setChangeNumber1(new BigDecimal(1.0));
        dsParam1.setChangeOverNumber1(new BigDecimal(11.0));
        dsParam1.setPlanNumber2(new BigDecimal(11.0));
        dsParam1.setChangeNumber2(new BigDecimal(1.0));
        dsParam1.setChangeOverNumber2(new BigDecimal(12.0));
        dsParam1.setPlanNumber3(new BigDecimal(12.0));
        dsParam1.setChangeNumber3(new BigDecimal(1.0));
        dsParam1.setChangeOverNumber3(new BigDecimal(13.0));


        dsParam2.setAreaName("黄埔区");
        dsParam2.setPlanType("在途");
        dsParam2.setPlanNumber1(new BigDecimal(10.0));
        dsParam2.setChangeNumber1(new BigDecimal(1.0));
        dsParam2.setChangeOverNumber1(new BigDecimal(11.0));
        dsParam2.setPlanNumber3(new BigDecimal(11.0));
        dsParam2.setChangeNumber3(new BigDecimal(1.0));
        dsParam2.setChangeOverNumber3(new BigDecimal(12.0));
        dsParam2.setPlanNumber2(new BigDecimal(12.0));
        dsParam2.setChangeNumber2(new BigDecimal(1.0));
        dsParam2.setChangeOverNumber2(new BigDecimal(13.0));

        dsParam3.setAreaName("黄埔区");
        dsParam3.setPlanType("入销售库");
        dsParam3.setPlanNumber1(new BigDecimal(10.0));
        dsParam3.setChangeNumber1(new BigDecimal(1.0));
        dsParam3.setChangeOverNumber1(new BigDecimal(11.0));
        dsParam3.setPlanNumber2(new BigDecimal(11.0));
        dsParam3.setChangeNumber2(new BigDecimal(1.0));
        dsParam3.setChangeOverNumber2(new BigDecimal(12.0));
        dsParam3.setPlanNumber3(new BigDecimal(12.0));
        dsParam3.setChangeNumber3(new BigDecimal(1.0));
        dsParam3.setChangeOverNumber3(new BigDecimal(13.0));
        listAll.add(dsParam1);
        listAll.add(dsParam2);
        listAll.add(dsParam3);
        pageParam.setData(listAll);
        return pageParam;
    }*/

    public PageResult<SC183101Param> findPageList(){
        PageResult<SC183101Param> pageParam=new PageResult<SC183101Param>();
        List<SC183101Param> listAll=new ArrayList<SC183101Param>();

        pageParam.setData(listAll);
        return pageParam;
    }

}
