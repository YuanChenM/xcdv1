package com.msk.sl.controller;

import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.bean.SlEpDdBean;
import com.msk.sl.logic.SL241103012Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by writer on 2016/1/27.
 */
@Controller
@RequestMapping("SL24110301201")
public class SL24110301201Controller extends BaseUploadController{

    @Autowired
    private SL241103012Logic sl241103012Logic;

    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(){
        return "sl/SL24110301201";
    }

    /**
     *
     * @param slEpDdBean slEpDdBean
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(MultipartFile slEpDdFile,SlEpDdBean slEpDdBean,HttpServletRequest request,HttpServletResponse response)throws IOException{
        /**获取用户存储的当前epID*/
        Long slEpId = (Long)request.getSession().getAttribute("jsp_epId2");
        slEpDdBean.setCrtId(super.getLoginUser().getCrtId());
        int num=sl241103012Logic.saveData(slEpId,slEpDdBean);
        /**保存实验室图片*/
        if(slEpDdFile.getSize()!=0){
            String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+slEpId+"/";
            String uploadFileName=BusinessConst.SLPath.EPTESTING+slEpDdBean.getDdId();
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(slEpDdFile,uploadFilePath,uploadFileName);
        }
        super.callBack(null,"保存成功",response);
    }
}
