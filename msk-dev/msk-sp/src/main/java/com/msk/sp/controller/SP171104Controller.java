package com.msk.sp.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.sp.bean.SP171104Bean;
import com.msk.sp.logic.SP171104Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SP171104Controller
 *
 * @author yang_yang
 *
 */
@Controller
@RequestMapping("SP171104")
public class SP171104Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SP171104Controller.class);

    @Autowired
    private SP171104Logic sp171104Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model) {

        logger.debug("需求数量设置画面初始化");

        return "sp/SP171104";
    }

    /**
     * 分页查询数据
     *
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<SP171104Bean> search(BasePageParam pageParam) {
        logger.debug("价盘平台查看查询");
        //判断当前用户登录是否失效
        //this.getLoginUser();

        return sp171104Logic.findSP171104List(pageParam);
    }

}
