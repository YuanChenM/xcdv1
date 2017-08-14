package com.msk.sl.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.SL241101Bean;
import com.msk.sl.logic.Sl241101Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 卖家审批审核列表Controller.
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "SL241101")
public class SL241101Controller extends BaseController {
    @Autowired
    private Sl241101Logic sl241101Logic;

    /**
     * 实例化页面
     * 
     * @return 卖家审批审核页面
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init() {
        return "/sl/SL241101";
    }
    /**
     * 实例化页面
     *
     * @return 卖家信息列表页面
     */
    @RequestMapping(value = "initShow",
            method = RequestMethod.POST)
    public String initShow() {
        return "sl/SL241115";
    }

    /**
     * 查询审批审核列表
     * 
     * @param basePageParam basePageParam
     * @return 信息
     * @author gyh
     */
    @RequestMapping(value = "search",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<SL241101Bean> search(BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "slCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slCodeDis", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slShowName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slTel", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slContact", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "cityName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "lgcsAreaName", DbUtils.LikeMode.FRONT);
        String slMainClass=StringUtil.toSafeString(basePageParam.getFilterMap().get("slMainClass"));
        if(!StringUtil.isNullOrEmpty(slMainClass)){
            String[] slMainClasss=slMainClass.split(",");
            basePageParam.getFilterMap().put("slMainClasss",slMainClasss);
        }
        String ddjsh = (String) basePageParam.getFilterMap().get("ddjsh");
        if(!StringUtil.isNullOrEmpty(ddjsh)){
            String[] ddjshAry = ddjsh.split(",");
            if (ddjshAry.length == NumberConst.IntDef.INT_TWO) {
                basePageParam.setFilter("ddjsh", null);
            }
        }
        String ddjkr = (String) basePageParam.getFilterMap().get("ddjkr");
        if(!StringUtil.isNullOrEmpty(ddjkr)){
            String[] ddjkrAry = ddjkr.split(",");
            if (ddjkrAry.length == NumberConst.IntDef.INT_TWO) {
                basePageParam.setFilter("ddjkr", null);
            }
        }
//        String salType = (String) basePageParam.getFilterMap().get("salType");
//        if(!StringUtil.isNullOrEmpty(salType)){
//            String[] ary = salType.split(",");
//            for (String flag : ary) {
//                if ("1".equals(flag)) {
//                    basePageParam.setFilter("slSelfFlg", "1");
//                } else if ("2".equals(flag)) {
//                    basePageParam.setFilter("slProxyFlg", "1");
//                } else if ("3".equals(flag)) {
//                    basePageParam.setFilter("slOemFlg", "1");
//                }
//            }
//        }
        basePageParam.setFilter("delFlg", "0");
        if (isDebug) {
            return this.sl241101Logic.getListInfo();
        }
        return this.sl241101Logic.findPage(basePageParam, SL241101Bean.class);
    }
}
