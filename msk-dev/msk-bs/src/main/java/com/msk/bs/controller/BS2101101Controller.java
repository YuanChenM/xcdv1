package com.msk.bs.controller;

import com.msk.bs.bean.BS2101101Bean;
import com.msk.bs.logic.BS2101101Logic;
import com.msk.bs.logic.BSCommLogic;
import com.msk.bs.logic.IBS2101102RsLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.MdCity;
import com.msk.core.entity.MdDistrict;
import com.msk.core.entity.MdProvince;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 买手店列表Controller.
 *
 * @author cx
 */
@Controller
@RequestMapping(value = "BS2101101")
public class BS2101101Controller extends BaseController {
    @Autowired
    private BS2101101Logic bS2101101Logic;
    @Autowired
    private IBS2101102RsLogic iBS2101102RsLogic;
    @Autowired
    private BSCommLogic bsCommLogic;

    /**
     * 实例化页面
     *
     * @return 买手店列表页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    private String init(Model model,
                        @RequestParam(value = "slCode", required = false) String slCode,
                        @RequestParam(value = "applyStatus", required = false) Integer applyStatus,
                        @RequestParam(value = "provinceCode", required = false) String provinceCode,
                        @RequestParam(value = "cityCode", required = false) String cityCode,
                        @RequestParam(value = "districtCode", required = false) String districtCode) {
        BaseParam baseParam = new BaseParam();
        List<MdProvince> mdProvinces = this.bsCommLogic.findMdProvinces(baseParam);
        List<MdCity> cityList = null;
        List<MdDistrict> mdDistrictList = null;
        String provinceId = "";
        String cityId = "";
        for (int i = 0; i < mdProvinces.size(); i++) {
            MdProvince mdProvince = mdProvinces.get(i);
            if (mdProvince.getProvinceCode().equals(provinceCode)) {
                provinceId = StringUtil.toSafeString(mdProvince.getProvinceId());
            }
        }
        cityList = this.bsCommLogic.findCityList(provinceId);
        for (int i = 0; i < cityList.size(); i++) {
            MdCity mdCity = cityList.get(i);
            if (mdCity.getCityCode().equals(cityCode)) {
                cityId = StringUtil.toSafeString(mdCity.getCityId());
            }
        }
        mdDistrictList = bsCommLogic.findDistrictList(cityId);
        model.addAttribute("mdProvinces", mdProvinces);
        model.addAttribute("cityList", cityList);
        model.addAttribute("mdDistrictList", mdDistrictList);
        model.addAttribute("mdProvinces", mdProvinces);
        model.addAttribute("slCode", slCode);
        model.addAttribute("applyStatus", applyStatus);
        model.addAttribute("provinceCode", provinceCode);
        model.addAttribute("cityCode", cityCode);
        model.addAttribute("districtCode", districtCode);
        return "/bs/BS2101101";
    }

    /**
     * 查询买手店列表
     *
     * @param basePageParam basePageParam
     * @return 信息
     * @author cx
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<BS2101101Bean> search(@RequestParam(value = "provinceCode", required = false) String provinceCode,
                                     @RequestParam(value = "cityCode", required = false) String cityCode,
                                     @RequestParam(value = "districtCode", required = false) String districtCode,
                                     BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "slCodeDis", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slContact", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slIdcard", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slTel", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slAddress", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "stewardNum", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyerNum", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "shopName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "lgcsAreaName", DbUtils.LikeMode.FRONT);
        if (provinceCode.equals("0")) {
            provinceCode = "";
        }
        if (cityCode.equals("0")) {
            cityCode = "";
        }
        if (districtCode.equals("0")) {
            districtCode = "";
        }
        basePageParam.setFilter("provinceCode", provinceCode);
        basePageParam.setFilter("cityCode", cityCode);
        basePageParam.setFilter("districtCode", districtCode);
        if (isDebug) {
            return null;
        }
        return this.bS2101101Logic.findPage(basePageParam, BS2101101Bean.class);
    }
}
