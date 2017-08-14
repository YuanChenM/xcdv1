package com.msk.bs.controller;

import com.msk.bs.bean.IBS210111201Bean;
import com.msk.bs.bean.IBS2101112Bean;
import com.msk.bs.logic.BS2101112Logic;
import com.msk.bs.logic.BSCommLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.MdProvince;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseUploadController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 买手账号信息编辑
 *
 * @author cx
 */
@Controller
@RequestMapping(value = "BS2101112")
public class BS2101112Controller extends BaseUploadController {

    private static Logger logger = LoggerFactory.getLogger(BS2101112Controller.class);
    @Autowired
    private BS2101112Logic bs2101112Logic;

    @Autowired
    private BSCommLogic bsCommLogic;

    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(@RequestParam(value = "slCode", required = false) String slCode,
                       @RequestParam(value = "slContact", required = false) String slContact,
                       @RequestParam(value = "slCodeDis", required = false) String slCodeDis,
                       @RequestParam(value = "buyerId", required = false) String buyerId,
                       @RequestParam(value = "houseCode", required = false) String houseCode,
                       @RequestParam(value = "houseAccount", required = false) String houseAccount,
                       @RequestParam(value = "houseCodeDis", required = false) String houseCodeDis,
                       @RequestParam(value = "houseContact", required = false) String houseContact,
                       @RequestParam(value = "flagNum", required = false) String flagNum,
                       Model model) {
        logger.debug("查询买手冻品管家的买家履历信息");
        if (isDebug) {
            return null;
        }
        model.addAttribute("slCode", slCode);
        model.addAttribute("slContact", slContact);
        model.addAttribute("slCodeDis", slCodeDis);
        model.addAttribute("buyerId", buyerId);
        model.addAttribute("houseCode", houseCode);
        model.addAttribute("houseCodeDis", houseCodeDis);
        model.addAttribute("houseAccount", houseAccount);
        model.addAttribute("houseContact", houseContact);
        model.addAttribute("flagNum", flagNum);
        List<MdProvince> mdProvinces = bsCommLogic.findMdProvinces(new BaseParam());
        model.addAttribute("mdProvinces", mdProvinces);
        return "bs/BS2101111";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<IBS2101112Bean> search(
            @RequestParam(value = "provinceCode", required = false) String provinceCode,
            @RequestParam(value = "cityCode", required = false) String cityCode,
            @RequestParam(value = "districtCode", required = false) String districtCode,
            @RequestParam(value = "provinceCode1", required = false) String provinceCode1,
            @RequestParam(value = "cityCode1", required = false) String cityCode1,
            @RequestParam(value = "districtCode1", required = false) String districtCode1,
            @RequestParam(value = "searchDataFlag", required = false) String searchDataFlag,
            BasePageParam basePageParam) {

        String code = basePageParam.getFilterMap().get("buyerInfo.buyerCode").toString();
        basePageParam.setFilter("buyerCode1", code);
        basePageParam.setFilter("buyerName1", basePageParam.getFilterMap().get("buyerInfo.buyerName").toString());
        basePageParam.setFilter("buyerAddr1", basePageParam.getFilterMap().get("buyerInfo.buyerAddr").toString());
        basePageParam.setFilter("busiTel1", basePageParam.getFilterMap().get("buyerInfo.busiTel").toString());
        String houseCodeDis1 = (String) basePageParam.getFilterMap().get("houseInfo.houseCodeDis");
        String houseContact1 = (String) basePageParam.getFilterMap().get("houseInfo.houseContact");
        if (null != houseCodeDis1 && !"".equals(houseCodeDis1)) {
            basePageParam.setFilter("houseCodeDis1", houseCodeDis1);
        }
        if (null != houseContact1 & !"".equals(houseContact1)) {
            basePageParam.setFilter("houseContact1", houseContact1);
        }
        DbUtils.buildLikeCondition(basePageParam, "startTime", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "endTime", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyerReason", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyershopReason", DbUtils.LikeMode.FRONT);
        //根据买家区划查询
        basePageParam.setFilter("provinceCode", provinceCode);
        basePageParam.setFilter("cityCode", cityCode);
        basePageParam.setFilter("districtCode", districtCode);
        //根据冻品管家区划查询
        basePageParam.setFilter("provinceCode1", provinceCode1);
        basePageParam.setFilter("cityCode1", cityCode1);
        basePageParam.setFilter("districtCode1", districtCode1);

        basePageParam.setFilter("searchDataFlag", searchDataFlag);
        if (isDebug) {
            return null;
        }
        PageResult<IBS2101112Bean> pageResult = this.bs2101112Logic.findPage(basePageParam, IBS2101112Bean.class);
        List<IBS2101112Bean> listBeans = pageResult.getData();
        for (IBS2101112Bean ibs2101112Bean : listBeans) {
            IBS210111201Bean ibs210111201Bean = ibs2101112Bean.getBuyerInfo();
            String cityName = ibs2101112Bean.getBuyerInfo().getCityName();
            String provinceName = ibs2101112Bean.getBuyerInfo().getProvinceName();
            String districtName = ibs2101112Bean.getBuyerInfo().getDistrictName();
            String districtName1 = provinceName + " " + cityName + " " + districtName;
            ibs210111201Bean.setDistrictName1(districtName1);
            ibs2101112Bean.setBuyerInfo(ibs210111201Bean);
        }
        return pageResult;
    }
}
