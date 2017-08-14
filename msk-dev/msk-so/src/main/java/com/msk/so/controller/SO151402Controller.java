package com.msk.so.controller;

import java.util.ArrayList;
import java.util.List;

import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151401Bean;
import com.msk.so.bean.SO151402Bean;
import com.msk.so.bean.order.BaseOrderStatusParam;
import com.msk.so.logic.SO151401Logic;
import com.msk.so.logic.SO151402Logic;
import com.msk.so.logic.order.OrderStatusHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.msk.common.consts.StatusConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.orderstatus.OrderStatusContext;

/**
 * @author chen_xin
 * @version 创建时间：2015年12月25日 下午1:58:30
 *          类说明
 */

@Controller
@RequestMapping("SO151402")
public class SO151402Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO151402Controller.class);

    @Autowired
    private SO151402Logic so151402Logic;
    @Autowired
    private SO151401Logic SO151401Logic;
    @Autowired
    private OrderStatusHandle orderStatusHandle;
    
    @Autowired
    private OrderStatusContext orderStatusContext;

    /**
     * 订单明细详细信息页面
     * 
     * @param orderId 订单编号
     * @param model Model
     * @return 订单明细详细信息页面
     * update gyh
     * updateTime 2016.1.5
     */
    @RequestMapping(value = "init/{orderId}",
        method = RequestMethod.POST)
    public String init(@PathVariable("orderId") String orderId,@RequestParam("enterMark") String enterMark, Model model) {
        logger.debug("订单明细详细信息");
        List<SO151402Bean> so251108Beans = new ArrayList<SO151402Bean>();
        if (isDebug) {
            so251108Beans = this.so151402Logic.queryResult();
        }else{
            so251108Beans =this.so151402Logic.findOrderDetailInfo(orderId);
        }

        //得到订单状态和类型
        BaseParam param = new BaseParam();
        param.getFilterMap().put("orderId",orderId);
        int childCount = so151402Logic.getChild(param);

        SO151402Bean so151402Bean = so151402Logic.findOne(param);
        if(childCount > NumberConst.IntDef.INT_ZERO){
            so151402Bean.setChildFlag(NumberConst.IntDef.INT_ONE);
        }else {
            so151402Bean.setChildFlag(NumberConst.IntDef.INT_ZERO);
        }
        model.addAttribute("so151402Bean",so151402Bean);

        model.addAttribute("so251108Beans", so251108Beans);
        if(!CollectionUtils.isEmpty(so251108Beans)){
            model.addAttribute("orderCode", so251108Beans.get(0).getOrderCode());
            model.addAttribute("orderStatusName",so251108Beans.get(0).getDetailStatusName());
        }
        model.addAttribute("orderId", orderId);
        model.addAttribute("enterMark", enterMark);
        // #1129 add by sjj 20160712 start
        model.addAttribute("printUrl", ConfigManager.getApiPrintOrderUrl());
        model.addAttribute("callBackUrl", ConfigManager.getApiSearchPrintOrderUrl());
        // #1129 add by sjj 20160712 end
        return "so/SO151402";
    }
    /**
     * 订单明细完成
     *
     * @param param Param
     * @return 订单明细详细信息页面
     */
/*    @RequestMapping(value = "allReceipt",method = RequestMethod.POST)
    public @ResponseBody String orderAllReceipt(OrderStatusParam param){
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        param.setNewStatus(StatusConst.OrderStatusDef.ALL_RECEIPT);
        orderStatusContext.handle(param);
        return "1";*/
    @RequestMapping(value = "allReceipt",method = RequestMethod.POST)
    public String orderAllReceipt(OrderStatusParam param,Model model){
        super.setCommonParam(param);
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        param.setNewStatus(StatusConst.OrderStatusDef.ALL_RECEIPT);
        orderStatusContext.handle(param);
        // Modify for Bug#2317 at 2016/09/19 by sun_jiaju Start
        logger.debug("初始化页面");
        return this.init(String.valueOf(param.getOrderId()),"init",model);
        // Modify for Bug#2317 at 2016/09/19 by sun_jiaju End
    }

    @RequestMapping(value = "orderPayment",method = RequestMethod.POST)
    public String orderPayment(SO151401Bean bean,Model model){
        BaseParam param = new BaseParam();
        super.setCommonParam(param);
        so151402Logic.modifyOrderPayment(bean.getOrderId(),param.getUpdId());
        logger.debug("初始化页面");
        return this.init(bean.getOrderId(),"init",model);
        // Modify for Bug#2317 at 2016/09/19 by sun_jiaju End
    }

    /**
     * 订单删除
     *
     * @param bean bean
     * @return 订单列表页面
     */
    @RequestMapping(value = "realDelete",method = RequestMethod.POST)
    public String realDelete(SO151401Bean bean,Model model){
        so151402Logic.deleteOrder(bean.getOrderId());

        List<SO151401Bean> districtList = new ArrayList<>();
        districtList = SO151401Logic.findDistrict();
        List<SO151401Bean> typeList = new ArrayList<>();
        typeList = SO151401Logic.findOrderType();
        model.addAttribute("districtList",districtList);
        model.addAttribute("typeList",typeList);
        logger.debug("初始化页面");
        return "so/SO151401";
    }

    /**
     * 订单取消
     *
     * @param bean bean
     * @return 订单列表页面
     */
    @RequestMapping(value = "cancel",method = RequestMethod.POST)
    public String cancel(SO151401Bean bean,Model model){
        BaseOrderStatusParam param = new BaseOrderStatusParam();
        super.setCommonParam(param);
        param.setOrderId(StringUtil.toLong(bean.getOrderId()));
        param.setVer(StringUtil.toInteger(bean.getVer()));
        param.setCancelType(NumberConst.IntDef.INT_ONE);
        param.setOrderType(StringUtil.toInteger(bean.getOrderType()));
        this.orderStatusHandle.modifyOrderCancel(param);
        // Modify for Bug#2317 at 2016/09/19 by sun_jiaju Start
        logger.debug("初始化页面");
        return this.init(bean.getOrderId(),"init",model);
        // Modify for Bug#2317 at 2016/09/19 by sun_jiaju End
    }
    /**
     * 订单确认
     *
     * @param bean bean
     * @return 订单列表页面
     */
    @RequestMapping(value = "confirm",method = RequestMethod.POST)
    public String commit(SO151401Bean bean,Model model){
        SO151401Logic.modifyOrderStu(bean);
        return this.init(bean.getOrderId(),"init",model);
    }
}
