package com.msk.so.controller;

import com.msk.common.consts.StatusConst;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.entity.SoOrderRelation;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.bean.SO151401Bean;
import com.msk.so.bean.SO151402Bean;
import com.msk.so.bean.order.BaseOrderStatusParam;
import com.msk.so.logic.SO151401Logic;
import com.msk.so.logic.SO151402Logic;
import com.msk.so.logic.SO151404Logic;
import com.msk.so.logic.order.OrderStatusHandle;
import com.msk.so.orderstatus.OrderStatusContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("SO151404")
public class SO151404Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO151404Controller.class);

    @Autowired
    private SO151404Logic so151404Logic;

    /**
     *  订单明细修改页面
     * 
     * @param orderDetailId 订单明细id
     * @param model Model
     * @return 订单明细修改页面
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(@RequestParam(value = "orderDetailId",
            required = false) String orderDetailId,@RequestParam(value = "orderId",
            required = false) String orderId, Model model) {
        logger.debug("订单明细详细信息");
        BaseParam param = new BaseParam();
        param.setFilter("orderDetailId",orderDetailId);
        model.addAttribute("orderId",orderId);
        model.addAttribute("orderDetailId",orderDetailId);
        SoOrderDetail orderDetail = this.so151404Logic.findOne(param);
        model.addAttribute("orderDetail",orderDetail);
        return "so/SO151404";
    }

    @RequestMapping(value = "save",
            method = RequestMethod.POST)
    public String save(SoOrderDetail orderDetail, Model model) {
        BaseParam param = new BaseParam();
        super.setCommonParam(param);
        orderDetail.setUpdId(param.getUpdId());
        orderDetail.setUpdTime(DateTimeUtil.getCustomerDate());
        Long id = this.so151404Logic.modifyOrderAmount(orderDetail);
        model.addAttribute("orderId", id);
        return "so/SO151402";
    }
}
