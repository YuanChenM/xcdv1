package com.msk.by.controller;

import com.msk.by.logic.BY121306Logic;
import com.msk.common.logic.CommonLogic;
import com.msk.core.entity.*;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.md.utils.DistrictAreaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 菜场详细画面编辑
 *
 * @author zhou_ling
 */
@Controller
@RequestMapping("BY121306")
public class BY121306Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BY121306Controller.class);

    @Autowired
    private BY121306Logic by121306Logic;

    @Autowired
    private CommonLogic commonLogic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
        @RequestMapping(value = "init",
                method = RequestMethod.POST)
        public String init(@RequestParam(value = "fodMarketId", required = false) String fodMarketId,
                @RequestParam(value = "type", required = true) String type, Model model) {
        logger.debug("菜场详细画面编辑");
        ByMarketFood byMarketFood = new ByMarketFood();
        if("edit".equals(type)){
            byMarketFood = by121306Logic.findMarketFood(fodMarketId);
        }
        model.addAttribute("fodMarketId",fodMarketId);
        model.addAttribute("byMarketFood",byMarketFood);

        //查询所有物流区
        List<MdLogisticsArea> logisticsAreaList = DistrictAreaUtils.getLogisticsAreaList();
        //查询指定物流区中的城市
        List<MdCity> cityList = DistrictAreaUtils.getCityListInLogisticsAreas(byMarketFood.getLgcsAreaCode());
        //查询指定城市中的区县
        List<MdDistrict> districtList = DistrictAreaUtils.getDistrictList(byMarketFood.getCityCode());
         //菜场类型
        List<CommConstant> marketTypeList = commonLogic.findConstantList("MarketType");
        //菜场地段类型
        List<CommConstant> marketSectionTypeList = commonLogic.findConstantList("MarketSectionType");
        //菜场规模类型
        List<CommConstant> marketSizeTypeList = commonLogic.findConstantList("MarketSizeType");

        model.addAttribute("logisticsAreaList",logisticsAreaList);
        model.addAttribute("cityList",cityList);
        model.addAttribute("districtList",districtList);
        model.addAttribute("marketTypeList", marketTypeList);
        model.addAttribute("marketSectionTypeList", marketSectionTypeList);
        model.addAttribute("marketSizeTypeList", marketSizeTypeList);

        return "by/BY121306";
    }

    /**
     * 菜场详细画面编辑保存
     * @param byMarketFood byMarketFood
     * @return
     */
    @RequestMapping(value = "save",
            method = RequestMethod.POST)
    public String byMarketTerminalSave(ByMarketFood byMarketFood, HttpServletResponse response, HttpServletRequest request) throws IOException{

        String fodMarketIdMarketId = byMarketFood.getFodMarketId();
        if(StringUtil.isEmpty(fodMarketIdMarketId)){
            fodMarketIdMarketId = UUID.randomUUID().toString();
            byMarketFood.setFodMarketId(fodMarketIdMarketId);
            // 菜场详细画面新增保存
            by121306Logic.byMarketFodAdd(byMarketFood);
        } else {
            // 菜场详细画面编辑保存
            by121306Logic.byMarketFoodModify(byMarketFood);
        }
        return "by/BY121302";
    }
}

