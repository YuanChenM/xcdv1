package com.msk.sl.controller;

import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SL2411030033Bean;
import com.msk.sl.bean.SL241103070Bean;
import com.msk.sl.bean.SL24110307Bean;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL24110109Logic;
import com.msk.sl.logic.SL241103009Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by writer on 2016/1/31.
 */
@Controller
@RequestMapping("SL24110109")
public class SL24110109Controller extends BaseUploadController{

    @Autowired
    private SL24110109Logic sl24110109Logic;
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(MultipartFile file,HttpServletResponse response,SL241103070Bean sL241103070Bean,HttpServletRequest request) throws IOException {
        sL241103070Bean.setUpdId(super.getLoginUser().getUpdId());
        this.sl24110109Logic.update(sL241103070Bean);
        if (file.getSize() == 0) {
            super.callBack(null, "保存成功", response);
        } else {
            //卖家负责人图片
            if(null!=sL241103070Bean && sL241103070Bean.getEleaderFlg().equals("团队负责人")){
                //图片上传到ftp里面
                String epId=request.getSession().getAttribute("jsp_epId2").toString();
                String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+epId+"/";
                String uploadFileName=BusinessConst.SLPath.ECTEAM+"01";
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(file,uploadFilePath,uploadFileName);
                super.callBack(null, "保存成功", response);
            }else {
                //图片上传到ftp里面
                String epId=request.getSession().getAttribute("jsp_epId2").toString();
                String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+epId+"/";
                String uploadFileName=BusinessConst.SLPath.ECTEAM+sL241103070Bean.getEmemberId();
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(file,uploadFilePath,uploadFileName);
                super.callBack(null, "保存成功", response);
            }

        }
    }

    @RequestMapping("delete")
    public void deleteETeam(SL241103070Bean sL241103070Bean,HttpServletRequest request,HttpServletResponse response) throws IOException {
        this.sl24110109Logic.removeETeam(sL241103070Bean);
        String epId=request.getSession().getAttribute("jsp_epId2").toString();
        String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epId + "/";
        //卖家负责人图片
        String uploadFileName="";
        if(null!=sL241103070Bean && sL241103070Bean.getEleaderFlg().equals("团队负责人")){
            uploadFileName=BusinessConst.SLPath.ECTEAM+"01";
        }else{
            uploadFileName=BusinessConst.SLPath.ECTEAM+sL241103070Bean.getEmemberId();
        }

        SLUploadFile slUploadFile = new SLUploadFile();
        slUploadFile.deleteFileFromFtp(uploadFilePath, uploadFileName);
        super.callBack(null,"删除成功",response);
    }

}
