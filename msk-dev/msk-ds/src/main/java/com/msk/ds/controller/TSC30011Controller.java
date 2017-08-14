package com.msk.ds.controller;

import com.msk.core.bean.PageResult;
import com.msk.ds.bean.TSC30011Bean;
import com.msk.ds.logic.TSC30011Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/6/7.
 */
@Controller
@RequestMapping(value = "TSC30011")
public class TSC30011Controller {
    @Autowired
    private TSC30011Logic tsc30011Logic;
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(TSC30011Controller.class);

    @RequestMapping(value = "init", method = RequestMethod.POST)

    public String init(Model model) {
        logger.debug("发票管理列表");
        return "ds/TSC30011";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<TSC30011Bean> search() {
        return this.tsc30011Logic.findList();
    }
}
