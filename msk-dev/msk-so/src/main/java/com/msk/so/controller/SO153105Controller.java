package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO153105Bean;
import org.slf4j.Logger;
import com.msk.so.logic.SO153105Logic;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 买家-电子对账单-收入
 * @author chen_xin
 * @version 1.0
 **/
@Controller
@RequestMapping("SO153105")
public class SO153105Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO153105Controller.class);
    @Autowired
    private SO153105Logic SO153105Logic;

    /**
     * 买家-电子对账单-收入
     *
     * @return String
     **/
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init( Model model) {
        logger.debug("初始化页面");
        List<SO153105Bean> list = this.SO153105Logic.findSO153105List();
        model.addAttribute("list", list);
        return "so/SO153105";
    }
}
