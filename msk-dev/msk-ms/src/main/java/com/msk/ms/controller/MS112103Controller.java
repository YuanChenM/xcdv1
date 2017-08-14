package com.msk.ms.controller;
import com.msk.core.web.base.*;
import com.msk.ms.bean.MS112103Bean;
import com.msk.ms.logic.MS112103Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * SO151503Controller
 * 会员卡明细页面
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("MS112103")
public class MS112103Controller extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(MS112103Controller.class);

    @Autowired
    private MS112103Logic MS112103Logic;

    /**
     * 明细页面
     * 
     * @param model 模型
     * @param msId 会员卡Id
     * @return String 返回
     */
    @RequestMapping(value = "init/{msId}",
        method = RequestMethod.POST)
    public String init(@PathVariable String msId, Model model) {
        logger.debug(msId);
        System.out.println(msId);
        MS112103Bean mS112103Bean = null;
        if (isDebug) {
            logger.info("假数据");
            mS112103Bean = this.MS112103Logic.findSO151503Bean();
        } else {
            //根据会员卡的msId查询会员卡信息
            mS112103Bean = this.MS112103Logic.findSO151503Bean(msId);
        }
        model.addAttribute("ms112103Bean", mS112103Bean);
        return "ms/MS112103";
    }
}
