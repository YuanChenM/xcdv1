package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.DS173103Param;
import com.msk.ds.logic.DS173103Logic;
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
 * DS173102Controller
 *
 * @author zhou_yajun
 *
 */
@Controller
@RequestMapping("DS173103")
public class DS173103Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS173103Controller.class);
    @Autowired
    private DS173103Logic ds173103Logic;
    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model) {
        List<DS173103Param> sellerList = this.ds173103Logic.getSellerInfo();
        model.addAttribute("sellerList",sellerList);
        return "ds/DS173103";
    }
}
