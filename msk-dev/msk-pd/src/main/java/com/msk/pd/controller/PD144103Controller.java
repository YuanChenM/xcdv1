package com.msk.pd.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.msk.common.logic.LogisticsAreaLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.MdLogisticsArea;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.pd.bean.PD144103Bean;
import com.msk.pd.bean.PD144103Param;
import com.msk.pd.logic.PD144103Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 产品类别信息controller
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "PD144103")
public class PD144103Controller extends BaseController {
    @Autowired
    private PD144103Logic pd144103Logic;
    @Autowired
    private LogisticsAreaLogic logisticsAreaLogic;

    /**
     * 实例化页面
     *
     * @param
     * @param model model
     * @return 界面
     * @author ren_qiang
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        List<MdLogisticsArea> lgcsAreaList = this.logisticsAreaLogic.findList(new BaseParam());
        model.addAttribute("lgcsAreaList", lgcsAreaList);
        return "pd/PD144103";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<PD144103Bean> search(PD144103Param param) {
        DbUtils.buildLikeCondition(param, "floorName", DbUtils.LikeMode.PARTIAL);
        PageResult<PD144103Bean> pageResult = pd144103Logic.findPage(param,PD144103Bean.class);
        for (int i = NumberConst.IntDef.INT_ZERO; i < pageResult.getData().size(); i++) {
            pageResult.getData().get(i).setSort(String.valueOf(i + NumberConst.IntDef.INT_ONE));
        }
        return pageResult;
    }

    @RequestMapping(value = "batchEdit", method = RequestMethod.POST)
    public
    @ResponseBody
    String batchEdit(String jsonStr) {
        Map<String, PD144103Bean> map = null;
        if (StringUtils.hasLength(jsonStr)) {
            map = JSON.parseObject(jsonStr, new TypeReference<Map<String, PD144103Bean>>() {
            });
            PD144103Param param = new PD144103Param();
            super.setCommonParam(param);
            Date date = DateTimeUtil.getCustomerDate();
            param.setUpdTime(date);
            Integer cot = pd144103Logic.batchEditSort(map.values(), param);
            if (cot != null && cot != 0) {
                return "S";
            } else {
                return "F";
            }
        }
        return "F";
    }

    @RequestMapping(value = "deleteAppFloor", method = RequestMethod.POST)
    public
    @ResponseBody
    String deleteAppFloor(PD144103Bean bean) {
        if (null != bean) {
            super.setCommonParam(bean);
            Date date = DateTimeUtil.getCustomerDate();
            bean.setUpdTime(date);
            Integer cot = pd144103Logic.delete(bean);
            if (cot != null && cot != 0) {
                return "S";
            } else {
                return "F";
            }
        }
        return "F";
    }
}
