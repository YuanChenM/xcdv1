package com.msk.by.controller.comm;

import com.msk.by.bean.IBY121205RsParam;
import com.msk.by.bean.IBY121206RsParam;
import com.msk.by.bean.IBY121207RsParam;
import com.msk.by.controller.BY121106Controller;
import com.msk.by.logic.BY121304Logic;
import com.msk.by.logic.IBY121205Logic;
import com.msk.by.logic.IBY121206Logic;
import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.*;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 买家证照信息画面
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("by/baseBuyerLicInfo")
public class BYBaseBuyerLicController extends BaseUploadController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BYBaseBuyerLicController.class);
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private BY121304Logic by121304Logic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init/{buyerId}",
        method = RequestMethod.POST)
    public String init(@PathVariable("buyerId") String buyerId,Model model) {
        logger.debug("买家证照信息画面");
        model.addAttribute("buyerId",buyerId);
        //买家证照信息
        IBY121205RsParam licenceInfo = by121304Logic.buyerLicenceFind(buyerId);
        model.addAttribute("licenceInfo",licenceInfo);
        //买家证照图片信息
        IBY121206RsParam licencePic = by121304Logic.buyerLicencePicFind(buyerId);
        model.addAttribute("licencePic",licencePic);
        //买家营业执照类型
        List<CommConstant> licTypeList = commonLogic.findConstantList("LicType");
        model.addAttribute("licTypeList",licTypeList);
        //买家法人代表证件类型
        List<CommConstant> legalLicTypeList = commonLogic.findConstantList("LegalLicType");
        model.addAttribute("legalLicTypeList",legalLicTypeList);

        return "by/comm/BASE_BUYER_LIC_INFO";
    }

    /**
     * 买家证照信息更新
     * @param busLicPic
     * @param orgCertificatePic
     * @param taxCertificatePic
     * @param foodCertificatePic
     * @param legalCertificatePic
     * @param basicLicInfo
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "update",
            method = RequestMethod.POST)
    public void basicLicInfoModify(MultipartFile busLicPic,MultipartFile orgCertificatePic,MultipartFile taxCertificatePic,MultipartFile foodCertificatePic,MultipartFile legalCertificatePic,ByBuyerLicence basicLicInfo,HttpServletResponse response)throws IOException{
        logger.debug("买家基本信息更新");
        //买家ID
        String buyerId = basicLicInfo.getBuyerId();
        //证照图片对象
        IBY121206RsParam licPicture = new IBY121206RsParam();
        licPicture.setBuyerId(buyerId);
        //买家图片上传共通对象
        BY121106Controller by121106Controller = new BY121106Controller();
        //图片上传临时文件路径
        String http = "http://";
        String url = ConfigManager.getFtpIp();
        String uploadTempFilePath = ConfigManager.getFtpImageRootPath() + BusinessConst.BYPath.TEMPIMAGEPATH + "/" + buyerId +"/";
        //营业执照图片上传
        if(busLicPic.getSize() != 0){
            String busLicPicName = this.getFileName(busLicPic);
            by121106Controller.picFileUpload(buyerId,busLicPic);
            licPicture.setPicLicensePath(http + url + uploadTempFilePath + busLicPicName);
        }
        //税务登记证图片上传
        if(orgCertificatePic.getSize() != 0){
            String orgCertificatePicName = this.getFileName(orgCertificatePic);
            by121106Controller.picFileUpload(buyerId,orgCertificatePic);
            licPicture.setPicOrgStructurePath(http + url + uploadTempFilePath + orgCertificatePicName);
        }
        //组织机构代码证图片上传
        if(taxCertificatePic.getSize() != 0){
            String taxCertificatePicName = this.getFileName(taxCertificatePic);
            by121106Controller.picFileUpload(buyerId,taxCertificatePic);
            licPicture.setPicTaxRegistrationPath(http + url + uploadTempFilePath + taxCertificatePicName);
        }
        //食品流通许可证图片上传
        if(foodCertificatePic.getSize() != 0){
            String foodCertificatePicName = this.getFileName(foodCertificatePic);
            by121106Controller.picFileUpload(buyerId,foodCertificatePic);
            licPicture.setPicFoodCirculationPath(http + url + uploadTempFilePath + foodCertificatePicName);
        }
        //法定代表人证件图片上传
        if(legalCertificatePic.getSize() != 0){
            String legalCertificatePicName = this.getFileName(legalCertificatePic);
            by121106Controller.picFileUpload(buyerId,legalCertificatePic);
            licPicture.setPicCertPath(http + url + uploadTempFilePath + legalCertificatePicName);
        }
        //买家证照信息更新
        int updateCount = by121304Logic.buyerLicenceModify(basicLicInfo);
        //买家证照图片更新
        int updatePicCount = by121304Logic.buyerLicencePicModify(licPicture);

        super.callBack(null, "保存成功", response);
    }
}
