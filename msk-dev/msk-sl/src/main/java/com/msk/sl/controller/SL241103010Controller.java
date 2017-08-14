package com.msk.sl.controller;

import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.sl.bean.SlEpAgentAuthBean;
import com.msk.sl.logic.SL241103010Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by writer on 2016/1/27.
 */
@Controller
@RequestMapping("SL241103010")
public class SL241103010Controller extends BaseUploadController{

    @Autowired
    private SL241103010Logic sl241103010Logic;

    /**
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("save")
    public @ResponseBody int insert2(SlEpAgentAuthBean slEpAgentAuthBean,HttpServletResponse response,HttpServletRequest request) throws IOException {
        String slcode = StringUtil.toSafeString(request.getSession().getAttribute("jsp_slCode"));
        int count=NumberConst.IntDef.INT_ZERO;
        slEpAgentAuthBean.setCrtId(super.getLoginUser().getCrtId());
        if(StringUtil.isNullOrEmpty(slcode)){
            throw new BusinessException("请先创建账号信息!");
        }else{
            int num=sl241103010Logic.saveData(slcode,slEpAgentAuthBean);
            if(num>0){
                count= NumberConst.IntDef.INT_ONE;
            }
        }
        return count;
    }


    @RequestMapping(value="init",method = RequestMethod.POST)
    public String init() {

        return "sl/SL241103010";
    }
}
