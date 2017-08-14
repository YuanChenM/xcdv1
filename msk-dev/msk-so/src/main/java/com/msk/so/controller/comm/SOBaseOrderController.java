package com.msk.so.controller.comm;

import java.text.ParseException;
import java.util.List;

import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151402Bean;
import com.msk.so.logic.SO151402Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msk.core.bean.BaseParam;
import com.msk.so.bean.BaseOrder;

/**
 * 订单基本信息Controller
 * 
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("so/baseorder")
public class SOBaseOrderController extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SOBaseOrderController.class);
    /** OM141102Logic */
    @Autowired
    private SO151402Logic so151402Logic;

    /**
     * 加载订单基础信息数据
     * 
     * @param orderId 订单ID
     * @param model Model
     * @return 订单基础数据页面
     * @throws ParseException 
     */
    @RequestMapping(value = "init/{orderId}",
        method = RequestMethod.POST)
    public String init(@PathVariable("orderId") String orderId, Model model) throws ParseException {
        logger.debug("加载订单基础信息数据");
        BaseOrder baseOrder = new BaseOrder();
        if (isDebug) {
            logger.debug("加载订单基础信息数据---假数据");
            baseOrder = this.so151402Logic.getBaseOrder();
        }else{
            BaseParam param = new BaseParam();
            param.setFilter("orderId", orderId);
            baseOrder = so151402Logic.queryBaseOrderByOrderId(param);
        }
        model.addAttribute("baseOrder", baseOrder);
        List<SO151402Bean> so151402BeanList=this.so151402Logic.findChildOrder(orderId);
        model.addAttribute("so151402BeanList", so151402BeanList);
        return "/so/comm/OM_BASE_ORDER_INFO";
    }
}
