package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.DS173102Bean;
import com.msk.ds.bean.SC183104Bean;
import com.msk.ds.logic.DS173102Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DS173102Controller
 *
 * @author pxg
 *
 */
@Controller
@RequestMapping("DS173102")
public class DS173102Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS173102Controller.class);

    /** DS173102Logic */
    @Autowired
    private DS173102Logic myLogic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("月度在线控制表一览初始化");
        return "ds/DS173102";
    }

    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<DS173102Bean> search(BasePageParam param) {
        logger.debug("月度在线控制表一览查询");
        return myLogic.findPageList();
    }
}
