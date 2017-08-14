package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC10011Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * TSC20001Controller
 *
 * @author cx
 */
@Controller
@RequestMapping("TSC10011")
public class TSC10011Controller extends BaseController {

    /**
     * 实例化页面
     *
     * @return 界面
     * @author  cx
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init() {
        return "ds/TSC10011";
    }



    /**
     * 分页查询数据
     *
     * @param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<TSC10011Bean> search(BasePageParam pageParam) {
        PageResult<TSC10011Bean> list = new PageResult<>();
        List<TSC10011Bean> beanList = new ArrayList<>();
        TSC10011Bean bean1 = new TSC10011Bean();
        bean1.setContractNumber("20160607001001");
        bean1.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean1.setManufacture("河北某某畜禽养殖有限公司");
        bean1.setInfo1("FH20160607001001");
        bean1.setInfo2("1");
        bean1.setInfo3("YS20160607001001");
        bean1.setInfo4("2016-6-26");
        bean1.setInfo5("已发货");
        TSC10011Bean bean2 = new TSC10011Bean();
        bean2.setContractNumber("20160607001001");
        bean2.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean2.setManufacture("河北某某畜禽养殖有限公司");
        bean2.setInfo1("FH20160607001002");
        bean2.setInfo2("2");
        bean2.setInfo3("YS20160607001002");
        bean2.setInfo4("2016-6-26");
        bean2.setInfo5("已发货");
        TSC10011Bean bean3 = new TSC10011Bean();
        bean3.setContractNumber("20160607001003");
        bean3.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean3.setManufacture("山东硕昌食品有限公司");
        bean3.setInfo1("FH20160607001003");
        bean3.setInfo2("1");
        bean3.setInfo3("YS20160607001003");
        bean3.setInfo4("2016-6-26");
        bean3.setInfo5("已发货");
        TSC10011Bean bean4 = new TSC10011Bean();
        bean4.setContractNumber("20160607001004");
        bean4.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean4.setManufacture("萧县强英食品有限公司");
        bean4.setInfo1("FH20160607001004");
        bean4.setInfo2("2");
        bean4.setInfo3("YS20160607001004");
        bean4.setInfo4("2016-6-26");
        bean4.setInfo5("已发货");
        TSC10011Bean bean5 = new TSC10011Bean();
        bean5.setContractNumber("20160607001005");
        bean5.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean5.setManufacture("寿光市圣德隆食品有限公司");
        bean5.setInfo1("FH20160607001005");
        bean5.setInfo2("3");
        bean5.setInfo3("YS20160607001005");
        bean5.setInfo4("2016-6-26");
        bean5.setInfo5("已发货");
        beanList.add(bean1);
        beanList.add(bean2);
        beanList.add(bean3);
        beanList.add(bean4);
        beanList.add(bean5);
        list.setData(beanList);
        list.setRecordsTotal(beanList.size());
        return list;
    }
}
