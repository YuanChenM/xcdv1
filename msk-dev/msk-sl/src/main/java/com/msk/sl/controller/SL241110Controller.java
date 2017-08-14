package com.msk.sl.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.SL241110Bean;
import com.msk.sl.logic.SL241110Logic;
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
 * 卖家意见查询
 * SL241110Controller.
 *
 * @author Administrator
 */


@Controller
@RequestMapping(value = "SL241110")
public class SL241110Controller extends BaseController {

    @Autowired
    private SL241110Logic sL241110Logic;
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SL241110Controller.class);

    /**
     * 实例化页面
     *
     * @param chapId 章节ID
     * @param model  参数
     * @return 页面
     */
    @RequestMapping(value = "init/{chapId}/{chapNo}/{chapClass}", method = RequestMethod.POST)
    public String init(@PathVariable(value = "chapId") String chapId,@PathVariable(value = "chapNo") String chapNo,@PathVariable(value = "chapClass") String chapClass, Model model) {
        logger.info("logger");
        model.addAttribute("chapId", chapId);
        model.addAttribute("chapNo", chapNo);
        model.addAttribute("chapClass", chapClass);
        return "sl/SL241110";
    }

    /**
     * 查询章程卖家信息列表
     *
     * @param basePageParam
     * @return
     */
    @RequestMapping(value = "search/{chapId}/{chapClass}", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SL241110Bean> search(@PathVariable(value = "chapId") String chapId,@PathVariable(value = "chapClass") String chapClass, BasePageParam basePageParam) {
        basePageParam.setFilter("chapId", chapId);
        basePageParam.setFilter("chapClass",chapClass);
        DbUtils.buildLikeCondition(basePageParam, "epName", DbUtils.LikeMode.FRONT);
        String agreeFlgName = StringUtil.toSafeString(basePageParam.getFilterMap().get("agreeFlgName"));
        if (!StringUtil.isNullOrEmpty(agreeFlgName)) {
            String[] agreeFlgNames = agreeFlgName.split(",");
            basePageParam.getFilterMap().put("agreeFlgNames", agreeFlgNames);
        }
        return this.sL241110Logic.findPage(basePageParam, SL241110Bean.class);
    }

}
