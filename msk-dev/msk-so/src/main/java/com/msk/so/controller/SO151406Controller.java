package com.msk.so.controller;

import com.msk.core.consts.StringConst;
import com.msk.core.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.so.bean.SO151406Bean;
import com.msk.so.logic.SO151406Logic;

/**
 * @author chen_xin
 * @version 创建时间：2015年12月23日 下午2:29:10
 *          退货单
 */
@Controller
@RequestMapping("SO151406")
public class SO151406Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO151406Controller.class);
    @Autowired
    private SO151406Logic so251106Logic;

    /**
     * 初始页面
     * 
     * @return String
     * @author chen_xin
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    private String init() {

        return "so/SO151406";
    }

    /**
     * 查询退货单明细列表
     * 
     * @return PageResult<OM141106Bean>
     * @author chen_xin
     * @param basePageParam basePageParam
     */
    @RequestMapping(value = "search",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<SO151406Bean> search(BasePageParam basePageParam) {
        PageResult<SO151406Bean> rs = null;
        if (isDebug) {
            logger.info("假数据");
            rs = so251106Logic.queryList();
        } else {
            logger.info("List操作");
            /*DbUtils.buildLikeCondition(basePageParam, "orderCodeQuery", DbUtils.LikeMode.FRONT);*/
            DbUtils.buildLikeCondition(basePageParam, "buyersCodeQuery", DbUtils.LikeMode.FRONT);
            DbUtils.buildLikeCondition(basePageParam, "buyersNameQuery", DbUtils.LikeMode.FRONT);
            //DbUtils.buildLikeCondition(basePageParam, "returnCodeQuery", DbUtils.LikeMode.FRONT);
            DbUtils.buildLikeCondition(basePageParam, "orderCode", DbUtils.LikeMode.FRONT);
            String returnCode = basePageParam.getFilterMap().get("returnCodeQuery").toString();
            if (returnCode.contains(StringConst.UNDERLINE)) {
                returnCode = returnCode.replace(StringConst.UNDERLINE,
                        "\\" + StringConst.UNDERLINE);
            }
            basePageParam.getFilterMap().put("returnCodeQuery",returnCode);
            rs = this.so251106Logic.findPage(basePageParam, SO151406Bean.class);
        }
        return rs;
    }
}
