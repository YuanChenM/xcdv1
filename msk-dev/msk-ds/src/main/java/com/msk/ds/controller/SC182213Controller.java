package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.SC182212Bean;
import com.msk.ds.bean.SC182213Bean;
import com.msk.ds.logic.SC182212Logic;
import com.msk.ds.logic.SC182213Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by FjM on 2016/4/28.
 */


@Controller
@RequestMapping("SC182213")
public class SC182213Controller extends BaseController{
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SC182213Controller.class);

    @Autowired
    private SC182213Logic sc182213Logic;

    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(){
        return "ds/SC182213";
    }


    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody
    PageResult<SC182213Bean> search(BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "lotId", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "serialId", DbUtils.LikeMode.FRONT);
        return this.sc182213Logic.findPage(basePageParam, SC182213Bean.class);
    }

    @RequestMapping(value = "delete",
            method = RequestMethod.POST)
    public String delete(Long lotId,String serialId) {
        logger.info("删除信息");
        this.sc182213Logic.deleteInfo(lotId,serialId);
        return "ds/SC182213";
    }
}
