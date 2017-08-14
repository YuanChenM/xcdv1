package com.msk.ds.controller;

import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC10001Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by air on 2016/6/8.
 */
@Controller
@RequestMapping("TSC10003")
public class TSC10003Controller extends BaseController{

    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(TSC10001Bean tsc10001Bean,Model model) {

        return "ds/TSC10003";
    }
}
