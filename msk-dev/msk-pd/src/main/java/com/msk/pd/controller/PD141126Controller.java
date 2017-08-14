package com.msk.pd.controller;

import com.msk.core.entity.PdClassestree;
import com.msk.core.web.base.BaseController;
import com.msk.pd.logic.PD141126Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品分类加工信息controller
 *
 * @author pxg
 */
@Controller
@RequestMapping(value = "PD141126")
public class PD141126Controller extends BaseController {
    @Autowired
    private PD141126Logic pd141126Logic;

    /**
     * 实例化页面
     *
     * @param model model
     * @return 界面
     * @author pxg
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        List<PdClassestree> listOne = new ArrayList<>();
        listOne = pd141126Logic.queryOneClassify();
        model.addAttribute("listOne", listOne);
        return "pd/PD141126";
    }

    /**
     * 实例化页面
     *
     * @param treeLevel       treeLevel
     * @param classestreeCode classestreeCode
     * @return 界面
     * @author pxg
     */
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public
    @ResponseBody
    List<PdClassestree> queryTwo(String classestreeCode, String treeLevel) {
        List<PdClassestree> listTwo = new ArrayList<>();
        listTwo = pd141126Logic.queryTwoClassify(treeLevel, classestreeCode);
        return listTwo;
    }
}
