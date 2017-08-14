package com.msk.sp.controller;

import com.msk.core.bean.BaseParam;
import com.msk.core.web.base.BaseController;
import com.msk.sp.bean.SP171129Bean;
import com.msk.sp.bean.SP171129Param;
import com.msk.sp.logic.SP171129Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * SP171128Controller
 *
 * @author wu_honglei
 *
 */
@Controller
@RequestMapping("SP171130")
public class SP171130Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SP171130Controller.class);

    @Autowired
    private SP171129Logic sp171129Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model,SP171129Param sp171129Param) {
        logger.info("神农客卖家产品报价初始化开始");
        //得到tab展示所需要的数据
        BaseParam bp =  new BaseParam();

        List<SP171129Bean> sp171129BeanList = sp171129Logic.findSP171129List(bp);

        model.addAttribute("sp171129Param",sp171129Param);
        model.addAttribute("sp171129BeanList",sp171129BeanList);

        logger.info("神农客卖家产品报价初始化结束");

        return "sp/SP171130";
    }

}
