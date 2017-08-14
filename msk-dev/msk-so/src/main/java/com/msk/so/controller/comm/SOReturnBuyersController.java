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

import com.msk.core.exception.BusinessException;
import com.msk.so.bean.ReturnOrderBuyersBean;
import com.msk.so.logic.OMReturnBuyersLogic;

/**
 * 退货人信息
 * 
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("so/returnBuyers")
public class SOReturnBuyersController extends BaseController {
    /**
     * logger 日志输出
     */
    private static Logger logger = LoggerFactory.getLogger(SOReturnBuyersController.class);
    /** OM141102Logic */
    @Autowired
    private OMReturnBuyersLogic oMReturnBuyersLogic;

    /**
     * 根据退货人id查询退货人信息
     * 
     * @param returnId 订单id
     * @param model Model
     * @return String 退货人详细信息
     * @author xhy
     */
    @RequestMapping(value = "init/{returnId}",
        method = RequestMethod.POST)
    public String init(Model model, @PathVariable("returnId") String returnId) {
        if (isDebug) {
            logger.debug("加载订单买家信息数据,假数据");
            ReturnOrderBuyersBean returnOrderBuyer = this.oMReturnBuyersLogic.getReturntOrderBuyers();
            model.addAttribute("returnOrderBuyer", returnOrderBuyer);
            return "/so/comm/OM_RETURN_BUYERS_INFO";
        }
        if (StringUtils.isNoneEmpty(returnId)) {
            logger.debug("加载订单买家信息数据DB");
            ReturnOrderBuyersBean returnOrderBuyer = this.oMReturnBuyersLogic.findOneReturntOrderBuyers(returnId);
            if (returnOrderBuyer == null) {
                throw new BusinessException("退货人信息查询失败,退货id:" + returnId);
            }
            model.addAttribute("returnOrderBuyer", returnOrderBuyer);
            return "/so/comm/OM_RETURN_BUYERS_INFO";
        }
        return null;
    }
}
