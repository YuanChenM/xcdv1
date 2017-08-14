package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.CommConstant;
import com.msk.core.exception.BusinessException;
import com.msk.core.file.FtpUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SL24110306Bean;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL2411030081Logic;
import com.msk.sl.logic.SL241103008Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by writer on 2016/2/2.
 */
@Controller
@RequestMapping("SL2411030081")
public class SL2411030081Controller extends BaseUploadController{

    @Autowired
    private SL241103008Logic sl241103008Logic;
    @Autowired
    private CommonLogic commonLogic;

    @RequestMapping("init")
    public  String init(Model mav){
        List<CommConstant> EpTeam = commonLogic.findConstantList("TeamPosition");
        mav.addAttribute("EpTeam",EpTeam);
        return "sl/SL2411030081";
    }

    @RequestMapping("insert")
    public void insert(HttpServletRequest request,MultipartFile file,HttpServletResponse response,SL24110306Bean sl24110306Bean) throws IOException {
        Long epId = (Long)request.getSession().getAttribute("jsp_epId2");
        String account = request.getSession().getAttribute("jsp_slAccount").toString();
        sl24110306Bean.setEpId(epId);
        /**管理人员职务非空判断，为空 则提示必须选择，不为空，根据传值，设置该成员职务*/
        if(null==sl24110306Bean.getMemberDuties()){
            throw  new BusinessException("请选择管理人员的职务");
        }
        /**根据传值，确定职务*/
        if("1".equals(sl24110306Bean.getMemberDuties())){
            sl24110306Bean.setMemberDuties("公司董事长");
        }
        if("2".equals(sl24110306Bean.getMemberDuties())){
            sl24110306Bean.setMemberDuties("公司总经理");
        }
        if("3".equals(sl24110306Bean.getMemberDuties())){
            sl24110306Bean.setMemberDuties("公司副总经理");
        }
        if("4".equals(sl24110306Bean.getMemberDuties())){
            sl24110306Bean.setMemberDuties("销售部经理");
        }
        if("5".equals(sl24110306Bean.getMemberDuties())){
            sl24110306Bean.setMemberDuties("品控部经理");
        }
        if("6".equals(sl24110306Bean.getMemberDuties())){
            sl24110306Bean.setMemberDuties("财务部经理");
        }
        //验证是否团队成员职务是否有重复
        //根据memberDuties和epId来查找数据库是否存在
        SL24110306Bean s= this.sl241103008Logic.checkMemberDuties(epId, sl24110306Bean.getMemberDuties());
        //账户已经有，返回告知用户换账户
        if (null != s) {
            throw new BusinessException("该职务已经存在！请重新填写！");
        }else {
            sl24110306Bean.setEpId(epId);
            //在manager表里用epid查询memberid，如果为空就设置为1，如果不为空就设置+1；
            SL24110306Bean m = this.sl241103008Logic.maxManagerByEpId(epId);
            if (m == null) {
                sl24110306Bean.setMemberId(1);
            } else {
                Integer mid = m.getMemberId() + 1;
                sl24110306Bean.setMemberId(mid);
            }
            sl24110306Bean.setCrtId(super.getLoginUser().getCrtId());
            sl24110306Bean.setVer(NumberConst.IntDef.INT_ONE);
            /**保存成员信息*/
            this.sl241103008Logic.saveManager(sl24110306Bean);
            /**如果没有上传图像，则不做操作*/
            if (file.getSize() == 0) {
                super.callBack(null, "保存成功", response);
            } else {
                //图片上传到ftp里面
                String uploadFilePath= BusinessConst.SLPath.SERVICEIMAGEPATH+"/"+BusinessConst.SLPath.SLIMAGEPATH+"/"+epId+"/";
                String uploadFileName="";
                if("公司董事长".equals(sl24110306Bean.getMemberDuties())){
                    uploadFileName=BusinessConst.SLPath.BOAMAN;
                }
                if("公司总经理".equals(sl24110306Bean.getMemberDuties())){
                    uploadFileName=BusinessConst.SLPath.GENMAN;
                }
                if("公司副总经理".equals(sl24110306Bean.getMemberDuties())){
                    uploadFileName=BusinessConst.SLPath.VICMAN;
                }
                if("销售部经理".equals(sl24110306Bean.getMemberDuties())){
                    uploadFileName=BusinessConst.SLPath.SALMAN;
                }
                if("品控部经理".equals(sl24110306Bean.getMemberDuties())){
                    uploadFileName=BusinessConst.SLPath.QCMAN;
                }
                if("财务部经理".equals(sl24110306Bean.getMemberDuties())){
                    uploadFileName=BusinessConst.SLPath.FINANCE;
                }
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(file,uploadFilePath,uploadFileName);
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
