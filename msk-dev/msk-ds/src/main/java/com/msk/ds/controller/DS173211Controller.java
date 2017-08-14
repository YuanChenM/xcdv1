package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.DS173201Param;
import com.msk.ds.bean.DS173211Param;
import com.msk.ds.logic.DS173211Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DS173211Controller
 *
 * @author zhou_yajun
 *
 */
@Controller
@RequestMapping("DS173211")
public class DS173211Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS173211Controller.class);

    @Autowired
    private DS173211Logic ds173211Logic;
    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model) {

        return "ds/DS173211";
    }
    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<DS173211Param> search(BasePageParam param) {

        return ds173211Logic.findPageList();
    }
}
