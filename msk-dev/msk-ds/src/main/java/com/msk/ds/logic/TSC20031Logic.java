package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.TSC10004Bean;
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
public class TSC20031Logic extends BaseLogic {


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
    public PageResult<TSC10004Bean> findListSl() {
        //查询列表数据
        PageResult<TSC10004Bean> list=new PageResult<>();
        List<TSC10004Bean> beanList=new ArrayList<>();
        TSC10004Bean TSC10004Bean1=new TSC10004Bean();
        TSC10004Bean1.setContractNumber("20160607001001");
        TSC10004Bean1.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        TSC10004Bean1.setManufacture("河北某某畜禽养殖有限公司");
        TSC10004Bean1.setContractDate("2016-11-03");
        TSC10004Bean1.setStatus("未核销");
        TSC10004Bean TSC10004Bean2=new TSC10004Bean();
        TSC10004Bean2.setContractNumber("20160607001002");
        TSC10004Bean2.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        TSC10004Bean2.setManufacture("山东荣达农业发展有限公司");
        TSC10004Bean2.setContractDate("2016-11-03");
        TSC10004Bean2.setStatus("未核销");
        TSC10004Bean TSC10004Bean3=new TSC10004Bean();
        TSC10004Bean3.setContractNumber("20160607001003");
        TSC10004Bean3.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        TSC10004Bean3.setManufacture("山东硕昌食品有限公司");
        TSC10004Bean3.setContractDate("2016-11-03");
        TSC10004Bean3.setStatus("已核销");
        TSC10004Bean TSC10004Bean4=new TSC10004Bean();
        TSC10004Bean4.setContractNumber("20160607001004");
        TSC10004Bean4.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        TSC10004Bean4.setManufacture("萧县强英食品有限公司");
        TSC10004Bean4.setContractDate("2016-11-03");
        TSC10004Bean4.setStatus("未核销");
        TSC10004Bean TSC10004Bean5=new TSC10004Bean();
        TSC10004Bean5.setContractNumber("20160607001005");
        TSC10004Bean5.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        TSC10004Bean5.setManufacture("寿光市圣德隆食品有限公司");
        TSC10004Bean5.setContractDate("2016-11-03");
        TSC10004Bean5.setStatus("已核销");
        beanList.add(TSC10004Bean1);
        beanList.add(TSC10004Bean2);
        beanList.add(TSC10004Bean3);
        beanList.add(TSC10004Bean4);
        beanList.add(TSC10004Bean5);
        list.setData(beanList);
        list.setRecordsTotal(beanList.size());
        return list;
    }
}
