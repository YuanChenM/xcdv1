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
 * sql查询器页面Controller.
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "GS300001")
public class GS300001Controller extends BaseController {
    /**
     * 实例化页面
     *
     * @return sql查询器页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init() {
        return "/gs/GS300001";
    }
}
