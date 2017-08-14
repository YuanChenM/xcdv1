package com.msk.so.controller.comm;

import com.msk.core.web.base.BaseController;
import com.msk.so.bean.OrderReceiveDemandBean;
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
//import com.msk.core.entity.SoOrderBuyers;

/**
 * 订单买家基本信息
 * 
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("so/buyers")
public class SOBuyersController extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SOBuyersController.class);
    /** OM141102Logic */
    @Autowired
    private SO151402Logic so151402Logic;

    /**
     * 加载订单买家信息数据
     * 
     * @param orderId 订单ID
     * @param model Model
     * @return 订单买家数据页面
     */
    @RequestMapping(value = "init/{orderId}",
        method = RequestMethod.POST)
    public String init(@PathVariable("orderId") String orderId, Model model) {
        logger.debug("加载订单买家信息数据");
        OrderReceiveDemandBean orderBuyers = new OrderReceiveDemandBean();
        if (isDebug) {
            orderBuyers = this.so151402Logic.getOrderBuyers();
        } else {
            BaseParam param = new BaseParam();
            param.setFilter("orderId", orderId);
            orderBuyers = so151402Logic.queryOrderBuyersByOrderId(param);
        }
        model.addAttribute("orderBuyers", orderBuyers);
        return "/so/comm/OM_BUYERS_INFO";
    }
}
