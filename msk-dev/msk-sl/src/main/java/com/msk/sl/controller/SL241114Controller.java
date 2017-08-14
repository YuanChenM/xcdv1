package com.msk.sl.controller;

import java.util.List;

import com.msk.core.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msk.sl.bean.SL241109Bean;

/**
 * 卖家产品技术标准档案卡审核
 * 
 * @author yuan_chen
 */
@Controller
@RequestMapping("SL241114")
public class SL241114Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SL241114Controller.class);


    /**
     * 初始化操作
     * 
     * @param 
     * @param model model
     * @return PD141114
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(Model mo) {
        logger.debug("实际产品技术数据录入页面页面初始化");

       SL241109Bean sl = new SL241109Bean();
       
       sl.setContent("sjhfashdkfjahfdkjahskjfahhdkjsafhkjashkjfssfsjdfhaskfdsajfkjaskfaskdfksahf<br/>sjhfajshjkkdkfaksdaskfkdskfsad");
       
       mo.addAttribute(sl);
        return "sl/SL241114";
    }

 
}
