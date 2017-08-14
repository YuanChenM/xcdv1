package com.msk.core.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msk.common.logic.CityLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.MdCity;
import com.msk.core.web.base.BaseController;

/**
 * DistrictController
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("district")
public class DistrictController extends BaseController{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DistrictController.class);
    @Autowired
    private CityLogic cityLogic;
    @RequestMapping(value = "searchCity",method = RequestMethod.POST)
    public @ResponseBody List<MdCity> searchCity(String lgcsId){
        logger.debug("查询城市信息");
        BaseParam param = new BaseParam();
        param.setFilterObject("lgcsId", lgcsId);

        return this.cityLogic.findList(param);
    }
}
