package com.msk.ds.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msk.common.bean.PriceCycle;
import com.msk.common.utils.PriceCycleUtils;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.DsSlPdLot;
import com.msk.core.entity.MdLogisticsArea;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.ds.logic.DS174101Logic;
import com.msk.ds.logic.DS174103Logic;

/**
 * DS174101Controller
 * 
 * @author yuan_chen
 *
 */
@Controller
@RequestMapping("DS174101")
public class DS174101Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS174101Controller.class);

    /** DS174101Logic */
    @Autowired
    private DS174101Logic ds174101Logic;
    @Autowired
    private DS174103Logic ds174103Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("产品批次列表初始化");
        List<MdLogisticsArea> logisticsAreaList = this.ds174101Logic.findLogisticsArea();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("logisticsAreaList",logisticsAreaList);
        model.addAttribute("logisticsArea",jsonObject.toString());
        return "ds/DS174101";
    }

    /**
     *
     * @param currentDate 日期字符串
     * @return 日期半旬
     */
    @RequestMapping(value = "getPriceCycle/{currentDate}",
            method = RequestMethod.POST)
    public @ResponseBody PriceCycle getPriceCycle(@PathVariable("currentDate") String currentDate){
        return PriceCycleUtils.getPriceCycle(DateTimeUtil.parseDate(currentDate,"yyyy-MM-dd"),0);
    }

    /**
     *
     * @param dsSlPdLot 参数
     * @return 页面
     */
    @RequestMapping(value = "modify",
            method = RequestMethod.POST)
    public String modify(DsSlPdLot dsSlPdLot,Model model){
        BaseParam baseParam=new BaseParam();
        baseParam.getFilterMap().put("lotId",dsSlPdLot.getLotId());
        DsSlPdLot dp=this.ds174101Logic.findOne(baseParam);
        if(!dp.getLgcsCode().equals(dsSlPdLot.getLgcsCode())||!dp.getDateCode().equals(dsSlPdLot.getDateCode())){
            //新增操作
            dp.setDateCode(dsSlPdLot.getDateCode());
            dp.setLgcsCode(dsSlPdLot.getLgcsCode());
            dp.setLgcsName(dsSlPdLot.getLgcsName());
            ds174103Logic.save(dp);
        }
        return this.init(model);
    }


    /**
     * 分页查询数据
     * 
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<DsSlPdLot> search(BasePageParam param) {
        logger.debug("产品批次列表查询");
        DbUtils.buildLikeCondition(param, "slCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "slName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "classesCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "breedCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "featureCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "classesName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "breedName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "featureName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "pkgCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "lgcsName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "dateCode", DbUtils.LikeMode.FRONT);
        return ds174101Logic.findPage(param, DsSlPdLot.class);
    }

    /**
     * 删除批次
     * @param dsSlPdLot dsSlPdLot
     * @param model model
     * @return 页面
     */
    @RequestMapping(value = "delete",
            method = RequestMethod.POST)
    public String delete(DsSlPdLot dsSlPdLot,Model model){
        if(this.ds174101Logic.remove(dsSlPdLot)>0){
            this.ds174101Logic.removeSerial(dsSlPdLot);
        }
        return this.init(model);
    }
}
