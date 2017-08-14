package com.msk.ds.controller;


import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC30001Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 市场需求审核注册修改添加controller
 *
 * @author XHY
 */
@Controller
@RequestMapping(value = "TSC20052")
public class TSC20052Controller extends BaseController {


    /**
     * 实例化页面
     *
     * @param model model
     * @return 界面
     * @author pxg
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        String[] listData = {"2","3","5"};
        model.addAttribute("listData",listData);
        return "ds/TSC20052";
    }


}
