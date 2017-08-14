package com.msk.by.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msk.by.bean.BY121302Bean;
import com.msk.by.logic.BY121302Logic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.md.utils.DistrictAreaUtils;

/**
 * 菜场列表
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("BY121302")
public class BY121302Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BY121302Controller.class);

    @Autowired
    private BY121302Logic by121302Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("菜场列表初始化");
        return "by/BY121302";
    }

    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<BY121302Bean> search(BasePageParam param) {
        logger.debug("菜场列表查询");
        DbUtils.buildLikeCondition(param, "marketCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "marketName", DbUtils.LikeMode.FRONT);
        PageResult<BY121302Bean> result = by121302Logic.findPage(param, BY121302Bean.class);
        for (BY121302Bean bean : result.getData()) {
            if (!StringUtil.isNullOrEmpty(bean.getLgcsAreaCode())) {
                bean.setLgcsAreaName(DistrictAreaUtils.getLogisticsAreaName(bean.getLgcsAreaCode()));
            } else {
                bean.setLgcsAreaName(StringConst.EMPTY);
            }
            if (!StringUtil.isNullOrEmpty(bean.getCityCode())) {
                bean.setCityName(DistrictAreaUtils.getCityName(bean.getCityCode()));
            } else {
                bean.setCityName(StringConst.EMPTY);
            }
            bean.setDistrictName(DistrictAreaUtils.getDistrictName(bean.getCityCode(), bean.getDistrictCode()));
        }
        return result;
    }

    /**
     * 删除菜场
     *
     * @param marketId marketId
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "delete/{marketId}",
        method = RequestMethod.POST)
    public String delete(@PathVariable("marketId") String marketId, Model model) {
        logger.debug("删除菜场");
        int result = by121302Logic.deleteMarketFoodById(marketId);
        if (result == NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("删除失败,未找到该菜场!");
        }
        return "by/BY121302";
    }
}
