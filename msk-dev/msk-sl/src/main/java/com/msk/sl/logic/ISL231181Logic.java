package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.*;
import com.msk.core.entity.SlAccount;
import com.msk.core.entity.SlEpAgentAuth;
import com.msk.core.entity.SlEpHonor;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cx on 2016/2/23.
 */
@Service
public class ISL231181Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private SL241103001Logic SL241103001Logic;

    @Autowired
    private SL24110100Logic sL24110100Logic;
    @Autowired
    private SL241103Logic sl241103Logic;
    /**
     * SQL ID
     */
    interface SqlId{
        String SQL_ID_FIND_QUERY_EPAGENT_AUTH = "querySlEpAgentAuth";
        String SQL_ID_FIND_QUERY_SLEPMANAGER = "querySlEpManager";
        String SQL_ID_FIND_QUERY_SLPDCLASSES = "querySlPdClasses";
        String SQL_ID_FIND_QUERY_SLEPBRANDHONOR = "queryslEpBrandHonor";
        String SQL_ID_FIND_QUERY_SLEPBRAND = "queryslEpBrand";
        String SQL_ID_FIND_QUERY_SLPDBRAND = "querySlPdBrand";
        String SQL_ID_FIND_QUERY_SLECTEAM = "querySlEcTeam";
        String SQL_ID_FIND_QUERY_SLEPCERT = "querySlEpCert";
        String SQL_ID_FIND_QUERY_SLEPCERT_ITEM = "querySlEpCertItem";
        String SQL_ID_FIND_QUERY_REGEGION ="queryRegion";
        String SQL_ID_FIND_QUERY_MDAREA = "queryMdArea";
        String SQL_ID_FIND_QUERY_MDPROVINCE = "queryMdProvince";
        String SQL_ID_FIND_QUERY_MDCITY = "queryMdCity";
        String SQL_ID_FIND_QUERY_MDDISTRICT = "queryMdDistrict";
        String SQL_ID_FIND_QUERY_MDLOINSTICSAREA = "queryMdLogisticsArea";
    }
    /**
     * @param param param
     * @return
     */
    public ISL231181Result findAllDate(RsRequest<ISL231181RsParam> param){
        /*//卖家基本信息
        SlSeller slSeller = this.sL24110100Logic.findSlByAc(param.getParam().getSlAccount());*/
/*        ISL231181RegionParam slSellerParam=new ISL231181RegionParam();
        if(null!=slSeller){
            slSellerParam.setSlCode(slSeller.getSlCode());
            //卖家账号
            slSellerParam.setSlAccount(slSeller.getSlAccount());
            //卖家编码
            slSellerParam.setSlCodeDis(slSeller.getSlCodeDis());
            //生产国籍
            slSellerParam.setSlConFlg(slSeller.getSlConFlg());
            //企业ID
            slSellerParam.setEpId(slSeller.getEpId());
            //卖家主分类
            slSellerParam.setSlMainClass(slSeller.getSlMainClass());
            //神农客标志
            slSellerParam.setSnkFlg(slSeller.getSnkFlg());
            //自产型卖家标志
            slSellerParam.setSelfFlg(slSeller.getSelfFlg());
            //代理型卖家标志
            slSellerParam.setAgentFlg(slSeller.getAgentFlg());
            //OEM型卖家标志
            slSellerParam.setOemFlg(slSeller.getOemFlg());
            //买手型卖家标志
            slSellerParam.setBuyerFlg(slSeller.getBuyerFlg());
            //神农客贯标审核
            slSellerParam.setSqaStatus(slSeller.getSqaStatus());
            //卖家分销资格
            slSellerParam.setDistQua(slSeller.getDistQua());
            //卖家开店资格
            slSellerParam.setShopQua(slSeller.getShopQua());
            //微信号码
            slSellerParam.setMemo1(slSeller.getMemo1());
            //QQ号码
            slSellerParam.setMemo2(slSeller.getMemo2());
            //邮箱
            slSellerParam.setMemo3(slSeller.getMemo3());
            //固定电话
            slSellerParam.setMemo4(slSeller.getMemo4());
            //传真号
            slSellerParam.setMemo5(slSeller.getMemo5());
            //买手类型
            slSellerParam.setMemo6(slSeller.getMemo6());
            //备用字段7
            slSellerParam.setMemo7(slSeller.getMemo7());
            //备用字段8
            slSellerParam.setMemo8(slSeller.getMemo8());
            //备用字段9
            slSellerParam.setMemo9(slSeller.getMemo9());
            //备用字段10
            slSellerParam.setMemo10(slSeller.getMemo10());
            //备用字段11
            slSellerParam.setMemo11(slSeller.getMemo11());
            //备用字段12
            slSellerParam.setMemo12(slSeller.getMemo12());
            //备用字段13
            slSellerParam.setMemo13(slSeller.getMemo13());
            //备用字段14
            slSellerParam.setMemo14(slSeller.getMemo14());
            //备用字段15
            slSellerParam.setMemo15(slSeller.getMemo15());
            //备用字段16
            slSellerParam.setMemo16(slSeller.getMemo16());
            //备用字段17
            slSellerParam.setMemo17(slSeller.getMemo17());
            //备用字段18
            slSellerParam.setMemo18(slSeller.getMemo18());
            //备用字段19
            slSellerParam.setMemo19(slSeller.getMemo19());
            //备用字段20
            slSellerParam.setMemo20(slSeller.getMemo20());
        }else{
            throw new BusinessException("卖家信息不存在");
        }*/
        ISL231181Result isl231181Result=new ISL231181Result();
        SlAccount SlAccount =  this.SL241103001Logic.slAccountEntity2(param.getParam().getSlAccount());
        if(null!=SlAccount){
            //卖家基本信息
            SlSeller slSeller = this.sL24110100Logic.findSlByAc(param.getParam().getSlAccount());
            if(null!=slSeller){
                ISL231181RegionParam slSellerParam=new ISL231181RegionParam();
                slSellerParam.setSlCode(slSeller.getSlCode());
                //卖家账号
                slSellerParam.setSlAccount(slSeller.getSlAccount());
                //卖家编码
                slSellerParam.setSlCodeDis(slSeller.getSlCodeDis());
                //生产国籍
                slSellerParam.setSlConFlg(slSeller.getSlConFlg());
                //企业ID
                slSellerParam.setEpId(slSeller.getEpId());
                //卖家主分类
                slSellerParam.setSlMainClass(slSeller.getSlMainClass());
                //神农客标志
                slSellerParam.setSnkFlg(slSeller.getSnkFlg());
                //自产型卖家标志
                slSellerParam.setSelfFlg(slSeller.getSelfFlg());
                //代理型卖家标志
                slSellerParam.setAgentFlg(slSeller.getAgentFlg());
                //OEM型卖家标志
                slSellerParam.setOemFlg(slSeller.getOemFlg());
                //买手型卖家标志
                slSellerParam.setBuyerFlg(slSeller.getBuyerFlg());
                //神农客贯标审核
                slSellerParam.setSqaStatus(slSeller.getSqaStatus());
                //卖家分销资格
                slSellerParam.setDistQua(slSeller.getDistQua());
                //卖家开店资格
                slSellerParam.setShopQua(slSeller.getShopQua());
                //微信号码
                slSellerParam.setMemo1(slSeller.getMemo1());
                //QQ号码
                slSellerParam.setMemo2(slSeller.getMemo2());
                //邮箱
                slSellerParam.setMemo3(slSeller.getMemo3());
                //固定电话
                slSellerParam.setMemo4(slSeller.getMemo4());
                //传真号
                slSellerParam.setMemo5(slSeller.getMemo5());
                //买手类型
                slSellerParam.setMemo6(slSeller.getMemo6());
                //备用字段7
                slSellerParam.setMemo7(slSeller.getMemo7());
                //备用字段8
                slSellerParam.setMemo8(slSeller.getMemo8());
                //备用字段9
                slSellerParam.setMemo9(slSeller.getMemo9());
                //备用字段10
                slSellerParam.setMemo10(slSeller.getMemo10());
                //备用字段11
                slSellerParam.setMemo11(slSeller.getMemo11());
                //备用字段12
                slSellerParam.setMemo12(slSeller.getMemo12());
                //备用字段13
                slSellerParam.setMemo13(slSeller.getMemo13());
                //备用字段14
                slSellerParam.setMemo14(slSeller.getMemo14());
                //备用字段15
                slSellerParam.setMemo15(slSeller.getMemo15());
                //备用字段16
                slSellerParam.setMemo16(slSeller.getMemo16());
                //备用字段17
                slSellerParam.setMemo17(slSeller.getMemo17());
                //备用字段18
                slSellerParam.setMemo18(slSeller.getMemo18());
                //备用字段19
                slSellerParam.setMemo19(slSeller.getMemo19());
                //备用字段20
                slSellerParam.setMemo20(slSeller.getMemo20());
                String ep = StringUtil.toSafeString(slSeller.getEpId());
                String slCode = slSeller.getSlCode();
                //卖家账户信息
                //SlAccount SlAccount =  this.SL241103001Logic.slAccountEntity2(param.getParam().getSlAccount());
                //卖家产品类别
                BaseParam paramForm=new BaseParam();
                paramForm.setFilter("slCode",slCode);
                paramForm.setFilter("delFlg","0");
                List<SlPdClasses> slPdClassesList=super.findList(SqlId.SQL_ID_FIND_QUERY_SLPDCLASSES,paramForm);
                //企业基本资质
                SlEnterprise slEnterprise = this.sL24110100Logic.findEpById(ep);
                //查询企业荣誉信息
                List<SlEpHonor> slEpHonors = this.sL24110100Logic.findSlEpHonor(ep);
                //企业产品品牌信息
                BaseParam paramnine=new BaseParam();
                paramnine.setFilter("epId",ep);
                paramnine.setFilter("delFlg","0");
                List<SL2411030033Bean> sl2411030033BeanList = this.findList(SqlId.SQL_ID_FIND_QUERY_SLEPBRAND,paramnine);
                if(!CollectionUtils.isEmpty(sl2411030033BeanList) && sl2411030033BeanList.size()>0){
                    for (int i = 0; i < sl2411030033BeanList.size(); i++) {
                        SL2411030033Bean sl2411030033Bean=sl2411030033BeanList.get(i);
                        //企业产品品牌荣誉
                        BaseParam paramFive=new BaseParam();
                        paramFive.setFilter("epId",ep);
                        paramFive.setFilter("brandId",StringUtil.toSafeString(sl2411030033Bean.getBrandId()));
                        paramFive.setFilter("delFlg","0");
                        List<SlEpBrandHonor> slEpBrandHonorList=super.findList(SqlId.SQL_ID_FIND_QUERY_SLEPBRANDHONOR,paramFive);
                        sl2411030033Bean.setSlEpBrandHonorList(slEpBrandHonorList);
                    }
                }
                /*//企业产品品牌荣誉
                BaseParam paramFive=new BaseParam();
                paramFive.setFilter("epId",ep);
                List<SlEpBrandHonor> slEpBrandHonorList=super.findList(SqlId.SQL_ID_FIND_QUERY_SLEPBRANDHONOR,paramFive);*/
                //企业生产能力
                SlEpCap slEpCap = this.sL24110100Logic.findSlEpCap(ep);
                //企业车间信息
                List<SlEpWorkshop> slEpWorkshops = this.sL24110100Logic.findSlEpWorkshop(ep);
                //生产商
                BaseParam paramTwo=new BaseParam();
                paramTwo.setFilter("slCode",slCode);
                paramTwo.setFilter("delFlg","0");
                List<SlEpAgentAuth> slEpAgentAuthList=super.findList(SqlId.SQL_ID_FIND_QUERY_EPAGENT_AUTH,paramTwo);
                //企业团队管理
                BaseParam paramThree=new BaseParam();
                paramThree.setFilter("epId",ep);
                paramThree.setFilter("delFlg","0");
                List<SlEpManager> slEpManagerList=super.findList(SqlId.SQL_ID_FIND_QUERY_SLEPMANAGER,paramThree);
                //卖家产品品牌
                BaseParam paramsex=new BaseParam();
                paramsex.setFilter("slCode",slCode);
                paramsex.setFilter("delFlg","0");
                List<SlPdBrand> slPdBrandList=super.findList(SqlId.SQL_ID_FIND_QUERY_SLPDBRAND,paramsex);
                //企业电商团队信息
                BaseParam paramSeven=new BaseParam();
                paramSeven.setFilter("slCode",slCode);
                paramSeven.setFilter("delFlg","0");
                List<SlEcTeam> slEcTeamList=super.findList(SqlId.SQL_ID_FIND_QUERY_SLECTEAM,paramSeven);
                //企业专业资质
                BaseParam paramEight=new BaseParam();
                paramEight.setFilter("epId",ep);
                paramEight.setFilter("delFlg","0");
                List<SlEpCertParam> slEpCertListTwo=new ArrayList<>();
                List<SlEpCertParam> slEpCertList=super.findList(SqlId.SQL_ID_FIND_QUERY_SLEPCERT,paramEight);
                for (int i = 0; i < slEpCertList.size(); i++) {
                    SlEpCertParam slEpCertParam=slEpCertList.get(i);
                    long epId=slEpCertParam.getEpId();
                    long certId=slEpCertParam.getCertId();
                    //企业证照项目信息
                    BaseParam paramNight=new BaseParam();
                    paramNight.setFilter("epId",StringUtil.toSafeString(epId));
                    paramNight.setFilter("certId",StringUtil.toSafeString(certId));
                    paramNight.setFilter("delFlg","0");
                    List<SlEpCertItem> slEpCertItemList=super.findList(SqlId.SQL_ID_FIND_QUERY_SLEPCERT_ITEM,paramNight);
                    slEpCertParam.setCertItemList(slEpCertItemList);
                    slEpCertListTwo.add(slEpCertParam);
                }
                //添加卖家产品类别
                isl231181Result.setPdClassesCodeList(slPdClassesList);
                //添加企业专业资质信息
                isl231181Result.setCertInfoList(slEpCertListTwo);
                //添加企业荣誉
                isl231181Result.setSlEpHonorList(slEpHonors);
                //添加企业产品品牌
                isl231181Result.setSlEpBrandList(sl2411030033BeanList);
                //添加企业产品品牌荣誉
                //isl231181Result.setSlEpBrandHonorList(slEpBrandHonorList);
                //添加卖家产品品牌
                isl231181Result.setSlPdBrandList(slPdBrandList);
                //添加企业车间
                isl231181Result.setSlEpWorkshopList(slEpWorkshops);
                //添加生产商
                isl231181Result.setSlEpAuthList(slEpAgentAuthList);
                //添加企业管理团队
                isl231181Result.setSlEpManagerList(slEpManagerList);
                //添加卖家电商团队
                isl231181Result.setSlEcTeamList(slEcTeamList);
                //卖家账号信息
                isl231181Result.setSlAccount(SlAccount);
                //企业基本资质
                isl231181Result.setSlEnterprise(slEnterprise);
                //企业生产能力
                isl231181Result.setSlEpCap(slEpCap);
                //大区编码
                slSellerParam.setAreaCode(slSeller.getAreaCode());
                BaseParam paramTen=new BaseParam();
                paramTen.setFilter("areaCode",slSeller.getAreaCode());
                paramTen.setFilter("provinceCode",slSeller.getProvinceCode());
                paramTen.setFilter("cityCode",slSeller.getCityCode());
                paramTen.setFilter("districtCode",slSeller.getDistrictCode());
                paramTen.setFilter("delFlg","0");
                ISL231181RegionParam isl231181RegionParam=super.findOne(SqlId.SQL_ID_FIND_QUERY_REGEGION,paramTen);
                //物流区编码
                slSellerParam.setLgcsAreaCode(slSeller.getLgcsAreaCode());
                //物流区编码名称
                BaseParam param5 = new BaseParam();
                param5.setFilter("lgcsAreaCode", slSeller.getLgcsAreaCode());
                param5.setFilter("delFlg","0");
                MdLogisticsArea mdLogisticsArea = super.findOne(SqlId.SQL_ID_FIND_QUERY_MDLOINSTICSAREA, param5);
                if(null!=mdLogisticsArea){
                    slSellerParam.setLgcsAreaName(StringUtil.toSafeString(mdLogisticsArea.getLgcsAreaName()));
                }
                if(null!=isl231181RegionParam){
                    //省编码
                    slSellerParam.setProvinceCode(slSeller.getProvinceCode());
                    //省编码名称
                    slSellerParam.setProvinceName(isl231181RegionParam.getProvinceName());
                    //地区编码
                    slSellerParam.setCityCode(slSeller.getCityCode());
                    //地区编码名称
                    slSellerParam.setCityName(isl231181RegionParam.getCityName());
                    //区编码
                    slSellerParam.setDistrictCode(slSeller.getDistrictCode());
                    //区编码名称
                    slSellerParam.setDistrictName(isl231181RegionParam.getDistrictName());
                }
                //卖家基本信息
                isl231181Result.setSlSeller(slSellerParam);
                //查询企业检测设备
                BaseParam params=new BaseParam();
                params.setFilter("epId",ep);
                params.setFilter("delFlg","0");
                List<SlEpDdBean> slEpDdBeanList=sl241103Logic.findEpEquipment(params);
                isl231181Result.setSlEpDdList(slEpDdBeanList);
            }else{
                throw new BusinessException("卖家基本信息不存在!");
            }
            /*
            //卖家账号
            isl231181Result.setSlAccount(SlAccount.getSlAccount());
            //登录手机号码
            isl231181Result.setSlTel(SlAccount.getSlTel());
            //卖家显示名称
            isl231181Result.setSlShowName(SlAccount.getSlShowName());
            //联系人姓名
            isl231181Result.setSlContact(SlAccount.getSlContact());
            //登录密码
            isl231181Result.setAccountPsd(SlAccount.getAccountPsd());
            //认证状态
            isl231181Result.setAuthStatus(SlAccount.getAuthStatus());
            //注册来源
            isl231181Result.setFromFlg(SlAccount.getFromFlg());
            //卖家编码
           isl231181Result.setSlCode(slSeller.getSlCode());
            //生产国籍
            isl231181Result.setSlConFlg(slSeller.getSlConFlg());
            //大区编码
            isl231181Result.setAreaCode(slSeller.getAreaCode());
            */
            //大区编码名称
            //大区编码
            /*slSellerParam.setAreaCode(slSeller.getAreaCode());
            BaseParam param1=new BaseParam();
            param1.setFilter("areaCode",slSeller.getAreaCode());
            MdArea mdArea=super.findOne(SqlId.SQL_ID_FIND_QUERY_MDAREA, param1);
            //物流区编码
            slSellerParam.setLgcsAreaCode(slSeller.getLgcsAreaCode());
            //物流区编码名称
            BaseParam param5 = new BaseParam();
            param5.setFilter("lgcsAreaCode", slSeller.getLgcsAreaCode());
            if(null!=mdArea){
                param5.setFilter("areaId",StringUtil.toSafeString(mdArea.getAreaId()));
                slSellerParam.setAreaName(StringUtil.toSafeString(mdArea.getAreaName()));
            }
            MdLogisticsArea mdLogisticsArea = super.findOne(SqlId.SQL_ID_FIND_QUERY_MDLOINSTICSAREA, param5);
            if(null!=mdLogisticsArea){
                slSellerParam.setLgcsAreaName(StringUtil.toSafeString(mdLogisticsArea.getLgcsAreaName()));
            }
            //省编码
            slSellerParam.setProvinceCode(slSeller.getProvinceCode());
            //省编码名称
            BaseParam param2 = new BaseParam();
            param2.setFilter("provinceCode", slSeller.getProvinceCode());
            if(null!=mdArea){
                param2.setFilter("areaId",StringUtil.toSafeString(mdArea.getAreaId()));
            }else{
                throw new BusinessException("大区编码:"+slSeller.getAreaCode()+",对应数据不存在");
            }
            MdProvince mdProvince = super.findOne(SqlId.SQL_ID_FIND_QUERY_MDPROVINCE, param2);
            //地区编码
            slSellerParam.setCityCode(slSeller.getCityCode());
            //地区编码名称
            BaseParam param3 = new BaseParam();
            param3.setFilter("cityCode", slSeller.getCityCode());
            if(null!=mdProvince){
                param3.setFilter("provinceId", StringUtil.toSafeString(mdProvince.getProvinceId()));
                slSellerParam.setProvinceName(StringUtil.toSafeString(mdProvince.getProvinceName()));
            }else{
                throw new BusinessException("省编码:"+slSeller.getProvinceCode()+",对应信息不存在");
            }
            MdCity mdCity = super.findOne(SqlId.SQL_ID_FIND_QUERY_MDCITY, param3);
            //区编码
            slSellerParam.setDistrictCode(slSeller.getDistrictCode());
            //区编码名称
            BaseParam param4 = new BaseParam();
            param4.setFilter("districtCode", slSeller.getDistrictCode());
            if(null!=mdCity) {
                param4.setFilter("cityId", StringUtil.toSafeString(mdCity.getCityId()));
                slSellerParam.setCityName(StringUtil.toSafeString(mdCity.getCityName()));
            }
            else{
                throw new BusinessException("地区编码:"+slSeller.getCityCode()+",对应信息不存在");
            }
            MdDistrict mdDistrict = super.findOne(SqlId.SQL_ID_FIND_QUERY_MDDISTRICT, param4);
            if(null!=mdDistrict){
                slSellerParam.setDistrictName(StringUtil.toSafeString(mdDistrict.getDistrictName()));
            }*/
            /*
            if(null!=slSeller){
                //企业ID
                isl231181Result.setEpId(slSeller.getEpId());
                //卖家主分类
                isl231181Result.setSlMainClass(slSeller.getSlMainClass());
                //神农客标志
                isl231181Result.setSnkFlg(slSeller.getSnkFlg());
                //自产型卖家标志
                isl231181Result.setSelfFlg(slSeller.getSelfFlg());
                //代理型卖家标志
                isl231181Result.setAgentFlg(slSeller.getAgentFlg());
                //OEM型卖家标志
                isl231181Result.setOemFlg(slSeller.getOemFlg());
                //买手型卖家标志
                isl231181Result.setBuyerFlg(slSeller.getBuyerFlg());
                //神农客贯标审核
                isl231181Result.setSqaStatus(slSeller.getSqaStatus());
                //卖家分销资格
                isl231181Result.setDistQua(slSeller.getDistQua());
                //卖家开店资格
                isl231181Result.setShopQua(slSeller.getShopQua());
                //微信号码
                isl231181Result.setMemo1(slSeller.getMemo1());
                //QQ号码
                isl231181Result.setMemo2(slSeller.getMemo2());
                //邮箱
                isl231181Result.setMemo3(slSeller.getMemo3());
                //固定电话
                isl231181Result.setMemo4(slSeller.getMemo4());
                //传真号
                isl231181Result.setMemo5(slSeller.getMemo5());
                //买手类型
                isl231181Result.setMemo6(slSeller.getMemo6());
                //备用字段7
                isl231181Result.setMemo7(slSeller.getMemo7());
                //备用字段8
                isl231181Result.setMemo8(slSeller.getMemo8());
                //备用字段9
                isl231181Result.setMemo9(slSeller.getMemo9());
                //备用字段10
                isl231181Result.setMemo10(slSeller.getMemo10());
                //备用字段11
                isl231181Result.setMemo11(slSeller.getMemo11());
                //备用字段12
                isl231181Result.setMemo12(slSeller.getMemo12());
                //备用字段13
                isl231181Result.setMemo13(slSeller.getMemo13());
                //备用字段14
                isl231181Result.setMemo14(slSeller.getMemo14());
                //备用字段15
                isl231181Result.setMemo15(slSeller.getMemo15());
                //备用字段16
                isl231181Result.setMemo16(slSeller.getMemo16());
                //备用字段17
                isl231181Result.setMemo17(slSeller.getMemo17());
                //备用字段18
                isl231181Result.setMemo18(slSeller.getMemo18());
                //备用字段19
                isl231181Result.setMemo19(slSeller.getMemo19());
                //备用字段20
                isl231181Result.setMemo20(slSeller.getMemo20());
            }
            if(null!=slEnterprise){
                //企业名称
                isl231181Result.setEpName(slEnterprise.getEpName());
                //三证合一营业执照标志
                isl231181Result.setLicType(slEnterprise.getLicType());
                //营业执照_名称
                isl231181Result.setLicName(slEnterprise.getLicName());
                //营业执照_注册号
                isl231181Result.setLicNo(slEnterprise.getLicNo());
                //营业执照_住所
                isl231181Result.setLicAddr(slEnterprise.getLicAddr());
                //营业执照_经营类型
                isl231181Result.setLicBusiType(slEnterprise.getLicBusiType());
                //营业执照_经营范围
                isl231181Result.setLicBusiScope(slEnterprise.getLicBusiScope());
                //营业执照_法人代表
                isl231181Result.setLicLegalPerson(slEnterprise.getLicLegalPerson());
                //营业执照_注册资本
                isl231181Result.setLicRegCapital(slEnterprise.getLicRegCapital());
                //营业执照_实收资本
                isl231181Result.setLicPaidinCapital(slEnterprise.getLicPaidinCapital());
                //营业执照_成立日期
                isl231181Result.setLicCrtDate(slEnterprise.getLicCrtDate());
                //营业执照_营业期限开始
                isl231181Result.setLicTermBegin(slEnterprise.getLicTermBegin());
                //营业执照_营业期限截止
                isl231181Result.setLicTermEnd(slEnterprise.getLicTermEnd());
                //营业执照_营业期限长期标志
                isl231181Result.setLicTermUnliimited(slEnterprise.getLicTermUnliimited());
                //税务登记证_税务登记证号
                isl231181Result.setTaxNo(slEnterprise.getTaxNo());
                //税务登记证_一般增值税纳税人资格认定编号
                isl231181Result.setTaxVatNo(slEnterprise.getTaxVatNo());
                //组织机构代码证_代码
                isl231181Result.setOrgNo(slEnterprise.getOrgNo());
                //组织机构代码证_有效期开始
                isl231181Result.setOrgTermBegin(slEnterprise.getOrgTermBegin());
                //组织机构代码证_有效期截止
                isl231181Result.setOrgTermEnd(slEnterprise.getOrgTermEnd());
                //银行开户许可证_法定代表人
                isl231181Result.setBalLegalPerson(slEnterprise.getBalLegalPerson());
                //银行开户许可证_开户银行
                isl231181Result.setBalBank(slEnterprise.getBalBank());
                //银行开户许可证_帐号
                isl231181Result.setBalAccount(slEnterprise.getBalAccount());
                //食品流通许可证_许可证编号
                isl231181Result.setFdlNo(slEnterprise.getFdlNo());
                //食品流通许可证_有效期开始
                isl231181Result.setFdlTermBegin(slEnterprise.getFdlTermBegin());
                //食品流通许可证_有效期截止
                isl231181Result.setFdlTermEnd(slEnterprise.getFdlTermEnd());
            }
            if(null!=slEpCap){
                //厂区_总资产
                isl231181Result.setFtyAsset(slEpCap.getFtyAsset());
                //厂区_注册资本
                isl231181Result.setFtyRegCapital(slEpCap.getFtyRegCapital());
                //厂区_占地面积
                isl231181Result.setFtyLandArea(slEpCap.getFtyLandArea());
                //厂区_厂房面积
                isl231181Result.setFtyFloorArea(slEpCap.getFtyFloorArea());
                //厂区_主要设备
                isl231181Result.setFtyEquipment(slEpCap.getFtyEquipment());
                //厂区_设计产能
                isl231181Result.setFtyDesignCap(slEpCap.getFtyDesignCap());
                //厂区_实际产能
                isl231181Result.setFtyActualCap(slEpCap.getFtyActualCap());
                //厂区_外贸销售占比
                isl231181Result.setFtyFtRate(slEpCap.getFtyFtRate());
                //厂区_直销占比
                isl231181Result.setFtyDsRate(slEpCap.getFtyDsRate());
                //厂区_代理销售占比
                isl231181Result.setFtyAsRate(slEpCap.getFtyAsRate());
                //库容概括_原料库容
                isl231181Result.setScapMaterial(slEpCap.getScapMaterial());
                //库容概括_成品库容
                isl231181Result.setScapProduct(slEpCap.getScapProduct());
                //实验室_面积
                isl231181Result.setLabArea(slEpCap.getLabArea());
                //实验室_功能
                isl231181Result.setLabFunction(slEpCap.getLabFunction());
                //实验室_投资
                isl231181Result.setLabInvestment(slEpCap.getLabInvestment());
                //实验室_人员
                isl231181Result.setLabMember(slEpCap.getLabMember());
                //检测设备_主要设备及用途
                isl231181Result.setDdEquipment(slEpCap.getDdEquipment());*/
        }else{
            throw new BusinessException("卖家账户不存在!");
        }
        return isl231181Result;
    }
}
