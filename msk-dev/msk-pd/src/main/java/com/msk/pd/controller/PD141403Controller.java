package com.msk.pd.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.pd.bean.PD141402Bean;
import com.msk.pd.bean.PD141403Bean;
import com.msk.pd.logic.PD141402Logic;
import com.msk.pd.logic.PD141403Logic;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * controller 卖家单个产品及状态在线管控一览
 *
 * @author xhy
 */
@Controller
@RequestMapping(value = "PD141403")
public class PD141403Controller extends BaseController {
    @Autowired
    private PD141403Logic pd141403Logic;

    /**
     * 实例化页面
     *
     * @return 卖家产品信息页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    private String init(Model model,PD141402Bean beans) {
        model.addAttribute("beans",beans);
        return "pd/PD141403";
    }

    /**
     * 查询审批审核列表
     *
     * @param basePageParam basePageParam
     * @return 信息
     * @author xhy
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<PD141403Bean> search(BasePageParam basePageParam,PD141402Bean nameBean) {
        PageResult<PD141403Bean> pageResult =   this.pd141403Logic.findPage(basePageParam,PD141403Bean.class);
        List<PD141403Bean> beans =  pageResult.getData();
        if(beans.size()> NumberConst.IntDef.INT_ZERO){
            for(PD141403Bean bean:beans){
                bean.setShowDate(PD141404Controller.formatter.format(bean.getCheckDate()));
                bean.setPdClassesName(nameBean.getPdClassesName());
                bean.setMachiningName(nameBean.getMachiningName());
                bean.setPdBreedName(nameBean.getPdBreedName());
                bean.setPdFeatureName(nameBean.getPdFeatureName());
                bean.setWeightName(nameBean.getWeightName());
                bean.setClassestreeCode(nameBean.getClassestreeCode());
                bean.setCheckDate(null);
            }
            return pageResult;
        }
        PageResult<PD141403Bean> result = new PageResult<PD141403Bean>();
        List<PD141403Bean> beansNull = new ArrayList<PD141403Bean>();
        result.setData(beansNull);
        return result;
    }
}