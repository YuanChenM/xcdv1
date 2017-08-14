package com.msk.sp.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.sp.bean.SP171103Bean;
import com.msk.sp.logic.SP171103Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * SP171103Controller
 *
 * @author yang_yang
 *
 */
@Controller
@RequestMapping("SP171103")
public class SP171103Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SP171103Controller.class);

    @Autowired
    private SP171103Logic sp171103Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model) {

        logger.debug("需求数量设置画面初始化");

        return "sp/SP171103";
    }

    /**
     * 分页查询数据
     *
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<SP171103Bean> search(BasePageParam pageParam) {
        logger.debug("价盘平台查看查询");
        //判断当前用户登录是否失效
        //this.getLoginUser();

        return sp171103Logic.findSP171103List(pageParam);
    }

    /**
     * 发布需求
     * @param sp171103Bean
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Model model,SP171103Bean sp171103Bean){
        BaseParam baseParam = new BaseParam();
        this.setCommonParam(baseParam);

        return "sp/SP171103";
    }

}
