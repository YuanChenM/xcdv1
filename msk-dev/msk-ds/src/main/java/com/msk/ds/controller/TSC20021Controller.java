package com.msk.ds.controller;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC10001Bean;
import com.msk.ds.bean.TSC20021Bean;
import com.msk.ds.bean.TSC20021Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * TSC20001Controller
 *
 * @author gyh
 */
@Controller
@RequestMapping("TSC20021")
public class TSC20021Controller extends BaseController {

    /**
     * 实例化页面
     *
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init() {
        return "ds/TSC20021";
    }

    /**
     * 实例化页面
     *
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "initOther",
            method = RequestMethod.POST)
    public String initOther() {
        return "ds/TSC20044";
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
    PageResult<TSC20021Bean> search(BasePageParam pageParam) {
        PageResult<TSC20021Bean> list = new PageResult<>();
        List<TSC20021Bean> beanList = new ArrayList<>();
        TSC20021Bean bean1 = new TSC20021Bean();
        bean1.setContractNumber("20160607001001");
        bean1.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean1.setManufacture("河北某某畜禽养殖有限公司");
        bean1.setContractDate("2016-4-11");
        bean1.setStatus("未核销");
        bean1.setInfo1("FH20160607001001");
        bean1.setInfo2("李全余");
        bean1.setInfo3("李全余");
        bean1.setInfo4("松江仓库");
        TSC20021Bean bean2 = new TSC20021Bean();
        bean2.setContractNumber("20160607001001");
        bean2.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean2.setManufacture("河北某某畜禽养殖有限公司");
        bean2.setContractDate("2016-4-11");
        bean2.setStatus("未核销");
        bean2.setInfo1("FH20160607001002");
        bean2.setInfo2("李全余");
        bean2.setInfo3("李全余");
        bean2.setInfo4("松江仓库");
        TSC20021Bean bean3 = new TSC20021Bean();
        bean3.setContractNumber("20160607001003");
        bean3.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean3.setManufacture("山东硕昌食品有限公司");
        bean3.setContractDate("2016-4-11");
        bean3.setStatus("已核销");
        bean3.setInfo1("FH20160607001003");
        bean3.setInfo2("李全余");
        bean3.setInfo3("李全余");
        bean3.setInfo4("松江仓库");
        TSC20021Bean bean4 = new TSC20021Bean();
        bean4.setContractNumber("20160607001004");
        bean4.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean4.setManufacture("萧县强英食品有限公司");
        bean4.setContractDate("2016-4-11");
        bean4.setStatus("未核销");
        bean4.setInfo1("FH20160607001004");
        bean4.setInfo2("李全余");
        bean4.setInfo3("李全余");
        bean4.setInfo4("松江仓库");
        TSC20021Bean bean5 = new TSC20021Bean();
        bean5.setContractNumber("20160607001005");
        bean5.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean5.setManufacture("寿光市圣德隆食品有限公司");
        bean5.setContractDate("2016-4-11");
        bean5.setStatus("已核销");
        bean5.setInfo1("FH20160607001005");
        bean5.setInfo2("李全余");
        bean5.setInfo3("李全余");
        bean5.setInfo4("松江仓库");
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
