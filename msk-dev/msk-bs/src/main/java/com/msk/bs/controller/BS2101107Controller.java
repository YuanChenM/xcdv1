package com.msk.bs.controller;

import com.msk.bs.bean.IBS2101104RsParam;
import com.msk.bs.bean.IBS2101104SlHouseAccount;
import com.msk.bs.logic.BS2101107Logic;
import com.msk.bs.logic.BSCommLogic;
import com.msk.bs.logic.IBS2101104RsLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.MdCity;
import com.msk.core.entity.MdDistrict;
import com.msk.core.entity.MdProvince;
import com.msk.core.entity.SlHouseAccount;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 冻品管家新添页面
 *
 * @author pxg
 */
@Controller
@RequestMapping(value = "BS2101107")
public class BS2101107Controller extends BaseController {


    @Autowired
    private BSCommLogic bsCommLogic;
    @Autowired
    private BS2101107Logic bs2101107Logic;
    @Autowired
    private IBS2101104RsLogic ibs2101104RsLogic;
    /**
     * 实例化页面
     *
     * @return 加载冻品管家新添页面
     */
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(@RequestParam(value="slCode",required = false)String slCode,
                       @RequestParam(value="slContact",required = false)String slContact,
                       @RequestParam(value="slCodeDis",required = false)String slCodeDis,
                       IBS2101104SlHouseAccount ibs2101104SlHouseAccount,Model model,String flagNum) {
        //地区回显
        BaseParam baseParam = new BaseParam();
        List<MdProvince> mdProvinces = this.bsCommLogic.findMdProvinces(baseParam);
        List<MdCity> cityList = null;
        List<MdDistrict> mdDistrictList = null;
        //虚拟地区
        List<MdCity> vcityList = null;
        List<MdDistrict> vmdDistrictList = null;
        if (null != ibs2101104SlHouseAccount) {
            String provinceId = "";
            String cityId = "";
            String vprovinceId = "";
            String vcityId = "";
            for (int i = 0; i < mdProvinces.size(); i++) {
                MdProvince mdProvince = mdProvinces.get(i);
                if (mdProvince.getProvinceCode().equals(ibs2101104SlHouseAccount.getProvinceCode())) {
                    provinceId = StringUtil.toSafeString(mdProvince.getProvinceId());
                }
                if (mdProvince.getProvinceCode().equals(ibs2101104SlHouseAccount.getVprovinceCode())) {
                    vprovinceId = StringUtil.toSafeString(mdProvince.getProvinceId());
                }
            }
            cityList = this.bsCommLogic.findCityList(provinceId);
            for (int i = 0; i < cityList.size(); i++) {
                MdCity mdCity = cityList.get(i);
                if (mdCity.getCityCode().equals(ibs2101104SlHouseAccount.getCityCode())) {
                    cityId = StringUtil.toSafeString(mdCity.getCityId());
                }
            }
            vcityList=this.bsCommLogic.findCityList(vprovinceId);
            for (int i = 0; i < vcityList.size(); i++) {
                MdCity mdCity = vcityList.get(i);
                if (mdCity.getCityCode().equals(ibs2101104SlHouseAccount.getVcityCode())) {
                    vcityId = StringUtil.toSafeString(mdCity.getCityId());
                }
            }
            mdDistrictList = bsCommLogic.findDistrictList(cityId);
            vmdDistrictList = bsCommLogic.findDistrictList(vcityId);
        }
        model.addAttribute("mdProvinces", mdProvinces);
        model.addAttribute("cityList", cityList);
        model.addAttribute("mdDistrictList", mdDistrictList);
        model.addAttribute("vcityList", vcityList);
        model.addAttribute("vmdDistrictList", vmdDistrictList);
     /*   List<MdProvince> mdProvinces = bsCommLogic.findMdProvinces(new BaseParam());
        model.addAttribute("mdProvinces",mdProvinces);*/
        model.addAttribute("ibs2101104SlHouseAccount",ibs2101104SlHouseAccount);
        model.addAttribute("slCode", slCode);
        model.addAttribute("slContact", slContact);
        model.addAttribute("slCodeDis", slCodeDis);
        model.addAttribute("flagNum", flagNum);
        return "bs/BS2101107";
    }
    /**
     * 根据provinceId查询地市
     * @param provinceCode 省Code
     * @return
     */
    @RequestMapping(value = "findCity", method = RequestMethod.POST)
    public @ResponseBody List<MdCity> findCity(String provinceCode) {
        MdProvince mdProvince = this.bs2101107Logic.findProvince(provinceCode);
        return this.bsCommLogic.findCityList(StringUtil.toSafeString(mdProvince.getProvinceId()));
    }
    /**
     * 根据cityId查询地市
     * @param cityCode 省Id
     * @return
     */
    @RequestMapping(value = "findDistrict", method = RequestMethod.POST)
    public @ResponseBody List<MdDistrict> findDistrict(String cityCode) {
        MdCity mdCity = this.bs2101107Logic.findCity(cityCode);
        return this.bsCommLogic.findDistrictList(StringUtil.toSafeString(mdCity.getCityId()));
    }

    /**
     * 数据保存
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody int save( IBS2101104SlHouseAccount ibs2101104SlHouseAccount,HttpServletRequest request,HttpServletResponse response) {
        int num=0;
        if(null!=ibs2101104SlHouseAccount){

            ibs2101104SlHouseAccount.setCrtId(super.getLoginUser().getCrtId());
            IBS2101104RsParam ibs2101104RsParam = new IBS2101104RsParam();
            ibs2101104RsParam.setSlHouseAccount(ibs2101104SlHouseAccount);
            SlHouseAccount account = ibs2101104RsLogic.editBSSeller(ibs2101104RsParam);
            if(account != null){
                num = 1;
            }
        }
        return num;
    }
}
