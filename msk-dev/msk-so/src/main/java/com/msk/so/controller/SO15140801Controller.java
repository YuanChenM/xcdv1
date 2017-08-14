package com.msk.so.controller;

import com.msk.common.consts.OrderConst;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.PdOrderlevel;
import com.msk.core.entity.PdPriceprdLogiarea;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.pd.logic.PriceprdLogiareaLogic;
import com.msk.so.bean.ProductStock;
import com.msk.so.bean.SuppStock;
import com.msk.so.logic.SO15140801Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * SO15140801Controller
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("SO15140801")
public class SO15140801Controller extends BaseController{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SO15140801Controller.class);
    @Autowired
    private PriceprdLogiareaLogic priceprdLogiareaLogic;
    @Autowired
    private SO15140801Logic so15140801Logic;

    /**
     * 订单新增时,选择卖家产品信息
     * @return 卖家产品选择页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(ProductStock productStock,Model model){
        logger.debug("进入页面");

        Integer orderType = Integer.valueOf(productStock.getSalePlatform());
        boolean isSupp = true;
        if(OrderConst.OrderType.DISTRIBUTION_ORDER == orderType || OrderConst.OrderType.BUYER_STOCKPILING_ORDER  == orderType
                || OrderConst.OrderType.BUYER_SALE_ORDER == orderType){
            isSupp = false;
        }

        model.addAttribute("productStock",productStock);
        model.addAttribute("isSupp",isSupp);
        return "/so/SO15140801";
    }


    /**
     * 订单新增时,选择卖家产品信息
     * @return 卖家产品选择页面
     */
    @RequestMapping(value = "init2",method = RequestMethod.POST)
    public String init2(ProductStock productStock,Model model){
        logger.debug("进入页面");

        Integer orderType = Integer.valueOf(productStock.getSalePlatform());
        boolean isSupp = true;
        if(OrderConst.OrderType.DISTRIBUTION_ORDER == orderType || OrderConst.OrderType.BUYER_STOCKPILING_ORDER  == orderType
                || OrderConst.OrderType.BUYER_SALE_ORDER == orderType){
            isSupp = false;
        }

        model.addAttribute("productStock",productStock);
        model.addAttribute("isSupp",isSupp);
        return "/so/SO15140802";
    }


    /**
     * 卖家产品查询获得数据
     * @param pageParam BasePageParam
     * @return 卖家产品JSON数据
     */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public @ResponseBody PageResult<ProductStock> search(BasePageParam pageParam,ProductStock productStock){
        logger.debug("数据加载");
        DbUtils.buildLikeCondition(pageParam, "classesName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "breedName", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "featureName", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "pdCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "pdName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "lgcsName", DbUtils.LikeMode.FRONT);

        Integer orderType = Integer.valueOf(productStock.getSalePlatform());
        String salePlatform = "2";//美食客
        if(OrderConst.OrderType.DISTRIBUTION_ORDER == orderType || OrderConst.OrderType.BUYER_STOCKPILING_ORDER  == orderType
                || OrderConst.OrderType.BUYER_SALE_ORDER == orderType){
            salePlatform = "1";//神龙客
        }

        pageParam.getFilterMap().put("slCode", productStock.getSlCode());
        pageParam.getFilterMap().put("lgcsCode", productStock.getLgcsCode());
        pageParam.getFilterMap().put("salePlatform", salePlatform);

        return this.so15140801Logic.findProductStockPage(pageParam);
    }

    @RequestMapping(value = "search2",method = RequestMethod.POST)
    public @ResponseBody PageResult<ProductStock> search2(BasePageParam pageParam,ProductStock productStock){
        logger.debug("数据加载");
        DbUtils.buildLikeCondition(pageParam, "classesName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "breedName", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "featureName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "unit", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "pdCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "pdName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "lgcsName", DbUtils.LikeMode.FRONT);

        Integer orderType = Integer.valueOf(productStock.getSalePlatform());
        String salePlatform = "2";//美食客
        if(OrderConst.OrderType.DISTRIBUTION_ORDER == orderType || OrderConst.OrderType.BUYER_STOCKPILING_ORDER  == orderType
                || OrderConst.OrderType.BUYER_SALE_ORDER == orderType){
            salePlatform = "1";//神龙客
        }

        pageParam.getFilterMap().put("slCode", productStock.getSlCode());
        pageParam.getFilterMap().put("lgcsCode", productStock.getLgcsCode());
        pageParam.getFilterMap().put("salePlatform", salePlatform);

        return this.so15140801Logic.findProductStockPage2(pageParam);
    }

    @RequestMapping(value = "searchSp",method = RequestMethod.POST)
    public @ResponseBody PageResult<SuppStock> searchSp(BasePageParam pageParam,SuppStock suppStock){
        logger.debug("数据加载");
        DbUtils.buildLikeCondition(pageParam, "classesName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "breedName", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "featureName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "unit", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "pdCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "pdName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "lgcsName", DbUtils.LikeMode.FRONT);

        Integer orderType = Integer.valueOf(suppStock.getSupplyPlatform());
        String salePlatform = "2";//美食客
        if(OrderConst.OrderType.DISTRIBUTION_ORDER == orderType || OrderConst.OrderType.BUYER_STOCKPILING_ORDER  == orderType
                || OrderConst.OrderType.BUYER_SALE_ORDER == orderType){
            salePlatform = "1";//神龙客
        }

        pageParam.getFilterMap().put("slCode", suppStock.getSlCode());
        pageParam.getFilterMap().put("lgcsCode", suppStock.getLgcsCode());
        pageParam.getFilterMap().put("supplyPlatform", salePlatform);

        return this.so15140801Logic.findSuppStockPage(pageParam);
    }

    @RequestMapping(value = "searchSp2",method = RequestMethod.POST)
    public @ResponseBody PageResult<SuppStock> searchSp2(BasePageParam pageParam,SuppStock suppStock){
        logger.debug("数据加载");
        DbUtils.buildLikeCondition(pageParam, "classesName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "breedName", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "featureName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "unit", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "pdCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "pdName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "lgcsName", DbUtils.LikeMode.FRONT);

        Integer orderType = Integer.valueOf(suppStock.getSupplyPlatform());
        String salePlatform = "2";//美食客
        if(OrderConst.OrderType.DISTRIBUTION_ORDER == orderType || OrderConst.OrderType.BUYER_STOCKPILING_ORDER  == orderType
                || OrderConst.OrderType.BUYER_SALE_ORDER == orderType){
            salePlatform = "1";//神龙客
        }

        pageParam.getFilterMap().put("slCode", suppStock.getSlCode());
        pageParam.getFilterMap().put("lgcsCode", suppStock.getLgcsCode());
        pageParam.getFilterMap().put("supplyPlatform", salePlatform);

        return this.so15140801Logic.findSuppStockPage2(pageParam);
    }


    @RequestMapping(value = "loadPrice",method = RequestMethod.POST)
    public @ResponseBody PdPriceprdLogiarea loadPrice(String pdCode,String orderNum){
        BaseParam param = new BaseParam();
        param.setFilter("pdCode",pdCode);
        param.setFilter("orderNum",orderNum);
        PdOrderlevel pdOrderlevel= priceprdLogiareaLogic.findOne(param);
        if(pdOrderlevel!=null){
            param.setFilter("orderlevelCode",pdOrderlevel.getOrderlevelCode());
        }else{
            throw new BusinessException("订单等级不存在！");
        }
        List<PdPriceprdLogiarea> pdPriceprdLogiareas= priceprdLogiareaLogic.findList(param);
        if(!CollectionUtils.isEmpty(pdPriceprdLogiareas)){
            return  pdPriceprdLogiareas.get(0);
        }
        return null;
    }
}
