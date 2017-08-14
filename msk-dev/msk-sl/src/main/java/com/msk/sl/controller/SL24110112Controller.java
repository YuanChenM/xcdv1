package com.msk.sl.controller;

import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SL241103070Bean;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.bean.SlEpDdBean;
import com.msk.sl.logic.SL24110109Logic;
import com.msk.sl.logic.SL24110112Logic;
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
@RequestMapping("SL24110112")
public class SL24110112Controller extends BaseUploadController{

    @Autowired
    private SL24110112Logic sl24110112Logic;
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(MultipartFile file,HttpServletResponse response,SlEpDdBean slEpDdBean,HttpServletRequest request) throws IOException {
        slEpDdBean.setUpdId(super.getLoginUser().getUpdId());
        String epId=request.getSession().getAttribute("jsp_epId2").toString();
        if(null!=epId){
            slEpDdBean.setEpId(Long.valueOf(epId));
        }
        this.sl24110112Logic.updateSlEPDd(slEpDdBean);
        if (file.getSize() == 0) {
            super.callBack(null, "保存成功", response);
        } else {
            //图片上传到ftp里面
            String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+epId+"/";
            String uploadFileName=BusinessConst.SLPath.EPTESTING+slEpDdBean.getDdId();
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(file,uploadFilePath,uploadFileName);
            super.callBack(null, "保存成功", response);
        }
    }

    @RequestMapping("delete")
    public void deleteETeam(SlEpDdBean slEpDdBean,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String epId=request.getSession().getAttribute("jsp_epId2").toString();
        if(null!=epId){
            slEpDdBean.setEpId(Long.valueOf(epId));
        }
        this.sl24110112Logic.delteSlEPDd(slEpDdBean);
        String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epId + "/";
        String uploadFileName=BusinessConst.SLPath.EPTESTING+slEpDdBean.getDdId();
        SLUploadFile slUploadFile = new SLUploadFile();
        slUploadFile.deleteFileFromFtp(uploadFilePath, uploadFileName);
        super.callBack(null,"删除成功",response);
    }

}
