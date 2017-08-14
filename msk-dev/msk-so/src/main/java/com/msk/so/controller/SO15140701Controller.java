
package com.msk.so.controller;

import com.msk.core.bean.BaseParam;
import com.msk.core.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.msk.so.logic.SO151407Logic;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * OM14110201Controller.
 * 
 * @author xhy
 */
@Controller
@RequestMapping("so/SO15140701")
public class SO15140701Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SO15140701Controller.class);

    @Autowired
    private SO151407Logic so151407Logic;

    /**
     * 修改订单明细信息
     * 
     * @param model Model 页面模型对象
     * @return 订单明细显示页面
     * 
     * @author xhy
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(@RequestParam(value = "pdCode",required = false) String pdCode,
                       @RequestParam(value = "pdName",required = false) String pdName,
                       @RequestParam(value = "returnQty",required = false) BigDecimal returnQty,
                       @RequestParam(value = "returnId",required = false) String returnId,
                       @RequestParam(value = "orderId",required = false) String orderId,
                       @RequestParam(value = "returnDetailId",required = false) String returnDetailId,Model model) {

        logger.info("修改退货详细页面初始化");
        model.addAttribute("pdCode", pdCode);
        model.addAttribute("pdName", pdName);
        model.addAttribute("returnQty", returnQty);
        model.addAttribute("returnDetailId", returnDetailId);
        model.addAttribute("returnId", returnId);
        model.addAttribute("orderId", orderId);

        return "/so/SO15140701";

    }


    /**
     * 修改退货单明细数量
     * @param returnDetailId
     * @param returnQty
     * @return
     */
    @RequestMapping(value = "save",
        method = RequestMethod.POST)
    @ResponseBody
    public int save(@RequestParam(value = "returnDetailId",required = false) String returnDetailId,@RequestParam(value = "returnQty",required = false) BigDecimal returnQty) {
        BaseParam param = new BaseParam();
        super.setCommonParam(param);
        int updateFlg = so151407Logic.updateDetailQty(returnDetailId,returnQty, param.getUpdId());
        return updateFlg;
    }

}
