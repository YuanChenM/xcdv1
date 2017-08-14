package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC10012Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cx on 2016/6/28.
 */
@Controller
@RequestMapping("TSC10012")
public class TSC10012Controller extends BaseController {
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init() {
        return "ds/TSC10012";
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
    PageResult<TSC10012Bean> search(BasePageParam pageParam) {
        PageResult<TSC10012Bean> list = new PageResult<>();
        List<TSC10012Bean> beanList = new ArrayList<>();
        TSC10012Bean bean1 = new TSC10012Bean();

        bean1.setContractNumber("20160607001001");
        bean1.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标 ");
        bean1.setManufacture("河北某某畜禽养殖有限公司");
        bean1.setInfo1("ZF20160607001001");
        bean1.setInfo2("首付");
        bean1.setInfo3("");
        bean1.setInfo4("预付款");
        bean1.setInfo5("全部付款");
        bean1.setInfo6("60000");
        bean1.setInfo7("60000");
        bean1.setInfo8("");
        bean1.setInfo9("");
        bean1.setInfo10("2016-6-28");
        bean1.setInfo11("2016-6-28");
        bean1.setInfo12("已审核");
        TSC10012Bean bean2 = new TSC10012Bean();

        bean2.setContractNumber("20160607001001");
        bean2.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标 ");
        bean2.setManufacture("河北某某畜禽养殖有限公司");
        bean2.setInfo1("ZF20160607001001");
        bean2.setInfo2("食材类订单");
        bean2.setInfo3("FH20160607001001");
        bean2.setInfo4("发货订单1货款");
        bean2.setInfo5("已付款");
        bean2.setInfo6("72000");
        bean2.setInfo7("72000");
        bean2.setInfo8("");
        bean2.setInfo9("");
        bean2.setInfo10("2016-6-27");
        bean2.setInfo11("2016-6-28");
        bean2.setInfo12("已审核");
        TSC10012Bean bean3 = new TSC10012Bean();

        bean3.setContractNumber("20160607001001");
        bean3.setContractName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标 ");
        bean3.setManufacture("河北某某畜禽养殖有限公司");
        bean3.setInfo1("ZF20160607001001");
        bean3.setInfo2("食材类订单");
        bean3.setInfo3("FH20160607001001");
        bean3.setInfo4("发货订单1货款");
        bean3.setInfo5("已付款");
        bean3.setInfo6("72000");
        bean3.setInfo7("72000");
        bean3.setInfo8("");
        bean3.setInfo9("");
        bean3.setInfo10("2016-6-27");
        bean3.setInfo11("2016-6-28");
        bean1.setInfo12("待审核");
        beanList.add(bean1);
        beanList.add(bean2);
        beanList.add(bean3);
        list.setData(beanList);
        list.setRecordsTotal(beanList.size());
        return list;
    }
}
