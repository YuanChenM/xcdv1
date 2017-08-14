package com.msk.ds.controller;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.SC181102Param;
import com.msk.ds.bean.SC182101Bean;
import com.msk.ds.bean.SC182102Param;
import com.msk.ds.logic.SC182101Logic;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * SC182101Controller
 *
 * @author pxg
 *
 */
@Controller
@RequestMapping("SC182101")
public class SC182101Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SC182101Controller.class);

    /** SC182101Logic */
    @Autowired
    private SC182101Logic sc182101Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("收货入库通知单初始化");
        BaseParam baseParam = new BaseParam();
        this.setCommonParam(baseParam);

        model.addAttribute("userType",baseParam.getUserType());

        return "ds/SC182101";
    }

    /**
     * 分页查询数据
     *
     * @param pageParam pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<SC182101Bean> search(BasePageParam pageParam) {
        logger.debug("收货入库通知单查询");
        this.buildLikeCondition(pageParam);
        /** 应上海需求 #1629 modify by likai1 on 2016/8/4 start */
        //分页结果
        PageResult<SC182101Bean> pageResult = sc182101Logic.findPage(pageParam,SC182101Bean.class);

        List<SC182101Bean> sc182101BeanList = pageResult.getData();
        /** 修改sql后调整,create by likai on 2016/8/16 start */
        pageParam.setPaging(false);
        SC182101Bean totalListBean = this.sc182101Logic.getCurrentInfo(pageParam);
        if (pageResult.getRecordsTotal() > NumberConst.IntDef.INT_ZERO) {
            SC182101Bean sc182101Bean = sc182101BeanList.get(NumberConst.IntDef.INT_ZERO);
            //所有数据合计
            if (null != totalListBean) {
                sc182101Bean.setTotalDifferNum(totalListBean.getCurrentDifferNum());
                sc182101Bean.setTotalDifferQty(totalListBean.getCurrentDifferQty());
                sc182101Bean.setTotalReceiveNum(totalListBean.getCurrentReceiveNum());
                sc182101Bean.setTotalRecriveQty(totalListBean.getCurrentRecriveQty());
                sc182101Bean.setTotalSendActualNum(totalListBean.getCurrentSendActualNum());
                sc182101Bean.setTotalSendActualQty(totalListBean.getCurrentSendActualQty());
                sc182101Bean.setTotalSendPlanQty(totalListBean.getCurrentSendPlanQty());
                sc182101Bean.setTotalSendPlanNum(totalListBean.getCurrentSendPlanNum());
            }
            for (SC182101Bean sc182101Bean1 : sc182101BeanList) {
                //本页面合计

                sc182101Bean.setCurrentDifferNum(DecimalUtil.add(sc182101Bean1.getDifferNum(),sc182101Bean.getCurrentDifferNum()));
                sc182101Bean.setCurrentDifferQty(DecimalUtil.add(sc182101Bean1.getDifferQty(),sc182101Bean.getCurrentDifferQty()));
                sc182101Bean.setCurrentReceiveNum(DecimalUtil.add(sc182101Bean1.getReceiveNum(),sc182101Bean.getCurrentReceiveNum()));
                sc182101Bean.setCurrentRecriveQty(DecimalUtil.add(sc182101Bean1.getRecriveQty(),sc182101Bean.getCurrentRecriveQty()));
                sc182101Bean.setCurrentSendActualNum(DecimalUtil.add(sc182101Bean1.getSendActualNum(),sc182101Bean.getCurrentSendActualNum()));
                sc182101Bean.setCurrentSendActualQty(DecimalUtil.add(sc182101Bean1.getSendActualQty(),sc182101Bean.getCurrentSendActualQty()));
                sc182101Bean.setCurrentSendPlanQty(DecimalUtil.add(sc182101Bean1.getSendPlanQty(),sc182101Bean.getCurrentSendPlanQty()));
                sc182101Bean.setCurrentSendPlanNum(DecimalUtil.add(sc182101Bean1.getSendPlanNum(),sc182101Bean.getCurrentSendPlanNum()));

            }
        }

        /** 修改sql后调整,create by likai on 2016/8/16 end */


        return pageResult;
    }

    /**
     * 删除数据
     //* @param model
     * @return
     */
    @RequestMapping(value = "delete",
            method = RequestMethod.POST)
    public String delete(SC182101Bean bean,BaseParam baseParam) {
        logger.debug("删除");
        //versionValidator   update前需先版本验证
        baseParam.getFilterMap().put("deliveryStockId", bean.getDeliveryStockId());
        bean = sc182101Logic.findOne(baseParam);
        bean.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ONE));
        int resultCount = sc182101Logic.modify(bean);

        if (resultCount <= NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("删除失败，请重新操作！");
        }
        return "ds/SC182101";
    }

    /** #1931,create by likai on 2016/8/17 start */
    /**
     * 导出excel
     * @param
     * @param response
     */
    @RequestMapping(value = "exportDeliveryData", method = RequestMethod.POST)
    public void export(BasePageParam pageParam, HttpServletResponse response) throws IOException {
        String fileName = " delivery__" + DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD,DateTimeUtil.getCustomerDate()) + ".xlsx";
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "ISO8859-1"));
        OutputStream outputStream = response.getOutputStream();
        this.buildLikeCondition(pageParam);
        this.sc182101Logic.exportDeliveryData(outputStream,pageParam);

    }

    /**
     * 设置检索条件
     * @param pageParam
     */
    public void buildLikeCondition(BasePageParam pageParam) {
        this.setCommonParam(pageParam);

        if(CommCodeMasterConst.LoginUserType.SELLER.equals(pageParam.getUserType())){
            pageParam.getFilterMap().put("crtId", pageParam.getCrtId());
        }

        DbUtils.buildLikeCondition(pageParam, "deliveryStockId", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "distMonth", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "lgcsName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "suppName", DbUtils.LikeMode.FRONT);
        /** 应上海需求修改显示字段 modify by likai1 2016/8/2 start */
        DbUtils.buildLikeCondition(pageParam, "deliveryReceiveStockTime", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "senPlanNum", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "sendActualNum", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "receiveNum", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "manuName", DbUtils.LikeMode.FRONT);
        /** 应上海需求修改显示字段 modify by likai1 2016/8/2 end */

        String halfCode = StringUtil.toSafeString(pageParam.getFilterMap().get("halfName"));
        String deliveryStockStatus = StringUtil.toSafeString(pageParam.getFilterMap().get("statusName"));
        if (!StringUtil.isNullOrEmpty(halfCode)) {
            String[] halfCodes = halfCode.split(",");
            pageParam.getFilterMap().put("halfCodes", halfCodes);
        }
        if (!StringUtil.isNullOrEmpty(deliveryStockStatus)) {
            String[] deliveryStocks = deliveryStockStatus.split(",");
            pageParam.getFilterMap().put("deliveryStocks", deliveryStocks);
        }
    }
    /** #1931,create by likai on 2016/8/17 end */

}
