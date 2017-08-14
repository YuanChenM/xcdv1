package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.DS173102Bean;
import com.msk.ds.bean.TSC10004Bean;
import com.msk.ds.logic.DS173102Logic;
import com.msk.ds.logic.TSC10004Logic;
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
 * TSC20001Controller
 *
 * @author gyh
 *
 */
@Controller
@RequestMapping("TSC20001")
public class TSC20001Controller extends BaseController {

    /**
     * 实例化页面
     *
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "init/{type}",
            method = RequestMethod.POST)
    public String init(@PathVariable(value = "type")String type,Model model) {
        model.addAttribute("type",type);
        return "ds/TSC20001";
    }
    /**
     * 实例化页面
     *
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "init2/{type}",
            method = RequestMethod.POST)
    public String init2(@PathVariable(value = "type")String type,Model model,String admin) {
        model.addAttribute("type",type);
        model.addAttribute("admin",admin);
        return "ds/TSC20011";
    }
}
