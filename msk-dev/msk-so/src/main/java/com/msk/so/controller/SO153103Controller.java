package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO153103Bean;
import org.slf4j.Logger;
import com.msk.so.logic.SO153103Logic;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 买家-交易记录详情
 * @author chen_xin
 * @version 1.0
 **/
@Controller
@RequestMapping("SO153103")
public class SO153103Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO153103Controller.class);
    @Autowired
    private SO153103Logic sO153103Logic;

    /**
     * 买家-交易记录详情
     *
     * @return String
     **/
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(BasePageParam param, Model model) {
        logger.debug("初始化页面");
        SO153103Bean sO153103Bean = this.sO153103Logic.findOne();
        model.addAttribute("sO153103Bean", sO153103Bean);
        return "so/SO153103";
    }
}
