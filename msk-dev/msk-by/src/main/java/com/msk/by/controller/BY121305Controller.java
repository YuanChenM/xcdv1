package com.msk.by.controller;

import com.msk.by.logic.BY121305Logic;
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
 * 批发市场详细画面编辑
 *
 * @author zhou_ling
 */
@Controller
@RequestMapping("BY121305")
public class BY121305Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BY121305Controller.class);

    @Autowired
    private BY121305Logic by121305Logic;

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
        public String init(@RequestParam(value = "terMarketId", required = false) String terMarketId,
                @RequestParam(value = "type", required = true) String type, Model model) {
        logger.debug("批发市场详细画面编辑");
        ByMarketTerminal byMarketTerminal = new ByMarketTerminal();
        if("edit".equals(type)){
            // 批发市场修改
            byMarketTerminal = by121305Logic.findMarketTerminal(terMarketId);
        }
        model.addAttribute("terMarketId",terMarketId);
        model.addAttribute("byMarketTerminal",byMarketTerminal);
        //查询所有物流区
        List<MdLogisticsArea> logisticsAreaList = DistrictAreaUtils.getLogisticsAreaList();
        //查询指定物流区中的城市
        List<MdCity> cityList = DistrictAreaUtils.getCityListInLogisticsAreas(byMarketTerminal.getLgcsAreaCode());
        //查询指定城市中的区县
        List<MdDistrict> districtList = DistrictAreaUtils.getDistrictList(byMarketTerminal.getCityCode());
        //批发市场级别
        List<CommConstant> marketLevelList = commonLogic.findConstantList("MarketLevel");

        model.addAttribute("logisticsAreaList",logisticsAreaList);
        model.addAttribute("cityList",cityList);
        model.addAttribute("districtList",districtList);
        model.addAttribute("marketLevelList", marketLevelList);

        return "by/BY121305";
    }

    /**
     * 批发市场详细画面编辑保存
     * @param byMarketTerminal byMarketTerminal
     * @return
     */
    @RequestMapping(value = "save",
            method = RequestMethod.POST)
    public String byMarketTerminalSave(ByMarketTerminal byMarketTerminal, HttpServletResponse response, HttpServletRequest request) throws IOException{

        String terMarketId = byMarketTerminal.getTerMarketId();
        if(StringUtil.isEmpty(terMarketId)){
            terMarketId = UUID.randomUUID().toString();
            byMarketTerminal.setTerMarketId(terMarketId);
            // 批发市场详细画面新增保存
            by121305Logic.byMarketTerminalAdd(byMarketTerminal);
        } else {
            // 批发市场详细画面编辑保存
            by121305Logic.byMarketTerminalModify(byMarketTerminal);
        }
        return "by/BY121301";
    }
}

