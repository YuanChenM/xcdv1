package com.msk.by.controller;

import com.msk.by.bean.IBY121201RsParam;
import com.msk.by.logic.IBY121201Logic;
import com.msk.core.entity.ByBuyerAccount;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.consts.BusinessConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msk.by.bean.BY121303Bean;
import com.msk.by.logic.BY121301Logic;
import com.msk.by.logic.BY121302Logic;
import com.msk.by.logic.BY121303Logic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.ByMarketFood;
import com.msk.core.entity.ByMarketTerminal;
import com.msk.core.utils.DbUtils;

/**
 * 买家列表
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("BY121303")
public class BY121303Controller extends BaseController{

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BY121303Controller.class);

    @Autowired
    private BY121303Logic by121303Logic;

    @Autowired
    private BY121301Logic by121301Logic;

    @Autowired
    private BY121302Logic by121302Logic;

    @Autowired
    private IBY121201Logic iby121201Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("买家列表初始化");
        model.addAttribute("superiorId", StringConst.ALL);
        return "by/BY121303";
    }
    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init/{message}",
            method = RequestMethod.POST)
    public String init(@PathVariable("message") String message,Model model) {
        logger.debug("买家列表初始化");
        model.addAttribute("superiorId", StringConst.ALL);
        model.addAttribute("message", message);
        return "by/BY121303";
    }

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init/{type}/{superiorId}",
        method = RequestMethod.POST)
    public String init(@PathVariable("type") String type, @PathVariable("superiorId") String superiorId, Model model) {
        logger.debug("买家列表初始化");
        model.addAttribute("type", type);
        model.addAttribute("superiorId", superiorId);
        if (type.equals("1")) {
            ByMarketTerminal market = by121301Logic.findMarketTerminalById(superiorId);
            model.addAttribute("market", market);
        } else if (type.equals("2")) {
            ByMarketFood market = by121302Logic.findMarketFoodById(superiorId);
            model.addAttribute("market", market);
        }
        return "by/BY121303";
    }

    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search/{superiorId}",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<BY121303Bean> search(@PathVariable("superiorId") String superiorId,
        BasePageParam param) {
        logger.debug("买家列表查询");
        if (!StringConst.ALL.equals(superiorId)) {
            param.getFilterMap().put("superiorId", superiorId);
        }
        DbUtils.buildLikeCondition(param, "buyerCode", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "buyerName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "buyerAddr", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "superiorName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "lgcsAreaName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "cityName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "districtName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "marketingsStatusName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "accountName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "telNo", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "storeNo", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "bossName", DbUtils.LikeMode.PARTIAL);
        return by121303Logic.findPage(param, BY121303Bean.class);
    }

    /**
     * 注册新买家
     * @param telNo
     * @param model
     * @return
     */
    @RequestMapping(value = "register/{telNo}")
    public String buyerRegister(@PathVariable("telNo") String telNo,Model model){
        IBY121201RsParam inParam = new IBY121201RsParam();
        inParam.setTelNo(telNo);
        inParam.setRegisterSource(BusinessConst.BuyerRegisterWay.System);
        String message = iby121201Logic.buyerRegister(inParam);
        ByBuyerAccount buyerAccount = null;
        if(StringUtil.isNullOrEmpty(message)){
            buyerAccount = iby121201Logic.getBuyerAccount(inParam);
            return super.forward("/BY121307/init/"+buyerAccount.getBuyerId()+"");
        }else{
            return super.forward("/BY121303/init/"+message);
        }
    }

    /**
     * 删除买家信息
     * @param buyerId
     * @return
     */
    @RequestMapping(value = "delete/{buyerId}",method = RequestMethod.POST)
    public String buyerInfoDelete(@PathVariable("buyerId") String buyerId){
        by121303Logic.deleteBuyerInfo(buyerId);
        return "by/BY121303";
    }
}
