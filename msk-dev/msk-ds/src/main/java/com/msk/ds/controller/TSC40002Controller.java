package com.msk.ds.controller;


import com.msk.core.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 供应商信息管理系统  供应商详细画面
 *
 *
 */
@Controller
@RequestMapping(value = "TSC40002")
public class TSC40002Controller extends BaseController {


    /**
     * 实例化页面
     *
     * @param model model
     * @return 界面
     * @author pxg
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        return "ds/TSC40002";
    }
/*
    *//**
     * 查询页面显示数据
     *
     * @return
     *//*
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<TSC40001Bean> search() {

        PageResult<TSC40001Bean> bean = new PageResult<TSC40001Bean>();
        List<TSC40001Bean> list = new ArrayList<TSC40001Bean>();
        TSC40001Bean bean1 = new TSC40001Bean();
        bean1.setProducerCode("3001001");
        bean1.setProducerName("上海通达禽类产品有限公司");
        bean1.setContactsName("王有才");
        bean1.setContactsPhone("18360547895");
        bean1.setRegion("上海闵行区莘庄凯德梦之龙18F77号");

        TSC40001Bean bean2= new TSC40001Bean();
        bean2.setProducerCode("30547541");
        bean2.setProducerName("湖南澧县镇肉类制品有限公司");
        bean2.setContactsName("宋江平");
        bean2.setContactsPhone("18387457865");
        bean2.setRegion("湖南澧县镇平阳路54号");

        TSC40001Bean bean3 = new TSC40001Bean();
        bean3.setProducerCode("5425412");
        bean3.setProducerName("宁波宏达肉类产品加工有限公司");
        bean3.setContactsName("王海江");
        bean3.setContactsPhone("15823654895");
        bean3.setRegion("宁波上虞市洪都昂路55号");

        TSC40001Bean bean4 = new TSC40001Bean();
        bean4.setProducerCode("546852");
        bean4.setProducerName("江苏省苏州市艾迪邦牛制品有限公司");
        bean4.setContactsName("崔阳");
        bean4.setContactsPhone("1843658745");
        bean4.setRegion("苏州市天都峰路66号");

        TSC40001Bean bean5 = new TSC40001Bean();
        bean5.setProducerCode("55487564");
        bean5.setProducerName("江苏宿迁市快捷产品有限集团");
        bean5.setContactsName("魏晨明");
        bean5.setContactsPhone("15546854256");
        bean5.setRegion("江苏省宿迁市名的乡88号");


        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        bean.setData(list);
        bean.setRecordsTotal(list.size());
        return bean;
    }
    */
}
