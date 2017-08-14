package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO153204Bean;
import org.slf4j.Logger;
import com.msk.so.logic.SO153204Logic;
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
@RequestMapping("SO153204")
public class SO153204Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO153204Controller.class);
    @Autowired
    private SO153204Logic SO153204Logic;

    /**
     * 买家-电子对账单-支出
     *
     * @return String
     **/
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(BasePageParam param, Model model) {
        logger.debug("初始化页面");
        List<SO153204Bean> list = this.SO153204Logic.findSO153204List();
        model.addAttribute("list", list);
        return "so/SO153204";
    }
}
