package com.msk.ds.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.CommConstant;
import com.msk.core.entity.PdGrade;
import com.msk.core.entity.PdNormsStd;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.utils.ValidatorUtils;
import com.msk.ds.bean.SC181103Bean;
import com.msk.ds.bean.SC181103Param;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 发货计划单录入
 *
 * @author li_kai1 on 2016/6/12.
 */
@Service
public class SC181103Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC181103Logic.class);
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private ProductLogic productLogic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_yajun
     */
    //TODO
    interface SqlId {
        String SQL_SAVE_DIST_NUM = "saveDistNum";   //保存到供应商分销数量表
        String SQL_SAVE_PD_VIRTUAL_STOCK_ACTUAL = "saveStockActual";    //保存到产品虚拟库存实际表
        String SQL_SAVE_PD_VIRTUAL_STOCK_PLAN = "saveStockPlan";    //保存到产品虚拟库存计划表
        //        String SQL_ID_FIND_MONTH = "findMonth"; // 查询月份
        String SQL_ID_FIND_AREA_LIST = "findAreaList"; // 查询区域list
        String SQL_ID_FIND_SUPP_LIST = "findSuppList"; // 查询供应商List
        String SQL_ID_FIND_PRODUCT_GRADE = "findPdGradeList";  //查询产品等级List

        String SQL_CHECK_PLAN_NUM = "checkPlanNum";
        String SQL_CHECK_ACTUAL_NUM = "checkActualNum";
//        String SQL_BATCH_SAVE_PLAN = "batchSavePlan";
//        String SQL_BATCH_SAVE_ACTUAL ="batchSaveActual";
    }

    interface halfDeparture {
        // 21号
        int DEPARTURE_1 = 21;
        // 26号
        int DEPARTURE_2 = 26;
        // 1号
        int DEPARTURE_3 = 1;
        // 6号
        int DEPARTURE_4 = 6;
        // 11号
        int DEPARTURE_5 = 11;
        // 16号
        int DEPARTURE_6 = 16;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 创建供应分销流水ID
     *
     * @return 供应分销流水ID
     */
    public long creatSuppDsId() {
        return commonLogic.maxId("DS_SUPP_DIST_NUM", "SUPP_DS_ID");
    }

    /**
     * 创建虚拟库存实际流水ID
     *
     * @return 虚拟库存实际流水ID
     */
    public long creatStockActualId() {
        return commonLogic.maxId("DS_PD_VIRTUAL_STOCK_ACTUAL", "VIRTUAL_STOCK_ACTUAL_ID");
    }

    /**
     * 创建虚拟库存计划流水ID
     *
     * @return 虚拟库存计划流水ID
     */
    public long creatStockPlanId() {

        return commonLogic.maxId("DS_PD_VIRTUAL_STOCK_PLAN", "VIRTUAL_STOCK_PLAN_ID");
    }

    /**
     * 保存数据到供应商分销数量表
     *
     * @param sc181103Param
     */
    public void saveDistNum(SC181103Param sc181103Param) {

        /**设置供应分销流水ID*/
        sc181103Param.setSuppDsId(creatSuppDsId());
        /**设置分销通道(固定值4)*/
        sc181103Param.setDistType(NumberConst.IntDef.INT_FOUR);
        /**设置分销数量*/
//        sc181103Param.setDistNum(sc181103Param.getPackNum());
        /**获得系统当前时间*/
        Date customerDate = DateTimeUtil.getCustomerDate();
        /**设置共通字段*/
        sc181103Param.setActId("Batch");
        sc181103Param.setActTime(customerDate);
        sc181103Param.setCrtId("Batch");
        sc181103Param.setCrtTime(customerDate);

        //设置产品编码（原9位）
        sc181103Param.setPdCode(sc181103Param.getPdCode() + sc181103Param.getGradeCode());
        /**验证插入数据非空*/
        if (StringUtil.isNullOrEmpty(sc181103Param.getDistMonth()) || StringUtil.isNullOrEmpty(sc181103Param.getLgcsCode())
                || StringUtil.isNullOrEmpty(sc181103Param.getSuppCode()) || StringUtil.isNullOrEmpty(sc181103Param.getPdCode())
                || StringUtil.isNullOrEmpty(sc181103Param.getGradeCode())
                || sc181103Param.getBrandType() <= NumberConst.IntDef.INT_ZERO
                || !DateTimeUtil.isValidDate(sc181103Param.getCrtTime())
                ) {
            throw new BusinessException("数据存在空值");
        } else {
            int resultNum = this.save(SqlId.SQL_SAVE_DIST_NUM, sc181103Param);
            if (resultNum > NumberConst.IntDef.INT_ZERO) {
                logger.info("供应商分销数量表保存数据成功");
            } else {
                logger.info("供应商分销数量表保存数据失败");
                throw new BusinessException("数据有误插入失败！请联系管理员");
            }
        }
    }

    /**
     * 设置产品虚拟库存计划表和实际表信息
     *
     * @param sc181103Param
     */

    public List<SC181103Param> setStockPlanAndActual(SC181103Param sc181103Param) {

        //保存数据的list
        List<SC181103Param> dataList = new ArrayList<SC181103Param>();

        /**计算半旬和分销月度，插入四条数据*/
        String halfCode = sc181103Param.getHalfCode();
        String distMonth = sc181103Param.getDistMonth();
        for (int i = NumberConst.IntDef.INT_ONE; i < NumberConst.IntDef.INT_FIVE; i++) {
            SC181103Param param = new SC181103Param();
            BeanUtils.copyProperties(sc181103Param, param);
            Integer distMonthNum = StringUtil.toInteger(distMonth);
            Integer halfCodeNum = StringUtil.toInteger(halfCode);

            int tempHalfCode = (halfCodeNum + i - NumberConst.IntDef.INT_TWO) % NumberConst.IntDef.INT_SIX;
            if (tempHalfCode == NumberConst.IntDef.INT_ZERO) {
                halfCodeNum = NumberConst.IntDef.INT_SIX;
            } else {
                halfCodeNum = tempHalfCode;
            }

            switch (halfCodeNum) {
                case NumberConst.IntDef.INT_ONE :
                    if (i == NumberConst.IntDef.INT_THREE || i == NumberConst.IntDef.INT_FOUR){
                        distMonthNum = distMonthNum + NumberConst.IntDef.INT_ONE;
                    }
                    break;
                case NumberConst.IntDef.INT_TWO :
                    if (i == NumberConst.IntDef.INT_FOUR){
                        distMonthNum = distMonthNum + NumberConst.IntDef.INT_ONE;
                    }
                    break;
                case NumberConst.IntDef.INT_SIX :
                    if (i == NumberConst.IntDef.INT_ONE){
                        distMonthNum = distMonthNum - NumberConst.IntDef.INT_ONE;
                    }
                    break;
            }


            /**设置计划录入日期和计划数量*/
            BigDecimal packNum = StringUtil.toBigDecimal(param.getDistNum());
            /**取保存数据到分销数量表的时间为录入时间*/
            param.setAdJustDate(sc181103Param.getCrtTime());
            param.setOrigPlanNum(packNum);
            param.setOldPlanNum(packNum);
            param.setNewPlanNum(packNum);

            /**设置实际录入日期和数量数量*/
            param.setOldActualNum(packNum);
            param.setNewActualNum(packNum);
            param.setInputDate(sc181103Param.getCrtTime());

            //设置分销月度
            param.setDistMonth(distMonthNum.toString());
            //设置半旬码
            param.setHalfCode(halfCodeNum.toString());

            //设置虚拟库存计划流水Id
//            param.setStockPlanId(creatStockPlanId());
            //设置虚拟库存实际流水Id
//            param.setStockActualId(creatStockActualId());

            //设置产品库存类型
            Integer stockTypeNum = (Integer) i;
            param.setPdStockType(stockTypeNum.toString());
            /**验证数据是否为空*/
            if (StringUtil.isNullOrEmpty(param.getPdStockType()) || StringUtil.isNullOrEmpty(param.getHalfCode())
                    || StringUtil.isNullOrEmpty(param.getClassesCode()) || StringUtil.isNullOrEmpty(param.getFeatureCode())
                    || StringUtil.isNullOrEmpty(param.getProductSpecifical()) || StringUtil.isNullOrEmpty(param.getBreedCode())
                    || StringUtil.isNullOrEmpty(param.getNormsCode())
                    ) {
                throw new BusinessException("要保存的产品不存在！");
            }
            dataList.add(param);

        }
        return dataList;
    }

    /**
     * 产品虚拟库存实际表和计划表数据处理
     *
     * @param dataList
     */
    @Transactional
    public void saveStockPlanAndActual(List<SC181103Param> dataList) {
        if (CollectionUtils.isNotEmpty(dataList)) {
            //初始化数据
            for (SC181103Param checkParam : dataList) {
                initData(checkParam, SqlId.SQL_SAVE_PD_VIRTUAL_STOCK_PLAN);

                initData(checkParam, SqlId.SQL_SAVE_PD_VIRTUAL_STOCK_ACTUAL);

            }
            for (SC181103Param saveParam : dataList) {
                SC181103Param sc181103Param = new SC181103Param();
                BeanUtils.copyProperties(saveParam, sc181103Param);
                //设置虚拟库存计划流水Id
                sc181103Param.setStockPlanId(creatStockPlanId());
                //设置虚拟库存实际流水Id
                sc181103Param.setStockActualId(creatStockActualId());
                int planRsNum = this.save(SqlId.SQL_SAVE_PD_VIRTUAL_STOCK_PLAN, sc181103Param);
                int actualRsNum = this.save(SqlId.SQL_SAVE_PD_VIRTUAL_STOCK_ACTUAL, sc181103Param);
                if (planRsNum > NumberConst.IntDef.INT_ZERO) {
                    logger.info("产品虚拟库存计划表保存数据成功");
                } else {
                    logger.info("产品虚拟库存计划表保存数据失败");
                    throw new BusinessException("数据有误插入失败！请联系管理员");
                }
                if (actualRsNum > NumberConst.IntDef.INT_ZERO) {
                    logger.info("产品虚拟库存实际表保存数据成功");
                } else {
                    logger.info("产品虚拟库存实际表保存数据失败");
                    throw new BusinessException("数据有误插入失败！请联系管理员");
                }
            }

        }

    }

    /**
     * 补全初始化数据
     *
     * @param sc181103Param
     */
    @Transactional
    public Boolean checkMonthData(SC181103Param sc181103Param, String sqlId) {
        //查询DB是否存在该数据
        if (SqlId.SQL_SAVE_PD_VIRTUAL_STOCK_PLAN.equals(sqlId)) {
            sqlId = SqlId.SQL_CHECK_PLAN_NUM;
        }else {
            sqlId = SqlId.SQL_CHECK_ACTUAL_NUM;
        }
        int dbCheckNum = this.getCount(sqlId, sc181103Param);
        if (dbCheckNum == NumberConst.IntDef.INT_ZERO) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * 初始化DB数据
     *
     * @param sc181103Param
     * @param sql
     */
    @Transactional
    public void initData(SC181103Param sc181103Param, String sql) {
//        List<SC181103Param> initDataList = new ArrayList<SC181103Param>();

        for (int i = NumberConst.IntDef.INT_ONE; i < NumberConst.IntDef.INT_FIVE; i++) {
            for (int j = NumberConst.IntDef.INT_ONE; j < NumberConst.IntDef.INT_SEVEN; j++) {
                SC181103Param initParam = new SC181103Param();
                BeanUtils.copyProperties(sc181103Param, initParam);
                if (sql.equals(SqlId.SQL_SAVE_PD_VIRTUAL_STOCK_PLAN)) {
                    //设置虚拟库存计划流水Id
                    initParam.setStockPlanId(creatStockPlanId());

                    initParam.setOrigPlanNum(BigDecimal.ZERO);
                    initParam.setOldPlanNum(BigDecimal.ZERO);
                    initParam.setNewPlanNum(BigDecimal.ZERO);
                } else {
                    //设置虚拟库存实际流水Id
                    initParam.setStockActualId(creatStockActualId());

                    initParam.setOldActualNum(BigDecimal.ZERO);
                    initParam.setNewActualNum(BigDecimal.ZERO);
                }
                /**插入实际数据和初始化数据属于不同批的插入,adJustDate和InputDate应不同*/
                Date adJustDate = DateTimeUtil.add(sc181103Param.getAdJustDate(), NumberConst.IntDef.INT_ZERO,
                        NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_ZERO,
                        NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_ONE);
                initParam.setAdJustDate(adJustDate);
                initParam.setInputDate(adJustDate);
                initParam.setPdStockType(StringUtil.toString(i));
                initParam.setHalfCode(StringUtil.toString(j));
//                initDataList.add(initParam);
                if (!checkMonthData(initParam, sql)) {
                    int initDataResult = this.save(sql, initParam);
                    if (initDataResult <= NumberConst.IntDef.INT_ZERO) {
                        throw new BusinessException("初始化对应月份数据失败!");
                    } else {
                        logger.info("初始化数据成功!");
                    }
                }
            }
        }
    }


    /**
     * 保存数据到产品虚拟库存计划表和实际表
     * @param sc181103Param
     */
    /*public void savePlanAndActual(SC181103Param sc181103Param) {
        SC181103Param param = sc181103Param;
        *//**设置计划录入日期和计划数量*//*
        BigDecimal packNum = sc181103Param.getPackNum();
        param.setAdJustDate(sc181103Param.getCrtTime());
        param.setOrigPlanNum(packNum);
        param.setOldPlanNum(packNum);
        param.setNewPlanNum(packNum);

        *//**设置实际录入日期和数量数量*//*
        param.setInputDate(sc181103Param.getCrtTime());
        param.setOldActualNum(packNum);
        param.setNewActualNum(packNum);
        *//**计算半旬和分销月度，插入四条数据*//*
        String halfCode = sc181103Param.getHalfCode();
        String distMonth = sc181103Param.getDistMonth();
        for (int i = NumberConst.IntDef.INT_ONE; i < NumberConst.IntDef.INT_FIVE; i++){
            Integer distMonthNum = Integer.parseInt(distMonth);
            Integer halfCodeNum = Integer.parseInt(halfCode);
            switch (halfCodeNum) {
                case NumberConst.IntDef.INT_ONE :
                    if (i == NumberConst.IntDef.INT_FOUR){
                        distMonthNum = distMonthNum + NumberConst.IntDef.INT_ONE;
                    }
                    break;
                case NumberConst.IntDef.INT_TWO :
                    if (i == NumberConst.IntDef.INT_FOUR||i == NumberConst.IntDef.INT_THREE){
                        distMonthNum = distMonthNum + NumberConst.IntDef.INT_ONE;
                    }
                    break;
                case NumberConst.IntDef.INT_THREE :
                    if (i == NumberConst.IntDef.INT_ONE){
                        distMonthNum = distMonthNum - NumberConst.IntDef.INT_ONE;
                    }
                    break;
            }
            int tempHalfCode = (halfCodeNum + i - NumberConst.IntDef.INT_TWO) % NumberConst.IntDef.INT_SIX;
            if (tempHalfCode == NumberConst.IntDef.INT_ZERO) {
                halfCodeNum = NumberConst.IntDef.INT_SIX ;
            }else{
                halfCodeNum = tempHalfCode ;
            }

            //设置虚拟库存计划流水Id
            param.setStockPlanId(creatStockPlanId());
            //设置虚拟库存实际流水Id
            param.setStockActualId(creatStockActualId());
            //设置产品库存类型
            Integer stockTypeNum = (Integer)i;
            param.setPdStockType(stockTypeNum.toString());
            //设置分销月度
            param.setDistMonth(distMonthNum.toString());
            //设置半旬码
            param.setHalfCode(halfCodeNum.toString());

            *//**验证数据是否为空*//*
            if (StringUtil.isNullOrEmpty(sc181103Param.getPdStockType())||StringUtil.isNullOrEmpty(sc181103Param.getHalfCode())
                    ||StringUtil.isNullOrEmpty(sc181103Param.getClassesCode())||StringUtil.isNullOrEmpty(sc181103Param.getFeatureCode())
                    ||StringUtil.isNullOrEmpty(sc181103Param.getProductSpecifical())||StringUtil.isNullOrEmpty(sc181103Param.getBreedCode())
                    ||StringUtil.isNullOrEmpty(sc181103Param.getNormsCode())||StringUtil.isNullOrEmpty(sc181103Param.getNetWeight())
                    )  {
                throw new BusinessException("数据存在空值");
            } else {
                //插入数量计数器
                int resultNum1 = NumberConst.IntDef.INT_ZERO;
                resultNum1 = this.save(SqlId.SQL_SAVE_PD_VIRTUAL_STOCK_PLAN,param);
                if(resultNum1 > NumberConst.IntDef.INT_ZERO){
                    logger.info("产品虚拟库存计划表保存数据成功");
                }
                else{
                    logger.info("产品虚拟库存计划表保存数据失败");
                    throw new BusinessException("数据有误插入失败！请联系管理员");
                }

                int resultNum2 = NumberConst.IntDef.INT_ZERO;
                resultNum2 = this.save(SqlId.SQL_SAVE_PD_VIRTUAL_STOCK_ACTUAL,param);
                if(resultNum2 > NumberConst.IntDef.INT_ZERO){
                    logger.info("产品虚拟库存实际表保存数据成功");
                }
                else{
                    logger.info("产品虚拟库存实际表保存数据失败");
                    throw new BusinessException("数据有误插入失败！请联系管理员");
                }
            }
        }
    }*/


    /**
     * OEM申报情况一览
     *
     * @param pageParam
     * @return
     */
    public PageResult<SC181103Bean> findSC181103BeansList(SC181103Param pageParam) {
        logger.info("供应商申报情况一览");
        PageResult<SC181103Bean> result = super.findPage(pageParam, SC181103Bean.class);
        if (result.getData() != null) {
            for (SC181103Bean sc181103Bean : result.getData()) {
                BaseParam param = new BaseParam();
                //产品等级默认置为"A1"
                String pdCode = sc181103Bean.getPdCode() + StringUtil.toString(NumberConst.IntDef.INT_TWO);
                ProductBean productInfo = productLogic.getProductInfo(pdCode);
                if (productInfo != null) {
                    if (productInfo.getPdClasses() != null) {
                        param.setFilter("classesCode", productInfo.getPdClasses().getClassesCode());
                        sc181103Bean.setClassesCode(productInfo.getPdClasses().getClassesCode());
                        sc181103Bean.setClassesName(productInfo.getPdClasses().getClassesName());
                    } else {
                        sc181103Bean.setClassesCode(StringConst.EMPTY);
                        sc181103Bean.setClassesName(StringConst.EMPTY);
                    }
                    if (productInfo.getPdMachining() != null) {
                        param.setFilter("machiningCode", productInfo.getPdMachining().getMachiningCode());
                        sc181103Bean.setMachiningName(productInfo.getPdMachining().getMachiningName());
                        sc181103Bean.setMachiningName(productInfo.getPdMachining().getMachiningCode());
                    } else {
                        sc181103Bean.setMachiningCode(StringConst.EMPTY);
                        sc181103Bean.setMachiningName(StringConst.EMPTY);
                    }
                    if (productInfo.getPdBreed() != null) {
                        param.setFilter("breedCode", productInfo.getPdBreed().getBreedCode());
                        sc181103Bean.setBreedName(productInfo.getPdBreed().getBreedName());
                        sc181103Bean.setBreedCode(productInfo.getPdBreed().getBreedCode());
                    } else {
                        sc181103Bean.setBreedCode(StringConst.EMPTY);
                        sc181103Bean.setBreedName(StringConst.EMPTY);
                    }
                    if (productInfo.getPdFeature() != null) {
                        param.setFilter("featureCode", productInfo.getPdFeature().getFeatureCode());
                        sc181103Bean.setFeatureCode(productInfo.getPdFeature().getFeatureCode());
                        sc181103Bean.setFeatureName(productInfo.getPdFeature().getFeatureName());
                    } else {
                        sc181103Bean.setFeatureCode(StringConst.EMPTY);
                        sc181103Bean.setFeatureName(StringConst.EMPTY);
                    }
                    if (productInfo.getPdWeight() != null) {
                        param.setFilter("weightCode", productInfo.getPdWeight().getWeightCode());
                        sc181103Bean.setWeightCode(productInfo.getPdWeight().getWeightCode());
                        sc181103Bean.setWeightName(productInfo.getPdWeight().getWeightName());
                        sc181103Bean.setNetWeight(productInfo.getPdWeight().getWeightVal().toString());
                    } else {
                        sc181103Bean.setWeightCode(StringConst.EMPTY);
                        sc181103Bean.setWeightName(StringConst.EMPTY);
                        sc181103Bean.setNetWeight(StringConst.EMPTY);
                    }
                    if (productInfo.getPdGrade() != null) {
                        param.setFilter("gradeCode", productInfo.getPdGrade().getGradeCode());
                        sc181103Bean.setGradeCode(productInfo.getPdGrade().getGradeCode());
                        sc181103Bean.setGradeName(productInfo.getPdGrade().getGradeName());
                    } else {
                        sc181103Bean.setGradeCode(StringConst.EMPTY);
                        sc181103Bean.setGradeName(StringConst.EMPTY);
                    }
                    /**设置产品品牌类型*/
                    Integer brandType = sc181103Bean.getSlQltGradeCode();
                    sc181103Bean.setBrandType(brandType);
                    switch (brandType) {
                        case NumberConst.IntDef.INT_ONE:
                            sc181103Bean.setBrandTypeName("神农先生");
                            break;
                        case NumberConst.IntDef.INT_TWO:
                            sc181103Bean.setBrandTypeName("神农客");
                            break;
                        case NumberConst.IntDef.INT_THREE:
                            sc181103Bean.setBrandTypeName("神农人家");
                            break;
                        default:
                            sc181103Bean.setBrandTypeName("");
                            break;
                    }
                    /**设置产品分销月度*/
                    sc181103Bean.setDistMonth(pageParam.getDistMonth());
                    //发货数量默认置为0
                    sc181103Bean.setPackNum(BigDecimal.valueOf(NumberConst.IntDef.INT_ZERO));
                    //半旬码
                    sc181103Bean.setHalfCode(StringUtil.toString(getHalfCode(
                            DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DD, new Date()))));
                    sc181103Bean.setHalfName(getHalfName(Integer.parseInt(sc181103Bean.getHalfCode())));

                    /**设置产品外包装规格和产品包装编码*/
                    List<PdNormsStd> pdNormsStds = productLogic.findPdNormsStd(param);
                    if (CollectionUtils.isNotEmpty(pdNormsStds)) {
                        sc181103Bean.setProductSpecifical(pdNormsStds.get(NumberConst.IntDef.INT_ZERO).getNormsOut());
                        sc181103Bean.setNormsCode(pdNormsStds.get(NumberConst.IntDef.INT_ZERO).getNormsCode());
//                        sc181103Bean.setNetWeight(pdNormsStds.get(NumberConst.IntDef.INT_ZERO).getNormsKg());
                    } else {
                        sc181103Bean.setProductSpecifical(StringConst.EMPTY);
                        sc181103Bean.setNormsCode(StringConst.EMPTY);
                    }
                }
            }
        }
        //TODO
        /**
         *
         *
         * 返回nulljsp显示对不起没有查到数据
         *
         *
         *
         */
        return result;
    }

    /**
     * 获取产品等级List
     *
     * @return List
     */
    public List<PdGrade> findProductGrade() {
        logger.info("获取产品等级List");
        BaseParam param = new BaseParam();
        return this.findList(SqlId.SQL_ID_FIND_PRODUCT_GRADE, param);
    }

    /**
     * 获取品牌List
     *
     * @return List
     */
    public List<CommConstant> findBrandType() {
        logger.info("获取品牌List");
        return commonLogic.findConstantList("BrandType");
    }

    /**
     * 获取半旬List
     *
     * @return
     */
    public List<CommConstant> findHalfNameList() {
        logger.info("获取半旬List");
        return commonLogic.findConstantList("HalfCodeType");
    }

    /**
     * 获取区域List
     *
     * @return
     */
    public List<SC181103Bean> findAreaList() {
        logger.info("获取区域List");
        BaseParam param = new BaseParam();
        List<SC181103Bean> result = super.findList(SqlId.SQL_ID_FIND_AREA_LIST, param);
        return result;
    }

    /**
     * 获取供应商List
     *
     * @return
     */
    public List<SC181103Bean> findSuppList(SC181103Param param) {
        logger.info("获取供应商List");
        List<SC181103Bean> result = super.findList(SqlId.SQL_ID_FIND_SUPP_LIST, param);
        return result;
    }

    /**
     * 获取半旬
     *
     * @param currentDay 传入对象
     * @return 半旬
     */
    public int getHalfCode(String currentDay) {
        int halfCode = 0;
        if (Integer.parseInt(currentDay) < halfDeparture.DEPARTURE_1) {
            if (Integer.parseInt(currentDay) >= halfDeparture.DEPARTURE_6) {
                halfCode = NumberConst.IntDef.INT_SIX;
            } else {
                if (Integer.parseInt(currentDay) >= halfDeparture.DEPARTURE_5) {
                    halfCode = NumberConst.IntDef.INT_FIVE;
                } else {
                    if (Integer.parseInt(currentDay) >= halfDeparture.DEPARTURE_4) {
                        halfCode = NumberConst.IntDef.INT_FOUR;
                    } else {
                        halfCode = NumberConst.IntDef.INT_THREE;
                    }
                }
            }
        } else {
            if (Integer.parseInt(currentDay) < halfDeparture.DEPARTURE_2) {
                halfCode = NumberConst.IntDef.INT_ONE;
            } else {
                halfCode = NumberConst.IntDef.INT_TWO;
            }
        }
        return halfCode;
    }

    /**
     * 获取半旬名称
     *
     * @param halfCode 传入对象
     * @return 半旬名称
     */
    public String getHalfName(int halfCode) {
        String halfName = null;
        /*半旬名称List*/
        List<CommConstant> halfNameList = findHalfNameList();
        //当前半旬Name
        for (CommConstant halfCodeType : halfNameList) {
            if (halfCodeType.getConstantValue().equals(String.valueOf(halfCode))) {
                halfName = halfCodeType.getConstantName();
                break;
            }
        }
        return halfName;
    }

    /**
     * 保存所有数据到DB
     *
     * @param sc181103Param
     */
    @Transactional
    public void saveParam(SC181103Param sc181103Param) {
        saveDistNum(sc181103Param);
        List<SC181103Param> dataList = setStockPlanAndActual(sc181103Param);
//        saveStockPlanAndActual(sc181103Param);
        saveStockPlanAndActual(dataList);
    }
};

