package com.msk.ds.controller;


import com.msk.core.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 市场需求审核注册修改添加controller
 *
 * @author XHY
 */
@Controller
@RequestMapping(value = "TSC30004")
public class TSC30004Controller extends BaseController {


    /**
     * 实例化页面
     *
     * @param model model
     * @return 界面
     * @author xhy
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        return "ds/TSC30004";
    }


}
