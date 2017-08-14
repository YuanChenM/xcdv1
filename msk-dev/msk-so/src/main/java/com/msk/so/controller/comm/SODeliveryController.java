package com.msk.so.controller.comm;

import com.msk.core.consts.StringConst;
import com.msk.core.entity.SoDeliver;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.ISO151402SoDeliver;
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
import com.msk.so.bean.OrderDeliveryBean;

import java.util.List;

/**
 * 订单配送信息
 * 
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("so/delivery")
public class SODeliveryController extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SODeliveryController.class);
    /** OM141102Logic */
    @Autowired
    private SO151402Logic so151402Logic;

    /**
     * 加载订单配送信息数据
     * 
     * @param orderId 订单ID
     * @param model Model
     * @return 订单配送数据页面
     */
    @RequestMapping(value = "init/{orderId}",
        method = RequestMethod.POST)
    public String init(@PathVariable("orderId") String orderId, Model model) {
        logger.debug("加载订单配送信息数据");
        OrderDeliveryBean orderDelivery = new OrderDeliveryBean();
        if (isDebug) {
            orderDelivery = this.so151402Logic.getOrderDelivery();
        }else{
            BaseParam param = new BaseParam();
            param.setFilter("orderId", orderId);
            orderDelivery = this.so151402Logic.queryOrderDeliveryByOrderId(param);
            // 设置习惯正常收货时间段
            StringBuilder receiveTimeResult = new StringBuilder();
            String[] receiveTimeArray = orderDelivery.getReceiveTime().split(StringConst.COMMA);
            param.setFilterObject("receiveTime", receiveTimeArray);
            List<OrderDeliveryBean> orderDeliveryBeanList =  this.so151402Logic.queryReceiveTime(param);
            for (OrderDeliveryBean orderDeliveryBean : orderDeliveryBeanList){
                receiveTimeResult.append(orderDeliveryBean.getReceiveTime()).append(StringConst.BLANK);
            }
            orderDelivery.setReceiveTime(receiveTimeResult.toString());
        }
        model.addAttribute("orderDelivery", orderDelivery);
        return "/so/comm/OM_DELIVERY_INFO";
    }


    /**
     *
     * @param orderId
     * @param model
     * @return
     */
    @RequestMapping(value = "actual/init/{orderId}",
            method = RequestMethod.POST)
    public String actualDeliveryInit(@PathVariable("orderId") String orderId, Model model) {
        logger.debug("实际订单配送信息数据");
      List<ISO151402SoDeliver>delivers= this.so151402Logic.findOrderDeliver(orderId);
        model.addAttribute("delivers", delivers);
        return "/so/comm/OM_DELIVERY_ACTUAL_INFO";
    }




}
