package com.msk.ds.controller;

import com.msk.core.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.DsSlPdLot;
import com.msk.core.utils.DbUtils;
import com.msk.ds.logic.DS174103Logic;

/**
 * DS174103Controller
 * 
 * @author yuan_chen
 *
 */
@Controller
@RequestMapping("DS174103")
public class DS174103Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS174103Controller.class);

    /** DS174103Logic */
    @Autowired
    private DS174103Logic myLogic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("卖家产品列表初始化");

        return "ds/DS174103";
    }

    /**
     * 分页查询数据
     * 
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<DsSlPdLot> search(BasePageParam param) {
        logger.debug("卖家产品列表查询");
        DbUtils.buildLikeCondition(param, "slCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "slName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "classesCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "breedCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "featureCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "classesName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "breedName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "featureName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "pkgCode", DbUtils.LikeMode.FRONT);
        return myLogic.findPage(param, DsSlPdLot.class);
    }

    /**
     *
     * 添加数据
     * 
     * @param bean bean
     * @param model model
     * @return 实例化
     */
    @RequestMapping(value = "save",
        method = RequestMethod.POST)
    public String save(DsSlPdLot bean, Model model) {
        logger.debug("添加一条");
        this.myLogic.setDsSlPdLot(bean);
        this.myLogic.save(bean);
        return this.init(model);
    }
}
