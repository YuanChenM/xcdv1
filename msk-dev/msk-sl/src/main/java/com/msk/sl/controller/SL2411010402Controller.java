package com.msk.sl.controller;

import com.msk.core.entity.SlEpCap;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SLUploadFile;
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
@RequestMapping("SL2411010402")
public class SL2411010402Controller extends BaseUploadController {

    @Autowired
    private SL24110300402Logic sL24110300402Logic;
    /**
     * 更新厂区概要信息
     * @param file 上传图片
     * @param slEpCap 数据
     * @param request 请求
     * @param response 响应
     * @throws IOException IO异常
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(MultipartFile file,SlEpCap slEpCap,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(null==request.getSession().getAttribute("jsp_epId2")){
            throw new BusinessException("没有获取到账号信息，请重新进入");
        }
        Long slEpId = (Long)request.getSession().getAttribute("jsp_epId2");
        slEpCap.setEpId(slEpId);
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
        super.callBack(null,"更新数据成功",response);
    }
}
