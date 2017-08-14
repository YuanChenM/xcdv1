package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO153201Bean;
import com.msk.so.bean.SO153201Param;
import org.slf4j.Logger;
import com.msk.so.logic.SO153201Logic;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * 买家-交易记录查询
 *
 * @author chen_xin
 * @version 1.0
 **/
@Controller
@RequestMapping("SO153201")
public class SO153201Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SO153201Controller.class);
    @Autowired
    private SO153201Logic SO153201Logic;

    /**
     * 卖家交易记录
     *
     * @return String
     **/
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(BasePageParam pageParam, Model model) {
        model.addAttribute("param", pageParam);
        logger.debug("初始化页面");
        return "so/SO153201";
    }

    /**
     * @param pageParam pageParam
     * @return PageResult<SO153201Bean>
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SO153201Param> search(BasePageParam pageParam) {

        logger.info("获取卖家交易记录");
        // 获取卖家交易记录
        DbUtils.buildLikeCondition(pageParam, "businessName", DbUtils.LikeMode.FRONT);

        String timeType = "";
        if(pageParam.getFilterMap().get("timeType") != null){
            timeType = pageParam.getFilterMap().get("timeType").toString();
        }
        //1 交易时间  2 创建时间
        if(String.valueOf(NumberConst.IntDef.INT_ONE).equals(timeType)){
            pageParam.getFilterMap().put("tranTimeStart", pageParam.getFilterMap().get("timeStart"));
            pageParam.getFilterMap().put("tranTimeEnd", pageParam.getFilterMap().get("timeEnd"));
        }
        if(String.valueOf(NumberConst.IntDef.INT_TWO).equals(timeType)){
            pageParam.getFilterMap().put("createTimeStart", pageParam.getFilterMap().get("timeStart"));
            pageParam.getFilterMap().put("createTimeEnd", pageParam.getFilterMap().get("timeEnd"));
        }

        return SO153201Logic.findSO153201List(pageParam);
    }

}
