package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO153104Bean;
import org.slf4j.Logger;
import com.msk.so.logic.SO153104Logic ;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 买家-电子对账单-支出
 * @author chen_xin
 * @version 1.0
 **/
@Controller
@RequestMapping("SO153104")
public class SO153104Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO153104Controller.class);
    @Autowired
    private SO153104Logic sO153104Logic;

    /**
     * 买家-电子对账单-支出
     *
     * @return String
     **/
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(BasePageParam param, Model model) {
        logger.debug("初始化页面");
        List<SO153104Bean> list = this.sO153104Logic.findSO153104List();
        model.addAttribute("list", list);
        return "so/SO153104";
    }
}
