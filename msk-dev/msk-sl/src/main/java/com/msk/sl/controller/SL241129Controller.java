package com.msk.sl.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.SL241129Bean;
import com.msk.sl.logic.SL241129Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 卖家申请产品controller
 *
 * @author pxg
 */
@Controller
@RequestMapping(value = "SL241129")
public class SL241129Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SL241129Controller.class);
    @Autowired
    private SL241129Logic sl241129Logic;
    /**
     * 实例化页面
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "showNorms",
            method = RequestMethod.POST)
    public String showNorms(Model model,SL241129Bean bean) {
        model.addAttribute("bean",bean);
        return "sl/SL24112901";
    }
    /**
     * 实例化页面
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model,@RequestParam(required = false)String slCode) {
        model.addAttribute("slCode",slCode);
        return "sl/SL241129";
    }
    /**
     * 卖家申请产品列表
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<SL241129Bean> search(BasePageParam pageParam) {
        logger.debug("卖家申请产品列表");
        DbUtils.buildLikeCondition(pageParam, "classesCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "classesName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "machiningCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "machiningName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "breedCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "breedName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "featureCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "featureName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "weightCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "weightName", DbUtils.LikeMode.FRONT);
        return sl241129Logic.queryProvider(pageParam);
    }
}
