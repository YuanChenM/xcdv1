/**
 * OMReturnReceiveController.java
 *
 * @screen
 * @author rwf
 */
package com.msk.so.controller.comm;

import com.msk.core.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msk.so.bean.ReturnReceiveBean;
import com.msk.so.logic.OMReturnReceiveLogic;

/**
 * 退货单物流收货信息
 * 
 * @author rwf
 */
@Controller
@RequestMapping("so/ReturnReceive")
public class SOReturnReceiveController extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SOReturnReceiveController.class);
    /** OM141102Logic */
    @Autowired
    private OMReturnReceiveLogic omReturnReceiveLogic;

    /**
     * 加载订单基础信息数据
     * @param orderId 订单id
     * @param model Model
     * @return 订单基础数据页面
     */
    @RequestMapping(value = "init/{orderId}",
        method = RequestMethod.POST)
    public String init(Model model,@PathVariable("orderId")String orderId) {
        logger.debug("加载退货单物流收货信息数据");
        ReturnReceiveBean returnReceiveBean = this.omReturnReceiveLogic.getReturnReceive();
        model.addAttribute("returnReceiveBean", returnReceiveBean);
        return "/so/comm/OM_RETURN_RECEIVE";
    }
}