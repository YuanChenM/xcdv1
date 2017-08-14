package com.msk.so.controller;


import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151410Bean;
import com.msk.so.bean.SO151410Param;
import com.msk.so.logic.SO151410Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjiaju
 * @version 创建时间：20160713
 */

@Controller
@RequestMapping("SO151410")
public class SO151410Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO151410Controller.class);

    @Autowired
    private SO151410Logic so151410Logic;


    /**
     * 发货单详情页面
     * 
     * @param orderId 订单编号
     * @param model Model
     * @return 发货单详情页面
     */
    @RequestMapping(value = "init/{orderId}", method = RequestMethod.POST)
    public String init(@PathVariable("orderId") String orderId, Model model) {
        logger.debug("发货单详情页面初始化");
        List<SO151410Bean> so151410Beans = this.so151410Logic.findOrderShipInfo(orderId);
        model.addAttribute("so151410Beans", so151410Beans);
        model.addAttribute("orderId", orderId);
        return "so/SO151410";
    }

    
    /**
     * 发货单取消
     *
     * @param param
     * @return 发货单详情页面
     */
    @RequestMapping(value = "cancel",method = RequestMethod.POST)
    public String cancel(SO151410Param param, Model model){
        logger.debug("发货单取消");
        super.setCommonParam(param);
        param.setFilter("cancelManName", super.getLoginUser().getEmplName());
        this.so151410Logic.cancel(param);
        return this.init(param.getOrderId().toString(), model);
    }
}
