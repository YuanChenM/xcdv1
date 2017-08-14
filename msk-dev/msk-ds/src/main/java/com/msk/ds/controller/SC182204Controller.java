package com.msk.ds.controller;

import com.msk.core.bean.BaseParam;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.bean.LoginUser;
import com.msk.ds.bean.DistSuppChain;
import com.msk.ds.bean.SC181102Param;
import com.msk.ds.bean.SC182204Param;
import com.msk.ds.bean.SC182204Bean;
import com.msk.pd.bean.ProductBean;
import com.msk.ds.logic.SC182101Logic;
import com.msk.ds.logic.SC182204Logic;
import com.msk.pd.logic.ProductLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * SC182204Controller
 *
 * @author yi_qixiang
 *
 */
@Controller
@RequestMapping("SC182204")
public class SC182204Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SC182204Controller.class);

    @Autowired
    private SC182204Logic sc182204Logic;

    @Autowired
    private ProductLogic productLogic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(SC182204Param sc182204Param,Model model) {

//        String lgcsCode = "";
//        String lgcsName = "";
//        String suppCode = "";
//        String suppName = "";
        String halfPeriod = "";
        String halfCode = "";
        String pdStockType = "2";
        String distMonth = "";

//        LoginUser loginUser = getLoginUser();
//        String slAccount = loginUser.getEmplId();
//        String userType = loginUser.getUserType();
//        if(userType.equals("2")){
//            SC182204Bean sc182204Bean = getLgcsAndSupp(slAccount);
//            if(sc182204Bean!=null){
//                suppCode = sc182204Bean.getSuppCode();
//                suppName = sc182204Bean.getSuppName();
//                lgcsCode = sc182204Bean.getLgcsCode();
//                lgcsName = sc182204Bean.getLgcsName();
//            }
//        }
//        sc182204Param.setLgcsCode(lgcsCode);
//        sc182204Param.setSuppCode(suppCode);
        SC182204Bean sc182204Bean = new SC182204Bean();
        sc182204Bean = sc182204Logic.getSC182204Bean(sc182204Param);
        sc182204Param.setPdStockType(pdStockType);
        List<SC182204Bean> returnList = new ArrayList<SC182204Bean>();
        List<SC182204Bean> stockActualList = new ArrayList<SC182204Bean>();

        try {
            halfCode = calculatHalfPeriod().substring(4,5);
            distMonth = "20"+calculatHalfPeriod().substring(0,4);  //根据系统时间计算
            sc182204Param.setHalfCode(halfCode);
            sc182204Param.setDistMonth(distMonth);
            returnList = sc182204Logic.getStockActual(sc182204Param);
            stockActualList = getStockActualList(returnList);
            halfPeriod = calculatHalfPeriod();
        }catch (Exception e){
            e.printStackTrace();
        }

//        model.addAttribute("lgcsName",lgcsName);
//        model.addAttribute("suppName",suppName);
        model.addAttribute("stockActualList",stockActualList);
        model.addAttribute("halfPeriod",halfPeriod);
        model.addAttribute("sc182204Bean",sc182204Bean);
        return "ds/SC182204";

    }


    /**
     * 保存变更
     * @param param
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public @ResponseBody void save(SC182204Param param) throws ParseException{
//        this.setCommonParam(param);
//        sc183103Logic.saveChangeNum(param);
//        return param.getFilterMap().get("entryMark").toString();
//        LoginUser loginUser = getLoginUser();
//        String slAccount = loginUser.getEmplId();
//        SC182204Bean sc182204Bean = getLgcsAndSupp(slAccount);
//        param.setLgcsCode(sc182204Bean.getLgcsCode());
//        param.setSuppCode(sc182204Bean.getSuppCode());
        param.setHalfPeriod(calculatHalfPeriod());
        sc182204Logic.saveProductLot(param);
//        return param.getFilterMap().get("entryMark").toString();

    }

    /**
     * 根据账号得到供应商和销售区域
     * @param
     * @return
     */
     public SC182204Bean getLgcsAndSupp(String slAccount) {
         SC182204Param sc182204Param = new SC182204Param();
         sc182204Param.setSlAccount(slAccount);
         return  sc182204Logic.getLgcsAndSupp(sc182204Param);
     }



    /**
     * 根据产品编号获得产品属性的list
     * @param returnList
     * @return
     */
    public List<SC182204Bean> getStockActualList(List<SC182204Bean> returnList) throws ParseException{

        List<SC182204Bean> stockACTUALList = new ArrayList<SC182204Bean>();
        for(int i=0;i<returnList.size();i++){
            SC182204Bean retrunSc182204Bean = (SC182204Bean)returnList.get(i);
            SC182204Bean sc182204Bean = new SC182204Bean();
            ProductBean productBean = productLogic.getProductInfo(retrunSc182204Bean.getPdCode());
            sc182204Bean.setLgcsCode(retrunSc182204Bean.getLgcsCode());
            sc182204Bean.setSuppCode(retrunSc182204Bean.getSuppCode());
            sc182204Bean.setProductBean(productBean);
            sc182204Bean.setSumNewActNum(retrunSc182204Bean.getSumNewActNum());
            String classesCode = "";
            String machiningCode = "";
            String breedCode = "";
            String featureCode = "";
            String gradeCode = "";
            String weightCode = "";
            String normsCode = "";
            String suppCode = "";
            String slCodeManufacture = "";
            String brandId = "";
            if(productBean!=null){
                if(productBean.getPdClasses()!=null){
                    classesCode = productBean.getPdClasses().getClassesCode();
                }
                if(productBean.getPdMachining()!=null){
                    machiningCode = productBean.getPdMachining().getMachiningCode();
                }
                if(productBean.getPdBreed()!=null){
                    breedCode = productBean.getPdBreed().getBreedCode();
                }
                if(productBean.getPdFeature()!=null){
                    featureCode = productBean.getPdFeature().getFeatureCode();
                }
                if(productBean.getPdGrade()!=null){
                    gradeCode = productBean.getPdGrade().getGradeCode();
                }
                if(productBean.getPdWeight()!=null){
                    weightCode = productBean.getPdWeight().getWeightCode();
                }
            }
            if(retrunSc182204Bean.getNormsCode()!=null){
                normsCode = retrunSc182204Bean.getNormsCode();
                if(normsCode.length()>2){
                    normsCode = normsCode.substring(1);
                }
            }
            if(retrunSc182204Bean.getSuppCode()!=null){
                suppCode = retrunSc182204Bean.getSuppCode();
            }

            sc182204Bean.setProLotNum("92" + suppCode +                  //卖家编号
                    "55555" +                                           //货号
                    calculatHalfPeriod());                               //批次号
            if((retrunSc182204Bean.getSumNewActNum().intValue())==0){
                sc182204Bean.setProductPrintNum("0");
            }else{
                sc182204Bean.setProductPrintNum("1-"+retrunSc182204Bean.getSumNewActNum().intValue());
            }
            sc182204Bean.setNormsCode(retrunSc182204Bean.getNormsCode());
            sc182204Bean.setHalfPeriod(calculatHalfPeriod());

            SC182204Param param = new SC182204Param();
            param.setSuppCode(retrunSc182204Bean.getSuppCode());
            if(sc182204Logic.getManuFactureAndBrand(param)!=null){
                  if((sc182204Logic.getManuFactureAndBrand(param).getSlCodeManufacture())!=null){
                      slCodeManufacture = sc182204Logic.getManuFactureAndBrand(param).getSlCodeManufacture();
                  }
                if((sc182204Logic.getManuFactureAndBrand(param).getBrandId())!=null){
                    brandId = sc182204Logic.getManuFactureAndBrand(param).getBrandId();
                }
            }
            sc182204Bean.setReadProLotNum(suppCode + slCodeManufacture + brandId + classesCode + machiningCode + breedCode + featureCode + gradeCode + weightCode + normsCode + calculatHalfPeriod());



            SC182204Param sc182204Param = new SC182204Param();
            sc182204Param.setProLotNum("92" + suppCode +
                    "55555"+
                    calculatHalfPeriod());
            if (sc182204Logic.getDsProductLot(sc182204Param)!=null){

            } else {
                stockACTUALList.add(sc182204Bean);
            }



        }
        return stockACTUALList;
    }


    /**
     * 得到半旬期
     * @param
     * @return
     */
    public String calculatHalfPeriod() throws ParseException {
//        String time="20160403";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String time= sdf.format(new Date());
        int dayNum = Integer.parseInt(time.substring(6, 8));
        if(dayNum>=1&&dayNum<=5){
            return time.substring(2,6)+"3";
        }else if(dayNum>=6&&dayNum<=10){
            return time.substring(2,6)+"4";
        }else if(dayNum>=11&&dayNum<=15){
            return time.substring(2,6)+"5";
        }else if(dayNum>=16&&dayNum<=20){
            return time.substring(2,6)+"6";
        }else if(dayNum>=21&&dayNum<=25){
            return time.substring(2,6)+"1";
        }else {
            return time.substring(2,6)+"2";
        }

    }



    /**
     * 获取下拉框数据
     * @param sc182204Param sc182204Param
     * @return selectList
     */
    @RequestMapping(value = "selectChange",
            method = RequestMethod.POST)
    public @ResponseBody
    List<SC182204Bean> selectChange(SC182204Param sc182204Param) {
        List<SC182204Bean> selectList = new ArrayList<>();
            /*供应商*/
        BaseParam param = new BaseParam();
        param.setFilter("lgcsCode", sc182204Param.getLgcsCode());
        selectList = sc182204Logic.getSuppListByLgcs(sc182204Param);

        return selectList;
    }

}
