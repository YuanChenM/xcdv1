package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.*;
import com.msk.core.web.base.BaseUploadController;
import com.msk.pd.logic.ProductLogic;
import com.msk.sl.bean.SL241129Bean;
import com.msk.sl.bean.SL241130Param;
import com.msk.sl.logic.SL241129Logic;
import com.msk.sl.logic.SL241130Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 申请新特性Controller.
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "SL241130")
public class SL241130Controller extends BaseUploadController {
    @Autowired
    private ProductLogic productLogic;
    @Autowired
    private SL241130Logic sl241130Logic;

    private static Logger logger = LoggerFactory.getLogger(SL241117Controller.class);

    /**
     * 申请新特性
     *
     * @param model      model
     * @param slShowName 卖家名称
     * @param slCode     买家编码
     * @return 申请新特性页面
     */
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(Model model, @RequestParam(required = false) String slShowName, String slCode) {
        logger.debug("申请新特性页面初始化");
        model.addAttribute("slShowName", slShowName);
        model.addAttribute("slCode", slCode);
        BaseParam param = new BaseParam();
        param.setFilter("slCode", slCode);
        //产品类别信息
        List<PdClasses> pdClassess = productLogic.findPdClasses(param);
        model.addAttribute("pdClasses", pdClassess);
        model.addAttribute("pdTcProvider", new SL241130Param());
        return "sl/SL241130";
    }

    /**
     * 保存申请信息
     *
     * @param sl241128Param 参数
     * @return 结果
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public
    @ResponseBody
    String save(SL241130Param sl241128Param) {
        super.setCommonParam(sl241128Param);
        List<SL241130Param> paramList = new ArrayList<SL241130Param>();
        paramList.add(sl241128Param);
        return this.sl241130Logic.saveNewPd(paramList);
    }
}
