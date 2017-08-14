package com.msk.by.controller.comm;

import com.google.zxing.common.StringUtils;
import com.msk.by.bean.IBY121202RsParam;
import com.msk.by.bean.IBY121205RsParam;
import com.msk.by.bean.IBY121206RsParam;
import com.msk.by.bean.IBY121207RsParam;
import com.msk.by.logic.BY121304Logic;
import com.msk.by.logic.IBY121202Logic;
import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.*;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.md.utils.DistrictAreaUtils;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 买家基本信息画面
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("by/baseBuyerBasicInfo")
public class BYBaseBuyerBasicController extends BaseController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BYBaseBuyerBasicController.class);

    @Autowired
    private BY121304Logic by121304Logic;
    @Autowired
    private IBY121202Logic iby121202Logic;
    @Autowired
    private CommonLogic commonLogic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init/{buyerId}",
            method = RequestMethod.POST)
    public String init(@PathVariable("buyerId") String buyerId, Model model) {
        logger.debug("买家基本信息画面");
        model.addAttribute("buyerId", buyerId);
        //买家基本信息
        IBY121202RsParam buyerDetail = by121304Logic.findBuyerDetail(buyerId);
        //批发市场
        List<ByMarketTerminal> marketTerminalList = null;
        if (BusinessConst.BuyerType.Distribution.equals(buyerDetail.getSuperiorType())) {
            marketTerminalList = by121304Logic.findBuyerMarketTerminalList(buyerDetail.getLgcsAreaCode(), buyerDetail.getCityCode(), buyerDetail.getDistrictCode());
            if (!CollectionUtils.isEmpty(marketTerminalList)) {
                for (int i = 0; i < marketTerminalList.size(); i++) {
                    if (buyerDetail.getSuperiorId().equals(marketTerminalList.get(i).getTerMarketId())) {
                        buyerDetail.setSuperiorIdName(marketTerminalList.get(i).getMarketName());
                        break;
                    }
                }
            }
        }
        //菜场数据
        List<ByMarketFood> marketFoodList = null;
        if (BusinessConst.BuyerType.Market.equals(buyerDetail.getSuperiorType())) {
            marketFoodList = by121304Logic.findBuyerMarketFoodList(buyerDetail.getLgcsAreaCode(), buyerDetail.getCityCode(), buyerDetail.getDistrictCode());
            if (!CollectionUtils.isEmpty(marketFoodList)) {
                for (int i = 0; i < marketFoodList.size(); i++) {
                    if (buyerDetail.getSuperiorId().equals(marketFoodList.get(i).getFodMarketId())) {
                        buyerDetail.setSuperiorIdName(marketFoodList.get(i).getMarketName());
                        break;
                    }
                }
            }
        }
        //查询所有物流区
        List<MdLogisticsArea> logisticsAreaList = DistrictAreaUtils.getLogisticsAreaList();
        //查询指定物流区中的城市
        List<MdCity> cityList = DistrictAreaUtils.getCityListInLogisticsAreas(buyerDetail.getLgcsAreaCode());
        //查询指定城市中的区县
        List<MdDistrict> districtList = DistrictAreaUtils.getDistrictList(buyerDetail.getCityCode());
        //习惯支付方式
        List<CommConstant> payTypeList = commonLogic.findConstantList("PaymentMethod");
        //上线状态
        List<CommConstant> marketingStatusList = commonLogic.findConstantList("MarketingSatus");
        //买家类型
        List<CommConstant> buyerTypeList = by121304Logic.findBuyerTypes("BuyerType");
        model.addAttribute("buyerDetail", buyerDetail);
        model.addAttribute("marketTerminalList", marketTerminalList);
        model.addAttribute("marketFoodList", marketFoodList);
        model.addAttribute("logisticsAreaList", logisticsAreaList);
        model.addAttribute("cityList", cityList);
        model.addAttribute("districtList", districtList);
        model.addAttribute("payTypeList", payTypeList);
        model.addAttribute("marketingStatusList", marketingStatusList);
        model.addAttribute("buyerTypeList", buyerTypeList);

        return "by/comm/BASE_BUYER_BASIC_INFO";
    }

    /**
     * 买家基本信息更新
     *
     * @param basicInfo
     * @param model
     * @return
     */
    @RequestMapping(value = "update",
            method = RequestMethod.POST)
    public String basicInfoModify(IBY121202RsParam basicInfo, Model model) {
        logger.debug("买家基本信息更新");
        if (!StringUtil.isNullOrEmpty(basicInfo.getSuperiorType())) {
            List<CommConstant> buyerTypeList = commonLogic.findConstantList("BuyerType");
            for (int i = 0; i < buyerTypeList.size(); i++) {
                if (basicInfo.getSuperiorType().equals(buyerTypeList.get(i).getConstantValue())) {
                    basicInfo.setSuperiorName(buyerTypeList.get(i).getConstantName());
                    break;
                }
            }
            //如果不是分销买家且不是菜场买家
            if (!BusinessConst.BuyerType.Market.equals(basicInfo.getSuperiorType()) && !BusinessConst.BuyerType.Distribution.equals(basicInfo.getSuperiorType())) {
                basicInfo.setSuperiorId("");
                basicInfo.setSuperiorQua("");
            }
            if (StringUtil.isNullOrEmpty(basicInfo.getIsMarketFlg()) || !basicInfo.getIsMarketFlg().equals("1")) {
                basicInfo.setIsMarketFlg("0");
            }
            if(basicInfo.getSuperiorSubName().equals("请选择")){
                basicInfo.setSuperiorSubName("无");
            }
        }
        int updateCount = iby121202Logic.buyerInfoModify(basicInfo);
        return super.forward("/BY121304/init/" + basicInfo.getBuyerId() + "");
    }

    /**
     * 物流区变更，获取城市下拉框数据
     *
     * @param lgcsAreaCode
     * @return
     */
    @RequestMapping(value = "lgcsAreaChange/{lgcsAreaCode}",
            method = RequestMethod.POST)
    public
    @ResponseBody
    List<MdCity> findCityList(@PathVariable("lgcsAreaCode") String lgcsAreaCode) {
        List<MdCity> cityList = null;
        if (!StringUtil.isNullOrEmpty(lgcsAreaCode)) {
            cityList = DistrictAreaUtils.getCityListInLogisticsAreas(lgcsAreaCode);
        }
        return cityList;
    }

    /**
     * 城市变更，获取区县下拉框数据
     *
     * @param cityCode
     * @return
     */
    @RequestMapping(value = "cityChange/{cityCode}",
            method = RequestMethod.POST)
    public
    @ResponseBody
    List<MdDistrict> findDistrictList(@PathVariable("cityCode") String cityCode) {
        List<MdDistrict> districtList = null;
        if (!StringUtil.isNullOrEmpty(cityCode)) {
            districtList = DistrictAreaUtils.getDistrictList(cityCode);
        }
        return districtList;
    }

    /**
     * 买家类型变更,分销买家获取批发市场数据
     *
     * @return
     */
    @RequestMapping(value = "findMarketTermialList",
            method = RequestMethod.POST)
    public
    @ResponseBody
    List<ByMarketTerminal> findMarketTerminalList(IBY121202RsParam iby121202RsParam) {
        List<ByMarketTerminal> marketTerminalList = by121304Logic.findBuyerMarketTerminalList(iby121202RsParam.getLgcsAreaCode(), iby121202RsParam.getCityCode(), iby121202RsParam.getDistrictCode());
        return marketTerminalList;
    }

    /**
     * 买家类型变更,菜场买家获取批发市场数据
     *
     * @return
     */
    @RequestMapping(value = "findMarketFoodList",
            method = RequestMethod.POST)
    public
    @ResponseBody
    List<ByMarketFood> findMarketFoodList(IBY121202RsParam iby121202RsParam) {
        List<ByMarketFood> marketFoodList = by121304Logic.findBuyerMarketFoodList(iby121202RsParam.getLgcsAreaCode(), iby121202RsParam.getCityCode(), iby121202RsParam.getDistrictCode());
        return marketFoodList;
    }

    /**
     * 买家类型变更,获取类型下二级类型数据
     *
     * @return
     */
    @RequestMapping(value = "findBuyerList/{buyerType}",
            method = RequestMethod.POST)
    public
    @ResponseBody
    List<CommConstant> findBuyerList(@PathVariable("buyerType") String buyerType) {
        List<CommConstant> buyerList = commonLogic.findConstantList(buyerType);
        return buyerList;
    }

    /**
     * 批发市场等级信息获取
     *
     * @return
     */
    @RequestMapping(value = "findMarketTermial/{superiorId}",
            method = RequestMethod.POST)
    public
    @ResponseBody
    ByMarketTerminal findMarketTerminal(@PathVariable("superiorId") String superiorId) {
        ByMarketTerminal marketTerminal = by121304Logic.findBuyerMarketTerminal(superiorId);
        return marketTerminal;
    }

    /**
     * 菜场等级信息获取
     *
     * @return
     */
    @RequestMapping(value = "findMarketFood/{superiorId}",
            method = RequestMethod.POST)
    public
    @ResponseBody
    ByMarketFood findMarketFood(@PathVariable("superiorId") String superiorId) {
        ByMarketFood marketFood = by121304Logic.findByMarketFood(superiorId);
        return marketFood;
    }

    /**
     * 重置账号和密码
     *
     * @return
     */
    @RequestMapping(value = "reset/accountPwd",
            method = RequestMethod.POST)
    public
    @ResponseBody
    int resetAccountPwd(ByBuyerAccount byBuyerAccount) {
        return by121304Logic.resetAccountPwd(byBuyerAccount);
    }

    /**
     * 初始化重置账号密码页面
     *
     * @param model
     * @param byBuyerAccount
     * @return
     */
    @RequestMapping(value = "initAccountPwd", method = RequestMethod.POST)
    public String initAccountPwd(Model model, ByBuyerAccount byBuyerAccount) {
        model.addAttribute("buyerId", byBuyerAccount.getBuyerId());
        model.addAttribute("telNo", byBuyerAccount.getTelNo());
        model.addAttribute("accountName", byBuyerAccount.getAccountName());
        model.addAttribute("accountPass", byBuyerAccount.getAccountPass());
        return "by/comm/ResetAccountPwd";
    }
}

