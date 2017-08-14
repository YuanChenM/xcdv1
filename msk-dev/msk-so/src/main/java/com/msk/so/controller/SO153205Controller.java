package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO153205Bean;
import org.slf4j.Logger;
import com.msk.so.logic.SO153205Logic;
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
@RequestMapping("SO153205")
public class SO153205Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO153205Controller.class);
    @Autowired
    private SO153205Logic SO153205Logic;

    /**
     * 卖家-电子对账单-收入
     *
     * @return String
     **/
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(BasePageParam param, Model model) {
        logger.debug("初始化页面");
        List<SO153205Bean> list = this.SO153205Logic.findSO153205List();
        model.addAttribute("list", list);
        return "so/SO153205";
    }
}
