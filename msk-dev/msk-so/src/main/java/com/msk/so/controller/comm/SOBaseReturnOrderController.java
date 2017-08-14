package com.msk.so.controller.comm;

import com.msk.core.web.base.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msk.so.bean.BaseReturnOrder;
import com.msk.so.logic.OMBaseReturnOrderLogic;

/**
 * 退货单基本信息Controller
 * 
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("so/returnOrder")
public class SOBaseReturnOrderController extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SOBaseReturnOrderController.class);
    /** OM141102Logic */
    @Autowired
    private OMBaseReturnOrderLogic oMBaseReturnOrderLogic;

    /**
     * 返回退货订单数据
     * 
     * @param returnId 退货订单id
     * @param model 页面数据
     * @return string 订单基础数据页面
     * @author xhy
     */
    @RequestMapping(value = "init/{returnId}",
        method = RequestMethod.POST)
    public String init(Model model, @PathVariable("returnId") String returnId) {
        logger.debug("加载订单基础信息数据");
        if (isDebug) {
            logger.debug("加载订单基础信息数据");
            BaseReturnOrder returnOrder = this.oMBaseReturnOrderLogic.getBaseReturnOrder();
            model.addAttribute("returnOrder", returnOrder);
            return "/so/comm/OM_BASE_RETURN_ORDER_INFO";
        }
        if (StringUtils.isNotBlank(returnId)) {
            logger.debug("加载订单基础信息数据DB");
            BaseReturnOrder returnOrder = oMBaseReturnOrderLogic.findoMBaseReturnOrder(returnId);
            if (returnOrder != null) {
                model.addAttribute("returnOrder", returnOrder);
                return "/so/comm/OM_BASE_RETURN_ORDER_INFO";
            }
        }
        return "/so/comm/OM_BASE_RETURN_ORDER_INFO";
    }
}
