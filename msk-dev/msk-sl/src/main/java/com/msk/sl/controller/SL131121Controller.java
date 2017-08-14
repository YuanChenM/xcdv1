package com.msk.sl.controller;

import java.util.List;

import com.msk.core.entity.MdLogisticsArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msk.common.logic.LogisticsAreaLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.SL131121Bean;
import com.msk.sl.logic.SL131121Logic;

/**
 * 物流区产品管理
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("SL131121")
public class SL131121Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SL131121Controller.class);

    /**
     * 注入SL131121Logic
     */
    @Autowired
    private SL131121Logic sl131121Logic;

    @Autowired
    private LogisticsAreaLogic logisticsAreaLogic;

    /**
     * 物流区产品管理画面初始化
     * 
     * @param pageParam pageParam
     * @param model model
     * @return SL131121
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(BasePageParam pageParam, Model model) {
        logger.debug("卖家物流区产品管理画面初始化");

        if (pageParam.getFilterMap().get("sellerCode") == null) {
            pageParam.getFilterMap().put("sellerCode", "6111100001");
            pageParam.getFilterMap().put("lgcsCode", "01");
        }
        pageParam.getFilterMap().put("lgcsBaseLevel", NumberConst.IntDef.INT_ONE);
        List<MdLogisticsArea> logisticsAreas = logisticsAreaLogic.findList(pageParam);

        model.addAttribute("sellerCode", pageParam.getFilterMap().get("sellerCode"));
        model.addAttribute("lgcsCode", pageParam.getFilterMap().get("lgcsCode"));
        model.addAttribute("logisticsAreas", logisticsAreas);
        return "sl/SL131121";
    }

    /**
     *
     * 添加数据
     * 
     * @param bean SL131121Bean
     * @param model model
     * @return 实例化
     */
    @RequestMapping(value = "add",
        method = RequestMethod.POST)
    public String add(SL131121Bean bean, Model model) {
        bean.setDelFlg("0");
        bean.setCrtId("admin");
        bean.setCrtTime(DateTimeUtil.getCustomerDate());
        bean.setUpdId("admin");
        bean.setUpdTime(DateTimeUtil.getCustomerDate());
        bean.setActId("admin");
        bean.setVer(NumberConst.IntDef.INT_ONE);
        int resultCount = this.sl131121Logic.save(bean);
        if (resultCount <= NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("插入失败，请重新操作！");
        }
        return this.init(bean, model);
    }

    /**
     * 删除数据
     * 
     * @param bean SL131121Bean
     * @param model model
     * @return 页面
     */
    @RequestMapping(value = "delete",
        method = RequestMethod.POST)
    public String delete(SL131121Bean bean, Model model) {
        int resultCount = this.sl131121Logic.remove(bean);
        if (resultCount <= NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("删除失败，请重新操作！");
        }
        return this.init(bean, model);
    }

    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<SL131121Bean> search(BasePageParam param) {
        logger.debug("物流区产品列表查询");
        // param.getFilterMap().put("lgcsCode", lgcsCode);
        // param.setPageSize(NumberConst.IntDef.INT_THIRTY);
        DbUtils.buildLikeCondition(param, "classesCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "breedCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "featureCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "classesName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "breedName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "featureName", DbUtils.LikeMode.FRONT);
        return sl131121Logic.findPage(param, SL131121Bean.class);
    }

    /**
     * 操作后页面Refresh
     * @param bean SL131121Bean
     * @param model Model
     * @return SL131121
     */
    private String init(SL131121Bean bean, Model model){
        BasePageParam pageParam = new BasePageParam();
        pageParam.getFilterMap().put("sellerCode", bean.getSlCode());
        pageParam.getFilterMap().put("lgcsCode", bean.getLgcsCode());
        return this.init(pageParam, model);
    }
}
