package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SlAccount;
import com.msk.core.entity.*;
import com.msk.core.entity.SlEpAgentAuth;
import com.msk.core.entity.SlEpHonor;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.*;
import com.msk.core.entity.SlEpOemAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 编辑all
 */
@Service
public class ISL231180RsLogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231180RsLogic.class);

    /**
     * SQL Id
     */
    interface SqlId {
        static final String SQL_ID_DELETE_SLACCOUNT = "deleteSlAccount";
        static final String SQL_ID_DELETE_SLPDCLASSESBYSLCODE = "deleteSlPdClassesBySlcode";
        static final String SQL_ID_UPDATE_SLSELLER = "updateSlSeller";
        static final String SQL_ID_UPDATE_SLEPBRAND = "updateSlEpBrand";
        static final String SQL_ID_UPDATE_SLEPBRANDHONOR = "updateSlEpBrandHonor";
        static final String SQL_ID_UPDATE_SLEPCERTITEM = "updateSlEpCertItem";
        static final String SQL_ID_UPDATE_SLACCOUNT = "updateSlAccount";
        static final String SQL_ID_UPDATE_SLEPCAP = "updateSlEpCap";
        static final String SQL_ID_UPDATE_SLPDBRAND = "updateSlPdBrand";
        static final String SQL_ID_UPDATE_SLSELFPDBRAND = "updateSlSelfPdBrand";
        static final String SQL_ID_UPDATE_SLEPAGENTAUTH = "updateSlEpAgentAuth";
        static final String SQL_ID_UPDATE_SLEPOEMAUTH = "updateSlEpOemAuth";
        static final String SQL_ID_FIND_SLACCOUNTIFEXIST = "findSlAccountIfExist";
        static final String SQL_ID_FIND_SLENTERPRISE = "findSlEnterprise";
        static final String SQL_ID_FIND_SLPDCLASSES = "findSlPdClasses";
        static final String SQL_ID_UPDATE_SLPDCLASSES = "updateSlPdClasses";
        static final String SQL_ID_SAVE_SLPDCLASSES = "saveSlPdClasses";
        static final String SQL_ID_QUERY_SLTEL = "querySlTel";
        static final String SQL_ID_SAVE_SLEPWORKSHOP = "saveSlEpWorkshop";
        static final String SQL_ID_SAVE_SLEPAGENTAUTH = "saveSlEpAgentAuth";
        static final String SQL_ID_SAVE_SLEPOEMAUTH = "saveSlEpOemAuth";
        static final String SQL_ID_SAVE_SLEPMANAGER = "saveSlEpManager";
        static final String SQL_ID_SAVE_SLECTEAM = "saveSlEcTeam";
        static final String SQL_ID_SAVE_SL_EPDD = "saveSlEpDd";
        static final String SQL_ID_UPDATE_SL_EPDD = "updateSlEpDd";
        static final String SQL_ID_FIND_SLPDBRANDIFEXIST = "findSlPdBrandIfExist";
        static final String SQL_ID_FIND_SLSELLERLIST = "findSlSellerList";
        static final String SQL_ID_FIND_SLSELLEREPID = "findSlSellerEpId";
        static final String SQL_ID_FIND_SLCODE = "findSlCode";
        static final String SQL_ID_FIND_CERTID = "findCertId";
        static final String SQL_ID_FIND_SLEPBRAND = "findSlEpBrandByEpIdAndBrandId";
        static final String SQL_ID_FIND_UPDATESLSELLER = "findUpdateSlseller";
        static final String SQL_ID_FIND_QUERYONESLCODE = "queryOneSlCode";
        static final String SQL_ID_FIND_QUERYLICNODATA = "queryLicNoData";
        static final String SQL_ID_FIND_QUERYSLPDCLASS = "querySlPdClass";
        static final String SQL_ID_DELETE_SLPDCLASS = "deleteSlPdClass";
        static final String SQL_ID_DELETE_SLEPCERT = "deleteSlEpCert";
        static final String SQL_ID_DELETE_SLEPHONOR = "deleteSlEpHonor";
        static final String SQL_ID_DELETE_SLEPBRAND = "deleteSlEpBrand";
        static final String SQL_ID_DELETE_SLEPBRANDHONOR = "deleteSlEpBrandHonor";
        static final String SQL_ID_DELETE_SLPDBRAND = "deleteSlPdBrand";
        static final String SQL_ID_DELETE_WORKSHOPID = "deleteWorkShopId";
        static final String SQL_ID_DELETE_SLEPAGENTAUTH = "deleteSLEpAgentAuth";
        static final String SQL_ID_DELETE_SLEPOEMAUTH = "deleteSLEpOemAuth";
        static final String SQL_ID_DELETE_SLEPMANAGER = "deleteSLEpManager";
        static final String SQL_ID_DELETE_SLECTEAM = "deleteSLEcTeam";
        static final String SQL_ID_DELETE_SLEPDD = "deleteSlEpDd";
        static final String SQL_ID_QUERY_SLEPCERT = "querySlEpCert";
        static final String SQL_ID_QUERY_SLPDBREED = "querySlPdBreed";
        static final String SQL_ID_QUERY_SLEPAGENTAUTH = "querySlEpAgentAuth";
        static final String SQL_ID_QUERY_SLEPOEMAUTH = "querySlEpOemAuth";
        static final String SQL_ID_FIND_MANUFACTUREACCOUNT = "findManufactureAccount";
    }

    /**
     * @see BaseLogic#setBaseDao(BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private SL241103001Logic sL241103001Logic;
    @Autowired
    private SL24110300301Logic sL24110300301Logic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private SL24110300401Logic sL24110300401Logic;
    @Autowired
    private ISL231146RsLogic iSL231146RsLogic;
    @Autowired
    private SL24110102Logic sl24110102Logic;
    @Autowired
    private SL2411010401Logic sl2411010401Logic;
    @Autowired
    private ISL231154RsLogic isl231154RsLogic;
    @Autowired
    private SL2411010501Logic sl2411010501Logic;
    @Autowired
    private SL24110300402Logic sl24110300402Logic;
    @Autowired
    private ISL231150RsLogic isl231150RsLogic;
    @Autowired
    private SL24110108Logic sl24110108Logic;
    @Autowired
    private SL24110109Logic sl24110109Logic;
    @Autowired
    private SL24110102Logic sL24110102Logic;
    @Autowired
    private SL2411030071Logic sL2411030071Logic;
    /**
     * 逻辑删除操作
     *
     * @param isl231180RsParam 录入参数信息===================================================================================================
     */
    @Transactional
    public void deleteSlAccount(ISL231180RsParam isl231180RsParam) {
        SlAccount slAccount = isl231180RsParam.getSlAccount();
        if (null != slAccount) {
            slAccount.setUpdId(isl231180RsParam.getLoginId());
            slAccount.setVer(isl231180RsParam.getVer() + 1);
            slAccount.setDelFlg("1");
            super.remove(SqlId.SQL_ID_DELETE_SLACCOUNT, slAccount);
        } else {
            throw new BusinessException("不存在的账号信息");
        }
    }

    /**
     * 卖家新增.更新
     *
     * @param isl231180RsParam 接口传入参数
     */
    @Transactional
    public ISL231180RsResult saveSlData(ISL231180RsParam isl231180RsParam) {
        ISL231180RsResult isl231180RsResult = new ISL231180RsResult();
        //判断全体新增
        String id = isl231180RsParam.getLoginId();
        String manufactureAccountData="";
        if (null != isl231180RsParam.getInsertFlag()) {
            if (isl231180RsParam.getInsertFlag() == NumberConst.IntDef.INT_ZERO) {
                //卖家ID
                String slCode = null;
                //企业ID
                Long epId = null;
                //判断生产商标示
                if(null!=isl231180RsParam.getManufactureFlag() && NumberConst.IntDef.INT_ONE==isl231180RsParam.getManufactureFlag()){

                    /**保存卖家账号信息=======================================================================================================*/
                    SlAccount slAccount = isl231180RsParam.getSlAccount();
                    SlAccount slAccountTwo=super.findOne(SqlId.SQL_ID_FIND_MANUFACTUREACCOUNT, new BaseParam());
                    Integer manufactureAccount=NumberConst.IntDef.INT_ZERO;
                    DecimalFormat df = new DecimalFormat("0000000");
                    if(null!=slAccountTwo){
                        manufactureAccount=Integer.parseInt(slAccountTwo.getSlAccount())+1;
                    }else{
                        manufactureAccount=NumberConst.IntDef.INT_ONE;
                    }
                    manufactureAccountData=df.format(manufactureAccount);
                    slAccount.setSlAccount(manufactureAccountData);
                    slAccount.setAccountPsd("123456");
                    slAccount.setSlTel("00000000000");
                    slAccount.setAuthStatus(NumberConst.IntDef.INT_ONE);
                    slAccount.setCrtId(id);
                    slAccount.setDelFlg("0");
                    slAccount.setVer(NumberConst.IntDef.INT_ONE);
                    this.sL241103001Logic.saveAccount(slAccount);
                }else{
                    /**保存卖家账号信息=======================================================================================================*/
                    SlAccount slAccount = isl231180RsParam.getSlAccount();
                    if (null != slAccount) {
                        //1.如果用戶帐号和密码不为空，查询账号是否存在
                        if (!StringUtil.isNullOrEmpty(slAccount.getSlAccount()) && !StringUtil.isNullOrEmpty(slAccount.getAccountPsd())) {
                            if (!StringUtil.isNullOrEmpty(slAccount.getSlTel())) {
                                BaseParam params = new BaseParam();
                                params.setFilter("slTel", slAccount.getSlTel());
                                int num = super.getCount(SqlId.SQL_ID_QUERY_SLTEL, params);
                                if (0 < num) {
                                    throw new BusinessException("手机账户已注册!");
                                }
                            }
                            BaseParam base = new BaseParam();
                            base.setFilter("slAccount", slAccount.getSlAccount());
                            SlAccount slAccount1 = super.findOne(SqlId.SQL_ID_FIND_SLACCOUNTIFEXIST, base);
                            //1.1如果账号存在，则更新
                            if (null == slAccount1) {
                                //1.1如果账号不存在，则新增
                                slAccount.setCrtId(id);
                                slAccount.setDelFlg("0");
                                slAccount.setVer(NumberConst.IntDef.INT_ONE);
                                this.sL241103001Logic.saveAccount(slAccount);
                            } else {
                                throw new BusinessException("卖家账号已存在!");
                            }

                        } else {
                            throw new BusinessException("卖家账号和密码不能为空");
                        }
                    }
                }

                /**================================================保存卖家基本信息========================================================*/
                SlSeller slSeller = isl231180RsParam.getSlSeller();
                String mainClass="";
                if (null != slSeller) {
                    mainClass=StringUtil.toSafeString(slSeller.getSlMainClass());
                    /**增加前先查询下这个卖家账号是否已经注册了，如果已经注册了，报错提示，如果没有注册过，就新增*/
                    //判断生产商标示
                    BaseParam base = new BaseParam();
                    if(null!=isl231180RsParam.getManufactureFlag()&& NumberConst.IntDef.INT_ONE==isl231180RsParam.getManufactureFlag()){
                        base.setFilter("slAccount", manufactureAccountData);
                        slSeller.setSlAccount(manufactureAccountData);
                    }else{
                        base.setFilter("slAccount", slSeller.getSlAccount());
                    }

                    SlSeller slSellerList = super.findOne(SqlId.SQL_ID_FIND_SLSELLERLIST, base);
                    if (null!=slSellerList) {
                        throw new BusinessException("该账号卖家基本信息已经存在，无法重复录入");
                    }
                    /**查询slcode,第一次新建的时候slcode不知道是多少，采用拼接方式 provinceCode+cityCode+districtCode+后八位番号*/
                    String slCodeDis = this.sL241103001Logic.findAccount(slSeller.getSlMainClass().toString(), slSeller.getCityCode(), slSeller.getSlConFlg());
                    //生成卖家生产商编码
                    //根据区划和国际查询生产商编码
                    slSeller.setSlCodeManufacture(this.sL241103001Logic.findSlCodeManufacture(slSeller.getCityCode(), slSeller.getSlConFlg()));
                    //二级经营类型
                    BaseParam baseParam = new BaseParam();
                    baseParam.setFilter("cityCode", slSeller.getCityCode());
                    baseParam.setFilter("slConFlg", slSeller.getSlConFlg());
                    //获取大区编码
                    MdProvince mdProvince = this.sL241103001Logic.findProvince(slSeller.getProvinceCode());
                    String areaCode = this.sL241103001Logic.findAreaCode(mdProvince.getAreaId());
                    slSeller.setAreaCode(areaCode);
                    MdCity mdCity = this.sL241103001Logic.findCity(slSeller.getCityCode());
                    //获取物流区编码
                    String lgcsAreaCode = this.sL241103001Logic.findLgcsAreaCode(mdCity.getLgcsAreaId());
                    slSeller.setLgcsAreaCode(lgcsAreaCode);
                    if ("1".equals(slSeller.getSelfFlg())) {
                        baseParam.setFilter("selfFlg", "1");
                        slSeller.setSlCodeSelf(this.sL241103001Logic.findSlCodeOther(baseParam));
                        baseParam.getFilterMap().remove("selfFlg");
                    }
                    if ("1".equals(slSeller.getAgentFlg())) {
                        baseParam.setFilter("agentFlg", "1");
                        slSeller.setSlCodeAgent(this.sL241103001Logic.findSlCodeOther(baseParam));
                        baseParam.getFilterMap().remove("agentFlg");
                    }
                    if ("1".equals(slSeller.getOemFlg())) {
                        baseParam.setFilter("oemFlg", "1");
                        slSeller.setSlCodeOem(this.sL241103001Logic.findSlCodeOther(baseParam));
                        baseParam.getFilterMap().remove("oemFlg");
                    }

                    slSeller.setSlCodeDis(slCodeDis);
                    slSeller.setCrtId(id);
                    slSeller.setDelFlg("0");
                    slSeller.setVer(NumberConst.IntDef.INT_ONE);
                    int num=this.sL241103001Logic.saveSeller(slSeller);
                    if(num>0){
                        SlSeller slSellerOne=sL241103001Logic.findSlSeller(slSeller.getSlAccount());
                        if(null!=slSellerOne){
                            slCode=slSellerOne.getSlCode();
                        }
                    }
                }


                /**==========================================保存卖家产品类别信息========================================================*/
                /**获取传入值*/
                List<SlPdClasses> slPdClassesLists = isl231180RsParam.getPdClassesCodeList();
                /**搜集用户传入的所有的资质证照ID*/
                List<Long> certIdList = new ArrayList<Long>();
                if (null != isl231180RsParam.getCertInfoList()) {
                    for (ISL231127CertInfoList isl231127CertInfoList : isl231180RsParam.getCertInfoList()) {
                        Long certId = isl231127CertInfoList.getCertId();
                        certIdList.add(certId);
                    }
                }
                if (!CollectionUtils.isEmpty(slPdClassesLists)) {
                    int i = 0;
                    for (SlPdClasses slPdClasse : slPdClassesLists) {
                        i++;
                        /**根据主键查询该信息是否已经存在，如果已经存在，提示存在该信息，没有存在插入数据*/
                       /* BaseParam base = new BaseParam();
                        base.setFilter("slCode", slCode);
                        base.setFilter("pdClassesCode", slPdClasse.getPdClassesCode());
                        base.setFilter("machiningCode", slPdClasse.getMachiningCode());
                        List<SlPdClasses> slPdClassesList = super.findList(SqlId.SQL_ID_FIND_SLPDCLASSES, base);
                        if (slPdClassesList.size() > 0) {
                            throw new BusinessException("录入的产品类别信息已经存在");
                        }*/
                        BaseParam base = new BaseParam();
                        base.setFilter("slCode", slPdClasse.getSlCode());
                        base.setFilter("pdClassesCode", slPdClasse.getPdClassesCode());
                        base.setFilter("machiningCode", slPdClasse.getMachiningCode());
                        BaseParam baseparams = new BaseParam();
                        baseparams.setFilter("slCode", slCode);
                        int count = super.getCount(SqlId.SQL_ID_FIND_QUERYONESLCODE, baseparams);
                        if (count > 0) {
                            /**根据产品类型和加工程度编码，查询用户必须具备的certID,看用户传入的certId是否包含所有的必须具备资质，包含正常执行，不包含，提示用户*/
                            List<SlMstPdCert> slMstPdCerts = super.findList(SqlId.SQL_ID_FIND_CERTID, base);
                            /**根据产品类型及加工程度。必须的资质*/
                            List<Long> certIds = new ArrayList<Long>();
                            if (null != slMstPdCerts) {
                                for (SlMstPdCert slMstPdCert : slMstPdCerts) {
                                    Long certId = slMstPdCert.getCertId();
                                    certIds.add(certId);
                                }
                            }
                            if (!certIdList.containsAll(certIds)) {
                                throw new BusinessException("对不起，您输入的证照不全，无法完成注册");
                            }

                            BaseParam param = new BaseParam();
                            param.setFilter("slCode", slCode);
                            int counts = super.getCount(SqlId.SQL_ID_FIND_QUERYSLPDCLASS, param);
                            if (counts > 0 && i == 1) {
                                super.remove(SqlId.SQL_ID_DELETE_SLPDCLASS, param);
                            }
                            slPdClasse.setSlCode(slCode);
                            slPdClasse.setCrtId(id);
                            slPdClasse.setDelFlg("0");
                            slPdClasse.setVer(NumberConst.IntDef.INT_ONE);
                            super.save(SqlId.SQL_ID_SAVE_SLPDCLASSES, slPdClasse);
                        } else {
                            throw new BusinessException("卖家ID为:" + slPdClasse.getSlCode() + "的不存在");
                        }
                    }
                }


                /**============================================企业基本资质添加=========================================================*/
                SlEnterpriseBean slEnterprise = isl231180RsParam.getSlEnterprise();
                if (null != slEnterprise) {
                    epId = commonLogic.maxId("sl_enterprise", "EP_ID");
                    slEnterprise.setEpId(epId);
                    slEnterprise.setDelFlg("0");
                    slEnterprise.setCrtId(id);
                    slEnterprise.setVer(NumberConst.IntDef.INT_ONE);
                    BaseParam params = new BaseParam();
                    params.setFilter("licNo", slEnterprise.getLicNo());
                    int count = super.getCount(SqlId.SQL_ID_FIND_QUERYLICNODATA, params);
                    if (count > 0) {
                        throw new BusinessException("营业执照号已注册!");
                    }
                    int num = this.sL241103001Logic.saveEp(slEnterprise);
                    if (num >= 1) {
                        BaseParam param = new BaseParam();
                        param.setFilter("epId", StringUtil.toSafeString(slEnterprise.getEpId()));
                        param.setFilter("slCode", slCode);
                        super.modify(SqlId.SQL_ID_FIND_UPDATESLSELLER, param);
                    }
                }


                /**============================================企业专业资质添加、更新====================================================================*/
                List<ISL231127CertInfoList> certInfoList = isl231180RsParam.getCertInfoList();
                if (!CollectionUtils.isEmpty(certInfoList)) {
                    for (ISL231127CertInfoList certInfo : certInfoList) {
                        SlEpCert slEpCert1 = new SlEpCert();
                        slEpCert1.setEpId(epId);
                        slEpCert1.setCertId(certInfo.getCertId());
                        slEpCert1.setCertName(certInfo.getCertName());
                        slEpCert1.setDelFlg("0");
                        slEpCert1.setCrtId(id);
                        slEpCert1.setVer(NumberConst.IntDef.INT_ONE);
                        /**根据用户企业Id查询最大的certseq*/
                        Long maxCertSeq = this.sL24110300301Logic.findMaxCertSeq(epId);
                        slEpCert1.setCertSeq(maxCertSeq);
                        this.sL24110300301Logic.saveSlEpCert(slEpCert1);
                        List<SlEpCertItem> slEpCertItemList = new ArrayList<SlEpCertItem>();
                        if (null != certInfo.getCertItemList() && certInfo.getCertItemList().size() > 0) {
                            for (SlEpCertItem slEpCertItem : certInfo.getCertItemList()) {
                                slEpCertItem.setEpId(epId);
                                slEpCertItem.setCertId(certInfo.getCertId());
                                slEpCertItem.setCertSeq(maxCertSeq);
                                slEpCertItem.setCrtId(id);
                                slEpCertItem.setDelFlg("0");
                                slEpCertItem.setVer(NumberConst.IntDef.INT_ONE);
                                slEpCertItemList.add(slEpCertItem);
                            }
                            this.sL24110300301Logic.saveSlEpCertItem(slEpCertItemList);
                        }
                    }
                }

                /**=============================================企业荣誉添加==========================================================*/
                List<SlEpHonor> slEpHonorList = isl231180RsParam.getSlEpHonorList();
                if (!CollectionUtils.isEmpty(slEpHonorList)) {
                    for (SlEpHonor slEpHonor : slEpHonorList) {
                        slEpHonor.setEpId(epId);
                        Long honorId = this.commonLogic.maxId("SL_EP_HONOR", "HONOR_ID");
                        slEpHonor.setHonorId(honorId);
                        slEpHonor.setCrtId(id);
                        slEpHonor.setVer(NumberConst.IntDef.INT_ONE);
                        slEpHonor.setDelFlg("0");
                        this.sL24110300401Logic.saveSlEpHonor(slEpHonor, epId);
                    }
                }


                /**==========================================企业产品品牌/企业产品品牌荣誉=================== ========================================*/
                List<ISL231180SlEpBrandList> slEpBrandList = isl231180RsParam.getSlEpBrandList();
                if (!CollectionUtils.isEmpty(slEpBrandList)) {
                    Long brandId=1L;
                    for (ISL231180SlEpBrandList isl231180SlEpBrandList : slEpBrandList) {
                        if(slEpBrandList.size()>9){
                            throw new BusinessException("企业产品品牌不能超过9个");
                        }else{
                            //根据epid查询brandid，进行设置
                            SlEpBrand brand = this.sL2411030071Logic.maxBrandByEpId(epId);
                            if (brand!= null && brand.getBrandId()+1L>9) {
                                throw new BusinessException("企业产品品牌不能超过9个");
                            }else if(null!= brand){
                                brandId = brand.getBrandId() + 1L;
                            }
                        }
                        /**保存企业产品品牌 以及保存品牌到卖家产品品牌中*/
                        SlEpBrand slEpBrand = new SlEpBrand();
                        slEpBrand.setEpId(epId);
                       /* Long brandId = this.commonLogic.maxId("SL_EP_BRAND", "BRAND_ID");*/
                        slEpBrand.setBrandId(brandId);
                        slEpBrand.setBrandName(isl231180SlEpBrandList.getBrandName());
                        slEpBrand.setBrandNo(isl231180SlEpBrandList.getBrandNo());
                        slEpBrand.setBrandTermBegin(isl231180SlEpBrandList.getBrandTermBegin());
                        slEpBrand.setBrandTermEnd(isl231180SlEpBrandList.getBrandTermEnd());
                        slEpBrand.setBrandClass(isl231180SlEpBrandList.getBrandClass());
                        slEpBrand.setDelFlg("0");
                        slEpBrand.setCrtId(id);
                        slEpBrand.setVer(NumberConst.IntDef.INT_ONE);
                        //保存企业产品品牌
                        this.iSL231146RsLogic.saveSLEpBrandc(slEpBrand);
                        if(("0").equals(mainClass) || ("1").equals(mainClass) || ("3").equals(mainClass)){
                            //设置卖家产品品牌，自有品牌添加
                            ISlPdBrand slPdBrand = new ISlPdBrand();
                            slPdBrand.setSlCode(slCode);
                            slPdBrand.setBrandEpId(epId);
                            slPdBrand.setBrandId(slEpBrand.getBrandId());
                            slPdBrand.setBrandName(isl231180SlEpBrandList.getBrandName());
                            slPdBrand.setTermBegin(isl231180SlEpBrandList.getBrandTermBegin());
                            slPdBrand.setTermEnd(isl231180SlEpBrandList.getBrandTermEnd());
                            slPdBrand.setBrandClass(isl231180SlEpBrandList.getBrandClass());
                            slPdBrand.setBrandType(1);
                            slPdBrand.setCrtId(id);
                            slPdBrand.setDelFlg("0");
                            slPdBrand.setVer(NumberConst.IntDef.INT_ONE);
                            //保存卖家产品品牌，添加自有品牌
                            this.isl231150RsLogic.saveSLPdBrand(slPdBrand);
                            List<SlEpBrandHonor> slEpBrandHonorList = isl231180SlEpBrandList.getSlEpBrandHonorList();
                            if (null != slEpBrandHonorList && slEpBrandHonorList.size() > 0) {
                                for (SlEpBrandHonor slEpBrandHonor : slEpBrandHonorList) {
                                    if (!StringUtil.isNullOrEmpty(slEpBrandHonor.getHonorDes())) {
                                        slEpBrandHonor.setEpId(epId);
                                        slEpBrandHonor.setBrandId(brandId);
                                        Long honorId = this.commonLogic.maxId("SL_EP_BRAND_HONOR", "HONOR_ID");
                                        slEpBrandHonor.setHonorId(honorId);
                                        slEpBrandHonor.setCrtId(id);
                                        slEpBrandHonor.setVer(NumberConst.IntDef.INT_ONE);
                                        slEpBrandHonor.setDelFlg("0");
                                        this.isl231154RsLogic.saveSLEpBrandHonor(slEpBrandHonor);
                                    }
                                }
                            }
                        }
                    }
                }


                /**==================================================非自己企业品牌时使用==============================================================*/
                List<ISlPdBrand> slPdBrandList2 = isl231180RsParam.getSlPdBrandList();
                if (!CollectionUtils.isEmpty(slPdBrandList2)) {
                    for (ISlPdBrand islPdBrand : slPdBrandList2) {
                        if (!epId.equals(islPdBrand.getBrandEpId())) {
                            if (null != islPdBrand.getBrandEpId() && null != islPdBrand.getBrandId()) {
                                BaseParam baseParams = new BaseParam();
                                baseParams.setFilter("brandEpId", islPdBrand.getBrandEpId().toString());
                                baseParams.setFilter("brandId", islPdBrand.getBrandId().toString());
                                //查询对应企业下的企业品牌ID是否存在，不存在就报错
                                List<SlEpBrand> slEpBrands = super.findList(SqlId.SQL_ID_FIND_SLEPBRAND, baseParams);
                                if (null == slEpBrands || slEpBrands.size() == 0) {
                                    throw new BusinessException("在卖家产品品牌增加别的企业的品牌时，录入了不存在的企业产品品牌");
                                }
                                /**卖家产品品牌*/
                                islPdBrand.setCrtId(id);
                                islPdBrand.setVer(NumberConst.IntDef.INT_ONE);
                                islPdBrand.setDelFlg("0");
                                this.isl231150RsLogic.saveSLPdBrand(islPdBrand);
                            }
                        }
                    }
                }

                /**===============================================企业车间================================================================*/
                List<SlEpWorkshop> slEpWorkshopList = isl231180RsParam.getSlEpWorkshopList();
                if (!CollectionUtils.isEmpty(slEpWorkshopList)) {
                    for (SlEpWorkshop slEpWorkshop : slEpWorkshopList) {
                        slEpWorkshop.setEpId(epId);
                        Long maxId = this.commonLogic.maxId("SL_EP_WORKSHOP", "WORKSHOP_ID");
                        slEpWorkshop.setWorkshopId(maxId);
                        slEpWorkshop.setCrtId(id);
                        slEpWorkshop.setDelFlg("0");
                        slEpWorkshop.setVer(NumberConst.IntDef.INT_ONE);
                        super.save(SqlId.SQL_ID_SAVE_SLEPWORKSHOP, slEpWorkshop);
                    }
                }

                /**==============================================企业生产能力================================================================*/
                SlEpCap slEpCap = isl231180RsParam.getSlEpCap();
                if (null != slEpCap) {
                    /**新增操作*/
                    slEpCap.setEpId(epId);
                    slEpCap.setVer(NumberConst.IntDef.INT_ONE);
                    slEpCap.setCrtId(id);
                    slEpCap.setDelFlg("0");
                    this.sl24110300402Logic.saveSlEpCap(slEpCap);
                }


                /**================================================生产商=============================================================*/
                List<ISL231180SLEpAuth> isl231180SLEpAuthList = isl231180RsParam.getSlEpAuthList();
                if (!CollectionUtils.isEmpty(isl231180SLEpAuthList)) {
                    for (ISL231180SLEpAuth isl231180SLEpAuth : isl231180SLEpAuthList) {
                        /**新增操作*/
                        if ("1".equals(isl231180SLEpAuth.getFlag())) {
                            /**新增代理及分销授权*/
                            SlEpAgentAuth slEpAgentAuth = new SlEpAgentAuth();
                            slEpAgentAuth.setSlCode(slCode);
                            slEpAgentAuth.setProducerEpId(epId);
                            slEpAgentAuth.setContractNo(isl231180SLEpAuth.getContractNo());
                            slEpAgentAuth.setAuthEpName(isl231180SLEpAuth.getAuthEpName());
                            slEpAgentAuth.setAuthTermBegin(isl231180SLEpAuth.getAuthTermBegin());
                            slEpAgentAuth.setAuthTermEnd(isl231180SLEpAuth.getAuthTermEnd());
                            slEpAgentAuth.setAuthTermUnliimited(isl231180SLEpAuth.getAuthTermUnliimited());
                            slEpAgentAuth.setCrtId(id);
                            slEpAgentAuth.setVer(NumberConst.IntDef.INT_ONE);
                            slEpAgentAuth.setDelFlg("0");
                            super.save(SqlId.SQL_ID_SAVE_SLEPAGENTAUTH, slEpAgentAuth);
                        }
                        if ("2".equals(isl231180SLEpAuth.getFlag())) {
                            /**新增oem委托授权*/
                            SlEpOemAuth slEpOemAuth = new SlEpOemAuth();
                            slEpOemAuth.setSlCode(slCode);
                            slEpOemAuth.setProducerEpId(epId);
                            slEpOemAuth.setContractNo(isl231180SLEpAuth.getContractNo());
                            slEpOemAuth.setAuthEpName(isl231180SLEpAuth.getAuthEpName());
                            slEpOemAuth.setAuthTermBegin(isl231180SLEpAuth.getAuthTermBegin());
                            slEpOemAuth.setAuthTermEnd(isl231180SLEpAuth.getAuthTermEnd());
                            slEpOemAuth.setAuthTermUnliimited(isl231180SLEpAuth.getAuthTermUnliimited());
                            slEpOemAuth.setCrtId(id);
                            slEpOemAuth.setVer(NumberConst.IntDef.INT_ONE);
                            slEpOemAuth.setDelFlg("0");
                            super.save(SqlId.SQL_ID_SAVE_SLEPOEMAUTH, slEpOemAuth);
                        }
                    }
                }

                /**==================================================企业管理团队==============================================================*/
                List<SlEpManager> slEpManagerList = isl231180RsParam.getSlEpManagerList();
                if (!CollectionUtils.isEmpty(slEpManagerList)) {
                    for (SlEpManager slEpManager : slEpManagerList) {
                        /**新增企业管理团队信息*/
                        slEpManager.setEpId(epId);
                        Long memberId = this.commonLogic.maxId("SL_EP_MANAGER", "MEMBER_ID");
                        slEpManager.setMemberId(memberId);
                        slEpManager.setCrtId(id);
                        slEpManager.setVer(NumberConst.IntDef.INT_ONE);
                        slEpManager.setDelFlg("0");
                        super.save(SqlId.SQL_ID_SAVE_SLEPMANAGER, slEpManager);
                    }
                }


                /**===================================================企业电商团队=================================================================*/
                List<SlEcTeam> slEcTeamList = isl231180RsParam.getSlEcTeamList();
                if (!CollectionUtils.isEmpty(slEcTeamList)) {
                    for (SlEcTeam slEcTeam : slEcTeamList) {
                        /**新增操作*/
                        slEcTeam.setSlCode(slCode);
                        Long memberId = this.commonLogic.maxId("SL_EC_TEAM", "MEMBER_ID");
                        slEcTeam.setMemberId(memberId.intValue());
                        slEcTeam.setDelFlg("0");
                        slEcTeam.setCrtId(id);
                        slEcTeam.setVer(NumberConst.IntDef.INT_ONE);
                        super.save(SqlId.SQL_ID_SAVE_SLECTEAM, slEcTeam);
                    }
                }
                /**=================================================企业检测设备===================================================================*/
                List<SlEpDd> slEpDdList = isl231180RsParam.getSlEpDdList();
                if (!CollectionUtils.isEmpty(slEpDdList)) {
                    for (SlEpDd slEpDd : slEpDdList) {
                        /**新增操作*/
                        slEpDd.setEpId(epId);
                        Long ddId = this.commonLogic.maxId("sl_ep_dd", "DD_ID");
                        slEpDd.setDdId(ddId);
                        slEpDd.setDelFlg("0");
                        slEpDd.setCrtId(id);
                        slEpDd.setVer(NumberConst.IntDef.INT_ONE);
                        super.save(SqlId.SQL_ID_SAVE_SL_EPDD, slEpDd);
                    }
                }
                isl231180RsResult.setEpId(epId);
                isl231180RsResult.setSlCode(slCode);
            } else if (isl231180RsParam.getInsertFlag() == NumberConst.IntDef.INT_ONE) {
                //单个添加
                {
                    //卖家ID
                    String slCode = null;
                    //企业ID
                    Long epId = null;
                    /**保存卖家账号信息=======================================================================================================*/
                    SlAccount slAccount = isl231180RsParam.getSlAccount();
                    if (null != slAccount) {
                        //1.如果用戶帐号和密码不为空，查询账号是否存在
                        if (!StringUtil.isNullOrEmpty(slAccount.getSlAccount()) && !StringUtil.isNullOrEmpty(slAccount.getAccountPsd())) {

                            if (!StringUtil.isNullOrEmpty(slAccount.getSlTel())) {
                                BaseParam params = new BaseParam();
                                params.setFilter("slTel", slAccount.getSlTel());
                                int num = super.getCount(SqlId.SQL_ID_QUERY_SLTEL, params);
                                if (0 < num) {
                                    throw new BusinessException("手机账户已注册!");
                                }
                            }
                            BaseParam base = new BaseParam();
                            base.setFilter("slAccount", slAccount.getSlAccount());
                            SlAccount slAccount1 = super.findOne(SqlId.SQL_ID_FIND_SLACCOUNTIFEXIST, base);
                            //1.1如果账号存在，则更新
                            if (null == slAccount1) {
                                //1.1如果账号不存在，则新增
                                slAccount.setCrtId(id);
                                slAccount.setDelFlg("0");
                                slAccount.setVer(NumberConst.IntDef.INT_ONE);
                                this.sL241103001Logic.saveAccount(slAccount);
                            } else {
                                throw new BusinessException("账户已注册!");
                            }
                        } else {
                            throw new BusinessException("卖家账号和密码不能为空");
                        }
                    }


                    /**================================================保存卖家基本信息========================================================*/
                    SlSeller slSeller = isl231180RsParam.getSlSeller();
                    if (null != slSeller) {
                        /**增加前先查询下这个卖家账号是否已经注册了，如果已经注册了，报错提示，如果没有注册过，就新增*/
                        BaseParam base = new BaseParam();
                        base.setFilter("slAccount", slSeller.getSlAccount());
                        SlSeller slSellerList = super.findOne(SqlId.SQL_ID_FIND_SLSELLERLIST, base);
                        if (null!=slSellerList) {
                            throw new BusinessException("该账号卖家基本信息已经存在，无法重复录入");
                        }
                        /**查询slcode,第一次新建的时候slcode不知道是多少，采用拼接方式 provinceCode+cityCode+districtCode+后八位番号*/
                        String slCodeDis = this.sL241103001Logic.findAccount(slSeller.getSlMainClass().toString(), slSeller.getCityCode(), slSeller.getSlConFlg());
                        //生成卖家生产商编码
                        //根据区划和国际查询生产商编码
                        slSeller.setSlCodeManufacture(this.sL241103001Logic.findSlCodeManufacture(slSeller.getCityCode(), slSeller.getSlConFlg()));
                        //获取大区编码
                        MdProvince mdProvince = this.sL241103001Logic.findProvince(slSeller.getProvinceCode());
                        String areaCode = this.sL241103001Logic.findAreaCode(mdProvince.getAreaId());
                        slSeller.setAreaCode(areaCode);
                        MdCity mdCity = this.sL241103001Logic.findCity(slSeller.getCityCode());
                        //获取物流区编码
                        String lgcsAreaCode = this.sL241103001Logic.findLgcsAreaCode(mdCity.getLgcsAreaId());
                        slSeller.setLgcsAreaCode(lgcsAreaCode);
                        //二级经营类型
                        BaseParam baseParam = new BaseParam();
                        baseParam.setFilter("cityCode", slSeller.getCityCode());
                        baseParam.setFilter("slConFlg", slSeller.getSlConFlg());
                        if ("1".equals(slSeller.getSelfFlg())) {
                            baseParam.setFilter("selfFlg", "1");
                            slSeller.setSlCodeSelf(this.sL241103001Logic.findSlCodeOther(baseParam));
                            baseParam.getFilterMap().remove("selfFlg");
                        }
                        if ("1".equals(slSeller.getAgentFlg())) {
                            baseParam.setFilter("agentFlg", "1");
                            slSeller.setSlCodeAgent(this.sL241103001Logic.findSlCodeOther(baseParam));
                            baseParam.getFilterMap().remove("agentFlg");
                        }
                        if ("1".equals(slSeller.getOemFlg())) {
                            baseParam.setFilter("oemFlg", "1");
                            slSeller.setSlCodeOem(this.sL241103001Logic.findSlCodeOther(baseParam));
                            baseParam.getFilterMap().remove("oemFlg");
                        }
                        slSeller.setSlCodeDis(slCodeDis);
                        slSeller.setCrtId(id);
                        slSeller.setDelFlg("0");
                        slSeller.setVer(NumberConst.IntDef.INT_ONE);
                        int num=this.sL241103001Logic.saveSeller(slSeller);
                        if(num>0){
                            SlSeller slSellerOne=sL241103001Logic.findSlSeller(slSeller.getSlAccount());
                            if(null!=slSellerOne){
                                slCode=slSellerOne.getSlCode();
                            }
                        }
                        isl231180RsResult.setSlCode(slCode);
                    }


                    /**==========================================保存卖家产品类别信息========================================================*/
                    /**获取传入值*/
                    List<SlPdClasses> slPdClassesLists = isl231180RsParam.getPdClassesCodeList();
                    /**搜集用户传入的所有的资质证照ID*/
                    List<Long> certIdList = new ArrayList<Long>();
                    if (null != isl231180RsParam.getCertInfoList()) {
                        for (ISL231127CertInfoList isl231127CertInfoList : isl231180RsParam.getCertInfoList()) {
                            Long certId = isl231127CertInfoList.getCertId();
                            certIdList.add(certId);
                        }
                    }
                    if (!CollectionUtils.isEmpty(slPdClassesLists)) {
                        int i = 0;
                        for (SlPdClasses slPdClasse : slPdClassesLists) {
                            i++;
                            /**根据主键查询该信息是否已经存在，如果已经存在，提示存在该信息，没有存在插入数据*/
                            /*BaseParam base = new BaseParam();
                            base.setFilter("slCode", slPdClasse.getSlCode());
                            base.setFilter("pdClassesCode", slPdClasse.getPdClassesCode());
                            base.setFilter("machiningCode", slPdClasse.getMachiningCode());
                            List<SlPdClasses> slPdClassesList = super.findList(SqlId.SQL_ID_FIND_SLPDCLASSES, base);
                            if (slPdClassesList.size() > 0) {
                                throw new BusinessException("录入的产品类别信息已经存在");
                            }*/
                            BaseParam base = new BaseParam();
                            base.setFilter("slCode", slPdClasse.getSlCode());
                            base.setFilter("pdClassesCode", slPdClasse.getPdClassesCode());
                            base.setFilter("machiningCode", slPdClasse.getMachiningCode());
                            BaseParam baseparams = new BaseParam();
                            baseparams.setFilter("slCode", slPdClasse.getSlCode());
                            int count = super.getCount(SqlId.SQL_ID_FIND_QUERYONESLCODE, baseparams);
                            if (count > 0) {
                                /**根据产品类型和加工程度编码，查询用户必须具备的certID,看用户传入的certId是否包含所有的必须具备资质，包含正常执行，不包含，提示用户*/
                                List<SlMstPdCert> slMstPdCerts = super.findList(SqlId.SQL_ID_FIND_CERTID, base);
                                /**根据产品类型及加工程度。必须的资质*/
                                List<Long> certIds = new ArrayList<Long>();
                                if (null != slMstPdCerts) {
                                    for (SlMstPdCert slMstPdCert : slMstPdCerts) {
                                        Long certId = slMstPdCert.getCertId();
                                        certIds.add(certId);
                                    }
                                }
                                if (!certIdList.containsAll(certIds)) {
                                    throw new BusinessException("对不起，您输入的证照不全，无法完成注册");
                                }
                                BaseParam param = new BaseParam();
                                param.setFilter("slCode", slPdClasse.getSlCode());
                                int counts = super.getCount(SqlId.SQL_ID_FIND_QUERYSLPDCLASS, param);
                                if (counts > 0 && i == 1) {
                                    super.remove(SqlId.SQL_ID_DELETE_SLPDCLASS, param);
                                }
                                slPdClasse.setSlCode(slPdClasse.getSlCode());
                                slPdClasse.setCrtId(id);
                                slPdClasse.setDelFlg("0");
                                slPdClasse.setVer(NumberConst.IntDef.INT_ONE);
                                super.save(SqlId.SQL_ID_SAVE_SLPDCLASSES, slPdClasse);
                            } else {
                                throw new BusinessException("卖家ID为:" + slPdClasse.getSlCode() + "的不存在");
                            }
                        }
                    }


                    /**============================================企业基本资质添加=========================================================*/
                    SlEnterpriseBean slEnterprise = isl231180RsParam.getSlEnterprise();
                    if (null != slEnterprise) {
                        Long epIds = commonLogic.maxId("sl_enterprise", "EP_ID");
                        slEnterprise.setEpId(epIds);
                        slEnterprise.setDelFlg("0");
                        slEnterprise.setCrtId(id);
                        slEnterprise.setVer(NumberConst.IntDef.INT_ONE);
                        BaseParam params = new BaseParam();
                        params.setFilter("licNo", slEnterprise.getLicNo());
                        int count = super.getCount(SqlId.SQL_ID_FIND_QUERYLICNODATA, params);
                        if (count > 0) {
                            throw new BusinessException("营业执照号已注册!");
                        }
                        int num = this.sL241103001Logic.saveEp(slEnterprise);
                        if (num >= 1) {
                            BaseParam param = new BaseParam();
                            param.setFilter("epId", StringUtil.toSafeString(slEnterprise.getEpId()));
                            param.setFilter("slCode", slEnterprise.getSlCode());
                            super.modify(SqlId.SQL_ID_FIND_UPDATESLSELLER, param);
                        }
                        isl231180RsResult.setEpId(epIds);
                    }


                    /**============================================企业专业资质添加、更新====================================================================*/
                    List<ISL231127CertInfoList> certInfoList = isl231180RsParam.getCertInfoList();
                    if (!CollectionUtils.isEmpty(certInfoList)) {
                        for (ISL231127CertInfoList certInfo : certInfoList) {
                            //判断标示是删除
                            if ("1".equals(certInfo.getDelFlg())) {
                                BaseParam param = new BaseParam();
                                param.setFilter("epId", StringUtil.toSafeString(certInfo.getEpId()));
                                param.setFilter("certId", StringUtil.toSafeString(certInfo.getCertId()));
                                param.setFilter("delFlg", "1");
                                //删除操作
                                super.modify(SqlId.SQL_ID_DELETE_SLEPCERT, param);
                                //判断标示是新增
                            } else if (StringUtil.isNullOrEmpty(certInfo.getDelFlg()) || "0".equals(certInfo.getDelFlg())) {
                                //查询数据是否存在
                                BaseParam params = new BaseParam();
                                params.setFilter("epId", StringUtil.toSafeString(certInfo.getEpId()));
                                params.setFilter("certId", StringUtil.toSafeString(certInfo.getCertId()));
                                SlEpCert slEpCert2 = super.findOne(SqlId.SQL_ID_QUERY_SLEPCERT, params);
                                if (null != slEpCert2) {
                                    String delFlg = slEpCert2.getDelFlg();
                                    //数据存在且删除标示为1，表示数据已删除。进行更新操作
                                    if ("1".equals(delFlg)) {
                                        //将删除数据，更新删除标示为0
                                        BaseParam param = new BaseParam();
                                        param.setFilter("epId", StringUtil.toSafeString(certInfo.getEpId()));
                                        param.setFilter("certId", StringUtil.toSafeString(certInfo.getCertId()));
                                        param.setFilter("delFlg", "0");
                                        super.modify(SqlId.SQL_ID_DELETE_SLEPCERT, param);
                                        //更新企业证照项目信息
                                        List<SlEpCertItem> itemList = certInfo.getCertItemList();
                                        if (null != itemList && itemList.size() > 0) {
                                            for (SlEpCertItem slEpCertItem : itemList) {
                                                slEpCertItem.setEpId(certInfo.getEpId());
                                                slEpCertItem.setCertId(certInfo.getCertId());
                                                slEpCertItem.setUpdId(id);
                                                if (null != isl231180RsParam.getVer()) {
                                                    slEpCertItem.setVer(isl231180RsParam.getVer() + 1);
                                                    super.modify(SqlId.SQL_ID_UPDATE_SLEPCERTITEM, slEpCertItem);
                                                }
                                            }
                                        } else {
                                            throw new BusinessException("证照项目信息为空");
                                        }
                                    } else {
                                        throw new BusinessException("企业ID为:" + StringUtil.toSafeString(certInfo.getEpId()) + ",证照ID为:" + StringUtil.toSafeString(certInfo.getCertId()) + "，记录已存在");
                                    }
                                } else {
                                    SlEpCert slEpCert1 = new SlEpCert();
                                    slEpCert1.setEpId(certInfo.getEpId());
                                    slEpCert1.setCertId(certInfo.getCertId());
                                    slEpCert1.setCertName(certInfo.getCertName());
                                    slEpCert1.setDelFlg("0");
                                    slEpCert1.setCrtId(id);
                                    slEpCert1.setVer(NumberConst.IntDef.INT_ONE);
                                    /**根据用户企业Id查询最大的certseq*/
                                    Long maxCertSeq = this.sL24110300301Logic.findMaxCertSeq(certInfo.getEpId());
                                    slEpCert1.setCertSeq(maxCertSeq);
                                    this.sL24110300301Logic.saveSlEpCert(slEpCert1);
                                    List<SlEpCertItem> slEpCertItemList = new ArrayList<SlEpCertItem>();
                                    if (null != certInfo.getCertItemList() && certInfo.getCertItemList().size() > 0) {
                                        for (SlEpCertItem slEpCertItem : certInfo.getCertItemList()) {
                                            slEpCertItem.setEpId(certInfo.getEpId());
                                            slEpCertItem.setCertId(certInfo.getCertId());
                                            slEpCertItem.setCertSeq(maxCertSeq);
                                            slEpCertItem.setCrtId(id);
                                            slEpCertItem.setDelFlg("0");
                                            slEpCertItem.setVer(NumberConst.IntDef.INT_ONE);
                                            slEpCertItemList.add(slEpCertItem);
                                        }
                                        this.sL24110300301Logic.saveSlEpCertItem(slEpCertItemList);
                                    }
                                }
                            }
                        }
                    }

                    /**=============================================企业荣誉添加==========================================================*/
                    List<SlEpHonor> slEpHonorList = isl231180RsParam.getSlEpHonorList();
                    if (!CollectionUtils.isEmpty(slEpHonorList)) {
                        for (SlEpHonor slEpHonor : slEpHonorList) {
                            if ("1".equals(slEpHonor.getDelFlg())) {
                                BaseParam param = new BaseParam();
                                param.setFilter("epId", StringUtil.toSafeString(slEpHonor.getEpId()));
                                param.setFilter("honorId", StringUtil.toSafeString(slEpHonor.getHonorId()));
                                param.setFilter("delFlg", "1");
                                super.modify(SqlId.SQL_ID_DELETE_SLEPHONOR, param);
                            } else if (StringUtil.isNullOrEmpty(slEpHonor.getDelFlg()) || "0".equals(slEpHonor.getDelFlg())) {
                                this.sL24110300401Logic.findIfExistHonor(slEpHonor.getEpId(), slEpHonor.getHonorDesc());
                                slEpHonor.setEpId(slEpHonor.getEpId());
                                Long honorId = this.commonLogic.maxId("SL_EP_HONOR", "HONOR_ID");
                                slEpHonor.setHonorId(honorId);
                                slEpHonor.setCrtId(id);
                                slEpHonor.setVer(NumberConst.IntDef.INT_ONE);
                                slEpHonor.setDelFlg("0");
                                this.sL24110300401Logic.saveSlEpHonor(slEpHonor, slEpHonor.getEpId());
                            }
                        }
                    }


                    /**==========================================企业产品品牌/企业产品品牌荣誉===========================================================*/
                    List<ISL231180SlEpBrandList> slEpBrandList = isl231180RsParam.getSlEpBrandList();
                    if (!CollectionUtils.isEmpty(slEpBrandList)) {
                        for (ISL231180SlEpBrandList isl231180SlEpBrandList : slEpBrandList) {
                            if(!StringUtil.isNullOrEmpty(StringUtil.toSafeString(isl231180SlEpBrandList.getEpId()))){
                                //根据epid查询brandid，进行设置
                                SlEpBrand brand = this.sL2411030071Logic.maxBrandByEpId(isl231180SlEpBrandList.getEpId());
                                Long brandId=1L;
                                if (brand!= null && brand.getBrandId()+1L>9) {
                                    throw new BusinessException("企业产品品牌不能超过9个");
                                }else if(null!= brand){
                                    brandId = brand.getBrandId() + 1L;
                                }
                                if ("1".equals(isl231180SlEpBrandList.getDelFlg())) {
                                    BaseParam param = new BaseParam();
                                    param.setFilter("epId", StringUtil.toSafeString(isl231180SlEpBrandList.getEpId()));
                                    param.setFilter("brandId", StringUtil.toSafeString(isl231180SlEpBrandList.getBrandId()));
                                    param.setFilter("delFlg", "1");
                                    super.modify(SqlId.SQL_ID_DELETE_SLEPBRAND, param);
                                } else if (StringUtil.isNullOrEmpty(isl231180SlEpBrandList.getDelFlg()) || "0".equals(isl231180SlEpBrandList.getDelFlg())) {
                                    /**保存企业产品品牌 以及保存品牌到卖家产品品牌中*/
                                    SlEpBrand slEpBrand = new SlEpBrand();
                                    slEpBrand.setEpId(isl231180SlEpBrandList.getEpId());
                                    slEpBrand.setBrandId(brandId);
                                    slEpBrand.setBrandName(isl231180SlEpBrandList.getBrandName());
                                    slEpBrand.setBrandNo(isl231180SlEpBrandList.getBrandNo());
                                    slEpBrand.setBrandTermBegin(isl231180SlEpBrandList.getBrandTermBegin());
                                    slEpBrand.setBrandTermEnd(isl231180SlEpBrandList.getBrandTermEnd());
                                    slEpBrand.setBrandClass(isl231180SlEpBrandList.getBrandClass());
                                    slEpBrand.setDelFlg("0");
                                    slEpBrand.setCrtId(id);
                                    slEpBrand.setVer(NumberConst.IntDef.INT_ONE);
                                    //保存企业产品品牌
                                    this.iSL231146RsLogic.saveSLEpBrandc(slEpBrand);
                                    BaseParam base = new BaseParam();
                                    base.setFilter("epId", StringUtil.toSafeString(isl231180SlEpBrandList.getEpId()));
                                    SlSeller slSellerList = super.findOne(SqlId.SQL_ID_FIND_SLSELLEREPID, base);
                                    if(null!=slSellerList){
                                        if(NumberConst.IntDef.INT_ZERO==slSellerList.getSlMainClass() || NumberConst.IntDef.INT_ONE==slSellerList.getSlMainClass() || NumberConst.IntDef.INT_THREE==slSellerList.getSlMainClass()){
                                            //设置卖家产品品牌，自有品牌添加
                                            ISlPdBrand slPdBrand = new ISlPdBrand();
                                            slPdBrand.setSlCode(slSellerList.getSlCode());
                                            slPdBrand.setBrandEpId(isl231180SlEpBrandList.getEpId());
                                            slPdBrand.setBrandId(slEpBrand.getBrandId());
                                            slPdBrand.setBrandName(isl231180SlEpBrandList.getBrandName());
                                            slPdBrand.setTermBegin(isl231180SlEpBrandList.getBrandTermBegin());
                                            slPdBrand.setTermEnd(isl231180SlEpBrandList.getBrandTermEnd());
                                            slPdBrand.setBrandClass(isl231180SlEpBrandList.getBrandClass());
                                            slPdBrand.setBrandType(1);
                                            slPdBrand.setCrtId(id);
                                            slPdBrand.setDelFlg("0");
                                            slPdBrand.setVer(NumberConst.IntDef.INT_ONE);
                                            //保存卖家产品品牌，添加自有品牌
                                            this.isl231150RsLogic.saveSLPdBrand(slPdBrand);
                                            List<SlEpBrandHonor> slEpBrandHonorList = isl231180SlEpBrandList.getSlEpBrandHonorList();
                                            if (null != slEpBrandHonorList && slEpBrandHonorList.size() > 0) {
                                                for (SlEpBrandHonor slEpBrandHonor : slEpBrandHonorList) {
                                                    if ("1".equals(slEpBrandHonor.getDelFlg())) {
                                                        BaseParam param = new BaseParam();
                                                        param.setFilter("epId", StringUtil.toSafeString(slEpBrandHonor.getEpId()));
                                                        param.setFilter("brandId", StringUtil.toSafeString(slEpBrandHonor.getBrandId()));
                                                        param.setFilter("honorId", StringUtil.toSafeString(slEpBrandHonor.getHonorId()));
                                                        param.setFilter("delFlg", "1");
                                                        super.modify(SqlId.SQL_ID_DELETE_SLEPBRANDHONOR, param);
                                                    } else if (StringUtil.isNullOrEmpty(slEpBrandHonor.getDelFlg()) || "0".equals(slEpBrandHonor.getDelFlg())) {
                                                        slEpBrandHonor.setEpId(slEpBrandHonor.getEpId());
                                                        slEpBrandHonor.setBrandId(brandId);
                                                        Long honorId = this.commonLogic.maxId("SL_EP_BRAND_HONOR", "HONOR_ID");
                                                        slEpBrandHonor.setHonorId(honorId);
                                                        slEpBrandHonor.setCrtId(id);
                                                        slEpBrandHonor.setVer(NumberConst.IntDef.INT_ONE);
                                                        slEpBrandHonor.setDelFlg("0");
                                                        this.isl231154RsLogic.saveSLEpBrandHonor(slEpBrandHonor);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }else{
                                List<SlEpBrandHonor> slEpBrandHonorList = isl231180SlEpBrandList.getSlEpBrandHonorList();
                                if (null != slEpBrandHonorList && slEpBrandHonorList.size() > 0) {
                                    for (SlEpBrandHonor slEpBrandHonor : slEpBrandHonorList) {
                                        if ("1".equals(slEpBrandHonor.getDelFlg())) {
                                            BaseParam param = new BaseParam();
                                            param.setFilter("epId", StringUtil.toSafeString(slEpBrandHonor.getEpId()));
                                            param.setFilter("brandId", StringUtil.toSafeString(slEpBrandHonor.getBrandId()));
                                            param.setFilter("honorId", StringUtil.toSafeString(slEpBrandHonor.getHonorId()));
                                            param.setFilter("delFlg", "1");
                                            super.modify(SqlId.SQL_ID_DELETE_SLEPBRANDHONOR, param);
                                        } else if (StringUtil.isNullOrEmpty(slEpBrandHonor.getDelFlg()) || "0".equals(slEpBrandHonor.getDelFlg())) {
                                            slEpBrandHonor.setEpId(slEpBrandHonor.getEpId());
                                            slEpBrandHonor.setBrandId(slEpBrandHonor.getBrandId());
                                            Long honorId = this.commonLogic.maxId("SL_EP_BRAND_HONOR", "HONOR_ID");
                                            slEpBrandHonor.setHonorId(honorId);
                                            slEpBrandHonor.setCrtId(id);
                                            slEpBrandHonor.setVer(NumberConst.IntDef.INT_ONE);
                                            slEpBrandHonor.setDelFlg("0");
                                            this.isl231154RsLogic.saveSLEpBrandHonor(slEpBrandHonor);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    /**===============================================卖家品牌================================================================*/
                    List<ISlPdBrand> slPdBrandList = isl231180RsParam.getSlPdBrandList();
                    if (!CollectionUtils.isEmpty(slPdBrandList)) {
                        for (ISlPdBrand slPdBrandTwo : slPdBrandList) {
                            if ("1".equals(slPdBrandTwo.getDelFlg())) {
                                BaseParam param = new BaseParam();
                                param.setFilter("slCode", StringUtil.toSafeString(slPdBrandTwo.getSlCode()));
                                param.setFilter("brandEpId", StringUtil.toSafeString(slPdBrandTwo.getBrandEpId()));
                                param.setFilter("brandId", StringUtil.toSafeString(slPdBrandTwo.getBrandId()));
                                param.setFilter("delFlg", "1");
                                super.modify(SqlId.SQL_ID_DELETE_SLPDBRAND, param);
                            } else if (StringUtil.isNullOrEmpty(slPdBrandTwo.getDelFlg()) || "0".equals(slPdBrandTwo.getDelFlg())) {
                                //查询卖家品牌是否存在
                                BaseParam param = new BaseParam();
                                param.setFilter("slCode", StringUtil.toSafeString(slPdBrandTwo.getSlCode()));
                                param.setFilter("brandEpId", StringUtil.toSafeString(slPdBrandTwo.getBrandEpId()));
                                param.setFilter("brandId", StringUtil.toSafeString(slPdBrandTwo.getBrandId()));
                                SlPdBrand slPdBrandThree = super.findOne(SqlId.SQL_ID_QUERY_SLPDBREED, param);
                                if (null != slPdBrandThree) {
                                    String delFlg = slPdBrandThree.getDelFlg();
                                    if ("1".equals(delFlg)) {
                                        BaseParam params = new BaseParam();
                                        params.setFilter("slCode", StringUtil.toSafeString(slPdBrandTwo.getSlCode()));
                                        params.setFilter("brandEpId", StringUtil.toSafeString(slPdBrandTwo.getBrandEpId()));
                                        params.setFilter("brandId", StringUtil.toSafeString(slPdBrandTwo.getBrandId()));
                                        params.setFilter("delFlg", "0");
                                        super.modify(SqlId.SQL_ID_DELETE_SLPDBRAND, params);
                                        //在保存企业产品品牌的时候已经保存了该企业的所有品牌到卖家产品品牌，现在添加的是别的企业的产品品牌,brandId必须存在
                                        if (null != slPdBrandTwo.getBrandEpId() && null != slPdBrandTwo.getBrandId()) {
                                            BaseParam baseParams = new BaseParam();
                                            baseParams.setFilter("brandEpId", slPdBrandTwo.getBrandEpId().toString());
                                            baseParams.setFilter("brandId", slPdBrandTwo.getBrandId().toString());
                                            //查询对应企业下的企业品牌ID是否存在，不存在就报错
                                            List<SlEpBrand> slEpBrands = super.findList(SqlId.SQL_ID_FIND_SLEPBRAND, baseParams);
                                            if (null == slEpBrands || slEpBrands.size() == 0) {
                                                throw new BusinessException("在卖家产品品牌增加别的企业的品牌时，录入了不存在的企业产品品牌");
                                            }
                                            //查询是否传入了slCode,如果传入了，更新操作，没有传入，新增操作
                                            if (!StringUtil.isNullOrEmpty(slPdBrandTwo.getSlCode())) {
                                                BaseParam paramTwo = new BaseParam();
                                                paramTwo.setFilter("slCode", slPdBrandTwo.getSlCode());
                                                paramTwo.setFilter("brandEpId", StringUtil.toSafeString(slPdBrandTwo.getBrandEpId()));
                                                paramTwo.setFilter("brandId", StringUtil.toSafeString(slPdBrandTwo.getBrandId()));
                                                //根据传入的数据查询数据库中是否已经存在，存在更新，不存在报错
                                                SlPdBrand slPdBrand1 = super.findOne(SqlId.SQL_ID_FIND_SLPDBRANDIFEXIST, paramTwo);
                                                if (null != slPdBrand1) {
                                                    /**更新操作*/
                                                    slPdBrandTwo.setUpdId(id);
                                                    if (null != isl231180RsParam.getVer()) {
                                                        slPdBrandTwo.setVer(isl231180RsParam.getVer() + 1);
                                                    }
                                                    super.modify(SqlId.SQL_ID_UPDATE_SLPDBRAND, slPdBrandTwo);
                                                } else {
                                                    throw new BusinessException("没有查询到您输入的卖家产品品牌信息");
                                                }
                                            }
                                        }
                                    } else {
                                        throw new BusinessException("卖家ID为:" + slPdBrandTwo.getSlCode() + ",企业ID为:" + StringUtil.toSafeString(slPdBrandTwo.getBrandEpId()) + ",品牌ID为:" + StringUtil.toSafeString(slPdBrandTwo.getBrandId()) + "，记录已存在");
                                    }
                                } else {
                                    //设置卖家产品品牌，自有品牌添加
                                    ISlPdBrand slPdBrand = new ISlPdBrand();
                                    slPdBrand.setSlCode(slPdBrandTwo.getSlCode());
                                    slPdBrand.setBrandEpId(slPdBrandTwo.getBrandEpId());
                                    slPdBrand.setBrandId(slPdBrandTwo.getBrandId());
                                    slPdBrand.setBrandName(slPdBrandTwo.getBrandName());
                                    slPdBrand.setTermBegin(slPdBrandTwo.getTermBegin());
                                    slPdBrand.setTermEnd(slPdBrandTwo.getTermBegin());
                                    slPdBrand.setBrandClass(slPdBrandTwo.getBrandClass());
                                    slPdBrand.setBrandType(1);
                                    slPdBrand.setCrtId(id);
                                    slPdBrand.setDelFlg("0");
                                    slPdBrand.setVer(NumberConst.IntDef.INT_ONE);
                                    //保存卖家产品品牌，添加自有品牌
                                    this.isl231150RsLogic.saveSLPdBrand(slPdBrand);
                                }
                            }
                        }
                    }
                }
                /**===============================================企业车间================================================================*/
                List<SlEpWorkshop> slEpWorkshopList = isl231180RsParam.getSlEpWorkshopList();
                if (!CollectionUtils.isEmpty(slEpWorkshopList)) {
                    for (SlEpWorkshop slEpWorkshop : slEpWorkshopList) {
                        if ("1".equals(slEpWorkshop.getDelFlg())) {
                            BaseParam param = new BaseParam();
                            param.setFilter("epId", StringUtil.toSafeString(slEpWorkshop.getEpId()));
                            param.setFilter("workShopId", StringUtil.toSafeString(slEpWorkshop.getWorkshopId()));
                            param.setFilter("delFlg", "1");
                            super.modify(SqlId.SQL_ID_DELETE_WORKSHOPID, param);
                        } else if (StringUtil.isNullOrEmpty(slEpWorkshop.getDelFlg()) || "0".equals(slEpWorkshop.getDelFlg())) {
                            slEpWorkshop.setEpId(slEpWorkshop.getEpId());
                            Long maxId = this.commonLogic.maxId("SL_EP_WORKSHOP", "WORKSHOP_ID");
                            slEpWorkshop.setWorkshopId(maxId);
                            slEpWorkshop.setCrtId(id);
                            slEpWorkshop.setDelFlg("0");
                            slEpWorkshop.setVer(NumberConst.IntDef.INT_ONE);
                            super.save(SqlId.SQL_ID_SAVE_SLEPWORKSHOP, slEpWorkshop);
                        }
                    }
                }

                /**==============================================企业生产能力================================================================*/
                SlEpCap slEpCap = isl231180RsParam.getSlEpCap();
                if (null != slEpCap) {
                    //查询记录是否存在
                    SlEpCap slEpCap1 = this.sl24110300402Logic.findSlEpCapIfExist(slEpCap.getEpId());
                    if (null != slEpCap1) {
                        throw new BusinessException("企业ID为:" + slEpCap.getEpId() + ",的基本能力已存在");
                    } else {
                        /**新增操作*/
                        slEpCap.setEpId(slEpCap.getEpId());
                        slEpCap.setVer(NumberConst.IntDef.INT_ONE);
                        slEpCap.setCrtId(id);
                        slEpCap.setDelFlg("0");
                        this.sl24110300402Logic.saveSlEpCap(slEpCap);
                    }
                }


                /**================================================生产商=============================================================*/
                List<ISL231180SLEpAuth> isl231180SLEpAuthList = isl231180RsParam.getSlEpAuthList();
                if (!CollectionUtils.isEmpty(isl231180SLEpAuthList)) {
                    for (ISL231180SLEpAuth isl231180SLEpAuth : isl231180SLEpAuthList) {
                        /**新增操作*/
                        if ("1".equals(isl231180SLEpAuth.getFlag())) {
                            if ("1".equals(isl231180SLEpAuth.getDelFlg())) {
                                BaseParam param = new BaseParam();
                                param.setFilter("slCode", StringUtil.toSafeString(isl231180SLEpAuth.getSlCode()));
                                param.setFilter("epId", StringUtil.toSafeString(isl231180SLEpAuth.getProducerEpId()));
                                param.setFilter("delFlg", "1");
                                super.modify(SqlId.SQL_ID_DELETE_SLEPAGENTAUTH, param);
                            } else if (StringUtil.isNullOrEmpty(isl231180SLEpAuth.getDelFlg()) || "0".equals(isl231180SLEpAuth.getDelFlg())) {
                                //查询记录是否存在
                                BaseParam param = new BaseParam();
                                param.setFilter("slCode", StringUtil.toSafeString(isl231180SLEpAuth.getSlCode()));
                                param.setFilter("epId", StringUtil.toSafeString(isl231180SLEpAuth.getProducerEpId()));
                                SlEpAgentAuth slEpAgentAuthTwo = super.findOne(SqlId.SQL_ID_QUERY_SLEPAGENTAUTH, param);
                                if (null != slEpAgentAuthTwo) {
                                    String delFlg = slEpAgentAuthTwo.getDelFlg();
                                    if ("1".equals(delFlg)) {
                                        BaseParam basepa = new BaseParam();
                                        basepa.setFilter("epId", isl231180SLEpAuth.getProducerEpId().toString());
                                        SlEnterprise slEnterprise1 = super.findOne(SqlId.SQL_ID_FIND_SLENTERPRISE, basepa);
                                        if (null == slEnterprise1) {
                                            throw new BusinessException("你录入的生产商_企业ID不存在");
                                        }
                                        /**更新操作*/
                                        if (isl231180SLEpAuth.getFlag().equals("1")) {
                                            /**更新卖家代理及分销授权*/
                                            SlEpAgentAuth slEpAgentAuth = new SlEpAgentAuth();
                                            slEpAgentAuth.setSlCode(isl231180SLEpAuth.getSlCode());
                                            slEpAgentAuth.setProducerEpId(isl231180SLEpAuth.getProducerEpId());
                                            slEpAgentAuth.setContractNo(isl231180SLEpAuth.getContractNo());
                                            slEpAgentAuth.setAuthEpName(isl231180SLEpAuth.getAuthEpName());
                                            slEpAgentAuth.setAuthTermBegin(isl231180SLEpAuth.getAuthTermBegin());
                                            slEpAgentAuth.setAuthTermEnd(isl231180SLEpAuth.getAuthTermEnd());
                                            slEpAgentAuth.setAuthTermUnliimited(isl231180SLEpAuth.getAuthTermUnliimited());
                                            slEpAgentAuth.setUpdId(id);
                                            if (null != isl231180RsParam.getVer()) {
                                                slEpAgentAuth.setVer(isl231180RsParam.getVer() + 1);
                                            }
                                            super.modify(SqlId.SQL_ID_UPDATE_SLEPAGENTAUTH, slEpAgentAuth);
                                        }
                                    } else {
                                        throw new BusinessException("卖家ID为:" + isl231180SLEpAuth.getSlCode() + ",企业ID为:" + StringUtil.toSafeString(isl231180SLEpAuth.getProducerEpId()) + ",记录已存在");
                                    }
                                } else {
                                    /**新增代理及分销授权*/
                                    SlEpAgentAuth slEpAgentAuth = new SlEpAgentAuth();
                                    slEpAgentAuth.setSlCode(isl231180SLEpAuth.getSlCode());
                                    slEpAgentAuth.setProducerEpId(isl231180SLEpAuth.getProducerEpId());
                                    slEpAgentAuth.setContractNo(isl231180SLEpAuth.getContractNo());
                                    slEpAgentAuth.setAuthEpName(isl231180SLEpAuth.getAuthEpName());
                                    slEpAgentAuth.setAuthTermBegin(isl231180SLEpAuth.getAuthTermBegin());
                                    slEpAgentAuth.setAuthTermEnd(isl231180SLEpAuth.getAuthTermEnd());
                                    slEpAgentAuth.setAuthTermUnliimited(isl231180SLEpAuth.getAuthTermUnliimited());
                                    slEpAgentAuth.setCrtId(id);
                                    slEpAgentAuth.setVer(NumberConst.IntDef.INT_ONE);
                                    slEpAgentAuth.setDelFlg("0");
                                    super.save(SqlId.SQL_ID_SAVE_SLEPAGENTAUTH, slEpAgentAuth);
                                }
                            }
                        }
                        if ("2".equals(isl231180SLEpAuth.getFlag())) {
                            if ("1".equals(isl231180SLEpAuth.getDelFlg())) {
                                BaseParam param = new BaseParam();
                                param.setFilter("slCode", StringUtil.toSafeString(isl231180SLEpAuth.getSlCode()));
                                param.setFilter("epId", StringUtil.toSafeString(isl231180SLEpAuth.getProducerEpId()));
                                param.setFilter("delFlg", "1");
                                super.modify(SqlId.SQL_ID_DELETE_SLEPOEMAUTH, param);
                            } else if (StringUtil.isNullOrEmpty(isl231180SLEpAuth.getDelFlg()) || "0".equals(isl231180SLEpAuth.getDelFlg())) {
                                //查询记录是否存在
                                BaseParam param = new BaseParam();
                                param.setFilter("slCode", StringUtil.toSafeString(isl231180SLEpAuth.getSlCode()));
                                param.setFilter("epId", StringUtil.toSafeString(isl231180SLEpAuth.getProducerEpId()));
                                SlEpOemAuth slEpOemAuthTwo = super.findOne(SqlId.SQL_ID_QUERY_SLEPOEMAUTH, param);
                                if (null != slEpOemAuthTwo) {
                                    String delFlg = slEpOemAuthTwo.getDelFlg();
                                    if ("1".equals(delFlg)) {
                                        /**更新卖家代理及分销授权*/
                                        SlEpOemAuth slEpOemAuth = new SlEpOemAuth();
                                        slEpOemAuth.setSlCode(isl231180SLEpAuth.getSlCode());
                                        slEpOemAuth.setProducerEpId(isl231180SLEpAuth.getProducerEpId());
                                        slEpOemAuth.setContractNo(isl231180SLEpAuth.getContractNo());
                                        slEpOemAuth.setAuthEpName(isl231180SLEpAuth.getAuthEpName());
                                        slEpOemAuth.setAuthTermBegin(isl231180SLEpAuth.getAuthTermBegin());
                                        slEpOemAuth.setAuthTermEnd(isl231180SLEpAuth.getAuthTermEnd());
                                        slEpOemAuth.setAuthTermUnliimited(isl231180SLEpAuth.getAuthTermUnliimited());
                                        slEpOemAuth.setUpdId(id);
                                        if (null != isl231180RsParam.getVer()) {
                                            slEpOemAuth.setVer(isl231180RsParam.getVer() + 1);
                                        }
                                        super.modify(SqlId.SQL_ID_UPDATE_SLEPOEMAUTH, slEpOemAuth);
                                    } else {
                                        throw new BusinessException("卖家ID为:" + isl231180SLEpAuth.getSlCode() + ",企业ID为:" + StringUtil.toSafeString(isl231180SLEpAuth.getProducerEpId()) + ",记录已存在");
                                    }
                                } else {
                                    /**新增oem委托授权*/
                                    SlEpOemAuth slEpOemAuth = new SlEpOemAuth();
                                    slEpOemAuth.setSlCode(isl231180SLEpAuth.getSlCode());
                                    slEpOemAuth.setProducerEpId(isl231180SLEpAuth.getProducerEpId());
                                    slEpOemAuth.setContractNo(isl231180SLEpAuth.getContractNo());
                                    slEpOemAuth.setAuthEpName(isl231180SLEpAuth.getAuthEpName());
                                    slEpOemAuth.setAuthTermBegin(isl231180SLEpAuth.getAuthTermBegin());
                                    slEpOemAuth.setAuthTermEnd(isl231180SLEpAuth.getAuthTermEnd());
                                    slEpOemAuth.setAuthTermUnliimited(isl231180SLEpAuth.getAuthTermUnliimited());
                                    slEpOemAuth.setCrtId(id);
                                    slEpOemAuth.setVer(NumberConst.IntDef.INT_ONE);
                                    slEpOemAuth.setDelFlg("0");
                                    super.save(SqlId.SQL_ID_SAVE_SLEPOEMAUTH, slEpOemAuth);
                                }
                            }
                        }
                    }
                }


                /**企业管理团队================================================================================================================*/
                List<SlEpManager> slEpManagerList = isl231180RsParam.getSlEpManagerList();
                if (!CollectionUtils.isEmpty(slEpManagerList)) {
                    for (SlEpManager slEpManager : slEpManagerList) {
                        if ("1".equals(slEpManager.getDelFlg())) {
                            BaseParam param = new BaseParam();
                            param.setFilter("memberId", StringUtil.toSafeString(slEpManager.getMemberId()));
                            param.setFilter("epId", StringUtil.toSafeString(slEpManager.getEpId()));
                            param.setFilter("delFlg", "1");
                            super.modify(SqlId.SQL_ID_DELETE_SLEPMANAGER, param);
                        } else if (StringUtil.isNullOrEmpty(slEpManager.getDelFlg()) || "0".equals(slEpManager.getDelFlg())) {
                            /**新增企业管理团队信息*/
                            slEpManager.setEpId(slEpManager.getEpId());
                            Long memberId = this.commonLogic.maxId("SL_EP_MANAGER", "MEMBER_ID");
                            slEpManager.setMemberId(memberId);
                            slEpManager.setCrtId(id);
                            slEpManager.setVer(NumberConst.IntDef.INT_ONE);
                            slEpManager.setDelFlg("0");
                            super.save(SqlId.SQL_ID_SAVE_SLEPMANAGER, slEpManager);
                        }
                    }
                }


                /**企业电商团队====================================================================================================================*/
                List<SlEcTeam> slEcTeamList = isl231180RsParam.getSlEcTeamList();
                if (!CollectionUtils.isEmpty(slEcTeamList)) {
                    for (SlEcTeam slEcTeam : slEcTeamList) {
                        if ("1".equals(slEcTeam.getDelFlg())) {
                            BaseParam param = new BaseParam();
                            param.setFilter("memberId", StringUtil.toSafeString(slEcTeam.getMemberId()));
                            param.setFilter("slCode", StringUtil.toSafeString(slEcTeam.getSlCode()));
                            param.setFilter("delFlg", "1");
                            super.modify(SqlId.SQL_ID_DELETE_SLECTEAM, param);
                        } else if (StringUtil.isNullOrEmpty(slEcTeam.getDelFlg()) || "0".equals(slEcTeam.getDelFlg())) {
                            /**新增操作*/
                            slEcTeam.setSlCode(slEcTeam.getSlCode());
                            Long memberId = this.commonLogic.maxId("SL_EC_TEAM", "MEMBER_ID");
                            slEcTeam.setMemberId(memberId.intValue());
                            slEcTeam.setDelFlg("0");
                            slEcTeam.setCrtId(id);
                            slEcTeam.setVer(NumberConst.IntDef.INT_ONE);
                            super.save(SqlId.SQL_ID_SAVE_SLECTEAM, slEcTeam);
                        }
                    }
                }
                /**=================================================企业检测设备===================================================================*/
                List<SlEpDd> slEpDdList = isl231180RsParam.getSlEpDdList();
                if (!CollectionUtils.isEmpty(slEpDdList)) {
                    for (SlEpDd slEpDd : slEpDdList) {
                        if ("1".equals(slEpDd.getDelFlg())) {
                            BaseParam param = new BaseParam();
                            param.setFilter("ddId", StringUtil.toSafeString(slEpDd.getDdId()));
                            param.setFilter("epId", StringUtil.toSafeString(slEpDd.getEpId()));
                            param.setFilter("delFlg", "1");
                            super.modify(SqlId.SQL_ID_DELETE_SLEPDD, param);
                        } else if (StringUtil.isNullOrEmpty(slEpDd.getDelFlg()) || "0".equals(slEpDd.getDelFlg())) {
                            /**新增操作*/
                            slEpDd.setEpId(slEpDd.getEpId());
                            Long ddId = this.commonLogic.maxId("sl_ep_dd", "DD_ID");
                            slEpDd.setDdId(ddId);
                            slEpDd.setDelFlg("0");
                            slEpDd.setCrtId(id);
                            slEpDd.setVer(NumberConst.IntDef.INT_ONE);
                            super.save(SqlId.SQL_ID_SAVE_SL_EPDD, slEpDd);
                        }
                    }
                }
            }
        } else {
            //修改
            /**===================================================修改卖家账号信息====================================================*/
            SlAccount slAccount = isl231180RsParam.getSlAccount();
            if (null != slAccount) {
                //1.如果用戶帐号和密码不为空，查询账号是否存在
                BaseParam base = new BaseParam();
                base.setFilter("slAccount", slAccount.getSlAccount());
                SlAccount slAccount1 = super.findOne(SqlId.SQL_ID_FIND_SLACCOUNTIFEXIST, base);
                //1.1如果账号存在，则更新
                if (null != slAccount1) {
                    /**更新操作*/
                    slAccount.setUpdId(isl231180RsParam.getLoginId());
                    if (null != isl231180RsParam.getVer()) {
                        slAccount.setVer(isl231180RsParam.getVer() + 1);
                    }
                    super.modify(SqlId.SQL_ID_UPDATE_SLACCOUNT, slAccount);
                } else {
                    throw new BusinessException("卖家账户不存在!");
                }
            }


            /**===========================================修改卖家基本信息=============================================================*/
            SlSeller slSeller = isl231180RsParam.getSlSeller();
            if (null != slSeller) {
                BaseParam base = new BaseParam();
                base.setFilter("slAccount", slSeller.getSlAccount());
                SlSeller slSellerList = super.findOne(SqlId.SQL_ID_FIND_SLSELLERLIST, base);
                if (null!=slSellerList) {
                    throw new BusinessException("该账号卖家基本信息不存在，无法更新!");
                }
                /**更新操作*/
                slSeller.setUpdId(id);
                if (null != isl231180RsParam.getVer()) {
                    slSeller.setVer(isl231180RsParam.getVer() + 1);
                }
                String slCodeDis = this.sL241103001Logic.findAccount(slSeller.getSlMainClass().toString(), slSeller.getCityCode(), slSeller.getSlConFlg());
                //生成卖家生产商编码
                //根据区划和国际查询生产商编码
                slSeller.setSlCodeManufacture(this.sL241103001Logic.findSlCodeManufacture(slSeller.getCityCode(), slSeller.getSlConFlg()));
                //二级经营类型
                BaseParam baseParam = new BaseParam();
                baseParam.setFilter("cityCode", slSeller.getCityCode());
                baseParam.setFilter("slConFlg", slSeller.getSlConFlg());
                //获取大区编码
                MdProvince mdProvince = this.sL241103001Logic.findProvince(slSeller.getProvinceCode());
                String areaCode = this.sL241103001Logic.findAreaCode(mdProvince.getAreaId());
                slSeller.setAreaCode(areaCode);
                MdCity mdCity = this.sL241103001Logic.findCity(slSeller.getCityCode());
                //获取物流区编码
                String lgcsAreaCode = this.sL241103001Logic.findLgcsAreaCode(mdCity.getLgcsAreaId());
                slSeller.setLgcsAreaCode(lgcsAreaCode);
                if ("1".equals(slSeller.getSelfFlg())) {
                    baseParam.setFilter("selfFlg", "1");
                    slSeller.setSlCodeSelf(this.sL241103001Logic.findSlCodeOther(baseParam));
                    baseParam.getFilterMap().remove("selfFlg");
                }
                if ("1".equals(slSeller.getAgentFlg())) {
                    baseParam.setFilter("agentFlg", "1");
                    slSeller.setSlCodeAgent(this.sL241103001Logic.findSlCodeOther(baseParam));
                    baseParam.getFilterMap().remove("agentFlg");
                }
                if ("1".equals(slSeller.getOemFlg())) {
                    baseParam.setFilter("oemFlg", "1");
                    slSeller.setSlCodeOem(this.sL241103001Logic.findSlCodeOther(baseParam));
                    baseParam.getFilterMap().remove("oemFlg");
                }
                slSeller.setSlCodeDis(slCodeDis);
                /**查询该卖家编码下的slseller信息，判断用户的市区编码是否发生变化，发生变化  将其存储到履历表中并且更新，没有发生变化 直接更新操作*/
                SlSellerHis slSellerHis = this.sL24110102Logic.findSlSellerBySlCode(slSeller.getSlCode());
                if (!slSeller.getCityCode().equals(slSellerHis.getCityCode())) {
                    Long hisId = this.commonLogic.maxId("SL_SELLER_HIS", "HIS_ID");
                    slSellerHis.setHisId(hisId);
                    this.sL24110102Logic.saveHis(slSellerHis);
                }
                /**更新seller到数据库*/
                super.modify(SqlId.SQL_ID_UPDATE_SLSELLER, slSeller);
                isl231180RsResult.setSlCode(slSeller.getSlCode());
            }

            /**==============================================更新卖家产品类别信息====================================================*/

            /*List<SlPdClasses> slPdClassesLists = isl231180RsParam.getPdClassesCodeList();
            if(!CollectionUtils.isEmpty(slPdClassesLists)){
                for (SlPdClasses slPdClasses : slPdClassesLists) {
                    BaseParam param = new BaseParam();
                    param.setFilter("slCode", slPdClasses.getSlCode());
                    int num = super.getCount(SqlId.SQL_ID_FIND_SLPDCLASSESSLCODE, param);
                    if (num <= 0) {
                        throw new BusinessException("卖家产品类别信息不存在，无法更新!");
                    } else {

                        slPdClasses.setUpdId(id);
                        super.modify(SqlId.SQL_ID_UPDATE_SLPDCLASSES, slPdClasses);
                    }
                }
            }*/

            /**获取传入值*/
            List<SlPdClasses> slPdClassesLists = isl231180RsParam.getPdClassesCodeList();
            /**搜集用户传入的所有的资质证照ID*/
            List<Long> certIdList = new ArrayList<Long>();
            if (null != isl231180RsParam.getCertInfoList()) {
                for (ISL231127CertInfoList isl231127CertInfoList : isl231180RsParam.getCertInfoList()) {
                    Long certId = isl231127CertInfoList.getCertId();
                    certIdList.add(certId);
                }
            }
            if (!CollectionUtils.isEmpty(slPdClassesLists)) {
                int i = 0;
                for (SlPdClasses slPdClasse : slPdClassesLists) {
                    i++;
                    /**根据主键查询该信息是否已经存在，如果已经存在，提示存在该信息，没有存在插入数据*/
                   /*  BaseParam base = new BaseParam();
                    base.setFilter("slCode", slPdClasse.getSlCode());
                    base.setFilter("pdClassesCode", slPdClasse.getPdClassesCode());
                    base.setFilter("machiningCode", slPdClasse.getMachiningCode());
                    List<SlPdClasses> slPdClassesList = super.findList(SqlId.SQL_ID_FIND_SLPDCLASSES, base);
                    if (slPdClassesList.size() > 0) {
                        throw new BusinessException("录入的产品类别信息已经存在");
                    }*/
                    BaseParam base = new BaseParam();
                    base.setFilter("slCode", slPdClasse.getSlCode());
                    base.setFilter("pdClassesCode", slPdClasse.getPdClassesCode());
                    base.setFilter("machiningCode", slPdClasse.getMachiningCode());
                    BaseParam baseparams = new BaseParam();
                    baseparams.setFilter("slCode", slPdClasse.getSlCode());
                    int count = super.getCount(SqlId.SQL_ID_FIND_QUERYONESLCODE, baseparams);
                    if (count > 0) {
                        /**根据产品类型和加工程度编码，查询用户必须具备的certID,看用户传入的certId是否包含所有的必须具备资质，包含正常执行，不包含，提示用户*/
                        List<SlMstPdCert> slMstPdCerts = super.findList(SqlId.SQL_ID_FIND_CERTID, base);
                        /**根据产品类型及加工程度。必须的资质*/
                        List<Long> certIds = new ArrayList<Long>();
                        if (null != slMstPdCerts) {
                            for (SlMstPdCert slMstPdCert : slMstPdCerts) {
                                Long certId = slMstPdCert.getCertId();
                                certIds.add(certId);
                            }
                        }
                        if (!certIdList.containsAll(certIds)) {
                            throw new BusinessException("对不起，您输入的证照不全，无法完成注册");
                        }
                        BaseParam param = new BaseParam();
                        param.setFilter("slCode", slPdClasse.getSlCode());
                        int counts = super.getCount(SqlId.SQL_ID_FIND_QUERYSLPDCLASS, param);
                        if (counts > 0 && i == 1) {
                            super.remove(SqlId.SQL_ID_DELETE_SLPDCLASS, param);
                        }
                        slPdClasse.setSlCode(slPdClasse.getSlCode());
                        slPdClasse.setCrtId(id);
                        slPdClasse.setDelFlg("0");
                        slPdClasse.setVer(NumberConst.IntDef.INT_ONE);
                        super.save(SqlId.SQL_ID_SAVE_SLPDCLASSES, slPdClasse);
                    } else {
                        throw new BusinessException("卖家ID为:" + slPdClasse.getSlCode() + "的不存在");
                    }
                }
            }


            /**===========================================企业基本资质更新==========================================================*/
            SlEnterpriseBean slEnterprise = isl231180RsParam.getSlEnterprise();
            if (null != slEnterprise) {
                BaseParam baseParam = new BaseParam();
                baseParam.setFilter("epId", StringUtil.toSafeString(slEnterprise.getEpId()));
                List<SlEnterprise> slEnterpriseList = super.findList(SqlId.SQL_ID_FIND_SLENTERPRISE, baseParam);
                if (slEnterpriseList.size() <= 0) {
                    throw new BusinessException("企业基本资质不存在,无法添加");
                }
                /**更新操作*/
                slEnterprise.setUpdId(id);
                if (null != isl231180RsParam.getVer()) {
                    slEnterprise.setVer(isl231180RsParam.getVer() + 1);
                }
                this.sl24110102Logic.updateEp(slEnterprise);
                isl231180RsResult.setEpId(slEnterprise.getEpId());
            }

            /**=====================================================企业专业资质更新===========================================================*/
            List<ISL231127CertInfoList> certInfoList = isl231180RsParam.getCertInfoList();
            if (!CollectionUtils.isEmpty(certInfoList)) {
                for (ISL231127CertInfoList isl231127CertInfoList : certInfoList) {
                    List<SlEpCertItem> itemList = isl231127CertInfoList.getCertItemList();
                    if (null != itemList && itemList.size() > 0) {
                        for (SlEpCertItem slEpCertItem : itemList) {
                            slEpCertItem.setEpId(isl231127CertInfoList.getEpId());
                            slEpCertItem.setCertId(isl231127CertInfoList.getCertId());
                            slEpCertItem.setUpdId(id);
                            if (null != isl231180RsParam.getVer()) {
                                slEpCertItem.setVer(isl231180RsParam.getVer() + 1);
                                super.modify(SqlId.SQL_ID_UPDATE_SLEPCERTITEM, slEpCertItem);
                            }
                        }
                    } else {
                        throw new BusinessException("更新操作失败，证照项目信息为空");
                    }
                }
            }

            /**===============================================企业荣誉添加========================================================*/

            List<SlEpHonor> slEpHonorList = isl231180RsParam.getSlEpHonorList();
            if (!CollectionUtils.isEmpty(slEpHonorList)) {
                for (SlEpHonor slEpHonor : slEpHonorList) {
                    /**当企业ID和荣誉ID不为空是时，执行更新操作*/
                    slEpHonor.setUpdId(id);
                    if (null != isl231180RsParam.getVer()) {
                        slEpHonor.setVer(isl231180RsParam.getVer() + 1);
                    }
                    this.sl2411010401Logic.updateEpHonor(slEpHonor);
                }
            }

            /**===============================================企业产品品牌 企业产品品牌荣誉更新==================================================================*/
            List<ISL231180SlEpBrandList> slEpBrandList = isl231180RsParam.getSlEpBrandList();
            if (null != slEpBrandList && slEpBrandList.size() > 0) {
                for (ISL231180SlEpBrandList isl231180SlEpBrandList : slEpBrandList) {
                    if (null != isl231180SlEpBrandList.getEpId() && null != isl231180SlEpBrandList.getBrandId()) {
                        /**更新操作企业产品品牌*/
                        SlEpBrand slEpBrand = new SlEpBrand();
                        slEpBrand.setEpId(isl231180SlEpBrandList.getEpId().longValue());
                        slEpBrand.setBrandId(isl231180SlEpBrandList.getBrandId().longValue());
                        slEpBrand.setBrandName(isl231180SlEpBrandList.getBrandName());
                        slEpBrand.setBrandNo(isl231180SlEpBrandList.getBrandNo());
                        slEpBrand.setBrandTermBegin(isl231180SlEpBrandList.getBrandTermBegin());
                        slEpBrand.setBrandTermEnd(isl231180SlEpBrandList.getBrandTermEnd());
                        slEpBrand.setBrandClass(isl231180SlEpBrandList.getBrandClass());
                        slEpBrand.setUpdId(id);
                        if (null != isl231180RsParam.getVer()) {
                            slEpBrand.setVer(isl231180RsParam.getVer() + 1);
                        }
                        //更新企业产品品牌
                        super.modify(SqlId.SQL_ID_UPDATE_SLEPBRAND, slEpBrand);
                        //更新卖家产品品牌 自有的品牌发生更改有，由于是自有的品牌，可以根据epID查询出slCode,在根据联合主键进行更新操作
                        BaseParam params = new BaseParam();
                        params.setFilter("epId", isl231180SlEpBrandList.getEpId().toString());
                        SlSeller slSeller1 = super.findOne(SqlId.SQL_ID_FIND_SLCODE, params);
                        if (null != slSeller1) {
                            SlPdBrand slPdBrand = new SlPdBrand();
                            slPdBrand.setSlCode(slSeller1.getSlCode());
                            slPdBrand.setBrandId(isl231180SlEpBrandList.getBrandId().longValue());
                            slPdBrand.setBrandEpId(isl231180SlEpBrandList.getEpId().longValue());
                            slPdBrand.setBrandName(isl231180SlEpBrandList.getBrandName());
                            slPdBrand.setBrandType(NumberConst.IntDef.INT_ONE);
                            slPdBrand.setTermBegin(isl231180SlEpBrandList.getBrandTermBegin());
                            slPdBrand.setTermEnd(isl231180SlEpBrandList.getBrandTermEnd());
                            slPdBrand.setBrandClass(isl231180SlEpBrandList.getBrandClass());
                            slPdBrand.setUpdId(id);
                            if (null != isl231180RsParam.getVer()) {
                                slPdBrand.setVer(isl231180RsParam.getVer() + 1);
                            }
                            super.modify(SqlId.SQL_ID_UPDATE_SLSELFPDBRAND, slPdBrand);
                        }
                        //企业产品品牌荣誉
                        List<SlEpBrandHonor> slEpBrandHonorList = isl231180SlEpBrandList.getSlEpBrandHonorList();
                        if (null != slEpBrandHonorList && slEpBrandHonorList.size() > 0) {
                            for (SlEpBrandHonor slEpBrandHonor : slEpBrandHonorList) {
                                if (null != slEpBrandHonor.getEpId() && null != slEpBrandHonor.getBrandId() && null != slEpBrandHonor.getHonorId()) {
                                    /**更新企业产品品牌荣誉*/
                                    slEpBrandHonor.setUpdId(id);
                                    if (null != isl231180RsParam.getVer()) {
                                        slEpBrandHonor.setVer(isl231180RsParam.getVer() + 1);
                                    }
                                    super.modify(SqlId.SQL_ID_UPDATE_SLEPBRANDHONOR, slEpBrandHonor);
                                }
                            }
                        }
                    }
                }
            }
            /**====================================================卖家产品品牌更新============================================================*/

            List<ISlPdBrand> slPdBrandList = isl231180RsParam.getSlPdBrandList();
            /**防止空指针异常做判断*/
            if (null != slPdBrandList && slPdBrandList.size() > 0) {
                for (ISlPdBrand slPdBrand : slPdBrandList) {
                    //在保存企业产品品牌的时候已经保存了该企业的所有品牌到卖家产品品牌，现在添加的是别的企业的产品品牌,brandId必须存在
                    if (null != slPdBrand.getBrandEpId() && null != slPdBrand.getBrandId()) {
                        BaseParam baseParams = new BaseParam();
                        baseParams.setFilter("brandEpId", slPdBrand.getBrandEpId().toString());
                        baseParams.setFilter("brandId", slPdBrand.getBrandId().toString());
                        //查询对应企业下的企业品牌ID是否存在，不存在就报错
                        List<SlEpBrand> slEpBrands = super.findList(SqlId.SQL_ID_FIND_SLEPBRAND, baseParams);
                        if (null == slEpBrands || slEpBrands.size() == 0) {
                            throw new BusinessException("在卖家产品品牌增加别的企业的品牌时，录入了不存在的企业产品品牌");
                        }
                        //查询是否传入了slCode,如果传入了，更新操作，没有传入，新增操作
                        if (!StringUtil.isNullOrEmpty(slPdBrand.getSlCode())) {
                            BaseParam paramTwo = new BaseParam();
                            paramTwo.setFilter("slCode", slPdBrand.getSlCode());
                            paramTwo.setFilter("brandEpId", slPdBrand.getBrandEpId().toString());
                            paramTwo.setFilter("brandId", slPdBrand.getBrandId().toString());
                            //根据传入的数据查询数据库中是否已经存在，存在更新，不存在报错
                            SlPdBrand slPdBrand1 = super.findOne(SqlId.SQL_ID_FIND_SLPDBRANDIFEXIST, paramTwo);
                            if (null != slPdBrand1) {
                                /**更新操作*/
                                slPdBrand.setUpdId(id);
                                if (null != isl231180RsParam.getVer()) {
                                    slPdBrand.setVer(isl231180RsParam.getVer() + 1);
                                }
                                super.modify(SqlId.SQL_ID_UPDATE_SLPDBRAND, slPdBrand);
                            } else {
                                throw new BusinessException("没有查询到您输入的卖家产品品牌信息");
                            }
                        }
                    }
                }
            }

            /**=====================================================企业车间================================================================*/

            List<SlEpWorkshop> slEpWorkshopList = isl231180RsParam.getSlEpWorkshopList();
            if (null != slEpWorkshopList && slEpWorkshopList.size() > 0) {
                for (SlEpWorkshop slEpWorkshop : slEpWorkshopList) {
                    if (null != slEpWorkshop.getEpId() && null != slEpWorkshop.getWorkshopId()) {
                        /**更新操作企业车间*/
                        slEpWorkshop.setUpdId(id);
                        if (null != isl231180RsParam.getVer()) {
                            slEpWorkshop.setVer(isl231180RsParam.getVer() + 1);
                        }
                        this.sl2411010501Logic.updateSlEpWorkshop(slEpWorkshop);
                    }
                }
            }
            /**===================================================企业生产能力===========================================================*/
            SlEpCap slEpCap = isl231180RsParam.getSlEpCap();
            if (null != slEpCap) {
                if (null != slEpCap.getEpId()) {
                    /**更新操作*/
                    slEpCap.setUpdId(id);
                    if (null != isl231180RsParam.getVer()) {
                        slEpCap.setVer(isl231180RsParam.getVer() + 1);
                    }
                    super.modify(SqlId.SQL_ID_UPDATE_SLEPCAP, slEpCap);
                }
            }
            /**=============================================生产商更新=========================================================================*/
            List<ISL231180SLEpAuth> isl231180SLEpAuthList = isl231180RsParam.getSlEpAuthList();
            if (null != isl231180SLEpAuthList && isl231180SLEpAuthList.size() > 0) {
                for (ISL231180SLEpAuth isl231180SLEpAuth : isl231180SLEpAuthList) {
                    BaseParam basepa = new BaseParam();
                    basepa.setFilter("epId", isl231180SLEpAuth.getProducerEpId().toString());
                    SlEnterprise slEnterprise1 = super.findOne(SqlId.SQL_ID_FIND_SLENTERPRISE, basepa);
                    if (null == slEnterprise1) {
                        throw new BusinessException("你录入的生产商_企业ID不存在");
                    }
                    /**当卖家编码存在时 则更新操作*/
                    if (!StringUtil.isNullOrEmpty(isl231180SLEpAuth.getSlCode())) {
                        /**更新操作*/
                        if (isl231180SLEpAuth.getFlag().equals("1")) {
                            /**更新卖家代理及分销授权*/
                            SlEpAgentAuth slEpAgentAuth = new SlEpAgentAuth();
                            slEpAgentAuth.setSlCode(isl231180SLEpAuth.getSlCode());
                            slEpAgentAuth.setProducerEpId(isl231180SLEpAuth.getProducerEpId());
                            slEpAgentAuth.setContractNo(isl231180SLEpAuth.getContractNo());
                            slEpAgentAuth.setAuthEpName(isl231180SLEpAuth.getAuthEpName());
                            slEpAgentAuth.setAuthTermBegin(isl231180SLEpAuth.getAuthTermBegin());
                            slEpAgentAuth.setAuthTermEnd(isl231180SLEpAuth.getAuthTermEnd());
                            slEpAgentAuth.setAuthTermUnliimited(isl231180SLEpAuth.getAuthTermUnliimited());
                            slEpAgentAuth.setUpdId(id);
                            if (null != isl231180RsParam.getVer()) {
                                slEpAgentAuth.setVer(isl231180RsParam.getVer() + 1);
                            }
                            super.modify(SqlId.SQL_ID_UPDATE_SLEPAGENTAUTH, slEpAgentAuth);
                        }
                        if (isl231180SLEpAuth.getFlag().equals("2")) {
                            /**更新卖家代理及分销授权*/
                            SlEpOemAuth slEpOemAuth = new SlEpOemAuth();
                            slEpOemAuth.setSlCode(isl231180SLEpAuth.getSlCode());
                            slEpOemAuth.setProducerEpId(isl231180SLEpAuth.getProducerEpId());
                            slEpOemAuth.setContractNo(isl231180SLEpAuth.getContractNo());
                            slEpOemAuth.setAuthEpName(isl231180SLEpAuth.getAuthEpName());
                            slEpOemAuth.setAuthTermBegin(isl231180SLEpAuth.getAuthTermBegin());
                            slEpOemAuth.setAuthTermEnd(isl231180SLEpAuth.getAuthTermEnd());
                            slEpOemAuth.setAuthTermUnliimited(isl231180SLEpAuth.getAuthTermUnliimited());
                            slEpOemAuth.setUpdId(id);
                            if (null != isl231180RsParam.getVer()) {
                                slEpOemAuth.setVer(isl231180RsParam.getVer() + 1);
                            }
                            super.modify(SqlId.SQL_ID_UPDATE_SLEPOEMAUTH, slEpOemAuth);
                        }
                    }
                }
            }

            /**企业管理团队================================================================================================================*/
            List<SlEpManager> slEpManagerList = isl231180RsParam.getSlEpManagerList();
            if (null != slEpManagerList && slEpManagerList.size() > 0) {
                for (SlEpManager slEpManager : slEpManagerList) {
                    if (null != slEpManager.getEpId() && null != slEpManager.getMemberId()) {
                        /**更新企业管理团队*/
                        slEpManager.setUpdId(id);
                        if (null != isl231180RsParam.getVer()) {
                            slEpManager.setVer(isl231180RsParam.getVer() + 1);
                        }
                        this.sl24110108Logic.updateSlEpManagerPort(slEpManager);
                    }
                }
            }

            /**企业电商团队====================================================================================================================*/
            List<SlEcTeam> slEcTeamList = isl231180RsParam.getSlEcTeamList();
            if (null != slEcTeamList && slEcTeamList.size() > 0) {
                for (SlEcTeam slEcTeam : slEcTeamList) {
                    if (null != slEcTeam.getSlCode() && null != slEcTeam.getMemberId()) {
                        /**更新操作*/
                        slEcTeam.setUpdId(id);
                        if (null != isl231180RsParam.getVer()) {
                            slEcTeam.setVer(isl231180RsParam.getVer() + 1);
                        }
                        this.sl24110109Logic.updateSLEcTeamPort(slEcTeam);
                    }
                }
            }
            /**=================================================企业监测设备===================================================================*/
            List<SlEpDd> slEpDdList = isl231180RsParam.getSlEpDdList();
            if (null != slEpDdList && slEpDdList.size() > 0) {
                for (SlEpDd slEpDd : slEpDdList) {
                    if (null != slEpDd.getEpId() && null != slEpDd.getDdId()) {
                        /**更新操作*/
                        slEpDd.setUpdId(id);
                        if (null != isl231180RsParam.getVer()) {
                            slEpDd.setVer(isl231180RsParam.getVer() + 1);
                        }
                        super.modify(SqlId.SQL_ID_UPDATE_SL_EPDD, slEpDd);
                    }
                }
            }
        }
        return isl231180RsResult;
    }
}
