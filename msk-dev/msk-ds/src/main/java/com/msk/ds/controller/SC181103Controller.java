package com.msk.ds.controller;

import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.CommConstant;
import com.msk.core.entity.PdGrade;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.utils.ValidatorUtils;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.SC181103Bean;
import com.msk.ds.bean.SC181103Param;
import com.msk.ds.logic.DistSuppChainLogic;
import com.msk.ds.logic.SC181103Logic;
import org.apache.commons.collections.CollectionUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

/**
 * SC181103Controller
 *
 * @author pxg
 *
 */
@Controller
@RequestMapping("SC181103")
public class SC181103Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SC181103Controller.class);

    @Autowired
    private SC181103Logic sc181103Logic;

    @Autowired
    private DistSuppChainLogic distSuppChainLogic;

    // 21号
    int DEPARTURE_1 = 21;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(SC181103Param sc181103Param,Model model) {
        logger.debug("月度管控（临时）初始化");
        BaseParam baseParam = new BaseParam();
        this.setCommonParam(baseParam);

        //获取分销月度
        Date currentDate = new Date();
        String currentDay = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DD,currentDate);
        // 分销月份
        String distMonth = null;
        // 查询卖家数据用的月份
        String searchMonth = null;
        int halfCode = 0;
        String halfName = null;
        if (Integer.parseInt(currentDay) >= DEPARTURE_1) {
            // 21号开始属于下个分销月度
            Calendar c = Calendar.getInstance();
            c.setTime(currentDate);
            c.add(Calendar.MONTH, 1);
            distMonth = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_YEAR_MONTH, c.getTime());
            // 分销下个月时检索这个月的数据
            searchMonth = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_YEAR_MONTH, currentDate);
        } else {
            distMonth = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_YEAR_MONTH, currentDate);
            // 分销当前月时检索上个月的数据
            Calendar c = Calendar.getInstance();
            c.setTime(currentDate);
            c.add(Calendar.MONTH, -1);
            searchMonth = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_YEAR_MONTH, c.getTime());
        }

        // 获取半旬
        halfCode = sc181103Logic.getHalfCode(currentDay);
        halfName = sc181103Logic.getHalfName(halfCode);

        // 获取区域下拉列表
        List<SC181103Bean> areaList = sc181103Logic.findAreaList();
        // 获取供应商下拉框
        List<SC181103Bean> suppList = null;
        String areaCode = null;
        String suppCode = null;
        String areaName = null;
        if (!CollectionUtils.isEmpty(areaList)) {
            SC181103Param areaParam = new SC181103Param();
            areaCode = areaList.get(0).getLgcsCode();
            areaName = areaList.get(0).getLgcsName();
            areaParam.setLgcsCode(areaCode);
            suppList = sc181103Logic.findSuppList(areaParam);

        }
        if (!CollectionUtils.isEmpty(suppList)) {
            suppCode = suppList.get(0).getSuppCode();
        }

        /**
         * 获取产品等级List
         * @return List
         * */

        List<PdGrade> gradeList = sc181103Logic.findProductGrade();
//        List<CommConstant> halfNameList = sc181103Logic.findHalfNameList();
        /**
         * 获取品牌List
         * @return List
         * */

        List<CommConstant> brandTypeList = sc181103Logic.findBrandType();
        model.addAttribute("pdGradeList", gradeList);
        model.addAttribute("brandTypeList",brandTypeList);
        model.addAttribute("userType",baseParam.getUserType());
        model.addAttribute("distMonth",distMonth);
        model.addAttribute("lgcsCode", areaCode);
        model.addAttribute("lgcsName", areaName);
        model.addAttribute("suppCode", suppCode);

        model.addAttribute("areaList",areaList);
        model.addAttribute("suppList",suppList);
//        model.addAttribute("halfParam",halfParam);

        return "ds/SC181103";
    }

    /**
     * 分页查询数据
     *
     * @param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody PageResult<SC181103Bean> search(SC181103Param pageParam) {
        logger.debug("收货入库通知单查询");
        //BasePageParam pageParam = new BasePageParam();
        pageParam.setFilter("suppCode",pageParam.getSuppCode());
        pageParam.setFilter("distMonth",pageParam.getDistMonth());
        DbUtils.buildLikeCondition(pageParam, "breedName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(pageParam, "featureName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(pageParam, "productSpecifical", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(pageParam, "netWeight", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(pageParam, "manuName", DbUtils.LikeMode.PARTIAL);
        PageResult<SC181103Bean> result = sc181103Logic.findSC181103BeansList(pageParam);
        String lgscCode = StringUtil.toSafeString(pageParam.getLgcsCode());
        for(SC181103Bean bean:result.getData()){
            bean.setLgcsCode(lgscCode);
            bean.setLgcsName(pageParam.getLgcsName());
        }
        return result;
    }
	
    /**
     *
     * 保存多个数据到DB
     * @param jsonStr
     */

    @RequestMapping(value = "save" , method = RequestMethod.POST)
    public @ResponseBody void saveAllParam(Model model,String jsonStr){

        JSONObject jsonObject = new JSONObject(jsonStr);
        Set keyset = jsonObject.keySet();
        Iterator<String> it = keyset.iterator();
        if (CollectionUtils.isNotEmpty(keyset)) {

            while (it.hasNext()) {
                JSONObject params = jsonObject.getJSONObject(it.next());
//            BeanUtils.copyProperties(params,sc181103Param);
                SC181103Param sc181103Param = new SC181103Param();
                sc181103Param.setPdCode(params.getString("pdCode"));
                sc181103Param.setNormsCode(params.getString("normsCode"));
                sc181103Param.setFeatureCode(params.getString("featureCode"));
                sc181103Param.setBreedCode(params.getString("breedCode"));
//            if (params.getString("packNum").length()<9
//                    &&ValidatorUtils.checkDecimal(params.getString("packNum"))
//                    &&StringUtil.toBigDecimal(params.getString("packNum")) != null) {
//
//                sc181103Param.setPackNum(StringUtil.toBigDecimal(params.getString("packNum")));
//            } else {
//                throw new BusinessException("发货数量不合法！");
//            }
                //设置分销数量
                setDistNum(params,sc181103Param);

                sc181103Param.setLgcsCode(params.getString("lgcsCode"));
                sc181103Param.setLgcsName(params.getString("lgcsName"));
                sc181103Param.setDistMonth(params.getString("distMonth"));
                sc181103Param.setClassesCode(params.getString("classesCode"));
//            sc181103Param.setBrandType(params.getInt("slQltGradeCode"));
                sc181103Param.setBrandType(params.getInt("brandType"));
                sc181103Param.setSuppCode(params.getString("suppCode"));
                sc181103Param.setProductSpecifical(params.getString("productSpecifical"));
                sc181103Param.setNetWeight(params.getString("netWeight"));
                sc181103Param.setGradeCode(params.getString("gradeCode"));
                sc181103Param.setHalfCode(params.getString("halfCode"));
                /**过滤误操作*/
                if (!StringUtil.isNullOrEmpty(params.getString("packNum"))
                        && !Integer.toString(NumberConst.IntDef.INT_ZERO).equals(params.getString("packNum"))){

                    sc181103Logic.saveParam(sc181103Param);
                }
            }
        } else {
            throw new BusinessException("请输入发货数量!");
        }
    }

    /**
     * 设置分销数量
     * @param param
     */
    public void setDistNum (JSONObject param, SC181103Param sc181103Param){
        //有效位数
        int num = NumberConst.IntDef.INT_EIGHTEEN;
        boolean flag = false;
        //发货箱数
        String packNum = param.getString("packNum");
        if (!StringUtil.isNullOrEmpty(packNum)) {
            if (packNum.startsWith("-")){
                flag = true;
                packNum = packNum.substring(1);
            }
            if (packNum.contains(".")) {
                num = NumberConst.IntDef.INT_TWENTY_ONE;

            }
            if (packNum.length() <= num  //验证有效位数
                    && ValidatorUtils.checkDecimal(packNum)     //验证Bigdecimal类型
                    && StringUtil.toBigDecimal(packNum)!=null       //过滤字符串+数字类型
                    &&!StringUtil.toBigDecimal(packNum).equals(BigDecimal.ZERO)) {  //过滤发货数量为0
                if (flag) {
                    packNum = "-" + packNum;
                }
                sc181103Param.setDistNum(StringUtil.toBigDecimal(packNum));
            } else {
                throw new BusinessException("发货数量不合法!");
            }
        }
    }

    /**
     * 下拉框选择
     * @param sC181103Param sc181103Param
     * @return 画面
     */
    @RequestMapping(value = "selectChange",
            method = RequestMethod.POST)
    public @ResponseBody
    List<SC181103Bean> selectChange(SC181103Param sC181103Param) {
        logger.debug("根据区域获取供应商下拉列表");
        this.setCommonParam(sC181103Param);
        // 获取供应商下拉框
        List<SC181103Bean> suppList = sc181103Logic.findSuppList(sC181103Param);

        return suppList;
    }
}
