package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.entity.SlEpHonor;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL24110300401Logic;
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
@RequestMapping("SL2411030040101")
public class SL2411030040101Controller extends BaseUploadController {

    @RequestMapping("init")
    public  String init(){
        return "sl/SL2411030040101";
    }

    @Autowired
    private SL24110300401Logic sL24110300401Logic;
    @Autowired
    private CommonLogic commonLogic;
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(MultipartFile file,SlEpHonor slEpHonor,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(null==request.getSession().getAttribute("jsp_epId2") || "".equals(request.getSession().getAttribute("jsp_epId2"))){
            throw new BusinessException("请先创建账号信息");
        }
        if(null==slEpHonor.getHonorDesc() || "".equals(slEpHonor.getHonorDesc())){
            throw new BusinessException("请填写荣誉描述信息");
        }
        Long honorId = this.commonLogic.maxId("SL_EP_HONOR","HONOR_ID");
        Long slEpId = (Long)request.getSession().getAttribute("jsp_epId2");
        /**查询同一个epID下的荣誉描述是否相同，相同则提示不必继续添加 不同 则继续增加荣誉*/
        this.sL24110300401Logic.findIfExistHonor(slEpId,slEpHonor.getHonorDesc());
        if(null!=slEpHonor.getCertDate()||null!=slEpHonor.getCertIssuer()||null!=slEpHonor.getHonorDesc()){
            slEpHonor.setHonorId(honorId);
            this.sL24110300401Logic.saveSlEpHonor(slEpHonor,slEpId);
            if(file.getSize()!=0){
                String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+slEpId+"/";
                String uploadFileName=BusinessConst.SLPath.EPHON+honorId;
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
            }
            super.callBack(null,"保存成功",response);
        }
    }
}
