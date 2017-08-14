package com.msk.sl.controller;

import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.entity.SlAccount;
import com.msk.core.entity.SlEpAgentAuth;
import com.msk.core.entity.SlEpHonor;
import com.msk.core.entity.SlEpOemAuth;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.*;
import com.msk.sl.logic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fjm on 2016/1/28.
 */
@Controller
@RequestMapping("SL24110100")
public class SL24110100Controller extends BaseController{

    @Autowired
    private SL241103001Logic SL241103001Logic;

    @Autowired
    private SL24110100Logic sL24110100Logic;

    @Autowired
    private SL241103000Logic sl241103000Logic;

    @Autowired
    private SL241103010Logic sl241103010Logic;

    @Autowired
    private SL241103Logic sl241103Logic;
    /**
     * 数据库查询sl_account表返回SlAccount对象回显给sl24110101页面
     * @param slAccount 账号
     * @param model model
     * @return String
     */

    @RequestMapping(value="init",method = RequestMethod.POST)
    public  String init(String slAccount,Model model,HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        //拿account获取seller实体，拿seller实体中的epid查出enterprise实体
        SlSeller slSeller = this.sL24110100Logic.findSlByAc(slAccount);
        BaseParam baseParam = new BaseParam();
        List<MdProvince> mdProvinces =this.sl241103000Logic.findMdProvinces(baseParam);
        model.addAttribute("mdProvinces",mdProvinces);
        String slCode="";
        String ep="";
        String epName="";
        if(null!=slSeller){
            slCode = slSeller.getSlCode();
            ep = StringUtil.toSafeString(slSeller.getEpId());
            epName= this.sL24110100Logic.findSlEnterprise(Long.valueOf(ep));
            request.getSession().setAttribute("jsp_epId2",slSeller.getEpId());
        }
        request.getSession().setAttribute("jsp_slCode",slCode);
        request.getSession().setAttribute("jsp_slAccount",slAccount);
        SlEnterprise slEnterprise = this.sL24110100Logic.findEpById(ep);
        SlAccount SlAccountsql =  this.SL241103001Logic.slAccountEntity2(slAccount);
        //查询企业资质信息
        List<SL24110302Bean> slEpCertList = this.sL24110100Logic.findSL24110302BeanList(ep);
        if(!CollectionUtils.isEmpty(slEpCertList)){
            model.addAttribute("slEpCertListsize",slEpCertList.size());
        }else {
            model.addAttribute("slEpCertListsize",0);
        }
        model.addAttribute("slEpCertList",slEpCertList);
        //查询企业荣誉信息
        List<SlEpHonor> slEpHonors = this.sL24110100Logic.findSlEpHonor(ep);
        if(!CollectionUtils.isEmpty(slEpHonors)){
            model.addAttribute("slepHonorList",slEpHonors.size());
        }else{
            model.addAttribute("slepHonorList",0);
        }
        model.addAttribute("slEpHonors",slEpHonors);
        //查询厂区信息 //查询库容信息 //查询实验室、品控等信息
        SlEpCap slEpCap = this.sL24110100Logic.findSlEpCap(ep);
        //查询车间信息
        List<SlEpWorkshop> slEpWorkshops = this.sL24110100Logic.findSlEpWorkshop(ep);
        if(!CollectionUtils.isEmpty(slEpWorkshops)){
            model.addAttribute("workshoplistSize",slEpWorkshops.size());

        }else{
            model.addAttribute("workshoplistSize",0);
        }
        model.addAttribute("slEpWorkshops",slEpWorkshops);
        //拿SL_CODE查询出企业电商信息
        System.out.print(slCode);
        List<SL241103070Bean> ecTeam = this.sL24110100Logic.findEcTeam(slCode);
        if(!CollectionUtils.isEmpty(ecTeam)){
            model.addAttribute("ecTeamSize",ecTeam.size());

        }else{
            model.addAttribute("ecTeamSize",0);
        }
        //SL241103070Bean sl241103070Bean = this.sL24110100Logic.findEcTeamBySCode(slCode);
        model.addAttribute("ecTeam",ecTeam);

        //品牌信息
        List<SL2411030033Bean> list = this.sL24110100Logic.findpp(ep);

        if(!CollectionUtils.isEmpty(list)){
            model.addAttribute("listSize",list.size());
        }else{
            model.addAttribute("listSize",0);
        }
        model.addAttribute("list",list);
        /**代理品牌信息*/
       List<SL2411030073Bean> sl2411030073Beans = this.sL24110100Logic.findPdBrand(slCode);
        if(!CollectionUtils.isEmpty(sl2411030073Beans)){
            for(SL2411030073Bean sl2411030073Bean : sl2411030073Beans){
                if(null!=this.sL24110100Logic.findSlEnterprise(sl2411030073Bean.getBrandEpId())){
                    sl2411030073Bean.setEpName(this.sL24110100Logic.findSlEnterprise(sl2411030073Bean.getBrandEpId()));
                }
            }
            model.addAttribute("sl2411030073BeansSize",sl2411030073Beans.size());
        }else{
            model.addAttribute("sl2411030073BeansSize",0);
        }
        model.addAttribute("sl2411030073Beans",sl2411030073Beans);

        //团队信息
        List<SL24110306Bean> ma = this.sL24110100Logic.findMa(ep);
        if(!CollectionUtils.isEmpty(ma)){
            model.addAttribute("maSize",ma.size());
        }else{
            model.addAttribute("maSize",0);
        }
        model.addAttribute("slEpManager",ma);
        //生产商信息
        BaseParam params=new BaseParam();
        params.setFilter("slCode",slCode);
        params.setFilter("delFlg","0");
        List<SlEpAgentAuthBean> slEpAgentAuthAndSlEpOem=new ArrayList<>();
        if(null!=slSeller && NumberConst.IntDef.INT_TWO==slSeller.getSlMainClass()){
            List<SlEpAgentAuthBean> slEpAgentAuth= sl241103010Logic.queryAgentData(params);
            if(!CollectionUtils.isEmpty(slEpAgentAuth)){
                for (int i = 0; i < slEpAgentAuth.size(); i++) {
                    SlEpAgentAuthBean slEpAgent=slEpAgentAuth.get(i);
                    slEpAgent.setSlCode(slCode);
                    slEpAgent.setEpName(this.sL24110100Logic.findSlEnterprise(slEpAgent.getProducerEpId()));
                    slEpAgent.setMarkFlg(NumberConst.IntDef.INT_ONE);
                    slEpAgentAuthAndSlEpOem.add(slEpAgent);
                }
                //model.addAttribute("slEpAgentAuth", slEpAgentAuth);
            }
        }else if(null!=slSeller && NumberConst.IntDef.INT_THREE==slSeller.getSlMainClass()){
            List<SlEpAgentAuthBean> slEpOemAuth= sl241103010Logic.queryOemData(params);
            if(!CollectionUtils.isEmpty(slEpOemAuth)){
                for (int i = 0; i < slEpOemAuth.size(); i++) {
                    SlEpAgentAuthBean slEpOem=slEpOemAuth.get(i);
                    slEpOem.setSlCode(slCode);
                    slEpOem.setEpName(this.sL24110100Logic.findSlEnterprise(slEpOem.getProducerEpId()));
                    slEpOem.setMarkFlg(NumberConst.IntDef.INT_TWO);
                    slEpAgentAuthAndSlEpOem.add(slEpOem);
                }
                //model.addAttribute("slEpOemAuth",slEpOemAuth);
            }
        }
        model.addAttribute("slEpAgentAuthAndSlEpOem",slEpAgentAuthAndSlEpOem);
        //地区回显
        List<MdCity> cityList=null;
        List<MdDistrict> mdDistrictList=null;
        if(null!=slSeller){
            String provinceId="";
            String cityId="";
            for (int i = 0; i <mdProvinces.size() ; i++) {
                MdProvince mdProvince=mdProvinces.get(i);
                if(mdProvince.getProvinceCode().equals(slSeller.getProvinceCode())){
                    provinceId=StringUtil.toSafeString(mdProvince.getProvinceId());
                }
            }
            cityList=this.sl241103000Logic.findCityList(provinceId);
            for (int i = 0; i <cityList.size() ; i++) {
                MdCity mdCity=cityList.get(i);
                if(mdCity.getCityCode().equals(slSeller.getCityCode())){
                    cityId=StringUtil.toSafeString(mdCity.getCityId());
                }
            }
            mdDistrictList= sl241103000Logic.findDistrictList(cityId);
        }
        //检测设备数据查询
        BaseParam param=new BaseParam();
        param.setFilter("epId",ep);
        param.setFilter("delFlg","0");
        List<SlEpDdBean> slEpDdBeanList=sl241103Logic.findEpEquipment(param);
        model.addAttribute("slEpDdBeanList",slEpDdBeanList);
        model.addAttribute("cityList",cityList);
        model.addAttribute("mdDistrictList",mdDistrictList);
        model.addAttribute("slAccount", SlAccountsql);
        model.addAttribute("slSeller",slSeller);
        model.addAttribute("slEnterprise",slEnterprise);
        model.addAttribute("slEpCap",slEpCap);

        return "sl/SL24110100";
    }

}
