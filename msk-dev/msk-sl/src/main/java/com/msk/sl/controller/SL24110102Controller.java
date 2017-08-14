package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.bean.SlEpAgentAuthBean;
import com.msk.sl.logic.SL24110102Logic;
import com.msk.sl.logic.SL241103001Logic;
import com.msk.sl.logic.SL241103010Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by fjm on 2016/1/28.
 */
@Controller
@RequestMapping("SL24110102")
public class SL24110102Controller extends BaseUploadController {

    @Autowired
    private SL24110102Logic sL24110102Logic;
    @Autowired
    private SL241103001Logic sl241103001Logic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private SL241103010Logic sl241103010Logic;

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(MultipartFile epthrfile,MultipartFile licfile, MultipartFile taxfile, MultipartFile orgfile, MultipartFile balfile, SlEnterprise slEnterprise, SlSeller slSeller, String slConFlg, String[] slSecondaryClass, String provinceCode, String cityCode, String districtCode, String licType, String licTermUnliimited, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (null == provinceCode || "".equals(provinceCode)) {
            throw new BusinessException("请选择省（含省、直辖市）");
        }
        MdProvince mdProvince = this.sl241103001Logic.findProvince(provinceCode);
        slSeller.setProvinceCode(provinceCode);
        String areaCode = this.sl241103001Logic.findAreaCode(mdProvince.getAreaId());
        slSeller.setAreaCode(areaCode);
        if (null == cityCode || "".equals(cityCode)) {
            throw new BusinessException("请选择地区（含地级市）");
        }
        MdCity mdCity = this.sl241103001Logic.findCity(cityCode);
        slSeller.setCityCode(cityCode);
        String lgcsAreaCode = this.sl241103001Logic.findLgcsAreaCode(mdCity.getLgcsAreaId());
        slSeller.setLgcsAreaCode(lgcsAreaCode);
        if (null == districtCode || "".equals(districtCode)) {
            throw new BusinessException("请选择区（含县级市、县、区）");
        }
        slSeller.setDistrictCode(districtCode);
        slSeller.setSqaStatus(2);
        request.getSession().setAttribute("jsp_slCode", slSeller.getSlCode());
        //seller_4.获取ep_id
        Long epid =slEnterprise.getEpId();
        request.getSession().setAttribute("jsp_epId", epid);
        //二级经营类型
        slSeller.setSelfFlg("0");
        slSeller.setAgentFlg("0");
        slSeller.setOemFlg("0");
        /**
         * 遍历传过来的复选框内容，选择了1，为自产型。。。
         */

        if(null!=slSecondaryClass) {
            for (int i = 0; i < slSecondaryClass.length; i++) {
                if (slSecondaryClass[i].equals("1")) {
                    slSeller.setSelfFlg("1");
                }
                if (slSecondaryClass[i].equals("2")) {
                    slSeller.setAgentFlg("1");
                }
                if (slSecondaryClass[i].equals("3")) {
                    slSeller.setOemFlg("1");
                }
            }
        }
        slSeller.setCrtId(super.getLoginUser().getCrtId());
        slSeller.setSlConFlg(slConFlg);
        /**查询该卖家编码下的slseller信息*/
        SlSellerHis slSellerHis=this.sL24110102Logic.findSlSellerBySlCode(slSeller.getSlCode());
        if(null!=slSellerHis){
            if(!slSeller.getCityCode().equals(slSellerHis.getCityCode())){
                Long hisId=this.commonLogic.maxId("SL_SELLER_HIS","HIS_ID");
                slSellerHis.setHisId(hisId);
                this.sL24110102Logic.saveHis(slSellerHis);
                BaseParam base = new BaseParam();
                base.setFilter("cityCode",cityCode);
                base.setFilter("slMainClass",StringUtil.toSafeString(slSeller.getSlMainClass()));
                base.setFilter("slConFlg",slConFlg);
                SlSeller seller=sL24110102Logic.findOne("queryMax", base);
                if(null!=seller){
                    slSeller.setSlCodeDis(seller.getSlCodeDis());
                }else{
                    String code = this.sl241103001Logic.findAccount(slSeller.getSlMainClass().toString(),cityCode,slSeller.getSlConFlg());
                    slSeller.setSlCodeDis(code);
                }
            }
            if(slSeller.getSlMainClass()!=slSellerHis.getSlMainClass()){
                BaseParam param=new BaseParam();
                param.setFilter("slCode",slSeller.getSlCode());
                param.setFilter("delFlg","0");
                List<SlEpAgentAuthBean> slEpAgentAuthBeanList=null;
                if(NumberConst.IntDef.INT_TWO==slSellerHis.getSlMainClass()){
                    slEpAgentAuthBeanList=sl241103010Logic.queryAgentData(param);
                }else if(NumberConst.IntDef.INT_THREE==slSellerHis.getSlMainClass()){
                    slEpAgentAuthBeanList=sl241103010Logic.queryOemData(param);
                }
                if(!CollectionUtils.isEmpty(slEpAgentAuthBeanList)){
                    throw new BusinessException("请先删除对应生产商，再修改类型");
                }

            }
            /**更新seller到数据库*/
        }
        MdArea mdArea=sl241103001Logic.areaSelect(provinceCode);
        if(null!=mdArea){
            slSeller.setAreaCode(mdArea.getAreaCode());
        }
        if(null!=mdCity){
            MdLogisticsArea mdLogisticsArea=sl241103001Logic.logisticsAreaSelect(StringUtil.toSafeString(mdCity.getLgcsAreaId()));
            if(null!=mdLogisticsArea){
                slSeller.setLgcsAreaCode(mdLogisticsArea.getLgcsAreaCode());
            }
        }
        this.sL24110102Logic.updateSl(slSeller);
        /**更新slEnterprise到数据库*/
        slEnterprise.setLicType(licType);
        slEnterprise.setCrtId(super.getLoginUser().getCrtId());
        slEnterprise.setLicTermUnliimited(licTermUnliimited);
        this.sL24110102Logic.updateEp(slEnterprise);
        if (null!=licfile && 0!=licfile.getSize()) {
            //图片上传到ftp里面
            String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epid + "/";
            String uploadFileName = BusinessConst.SLPath.EPBUS;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(licfile, uploadFilePath, uploadFileName);
        }
        if (null!=taxfile && 0!=taxfile.getSize()) {
            String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epid + "/";
            String uploadFileName = BusinessConst.SLPath.EPTAX;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(taxfile, uploadFilePath, uploadFileName);
        }
        if (null!=epthrfile && 0!=epthrfile.getSize()) {
            String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epid + "/";
            String uploadFileName = BusinessConst.SLPath.EPTHR;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(epthrfile, uploadFilePath, uploadFileName);
        }
        if (null!=orgfile && 0!=orgfile.getSize()) {
            String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epid + "/";
            String uploadFileName = BusinessConst.SLPath.EPORG;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(orgfile, uploadFilePath, uploadFileName);
        }
        if (null!=balfile && 0!=balfile.getSize()) {
            String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epid + "/";
            String uploadFileName = BusinessConst.SLPath.EPBAN;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(balfile, uploadFilePath, uploadFileName);
        }
        super.callBack(null, "保存成功", response);
    }
}