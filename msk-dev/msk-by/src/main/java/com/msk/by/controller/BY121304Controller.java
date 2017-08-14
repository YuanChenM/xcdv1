package com.msk.by.controller;

import com.msk.by.bean.IBY121202RsParam;
import com.msk.by.bean.IBY121205RsParam;
import com.msk.by.bean.IBY121206RsParam;
import com.msk.by.bean.IBY121207RsParam;
import com.msk.by.logic.BY121304Logic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.*;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 买家详细画面
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("BY121304")
public class BY121304Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BY121304Controller.class);

    @Autowired
    private BY121304Logic by121304Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init/{buyerId}",
        method = RequestMethod.POST)
    public String init(@PathVariable("buyerId") String buyerId,Model model) {
        logger.debug("买家详细画面");
        model.addAttribute("buyerId",buyerId);
        ByBuyerAccount buyerAccount = by121304Logic.findBuyerAccount(buyerId);
        if(null != buyerAccount){
            model.addAttribute("buyerAccount",buyerAccount);
        }
        return "by/BY121304";
    }
    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search/{buyerId}",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<IBY121207RsParam> search(@PathVariable("buyerId") String buyerId,
                                                         BasePageParam param) {
        logger.debug("买家员工信息查询");
        param.getFilterMap().put("buyerId", buyerId);
        DbUtils.buildLikeCondition(param, "employeeName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "employeeTel", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "employeeQq", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "employeeWechat", DbUtils.LikeMode.FRONT);
        PageResult<IBY121207RsParam> result = by121304Logic.findPage(param, IBY121207RsParam.class);
        return result;
    }

    /**
     * 删除雇员信息
     * @param byBuyerEmployee
     */
    @RequestMapping(value = "delete",
            method = RequestMethod.POST)
    public @ResponseBody String deleteEmployee(IBY121207RsParam byBuyerEmployee){
        int deleteCount = by121304Logic.deleteEmployee(byBuyerEmployee);
        return "by/BY121304";
    }
}
