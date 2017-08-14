package com.msk.sl.controller;

import com.msk.core.entity.SlEpCap;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL24110300402Logic;
import com.msk.sl.logic.SL24110300502Logic;
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
@RequestMapping("SL24110300502")
public class SL24110300502Controller extends BaseUploadController {

    @Autowired
    private SL24110300502Logic sL24110300502Logic;
    @Autowired
    private SL24110300402Logic sL24110300402Logic;
    /** 库容*/
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(MultipartFile file,SlEpCap slEpCap,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(null==request.getSession().getAttribute("jsp_epId") || "".equals(request.getSession().getAttribute("jsp_epId"))){
            throw new BusinessException("请先创建账号信息");
        }
        /**获取用户存储的当前epID*/
        Long slEpId = (Long)request.getSession().getAttribute("jsp_epId");
        slEpCap.setEpId(slEpId);
        /**查询用户是否已经录入信息了 如果已经录入就更新，如果没有可以正常保存*/
        SlEpCap slCap=this.sL24110300402Logic.findSlEpCapIfExist(slEpId);
        if(null==slCap){
            this.sL24110300402Logic.saveSlEpCap(slEpCap);
        }else{
            /** 库容 */
            this.sL24110300502Logic.updateSlEpCap(slEpCap);
        }
        if(file.getSize()!=0){
            String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+slEpId+"/";
            String uploadFileName=BusinessConst.SLPath.EPWAREHOUSE;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(file,uploadFilePath,uploadFileName);
        }
        super.callBack(null,"上传成功",response);
    }
}
