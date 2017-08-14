package com.msk.gs.controller;

import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.gs.bean.GS200001Param;
import com.msk.gs.logic.GS200001Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * sql查询器页面Controller.
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "GS200001")
public class GS200001Controller extends BaseController {
    @Autowired
    private GS200001Logic gs200001Logic;
    /**
     * 实例化页面
     * 
     * @return sql查询器页面
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init() {
        return "/gs/GS200001";
    }
    /**
     * 实例化页面
     *
     * @return sql查询器子页面
     */
    @RequestMapping(value = "initSon",
            method = RequestMethod.POST)
    public String initSon(Model model,GS200001Param param){
        //String[] fieldArray=gs200001Logic.returnField(param);
        //model.addAttribute("fieldArray", fieldArray);
        if(StringUtil.isNullOrEmpty(param.getSqlInfo())){
            throw new BusinessException("请输入Sql语句！");
        }
        model.addAttribute("fields",gs200001Logic.findResult(param));
        return "/gs/GS20000101";
    }
}
