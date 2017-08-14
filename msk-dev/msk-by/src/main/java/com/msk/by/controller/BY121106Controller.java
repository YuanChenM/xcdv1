package com.msk.by.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.msk.core.consts.NumberConst;
import com.msk.core.file.FtpUtils;
import com.msk.core.utils.ConfigManager;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;

/**
 * BY121101Controller
 *
 * @author pxg
 *
 */
@Controller
@RequestMapping("BY121106")
public class BY121106Controller extends BaseUploadController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BY121106Controller.class);

    /**
     * 前台图片上传到ftp临时文件服务器
     * @param buyerId
     * @param file
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "upload",
            method = RequestMethod.POST)
    public String upload(String buyerId,MultipartFile file, HttpServletResponse response) throws IOException {
        picFileUpload(buyerId,file);
        return null;
    }

    /**
     * 图片上传
     * @param buyerId
     * @param file
     * @throws IOException
     */
    public void picFileUpload(String buyerId,MultipartFile file) throws IOException{
        //ftpIp地址
        String url = ConfigManager.getFtpIp();
        //ftp登陆密码
        String password=ConfigManager.getFtpPwd();
        //ftp登陆名称
        String userName = ConfigManager.getFtpUser();
        //端口号
        int port= NumberConst.IntDef.INT_TWENTY_ONE;
        FtpUtils ftpUtils = new FtpUtils(url,port,userName,password);
        //上传文件名称
        String fileName = this.getFileName(file);
        //本地文件路径
        String localPath = System.getProperty("java.io.tmpdir");
        //保存到本地
        this.saveFile(file,localPath);
        //图片上传到临时服务器路径
        String uploadFilePath = ConfigManager.getFtpImageRootPath() + BusinessConst.BYPath.TEMPIMAGEPATH + "/" + buyerId +"/";
        //读取本地存储的文件
        File uploadTempFile = new File(localPath,fileName);
        //上传到ftp临时文件服务器
        ftpUtils.upload(uploadFilePath,uploadTempFile);
        //删除本地文件
        uploadTempFile.delete();
    }
}
