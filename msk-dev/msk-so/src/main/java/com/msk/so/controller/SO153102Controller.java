package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO153102Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.msk.so.logic.SO153102Logic;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *买家订单详情
 * @author chen_xin
 * @version 1.0
 **/
@Controller
@RequestMapping("SO153102")
public class SO153102Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO153102Controller.class);

    @Autowired
    private SO153102Logic so153102Logic;

    /**
     * 买家订单详细信息初始化方法
     * @param param
     * @param model
     * @param orderCode
     * @return
     */
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(BasePageParam param, Model model,@RequestParam(value = "orderCode", required = false) String orderCode) {
        logger.debug("初始化页面");

        param.getFilterMap().put("orderCode", orderCode);

        SO153102Bean sO153102Bean = so153102Logic.findSO153102One(param);

        model.addAttribute("sO153102Bean",sO153102Bean);
        model.addAttribute("orderCode", orderCode);

        return "so/SO153102";
    }

    /**
     *买家订单详情页面展示方法
     * @param param
     * @param model
     * @return PageResult<SO153102Bean>
     */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public @ResponseBody
    PageResult<SO153102Bean> search(BasePageParam param,Model model)
    {
        logger.debug("买家订单详情");
        return so153102Logic.findSO153102List(param);
    }
}
