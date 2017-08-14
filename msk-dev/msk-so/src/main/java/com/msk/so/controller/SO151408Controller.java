package com.msk.so.controller;

import com.msk.common.logic.CityLogic;
import com.msk.common.logic.DistrictLogic;
import com.msk.common.logic.LogisticsAreaLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.MdCity;
import com.msk.core.entity.MdDistrict;
import com.msk.core.entity.MdLogisticsArea;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151408Bean;
import com.msk.so.bean.SO151408Param;
import com.msk.so.logic.SO151408Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * SO151408Controller
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("SO151408")
public class SO151408Controller extends BaseController{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SO151408Controller.class);
    @Autowired
    private LogisticsAreaLogic logisticsAreaLogic;
    @Autowired
    private CityLogic cityLogic;
    @Autowired
    private DistrictLogic districtLogic;
    @Autowired
    private SO151408Logic SO151408Logic;

    /**
     * 根据订单编号,进行新增或者修改
     * @param orderId
     * @param model
     * @return
     */
    @RequestMapping("init/{orderId}")
    public String init(@PathVariable("orderId") String orderId, Model model){
        SO151408Bean SO151408Bean = null;
        if("-1".equals(orderId)){
            logger.debug("订单新增Case");
            SO151408Bean = new SO151408Bean();
        }
        BaseParam param = new BaseParam();
        List<MdLogisticsArea> logisticsAreaList = this.logisticsAreaLogic.findList(param);
        List<MdCity> cityList = null;
        if(!CollectionUtils.isEmpty(logisticsAreaList)){
            MdLogisticsArea logisticsArea = logisticsAreaList.get(NumberConst.IntDef.INT_ZERO);
            Long lgcsId = logisticsArea.getLgcsAreaId();
            param.setFilterObject("lgcsId",lgcsId);
            cityList = this.cityLogic.findList(param);
        }

        List<MdDistrict> districtList = null;
        if(!CollectionUtils.isEmpty(cityList)){
            MdCity city = cityList.get(NumberConst.IntDef.INT_ZERO);
            Long cityId = city.getCityId();
            param.setFilterObject("cityId",cityId);
            districtList = this.districtLogic.findList(param);
        }
        model.addAttribute("logisticsAreaList",logisticsAreaList);
        model.addAttribute("SO151408Bean",SO151408Bean);
        model.addAttribute("cityList",cityList);
        model.addAttribute("districtList",districtList);
        return "/so/SO151408";
    }

    /**
     * 订单数据插入操作
     * @param param 订单基本数据
     * @return 操作成功跳转到List页面
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(SO151408Param param){

        this.SO151408Logic.save(param);
        return super.forward("/SO151401/init");
    }

    /**
     * 加载买家信息
     * @param buyersCode 买家Code
     * @return 买家JSON数据
     */
    @RequestMapping(value = "loadBuyers",method = RequestMethod.POST)
    public @ResponseBody String loadBuyers(String buyersCode){
        return null;
    }



}
