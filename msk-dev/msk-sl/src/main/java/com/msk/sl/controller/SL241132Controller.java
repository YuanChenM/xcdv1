package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.core.web.consts.CodeMasterConst;
import com.msk.pd.logic.ProductLogic;
import com.msk.sl.bean.SL241101Bean;
import com.msk.sl.bean.SL241116Bean;
import com.msk.sl.bean.SL241132Bean;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL241117Logic;
import com.msk.sl.logic.Sl241101Logic;
import com.msk.sl.logic.Sl241116Logic;
import com.msk.sl.logic.Sl241132Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 卖家货号列表Controller.
 *
 * @author pxg
 */
@Controller
@RequestMapping(value = "SL241132")
public class SL241132Controller extends BaseUploadController {
    @Autowired
    private Sl241132Logic sl241132Logic;
    /**
     * 实例化页面
     *
     * @return 卖家货号信息页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    private String init(Model model,String slCode) {
        model.addAttribute("slCode", slCode);
        return "sl/SL241132";
    }

    /**
     * 卖家货号列表
     *
     * @param basePageParam basePageParam
     * @return 信息
     * @author pxg
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SL241132Bean> search(BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "slPdArtno", DbUtils.LikeMode.FRONT);
        /*DbUtils.buildLikeCondition(basePageParam, "slCodeDis", DbUtils.LikeMode.FRONT);*/
        return sl241132Logic.findPage(basePageParam, SL241132Bean.class);
    }
}
