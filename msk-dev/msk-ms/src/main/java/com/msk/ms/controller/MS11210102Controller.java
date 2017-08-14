package com.msk.ms.controller;
import com.msk.core.web.base.*;
import com.msk.core.entity.MsCardmanager;
import com.msk.ms.logic.MS11210102Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 会员卡密码修改
 * @author fjm
 *
 */
@Controller
@RequestMapping("MS11210102")
public class MS11210102Controller extends BaseController{
    
    /**
     * logger
     */
    private static Logger LOGGER = LoggerFactory.getLogger(MS11210102Controller.class);
    
    @Autowired
    private MS11210102Logic mS11210102Logic;
    /** des加密密钥 */
    String key="527f6b54";

    /**
     * 调用回调函数后初始化进入会员卡页面
     * @return String 返回String
     */
    @RequestMapping(value="init",method=RequestMethod.POST)
    public String init(){
        return "ms/MS112101";
    }
    
    /**
     * 点击按钮后初始化页面
     * @param msId msId数据
     * @param model ModleAndView
     * @return 返回页面
     * @throws Exception 异常抛出
     */
    @RequestMapping(value="init/{msId}",method=RequestMethod.POST)
    public String init(@PathVariable String msId,Model model) throws Exception{
        LOGGER.debug("进入MS11210102页面");
        if(isDebug){
            LOGGER.debug("页面填充假数据");
            MsCardmanager msCardmanager = new MsCardmanager();
            msCardmanager.setMsNowpw("zmsgsl");
            model.addAttribute("msCardmanager", msCardmanager);
        }
        MsCardmanager msCardmanager = this.mS11210102Logic.mS11210102Entity(msId);
        model.addAttribute("msCardmanager", msCardmanager);
        return "ms/MS11210102";
    }
    
    /**
     * 会员卡密码修改提交信息
     * @param msCardmanager 对象参数
     * @param msCardmanager 返回response
     * @throws Exception 异常抛出
     */
    @RequestMapping(value="updatePW",method=RequestMethod.POST)
    public @ResponseBody String updatePW(MsCardmanager msCardmanager) throws Exception{
        LOGGER.debug("成功进入controller");
        //1.获取页面当前密码数据,并加密
        String msPrevpw = msCardmanager.getMsPrevpw();
        String msNowpw = msCardmanager.getMsNowpw();
        String DESpwd = mS11210102Logic.encryDES(msPrevpw.getBytes(), key);
        
        //2.从后台获取当前密码数据
        MsCardmanager SqlmsCardmanager = this.mS11210102Logic.ms11210102Entity2(msCardmanager.getMsCardno());
        String password = SqlmsCardmanager.getMsNowpw();
        LOGGER.debug("页面输入的密码加密后为"+DESpwd);
        LOGGER.debug("后台当前密码为"+password);
        
        //3.判断2个密码是否一致并做相应处理
        if(DESpwd.equals(password)){
            LOGGER.debug("对比成功！");
            String nowPwd = mS11210102Logic.encryDES(msNowpw.getBytes(), key);
            msCardmanager.setMsNowpw(nowPwd);
            msCardmanager.setMsPrevpw(password);
            this.mS11210102Logic.modifyOne(msCardmanager);
            return "1";
        }else{
            LOGGER.debug("对比失败！");
            return "0";
        }
    }
}
