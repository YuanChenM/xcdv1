package com.msk.sl.controller;

import com.msk.core.entity.SlEpCap;
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
@RequestMapping("SL2411010502")
public class SL2411010502Controller extends BaseUploadController {

    @Autowired
    private SL24110300502Logic sL24110300502Logic;
    @Autowired
    private SL24110300402Logic sL24110300402Logic;
    /**更新库容信息*/
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void save(MultipartFile file,SlEpCap slEpCap,HttpServletRequest request,HttpServletResponse response) throws IOException {
        /**获取用户存储的当前epID*/
        Long slEpId = (Long)request.getSession().getAttribute("jsp_epId2");
        slEpCap.setEpId(slEpId);
        SlEpCap slCap=this.sL24110300402Logic.findSlEpCapIfExist(slEpId);
        if(null==slCap){
            this.sL24110300402Logic.saveSlEpCap(slEpCap);
        }else{
            /**更新库容信息数据*/
            this.sL24110300502Logic.updateSlEpCap(slEpCap);
        }
        if(file.getSize()!=0){
            String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+slEpId+"/";
            String uploadFileName=BusinessConst.SLPath.EPWAREHOUSE;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
        }
        super.callBack(null,"更新数据成功",response);
    }
}
