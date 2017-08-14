package com.msk.bs.controller;

import com.msk.bs.bean.BS2101104Bean;
import com.msk.bs.bean.IBS2101106Bean;
import com.msk.bs.bean.IBS2101107Bean;
import com.msk.bs.logic.BS2101104Logic;
import com.msk.bs.logic.BSCommLogic;
import com.msk.bs.logic.IBS2101106RsLogic;
import com.msk.bs.logic.IBS2101108RsLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.MdProvince;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公共买家池.
 *
 * @author cx
 */
@Controller
@RequestMapping(value = "BS2101104")
public class BS2101104Controller extends BaseController {
    @Autowired
    private BS2101104Logic bS2101104Logic;
    @Autowired
    private IBS2101106RsLogic iBS2101106RsLogic;
    @Autowired
    private IBS2101108RsLogic iBS2101108RsLogic;
    @Autowired
    private BSCommLogic bsCommLogic;
    String slCo = "";
    String houseAc = "";
    String houseCo = "";

    /**
     * 实例化页面
     *
     * @return 公共买家池列表
     */
    @RequestMapping(value = "init/{pageType}", method = RequestMethod.POST)
    public String init(@RequestParam(value = "slCode", required = false) String slCode,
                       @RequestParam(value = "houseAccount", required = false) String houseAccount,
                       @RequestParam(value = "houseCode", required = false) String houseCode,
                       @RequestParam(value = "slCodeDis",required = false) String slCodeDis,
                       @RequestParam(value = "slContact",required = false) String slContact,
                       @RequestParam(value = "houseContact",required = false) String houseContact,
                       @PathVariable(value = "pageType") String pageType,Model model) {
        slCo = slCode;
        houseAc = houseAccount;
        houseCo = houseCode;

        List<MdProvince> mdProvinces = bsCommLogic.findMdProvinces(new BaseParam());
        model.addAttribute("mdProvinces", mdProvinces);
        model.addAttribute("slCode", slCode);
        model.addAttribute("slContact", slContact);
        model.addAttribute("slCodeDis", slCodeDis);
        model.addAttribute("houseCode", houseCode);
        model.addAttribute("houseAccount", houseAccount);
        model.addAttribute("houseContact", houseContact);
        model.addAttribute("pageType",pageType);
        return "/bs/BS2101104";
    }


    /**
     * 公共买家池列表
     *
     * @param basePageParam basePageParam
     * @return 信息
     * @author cx
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<IBS2101107Bean> search(BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "accountName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "telNo", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyerCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyerName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "superiorName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "marketingsStatusName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyerAddr", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "busiTel", DbUtils.LikeMode.FRONT);
        if (isDebug) {
            return null;
        }
        return this.iBS2101108RsLogic.findPage(basePageParam, IBS2101107Bean.class);

    }

    /**
     * 买家申请成为专属会员
     *
     * @return
     */
    @RequestMapping(value = "SlApply", method = RequestMethod.POST)
    public @ResponseBody String SlApply(BS2101104Bean bean, @RequestParam(value = "flge", required = false) String flge) {
        IBS2101106Bean iBS2101106Bean = new IBS2101106Bean();
        iBS2101106Bean.setSlCode(slCo);
        iBS2101106Bean.setHouseAccount(houseAc);
        iBS2101106Bean.setHouseCode(houseCo);
        String buyerId = bean.getBuyerId();
        iBS2101106Bean.setBuyerId(buyerId);
        iBS2101106Bean.setBuyerFlag("1");
        //冻品管家申请成为专属会员
        if ("7".equals(flge)) {
            iBS2101106Bean.setApplyStatus("1");
            iBS2101106Bean.setApplySide("A");
            //买家申请成为专属会员
        } else if ("6".equals(flge)) {
            iBS2101106Bean.setApplyStatus("1");
            iBS2101106Bean.setApplySide("B");
            //成为专属买家
        } else if ("5".equals(flge)) {
            iBS2101106Bean.setApplyStatus("2");
            iBS2101106Bean.setApplySide("B");
        }
        iBS2101106RsLogic.editExclusive(iBS2101106Bean);
        return "/bs/BS2101104";
    }
}
