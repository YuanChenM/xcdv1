package com.msk.ds.controller;


import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC30001Bean;
import com.msk.ds.bean.TSC30002Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 市场需求审核注册修改添加controller
 *
 * @author XHY
 */
@Controller
@RequestMapping(value = "TSC30002")
public class TSC30002Controller extends BaseController {


    /**
     * 实例化页面
     *
     * @param model model
     * @return 界面
     * @author xhy
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model,String admin) {
        model.addAttribute("admin",admin);
        return "ds/TSC30002";
    }

    /**
     * 查询页面显示数据
     *
     * @return
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<TSC30002Bean> search() {

        PageResult<TSC30002Bean> bean = new PageResult<TSC30002Bean>();
        List<TSC30002Bean> list = new ArrayList<TSC30002Bean>();
        TSC30002Bean bean1 = new TSC30002Bean();
        bean1.setJsNumber("1");
        bean1.setMoneyAll("100万");
        bean1.setPercentage("20%");
        bean1.setPracticalMoney("20万");
        bean1.setStateHt("已付款");
        TSC30002Bean bean2 = new TSC30002Bean();
        bean2.setJsNumber("2");
        bean2.setMoneyAll("100万");
        bean2.setPercentage("20%");
        bean2.setPracticalMoney("20万");
        bean2.setStateHt("待付款");

        TSC30002Bean bean3 = new TSC30002Bean();
        bean3.setJsNumber("3");
        bean3.setMoneyAll("100万");
        bean3.setPercentage("20%");
        bean3.setPracticalMoney("20万");
        bean3.setStateHt("取消");
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        bean.setData(list);
        bean.setRecordsTotal(list.size());
        return bean;
    }
}
