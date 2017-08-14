package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO153202Bean;
import com.msk.so.bean.SO153301Bean;
import com.msk.so.logic.SO153302Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.msk.so.bean.SO153302Bean;

/**
 *
 * 收支平衡管理
 *
 * @author zhou_ling
 * @version 1.0
 **/
@Controller
@RequestMapping("SO153302")
public class SO153302Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO153302Controller.class);
    @Autowired
    private SO153302Logic sO153302Logic;

    /**
     * 买手订单详细信息初始化方法
     * @param param
     * @param model
     * @param orderCode
     * @return
     */
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(BasePageParam param, Model model,@RequestParam(value = "orderCode", required = false) String orderCode) {
        logger.debug("初始化页面");
        param.getFilterMap().put("orderCode", orderCode);

        SO153302Bean so153302Bean = sO153302Logic.findSO153302One(param);

        model.addAttribute("sO153302Bean",so153302Bean);
        model.addAttribute("orderCode", orderCode);
        return "so/SO153302";
    }

    /**
     * 买手订单详细信息
     * @param param
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SO153302Bean> search(BasePageParam param,Model model) {

        logger.info("获取买手交易记录");
        return sO153302Logic.findSo153302List(param);
    }

}
