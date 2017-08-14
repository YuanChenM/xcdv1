package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.DS173209Bean;
import com.msk.ds.logic.DS173209Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DS173209Controller
 *
 * @author pxg
 *
 */
@Controller
@RequestMapping("DS173209")
public class DS173209Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS173209Controller.class);

    /** DS173209Logic */
    @Autowired
    private DS173209Logic myLogic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("批次编码初始化");
        return "ds/DS173209";
    }

    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<DS173209Bean> search(BasePageParam param) {
        logger.debug("批次编码查询");
        return myLogic.findPageList();
    }
}
