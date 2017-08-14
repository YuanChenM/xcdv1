package com.msk.sl.controller;

import com.msk.core.entity.SlEpCap;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL2411010402Logic;
import com.msk.sl.logic.SL24110300402Logic;
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
@RequestMapping("SL24110300402")
public class SL24110300402Controller extends BaseUploadController {
    //厂房平面图
    @Autowired
    private SL24110300402Logic sL24110300402Logic;
    @Autowired
    private SL2411010402Logic sL2411010402Logic;
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(SlEpCap slEpCap,MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(null==request.getSession().getAttribute("jsp_epId") || "".equals(request.getSession().getAttribute("jsp_epId"))){
            throw new BusinessException("请先创建账号信息");
        }
        Long slEpId = (Long)request.getSession().getAttribute("jsp_epId");
        slEpCap.setEpId(slEpId);
        slEpCap.setDelFlg("0");
        /**查询用户是否已经录入信息了 如果已经录入就更新，如果没有可以正常保存*/
        SlEpCap slCap=this.sL24110300402Logic.findSlEpCapIfExist(slEpId);
        if(null==slCap){
            this.sL24110300402Logic.saveSlEpCap(slEpCap);
        }else{
            this.sL24110300402Logic.updateSlEpCap(slEpCap);
        }
        if(file.getSize()!=0){
            String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+slEpId+"/";
            String uploadFileName=BusinessConst.SLPath.EPWORKSHOP;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
        }
        super.callBack(null,"上传成功",response);
    }
}
