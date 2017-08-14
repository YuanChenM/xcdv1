package com.msk.sl.controller;

/**
 * Created by fjm on 2016/1/26.
 */

import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlEpCert;
import com.msk.core.entity.SlEpCertItem;
import com.msk.core.entity.SlMstCert;
import com.msk.core.entity.SlMstCertItem;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL241103000Logic;
import com.msk.sl.logic.SL24110300301Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("SL2411010301")
/**
 * 初始化页面数据，根据certId查询该证照下的所有的项目名称
 *
 */
public class SL2411010301Controller extends BaseUploadController{
    List<SlMstCertItem> slMstCertItems=new ArrayList<>();
    @Autowired
    private SL24110300301Logic sl24110300301Logic;
    @Autowired
    private SL241103000Logic sl241103000Logic;
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model){
        Long epId=(Long)request.getSession().getAttribute("jsp_epId2");
        BaseParam baseParam = new BaseParam();
        List<SlMstCert> slMstCerts=this.sl241103000Logic.findList(baseParam);
        model.addAttribute("slMstCerts",slMstCerts);
        return "sl/SL2411010301";
    }

    @RequestMapping(value = "select",method = RequestMethod.POST)
    public String select(String certId,Model model){
        Long epId=(Long)request.getSession().getAttribute("jsp_epId2");
        /**保证同名证照不重复*/
        SlEpCert slEpCert2 = this.sl24110300301Logic.findSlEpCertById(epId,certId.toString());
        if(null!=slEpCert2){
            throw new BusinessException("该证照已经存在，注册完成后，您可以在编辑页面进行修改");
        }
        /**根据certId查询详细的证照信息*/
        slMstCertItems= this.sl24110300301Logic.findSLMstCertItemList(certId);
        if(null==slMstCertItems){
            throw  new BusinessException("没有获取该证照的详细信息");
        }

        model.addAttribute("slMstCertItems",slMstCertItems);
        return "sl/SL241101030101";
    }
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public void save(MultipartFile file,HttpServletRequest request,HttpServletResponse response,String[] certItemValue) throws IOException {
        Long epId=(Long)request.getSession().getAttribute("jsp_epId2");
        SlEpCert slEpCert = new SlEpCert();
        Long certId = slMstCertItems.get(0).getCertId();
        slEpCert.setCertId(certId);
        slEpCert.setEpId(epId);
        /**保证同名证照不重复*/
        SlEpCert slEpCert2 = this.sl24110300301Logic.findSlEpCertById(epId,certId.toString());
        if(null!=slEpCert2){
            throw new BusinessException("该证照已经存在，注册完成后，您可以在编辑页面进行修改");
        }
        /**根据certId查询证照名称*/
        SlMstCert slMstCert=this.sl24110300301Logic.findCertNameByCertId(certId);
        slEpCert.setCertName(slMstCert.getCertName());
        /**查询证照的最大certSeq+1*/
        Long maxCertSeq=this.sl24110300301Logic.findMaxCertSeq(epId);
        slEpCert.setCertSeq(maxCertSeq);
        /**保存卖家企业证照信息*/
        this.sl24110300301Logic.saveSlEpCert(slEpCert);
        List<SlEpCertItem> slEpCertItems=new ArrayList<SlEpCertItem>();
        for(int i =0;i<slMstCertItems.size();i++){
            SlEpCertItem slEpCertItem = new SlEpCertItem();
            slEpCertItem.setEpId(epId);
            slEpCertItem.setCertItemValue(certItemValue[i]);
            slEpCertItem.setCertId(certId);
            slEpCertItem.setCertItemName(slMstCertItems.get(i).getCertItemName());
            slEpCertItem.setCertSeq(maxCertSeq);
            slEpCertItem.setCertItemId(slMstCertItems.get(i).getCertItemId());
            slEpCertItems.add(slEpCertItem);
        }
        /**保存证照详细信息*/
        this.sl24110300301Logic.saveSlEpCertItem(slEpCertItems);
        if(file.getSize()!=0){
            String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epId + "/";
            String uploadFileName = BusinessConst.SLPath.CERT + certId;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(file, uploadFilePath, uploadFileName);
        }
        super.callBack(null,"保存成功",response);
    }
}
