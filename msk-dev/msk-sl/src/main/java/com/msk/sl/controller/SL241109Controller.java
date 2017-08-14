package com.msk.sl.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.SL241109Bean;
import com.msk.sl.logic.SL241109Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("SL241109")
public class SL241109Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SL241109Controller.class);
    
    @Autowired
    private SL241109Logic sl241109Logic;
    
    /**
     * 实例化页面
     * 
     * @return 分销章程列表
     */
    @RequestMapping(value="init/{chapClass}",method=RequestMethod.POST)
    private String init(@PathVariable(value = "chapClass")String chapClass,Model model){
        model.addAttribute("chapClass",chapClass);
        return "sl/SL241109";
    }
    
    /**
     * 查询审批审核列表
     * @param basePageParam
     * @return 查询审批审核列表
     * @author gyh
     */
    @RequestMapping(value="search/{chapClass}",method=RequestMethod.POST)
    public @ResponseBody PageResult<SL241109Bean> search(@PathVariable(value = "chapClass")String chapClass,BasePageParam basePageParam){
        basePageParam.setFilter("chapClass",chapClass);
        DbUtils.buildLikeCondition(basePageParam, "chapNo", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam,"chapTitle", DbUtils.LikeMode.FRONT);
        if(isDebug){
            return this.sl241109Logic.getListInfo();
        }
        return this.sl241109Logic.findPage(basePageParam, SL241109Bean.class);
    }
}
