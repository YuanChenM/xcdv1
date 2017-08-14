package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.SC183104Bean;
import com.msk.ds.logic.DS173303Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DS173303Controller
 *
 * @author pxg
 *
 */
@Controller
@RequestMapping("DS173303")
public class DS173303Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS173303Controller.class);

    /** DS173303Logic */
    @Autowired
    private DS173303Logic myLogic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("计划生产查询初始化");
        return "ds/DS173303";
    }

    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<SC183104Bean> search(BasePageParam param) {
        logger.debug("计划生产查询");
        return myLogic.findPageList();
    }
}
