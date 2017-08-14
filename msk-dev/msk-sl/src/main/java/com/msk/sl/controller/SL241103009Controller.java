package com.msk.sl.controller;

import com.msk.core.exception.BusinessException;
import com.msk.core.file.FtpUtils;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SL24110306Bean;
import com.msk.sl.bean.SL241103070Bean;
import com.msk.sl.bean.SL24110307Bean;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL241103009Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by fjm on 2016/1/30.
 */
@Controller
@RequestMapping("SL241103009")
public class SL241103009Controller extends BaseUploadController {

    @Autowired
    private SL241103009Logic sL241103009Logic;

    @RequestMapping("init")
     public String init() {
        return "sl/SL241103009";
    }

    @RequestMapping("insert")
    public void insert(MultipartFile file, HttpServletResponse response, SL241103070Bean sL241103070Bean, HttpServletRequest request) throws IOException {
        if(null==request.getSession().getAttribute("jsp_epId") || "".equals(request.getSession().getAttribute("jsp_epId"))){
            throw new BusinessException("请先创建账号信息");
        }
        Long epId = (Long) request.getSession().getAttribute("jsp_epId");
        if(null==request.getSession().getAttribute("jsp_slCode") || "".equals(request.getSession().getAttribute("jsp_slCode"))){
            throw new BusinessException("请先创建账号信息");
        }
        String slCode = request.getSession().getAttribute("jsp_slCode").toString();
        sL241103070Bean.setEslCode(slCode);
        String eleaderFlg = sL241103070Bean.getEleaderFlg();
        /**一个电商团队只有一个负责人*/
        if ("1".equals(eleaderFlg)) {
            SL241103070Bean s = this.sL241103009Logic.selectTeamLeader(eleaderFlg, slCode);
            if (null != s) {
                throw new BusinessException("只允许一名负责人，您已经录入了负责人信息！");
            }
        }
        //ememberId去数据库查询出当前slCode里ememberId里最大的那个然后进行+1即可
        SL241103070Bean m = this.sL241103009Logic.maxBrandByEpId(slCode);
        if (m == null) {
            sL241103070Bean.setEmemberId(1);
        } else {
            Integer mid = m.getEmemberId() + 1;
            sL241103070Bean.setEmemberId(mid);
        }

        this.sL241103009Logic.saveEteam(sL241103070Bean);
        if (file.getSize() == 0) {
            super.callBack(null, "保存成功", response);
        } else {

            //卖家负责人图片
            if(null!=sL241103070Bean && sL241103070Bean.getEleaderFlg().equals("1")){
                //图片上传到ftp里面
                String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epId + "/";
                String uploadFileName = BusinessConst.SLPath.ECTEAM +"01";
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
                super.callBack(null, "保存成功", response);
            }else{
                //图片上传到ftp里面
                String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epId + "/";
                String uploadFileName = BusinessConst.SLPath.ECTEAM + sL241103070Bean.getEmemberId();
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
                super.callBack(null, "保存成功", response);
            }
        }
    }
}
