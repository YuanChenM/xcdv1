package com.msk.ms.controller;
import com.msk.core.web.base.*;
import com.msk.core.entity.MsCardmanager;
import com.msk.ms.logic.MS11210101Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * MS11210101Controller
 * 会员卡信息修改
 * @author fjm
 *
 */
@Controller
@RequestMapping("MS11210101")
public class MS11210101Controller extends BaseController{

    private static Logger LOGGER = LoggerFactory.getLogger(MS11210101Controller.class);
    
    @Autowired
    private MS11210101Logic mS11210101Logic;
    
   /**
    * 初始化进入会员卡信息编辑页面（MS11210101.jsp），回显会员卡相关数据
    * @param msId 传入msId参数
    * @param mav ModelAndView
    * @return String返回对象
    */
    @RequestMapping(value = "init/{msId}",method = RequestMethod.POST)
    public String init(@PathVariable String msId,Model mav){
        LOGGER.debug("进入MS11210101页面");
        if(isDebug){
            LOGGER.debug("页面填充假数据");
            MsCardmanager msCardmanager = new MsCardmanager();
            
            msCardmanager.setMsId(1L);
            msCardmanager.setMsCardno("XXXXXXXXX00001");
            msCardmanager.setBuyerCode("XXXXXXXXXXXX00001");
            msCardmanager.setBuyerName("张三");
            msCardmanager.setIsActivate("是");
            msCardmanager.setIsProvide("挂失");
            msCardmanager.setProvideDate(new Date());
            msCardmanager.setPurchaseLot("20151224"); 
            
            mav.addAttribute("msCardmanager", msCardmanager);
            return "ms/MS11210101";
        }else{            
            MsCardmanager msCardmanager = this.mS11210101Logic.mS11210101Entity(msId);
            mav.addAttribute("msCardmanager", msCardmanager);
            return "ms/MS11210101";
        }
    }


    /**
     * 保存修改会员卡信息
     * @param msCardmanager 页面传入对象
     * @param model ModelAndView
     * @return String 返回页面
     * @throws Exception 异常抛出
     */
    @RequestMapping(value = "update",
        method = RequestMethod.POST)
    public String update(MsCardmanager msCardmanager,Model model) throws Exception {
        this.mS11210101Logic.modifyOne(msCardmanager);
        return "ms/MS112101";
    }
}
