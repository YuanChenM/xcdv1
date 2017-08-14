package com.msk.ds.controller;

import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC1000501Bean;
import com.msk.ds.bean.TSC1000502Bean;
import com.msk.ds.bean.TSC1000503Bean;
import com.msk.ds.logic.TSC10005Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 市场需求审核注册修改添加controller
 *
 * @author pxg
 */
@Controller
@RequestMapping(value = "TSC10006")
public class TSC10006Controller extends BaseController {

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
        return "ds/TSC10006";
    }
}
