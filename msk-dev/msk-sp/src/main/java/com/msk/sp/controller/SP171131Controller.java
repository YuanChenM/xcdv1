package com.msk.sp.controller;

import com.msk.common.bean.PriceCycle;
import com.msk.common.utils.PriceCycleUtils;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseController;
import com.msk.sp.bean.SP171131Bean;
import com.msk.sp.bean.SP171131Param;
import com.msk.sp.logic.SP171131Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 美侍客卖家产品库存一览控制层
 * Created by xu_wei on 2016/3/29.
 */
@Controller
@RequestMapping(value = "SP171131")
public class SP171131Controller extends BaseController{

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(SP171131Controller.class);

    @Autowired
    private SP171131Logic SP171131Logic;

    /**
     * 初始化
     * @param param
     * @param model
     * @return
     */
    @RequestMapping(value = "init")
    public String init(SP171131Param param,Model model){
        logger.info("美侍客卖家产品库存一览页面初始化");

        Date dateNow = DateTimeUtil.getCustomerDate();
        //TODO
        PriceCycle priceCycle = PriceCycleUtils.getNextPriceCycle(dateNow, NumberConst.IntDef.INT_ZERO);
        BaseParam param1 = new BaseParam();
        super.setCommonParam(param1);
        String loginId = param1.getActId();

        List<SP171131Bean> districtList = new ArrayList<>();
//        districtList = BP112211Logic.findDistrictNameList();
//        model.addAttribute("districtList",districtList);
        model.addAttribute("startDate", priceCycle.getStartDate());
        model.addAttribute("endDate",priceCycle.getEndDate());
        model.addAttribute("dayAmount",priceCycle.getDayAmount());
        model.addAttribute("cycleCode",priceCycle.getCycleCode());
        model.addAttribute("loginId", loginId);
        return "sp/SP171131";
    }

    /**
     * 分页查询库存报表信息一览
     * @param basePageParam
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    public PageResult<SP171131Bean> search(BasePageParam basePageParam) {
        BaseParam param = new BaseParam();
        super.setCommonParam(param);
        String loginId = param.getActId();
        basePageParam.getFilterMap().put("loginId", loginId);
        logger.info("查询数据库");
        return SP171131Logic.findSP171131List(basePageParam);
    }

}
