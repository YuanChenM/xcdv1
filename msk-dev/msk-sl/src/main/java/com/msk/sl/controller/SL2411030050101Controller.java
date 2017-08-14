package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.entity.SlEpWorkshop;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL24110300501Logic;
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
@RequestMapping("SL2411030050101")
public class SL2411030050101Controller extends BaseUploadController {

    @RequestMapping("init")
    public  String init(){
        return "sl/SL2411030050101";
    }

    @Autowired
    private SL24110300501Logic sL24110300501Logic;
    @Autowired
    private CommonLogic commonLogic;
    /** 保存车间概括信息*/
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(MultipartFile file,SlEpWorkshop slEpWorkshop,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(null==request.getSession().getAttribute("jsp_epId2") || "".equals(request.getSession().getAttribute("jsp_epId2"))){
            throw new BusinessException("请先创建账号信息");
        }
        if(null==slEpWorkshop.getWorkshopName() || "".equals(slEpWorkshop.getWorkshopName().trim())){
            throw new  BusinessException("请输入车间的名称");
        }
        /**获取用户存储的当前epID*/
        Long slEpId = (Long)request.getSession().getAttribute("jsp_epId2");
        this.sL24110300501Logic.findIfExist(slEpId,slEpWorkshop.getWorkshopName());
        Long maxId = this.commonLogic.maxId("SL_EP_WORKSHOP", "WORKSHOP_ID");
        if(null!=slEpWorkshop.getProcess() || null!=slEpWorkshop.getProduct() || null!=slEpWorkshop.getWorkshopName()){
            //保存生产车间信息
            slEpWorkshop.setEpId(slEpId);
            slEpWorkshop.setWorkshopId(maxId);
            this.sL24110300501Logic.saveSlEpWorkshop(slEpWorkshop,slEpId);
            if(file.getSize()!=0){
                String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+slEpId+"/";
                String uploadFileName=BusinessConst.SLPath.EPWORKSHOPDES+maxId;
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
            }
            super.callBack(null,"上传成功",response);
        }
    }
}
