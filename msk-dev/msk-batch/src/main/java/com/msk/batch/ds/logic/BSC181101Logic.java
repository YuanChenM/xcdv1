package com.msk.batch.ds.logic;

import com.msk.batch.ds.bean.BSC181101Param;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.entity.*;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * SCMGetDataLogic 业务处理类
 *
 * @author zhou_yajun 2016.01.27
 */
public class BSC181101Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSC181101Logic.class);

    /**
     * PDCODE_LENGTH
     */
    private static int PDCODE_LENGTH = 10;

    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private ProductLogic productLogic;

    /**
     * JSON Key值
     */
    private interface JsonKey {
        String JSON_RESULT_KEY = "result";
        String JSON_AREA_CODE_KEY = "areaCode";
        String JSON_SUP_LIST_KEY = "supList";
        String JSON_SUP_CODE_KEY = "supCode";
        String JSON_PRODUCT_LIST_KEY = "productList";
        String JSON_PRODUCT_CODE_KEY = "productCode";
        String JSON_CAMP_TYPE_KEY = "campType";
        String JSON_WAY_LIST_KEY = "wayList";
        String JSON_WAY_TYPE_KEY = "wayType";
        String JSON_PASS_DEMAND_KEY = "passDemand";
    }

    /**
     * 计划生产量标准
     */
    private interface PlanGenerationAmountStandard {
        BigDecimal STANDARD_ONE = new BigDecimal(IntDef.INT_ONE_HUNDRED_AND_FIFTY);
    }

    private interface SqlId {
        String SQL_ID_BATCH_EXIST_CHK = "existChk";
        String SQL_ID_BATCH_SAVE_VIRTUAL_STOCK_ACTUAL = "batchSaveVirtualStockActual";
        String SQL_ID_BATCH_SAVE_VIRTUAL_STOCK_PLAN = "batchSaveVirtualStockPlan";
        String SQL_ID_BATCH_FIND_PD_NORMSSTD = "findPdNormsStd";
        String SQL_ID_BATCH_FIND_PD_NORMSSTD_PROD = "findPdNormsStdProd";
    }

    // 初期化产品编号HashMap
    HashMap<String,DsSuppDistNum> planProdInfoMap = new HashMap<String,DsSuppDistNum>();

    /**
     * 设置供应商信息
     *
     * @param param     BSC181101Param
     * @param jsonArray Json Array
     */
    private void setSupplierInfo(BSC181101Param param, JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == IntDef.INT_ZERO) {
            logger.debug("没有供应商信息");
            return;
        }
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject supObject = jsonArray.getJSONObject(i);
            // 供应商编号
            param.setSuppCode(supObject.getString(JsonKey.JSON_SUP_CODE_KEY));
            // 供应商产品
            JSONArray productArray = supObject.getJSONArray(JsonKey.JSON_PRODUCT_LIST_KEY);
            this.setProductInfo(param, productArray);
        }
    }

    private void setProductInfo(BSC181101Param param, JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == IntDef.INT_ZERO) {
            logger.debug("没有供应商对应的产品信息");
            return;
        }
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject productObject = jsonArray.getJSONObject(i);
            param.setPdCode(productObject.getString(JsonKey.JSON_PRODUCT_CODE_KEY));
            param.setBrandType(productObject.getInt(JsonKey.JSON_CAMP_TYPE_KEY));
            JSONArray wayArray = productObject.getJSONArray(JsonKey.JSON_WAY_LIST_KEY);
            this.setWayInfo(param, wayArray);
        }
    }

    /**
     * @param distNumTon
     * @param halfCode
     * @return
     */
    private static BigDecimal[]  createPlanAmount(BigDecimal distNumTon,int halfCode) {
        BigDecimal[] planGenerationAmount = new BigDecimal[IntDef.INT_FIVE];
        int index = IntDef.INT_ZERO;
        planGenerationAmount[index++] = BigDecimal.ZERO;
        planGenerationAmount[index++] = BigDecimal.ZERO;
        planGenerationAmount[index++] = BigDecimal.ZERO;
        planGenerationAmount[index++] = BigDecimal.ZERO;
        planGenerationAmount[index++] = BigDecimal.ZERO;

        // 获得可以计划生产量次数
        BigDecimal num = DecimalUtil.divide(distNumTon, new BigDecimal(IntDef.INT_THIRTY));
        long yValue=0;
        long zValue = num.longValue() % IntDef.INT_FIVE;
        if(zValue==5 || zValue == 0) {
            zValue = 0;
        } else {
            zValue = IntDef.INT_FIVE-zValue;
        }
        yValue = (num.longValue() + zValue) / IntDef.INT_FIVE ;

        if(zValue == 0) {
                planGenerationAmount[0] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[1] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[2] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[3] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[4] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
        }
        if(zValue == 1) {
                planGenerationAmount[0] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[1] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[2] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[3] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[4] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue-1));
        }
        if(zValue == 2) {
                planGenerationAmount[0] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[1] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[2] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[3] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue-1));
                planGenerationAmount[4] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue-1));
        }
        if(zValue == 3) {
                planGenerationAmount[0] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[1] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[2] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue-1));
                planGenerationAmount[3] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue-1));
                planGenerationAmount[4] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue-1));
        }
        if(zValue == 4) {
                planGenerationAmount[0] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue));
                planGenerationAmount[1] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue-1));
                planGenerationAmount[2] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue-1));
                planGenerationAmount[3] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue-1));
                planGenerationAmount[4] = new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(yValue-1));
        }
        return planGenerationAmount;
    }
    /**
     * @param distNumTon
     * @return
     */
    private static BigDecimal[]  createPlanAmount(BigDecimal distNumTon) {
        BigDecimal[] planGenerationAmount = new BigDecimal[IntDef.INT_FIVE];
        int index = IntDef.INT_ZERO;
        planGenerationAmount[index++] = BigDecimal.ZERO;
        planGenerationAmount[index++] = BigDecimal.ZERO;
        planGenerationAmount[index++] = BigDecimal.ZERO;
        planGenerationAmount[index++] = BigDecimal.ZERO;
        planGenerationAmount[index++] = BigDecimal.ZERO;

        // 获得可以计划生产量次数
        BigDecimal num = DecimalUtil.divide(distNumTon, new BigDecimal(IntDef.INT_THIRTY));

        int intNum = num.intValue();
        for(int i=1; i<=intNum; i++) {
            planGenerationAmount[i-1] = new BigDecimal(IntDef.INT_THIRTY);
        }

        if(intNum < IntDef.INT_FIVE) {
            planGenerationAmount[intNum] = distNumTon.subtract(new BigDecimal(IntDef.INT_THIRTY).multiply(new BigDecimal(intNum)));
        }

        return planGenerationAmount;
    }

private List<DsPdVirtualStockPlan> createVirtualStockPlan(DsSuppDistNum suppDistNum) {

    // 数据检查
    String pdCode = suppDistNum.getPdCode();
    pdCode = pdCode + suppDistNum.getBrandType();
    suppDistNum.setPdCode(pdCode);
    if (pdCode.length() != PDCODE_LENGTH) {
        logger.info("产品编码不符合规范");
        return null;
    }
    ProductBean product = this.productLogic.getProductInfo(pdCode);
    if (product == null) {
        logger.info("产品编号:" + pdCode + "没有相关产品");
        return null;
    }

//    PdCountry pdCountries = product.getPdCountry();
    PdClasses classess = product.getPdClasses();
    PdMachining pdMachinings = product.getPdMachining();
    PdBreed bread = product.getPdBreed();
    PdFeature feature = product.getPdFeature();
    PdWeight pdWeights = product.getPdWeight();
    PdGrade grade = product.getPdGrade();
//    PdNormsStd pdNormsStd = product.getPdNormsStd();
//    if (pdCountries == null || classess == null || pdMachinings == null || bread == null
    if (classess == null || pdMachinings == null || bread == null
            || feature == null || pdWeights == null || grade == null) {
        logger.info("产品编号" + pdCode + "没有找到相应的Classess或者bread等相关信息");
        return null;
    }

    // 获取包装相关信息
    PdNormsStd pdNormsStd = new PdNormsStd();
    // TODO:test useful
//    pdNormsStd.setNormsCode("001");
//    pdNormsStd.setNormsOut("01");
//    pdNormsStd.setNormsKg("0");
    List<PdNormsStd> pdNormsStdList = getPdNormsStdList(product);
    if(pdNormsStdList ==null || pdNormsStdList.size() == 0) {
        logger.info("产品编号" + pdCode + "没有找到相应的包装编码等相关信息");
        return null;
    }

    pdNormsStd.setNormsCode(pdNormsStdList.get(0).getNormsCode());
    pdNormsStd.setNormsOut(pdNormsStdList.get(0).getNormsOut());
    if(pdNormsStdList.get(0).getNormsKg() != null) {
        pdNormsStd.setNormsKg(pdNormsStdList.get(0).getNormsKg());
    } else {
        pdNormsStd.setNormsKg("0");
    }

    product.setPdNormsStd(pdNormsStd);
    // 半旬计划数据作成。
    // 单位为千克
    BigDecimal distNum = suppDistNum.getDistNum();
    // 单位吨
    BigDecimal distNumTon = DecimalUtil.divide(distNum, new BigDecimal(IntDef.INT_THOUSAND));
    BigDecimal[] planGenerationAmount = null;
    // 当期计划生产量≤150吨时
    // 30N÷30＝N（1、2、3、4、5）不足5个补0数据
    if (distNumTon.compareTo(PlanGenerationAmountStandard.STANDARD_ONE) <= IntDef.INT_ZERO) {
        planGenerationAmount = this.createPlanAmount(distNumTon);
    } else {
        planGenerationAmount = this.createPlanAmount(distNumTon, 0);
    }

    List<DsPdVirtualStockPlan> virtualStockPlanList = new ArrayList<DsPdVirtualStockPlan>();
    // 各产品虚拟库存作成
    for (int i=1; i<=4; i++) {
        // 生产期虚拟库存作成
        if(i == 1) {
            for (int j=0; j<5;j++) {
                String pdStockType = "" + i;
                String halfCode = "" + (j+1);
                createOnePlan(virtualStockPlanList,suppDistNum,product,pdStockType,halfCode,planGenerationAmount[j]);
            }
            // 第六个半旬
            createOnePlan(virtualStockPlanList,suppDistNum,product,"1","6",new BigDecimal(0));
        }
        // 待运库虚拟库存作成
        if(i == 2) {
            // 第1个半旬
            createOnePlan(virtualStockPlanList,suppDistNum,product,"2","1",new BigDecimal(0));
            for (int j=0; j<5;j++) {
                String pdStockType = "" + i;
                String halfCode = "" + (j+2);
                createOnePlan(virtualStockPlanList,suppDistNum,product,pdStockType,halfCode,planGenerationAmount[j]);
            }
        }
        // 在途虚拟库存作成
        if(i == 3) {
            // 第1个半旬
            createOnePlan(virtualStockPlanList,suppDistNum,product,"3","1",new BigDecimal(0));
            for (int j=0; j<5;j++) {
                String pdStockType = "" + i;
                String halfCode = "" + (j+2);
                createOnePlan(virtualStockPlanList,suppDistNum,product,pdStockType,halfCode,planGenerationAmount[j]);
            }
        }
        // 入销售库虚拟库存作成
        if(i == 4) {
            // 第1个半旬
            createOnePlan(virtualStockPlanList,suppDistNum,product,"4","1",new BigDecimal(0));
            for (int j=0; j<5;j++) {
                String pdStockType = "" + i;
                String halfCode = "" + (j+2);
                createOnePlan(virtualStockPlanList,suppDistNum,product,pdStockType,halfCode,planGenerationAmount[j]);
            }
        }
    }
    return virtualStockPlanList;
}
    private void createOnePlan(List<DsPdVirtualStockPlan> virtualStockPlanList,
                                        DsSuppDistNum suppDistNum,
                                        ProductBean product,
                                        String pdStockType,
                                        String halfCode,
                                        BigDecimal planGenerationAmount) {
        DsPdVirtualStockPlan virtualStockPlan = new DsPdVirtualStockPlan();
        virtualStockPlan.setSuppDsId(suppDistNum.getSuppDsId());
        virtualStockPlan.setDistMonth(suppDistNum.getDistMonth());
        virtualStockPlan.setLgcsCode(suppDistNum.getLgcsCode());
        virtualStockPlan.setSuppCode(suppDistNum.getSuppCode());
        virtualStockPlan.setPdStockType(pdStockType);
        virtualStockPlan.setHalfCode(halfCode);
        virtualStockPlan.setClassesCode(product.getPdClasses().getClassesCode());
        virtualStockPlan.setBreedCode(product.getPdBreed().getBreedCode());
        virtualStockPlan.setFeatureCode(product.getPdFeature().getFeatureCode());
        virtualStockPlan.setGradeCode(product.getPdGrade().getGradeCode());
        virtualStockPlan.setNormsCode(product.getPdNormsStd().getNormsCode());
        virtualStockPlan.setOutSpec(product.getPdNormsStd().getNormsOut());
        virtualStockPlan.setOutNw(product.getPdWeight().getWeightVal());
        virtualStockPlan.setPdCode(suppDistNum.getPdCode());
        virtualStockPlan.setAdjustDate(suppDistNum.getCrtTime());
        virtualStockPlan.setCrtId(suppDistNum.getCrtId());
        virtualStockPlan.setCrtTime(suppDistNum.getCrtTime());
        virtualStockPlan.setOrigPlanNum(planGenerationAmount);
        virtualStockPlan.setOldPlanNum(planGenerationAmount);
        virtualStockPlan.setNewPlanNum(planGenerationAmount);
        virtualStockPlanList.add(virtualStockPlan);
    }

    private void batchSaveVirtualStockPlan(List<DsPdVirtualStockPlan> virtualStockPlanList) {
        for (DsPdVirtualStockPlan virtualStockPlan : virtualStockPlanList) {
            long virtualStockPlanId = this.commonLogic.maxId("DS_PD_VIRTUAL_STOCK_PLAN", "VIRTUAL_STOCK_PLAN_ID");
            virtualStockPlan.setVirtualStockPlanId(virtualStockPlanId);
            virtualStockPlan.setOrigPlanNum(virtualStockPlan.getOrigPlanNum().multiply(new BigDecimal(IntDef.INT_THOUSAND)));
            virtualStockPlan.setOldPlanNum(virtualStockPlan.getOldPlanNum().multiply(new BigDecimal(IntDef.INT_THOUSAND)));
            virtualStockPlan.setNewPlanNum(virtualStockPlan.getNewPlanNum().multiply(new BigDecimal(IntDef.INT_THOUSAND)));
            this.save(SqlId.SQL_ID_BATCH_SAVE_VIRTUAL_STOCK_PLAN, virtualStockPlan);
            long virtualStockActualId = this.commonLogic.maxId("DS_PD_VIRTUAL_STOCK_ACTUAL","VIRTUAL_STOCK_ACTUAL_ID");
            BaseParam param = new BaseParam();
            param.setFilter("virtualStockPlanId",String.valueOf(virtualStockPlanId));
            param.setFilter("virtualStockActualId",String.valueOf(virtualStockActualId));
            this.save(SqlId.SQL_ID_BATCH_SAVE_VIRTUAL_STOCK_ACTUAL,param);
        }
    }

    private void setWayInfo(BSC181101Param param, JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == IntDef.INT_ZERO) {
            logger.debug("没有供应商对应的产品信息");
            return;
        }

        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject wayObject = jsonArray.getJSONObject(i);
            param.setDistType(wayObject.getInt(JsonKey.JSON_WAY_TYPE_KEY));
            param.setDistNum(new BigDecimal(wayObject.getDouble(JsonKey.JSON_PASS_DEMAND_KEY)));
            DsSuppDistNum suppDistNum = setScSuppDistNumEntity(param);

            // todo:debug
            printLog(suppDistNum);

            String planProdInfoKey = suppDistNum.getDistMonth()
                    + suppDistNum.getLgcsCode()
                    + suppDistNum.getSuppCode()
                    + suppDistNum.getPdCode()
                    ;
            // 查询有没有数据，没有插入
            BSC181101Param baseParam = new BSC181101Param();
            baseParam.setFilter("distMonth",suppDistNum.getDistMonth());
            baseParam.setFilter("lgcsCode",String.valueOf(suppDistNum.getLgcsCode()));
            baseParam.setFilter("suppCode",String.valueOf(suppDistNum.getSuppCode()));
            baseParam.setFilter("pdCode",String.valueOf(suppDistNum.getPdCode()));
            baseParam.setFilter("brandType",String.valueOf(suppDistNum.getBrandType()));
            baseParam.setFilter("distType",String.valueOf(suppDistNum.getDistType()));
            if (super.getCount(SqlId.SQL_ID_BATCH_EXIST_CHK, baseParam) == IntDef.INT_ZERO) {
                suppDistNum.setSuppDsId(this.commonLogic.maxId("DS_SUPP_DIST_NUM", "SUPP_DS_ID"));
                super.save(suppDistNum);
//                List<DsPdVirtualStockPlan> virtualStockPlanList = this.createVirtualStockPlan(suppDistNum);
//                this.batchSaveVirtualStockPlan(virtualStockPlanList);
                if(planProdInfoMap.containsKey(planProdInfoKey)) {
                    // 存在，数量增加。
                    BigDecimal oldNum = planProdInfoMap.get(planProdInfoKey).getDistNum();
                    oldNum = oldNum.add(suppDistNum.getDistNum());
                    planProdInfoMap.get(planProdInfoKey).setDistNum(oldNum);
                } else {
                    // 不存在，追加作成。
                    planProdInfoMap.put(planProdInfoKey, suppDistNum);
                }
            }
        }
    }
private void printLog(DsSuppDistNum suppDistNum ){
    StringBuffer log = new StringBuffer("");
    log.append("getDistMonth=" + suppDistNum.getDistMonth());
    log.append(" || getLgcsCode=" + suppDistNum.getLgcsCode());
    log.append(" || getSuppCode=" + suppDistNum.getSuppCode());
    log.append(" || getPdCode=" + suppDistNum.getPdCode());
    log.append(" || getBrandType=" + suppDistNum.getBrandType());
    log.append(" || getDistType=" + suppDistNum.getDistType());
    System.out.println(log.toString());
}
    /**
     * 数据处理插入DB
     *
     * @param param param
     */
    @Transactional
    public void setSuppDistNum(BaseParam param) {
        logger.info("数据处理开始");
        BSC181101Param scm01Param = (BSC181101Param) param;
        JSONObject jsonObject = scm01Param.getJsonData();
        // 获得JSON Result 结果集合
        JSONArray resultArray = jsonObject.getJSONArray(JsonKey.JSON_RESULT_KEY);
        // Check Result结果是否为空
        if (resultArray == null || resultArray.length() == IntDef.INT_ZERO) {
            logger.debug("没有可用结果可以操作,程序结束.");
            return;
        }
        // 获得系统当前时间
        Date customerDate = DateTimeUtil.getCustomerDate();
        // 设置共通字段
        scm01Param.setActId("Batch");
        scm01Param.setActTime(customerDate);
        scm01Param.setCrtId("Batch");
        scm01Param.setCrtTime(customerDate);
        for (int i = 0; i < resultArray.length(); i++) {
            JSONObject resultObject = resultArray.getJSONObject(i);
            scm01Param.setDistMonth(getDistMonth());

            scm01Param.setLgcsCode(resultObject.getString(JsonKey.JSON_AREA_CODE_KEY));
            JSONArray supArray = resultObject.getJSONArray(JsonKey.JSON_SUP_LIST_KEY);
            this.setSupplierInfo(scm01Param, supArray);
        }

        // 保存计划数据
        Iterator iter = planProdInfoMap.values().iterator();
        while (iter.hasNext()) {
            DsSuppDistNum entry = (DsSuppDistNum) iter.next();
            List<DsPdVirtualStockPlan> virtualStockPlanList = this.createVirtualStockPlan(entry);
            if(virtualStockPlanList != null && virtualStockPlanList.size() > 0) {
                this.batchSaveVirtualStockPlan(virtualStockPlanList);
            }
        }
    }

    /**
     * 获取分销月度
     *
     * @return string
     */
    public String getDistMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        String distMonth = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_YYYYMMDD, calendar.getTime());
        return distMonth.substring(IntDef.INT_ZERO, IntDef.INT_SIX);
    }

    /**
     * 设置传入DB的Entity
     *
     * @param param 传入参数
     * @return ScSuppDistNum
     */
    public DsSuppDistNum setScSuppDistNumEntity(BSC181101Param param) {
        DsSuppDistNum suppDistNum = new DsSuppDistNum();
        suppDistNum.setDistMonth(param.getDistMonth());
        suppDistNum.setLgcsCode(param.getLgcsCode());
        suppDistNum.setPdCode(param.getPdCode());
        suppDistNum.setSuppCode(param.getSuppCode());
        suppDistNum.setBrandType(param.getBrandType());
        suppDistNum.setDistType(param.getDistType());
        suppDistNum.setDistNum(param.getDistNum());
        suppDistNum.setActId(param.getActId());
        suppDistNum.setActTime(param.getActTime());
        suppDistNum.setCrtId(param.getCrtId());
        suppDistNum.setCrtTime(param.getCrtTime());
        suppDistNum.setUpdId(param.getCrtId());
        suppDistNum.setUpdTime(DateTimeUtil.getCustomerDate());
        suppDistNum.setVer(IntDef.INT_ONE);
        return suppDistNum;
    }

    /**
     * 包装编码获取
     *
     * @param product ProductBean
     * @return PdNormsStd List
     * @author gyh
     */
    public List<PdNormsStd> getPdNormsStdList (ProductBean product) {
        logger.debug("包装编码获取");

        // 从卖家系统获取包装编码信息
        BaseParam param = new BaseParam();
//        param.setFilter("countryCode", product.getPdCountry().getCountryCode());
        param.setFilter("classesCode", product.getPdClasses().getClassesCode());
        param.setFilter("machiningCode", product.getPdMachining().getMachiningCode());
        param.setFilter("breedCode", product.getPdBreed().getBreedCode());
        param.setFilter("featureCode", product.getPdFeature().getFeatureCode());
        param.setFilter("weightCode", product.getPdWeight().getWeightCode());
        param.setFilter("gradeCode", product.getPdGrade().getGradeCode());
//        ProductBean productBean = new ProductBean();
        List<PdNormsStd> pdNormsStd = this.findList(SqlId.SQL_ID_BATCH_FIND_PD_NORMSSTD, param);

        // 从产品系统获取包装编码信息
        if(pdNormsStd == null || pdNormsStd.size()==0) {
            pdNormsStd = this.findList(SqlId.SQL_ID_BATCH_FIND_PD_NORMSSTD_PROD, param);
        }
        return pdNormsStd;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
