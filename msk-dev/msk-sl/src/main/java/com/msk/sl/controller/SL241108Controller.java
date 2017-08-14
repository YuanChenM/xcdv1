package com.msk.sl.controller;

import java.util.List;

import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.SL24110101;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msk.core.bean.BasePageParam;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.SL241104Bean;
import com.msk.sl.bean.SL241108Param;

/**
 * 卖家产品技术标准档案卡审核
 * 
 * @author yuan_chen
 */
@Controller
@RequestMapping("SL241108")
public class SL241108Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SL241108Controller.class);

//    @Autowired
//    private PD141107Logic pd141107Logic;

    /**
     * 初始化操作
     * 
     * @param sl241104Bean sl241104Bean
     * @param model model
     * @return PD141108
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(SL241104Bean sl241104Bean, Model model) {
        logger.debug("实际产品技术数据录入页面页面初始化");

        BasePageParam pageParam = new BasePageParam();
        pageParam.setPaging(Boolean.FALSE);

        int examineStatus = 0;
        if (StringUtil.isNullOrEmpty(sl241104Bean.getGradeCode())) {
            examineStatus = 1;
        } else {
            if (StringUtil.equals(sl241104Bean.getExamineResult(), "未审核")) {
                examineStatus = 2;
            }
        }
        List<SL24110101> tscList;
//        if (isDebug) {
//            tscList = pd141107Logic.getTncStdTestData();
//        } else {
//            tscList = pd141107Logic.getTncStd(pageParam);
//        }

//        model.addAttribute("technicalStdClaList", tscList);
        model.addAttribute("examineStatus", examineStatus);
        model.addAttribute("sl241104Bean", sl241104Bean);
        return "sl/SL241108";
    }

    /**
     * 提交审核结果
     * 
     * @param param param
     * @param model model
     * @return SL241104
     */
    @RequestMapping(value = "examine",
        method = RequestMethod.POST)
    public String examine(SL241108Param param, Model model) {
        // pd141108Logic.save(param);
        return "sl/SL241104";
    }

    /**
     * 提交审核确认结果
     * 
     * @param param param
     * @param model model
     * @return SL241104
     */
    @RequestMapping(value = "confirm",
        method = RequestMethod.POST)
    public String confirm(SL241108Param param, Model model) {
        // pd141108Logic.save(param);
        return "sl/SL241104";
    }
}
