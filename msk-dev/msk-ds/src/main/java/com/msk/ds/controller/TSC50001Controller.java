package com.msk.ds.controller;


import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC30001Bean;
import com.msk.ds.bean.TSC50001Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 采购员仓库员查看
 *
 * @author XHY
 */
@Controller
@RequestMapping(value = "TSC50001")
public class TSC50001Controller extends BaseController {


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
        return "ds/TSC50001";
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
    PageResult<TSC50001Bean> search() {

        PageResult<TSC50001Bean> bean = new PageResult<TSC50001Bean>();
        List<TSC50001Bean> list = new ArrayList<TSC50001Bean>();
        TSC50001Bean bean1 = new TSC50001Bean();
        bean1.setId("1");
        bean1.setRole("采购员");
        bean1.setAccount("CG001");
        bean1.setPepName("张玉");

        TSC50001Bean bean2 = new TSC50001Bean();
        bean2.setId("2");
        bean2.setRole("采购员");
        bean2.setAccount("CG002");
        bean2.setPepName("赵宇");

        TSC50001Bean bean3 = new TSC50001Bean();
        bean3.setId("3");
        bean3.setRole("采购员");
        bean3.setAccount("CG003");
        bean3.setPepName("诚诚");

        TSC50001Bean bean4 = new TSC50001Bean();
        bean4.setId("4");
        bean4.setRole("仓库管理员");
        bean4.setAccount("CK001");
        bean4.setPepName("王临空");

        TSC50001Bean bean5 = new TSC50001Bean();
        bean5.setId("5");
        bean5.setRole("仓库管理员");
        bean5.setAccount("CK002");
        bean5.setPepName("张大明");


        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        bean.setRecordsTotal(list.size());
        bean.setData(list);
        return bean;
    }
}
