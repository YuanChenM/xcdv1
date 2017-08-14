package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.SystemConst;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151201Bean;
import com.msk.so.bean.SO151409Bean;
import com.msk.so.bean.order.BaseOrderDetailParam;
import com.msk.so.bean.order.BaseOrderStatusResult;
import com.msk.so.bean.order.OrderPartOperationParam;
import com.msk.so.logic.order.OrderStatusHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.msk.so.logic.SO151409Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * 卖家销售排名
 * Created by yang_chunyan on 2016/3/22.
 */
@Controller
@RequestMapping("SO151409")
@SessionAttributes("param")
public class SO151409Controller extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SO151409Controller.class);

    @Autowired
    private SO151409Logic SO151409Logic;
    @Autowired
    private OrderStatusHandle orderStatusHandle;

    /**
     * 加载卖家销售排名界面
     * @param param
     * @param model
     * @return
    */
    @RequestMapping(value="init", method = RequestMethod.POST)
    public String init(BasePageParam param, Model model) {
        model.addAttribute("param", param);
        logger.debug("初始化页面");
        return "so/SO151409";
    }

    /**
     * 分页查询卖家销售排行信息
     * @param basePageParam basePageParam
     * @return PageResult<SO151409Bean>
     */
    @RequestMapping(value = "search",  method = RequestMethod.POST)
    @ResponseBody
    public PageResult<SO151409Bean> search(BasePageParam basePageParam) {
        logger.info("查询数据库");
        DbUtils.buildLikeCondition(basePageParam, "lgcsCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "suppCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "suppName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "pdCode", DbUtils.LikeMode.FRONT);
        return this.SO151409Logic.findPage(basePageParam, SO151409Bean.class);
    }

    /**
     * 修改销售排名信息(销售排行/轮单次数)
     * @param lgcsCode 物流区编号
     * @param orderLevel 订单等级
     * @param pdCode 产品编码
     * @param suppCode 供应商编码
     * @param salesRanking 销售排行
     * @param wheelFrequency 轮单次数
     * @return
     */
    @RequestMapping(value="save", method = RequestMethod.POST)
    @ResponseBody
    public String save(String lgcsCode,String orderLevel,String pdCode,String suppCode,String salesRanking,String wheelFrequency) {
        BasePageParam param = new BasePageParam();
        param.setFilter("lgcsCode",lgcsCode);
        param.setFilter("orderLevel",orderLevel);
        param.setFilter("pdCode",pdCode);
        param.setFilter("suppCode",suppCode);
        param.setFilter("salesRanking", salesRanking);
        param.setFilter("wheelFrequency", wheelFrequency);
        int result = this.SO151409Logic.saveSalesRanking(param);
        if(result > 0) {
            return SystemConst.RsStatus.SUCCESS;
        } else {
            return SystemConst.RsStatus.FAIL;
        }
    }
}
