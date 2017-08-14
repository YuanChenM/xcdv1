package com.msk.sl.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.msk.core.entity.SlSeller;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.msk.core.bean.BaseParam;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.SL24110301Bean;
import com.msk.sl.bean.SL24110302Bean;
import com.msk.sl.bean.SL24110302_1Bean;
import com.msk.sl.bean.SL2411030301Bean;
import com.msk.sl.bean.SL2411030302Bean;
import com.msk.sl.bean.SL2411030303Bean;
import com.msk.sl.bean.SL24110303Bean;
import com.msk.sl.bean.SL24110304Bean;
import com.msk.sl.bean.SL24110306Bean;
import com.msk.sl.logic.SL241103Logic;

@Controller
@RequestMapping("SL24110333")
public class SL24110333Controller extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(SL241103Controller.class);
    @Autowired
    private SL241103Logic sl241103Logic;
    String selfFlg = null; // 自产性
    String proxyFlg = null;// 代理性
    String oemFlg = null;// OEM性

    @SuppressWarnings("null")
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(@RequestParam(required = false) String slCode, @RequestParam(required = false) String epId, Model mav) {
        BaseParam param = new BaseParam();
        param.setFilter("epId", epId);
        if (isDebug) {
            epId = "1";
            mav.addAttribute("epId", epId);
            SlSeller seller = new SlSeller();
            seller.setAgentFlg("1");
            seller.setOemFlg("1");
            seller.setSelfFlg("1");
            selfFlg = seller.getSelfFlg();// 自产性标识
            proxyFlg = seller.getAgentFlg();
            oemFlg = seller.getOemFlg();
            mav.addAttribute("selfFlg", selfFlg);
            mav.addAttribute("proxyFlg", proxyFlg);
            mav.addAttribute("oemFlg", oemFlg);
            // 企业基本资质调用
            SL24110301Bean sL24110301Bean = new SL24110301Bean();
            sL24110301Bean = this.slEnterprise(epId);
            logger.info("企业基本资质执行");
            mav.addAttribute("sL0301Bean", sL24110301Bean);
            // 企业专业资质审批调用
            List<SL24110302Bean> listEpCert = this.slEpCert(mav, slCode, epId);
            logger.info("企业专业资质审批执行");
            mav.addAttribute("listEpCert", listEpCert);
            // 企业基本能力描述
            logger.info("企业能力");
            SL24110303Bean dc = this.slAbilityDc(mav, slCode, epId);
            mav.addAttribute("SL24110303Bean", dc);
            // 企业生产车间、设备、产品工艺流程描述
            logger.info("企业生产车间、设备、产品工艺流程描述");
            SL24110304Bean slPdWorkShop = this.slPdWorkShop(mav, slCode, epId);
            mav.addAttribute("SL24110304Bean", slPdWorkShop);
            // 实验室等信息
            logger.info("实验室、检测设备、品控组织架构及质量控制系统图");
            SL2411030302Bean slLaboratory = this.slLaboratory(mav, slCode, epId);
            mav.addAttribute("SL2411030302Bean", slLaboratory);
            // 企业管理团队描述
            this.slTeamDs(mav, slCode, epId);
        } else {
            mav.addAttribute("epId", epId);
            SlSeller seller = sl241103Logic.findSlSeller(param);
            if (null == seller) {
                seller=new SlSeller();
                seller.setSelfFlg("0");// 自产性标识
                seller.setAgentFlg("0");
                seller.setOemFlg("0");
                throw new BusinessException("企业信息不存在!");
            }
            selfFlg = seller.getSelfFlg();// 自产性标识
            proxyFlg = seller.getAgentFlg();
            oemFlg = seller.getOemFlg();
            mav.addAttribute("slMainClass", seller.getSlMainClass());
            mav.addAttribute("selfFlg", selfFlg);
            mav.addAttribute("proxyFlg", proxyFlg);
            mav.addAttribute("oemFlg", oemFlg);
            // 企业基本资质调用
            SL24110301Bean sL24110301Bean = this.slEnterprise(epId);
            logger.info("企业基本资质执行");
            mav.addAttribute("sL0301Bean", sL24110301Bean);
            // 企业专业资质审批调用
            List<SL24110302Bean> listEpCert = this.slEpCert(mav, slCode, epId);
            logger.info("企业专业资质审批执行");
            mav.addAttribute("listEpCert", listEpCert);
            // 企业基本能力描述
            logger.info("企业能力");
            SL24110303Bean dc = this.slAbilityDc(mav, slCode, epId);
            mav.addAttribute("SL24110303Bean", dc);
            // 企业生产车间、设备、产品工艺流程描述
            logger.info("企业生产车间、设备、产品工艺流程描述");
            SL24110304Bean slPdWorkShop = this.slPdWorkShop(mav, slCode, epId);
            mav.addAttribute("SL24110304Bean", slPdWorkShop);
            // 实验室等信息
            logger.info("实验室、检测设备、品控组织架构及质量控制系统图");
            SL2411030302Bean slLaboratory = this.slLaboratory(mav, slCode, epId);
            mav.addAttribute("SL2411030302Bean", slLaboratory);
            // 企业管理团队描述
            this.slTeamDs(mav, slCode, epId);
        }
        return "sl/SL24110333";
    }

    /**
     * 查询企业基本资质*
     *
     * @return 企业基本资质
     *
     * @author pxg
     */
    public SL24110301Bean slEnterprise(String epId) {
        SL24110301Bean sl24110301Bean = new SL24110301Bean();
        if (isDebug) {
            sl24110301Bean = sl241103Logic.selectSlenterPrise();
            String crtDate = DateTimeUtil.formatDate("yyyy-MM-dd", sl24110301Bean.getLicCrtDate());
            String licTermEnd = DateTimeUtil.formatDate("yyyy-MM-dd", sl24110301Bean.getLicTermEnd());
            String orgTermEnd = DateTimeUtil.formatDate("yyyy-MM-dd", sl24110301Bean.getOrgTermEnd());
            sl24110301Bean.setFdlTermEnds(orgTermEnd);
            DecimalFormat df = new DecimalFormat("0.00"); // 保留几位小数
            String licRegCapital = df.format(sl24110301Bean.getLicRegCapital());
            String licPaidinCapital = df.format(sl24110301Bean.getLicPaidinCapital());
            sl24110301Bean.setLicSpeck("名称：" + sl24110301Bean.getEpName() + "<br/>营业执照注册号：" + sl24110301Bean.getLicNo() + "<br/>住所：" + sl24110301Bean.getLicAddr() + " </br>经营类型：" + sl24110301Bean.getLicBusiType() + "<br/>经营范围：" + sl24110301Bean.getLicBusiScope() + "</br>法人代表：" + sl24110301Bean.getLicLegalPerson() + "<br/>注册资本：" + licRegCapital + "<br/>实收资本：" + licPaidinCapital + " </br>成立日期：" + crtDate + "<br/>营业期限：" + licTermEnd);
            sl24110301Bean.setTaxSpeck("税务登记证号：" + sl24110301Bean.getTaxNo() + "<br/>一般增值纳税人资格认定：" + sl24110301Bean.getTaxVatNo());
            sl24110301Bean.setOrgSpeck("代码：" + sl24110301Bean.getOrgNo());
            sl24110301Bean.setBalSpeck("法定代表人：" + sl24110301Bean.getBalLegalPerson() + "<br/>开户银行：" + sl24110301Bean.getBalBank() + "<br/>账号：" + sl24110301Bean.getBalAccount());
            sl24110301Bean.setLicTypeSpeck("注册号：" + sl24110301Bean.getLicNo() + "<br/>组织机构代码证：" + sl24110301Bean.getOrgNo() + "<br/>税务登记证号：" + sl24110301Bean.getTaxNo() + "<br/>名称：" + sl24110301Bean.getEpName() + "<br/>类型：" + sl24110301Bean.getLicBusiType() + "<br/>住所：" + sl24110301Bean.getLicAddr() + "<br/>法定代表人：" + sl24110301Bean.getBalLegalPerson() + "<br/>注册资本：" + licRegCapital + "<br/>成立日期：" + crtDate + "<br/>营业期限：" + licTermEnd + "<br/>经营范围：" + sl24110301Bean.getLicBusiScope());
        } else {
            BaseParam param = new BaseParam();
            param.setFilter("epId", epId);
            sl24110301Bean = sl241103Logic.findOne(param);
            if (null != sl24110301Bean) {
                String crtDate = DateTimeUtil.formatDate("yyyy-MM-dd", sl24110301Bean.getLicCrtDate());
                String licTermEnd = DateTimeUtil.formatDate("yyyy-MM-dd", sl24110301Bean.getLicTermEnd());
                String orgTermEnd = DateTimeUtil.formatDate("yyyy-MM-dd", sl24110301Bean.getOrgTermEnd());
                sl24110301Bean.setFdlTermEnds(orgTermEnd);
                DecimalFormat df = new DecimalFormat("0.00"); // 保留几位小数
                String licRegCapital="";
                String licPaidinCapital="";
                if(null!=sl24110301Bean.getLicRegCapital()){
                    licRegCapital = df.format(sl24110301Bean.getLicRegCapital());
                }
                if(null!=sl24110301Bean.getLicPaidinCapital()){
                    licPaidinCapital = df.format(sl24110301Bean.getLicPaidinCapital());
                }
                sl24110301Bean.setLicSpeck("名称：" + StringUtil.toSafeString(sl24110301Bean.getEpName()) + "<br/>营业执照注册号：" + StringUtil.toSafeString(sl24110301Bean.getLicNo()) + "<br/>住所：" + StringUtil.toSafeString(sl24110301Bean.getLicAddr()) + " </br>经营类型：" + StringUtil.toSafeString(sl24110301Bean.getLicBusiType()) + "<br/>经营范围：" + StringUtil.toSafeString(sl24110301Bean.getLicBusiScope()) + "</br>法人代表：" + StringUtil.toSafeString(sl24110301Bean.getLicLegalPerson()) + "<br/>注册资本：" + licRegCapital + "<br/>实收资本：" + licPaidinCapital + " </br>成立日期：" + crtDate + "<br/>营业期限：" + licTermEnd);
                sl24110301Bean.setTaxSpeck("税务登记证号：" + StringUtil.toSafeString(sl24110301Bean.getTaxNo()) + "<br/>一般增值纳税人资格认定：" + StringUtil.toSafeString(sl24110301Bean.getTaxVatNo()));
                sl24110301Bean.setOrgSpeck("代码：" + sl24110301Bean.getOrgNo());
                sl24110301Bean.setBalSpeck("法定代表人：" + StringUtil.toSafeString(sl24110301Bean.getBalLegalPerson()) + "<br/>开户银行：" + StringUtil.toSafeString(sl24110301Bean.getBalBank()) + "<br/>账号：" + StringUtil.toSafeString(sl24110301Bean.getBalAccount()));
                sl24110301Bean.setLicTypeSpeck("注册号：" + StringUtil.toSafeString(sl24110301Bean.getLicNo()) + "<br/>组织机构代码证：" + StringUtil.toSafeString(sl24110301Bean.getOrgNo()) + "<br/>税务登记证号：" + StringUtil.toSafeString(sl24110301Bean.getTaxNo()) + "<br/>名称：" + StringUtil.toSafeString(sl24110301Bean.getEpName()) + "<br/>类型：" + StringUtil.toSafeString(sl24110301Bean.getLicBusiType()) + "<br/>住所：" + StringUtil.toSafeString(sl24110301Bean.getLicAddr()) + "<br/>法定代表人：" + StringUtil.toSafeString(sl24110301Bean.getBalLegalPerson()) + "<br/>注册资本：" + licRegCapital + "<br/>成立日期：" + crtDate + "<br/>营业期限：" + licTermEnd + "<br/>经营范围：" + StringUtil.toSafeString(sl24110301Bean.getLicBusiScope()));
            }
        }
        return sl24110301Bean;
    }

    /**
     * 查询企业专业资质审批*
     *
     * @return 企业专业资质审批
     *
     * @author pxg
     */
    public List<SL24110302Bean> slEpCert(Model mv, String slCode, String epId) {
        List<SL24110302Bean> listEpCert = new ArrayList<SL24110302Bean>();
        slCode = null;
        if (isDebug) {
            listEpCert = sl241103Logic.selectSlEpCert();
            String slSelfFlg = "1";
            mv.addAttribute("slSelfFlg", slSelfFlg);
        } else {
            logger.info("生产商");
            BaseParam param1 = new BaseParam();
            param1.setFilter("epId", epId);
            listEpCert = sl241103Logic.findSL24110302Bean(param1);
            if (listEpCert.size() > 0) {
                List<SL24110302_1Bean> listSlEpCert = new ArrayList<SL24110302_1Bean>();
                for (int i = 0; i < listEpCert.size(); i++) {
                    String certId = String.valueOf(listEpCert.get(i).getCertId());
                    BaseParam param2 = new BaseParam();
                    param2.setFilter("certId", certId);
                    param2.setFilter("epId", epId);
                    listSlEpCert = sl241103Logic.findSL24110302_1Bean(param2);
                    listEpCert.get(i).setBeanList(listSlEpCert);
                }
            }
        }
        return listEpCert;

    }

    /**
     * rwf
     * 企业基本能力描述
     */
    public SL24110303Bean slAbilityDc(Model mv, String slCode, String epId) {

        SL24110303Bean sL24110303Bean = new SL24110303Bean();
        if (isDebug) {
            slCode = "1";
            mv.addAttribute("slCode", slCode);
            sL24110303Bean = sl241103Logic.selectLi3(slCode, epId);
            return sL24110303Bean;
        } else {
            List<SL2411030301Bean> sL2411030301BeanList = new ArrayList<SL2411030301Bean>();
            List<SL2411030302Bean> sL2411030302BeanList = new ArrayList<>();
            if (!StringUtil.isNullOrEmpty(epId)) {
                logger.info("生产商");
                BaseParam param = new BaseParam();
                param.setFilter("epId", epId);
                sL2411030301BeanList = sl241103Logic.findList("queryList0301", param);
                sL2411030302BeanList = sl241103Logic.findList("queryList0302", param);
                for (int i = 0; i < sL2411030301BeanList.size(); i++) {
                    SL2411030301Bean sL2411030301Bean = sL2411030301BeanList.get(i);
                    sL2411030301Bean.setAptitudeDesc("发证日期：" + DateTimeUtil.formatDate("yyyy-MM-dd", sL2411030301Bean.getCertDate()));
                }
                for (int i = 0; i < sL2411030302BeanList.size(); i++) {
                    SL2411030302Bean sL2411030302Bean = sL2411030302BeanList.get(i);
                    sL2411030302Bean.setAptitudeDesc("总资产：" + StringUtil.toSafeString(sL2411030302Bean.getFtyAsset()) + "(万元)<br/>占地面积：" + StringUtil.toSafeString(sL2411030302Bean.getFtyLandArea()) + "(平米)<br/>厂房面积：" + StringUtil.toSafeString(sL2411030302Bean.getFtyFloorArea()) + "(平米)<br/>主要设备：" + StringUtil.toSafeString(sL2411030302Bean.getFtyEquipment()) + "<br/>设计产能：" + StringUtil.toSafeString(sL2411030302Bean.getFtyDesignCap()) + "吨/天<br/>实际产能：" + StringUtil.toSafeString(sL2411030302Bean.getFtyActualCap()) + "吨/天<br/>外贸销售占比：" + StringUtil.toSafeString(sL2411030302Bean.getFtyFtRate()) + "%<br/>直销占比：" + StringUtil.toSafeString(sL2411030302Bean.getFtyDsRate()) + "%<br/>代理占比：" + StringUtil.toSafeString(sL2411030302Bean.getFtyAsRate()) + "%");
                }
                sL24110303Bean.setsL2411030301BeanList(sL2411030301BeanList);
                sL24110303Bean.setsL2411030302BeanList(sL2411030302BeanList);
                return sL24110303Bean;
            } else {

                return null;
            }
        }
    }

    /**
     * rwf
     * 企业生产车间、设备、产品工艺流程描述
     */
    public SL24110304Bean slPdWorkShop(Model mv, String slCode, String epId) {
        SL24110304Bean sL24110304Bean = new SL24110304Bean();
        if (isDebug) {
            slCode = "1";
            mv.addAttribute("slCode", slCode);
            sL24110304Bean = sl241103Logic.selectLi4(slCode, epId);
            return sL24110304Bean;
        } else {
            List<SL2411030303Bean> sL2411030303BeanList = new ArrayList<>();
            List<SL2411030302Bean> sL2411030302BeanList = new ArrayList<>();
            if (!StringUtil.isNullOrEmpty(epId)) {
                logger.info("生产商");
                BaseParam param = new BaseParam();
                param.setFilter("epId", epId);
                sL2411030303BeanList = sl241103Logic.findList("queryList0401", param);
                sL2411030302BeanList = sl241103Logic.findList("queryList0402", param);
                for (int i = 0; i < sL2411030303BeanList.size(); i++) {
                    SL2411030303Bean sL2411030303Bean = sL2411030303BeanList.get(i);
                    sL2411030303Bean.setWorkshopDesc("1、车间名称：" + StringUtil.toSafeString(sL2411030303Bean.getWorkshopName()) + "<br/>2、生产产品：" + StringUtil.toSafeString(sL2411030303Bean.getProduct()) + "<br/>3、工艺流程特点：" + StringUtil.toSafeString(sL2411030303Bean.getProcess()));
                }
                for (int i = 0; i < sL2411030302BeanList.size(); i++) {
                    SL2411030302Bean sL2411030302Bean = sL2411030302BeanList.get(i);
                    sL2411030302Bean.setScapDesc("1、原料库容：" + StringUtil.toSafeString(sL2411030302Bean.getScapMaterial()) + "(立方)<br/>2、成品库容：" + StringUtil.toSafeString(sL2411030302Bean.getScapProduct()) + "(立方)");
                }
                sL24110304Bean.setsL2411030303BeanList(sL2411030303BeanList);
                sL24110304Bean.setsL2411030302BeanList(sL2411030302BeanList);
                return sL24110304Bean;
            } else {

                return null;
            }
        }
    }

    /**
     * rwf
     * 企业实验室、检测设备及产品质量控制系统描述
     */
    public SL2411030302Bean slLaboratory(Model mv, String slCode, String epId) {
        SL2411030302Bean sL2411030302Bean = new SL2411030302Bean();
        if (isDebug) {
            slCode = "1";
            mv.addAttribute("slCode", slCode);
            sL2411030302Bean = sl241103Logic.selectLi5(slCode, epId);
            sL2411030302Bean.setAptitudeDesc("1、面积：" + StringUtil.toSafeString(sL2411030302Bean.getLabArea()) + "(平米)<br/>2、功能：" + StringUtil.toSafeString(sL2411030302Bean.getLabFunction()) + "<br/>3、投资：" + StringUtil.toSafeString(sL2411030302Bean.getLabInvestment()) + "(万元)<br/>4、人员数量：" + StringUtil.toSafeString(sL2411030302Bean.getLabMember()) + "(人)");
            sL2411030302Bean.setAptitudeDesc2("主要设备及用途：" + sL2411030302Bean.getDdEquipment());
        } else {
            if (!StringUtil.isNullOrEmpty(epId)) {
                BaseParam param = new BaseParam();
                param.setFilter("epId", epId);
                sL2411030302Bean = sl241103Logic.findOne("findOneSL2411030302Bean", param);
                if (sL2411030302Bean != null) {
                    sL2411030302Bean.setAptitudeDesc("1、面积：" + StringUtil.toSafeString(sL2411030302Bean.getLabArea()) + "(平米)<br/>2、功能：" + StringUtil.toSafeString(sL2411030302Bean.getLabFunction()) + "<br/>3、投资：" + StringUtil.toSafeString(sL2411030302Bean.getLabInvestment()) + "(万元)<br/>4、人员数量：" + StringUtil.toSafeString(sL2411030302Bean.getLabMember()) + "(人)");
                    sL2411030302Bean.setAptitudeDesc2("主要设备及用途：" + StringUtil.toSafeString(sL2411030302Bean.getDdEquipment()));
                }
            }
        }
        return sL2411030302Bean;
    }

    /**
     * 企业管理团队描述
     * 
     * @param mv
     * @param slCode
     * @param epId
     * @return 企业管理团队描述
     *
     * @author chen_xin
     */
    public String slTeamDs(Model mv, @RequestParam(required = false) String slCode, @RequestParam(required = false) String epId) {

        if (isDebug) {
            List<SL24110306Bean> list0306 = sl241103Logic.queryList();
            mv.addAttribute("list0306", list0306);
        } else {

            logger.info("查询数据库  ,企业管理团队描述操作");
            if ("".equals(slCode) && null == slCode) {
                logger.info("生产商");
            } else {
                logger.info("卖家");
                BaseParam param = new BaseParam();
                if (StringUtil.isNullOrEmpty(epId)) {
                    return null;
                } else {
                    param.setFilter("epId", epId);
                    List<SL24110306Bean> list0306 = sl241103Logic.findList("findList0306", param);
                    if (null != list0306 && !list0306.isEmpty()) {
                        mv.addAttribute("list0306", list0306);
                    }
                }
            }
        }
        return "sl/SL24110306";
    }

}
