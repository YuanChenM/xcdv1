package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO153203Bean;
import org.slf4j.Logger;
import com.msk.so.logic.SO153203Logic;
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
@RequestMapping("SO153203")
public class SO153203Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO153203Controller.class);
    @Autowired
    private SO153203Logic SO153203Logic;

    /**
     * 买家-交易记录详情
     *
     * @return String
     **/
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(BasePageParam param, Model model) {
        logger.debug("初始化页面");
        SO153203Bean SO153203Bean = this.SO153203Logic.findOne();
        model.addAttribute("SO153203Bean", SO153203Bean);
        return "so/SO153203";
    }
}
