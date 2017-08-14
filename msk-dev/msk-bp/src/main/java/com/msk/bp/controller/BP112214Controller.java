package com.msk.bp.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.msk.bp.bean.BP112214Bean;
import com.msk.bp.bean.BP112215Bean;
import com.msk.bp.logic.BP112214Logic;
import com.msk.common.bean.PriceCycle;
import com.msk.common.utils.PriceCycleUtils;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.StringConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.bean.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 美侍客价盘卖家查看画面  controller
 * Created by zhang_qiang1 on 2016/3/29.
 */
@Controller
@RequestMapping(value="BP112214")
public class BP112214Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BP112214Controller.class);

    @Autowired
    private BP112214Logic bp112214Logic;


    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("价盘卖家查看画面初始化");
        return "bp/BP112214";
    }



    /**
     * @return PageResult<BP112214Bean>
     * @author zhang_qiang1
     * @param basePageParam basePageParam
     */
    @RequestMapping(value = "search",  method = RequestMethod.POST)
    @ResponseBody
    public   PageResult<BP112214Bean> search(BasePageParam basePageParam) {
        String breedName= (String) basePageParam.getFilterMap().get("pdName");
       // basePageParam.getFilterMap().put("pdCode", this.bp112214Logic.getBreedCodeP(breedName.trim())) ;
       List<BP112214Bean> beans= this.bp112214Logic.getBreeds(breedName.trim());
        if(beans!=null&&beans.size()==0){
             BP112214Bean bp=  new BP112214Bean();
            bp.setPdCode("-1");//  在查询情况下   因为查询 pd_breed 表中没有数据  所以 设置 一个 pdcode  不存在的数值 这样 返回就是 空
            beans.add(bp) ;
        }
        basePageParam.getFilterMap().put("pdCodeList",beans);
        PageResult<BP112214Bean> pageResult=new PageResult<BP112214Bean>();
        LoginUser user=  this.getLoginUser();
        String slCode= this.bp112214Logic.getSlCode(user.getEmplId());//  获取slcode
        if(slCode.length()>0){
          basePageParam.getFilterMap().put("slCode",slCode);
        }
        logger.info("查询数据库");
       pageResult = this.bp112214Logic.findPage(basePageParam, BP112214Bean.class);
       this.bp112214Logic.setProductPagram(pageResult);
        return pageResult;
    }


    /**
     * 点击+ 按钮  通过ajax 访问   获取对应的参数
     * @param param
     * @return
     */
    @RequestMapping(value = "findOrderLevelList", method = RequestMethod.POST)
    @ResponseBody
    public List<BP112214Bean> findOrderLevelList(BaseParam param) {
        logger.debug("获取订单等级列表");
        return bp112214Logic.getOrderLevelList(param);
    }





}
