package com.msk.bp.controller;

import com.msk.bp.bean.BP112215Bean;
import com.msk.bp.logic.BP112215Logic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * BP112215Controller
 *
 * @author yang_yang
 *
 */
@Controller
@RequestMapping("BP112215")
public class BP112215Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BP112215Controller.class);

    @Autowired
    private BP112215Logic bp112215Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model) {

        logger.debug("价盘平台查看画面初始化");

        return "bp/BP112215";
    }

    /**
     * 分页查询数据
     *
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<BP112215Bean> search(BasePageParam pageParam) {
        logger.debug("价盘平台查看查询");
        //判断当前用户登录是否失效
        this.getLoginUser();
        String breedName = (String) pageParam.getFilterMap().get("pdName");
        List<BP112215Bean> beans = this.bp112215Logic.getBreeds(breedName.trim());
        if(beans != null && beans.size() == 0){
            BP112215Bean bp = new BP112215Bean();
            bp.setPdCode("-1");
            beans.add(bp) ;
        }
        pageParam.getFilterMap().put("pdCodeList",beans);

        DbUtils.buildLikeCondition(pageParam, "logiareaName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "slName", DbUtils.LikeMode.FRONT);

        return bp112215Logic.findBP112215List(pageParam);
    }

    /**
     * 获取订单等级列表
     * @param param
     * @return
     */
    @RequestMapping(value = "findOrderLevelList", method = RequestMethod.POST)
    public @ResponseBody List<BP112215Bean> findOrderLevelList(BaseParam param) {
        logger.debug("获取订单等级列表");

        return bp112215Logic.getOrderLevelList(param);
    }

}
