package com.msk.ds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/6/8.
 */
@Controller
@RequestMapping(value = "TSC30012")
public class TSC30012Controller {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(TSC30012Controller.class);

    @RequestMapping(value = "init", method = RequestMethod.POST)

    public String init(Model model,String admin) {
        model.addAttribute("admin",admin);
        logger.debug("发票确认");
        return "ds/TSC30012";
    }

}
