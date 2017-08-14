package com.msk.so.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.StringConst;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151401Bean;
import com.msk.so.bean.SO151414Bean;
import com.msk.so.logic.SO151401Logic;
import com.msk.so.logic.SO151414Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Map;

/**
 * SO151414Controller
 *
 * @author sjj
 * @version 1.0
 */
@Controller
@RequestMapping("SO151414")
@SessionAttributes("param")
public class SO151414Controller extends BaseController {
    /**
     * logger
     *
     * @author sjj
     */
    private static Logger logger = LoggerFactory.getLogger(SO151414Controller.class);

    @Autowired
    private SO151414Logic so151414Logic;

    @Autowired
    private SO151401Logic so151401Logic;

    /**
     * 页面初始化
     *
     * @return String
     */
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(Model model) {
        List<SO151401Bean> districtList = so151401Logic.findDistrict();
        List<SO151414Bean> whList = so151414Logic.findWhList();
        model.addAttribute("districtList", districtList);
        model.addAttribute("whList", whList);
        return "so/SO151414";
    }

    /**
     * @param basePageParam basePageParam
     * @return PageResult<SO151414Bean>
     * @author rwf
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SO151414Bean> search(BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "orderCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "buyersCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "frozenGoodsHousekeep", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(basePageParam, "receiverAddr", DbUtils.LikeMode.PARTIAL);
        String buyersName = basePageParam.getFilterMap().get("buyersName").toString();
        if (buyersName.contains(StringConst.UNDERLINE)) {
            buyersName = buyersName.replace(StringConst.UNDERLINE,
                    "\\" + StringConst.UNDERLINE);
        }
        basePageParam.getFilterMap().put("buyersName", buyersName);
        PageResult<SO151414Bean> results = this.so151414Logic.search(basePageParam);
        return results;
    }

    /**
     * 保存
     *
     * @param jsonStr
     * @param whCode
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Model model, String jsonStr, String whCode) {
        BaseParam baseParam = new BaseParam();
        super.setCommonParam(baseParam);
        Map<String, SO151414Bean> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, SO151414Bean>>() {
        });
        so151414Logic.save(map.values(), baseParam, whCode);
        return this.init(model);
    }
}