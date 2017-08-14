package com.msk.sl.controller;

/**
 * Created by fjm on 2016/1/26.
 */

import com.msk.core.bean.BaseParam;
import com.msk.core.entity.*;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.SL2411030073Bean;
import com.msk.sl.logic.SL241103000Logic;
import com.msk.sl.logic.SL241103001Logic;
import com.msk.sl.logic.SL2411030071Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("SL241103000")
public class SL241103000Controller extends BaseController{

    @Autowired
    private SL2411030071Logic sl2411030071Logic;
    @Autowired
    private SL241103000Logic sl241103000Logic;
    @Autowired
    private SL241103001Logic sl241103001Logic;

    @RequestMapping("init")
    public String init(String slCode,Model model){
        //查询出代理分销表里面所有生产商授权单位作为SL241103007页面select框回显使用
        List<SL2411030073Bean> list = this.sl2411030071Logic.selectProxyList(slCode);
        BaseParam baseParam = new BaseParam();
        /**
         * 查询slMstCert表中的所有数据，用以添加联动选择项 证照的名称
         */
        List<SlMstCert> slMstCerts=this.sl241103000Logic.findList(baseParam);
        /**
         * 查询
         */
        List<MdProvince> mdProvinces =this.sl241103000Logic.findMdProvinces(baseParam);
        model.addAttribute("proxy",new SL2411030073Bean());
        model.addAttribute("proxyBean",list);
        model.addAttribute("slMstCerts",slMstCerts);
        model.addAttribute("mdProvinces",mdProvinces);
        return "sl/SL241103000";
    }

    /**
     * 根据生产商企业id查询卖家产品品牌列表里面的数据，返回js用以联动第二个select
     * @param param
     * @return
     */
    @RequestMapping(value = "findBrand", method = RequestMethod.POST)
    public @ResponseBody List<SlPdBrand> findBreed(BaseParam param) {
        return this.sl2411030071Logic.findPdBrand(param);
    }
    /**
     * 根据provinceId查询地市
     * @param provinceCode 省Code
     * @return
     */
    @RequestMapping(value = "findCity", method = RequestMethod.POST)
    public @ResponseBody List<MdCity> findCity(String provinceCode) {
        MdProvince mdProvince = this.sl241103001Logic.findProvince(provinceCode);
        return this.sl241103000Logic.findCityList(StringUtil.toSafeString(mdProvince.getProvinceId()));
    }

    /**
     * 根据cityId查询地市
     * @param cityCode 省Id
     * @return
     */
    @RequestMapping(value = "findDistrict", method = RequestMethod.POST)
    public @ResponseBody List<MdDistrict> findDistrict(String cityCode) {
        MdCity mdCity = this.sl241103001Logic.findCity(cityCode);
        return this.sl241103000Logic.findDistrictList(StringUtil.toSafeString(mdCity.getCityId()));
    }
}
