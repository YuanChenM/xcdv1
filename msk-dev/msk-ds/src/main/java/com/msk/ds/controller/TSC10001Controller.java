package com.msk.ds.controller;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC10001Bean;
import com.msk.ds.logic.TSC10001Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * SC183104Controller
 *
 * @author fjm
 *
 */
@Controller
@RequestMapping("TSC10001")
public class TSC10001Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SC183104Controller.class);

    @Autowired
    private TSC10001Logic tsc10001Logic;

    /**
     * 初始化页面
     * @return SC183104.jsp
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {

        return "ds/TSC10001";
    }

  /**
     * 分页查询数据
     *
     * @param  pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody
    PageResult<TSC10001Bean> search(BasePageParam pageParam) {
        logger.debug("数据一览查询");
        this.setCommonParam(pageParam);

        if(CommCodeMasterConst.LoginUserType.SELLER.equals(pageParam.getUserType())){
            pageParam.getFilterMap().put("crtId", pageParam.getCrtId());
        }

        DbUtils.buildLikeCondition(pageParam, "status", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(pageParam, "winner", DbUtils.LikeMode.FRONT);

        List<TSC10001Bean> list = new ArrayList<TSC10001Bean>();
        TSC10001Bean tsc10001Bean1 = new TSC10001Bean();
        tsc10001Bean1.setZbid("1");
        tsc10001Bean1.setProjectName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        tsc10001Bean1.setCheckTime("2016-3-20");
        tsc10001Bean1.setWinner("河北创融公司");
        tsc10001Bean1.setStatus("<input type=\"radio\" checked=\"checked\"name=\"1\"value=\"1\"/>编辑" +
                " <input type=\"radio\" name=\"1\"value=\"1\"/>生效 <input type=\"radio\" name=\"1\"value=\"1\"/>作废" +
                " &nbsp <input type=\"submit\" value=\"确认修改\" />");


        TSC10001Bean tsc10001Bean2 = new TSC10001Bean();
        tsc10001Bean2.setZbid("2");
        tsc10001Bean2.setProjectName("2016年4月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        tsc10001Bean2.setCheckTime("2016-4-20");
        tsc10001Bean2.setWinner("北京创融公司");
        tsc10001Bean2.setStatus("<input type=\"radio\" name=\"11\"value=\"11\"/>编辑" +
                " <input type=\"radio\" checked=\"checked\" name=\"11\"value=\"11\"/>生效 <input type=\"radio\" name=\"11\"value=\"11\"/>作废" +
                " &nbsp <input type=\"submit\" value=\"确认修改\" />");


        TSC10001Bean tsc10001Bean3 = new TSC10001Bean();
        tsc10001Bean3.setZbid("3");
        tsc10001Bean3.setProjectName("2016年5月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        tsc10001Bean3.setCheckTime("2016-5-20");
        tsc10001Bean3.setWinner("广东创融公司");
        tsc10001Bean3.setStatus("<input type=\"radio\" name=\"12\"value=\"12\"/>编辑" +
                " <input type=\"radio\" name=\"12\"value=\"12\"/>生效 <input type=\"radio\" checked=\"checked\" name=\"12\"value=\"12\"/>作废" +
                " &nbsp <input type=\"submit\" value=\"确认修改\"/>");

        list.add(tsc10001Bean1);
        list.add(tsc10001Bean2);
        list.add(tsc10001Bean3);
        PageResult pageResult = new PageResult();
        pageResult.setRecordsTotal(3);
        pageResult.setData(list);

        return pageResult;
    }

}
