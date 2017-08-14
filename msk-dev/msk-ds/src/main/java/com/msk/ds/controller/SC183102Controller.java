package com.msk.ds.controller;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.SC183102Bean;
import com.msk.ds.logic.SC183102Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SC183102Controller
 *
 * @author fjm
 *
 */
@Controller
@RequestMapping("SC183102")
public class SC183102Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SC183102Controller.class);

    /** SC183102Logic */
    @Autowired
    private SC183102Logic sc183102Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("计划调整一览初始化");
        return "ds/SC183102";
    }

    /**
     * 分页查询数据
     *
     * @param  pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<SC183102Bean> search(BasePageParam pageParam) {
        logger.debug("计划调整一览查询");
        this.setCommonParam(pageParam);

        if(CommCodeMasterConst.LoginUserType.SELLER.equals(pageParam.getUserType())){
            pageParam.getFilterMap().put("crtId", pageParam.getCrtId());
        }

        DbUtils.buildLikeCondition(pageParam, "suppDsId", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "planFlowId", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "distMonth", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "lgcsName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "suppName", DbUtils.LikeMode.FRONT);
//        DbUtils.buildLikeCondition(pageParam, "pdStockType", DbUtils.LikeMode.FRONT);
//        DbUtils.buildLikeCondition(pageParam, "halfCode", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "classesCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "breedCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "featureCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "gradeCode", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "outSpec", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "outNw", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "pdCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "normsCode", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "adjustDate", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(pageParam, "oldPlanNum", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "newPlanNum", DbUtils.LikeMode.FRONT);

        String halfCode = StringUtil.toSafeString(pageParam.getFilterMap().get("halfCode"));
        String pdStockType = StringUtil.toSafeString(pageParam.getFilterMap().get("pdStockType"));
        if (!StringUtil.isNullOrEmpty(halfCode)) {
            String[] halfCodes = halfCode.split(",");
            pageParam.getFilterMap().put("halfCodes", halfCodes);
        }
        if (!StringUtil.isNullOrEmpty(pdStockType)) {
            String[] pdStockTypes = pdStockType.split(",");
            pageParam.getFilterMap().put("pdStockTypes", pdStockTypes);
        }

        return sc183102Logic.findPage(pageParam, SC183102Bean.class);
    }


    /**
     * 删除数据
     * @param
     * @return
     */
    @RequestMapping(value = "delete",
            method = RequestMethod.POST)
    public String delete(@RequestParam(value = "suppDsId", required = false) Long suppDsId,@RequestParam(value = "planFlowId", required = false) Long planFlowId) {
        logger.debug("删除");
        SC183102Bean sc183102Bean = new SC183102Bean();
        sc183102Bean.setSuppDsId(suppDsId);
        sc183102Bean.setPlanFlowId(planFlowId);
        this.sc183102Logic.deleteBean(sc183102Bean);
        return "ds/SC183102";
    }
}
