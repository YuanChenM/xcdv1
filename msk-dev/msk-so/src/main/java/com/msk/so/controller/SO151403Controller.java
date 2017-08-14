
package com.msk.so.controller;

import com.msk.core.bean.BaseParam;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.so.logic.SO151403Logic;

/**
 * OM14110201Controller.
 *
 * @author rwf
 */
@Controller
@RequestMapping("SO151403")
public class SO151403Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SO151403Controller.class);

    @Autowired
    private SO151403Logic SO151403Logic;

    /**
     * 修改订单明细信息
     * 
     * @param orderDetailAvailabilityId 订单明细供应商ID
     * @param model Model
     * @return 订单明细显示页面
     * @author xhy
     * update gyh
     * updateTime gyh
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(@RequestParam(value = "orderDetailAvailabilityId",
        required = false) String orderDetailAvailabilityId, Model model) {
        logger.debug("加载订单明细供应商数据");
        SoOrderDetailAvailability soOrderDetailAvailability = new SoOrderDetailAvailability();
        if (isDebug) {
            soOrderDetailAvailability = SO151403Logic.getDetailAvailability();
        } else {
            soOrderDetailAvailability = this.SO151403Logic.findOneAvailability(orderDetailAvailabilityId);
        }
        model.addAttribute("soOrderDetailAvailability", soOrderDetailAvailability);
        return "so/SO151403";
    }

    /**
     * 
     * 订单修改操作
     *
     * @param soOrderDetailAvailability 订单明细供应商id
     * @param model model
     * @author hxy
     * @return OM141108页面
     *         update gyh
     *         updateTime 2016.1.6
     */
    @RequestMapping(value = "save",
        method = RequestMethod.POST)
    public String save(SoOrderDetailAvailability soOrderDetailAvailability, Model model) {
        BaseParam param = new BaseParam();
        super.setCommonParam(param);
        soOrderDetailAvailability.setUpdId(param.getUpdId());
        soOrderDetailAvailability.setUpdTime(DateTimeUtil.getCustomerDate());
        model.addAttribute("orderId", soOrderDetailAvailability.getOrderId());
        this.SO151403Logic.modifyOrder(soOrderDetailAvailability);
        return "so/SO151402";
    }
}
