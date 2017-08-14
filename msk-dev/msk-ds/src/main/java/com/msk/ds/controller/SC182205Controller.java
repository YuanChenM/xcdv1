package com.msk.ds.controller;

import com.msk.core.bean.BaseParam;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.bean.LoginUser;
import com.msk.core.web.consts.BusinessConst;
import com.msk.ds.bean.*;
import com.msk.ds.logic.SC182205Logic;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * SC182205Controller
 *
 * @author yi_qixiang
 *
 */
@Controller
@RequestMapping("SC182205")
public class SC182205Controller extends BaseController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SC182205Controller.class);

    /** sc182205Logic */
    @Autowired
    private SC182205Logic sc182205Logic;
    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public String init(Model model,SC182203Bean sc182203Bean) {

        SC182205Bean sc182205Bean = new SC182205Bean();
        String classesName = "";
        String breedName = "";
        String machiningName = "";
        String featureName = "";
        String weightName = "";
        String gradeName = "";

        String proLotNum = sc182203Bean.getProLotNum();
        SC182205Param sc182205Param = new SC182205Param();
        sc182205Param.setProLotNum(proLotNum);
        sc182205Bean= sc182205Logic.getDsProductLot(sc182205Param);
        classesName = sc182205Logic.getClassesName(sc182205Bean.getClassesCode());
        breedName = sc182205Logic.getBreedName(sc182205Bean.getBreedCode());
        machiningName = sc182205Logic.getMachiningName(sc182205Bean.getMachiningCode());
        featureName = sc182205Logic.getFeatureName(sc182205Bean.getFeatureCode());
        weightName = sc182205Logic.getWeightName(sc182205Bean.getWeightCode());
        gradeName = sc182205Logic.getGradeName(sc182205Bean.getGradeCode());
        model.addAttribute("classesName",classesName);
        model.addAttribute("breedName",breedName);
        model.addAttribute("machiningName",machiningName);
        model.addAttribute("featureName",featureName);
        model.addAttribute("weightName",weightName);
        model.addAttribute("gradeName",gradeName);
        model.addAttribute("sc182205Bean",sc182205Bean);

        return "ds/SC182205";
    }





    /**
     * （保存打印数据）
     * @param sc182205Bean
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Model model,SC182205Bean sc182205Bean){
        //BaseParam baseParam = new BaseParam();
        //this.setCommonParam(baseParam);
        //获取当前用户信息

        String proLotNum = sc182205Bean.getProLotNum();
        String productPrintNum = sc182205Bean.getProductPrintNum();
//        String printTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        SC182205Param sc182205Param = new SC182205Param();
        sc182205Param.setProLotNum(proLotNum);
        sc182205Param.setProductPrintNum(productPrintNum);
        sc182205Param.setPrintTime(new Date());
        sc182205Logic.saveProductPrintNum(sc182205Param);
        model.addAttribute("classesName",sc182205Bean.getClassesName());
        model.addAttribute("breedName",sc182205Bean.getBreedName());
        model.addAttribute("machiningName",sc182205Bean.getMachiningName());
        model.addAttribute("featureName",sc182205Bean.getFeatureName());
        model.addAttribute("weightName",sc182205Bean.getWeightName());
        model.addAttribute("gradeName",sc182205Bean.getGradeName());
        model.addAttribute("sc182205Bean",sc182205Bean);

        return "ds/SC182205";
    }




}
