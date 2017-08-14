package com.msk.gs.controller;

import com.msk.core.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * sql查询器页面Controller.
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "GS300002")
public class GS300002Controller extends BaseController {
    /**
     * 实例化页面
     *
     * @return sql查询器页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init() {
        return "/gs/GS300002";
    }
}
