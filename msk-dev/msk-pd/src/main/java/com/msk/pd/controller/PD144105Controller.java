package com.msk.pd.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.*;
import com.msk.core.web.base.BaseController;
import com.msk.pd.bean.PD144104Bean;
import com.msk.pd.bean.PD144104Param;
import com.msk.pd.bean.PD144107Param;
import com.msk.pd.logic.PD144105Logic;
import com.msk.core.bean.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 产品类别信息controller
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "PD144105")
public class PD144105Controller extends BaseController {
    @Autowired
    private PD144105Logic pd144105Logic;
    /**
     * 实例化页面
     *
     * @param
     * @param model model
     * @return 界面
     * @author ren_qiang
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model,PD144104Param param) {
        List<PdClassestree> pdClasseslst = new ArrayList<>();
        pdClasseslst = pd144105Logic.queryOneClassify();
        List<PdGrade> gradeList = new ArrayList<PdGrade>();
        gradeList = pd144105Logic.queryGrade();
        model.addAttribute("pdClasseslst", pdClasseslst);
        model.addAttribute("gradeList",gradeList);
        model.addAttribute("param",param);
        return "pd/PD144105";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<PD144104Bean> search(PD144104Param param){
       return pd144105Logic.findPage(param, PD144104Bean.class);
    }

    /**
     * 实例化页面
     *
     * @param classesCode classesCode
     * @return 界面
     * @author pxg
     */
    @RequestMapping(value = "queryTwo", method = RequestMethod.POST)
    public
    @ResponseBody
    List<PdMachining> queryTwo(String classesCode) {
        List<PdMachining> listTwo = new ArrayList<PdMachining>();
        listTwo = pd144105Logic.queryTwoClassify(classesCode);
        return listTwo;
    }

    @RequestMapping(value = "queryBreed" , method = RequestMethod.POST)
    public
    @ResponseBody
    List<PdBreed> queryBreed(String classesCode,String  machiningCode){
        List<PdBreed> breedList = new ArrayList<PdBreed>();
        breedList = pd144105Logic.queryBreed(classesCode,machiningCode);
        return  breedList;
    }

    @RequestMapping(value = "queryFeature" , method = RequestMethod.POST)
    public
    @ResponseBody
    List<PdFeature> queryFeature(String classesCode,String  machiningCode,String breedCode){
        List<PdFeature> featureList = new ArrayList<PdFeature>();
        featureList = pd144105Logic.queryFeature(classesCode, machiningCode, breedCode);
        return  featureList;
    }
    @RequestMapping(value = "queryWeight" , method = RequestMethod.POST)
    public
    @ResponseBody
    List<PdWeight> queryWeight(String classesCode,String  machiningCode,String breedCode,String featureCode){
        List<PdWeight> weightsList = new ArrayList<PdWeight>();
        weightsList = pd144105Logic.queryWeight(classesCode, machiningCode, breedCode, featureCode);
        return  weightsList;
    }


    /**
     * 批量保存楼层产品信息
     * @param pd144104Param
     * @param param
     * @return
     */
    @RequestMapping(value = "save" , method = RequestMethod.POST)
    @ResponseBody
    public String saveProduct(PD144104Param pd144104Param,@RequestParam(value = "param",
            required = false)String param){
        super.setCommonParam(pd144104Param);
        Map<String, PdAppFloorDetail> map = JSON.parseObject(param, new TypeReference<Map<String, PdAppFloorDetail>>() {
        });
        int count = pd144105Logic.batchSave(map.values(),pd144104Param);
        if(count > 0){
            return SystemConst.RsStatus.SUCCESS;
        }
        return SystemConst.RsStatus.FAIL;
    }

}
