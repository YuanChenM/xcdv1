package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.TSC10004Bean;
import com.msk.ds.bean.TSC20032Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * PD141136Logic
 * @author pxg
 */
@Service
public class TSC20032Logic extends BaseLogic {


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询数据
     * @return
     */
    @Transactional(readOnly = true)
    public PageResult<TSC20032Bean> findListSl() {
        //查询列表数据
        PageResult<TSC20032Bean> list=new PageResult<>();
        List<TSC20032Bean> beanList=new ArrayList<>();
        TSC20032Bean tsc20032Bean=new TSC20032Bean();
        tsc20032Bean.setOrderNumber("SA01032201");
        tsc20032Bean.setOrderDate("2016-09-21");
        tsc20032Bean.setProduction("寿光圣沣食品有限公司");
        tsc20032Bean.setAddress("上海市松江区开明路1168号（味硕实业（上海）有限公司）");
        TSC20032Bean tsc20032Bean1=new TSC20032Bean();
        tsc20032Bean1.setOrderNumber("SA01032201");
        tsc20032Bean1.setOrderDate("2016-09-26");
        tsc20032Bean1.setProduction("寿光圣沣食品有限公司.");
        tsc20032Bean1.setAddress("上海市松江区开明路1168号（味硕实业（上海）有限公司）");
        TSC20032Bean tsc20032Bean2=new TSC20032Bean();
        tsc20032Bean2.setOrderNumber("SA01032201");
        tsc20032Bean2.setOrderDate("2016-09-24");
        tsc20032Bean2.setProduction("寿光圣沣食品有限公司");
        tsc20032Bean2.setAddress("上海市松江区开明路1168号（味硕实业（上海）有限公司）");
        TSC20032Bean tsc20032Bean3=new TSC20032Bean();
        tsc20032Bean3.setOrderNumber("SA01032201");
        tsc20032Bean3.setOrderDate("2016-09-22");
        tsc20032Bean3.setProduction("寿光圣沣食品有限公司");
        tsc20032Bean3.setAddress("上海市松江区开明路1168号（味硕实业（上海）有限公司）");
        beanList.add(tsc20032Bean);
        beanList.add(tsc20032Bean1);
        beanList.add(tsc20032Bean2);
        beanList.add(tsc20032Bean3);
        list.setData(beanList);
        list.setRecordsTotal(beanList.size());
        return list;
    }
}
