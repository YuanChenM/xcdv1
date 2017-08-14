package com.msk.ds.controller;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.bean.LoginUser;
import com.msk.ds.logic.*;
import com.msk.ds.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SC182203Controller
 *
 * @author yi_qixiang
 *
 */
@Controller
@RequestMapping("SC182203")
public class SC182203Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SC182203Controller.class);

    /** sc182203Logic */
    @Autowired
    private SC182203Logic sc182203Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(SC182203Param sc182203Param,Model model) {
        logger.debug("产品批次查询");
        return "ds/SC182203";
    }



    /**
     * 分页查询数据
     *
     * @param  pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody
    PageResult<SC182203Bean> search(BasePageParam pageParam) {
        logger.debug("产品批次查询");
        this.setCommonParam(pageParam);

        DbUtils.buildLikeCondition(pageParam, "halfPeriod", DbUtils.LikeMode.FRONT);
//        DbUtils.buildLikeCondition(pageParam, "lgcsName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "proLotNum", DbUtils.LikeMode.FRONT);

        String lgcsName = StringUtil.toSafeString(pageParam.getFilterMap().get("lgcsName"));
        if (!StringUtil.isNullOrEmpty(lgcsName)) {
            String[] lgcsNames = lgcsName.split(",");
            pageParam.getFilterMap().put("lgcsNames", lgcsNames);
        }


        return sc182203Logic.findPage(pageParam, SC182203Bean.class);

    }



}
