package com.msk.ds.logic;

import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.TSC30011Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TSC30011Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(TSC30011Logic.class);

    public PageResult<TSC30011Bean> findList() {
        PageResult pageResult = new PageResult();
        List<TSC30011Bean> list = new ArrayList<TSC30011Bean>();
        TSC30011Bean tsc30011Bean = new TSC30011Bean();
        tsc30011Bean.setCode("20160607001001");
        tsc30011Bean.setName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        tsc30011Bean.setChangshang("河北某某畜禽养殖有限公司");
        tsc30011Bean.setTime("2016-03-20");
        tsc30011Bean.setType("未核销");
        TSC30011Bean tsc30011Bean1 = new TSC30011Bean();
        tsc30011Bean1.setCode("20160607001002");
        tsc30011Bean1.setName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        tsc30011Bean1.setChangshang("山东荣达农业发展有限公司");
        tsc30011Bean1.setTime("2016-03-20");
        tsc30011Bean1.setType("未核销");
        TSC30011Bean tsc30011Bean2 = new TSC30011Bean();
        tsc30011Bean2.setCode("20160607001003");
        tsc30011Bean2.setName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        tsc30011Bean2.setChangshang("山东硕昌食品有限公司");
        tsc30011Bean2.setTime("2016-03-20");
        tsc30011Bean2.setType("已核销");
        TSC30011Bean tsc30011Bean3 = new TSC30011Bean();
        tsc30011Bean3.setCode("20160607001004");
        tsc30011Bean3.setName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        tsc30011Bean3.setChangshang("萧县强英食品有限公司");
        tsc30011Bean3.setTime("2016-03-20");
        tsc30011Bean3.setType("未核销");
        TSC30011Bean tsc30011Bean4 = new TSC30011Bean();
        tsc30011Bean4.setCode("20160607001005");
        tsc30011Bean4.setName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        tsc30011Bean4.setChangshang("寿光市圣德隆食品有限公司");
        tsc30011Bean4.setTime("2016-03-20");
        tsc30011Bean4.setType("已核销");
        list.add(tsc30011Bean);
        list.add(tsc30011Bean1);
        list.add(tsc30011Bean2);
        list.add(tsc30011Bean3);
        list.add(tsc30011Bean4);
        pageResult.setData(list);
        return pageResult;
    }
}