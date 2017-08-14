package com.msk.so.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.msk.common.consts.StatusConst;
import com.msk.core.bean.BaseParam;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151411Bean;
import com.msk.so.logic.SO151411Logic;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * 申请退货页面Controller
 * @author sunjiaju
 * @version 创建时间：20160929
 */

@Controller
@RequestMapping("SO151411")
public class SO151411Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO151411Controller.class);

    @Autowired
    private SO151411Logic so151411Logic;


    /**
     * 申请退货页面初始化
     *
     * @param orderId 订单编号
     * @param model   Model
     * @return 申请退货页面初始化
     */
    @RequestMapping(value = "init/{orderId}", method = RequestMethod.POST)
    public String init(@PathVariable("orderId") String orderId, Model model) {
        logger.debug("申请退货页面初始化");
        List<SO151411Bean> so151411Beans = this.so151411Logic.findReturnList(orderId);
        // MODIFY for Bug#3358 at 2016/10/17 by sun_jiaju Start
        boolean allReturn = true;
        if (CollectionUtils.isNotEmpty(so151411Beans)){
            for(SO151411Bean so151411Bean : so151411Beans){
                if (StatusConst.OrderDetailAvailabilityStatusDef.ALL_RETURN != so151411Bean.getStatus()){
                    allReturn = false;
                }
            }
        }
        model.addAttribute("so151411Beans", so151411Beans);
        model.addAttribute("orderId", orderId);
        model.addAttribute("allReturn", allReturn);
        // MODIFY for Bug#3358 at 2016/10/17 by sun_jiaju End
        return "so/SO151411";
    }


    /**
     * 申请退货处理
     *
     * @param jsonStr
     * @param orderId
     * @param returnMode
     */
    @RequestMapping(value = "return", method = RequestMethod.POST)
    public String returnOrder(Model model, String jsonStr, String orderId, String returnMode) {
        BaseParam baseParam = new BaseParam();
        super.setCommonParam(baseParam);
        Map<String, SO151411Bean> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, SO151411Bean>>() {
        });
        so151411Logic.returnOrder(map.values(), baseParam, returnMode);
        return this.init(orderId, model);
    }
}
