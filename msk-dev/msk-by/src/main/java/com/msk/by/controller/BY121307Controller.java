package com.msk.by.controller;

import com.msk.by.bean.BY121307Bean;
import com.msk.by.bean.IBY121202RsParam;
import com.msk.by.bean.IBY121206RsParam;
import com.msk.by.bean.IBY121207RsParam;
import com.msk.by.logic.*;
import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.*;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.md.utils.DistrictAreaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 新增买家
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("BY121307")
public class BY121307Controller extends BaseUploadController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BY121307Controller.class);

    @Autowired
    private BY121304Logic by121304Logic;
    @Autowired
    private IBY121202Logic iby121202Logic;
    @Autowired
    private IBY121203Logic iby121203Logic;
    @Autowired
    private IBY121204Logic iby121204Logic;
    @Autowired
    private IBY121208Logic iby121208Logic;
    @Autowired
    private IBY121209Logic iby121209Logic;
    @Autowired
    private CommonLogic commonLogic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init/{buyerId}",
            method = RequestMethod.POST)
    public String init(@PathVariable("buyerId") String buyerId, Model model) {
        logger.debug("买家新增画面");
        model.addAttribute("buyerId", buyerId);
        //查询所有物流区
        List<MdLogisticsArea> logisticsAreaList = DistrictAreaUtils.getLogisticsAreaList();
        //买家类型
        List<CommConstant> buyerTypeList = by121304Logic.findBuyerTypes("BuyerType");
        // 收货时间
        List<CommConstant> recTimeCommList = commonLogic.findConstantList("ReceivePeriodType");
        // 销售对象
        List<CommConstant> salestargetCommList = commonLogic.findConstantList("SalesTarget");
        // 销售产品
        List<PdClasses> pdClaCommList = by121304Logic.findPdClassesList();
        model.addAttribute("recTimeCommList", recTimeCommList);
        model.addAttribute("salestargetCommList", salestargetCommList);
        model.addAttribute("pdClaCommList", pdClaCommList);
        model.addAttribute("logisticsAreaList", logisticsAreaList);
        model.addAttribute("buyerTypeList", buyerTypeList);
        return "by/BY121307";
    }

    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search/{buyerId}",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<IBY121207RsParam> search(@PathVariable("buyerId") String buyerId,
                                        BasePageParam param) {
        logger.debug("买家员工信息查询");
        param.getFilterMap().put("buyerId", "");
        DbUtils.buildLikeCondition(param, "employeeName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "employeeTel", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "employeeQq", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(param, "employeeWechat", DbUtils.LikeMode.FRONT);
        PageResult<IBY121207RsParam> result = by121304Logic.findPage(param, IBY121207RsParam.class);
        return result;
    }

    /**
     * 新增买家信息保存
     *
     * @param busLicPic
     * @param orgCertificatePic
     * @param taxCertificatePic
     * @param foodCertificatePic
     * @param legalCertificatePic
     * @param by121307Bean
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "save/{buyerId}", method = RequestMethod.POST)
    public void basicLicInfoModify(@PathVariable("buyerId") String buyerId, MultipartFile busLicPic, MultipartFile orgCertificatePic, MultipartFile taxCertificatePic, MultipartFile foodCertificatePic, MultipartFile legalCertificatePic, BY121307Bean by121307Bean, HttpServletResponse response) throws IOException {
        logger.debug("买家基本信息更新");
        IBY121202RsParam buyerBasicInfo = by121307Bean.getBuyerBasicInfo();
        //更新买家基本信息
        byBasicInfoSave(buyerBasicInfo, buyerId);
        logger.debug("买家收货信息更新");
        // 更新买家收货地址
        List<ByBuyerRecAddr> recAddrList = by121307Bean.getBuyerRecAddrList();
        byBuyerRecAddrSave(recAddrList, buyerId);
        // 更新买家收货时间
        String[] receiveTime = by121307Bean.getBuyerRecTime();
        byBuyerRecTimeSave(receiveTime, buyerId);
        // 更新买家销售对象
        String[] salestarget = by121307Bean.getBuyerSalestarget();
        byBuyerSalesTargetSave(salestarget, buyerId);
        // 更新买家销售产品
        String[] pdCla = by121307Bean.getBuyerPdCla();
        byBuyerPdClaSave(pdCla, buyerId);
        logger.debug("买家证照信息更新");
        //更新买家证照信息
        ByBuyerLicence buyerLicence = by121307Bean.getBuyerLicence();
        byBuyerLicenceSave(buyerLicence, buyerId, busLicPic, orgCertificatePic, taxCertificatePic, foodCertificatePic, legalCertificatePic);
        super.callBack("BY121307CallbackFun", "保存成功", response);
    }

    /**
     * 买家基本信息保存
     *
     * @param buyerBasicInfo
     * @param buyerId
     */
    public void byBasicInfoSave(IBY121202RsParam buyerBasicInfo, String buyerId) {
        if (null != buyerBasicInfo) {
            buyerBasicInfo.setBuyerId(buyerId);
            buyerBasicInfo.setRegisterSource("1");
            List<CommConstant> buyerTypeList = commonLogic.findConstantList("BuyerType");
            for (int i = 0; i < buyerTypeList.size(); i++) {
                if (buyerBasicInfo.getSuperiorType().equals(buyerTypeList.get(i).getConstantValue())) {
                    buyerBasicInfo.setSuperiorName(buyerTypeList.get(i).getConstantName());
                    break;
                }
            }
            //如果不是分销买家且不是菜场买家
            if (!BusinessConst.BuyerType.Market.equals(buyerBasicInfo.getSuperiorType()) && !BusinessConst.BuyerType.Distribution.equals(buyerBasicInfo.getSuperiorType())) {
                buyerBasicInfo.setSuperiorId("");
                buyerBasicInfo.setSuperiorQua("");
            }

            if (StringUtil.isNullOrEmpty(buyerBasicInfo.getIsMarketFlg()) || !buyerBasicInfo.getIsMarketFlg().equals("1")) {
                buyerBasicInfo.setIsMarketFlg("0");
            }
            if(buyerBasicInfo.getSuperiorSubName().equals("请选择")){
                buyerBasicInfo.setSuperiorSubName("无");
            }
            int updateCount = iby121202Logic.buyerInfoModify(buyerBasicInfo);
        }
    }

    /**
     * 买家收货地址保存
     *
     * @param recAddrList
     * @param buyerId
     */
    public void byBuyerRecAddrSave(List<ByBuyerRecAddr> recAddrList, String buyerId) {
        if (!CollectionUtils.isEmpty(recAddrList)) {
            for (int i = 0; i < recAddrList.size(); i++) {
                recAddrList.get(i).setBuyerId(buyerId);
            }
            int updateRecAddrCount = iby121208Logic.buyerReceiveAddrModify(recAddrList, new ArrayList<ByBuyerRecAddr>());
        }
    }

    /**
     * 买家收货时间保存
     *
     * @param receiveTime
     * @param buyerId
     */
    public void byBuyerRecTimeSave(String[] receiveTime, String buyerId) {
        List<ByBuyerRecTime> recTimeList = new ArrayList<>();
        List<CommConstant> recTimeCommList = commonLogic.findConstantList("ReceivePeriodType");
        if (receiveTime != null) {
            for (int i = 0; i < receiveTime.length; i++) {
                for (int j = 0; j < recTimeCommList.size(); j++) {
                    if (receiveTime[i].equals(recTimeCommList.get(j).getConstantValue())) {
                        ByBuyerRecTime byBuyerRecTime = new ByBuyerRecTime();
                        byBuyerRecTime.setBuyerId(buyerId);
                        byBuyerRecTime.setRecPerType(receiveTime[i]);
                        byBuyerRecTime.setTimeDescribe(recTimeCommList.get(j).getConstantName());
                        recTimeList.add(byBuyerRecTime);
                        break;
                    }
                }
            }
            int updateRecTimeCount = iby121209Logic.buyerReceiveTimeModify(recTimeList);
        }
    }

    /**
     * 买家销售对象保存
     *
     * @param salestarget
     * @param buyerId
     */
    public void byBuyerSalesTargetSave(String[] salestarget, String buyerId) {
        List<ByBuyerSalestarget> salestargetList = new ArrayList<>();
        List<CommConstant> salestargetCommList = commonLogic.findConstantList("SalesTarget");
        if (salestarget != null) {
            for (int i = 0; i < salestarget.length; i++) {
                for (int j = 0; j < salestargetCommList.size(); j++) {
                    if (salestarget[i].equals(salestargetCommList.get(j).getConstantValue())) {
                        ByBuyerSalestarget byBuyerSalestarget = new ByBuyerSalestarget();
                        byBuyerSalestarget.setBuyerId(buyerId);
                        byBuyerSalestarget.setSalesTargetType(salestarget[i]);
                        byBuyerSalestarget.setSalesTargetName(salestargetCommList.get(j).getConstantName());
                        salestargetList.add(byBuyerSalestarget);
                        break;
                    }
                }
            }
            int salesTargetCount = iby121204Logic.buyerSalesTargetModify(salestargetList);
        }
    }

    /**
     * 买家销售产品保存
     *
     * @param pdCla
     * @param buyerId
     */
    public void byBuyerPdClaSave(String[] pdCla, String buyerId) {
        List<ByBuyerPdCla> pdClaList = new ArrayList<>();
        List<PdClasses> pdClaCommList = by121304Logic.findPdClassesList();
        if (pdCla != null) {
            for (int i = 0; i < pdCla.length; i++) {
                for (int j = 0; j < pdClaCommList.size(); j++) {
                    if (pdCla[i].equals(pdClaCommList.get(j).getClassesCode())) {
                        ByBuyerPdCla buyerPdCla = new ByBuyerPdCla();
                        buyerPdCla.setBuyerId(buyerId);
                        buyerPdCla.setClassCode(pdCla[i]);
                        buyerPdCla.setClassName(pdClaCommList.get(j).getClassesName());
                        pdClaList.add(buyerPdCla);
                        break;
                    }
                }
            }
            iby121203Logic.buyerPdClassificationModify(pdClaList);
        }
    }

    /**
     * 买家证照信息保存
     *
     * @param buyerLicence
     * @param buyerId
     * @param busLicPic
     * @param orgCertificatePic
     * @param taxCertificatePic
     * @param foodCertificatePic
     * @param legalCertificatePic
     */
    public void byBuyerLicenceSave(ByBuyerLicence buyerLicence, String buyerId, MultipartFile busLicPic, MultipartFile orgCertificatePic, MultipartFile taxCertificatePic, MultipartFile foodCertificatePic, MultipartFile legalCertificatePic) throws IOException {
        if (buyerLicence != null) {
            //买家证照信息更新
            buyerLicence.setBuyerId(buyerId);
            int updateCount = by121304Logic.buyerLicenceModify(buyerLicence);
        }
        //证照图片对象
        IBY121206RsParam licPicture = new IBY121206RsParam();
        //买家图片上传共通对象
        BY121106Controller by121106Controller = new BY121106Controller();
        //图片上传临时文件路径
        String http = "http://";
        String url = ConfigManager.getFtpIp();
        String uploadTempFilePath = ConfigManager.getFtpImageRootPath() + BusinessConst.BYPath.TEMPIMAGEPATH + "/" + buyerId + "/";
        //营业执照图片上传
        if (busLicPic.getSize() != 0) {
            String busLicPicName = this.getFileName(busLicPic);
            by121106Controller.picFileUpload(buyerId, busLicPic);
            licPicture.setBuyerId(buyerId);
            licPicture.setPicLicensePath(http + url + uploadTempFilePath + busLicPicName);
        }
        //税务登记证图片上传
        if (orgCertificatePic.getSize() != 0) {
            String orgCertificatePicName = this.getFileName(orgCertificatePic);
            by121106Controller.picFileUpload(buyerId, orgCertificatePic);
            licPicture.setBuyerId(buyerId);
            licPicture.setPicOrgStructurePath(http + url + uploadTempFilePath + orgCertificatePicName);
        }
        //组织机构代码证图片上传
        if (taxCertificatePic.getSize() != 0) {
            String taxCertificatePicName = this.getFileName(taxCertificatePic);
            by121106Controller.picFileUpload(buyerId, taxCertificatePic);
            licPicture.setBuyerId(buyerId);
            licPicture.setPicTaxRegistrationPath(http + url + uploadTempFilePath + taxCertificatePicName);
        }
        //食品流通许可证图片上传
        if (foodCertificatePic.getSize() != 0) {
            String foodCertificatePicName = this.getFileName(foodCertificatePic);
            by121106Controller.picFileUpload(buyerId, foodCertificatePic);
            licPicture.setBuyerId(buyerId);
            licPicture.setPicFoodCirculationPath(http + url + uploadTempFilePath + foodCertificatePicName);
        }
        //法定代表人证件图片上传
        if (legalCertificatePic.getSize() != 0) {
            String legalCertificatePicName = this.getFileName(legalCertificatePic);
            by121106Controller.picFileUpload(buyerId, legalCertificatePic);
            licPicture.setBuyerId(buyerId);
            licPicture.setPicCertPath(http + url + uploadTempFilePath + legalCertificatePicName);
        }
        //买家证照图片更新
        if (!StringUtil.isNullOrEmpty(licPicture.getBuyerId())) {
            int updatePicCount = by121304Logic.buyerLicencePicModify(licPicture);
        }
    }
}

