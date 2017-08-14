package com.msk.sl.controller;

import com.msk.core.entity.SlAccount;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL24110100Logic;
import com.msk.sl.logic.SL24110101Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fjm on 2016/1/28.
 */
@Controller
@RequestMapping("SL24110101")
public class SL24110101Controller extends BaseUploadController{

    @Autowired
    private SL24110101Logic sL24110101Logic;

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(MultipartFile file,SlAccount slAccount,HttpServletResponse response) throws IOException {
        this.sL24110101Logic.update(slAccount);
        if (file.getSize() > 0) {
            //图片上传到ftp里面
            String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" +BusinessConst.SLPath.BASE+ "/";
            String uploadFileName = slAccount.getSlAccount();
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
        }
        super.callBack(null,"保存成功",response);
    }
}
