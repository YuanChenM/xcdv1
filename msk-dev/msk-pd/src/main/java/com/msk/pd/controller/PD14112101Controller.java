package com.msk.pd.controller;

import com.msk.common.logic.LogisticsAreaLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.MdLogisticsArea;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.pd.bean.PD141121Bean;
import com.msk.pd.logic.PD14112101Logic;
import com.msk.pd.logic.PD141121Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msk.core.web.base.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 物流区产品管理
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("PD14112101")
public class PD14112101Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(PD141121Controller.class);

    /**
     * 注入PD141121Logic
     */
    @Autowired
    private PD141121Logic pd141121Logic;

    @Autowired
    private PD14112101Logic pd14112101Logic;

    @Autowired
    private LogisticsAreaLogic logisticsAreaLogic;

    /**
     * 默认选择物流区编码为'01'的物流区,初始化
     * @param model model
     * @return PD141121
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String initA(String lgcsAreaCode,Model model) {
        if(lgcsAreaCode==null){
            return this.init("41", model);
        }else{
            return this.init(lgcsAreaCode,model);
        }

    }

    @RequestMapping(value = "checkedList",
            method = RequestMethod.POST)
    public String checkedList(String lgcsAreaCode,Model model) {

        List<MdLogisticsArea> logisticsAreas = this.pd141121Logic.findListChecked(lgcsAreaCode);
        model.addAttribute("lgcsAreaCode",lgcsAreaCode);
        model.addAttribute("logisticsAreas",logisticsAreas);
        return "pd/PD141121";
    }


    /**
     * 物流区产品管理画面初始化
     * @param lgcsAreaCode 物流区编码
     * @param model model
     * @return PD141121
     */
    @RequestMapping(value = "init/{lgcsAreaCode}",
            method = RequestMethod.POST)
    public String init(@PathVariable("lgcsAreaCode") String lgcsAreaCode, Model model) {
        logger.debug("物流区产品管理画面初始化");
        BasePageParam param = new BasePageParam();
        /*param.setFilter("",);*/
        param.getFilterMap().put("delFlg", NumberConst.IntDef.INT_ZERO);
        List<MdLogisticsArea> logisticsAreas = this.pd141121Logic.findList(param);

        /*model.addAttribute("lgcsAreaCode",lgcsAreaCode);*/
        model.addAttribute("lgcsAreaCode",lgcsAreaCode);
        model.addAttribute("logisticsAreas",logisticsAreas);
        return "pd/PD14112101";
    }

    /**
     *
     * 添加数据
     * @param bean PD141121Bean
     * @param model model
     * @return 实例化
     */
    @RequestMapping(value = "add",
            method = RequestMethod.POST)
    public String add(PD141121Bean bean, Model model) {
        bean.setDelFlg("0");
        bean.setCrtId("admin");
        bean.setCrtTime(DateTimeUtil.getCustomerDate());
        bean.setUpdId("admin");
        bean.setUpdTime(DateTimeUtil.getCustomerDate());
        bean.setActId("admin");
        bean.setVer(NumberConst.IntDef.INT_ONE);
        int resultCount = this.pd141121Logic.save(bean);
        if (resultCount <= NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("插入失败，请重新操作！");
        }
        return this.init(bean.getLgcsAreaCode(), model);
    }

    /**
     * 删除数据
     * @param bean PD141121Bean
     * @param model model
     * @return 页面
     */
    @RequestMapping(value = "delete",
            method = RequestMethod.POST)
    @ResponseBody
    public String delete(PD141121Bean bean, Model model){
        int resultCount = this.pd141121Logic.remove(bean);
        if (resultCount <= NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("删除失败，请重新操作！");
        }
        return "ok";//this.init(bean.getLgcsAreaCode(), model);
    }

    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */

    @RequestMapping(value = "search/{lgcsAreaCode}",
            method = RequestMethod.POST)
    public @ResponseBody
    PageResult<PD141121Bean> search(@PathVariable("lgcsAreaCode") String lgcsAreaCode,BasePageParam param) {
        /*logger.debug(lgcsAreaCode);*/
/*
        if(s!=null){
            param.getFilterMap().put("lgcsAreaCode",s);
        }*/
        /*param.getFilterMap().put("lgcsAreaCode", lgcsAreaCode);*/
        //param.setPageSize(NumberConst.IntDef.INT_THIRTY);
        DbUtils.buildLikeCondition(param, "classesCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "machiningCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "breedCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "featureCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "weightCode", DbUtils.LikeMode.FRONT);


        /*DbUtils.buildLikeCondition(param, "lgcsAreaCode", DbUtils.LikeMode.FRONT);*/


        DbUtils.buildLikeCondition(param, "lgcsAreaName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "classesName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "machiningName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "breedName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "featureName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "weightName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "gradeCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "gradeName", DbUtils.LikeMode.FRONT);
        return pd14112101Logic.findPage(param, PD141121Bean.class);
    }

}
