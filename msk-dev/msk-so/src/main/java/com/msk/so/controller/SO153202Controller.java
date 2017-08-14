package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO153202Param;
import com.msk.so.bean.SO153202Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.msk.so.logic.SO153202Logic;

/**
 *买家-支付明细
 * @author chen_xin
 * @version 1.0
 **/
@Controller
@RequestMapping("SO153202")
public class SO153202Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO153202Controller.class);
    @Autowired
    private SO153202Logic so153202Logic;

    /**
     * 卖家订单详细信息初始化方法
     * @param pageParam
     * @param model
     * @param orderCode
     * @return
     */
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(BasePageParam pageParam, Model model,@RequestParam(value = "orderCode", required = false) String orderCode) {
        pageParam.getFilterMap().put("orderCode", orderCode);

        SO153202Param so153202Param = so153202Logic.findSO153202One(pageParam);

        model.addAttribute("so153202Param",so153202Param);
        model.addAttribute("orderCode", orderCode);
        logger.debug("初始化页面");
        return "so/SO153202";
    }


    /**
     * 卖家订单详细信息查询方法
     * @param pageParam
     * @param model
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SO153202Bean> search(BasePageParam pageParam,Model model) {
        logger.info("获取卖家交易记录");

        return so153202Logic.findSO153202List(pageParam);
    }
}
