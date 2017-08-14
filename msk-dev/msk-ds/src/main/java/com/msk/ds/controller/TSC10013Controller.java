package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC10013Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("TSC10013")
public class TSC10013Controller extends BaseController {

    /**
     * 实例化页面
     *
     * @return 界面
     * @author  cx
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init() {
        return "ds/TSC10013";
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
    PageResult<TSC10013Bean> search(BasePageParam pageParam) {
        PageResult<TSC10013Bean> list = new PageResult<>();
        List<TSC10013Bean> beanList = new ArrayList<>();
        TSC10013Bean bean1 = new TSC10013Bean();
        bean1.setInfo1("220102022");
        bean1.setInfo2("鸭产品");
        bean1.setInfo3("分割品");
        bean1.setInfo4("带皮鸭胸");
        bean1.setInfo5("220-224g");
        bean1.setInfo6("A2");
        bean1.setInfo7("10");
        bean1.setInfo8("10kg*1");
        bean1.setInfo9("1000");
        bean1.setInfo10("10");
        bean1.setInfo11("700");
        TSC10013Bean bean2 = new TSC10013Bean();
        bean2.setInfo1("220102022");
        bean2.setInfo2("鸭产品");
        bean2.setInfo3("分割品");
        bean2.setInfo4("带皮鸭胸");
        bean2.setInfo5("220-224g");
        bean2.setInfo6("A2");
        bean2.setInfo7("10");
        bean2.setInfo8("10kg*1");
        bean2.setInfo9("1000");
        bean2.setInfo10("10");
        bean2.setInfo11("700");
        TSC10013Bean bean3 = new TSC10013Bean();
        bean3.setInfo1("220102022");
        bean3.setInfo2("鸭产品");
        bean3.setInfo3("分割品");
        bean3.setInfo4("带皮鸭胸");
        bean3.setInfo5("220-224g");
        bean3.setInfo6("A2");
        bean3.setInfo7("10");
        bean3.setInfo8("10kg*1");
        bean3.setInfo9("1000");
        bean3.setInfo10("10");
        bean3.setInfo11("700");
        beanList.add(bean1);
        beanList.add(bean2);
        beanList.add(bean3);
        list.setData(beanList);
        list.setRecordsTotal(beanList.size());
        return list;
    }
}
