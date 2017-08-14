package com.msk.bp.controller;

import com.msk.bp.bean.BP112212Param;
import com.msk.common.bean.PriceCycle;
import com.msk.common.consts.CommCodeMasterConst;
import com.msk.common.utils.PriceCycleUtils;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.bp.bean.BP112211Bean;
import com.msk.bp.logic.BP112211Logic;
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
 * Created by yang_chunyan on 2016/3/29.
 */
@Controller
@RequestMapping(value = "BP112211")
public class BP112211Controller extends BaseController{

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(BP112211Controller.class);

    @Autowired
    private BP112211Logic BP112211Logic;

    /**
     * 初始化
     * @param param
     * @param model
     * @return
     */
    @RequestMapping(value = "init")
    public String init(BP112212Param param,Model model){
        logger.info("美侍客卖家产品库存一览页面初始化");

        Date dateNow = DateTimeUtil.getCustomerDate();
        //TODO
        PriceCycle priceCycle = PriceCycleUtils.getNextPriceCycle(dateNow, NumberConst.IntDef.INT_ZERO);
        BaseParam param1 = new BaseParam();
        super.setCommonParam(param1);
        String loginId = param1.getActId();

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

    /**
     * 分页查询库存报表信息一览
     * @param basePageParam
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    public PageResult<BP112211Bean> search(BasePageParam basePageParam) {
        BaseParam param = new BaseParam();
        super.setCommonParam(param);
        if(CommCodeMasterConst.LoginUserType.SELLER.equals(param.getUserType())){
            String loginId = param.getActId();
            basePageParam.getFilterMap().put("loginId", loginId);
        }
        logger.info("查询数据库");
        return BP112211Logic.findBP112211BeansList(basePageParam);
    }

}
