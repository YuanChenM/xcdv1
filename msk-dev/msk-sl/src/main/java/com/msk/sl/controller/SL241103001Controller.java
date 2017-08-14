package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.file.FtpUtils;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL24110100Logic;
import com.msk.sl.logic.SL241103001Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 增加卖家账户
 * Created by fjm on 2016/1/26.
 */
@Controller
@RequestMapping("SL241103001")
public class SL241103001Controller extends BaseUploadController {
    @Autowired
    private SL241103001Logic sl241103001Logic;

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private SL24110100Logic sl24110100Logic;

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @Transactional
    public void insert(MultipartFile epthrfile,MultipartFile accountfile, MultipartFile licfile, MultipartFile taxfile, MultipartFile orgfile, MultipartFile balfile,SlEnterprise slEnterprise, SlSeller slSeller, SlAccount slAccount,String slConFlg,String[] slSecondaryClass,String provinceCode, String cityCode, String districtCode, String licType,String licTermUnliimited,HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        //获取前台提交的账号信息
        String accountWeb = slAccount.getSlAccount();

        //将account信息放进session里面
        request.getSession().setAttribute("jsp_slAccount", accountWeb);

        //判断这个账户是否已经存在，拿数据去后台查询数据库查询账号信息
        SlAccount EntitySql = this.sl241103001Logic.slAccountEntity(accountWeb);
        //账户已经有，返回告知用户换账户
        if (null != EntitySql) {
            throw new BusinessException("账户已经存在！请重新填写！");
        } else {
            //不存在账户，那么就插入即可
            //页面数据插入slAccount表
            if(null!=accountfile){
                if (accountfile.getSize() != 0) {
                    String suffix = super.getFileSuffix(accountfile);
                    slAccount.setAccountImg(request.getSession().getServletContext().getAttribute("fileSerUrl").toString() + "/"
                            + BusinessConst.SLPath.SLIMAGEPATH + "/" + BusinessConst.SLPath.BASE + "/" + slAccount.getSlAccount() + StringConst.DOT + suffix);
                } else {
                    slAccount.setAccountImg("");
                }
            }
            slAccount.setDelFlg("0");
            slAccount.setSlShowName(slEnterprise.getEpName());
            slAccount.setAuthStatus(2);
            slAccount.setCrtId(super.getLoginUser().getCrtId());
            this.sl241103001Logic.saveAccount(slAccount);

            //---------------------------------------------------------------------

            //处理seller和enterprise数据
            slSeller.setSlAccount(accountWeb);
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
            /**
             * 获取卖家code 先查询该区域是否已经存在卖家注册过，如果存在，取卖家分类码，卖家地区码+三位番号
             */
            String code = this.sl241103001Logic.findAccount(slSeller.getSlMainClass().toString(),cityCode,slSeller.getSlConFlg());
            /*String slCodes=StringUtil.toSafeString(commonLogic.maxId("sl_seller", "SL_CODE"));*/
            slSeller.setSlCodeDis(code);

            //生成卖家生产商编码
            //根据区划和国际查询生产商编码
            if("0".equals(slSeller.getSlMainClass())||"1".equals(slSeller.getSlMainClass())){
                slSeller.setSlCodeManufacture(this.sl241103001Logic.findSlCodeManufacture(cityCode,slSeller.getSlConFlg()));
            }
            //seller_4.获取ep_id
            Long epid =commonLogic.maxId("sl_enterprise", "EP_ID");
            slSeller.setEpId(epid);
            request.getSession().setAttribute("jsp_epId", epid);
            //二级经营类型
            slSeller.setSelfFlg("0");
            slSeller.setAgentFlg("0");
            slSeller.setOemFlg("0");
            /**
             * 遍历传过来的复选框内容，选择了1，为自产型。。。
             */
            BaseParam base=new BaseParam();
            base.setFilter("cityCode",cityCode);
            base.setFilter("slConFlg",slSeller.getSlConFlg());
            if(null!=slSecondaryClass){
                for(int i=0;i<slSecondaryClass.length;i++){
                    if(slSecondaryClass[i].equals("1")){
                        slSeller.setSelfFlg("1");
                        base.setFilter("selfFlg","1");
                        slSeller.setSlCodeSelf(this.sl241103001Logic.findSlCodeOther(base));
                        base.getFilterMap().remove("selfFlg");
                    }
                    if(slSecondaryClass[i].equals("2")){
                        slSeller.setAgentFlg("1");
                        base.setFilter("agentFlg","1");
                        slSeller.setSlCodeAgent(this.sl241103001Logic.findSlCodeOther(base));
                        base.getFilterMap().remove("agentFlg");
                    }
                    if(slSecondaryClass[i].equals("3")){
                        slSeller.setOemFlg("1");
                        base.setFilter("oemFlg","1");
                        slSeller.setSlCodeOem(this.sl241103001Logic.findSlCodeOther(base));
                        base.getFilterMap().remove("oemFlg");
                    }
                }
            }
            slSeller.setCrtId(super.getLoginUser().getCrtId());
            slSeller.setSlConFlg(slConFlg);
            slSeller.setDelFlg("0");
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
            //现在将sl_account,ep_id,areacode,slcode和页面传入的主类型main_class一共5个字段值插入数据库
            int num=this.sl241103001Logic.saveSeller(slSeller);
            if(num>0){
                SlSeller slSeller1=this.sl241103001Logic.findSlSeller(accountWeb);
                if(null!=slSeller1){
                    request.getSession().setAttribute("jsp_slCode", slSeller1.getSlCode());
                }
            }
            //---------------------------------------------------------------------
            //enterprise_1.将页面传入的数据插入数据库sl_enterprise表里
            //表的主键ep_id为自增长，现在废弃，使用上述epid代替进行设置
            slEnterprise.setEpId(epid);
            //下面品牌选择时这里要改。。。WTD
            slEnterprise.setLicType(licType);
            slEnterprise.setCrtId(super.getLoginUser().getCrtId());
            slEnterprise.setLicTermUnliimited(licTermUnliimited);
            slEnterprise.setDelFlg("0");
            this.sl241103001Logic.saveEp(slEnterprise);
            if (null!=accountfile && 0!=accountfile.getSize()) {
                //卖家头像上传
                String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" +BusinessConst.SLPath.BASE+ "/";
                String uploadFileName = slAccount.getSlAccount();
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(accountfile, uploadFilePath, uploadFileName);
            }
            if (null!=licfile && 0!=licfile.getSize()) {
                //图片上传到ftp里面
                String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epid + "/";
                String uploadFileName = BusinessConst.SLPath.EPBUS;
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(licfile, uploadFilePath, uploadFileName);
            }
            if (null!=epthrfile && 0!=epthrfile.getSize()) {
                String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epid + "/";
                String uploadFileName = BusinessConst.SLPath.EPTHR;
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(epthrfile, uploadFilePath, uploadFileName);
            }
            if (null!=taxfile && 0!=taxfile.getSize()) {
                String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + epid + "/";
                String uploadFileName = BusinessConst.SLPath.EPTAX;
                SLUploadFile slUploadFile = new SLUploadFile();
                slUploadFile.saveUploadFile(taxfile, uploadFilePath, uploadFileName);
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
}


