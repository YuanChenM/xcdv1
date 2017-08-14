package com.msk.bs.controller;

import com.msk.bs.bean.IBS2101106Bean;
import com.msk.bs.bean.IBS2101107Bean;
import com.msk.bs.logic.BS2101103Logic;
import com.msk.bs.logic.BSCommLogic;
import com.msk.bs.logic.IBS2101106RsLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
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
 * 买手店管家会员列表Controller.
 *
 * @author cx
 */
@Controller
@RequestMapping(value = "BS2101103")
public class BS2101103Controller extends BaseController {
    @Autowired
    private BS2101103Logic bS2101103Logic;
    @Autowired
    private BSCommLogic bsCommLogic;
    @Autowired
    private IBS2101106RsLogic iBS2101106RsLogic;

    /**
     * 实例化页面
     *
     * @return 买手店管家会员列表
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(@RequestParam(value = "slCode", required = false) String slCode,
                       @RequestParam(value = "slCodeDis", required = false) String slCodeDis,
                       @RequestParam(value = "slContact", required = false) String slContact,
                       @RequestParam(value = "houseAccount", required = false) String houseAccount,
                       @RequestParam(value = "houseCode", required = false) String houseCode,
                       @RequestParam(value = "houseContact", required = false) String houseContact,
                       @RequestParam(value = "houseCodeDis", required = false) String houseCodeDis, Model model) {

        List<MdProvince> mdProvinces = bsCommLogic.findMdProvinces(new BaseParam());
        model.addAttribute("mdProvinces", mdProvinces);
        model.addAttribute("slCode", slCode);
        model.addAttribute("slContact", slContact);
        model.addAttribute("slCodeDis", slCodeDis);
        model.addAttribute("houseCode", houseCode);
        model.addAttribute("houseAccount", houseAccount);
        model.addAttribute("houseContact", houseContact);
        model.addAttribute("houseCodeDis", houseCodeDis);
        return "/bs/BS2101103";
    }

    /**
     * 买手店管家会员列表
     *
     * @param basePageParam basePageParam
     * @return 信息
     * @author cx
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<IBS2101107Bean> search(
            @RequestParam(value = "provinceCode", required = false) String provinceCode,
            @RequestParam(value = "cityCode", required = false) String cityCode,
            @RequestParam(value = "districtCode", required = false) String districtCode,
            BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "buyerCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyerName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "lgcsCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyerAddr", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "busiTel", DbUtils.LikeMode.FRONT);
        String applyStatusName= StringUtil.toSafeString(basePageParam.getFilterMap().get("applyStatusName"));
        if(!StringUtil.isNullOrEmpty(applyStatusName)){
            String [] applyStatusNames=applyStatusName.split(",");
            basePageParam.getFilterMap().put("applyStatusNames", applyStatusNames);
        }
        basePageParam.setFilter("provinceCode", provinceCode);
        basePageParam.setFilter("cityCode", cityCode);
        basePageParam.setFilter("districtCode", districtCode);
        basePageParam.setFilter("buyerFlag", "1");
        if (isDebug) {
            return null;
        }
        return this.bS2101103Logic.findPage(basePageParam, IBS2101107Bean.class);
    }

    /**
     * 解除 买手店管家会员关系
     *
     * @param houseCode
     * @param buyerId
     * @param slCode
     * @return
     */
    @RequestMapping(value = "relievePelation", method = RequestMethod.POST)
    public
    @ResponseBody
    String relievePelation(@RequestParam(value = "houseCode", required = false) String houseCode,
                           @RequestParam(value = "buyerId", required = false) String buyerId,
                           @RequestParam(value = "slCode", required = false) String slCode) {
        IBS2101106Bean iBS2101106Bean = new IBS2101106Bean();
        iBS2101106Bean.setHouseCode(houseCode);
        iBS2101106Bean.setBuyerId(buyerId);
        iBS2101106Bean.setSlCode(slCode);
        iBS2101106Bean.setBuyerFlag("1");
        iBS2101106Bean.setDelFlg("1");
        iBS2101106RsLogic.editExclusive(iBS2101106Bean);

        return "1";
    }

    /**
     * 成为买手店管家会员
     * @param iBS2101106Bean
     * @return 结果
     */
    @RequestMapping(value = "buildPelation", method = RequestMethod.POST)
    public @ResponseBody int buildPelation(IBS2101106Bean iBS2101106Bean) {
        iBS2101106Bean.setBuyerFlag("1");
        iBS2101106Bean.setApplyStatus("2");
        return iBS2101106RsLogic.editExclusive(iBS2101106Bean);
    }

}
