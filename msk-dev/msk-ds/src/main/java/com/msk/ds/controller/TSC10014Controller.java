package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC10014Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("TSC10014")
public class TSC10014Controller extends BaseController {

    /**
     * 实例化页面
     *
     * @return 界面
     * @author  cx
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init() {
        return "ds/TSC10014";
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
    PageResult<TSC10014Bean> search(BasePageParam pageParam) {
        PageResult<TSC10014Bean> list = new PageResult<>();
        List<TSC10014Bean> beanList = new ArrayList<>();
        TSC10014Bean bean1 = new TSC10014Bean();
        bean1.setInfo1("YS20160607001001");
        bean1.setInfo2("001");
        bean1.setInfo3("待装车");
        bean1.setInfo4("2016-6-26");
        bean1.setInfo5("");
        bean1.setInfo6("2016-6-27");
        bean1.setInfo7("");
        bean1.setInfo8("798");
        bean1.setInfo9("220102022");
        bean1.setInfo10("带皮鸭胸");
        bean1.setInfo11("220-224g");
        bean1.setInfo12("A2");
        bean1.setInfo13("100");
        bean1.setInfo14("");
        bean1.setInfo15("");
        TSC10014Bean bean2 = new TSC10014Bean();
        bean2.setInfo1("YS20160607001001");
        bean2.setInfo2("001");
        bean2.setInfo3("待装车");
        bean2.setInfo4("2016-6-26");
        bean2.setInfo5("");
        bean2.setInfo6("2016-6-27");
        bean2.setInfo7("");
        bean2.setInfo8("798");
        bean2.setInfo9("220102022");
        bean2.setInfo10("鸭胗");
        bean2.setInfo11("220-224g");
        bean2.setInfo12("A2");
        bean2.setInfo13("10");
        bean2.setInfo14("");
        bean2.setInfo15("");
        TSC10014Bean bean3 = new TSC10014Bean();
        bean3.setInfo1("YS20160607001001");
        bean3.setInfo2("002");
        bean3.setInfo3("已发货");
        bean3.setInfo4("2016-6-26");
        bean3.setInfo5("2016-6-26");
        bean3.setInfo6("2016-6-27");
        bean3.setInfo7("2016-6-27");
        bean3.setInfo8("798");
        bean3.setInfo9("220201032");
        bean3.setInfo10("鸭锁骨");
        bean3.setInfo11("100-120g");
        bean3.setInfo12("A2");
        bean3.setInfo13("250");
        bean3.setInfo14("250");
        bean3.setInfo15("25");
        TSC10014Bean bean4 = new TSC10014Bean();
        bean4.setInfo1("YS20160607001001");
        bean4.setInfo2("003");
        bean4.setInfo3("已收货");
        bean4.setInfo4("2016-6-26");
        bean4.setInfo5("2016-6-26");
        bean4.setInfo6("2016-6-27");
        bean4.setInfo7("2016-6-27");
        bean4.setInfo8("798");
        bean4.setInfo9("220201032");
        bean4.setInfo10("带皮鸭胸");
        bean4.setInfo11("220-224g");
        bean4.setInfo12("A2");
        bean4.setInfo13("100");
        bean4.setInfo14("105");
        bean4.setInfo15("10");
        beanList.add(bean1);
        beanList.add(bean2);
        beanList.add(bean3);
        beanList.add(bean4);
        list.setData(beanList);
        list.setRecordsTotal(beanList.size());
        return list;
    }
}
