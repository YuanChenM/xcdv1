package com.msk.sl.controller;

import com.msk.core.exception.BusinessException;
import com.msk.core.file.FtpUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SL241103070Bean;
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
import java.io.PrintWriter;

/**
 * Created by writer on 2016/2/3.
 */
@Controller
@RequestMapping("SL2411030091")
public class SL2411030091Controller extends BaseUploadController{

    @Autowired
    private SL241103009Logic sL241103009Logic;

    @RequestMapping("init")
    public  String init(){
        return "sl/SL2411030091";
    }

    @RequestMapping("insert")
    public void insert(HttpServletRequest request,MultipartFile file,HttpServletResponse response,SL241103070Bean sL241103070Bean) throws IOException {
        String slCode = request.getSession().getAttribute("jsp_slCode").toString();
        sL241103070Bean.setEslCode(slCode);
        Long epId = (Long)request.getSession().getAttribute("jsp_epId2");
        String eleaderFlg = sL241103070Bean.getEleaderFlg();
        /**一个电商团队只有一个负责人*/
        if("1".equals(eleaderFlg)) {
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
                    String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+epId+"/";
                    String uploadFileName=BusinessConst.SLPath.ECTEAM+"01";
                    SLUploadFile slUploadFile = new SLUploadFile();
                    slUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
                    super.callBack(null, "保存成功", response);
                }else {
                    //图片上传到ftp里面
                    String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+epId+"/";
                    String uploadFileName=BusinessConst.SLPath.ECTEAM+sL241103070Bean.getEmemberId();
                    SLUploadFile slUploadFile = new SLUploadFile();
                    slUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
                    super.callBack(null, "保存成功", response);
                }

            }
        }

    protected void callBack2(String account,String callbackFun, String message, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<script type='text/javascript'>");
        writer.write("window.parent.");
        if(StringUtil.isEmpty(callbackFun)){
            writer.write("callbackFun2('"+message+"','"+account+"')");
        }else{
            writer.write(callbackFun+"(");
            if(!StringUtil.isEmpty(message)){
                writer.write("'"+message+"'");
            }
            writer.write(")");
        }
        writer.write("</script>");
    }
}
