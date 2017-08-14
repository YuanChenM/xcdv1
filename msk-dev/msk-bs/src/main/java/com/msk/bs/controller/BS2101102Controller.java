package com.msk.bs.controller;

import com.msk.bs.bean.IBS2101105RsResult;
import com.msk.bs.logic.BS2101102Logic;
import com.msk.bs.logic.BSCommLogic;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 冻品管家列表Controller.
 *
 * @author cx
 */
@Controller
@RequestMapping(value = "BS2101102")
public class BS2101102Controller extends BaseController {
    @Autowired
    private BS2101102Logic bS2101102Logic;

    @Autowired
    private BSCommLogic bsCommLogic;

    /**
     * 实例化页面
     *
     * @return 冻品管家列表页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(@RequestParam(value = "slCode", required = false) String slCode,
                       @RequestParam(value = "slCodeDis", required = false) String slCodeDis,
                       @RequestParam(value = "slContact", required = false) String slContact,
                       @RequestParam(value = "provinceCode1", required = false) String provinceCode1,
                       @RequestParam(value = "cityCode1", required = false) String cityCode1,
                       @RequestParam(value = "districtCode1", required = false) String districtCode1,
                       @RequestParam(value = "provinceCode", required = false) String provinceCode,
                       @RequestParam(value = "cityCode", required = false) String cityCode,
                       @RequestParam(value = "districtCode", required = false) String districtCode,
                       Model model) {
        //List<MdProvince> mdProvinces = bsCommLogic.findMdProvinces(new BaseParam());


        BaseParam baseParam = new BaseParam();
        List<MdProvince> mdProvinces = this.bsCommLogic.findMdProvinces(baseParam);
        List<MdCity> cityList = null;
        List<MdDistrict> mdDistrictList = null;
        String provinceId = "";
        String cityId = "";
        for (int i = 0; i < mdProvinces.size(); i++) {
            MdProvince mdProvince = mdProvinces.get(i);
            if (mdProvince.getProvinceCode().equals(provinceCode1)) {
                provinceId = StringUtil.toSafeString(mdProvince.getProvinceId());
            }
        }
        cityList = this.bsCommLogic.findCityList(provinceId);
        for (int i = 0; i < cityList.size(); i++) {
            MdCity mdCity = cityList.get(i);
            if (mdCity.getCityCode().equals(cityCode1)) {
                cityId = StringUtil.toSafeString(mdCity.getCityId());
            }
        }
        mdDistrictList = bsCommLogic.findDistrictList(cityId);
        model.addAttribute("mdProvinces", mdProvinces);
        model.addAttribute("cityList", cityList);
        model.addAttribute("mdDistrictList", mdDistrictList);
        model.addAttribute("slCode", slCode);
        model.addAttribute("slCodeDis", slCodeDis);
        model.addAttribute("slContact", slContact);
        model.addAttribute("provinceCode1", provinceCode1);
        model.addAttribute("cityCode1", cityCode1);
        model.addAttribute("districtCode1", districtCode1);
        model.addAttribute("provinceCode", provinceCode);
        model.addAttribute("cityCode", cityCode);
        model.addAttribute("districtCode", districtCode);
        return "/bs/BS2101102";
    }

    /**
     * 冻品管家列表
     *
     * @param basePageParam basePageParam
     * @return 信息
     * @author cx
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<IBS2101105RsResult> search(
            @RequestParam(value = "provinceCode1", required = false) String provinceCode1,
            @RequestParam(value = "cityCode1", required = false) String cityCode1,
            @RequestParam(value = "districtCode1", required = false) String districtCode1,
            BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "houseAccount", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "houseContact", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slIdcard", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "houseAddress", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "houseTel", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "houseCodeDis", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "vhouseAddress", DbUtils.LikeMode.FRONT);
        if (provinceCode1.equals("0")||null == provinceCode1) {
            provinceCode1 = "";
        }
        if (cityCode1.equals("0") || null == cityCode1) {
            cityCode1 = "";
        }
        if (districtCode1.equals("0")|| null == districtCode1) {
            districtCode1 = "";
        }
        basePageParam.setFilter("provinceCode1", provinceCode1);
        basePageParam.setFilter("cityCode1", cityCode1);
        basePageParam.setFilter("districtCode1", districtCode1);
        if (isDebug) {
            return null;
        }
        return this.bS2101102Logic.findPage(basePageParam, IBS2101105RsResult.class);
    }

}
