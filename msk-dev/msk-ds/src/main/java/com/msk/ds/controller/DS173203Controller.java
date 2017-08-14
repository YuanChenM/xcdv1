package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.DS173203Param;
import com.msk.ds.logic.DS173203Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DS173203Controller
 *
 * @author zhou_yajun
 *
 */
@Controller
@RequestMapping("DS173203")
public class DS173203Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS173203Controller.class);

    @Autowired
    private DS173203Logic dS173203Logic;
    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model) {

        return "ds/DS173203";
    }
    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<DS173203Param> search(BasePageParam param) {

        return dS173203Logic.findPageList();
    }
}
