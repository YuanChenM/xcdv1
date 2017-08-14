package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151401Bean;
import com.msk.so.logic.SO151401Logic;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * OM141101Controller
 *
 * @author rwf
 * @version 1.0
 **/
@Controller
@RequestMapping("SO151401")
@SessionAttributes("param")
public class SO151401Controller extends BaseController {
    /**
     * logger
     *
     * @author rwf
     */
    private static Logger logger = LoggerFactory.getLogger(SO151401Controller.class);
    @Autowired
    private SO151401Logic SO151401Logic;

    /**
     * 加载订单列表界面
     *
     * @return String
     **/
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(BasePageParam param,Model model) {
        //model.addAttribute("param",param);
        List<SO151401Bean> districtList = new ArrayList<>();
        districtList = SO151401Logic.findDistrict();
        List<SO151401Bean> typeList = new ArrayList<>();
        typeList = SO151401Logic.findOrderType();

 /*       List<SO151401Bean> sourceList = new ArrayList<>();
        sourceList = SO151401Logic.findOrderSource();*/

       // param.setFilterObject("districtList", districtList);
        model.addAttribute("districtList",districtList);
        model.addAttribute("typeList",typeList);
//        model.addAttribute("sourceList",sourceList);
        logger.debug("初始化页面");
        return "so/SO151401";
    }

    /**
     * @return PageResult<OM141101Bean>
     * @author rwf
     * @param basePageParam basePageParam
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<SO151401Bean> search(BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "orderId", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "orderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "requireOrderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "confirmOrderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "deliveryOrderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyersCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "frozenGoodsHousekeep", DbUtils.LikeMode.PARTIAL);
//        DbUtils.buildLikeCondition(basePageParam, "buyersName", DbUtils.LikeMode.FRONT);
        String buyersName = basePageParam.getFilterMap().get("buyersName").toString();

        if (buyersName.contains(StringConst.UNDERLINE)) {
            buyersName = buyersName.replace(StringConst.UNDERLINE,
                    "\\" + StringConst.UNDERLINE);
        }
        basePageParam.getFilterMap().put("buyersName",buyersName);
        if (isDebug) {
            logger.info("假数据");
            // 获取假数据
            return SO151401Logic.findOrderList();
        }
        String orderStatus = basePageParam.getFilterMap().get("orderStatus").toString();
        if (orderStatus.contains("15")){
            basePageParam.setFilterObject("allReturn", NumberConst.IntDef.INT_ONE);
        } else {
            basePageParam.setFilterObject("allReturn", NumberConst.IntDef.INT_ZERO);
        }
        // #1512 update by sjj 20160808 start
        String[] orderStatusArray = orderStatus.split(StringConst.COMMA);
        basePageParam.setFilterObject("orderStatusArray", orderStatusArray);
        // #1512 update by sjj 20160808 end
        logger.info("查询数据库");
        //Modify for bug#1154 at 2016/07/19 by wang_jianzhou Start.
        PageResult<SO151401Bean> results = this.SO151401Logic.search(basePageParam);
        return results;
        //Modify for bug#1154 at 2016/07/19 by wang_jianzhou end.
    }


    /**
     *
     * @param basePageParam
     * @param response
     * @param orderId
     * @param orderCode
     * @param orderTimeStart
     * @param orderTimeEnd
     * @param buyersCode
     * @param confirmOrderCode
     * @param buyersName
     * @param returnFlg
     * @param splitDeliveryFlg
     * @param needInvoice
     * @param districtName
     * @param status
     * @param orderSource
     * @param orderType
     * @param orderStatus
     * @throws Exception
     */

    @RequestMapping(value = "dataExport", method = RequestMethod.POST)
    public void export(BasePageParam basePageParam, HttpServletResponse response, String orderId, String orderCode,
                       String orderTimeStart, String orderTimeEnd, String buyersCode, String confirmOrderCode, String buyersName,
                       String returnFlg, String splitDeliveryFlg, String needInvoice, String frozenGoodsHousekeep,
                       String districtName, String status, String orderSource, String orderType, String orderStatus)throws  Exception{

        basePageParam.getFilterMap().put("orderId",orderId);
        basePageParam.getFilterMap().put("orderCode",orderCode);
        basePageParam.getFilterMap().put("orderTimeStart",orderTimeStart);
        basePageParam.getFilterMap().put("orderTimeEnd",orderTimeEnd);
        basePageParam.getFilterMap().put("buyersCode",buyersCode);
        basePageParam.getFilterMap().put("confirmOrderCode",confirmOrderCode);
        basePageParam.getFilterMap().put("returnFlg",returnFlg);
        basePageParam.getFilterMap().put("splitDeliveryFlg",splitDeliveryFlg);
        basePageParam.getFilterMap().put("needInvoice",needInvoice);
        basePageParam.getFilterMap().put("status",status);
        basePageParam.getFilterMap().put("districtName",districtName);
        basePageParam.getFilterMap().put("orderSource",orderSource);
        basePageParam.getFilterMap().put("orderType",orderType);
        basePageParam.getFilterMap().put("orderStatus",orderStatus);
        basePageParam.getFilterMap().put("buyersName",buyersName);

        basePageParam.getFilterMap().put("frozenGoodsHousekeep",frozenGoodsHousekeep);



        DbUtils.buildLikeCondition(basePageParam, "orderId", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "orderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "requireOrderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "confirmOrderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "deliveryOrderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyersCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "frozenGoodsHousekeep", DbUtils.LikeMode.PARTIAL);



        if(basePageParam.getFilterMap().get("buyersName")!=null){
            String buyersNameStr = basePageParam.getFilterMap().get("buyersName").toString();
            if (buyersNameStr.contains(StringConst.UNDERLINE)) {
                buyersNameStr = buyersName.replace(StringConst.UNDERLINE,
                        "\\" + StringConst.UNDERLINE);
            }
            basePageParam.getFilterMap().put("buyersName",buyersNameStr);
        }
        if (orderStatus.contains("15")){
            basePageParam.setFilterObject("allReturn", NumberConst.IntDef.INT_ONE);
        } else {
            basePageParam.setFilterObject("allReturn", NumberConst.IntDef.INT_ZERO);
        }
        // #1512 update by sjj 20160808 start
        String[] orderStatusArray = basePageParam.getFilterMap().get("orderStatus").toString().split(StringConst.COMMA);
        basePageParam.setFilterObject("orderStatusArray", orderStatusArray);
        // #1512 update by sjj 20160808 end
        Workbook workbook= this.SO151401Logic.export1(basePageParam);
        Date date= DateTimeUtil.getCustomerDate();
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr=sf.format(date);
        OutputStream o = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename="+ "order-"+dateStr+".xlsx");// the dialogbox of download file.
        response.setContentType("application/vnd.ms-excel");// set the MIME type.
        workbook.write(o);


    }

    /**
     * 订单列表打印用报表
     * @param basePageParam
     * @param response
     * @param orderId
     * @param orderCode
     * @param orderTimeStart
     * @param orderTimeEnd
     * @param buyersCode
     * @param confirmOrderCode
     * @param buyersName
     * @param returnFlg
     * @param splitDeliveryFlg
     * @param needInvoice
     * @param districtName
     * @param status
     * @param orderSource
     * @param orderType
     * @param orderStatus
     * @throws Exception
     */
    @RequestMapping(value = "exportOrder", method = RequestMethod.POST)
    public void exportOrder(BasePageParam basePageParam, HttpServletResponse response,String orderId, String orderCode,
                            String orderTimeStart, String orderTimeEnd, String buyersCode, String confirmOrderCode, String buyersName,
                            String returnFlg, String splitDeliveryFlg, String needInvoice, String frozenGoodsHousekeep,
                            String districtName, String status, String orderSource, String orderType, String orderStatus)throws  Exception{
        basePageParam.getFilterMap().put("orderId",orderId);
        basePageParam.getFilterMap().put("orderCode",orderCode);
        basePageParam.getFilterMap().put("orderTimeStart",orderTimeStart);
        basePageParam.getFilterMap().put("orderTimeEnd",orderTimeEnd);
        basePageParam.getFilterMap().put("buyersCode",buyersCode);
        basePageParam.getFilterMap().put("confirmOrderCode",confirmOrderCode);
        basePageParam.getFilterMap().put("returnFlg",returnFlg);
        basePageParam.getFilterMap().put("splitDeliveryFlg",splitDeliveryFlg);
        basePageParam.getFilterMap().put("needInvoice",needInvoice);
        basePageParam.getFilterMap().put("status",status);
        basePageParam.getFilterMap().put("districtName",districtName);
        basePageParam.getFilterMap().put("orderSource",orderSource);
        basePageParam.getFilterMap().put("orderType",orderType);
        basePageParam.getFilterMap().put("orderStatus",orderStatus);
        basePageParam.getFilterMap().put("buyersName",buyersName);
        basePageParam.getFilterMap().put("frozenGoodsHousekeep",frozenGoodsHousekeep);

        DbUtils.buildLikeCondition(basePageParam, "orderId", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "orderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "requireOrderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "confirmOrderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "deliveryOrderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyersCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "frozenGoodsHousekeep", DbUtils.LikeMode.PARTIAL);
        if(basePageParam.getFilterMap().get("buyersName")!=null){
            String buyersNameStr = basePageParam.getFilterMap().get("buyersName").toString();
            if (buyersNameStr.contains(StringConst.UNDERLINE)) {
                buyersNameStr = buyersName.replace(StringConst.UNDERLINE,
                        "\\" + StringConst.UNDERLINE);
            }
            basePageParam.getFilterMap().put("buyersName",buyersNameStr);
        }
        if (orderStatus.contains("15")){
            basePageParam.setFilterObject("allReturn", NumberConst.IntDef.INT_ONE);
        } else {
            basePageParam.setFilterObject("allReturn", NumberConst.IntDef.INT_ZERO);
        }
        // #1512 update by sjj 20160808 start
        String[] orderStatusArray = basePageParam.getFilterMap().get("orderStatus").toString().split(StringConst.COMMA);
        basePageParam.setFilterObject("orderStatusArray", orderStatusArray);
        // #1512 update by sjj 20160808 end
        basePageParam.setPaging(false);
        logger.info("查询数据库");
        PageResult<SO151401Bean> result = this.SO151401Logic.findPage(basePageParam, SO151401Bean.class);
        Workbook workbook= this.SO151401Logic.exportOrder(result.getData());
        Date date= DateTimeUtil.getCustomerDate();
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr=sf.format(date);
        OutputStream o = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename="+ "order-"+dateStr+".xlsx");// the dialogbox of download file.
        response.setContentType("application/vnd.ms-excel");// set the MIME type.
        workbook.write(o);
    }

}