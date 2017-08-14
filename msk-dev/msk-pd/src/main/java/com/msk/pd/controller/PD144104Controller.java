package com.msk.pd.controller;


import com.msk.common.logic.LogisticsAreaLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.MdLogisticsArea;
import com.msk.core.entity.PdLogiarea;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseController;
import com.msk.pd.bean.PD144103Bean;
import com.msk.pd.bean.PD144103Param;
import com.msk.pd.bean.PD144104Bean;
import com.msk.pd.bean.PD144104Param;
import com.msk.pd.logic.PD144103Logic;
import com.msk.pd.logic.PD144104Logic;
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
 * 产品类别信息controller
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "PD144104")
public class PD144104Controller extends BaseController {
    @Autowired
    private PD144104Logic pd144104Logic;
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
    public String init(Model model,PD144103Bean bean,Integer isEdit) {
        List<MdLogisticsArea> lgcsAreaList = this.logisticsAreaLogic.findList(new BaseParam());
        model.addAttribute("lgcsList",lgcsAreaList);
        model.addAttribute("pdAppFloor",bean);
        model.addAttribute("isEdit",isEdit);
        model.addAttribute("floorId",bean.getId());
        model.addAttribute("lgcsCode",bean.getLgcsCode());
        return "pd/PD144104";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<PD144104Bean> search(PD144104Param param){
        return  pd144104Logic.findPage(param, PD144104Bean.class);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public  @ResponseBody String save(PD144103Param param){
        String id = "";
        if(null != param){
            super.setCommonParam(param);
            Date date = DateTimeUtil.getCustomerDate();
            param.setCrtTime(date);
            param.setUpdTime(date);
            param.setActTime(date);
            id = pd144104Logic.saveFloor(param);
        }
        return id;
    }


    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public  @ResponseBody Integer delete(PD144104Param param){
        return pd144104Logic.remove(param);
    }
}
