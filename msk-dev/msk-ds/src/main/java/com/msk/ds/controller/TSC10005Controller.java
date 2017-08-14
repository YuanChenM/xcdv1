package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC10004Bean;
import com.msk.ds.bean.TSC1000501Bean;
import com.msk.ds.bean.TSC1000502Bean;
import com.msk.ds.bean.TSC1000503Bean;
import com.msk.ds.logic.TSC10004Logic;
import com.msk.ds.logic.TSC10005Logic;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author pxg
 */
@Controller
@RequestMapping(value = "TSC10005")
public class TSC10005Controller extends BaseController {

    @Autowired
    private TSC10005Logic tsc10005Logic;
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
        //查询合同信息
        List<TSC1000501Bean> list=tsc10005Logic.queryData();
        //查询交货计划
        List<TSC1000503Bean> listTwo=tsc10005Logic.queryDataTwo();
        //查询合同包材信息
        List<TSC1000502Bean> listThree=tsc10005Logic.queryThree();
        model.addAttribute("listData",list);
        model.addAttribute("listDataTwo",listTwo);
        model.addAttribute("listThree",listThree);
        return "ds/TSC10005";
    }
}
