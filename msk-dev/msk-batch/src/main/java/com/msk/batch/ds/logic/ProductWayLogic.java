package com.msk.batch.ds.logic;

import com.msk.batch.ds.bean.ProductWayParam;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.PdLogiareaOrderlevel;
import com.msk.core.entity.PdPriceprdLogiarea;
import com.msk.core.utils.DateTimeUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * ProductPricePlateLogic 业务处理类
 *
 * @author zhou_yajun 2016.01.28
 */
public class ProductWayLogic extends BaseLogic {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ProductWayLogic.class);

    @Autowired
    private CommonLogic commonLogic;
    /**
     * SQL Map 中SQL ID定义
     *
     */
    public interface SqlId {
        static final String SQLID_INSERT_ORDER_LEVEL = "insertOrderLevel";
        static final String SQLID_UPDATE_ORDER_LEVEL = "updateOrderLevel";
        static final String SQLID_SELECT_ORDER_LEVEL = "selectOrderLevel";
        static final String SQLID_DELETE_ORDER_LEVEL = "deleteOrderLevel";
    }
    /**
     * 数据处理插入DB
     *
     * @param param param
     *
     */
    @Transactional
    public void JsonDataResolve(BaseParam param){
        logger.info("数据处理开始");
        ProductWayParam dataParam = (ProductWayParam)param;
        dataParam.setActId("Batch");
        dataParam.setActTime(DateTimeUtil.getCustomerDate());
        dataParam.setCrtId("Batch");
        dataParam.setCrtTime(DateTimeUtil.getCustomerDate());


        JSONObject jsonWay = new JSONObject(dataParam.getJsonWayData());
        //产品价盘数据整理

        //产品通道配置数据整理

        if("S".equals(jsonWay.getString("status"))){
            JSONArray resultArray = jsonWay.getJSONArray("result");
            //清空物流区产品价盘表
            super.remove(SqlId.SQLID_DELETE_ORDER_LEVEL, dataParam);

            if(resultArray.length() > 0){
                for (int i = 0; i < resultArray.length(); i++) {
                    JSONObject resultObject = resultArray.getJSONObject(i);
                    String areaCode = resultObject.getString("areaCode");
                    dataParam.setLogiareaCode(areaCode);
                    JSONArray productArray = resultObject.getJSONArray("productList");
                    if(productArray.length() > 0){
                        for (int j = 0; j < productArray.length(); j++) {
                            JSONObject productObject = productArray.getJSONObject(j);
                            String productCode = productObject.getString("productCode");
                            //产品编码
                            dataParam.setProductCode(productCode);
                            //拆分产品编码
                            splitProductCode(dataParam);
                            JSONArray gradeArray = productObject.getJSONArray("gradeList");
                            if(gradeArray.length() > 0){
                                for (int k = 0; k < gradeArray.length(); k++) {
                                    JSONObject gradeObject = gradeArray.getJSONObject(k);
                                    //产品等级
                                    String gradeCode = gradeObject.getString("grade");
                                    dataParam.setGradeCode(gradeCode);
                                    JSONArray wayArray = gradeObject.getJSONArray("wayList");
                                    if(wayArray.length() > 0){
                                        for (int l = 0; l < wayArray.length(); l++) {
                                            JSONObject wayObject = wayArray.getJSONObject(l);
                                            Integer wayCode = wayObject.getInt("wayCode");
                                            Integer wayStartNum = wayObject.getInt("wayStartNum");
                                            Integer wayEndNum = wayObject.getInt("wayEndNum");
                                            dataParam.setOrderLevelCode(wayCode);
                                            dataParam.setBoxCntMin(wayStartNum);
                                            dataParam.setBoxCntMax(wayEndNum);

                                            //判断DB中是否存在这条记录，存在则更新，不存在则插入
                                            List<PdLogiareaOrderlevel> result = super.findList(SqlId.SQLID_SELECT_ORDER_LEVEL,dataParam);
                                            if(result.size() > 0 && null != result){
                                                //super.modify(SqlId.SQLID_UPDATE_ORDER_LEVEL,setOrderLevel(dataParam));
                                            }else{
                                                super.save(SqlId.SQLID_INSERT_ORDER_LEVEL,setOrderLevel(dataParam));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * 拆分产品编码
     * @param param param
     */
    public void splitProductCode(ProductWayParam param){
        /**产品编码 */
        String productCode = param.getProductCode();
        /**产品类别编码 */
        String classesCode = productCode.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_TWO);
        /**产品二级分类编码 */
        String machiningCode = productCode.substring(NumberConst.IntDef.INT_TWO, NumberConst.IntDef.INT_THREE);
        /**产品种类编码 */
        String breedCode = productCode.substring(NumberConst.IntDef.INT_THREE, NumberConst.IntDef.INT_FIVE);
        /**产品特征编码 */
        String featureCode = productCode.substring(NumberConst.IntDef.INT_FIVE, NumberConst.IntDef.INT_SEVEN);
        /**产品净重编码 */
        String weightCode = productCode.substring(NumberConst.IntDef.INT_SEVEN, NumberConst.IntDef.INT_NINE);
        /**产品等级编码 */
       // String gradeCode = productCode.substring(NumberConst.IntDef.INT_NINE, NumberConst.IntDef.INT_TEN);
        param.setClassesCode(classesCode);
        param.setMachiningCode(machiningCode);
        param.setBreedCode(breedCode);
        param.setFeatureCode(featureCode);
        param.setWeightCode(weightCode);
      //  param.setGradeCode(gradeCode);
    }


    /**
     * 获取产品物流区订单等级表Entity
     * @param param param
     * @return orderLevel
     */
    public PdLogiareaOrderlevel setOrderLevel(ProductWayParam param){
        PdLogiareaOrderlevel orderLevel = new PdLogiareaOrderlevel();
        orderLevel.setLogiareaCode(param.getLogiareaCode());
        orderLevel.setClassesCode(param.getClassesCode());
        orderLevel.setMachiningCode(param.getMachiningCode());
        orderLevel.setBreedCode(param.getBreedCode());
        orderLevel.setGradeCode(param.getGradeCode());
        orderLevel.setFeatureCode(param.getFeatureCode());
        orderLevel.setWeightCode(param.getWeightCode());
        orderLevel.setPkgCode(param.getPkgCode());
        orderLevel.setOrderlevelCode(String.valueOf(param.getOrderLevelCode()));
        orderLevel.setBoxCntmin(param.getBoxCntMin());
        orderLevel.setBoxCntmax(param.getBoxCntMax());
        orderLevel.setActId(param.getActId());
        orderLevel.setActTime(param.getActTime());
        orderLevel.setCrtId(param.getCrtId());
        orderLevel.setCrtTime(param.getCrtTime());
        orderLevel.setUpdId(param.getCrtId());
        orderLevel.setUpdTime(DateTimeUtil.getCustomerDate());
        return orderLevel;
    }
    /**
     * 根据当前日期获得价盘周期
     * @return 价盘周期
     */
    public String getPriceCyclePeriod(){
        String yyyyMM = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_YYYYMMDD,DateTimeUtil.getCustomerDate());
        int Day = DateTimeUtil.getDayOfMonth(DateTimeUtil.getCustomerDate());
        String yyMM = yyyyMM.substring(NumberConst.IntDef.INT_TWO, NumberConst.IntDef.INT_SIX);
        if(Day >= NumberConst.IntDef.INT_ONE && Day <= NumberConst.IntDef.INT_FIVE){
            return yyMM + "1";
        }else if(Day >= NumberConst.IntDef.INT_SIX && Day <= NumberConst.IntDef.INT_TEN){
            return yyMM + "2";
        }else if(Day >= NumberConst.IntDef.INT_ELEVEN && Day <= NumberConst.IntDef.INT_FIFTEEN){
            return yyMM + "3";
        }else if(Day >= NumberConst.IntDef.INT_SIXTEEN && Day <= NumberConst.IntDef.INT_TWENTY){
            return yyMM + "4";
        }else if(Day >= NumberConst.IntDef.INT_TWENTY_ONE && Day <= NumberConst.IntDef.INT_TWENTY_FIVE){
            return yyMM + "5";
        }else {
            return yyMM + "6";
        }
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
