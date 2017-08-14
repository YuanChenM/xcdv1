package com.msk.ds.controller;

import com.msk.core.web.base.BaseController;
import com.msk.ds.logic.DS173213Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * DS173212Controller
 *
 * @author zhou_yajun
 *
 */
@Controller
@RequestMapping("DS173213")
public class DS173213Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS173213Controller.class);

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model) {

        return "ds/DS173213";
    }
}
