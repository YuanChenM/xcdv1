package com.msk.sl.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.SL241110Bean;
import com.msk.sl.bean.SL241120Bean;
import com.msk.sl.logic.SL241110Logic;
import com.msk.sl.logic.SL241120Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 卖家意见查询
 * SL241120Controller.
 *
 * @author Administrator
 */


@Controller
@RequestMapping(value = "SL241120")
public class SL241120Controller extends BaseController {

    @Autowired
    private SL241120Logic sL241120Logic;
    @Autowired
    private SL241110Logic sL241110Logic;
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SL241120Controller.class);

    /**
     * 实例化页面
     *
     * @return 页面
     */
    @RequestMapping(value = "init/{chapClass}", method = RequestMethod.POST)
    public String init(@PathVariable(value = "chapClass")String chapClass,Model model) {
        logger.info("实例化页面");
        model.addAttribute("chapClass",chapClass);
        return "sl/SL241120";
    }

    /**
     * 卖家意见列表
     *
     * @param basePageParam 参数
     * @return
     */
    @RequestMapping(value = "search/{chapClass}", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SL241120Bean> search(BasePageParam basePageParam,@PathVariable(value = "chapClass")String chapClass) {
        DbUtils.buildLikeCondition(basePageParam, "epName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slTel", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slContact", DbUtils.LikeMode.FRONT);
        basePageParam.setFilter("chapClass",chapClass);
        return this.sL241120Logic.findPage(basePageParam, SL241120Bean.class);
    }

    /**
     * 根据编码查询章节意见
     * @param slCode 卖家编码
     * @return 结果
     */
    @RequestMapping(value = "findSlDistReguSug/{chapClass}", method = RequestMethod.POST)
    public @ResponseBody
    List<SL241110Bean> findSlDistReguSug(String slCode,@PathVariable(value = "chapClass")String chapClass){
        BasePageParam basePageParam=new BasePageParam();
        basePageParam.setPaging(false);
        basePageParam.setFilter("slCode",slCode);
        basePageParam.setFilter("chapClass",chapClass);
        return sL241110Logic.findPageList(basePageParam, SL241110Bean.class);
    }


}
