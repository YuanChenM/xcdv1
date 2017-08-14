package com.msk.sp.controller;

import com.msk.common.bean.PriceCycle;
import com.msk.common.utils.PriceCycleUtils;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseController;
import com.msk.sp.bean.SP171103Bean;
import com.msk.sp.bean.SP171128Bean;
import com.msk.sp.logic.SP171128Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * SP171128Controller
 *
 * @author wu_honglei
 *
 */
@Controller
@RequestMapping("SP171128")
public class SP171128Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SP171128Controller.class);

    @Autowired
    private SP171128Logic sp171128Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model) {

        logger.debug("产品报价画面初始化");

        Date dateNow = DateTimeUtil.getCustomerDate();

        PriceCycle priceCycle = PriceCycleUtils.getNextPriceCycle(dateNow, NumberConst.IntDef.INT_ZERO);
        BaseParam param1 = new BaseParam();
        super.setCommonParam(param1);
        String loginId = param1.getActId();

        List<SP171128Bean> districtList = new ArrayList<>();
        //构造假数据
        SP171128Bean spBean1 = new SP171128Bean();
        spBean1.setLgcsName("上海");
        districtList.add(spBean1);

        SP171128Bean spBean2 = new SP171128Bean();
        spBean2.setLgcsName("南京");
        districtList.add(spBean2);

        SP171128Bean spBean3 = new SP171128Bean();
        spBean3.setLgcsName("杭州");
        districtList.add(spBean3);

       model.addAttribute("districtList",districtList);
        model.addAttribute("startDate", priceCycle.getStartDate());
        model.addAttribute("endDate",priceCycle.getEndDate());
        model.addAttribute("dayAmount",priceCycle.getDayAmount());
        model.addAttribute("cycleCode",priceCycle.getCycleCode());
        model.addAttribute("loginId", loginId);


        return "sp/SP171128";
    }

    /**
     * 分页查询数据
     *
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",  method = RequestMethod.POST)
    public @ResponseBody PageResult<SP171128Bean> search(BasePageParam pageParam) {
        logger.debug("价盘平台查看查询");
        //判断当前用户登录是否失效
        //this.getLoginUser();

        return sp171128Logic.findSP171128List(pageParam);
    }

}
