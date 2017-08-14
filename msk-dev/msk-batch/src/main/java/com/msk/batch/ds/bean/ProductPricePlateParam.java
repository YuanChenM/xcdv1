package com.msk.batch.ds.bean;

import com.msk.core.bean.BaseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


public class ProductPricePlateParam extends BaseParam {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ProductPricePlateParam.class);

    public static final long serialVersionUID = 1L;

    /**接收的价盘json字符串 */
    public String jsonPlateData;
    /**接收的产品通道json字符串 */
    public String jsonWayData;
    /**物流区编码 */
    public String logiareaCode;
    /**产品编码 */
    public String productCode;
    /**产品类别编码 */
    public String classesCode;
    /**产品二级分类编码 */
    public String machiningCode;
    /**产品种类编码 */
    public String breedCode;
    /**产品特征编码 */
    public String featureCode;
    /**产品净重编码 */
    public String weightCode;
    /**产品包装编码 */
    public String pkgCode;
    /**产品等级编码 */
    public String gradeCode;
    /**订单等级编码(通道等级) */
    public Integer orderLevelCode;
    /**公斤价(价盘定价) */
    public BigDecimal priceOfKg;
    /**箱数范围下限 */
    public Integer boxCntMin;
    /**箱数范围上限 */
    public Integer boxCntMax;

    public String getLogiareaCode() {
        return logiareaCode;
    }

    public void setLogiareaCode(String logiareaCode) {
        this.logiareaCode = logiareaCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCodeCode) {
        this.machiningCode = machiningCodeCode;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getWeightCode() {
        return weightCode;
    }
    public void setWeightCode(String weightCode) {
        this.weightCode = weightCode;
    }

    public String getPkgCode() {
        return pkgCode;
    }
    public void setPkgCode(String pkgCode) {
        this.pkgCode = pkgCode;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public Integer getOrderLevelCode() {
        return orderLevelCode;
    }

    public void setOrderLevelCode(Integer orderLevelCode) {
        this.orderLevelCode = orderLevelCode;
    }

    public BigDecimal getPriceOfKg() {
        return priceOfKg;
    }

    public void setPriceOfKg(BigDecimal priceOfKg) {
        this.priceOfKg = priceOfKg;
    }

    public Integer getBoxCntMin() {
        return boxCntMin;
    }

    public void setBoxCntMin(Integer boxCntMin) {
        this.boxCntMin = boxCntMin;
    }

    public Integer getBoxCntMax() {
        return boxCntMax;
    }

    public void setBoxCntMax(Integer boxCntMax) {
        this.boxCntMax = boxCntMax;
    }

    public String getJsonPlateData() {
        return jsonPlateData;
    }

    public void setJsonPlateData(String jsonPlateData) {
        this.jsonPlateData = jsonPlateData;
    }

    public String getJsonWayData() {
        return jsonWayData;
    }

    public void setJsonWayData(String jsonWayData) {
        this.jsonWayData = jsonWayData;
    }
}
