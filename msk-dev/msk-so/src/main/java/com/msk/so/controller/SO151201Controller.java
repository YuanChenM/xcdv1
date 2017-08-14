package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.SystemConst;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151201Bean;
import com.msk.so.logic.SO151201Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 分销正常库存
 */
@Controller
@RequestMapping("SO151201")
@SessionAttributes("param")
public class SO151201Controller extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SO151201Controller.class);

    @Autowired
    private SO151201Logic SO151201Logic;

    /**
     * 加载分销正常库存界面
     *
     * @return String
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(BasePageParam param, Model model) {
        model.addAttribute("param", param);
        logger.debug("初始化页面");
        return "so/SO151201";
    }

    /**
     * @param basePageParam basePageParam
     * @return PageResult<SO151201Bean>
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SO151201Bean> search(BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "lgcsCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "warehouseCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slCodeDis", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(basePageParam, "lgcsName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "warehouseName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slName", DbUtils.LikeMode.FRONT);
        /*lgcsName   warehouseName    slName     */
        DbUtils.buildLikeCondition(basePageParam, "supplierCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "pdCode", DbUtils.LikeMode.FRONT);

        DbUtils.buildLikeCondition(basePageParam, "supplyPlayFrom", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "supplierName", DbUtils.LikeMode.FRONT);
       /* supplyPlayFrom supplierName   */
        DbUtils.buildLikeCondition(basePageParam, "pdName", DbUtils.LikeMode.PARTIAL);




        if (isDebug) {
            logger.info("假数据");
            // 获取假数据
        }
        logger.info("查询数据库");
        return this.SO151201Logic.findPage(basePageParam, SO151201Bean.class);
    }

    /**
     * 库存保存
     */
    @RequestMapping(value = "save",
            method = RequestMethod.POST)
    public
    @ResponseBody
    String save(String stockId, String stockQty) {
        BasePageParam param = new BasePageParam();
        param.setFilter("stockId",stockId);
        param.setFilter("stockQty", stockQty);
        int result = this.SO151201Logic.saveStockQty(param);
        if(result > 0) {
            return SystemConst.RsStatus.SUCCESS;
        } else {
            return SystemConst.RsStatus.FAIL;
        }
    }
}
