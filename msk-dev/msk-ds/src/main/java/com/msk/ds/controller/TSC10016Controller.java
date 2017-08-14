package com.msk.ds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "TSC10016")
public class TSC10016Controller {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(TSC10016Controller.class);

    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init() {
        logger.debug("付款详细");
        return "ds/TSC10016";
    }

}