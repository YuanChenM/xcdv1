/**
 * SO151109Controller.java
 *
 * @screen
 * @author rwf
 */
package com.msk.so.controller;

import com.msk.core.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.so.bean.SO151109Bean;
import com.msk.so.logic.SO151109Logic;

/**
 * SO151109Controller.
 *
 * @author rwf
 */
@Controller
@RequestMapping("SO151109")
public class SO151109Controller extends BaseController {

    /**
     * logger
     * 
     * @author rwf
     */
    private static Logger logger = LoggerFactory.getLogger(SO151109Controller.class);

    @Autowired
    private SO151109Logic sO151109Logic;

    /**
     * 加载订单列表界面
     * 
     * @return String
     **/
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init() {

        return "so/SO151109";
    }

    /**
     * @param basePageParam 
     * @return PageResult<SO151109Bean>
     * @author rwf
     * 
     */
    @RequestMapping(value = "search",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<SO151109Bean> search(BasePageParam basePageParam) {

        if (isDebug) {
            logger.info("假数据");
            // 获取假数据
            return sO151109Logic.findOrderList();
        }
        // return this.sO151109Logic.findPage(basePageParam, sO151109Logic.class);
        return null;
    }
}
