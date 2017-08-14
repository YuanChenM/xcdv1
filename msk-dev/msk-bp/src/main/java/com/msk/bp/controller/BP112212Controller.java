package com.msk.bp.controller;

import com.msk.bp.bean.BP112211Bean;
import com.msk.bp.bean.BP112211Param;
import com.msk.bp.bean.BP112212Bean;
import com.msk.bp.bean.BP112212Param;
import com.msk.bp.logic.BP112211Logic;
import com.msk.bp.logic.BP112212Logic;
import com.msk.common.bean.PriceCycle;
import com.msk.common.utils.PriceCycleUtils;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 
 * 美侍客卖家产品报价
 *
 * @author liu_tao2
 */

@Controller
@RequestMapping("BP112212")
public class BP112212Controller extends BaseController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BP112212Controller.class);

    @Autowired
    private BP112212Logic bp112212Logic ;

    @Autowired
    private com.msk.bp.logic.BP112211Logic BP112211Logic;

    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model,BP112211Param bp112211Param) {

        logger.info("美侍客卖家产品报价初始化开始");

        //得到tab展示所需要的数据
        List<BP112212Bean> bp112212BeanList = bp112212Logic.getSellerQuotationDetailList(bp112211Param);

        model.addAttribute("bp112211Param",bp112211Param);
        model.addAttribute("bp112212BeanList",bp112212BeanList);

        logger.info("美侍客卖家产品报价初始化结束");
        return "bp/BP112212";
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(BP112212Param param,Model model)
    {
        Date dateNow = DateTimeUtil.getCustomerDate();
        //TODO
        PriceCycle priceCycle = PriceCycleUtils.getNextPriceCycle(dateNow, NumberConst.IntDef.INT_ZERO);

        BaseParam baseParam = new BaseParam();
        super.setCommonParam(baseParam);
        String loginId = baseParam.getActId();

        param.setUpdId(loginId);
        bp112212Logic.saveSellerQuotationInfo(param);

        List<BP112211Bean> districtList = new ArrayList<>();
        districtList = BP112211Logic.findDistrictNameList();
        model.addAttribute("districtList",districtList);
        model.addAttribute("startDate", priceCycle.getStartDate());
        model.addAttribute("endDate",priceCycle.getEndDate());
        model.addAttribute("dayAmount",priceCycle.getDayAmount());
        model.addAttribute("cycleCode",priceCycle.getCycleCode());
        model.addAttribute("loginId", loginId);
        return "bp/BP112211";
    }
}
