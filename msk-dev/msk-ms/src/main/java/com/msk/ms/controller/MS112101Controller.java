package com.msk.ms.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DbUtils;
import com.msk.ms.bean.MS112101Bean;
import com.msk.ms.logic.MS112101Logic;

/**
 * SO151501Controller
 * 会员卡列表
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
@RequestMapping("MS112101")
public class MS112101Controller extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(MS112101Controller.class);

    @Autowired
    private MS112101Logic MS112101Logic;

    /**
     * 初始化进入List页面
     * 
     * @return String 返回String
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init() {
        logger.debug("进入MS112101页面");
        return "/ms/MS112101";
    }

    /**
     * Search Data List.
     * 分页显示会员卡信息
     * @param param Base Page Param
     * @return PageResult
     */
    @RequestMapping(value = "search",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<MS112101Bean> search(BasePageParam param) {
        PageResult<MS112101Bean> result = null;
        if (isDebug) {
            result = new PageResult<MS112101Bean>();
            List<MS112101Bean> dataList = new ArrayList<MS112101Bean>();
            MS112101Bean bean = new MS112101Bean();
            bean.setMsCardno("XXXXXXXXX00001");
            bean.setBuyerCode("XXXXXXXXXXXX00001");
            bean.setBuyerName("张三");
            bean.setIsActivate("是");
            bean.setIsProvide("是");
            bean.setProvideDate("2016-01-01");
            dataList.add(bean);
            MS112101Bean bean1 = new MS112101Bean();
            bean1.setMsCardno("XXXXXXXXX00002");
            bean1.setBuyerCode("XXXXXXXXXXXX00002");
            bean1.setBuyerName("李四");
            bean1.setIsActivate("是");
            bean1.setIsProvide("是");
            bean1.setProvideDate("2016-01-01");
            dataList.add(bean1);
            MS112101Bean bean2 = new MS112101Bean();
            bean2.setMsCardno("XXXXXXXXX00003");
            bean2.setBuyerCode("XXXXXXXXXXXX00003");
            bean2.setBuyerName("王五");
            bean2.setIsActivate("是");
            bean2.setIsProvide("否");
            bean2.setProvideDate("2016-01-01");
            dataList.add(bean2);
            result.setData(dataList);
            result.setRecordsTotal(NumberConst.IntDef.INT_THREE);
        } else {
            DbUtils.buildLikeCondition(param, "msCardno", DbUtils.LikeMode.FRONT);
            DbUtils.buildLikeCondition(param, "buyerCode", DbUtils.LikeMode.FRONT);
            DbUtils.buildLikeCondition(param, "buyerName", DbUtils.LikeMode.FRONT);
            result = this.MS112101Logic.findPage(param, MS112101Bean.class);
        }
        return result;
    }

}
