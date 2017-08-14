package com.msk.pd.controller;

import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseController;
import com.msk.pd.bean.PD141124Bean;
import com.msk.pd.logic.PD141124Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 品种产品目录报表
 *
 * @author xhy
 */
@Controller
@RequestMapping(value = "PD142102")
public class PD142102Controller extends BaseController {
    @Autowired
    private PD141124Logic pd141124Logic;

    /**
     * 实例化页面
     *
     * @param model model
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        BaseParam param = new BaseParam();
        param.setFilter("level", String.valueOf(NumberConst.IntDef.INT_ONE));
        //显示一级类目下拉框
        List<PD141124Bean> list = this.pd141124Logic.findList(param);
        if (list != null) model.addAttribute("classesList", list);
        return "pd/PD142102";
    }


}
