package com.msk.ds.controller;

import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.ConfigManager;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.ds.bean.*;
import com.msk.ds.logic.SC182102Logic;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SC182102Controller
 *
 * @author yang_yang
 *
 */
@Controller
@RequestMapping("SC182102")
public class SC182102Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SC182102Controller.class);

    @Autowired
    private SC182102Logic sc182102Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init/{isEdit}",method = RequestMethod.POST)
    public String init(Model model,SC182101Bean sc182101Bean,@PathVariable boolean isEdit) {
        SC181102Param sc181102Param = new SC181102Param();

        sc181102Param.setDistMonth(sc182101Bean.getDistMonth());
        sc181102Param.setAreaCode(sc182101Bean.getLgcsCode());
        sc181102Param.setSupplierCode(sc182101Bean.getSuppCode());
        sc181102Param.setHalfCode(sc182101Bean.getHalfCode());
        this.setCommonParam(sc181102Param);

        //获取分销月度
        DistSuppChain distMonthParam = sc182102Logic.getDistMonth();
        //获取半旬
        DistSuppChain halfName = sc182102Logic.getHalfName(sc181102Param);

        if(sc182101Bean.getHalfCode() != null && halfName.getCurrentHalfCode() != Integer.valueOf(sc182101Bean.getHalfCode())){
            halfName.setCurrentHalfCode(Integer.valueOf(sc182101Bean.getHalfCode()));
        }

        //获取发货次数(TODO)
        if(sc182101Bean.getDeliveryStockId() == null || sc182101Bean.getDeliveryStockId() == 0){
            sc182101Bean.setDeliveryNums(sc182102Logic.getDeliveryNums(sc181102Param));
        } else {
            sc182101Bean.setDeliveryNums(sc182101Bean.getDeliveryStockId());
        }

        //已确认
        String status = BusinessConst.StockStatusName.IsSure;
        if(isEdit && sc182101Bean != null){
            //待收货
            if(BusinessConst.DeliveryStockStatus.NoDelivery.equals(sc182101Bean.getDeliveryStockStatus())){
                status = BusinessConst.StockStatusName.NoDelivery;
            }
            //已收货
            if(BusinessConst.DeliveryStockStatus.Delivery.equals(sc182101Bean.getDeliveryStockStatus())){
                status = BusinessConst.StockStatusName.Delivery;
            }
        }

        BaseParam baseParam = new BaseParam();
        this.setCommonParam(baseParam);

        model.addAttribute("userType",baseParam.getUserType());

        model.addAttribute("isEdit",isEdit);
        model.addAttribute("status",status);
        model.addAttribute("distMonthParam",distMonthParam);
        model.addAttribute("halfParam",halfName);
        model.addAttribute("sc182101Bean",sc182101Bean);
        /** PDF打印请求url和回调函数url create by likai on 2016/8/11 start */
        //TODO
        /** 供应商和管理员身份判断 */
        if ((isEdit && !status.equals(BusinessConst.StockStatusName.NoDelivery)) ||
                ("1".equals(baseParam.getUserType()) && isEdit && status.equals(BusinessConst.StockStatusName.NoDelivery))) {

            model.addAttribute("printUrl", ConfigManager.getApiPrintDsUrl()+"SC182102");
        }else {
            model.addAttribute("printUrl", ConfigManager.getApiPrintDsUrl()+"SC182102GYS");
        }
        model.addAttribute("callBackUrl", ConfigManager.getApiSearchPrintDeliveryUrl());
        /** PDF打印请求url和回调函数url create by likai on 2016/8/11 end */

        return "ds/SC182102";
    }

    /**
     * 分页查询数据
     *
     * @return 分页查询数据
     */
    @RequestMapping(value = "search/{isEdit}",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<SC182102Param> search(Model model,@PathVariable boolean isEdit,SC182101Bean sc182101Bean) {
        SC181102Param sc181102Param = new SC181102Param();

        sc181102Param.setDistMonth(sc182101Bean.getDistMonth());
        sc181102Param.setAreaCode(sc182101Bean.getLgcsCode());
        sc181102Param.setSupplierCode(sc182101Bean.getSuppCode());
        sc181102Param.setHalfCode(sc182101Bean.getHalfCode());

        sc181102Param.getFilterMap().put("deliveryStockId", sc182101Bean.getDeliveryStockId());
        /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 start */
        PageResult<SC182102Param> result = sc182102Logic.findPageList(sc181102Param,isEdit);
        SC182102Param currentBen = new SC182102Param();
        currentBen = this.sc182102Logic.getCurrentInfo(sc181102Param);
        if( result.getData().size()>0 && CollectionUtils.isNotEmpty(result.getData())) {
            result.getData().get(0).setCurrentNetWeight(currentBen.getCurrentNetWeight());
            result.getData().get(0).setCurrentDifferNum(currentBen.getCurrentDifferNum());
            result.getData().get(0).setCurrentDifferQty(currentBen.getCurrentDifferQty());
            result.getData().get(0).setCurrentReceiveNum(currentBen.getCurrentReceiveNum());
            result.getData().get(0).setCurrentRecriveQty(currentBen.getCurrentRecriveQty());
            result.getData().get(0).setCurrentSendActualNum(currentBen.getCurrentSendActualNum());
            result.getData().get(0).setCurrentSendQty(currentBen.getCurrentSendQty());
            result.getData().get(0).setCurrentSendPlanQty(currentBen.getCurrentSendPlanQty());
            result.getData().get(0).setCurrentSendNum(currentBen.getCurrentSendNum());
        }
        /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 end */

        return result;
    }

    /**
     * （发货签字）
     * @param sc182101Bean
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Model model,SC182101Bean sc182101Bean){
        BaseParam baseParam = new BaseParam();
        this.setCommonParam(baseParam);
        //获取当前用户信息
        sc182101Bean.setCrtId(baseParam.getCrtId());

        sc182102Logic.saveStock(sc182101Bean);

        model.addAttribute("userType",baseParam.getUserType());


        return "ds/SC182101";
    }

    /**
     *收货签字（测试用）
     * @param sc182101Bean
     * @return
     */
    @RequestMapping(value="modify",method = RequestMethod.POST)
    public String modify(Model model,SC182101Bean sc182101Bean) {
        BaseParam baseParam = new BaseParam();
        this.setCommonParam(baseParam);
        //获取当前用户信息
        sc182101Bean.setCrtId(baseParam.getCrtId());

        model.addAttribute("userType",baseParam.getUserType());

        sc182102Logic.modifyStock(sc182101Bean);

        return "ds/SC182101";
    }

}
