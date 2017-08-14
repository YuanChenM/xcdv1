package com.msk.ds.logic;

import com.msk.common.logic.CommonLogic;import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.msk.ds.bean.*;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.CommConstant;
import com.msk.core.exception.BusinessException;import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * DS174101Logic.
 *
 * @author pxg
 * @version 1.0
 **/
@Service
public class SC183101Logic extends BaseLogic {
    /**
     * 1:供货商月度管控画面，2:供应商产品计划调整一览画面
     */
    static final String STRING_ONE = "1";
    static final String STRING_TWO = "2";
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC183101Logic.class);
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private DistSuppChainLogic distSuppChainLogic;
    @Autowired
    private ProductLogic productLogic;
    /**
     * SQL Map 中SQL ID定义
     * @author zhou_yajun
     */
    interface SqlId{
        String SQL_GET_PLAN_CHANGE_PRODUCT_LIST = "findPlanChangeProductList";
        String SQL_GET_PLAN_CHANGE_PRODUCT_LIST_BY_ID = "findPlanChangeProductListById";
        String SQL_MODIFY_DELETE_FLAG = "modifyDeleteFlag";
        String SQL_MODIFY_CHANGE_PRODUCT = "modifyData";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    /**
     * 获取传出对象
     * @param sc183101Param param
     * @return SC183101Param
     */
    public PlanAdjust getHalfName(SC183101Param sc183101Param){
        //传出对象
        PlanAdjust planAdjust = new PlanAdjust();
        //产品名称
        String productName = null;
        //点击的半旬Code
        String currentHalfCode = null;
        //点击的计划类型
        String planType = null;
        //点击的调整时间
        String adjustDate = null;
        //点击的按钮名称(XXX_ProductName_HalfCode_PlanType)
        String buttonName = sc183101Param.getButtonName();

        if(STRING_ONE.equals(sc183101Param.getEntryMark()) && buttonName!=null){
            //点击的按钮对应的产品
            productName = buttonName.split("_")[NumberConst.IntDef.INT_ONE];
            //点击的按钮是第几个半旬
            currentHalfCode = buttonName.split("_")[NumberConst.IntDef.INT_TWO];
            //点击的按钮是所在的计划类型
            planType = buttonName.split("_")[NumberConst.IntDef.INT_THREE];
            //调整时间
            adjustDate = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, DateTimeUtil.getCustomerDate());
            //添加检索条件
            sc183101Param.setCurrentHalfCode(currentHalfCode);
            sc183101Param.setProductName(productName);
            sc183101Param.setPlanType(planType);
            planAdjust.setAreaCode(sc183101Param.getAreaCode());
            planAdjust.setSupplierCode(sc183101Param.getSupplierCode());
            planAdjust.setHalfCode(sc183101Param.getHalfCode());
        }else if(STRING_TWO.equals(sc183101Param.getEntryMark())){
            productName = sc183101Param.getProductName();
            currentHalfCode = sc183101Param.getCurrentHalfCode();
            adjustDate = sc183101Param.getAdjustDate();
            planAdjust.setSuppDsId(sc183101Param.getSuppDsId());
            planAdjust.setVirtualStockPlanId(sc183101Param.getVirtualStockPlanId());
            planType = sc183101Param.getPlanType();
            planAdjust.setAreaCode(sc183101Param.getAreaCode());
            planAdjust.setSupplierCode(sc183101Param.getSupplierCode());
        } else {
            //selectChange的情况下
            productName = sc183101Param.getProductName();
            planType = sc183101Param.getPlanType();
            currentHalfCode = sc183101Param.getCurrentHalfCode();
            adjustDate = sc183101Param.getAdjustDate();
            planAdjust.setHalfCode(sc183101Param.getHalfCode());
        }

        //获得调整前的数据
        List<PlanAdjust> planChangeProductList = findPlanChangeProduct(sc183101Param);
        planAdjust.setPlanChangeProductList(planChangeProductList);
        //获取传出数据
        planAdjust.setDistMonth(sc183101Param.getDistMonth());
        planAdjust.setAreaName(sc183101Param.getAreaName());
        planAdjust.setSupplierName(sc183101Param.getSupplierName());
        planAdjust.setClassName(productName);
        planAdjust.setCurrentHalfCode(currentHalfCode);
        planAdjust.setPlanType(planType);
        planAdjust.setAdjustDate(adjustDate);
        planAdjust.setEntryMark(sc183101Param.getEntryMark());
        //获取计划类型下拉数据
        planAdjust.setPlanList(getPlanTypeList(sc183101Param,planType));
        //获取显示的半旬下拉数据
        planAdjust.setHalfNameList(getHalfList(sc183101Param,currentHalfCode,planType));

        //获得调整前的数据合计
        BigDecimal sumChangeBeforeNum = BigDecimal.ZERO;
        if(!CollectionUtils.isEmpty(planChangeProductList)){
            for(int i = 0;i < planChangeProductList.size();i++){
                PlanAdjust planAdjust1 = planChangeProductList.get(i);
                String productFullName = planAdjust1.getClassName() + planAdjust1.getBreedName() + planAdjust1.getFeatureName() + planAdjust1.getGradeName();
                String productFullCode = planAdjust1.getClassCode() + planAdjust1.getBreedCode() + planAdjust1.getFeatureCode() + planAdjust1.getGradeCode();
                planAdjust1.setProductName(productFullName);
//                planAdjust1.setProductCode(productFullCode);
                sumChangeBeforeNum = sumChangeBeforeNum.add(planChangeProductList.get(i).getChangeBeforeNum());
            }
        }
        planAdjust.setSumChangeBeforeNum(sumChangeBeforeNum);

        return planAdjust;
    }

    /**
     * 获取变更前数据
     * @param sc183101Param sc183101Param
     * @return
     */
    public List<PlanAdjust> findPlanChangeProduct(SC183101Param sc183101Param){
        List<PlanAdjust> planChangeProductList = null;
        if("1".equals(sc183101Param.getEntryMark())) {
            sc183101Param.setProductName(DbUtils.buildLikeCondition(sc183101Param.getProductName(), DbUtils.LikeMode.FRONT));
            planChangeProductList = this.findList(SqlId.SQL_GET_PLAN_CHANGE_PRODUCT_LIST, sc183101Param);
        }else{
            planChangeProductList = this.findList(SqlId.SQL_GET_PLAN_CHANGE_PRODUCT_LIST_BY_ID, sc183101Param);
        }

        setProductInfo(planChangeProductList);
        return planChangeProductList;
    }

    /**
     * 设置产品信息
     * @param planChangeProductList
     */
    private void setProductInfo(List<PlanAdjust> planChangeProductList) {

        if(!CollectionUtils.isEmpty(planChangeProductList)){
            for(PlanAdjust data : planChangeProductList){
                //根据产品Code获取产品信息
                ProductBean product = productLogic.getProductInfo(data.getProductCode());
                if (product == null) {
                    logger.info("产品编号:" + data.getProductCode() + "没有相关产品");
                    throw new BusinessException("产品编号:" + data.getProductCode() + "没有相关产品");
                }

                if(product.getPdClasses() != null){
                    data.setProductName(product.getPdClasses().getClassesName());
                }
                if(product.getPdBreed() != null){
                    data.setBreedName(product.getPdBreed().getBreedName());
                }
                if(product.getPdFeature() != null){
                    data.setFeatureName(product.getPdFeature().getFeatureName());
                }
                if(product.getPdGrade() != null){
                    data.setGradeName(product.getPdGrade().getGradeName());
                }
            }
        }
    }

    /**
     * 调整数据保存到DB
     * @param param
     */
    public void saveChangeNum(SC183101Param param){
        Map<String, Object> paramMap = param.getFilterMap();
        SC183101Param param1 = null;
        for (SC183101ProductParam entity : param.getProductParamList()) {
            param1 = new SC183101Param();
            param1.setDistMonth(paramMap.get("distMonth").toString());
            param1.setAreaCode(paramMap.get("areaCode").toString());
            param1.setSupplierCode(paramMap.get("supplierCode").toString());
            param1.setPlanType(paramMap.get("planType").toString());
            param1.setCurrentHalfCode(paramMap.get("halfCode").toString());
            param1.setProductCode(entity.getProductCode());
            param1.setNormsCode(entity.getNormsCode());
            param1.setAdjustDate(entity.getAdjustDate());
            param1.setChangeBeforeNum(entity.getChangeBeforeNum());
            param1.setChangeOverNum(entity.getChangeOverNum());
            long virtualStockPlanId = this.commonLogic.maxId("DS_PD_VIRTUAL_STOCK_PLAN", "VIRTUAL_STOCK_PLAN_ID");
            param1.setVirtualStockPlanId(virtualStockPlanId);
            param1.setCrtId(param.getCrtId());
            param1.setUpdId(param.getUpdId());
            param1.setCrtTime(DateTimeUtil.getCustomerDate());
            param1.setUpdTime(DateTimeUtil.getCustomerDate());

            if (STRING_ONE.equals(paramMap.get("entryMark").toString())) {
                if (super.save(param1) == NumberConst.IntDef.INT_ZERO) {
                    throw new BusinessException("更新失败，请和管理员联系");
                }
                if (super.modify(SqlId.SQL_MODIFY_DELETE_FLAG, param1) == NumberConst.IntDef.INT_ZERO) {
                    throw new BusinessException("更新失败，请和管理员联系");
                }
                ;
            } else {
                param1.setSuppDsId(Long.parseLong(paramMap.get("suppDsId").toString()));
                param1.setVirtualStockPlanId(Long.parseLong(paramMap.get("virtualStockPlanId").toString()));
                if (super.modify(SqlId.SQL_MODIFY_CHANGE_PRODUCT, param1) == NumberConst.IntDef.INT_ZERO) {
                    throw new BusinessException("更新失败，请和管理员联系");
                }
                ;
            }
        }

    }

    /**
     * 获取计划类型下拉数据
     * @param sc183101Param 传入对象
     * @param planType 点击的计划类型code
     * @return 计划类型List
     */
    public List<PlanAdjust> getPlanTypeList(SC183101Param sc183101Param,String planType){
        List<PlanAdjust> planList = new ArrayList<>();
        List<CommConstant> commPlanList = distSuppChainLogic.findPlanTypeList();
        for(int i = 0;i<commPlanList.size();i++){
            PlanAdjust planAdjust = new PlanAdjust();
            if(STRING_ONE.equals(sc183101Param.getEntryMark())){
                planAdjust.setPlanType(commPlanList.get(i).getConstantValue());
                planAdjust.setPlanTypeName(commPlanList.get(i).getConstantName());
            }else if(STRING_TWO.equals(sc183101Param.getEntryMark())){
                if(planType.equals(commPlanList.get(i).getConstantValue())){
                    planAdjust.setPlanType(commPlanList.get(i).getConstantValue());
                    planAdjust.setPlanTypeName(commPlanList.get(i).getConstantName());
                    planList.add(planAdjust);
                    break;
                }
            }
            planList.add(planAdjust);
        }
        return planList;
    }
    /**
     * 获取显示的半旬下拉数据
     * @param sc183101Param 传入对象
     * @param currentHalfCode 点击的半旬编码
     * @return 半旬List
     */
    public List<DistSuppChain> getHalfList(SC183101Param sc183101Param,String currentHalfCode,String planType){
        int year = Integer.parseInt(sc183101Param.getDistMonth().substring(NumberConst.IntDef.INT_ZERO,NumberConst.IntDef.INT_FOUR));
        int month = Integer.parseInt(sc183101Param.getDistMonth().substring(NumberConst.IntDef.INT_FOUR, NumberConst.IntDef.INT_SIX));
        List<DistSuppChain> halfNameList = new ArrayList<>();
        String halfName = null;
        if(STRING_ONE.equals(sc183101Param.getEntryMark())){
            //当前半旬
            int halfCode = Integer.parseInt(sc183101Param.getHalfCode());
            halfNameList = distSuppChainLogic.getHalfNameList(sc183101Param.getDistMonth(),halfCode);
//            if(STRING_ONE.equals(planType)){
//                halfNameList.remove(halfNameList.size() - 1);
//            }
        }else if(STRING_TWO.equals(sc183101Param.getEntryMark())){
            DistSuppChain hslfParam = new DistSuppChain();
            if(STRING_ONE.equals(currentHalfCode) || STRING_TWO.equals(currentHalfCode)){
                if(month == NumberConst.IntDef.INT_ONE) {
                    halfName = distSuppChainLogic.getHalfName(NumberConst.IntDef.INT_TWELVE, Integer.parseInt(currentHalfCode), year - NumberConst.IntDef.INT_ONE);
                }else {
                    halfName = distSuppChainLogic.getHalfName(month - NumberConst.IntDef.INT_ONE, Integer.parseInt(currentHalfCode), year);
                }
            }else {
                halfName = distSuppChainLogic.getHalfName(month, Integer.parseInt(currentHalfCode), year);
            }
            hslfParam.setHalfCode(currentHalfCode);
            hslfParam.setHalfName(halfName);
            halfNameList.add(hslfParam);
        }
        return halfNameList;
    }
}
