package com.msk.so.controller;

import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151402Bean;
import com.msk.so.bean.SO15140701Bean;
import com.msk.so.logic.SO151402Logic;
import com.msk.so.logic.SO151407Logic;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * OM141107Controller
 * 退货单明细
 *
 * @author jiang_nan
 * @version 1.0
 */
@Controller
@RequestMapping("SO151407")
public class SO151407Controller extends BaseController {
    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(SO151407Controller.class);

    @Autowired
    private SO151407Logic SO151407Logic;
    @Autowired
    private SO151402Logic so151402Logic;

    /**
     * 退货订单明细
     *
     * @param returnId 退货单id
     * @param orderId  订单id
     * @param mv       模型
     * @return string 订单明细页面
     * @author xhy
     */
    @RequestMapping(value = "init/{returnId}", method = RequestMethod.POST)
    public String init(@PathVariable(value = "returnId") String returnId, @RequestParam(value = "orderId",
            required = false) String orderId, Model mv) {
        if (StringUtils.isNotBlank(orderId)) {
            logger.info("查询订单明细");
            List<SO151402Bean> detailList = so151402Logic.findOrderDetailInfo(orderId);
            BigDecimal orderAllMoney = BigDecimal.ZERO;
            for (SO151402Bean so151402Bean : detailList) {
                so151402Bean.setOneAllMoney(so151402Bean.getOrderQty().multiply(so151402Bean.getPdPrice()));
                orderAllMoney = orderAllMoney.add(so151402Bean.getOneAllMoney());
            }
            mv.addAttribute("detailList", detailList);
            mv.addAttribute("orderAllMoney", orderAllMoney);

        }
        if (StringUtils.isNotBlank(returnId)) {
            logger.info("查询退货单明细");
            List<SO15140701Bean> returnGoodsList = this.SO151407Logic.findOM14110704ListGoods(returnId);
            mv.addAttribute("returnGoodsList", returnGoodsList);
            mv.addAttribute("returnId", returnId);
            mv.addAttribute("orderId", orderId);
            if (!CollectionUtils.isEmpty(returnGoodsList)) {
                mv.addAttribute("returnCode", returnGoodsList.get(0).getReturnCode());
            }
        }
        return "so/SO151407";
    }
}
