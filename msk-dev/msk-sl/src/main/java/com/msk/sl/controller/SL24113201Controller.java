package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.entity.SlAccount;
import com.msk.core.entity.SlEpHonor;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.*;
import com.msk.sl.logic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fjm on 2016/1/28.
 */
@Controller
@RequestMapping("SL24113201")
public class SL24113201Controller extends BaseController{

    @Autowired
    private SL24113201Logic sl24113201Logic;
    @Autowired
    private CommonLogic commonLogic;
    /**
     * 编辑初始化页面
     * @param model model
     * @return String
     */

    @RequestMapping(value="init",method = RequestMethod.POST)
    public  String init(SL241132Bean sl241132Bean,Model model){
        List<CommConstant> list=commonLogic.findConstantList("saleStatus");
        model.addAttribute("slPdArtnos",sl241132Bean);
        model.addAttribute("list",list);
        return "sl/SL24113201";
    }
    /**
     * 编辑初始化页面
     * @param sl241132Bean sl241132Bean
     * @return String
     */

    @RequestMapping(value="save",method = RequestMethod.POST)
    public @ResponseBody int save(SL241132Bean sl241132Bean){
        int num=sl24113201Logic.modify(sl241132Bean);
        return num;
    }
}
