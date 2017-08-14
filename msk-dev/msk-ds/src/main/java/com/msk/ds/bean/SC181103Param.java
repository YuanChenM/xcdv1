package com.msk.ds.bean;

import com.msk.core.bean.BasePageParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * zhou_yajun on 2016/1/28.
 */
public class SC181103Param extends BasePageParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**供应分销流水id*/
    private Long suppDsId;
    /**虚拟库存实际流水Id*/
    private Long stockActualId;
    /**虚拟库存计划流水Id*/
    private Long stockPlanId;
    /**地区名称 */
    private String lgcsName;
    /**地区编码 */
    private String lgcsCode;
    /**供应商编码 */
    private String suppCode;
    /**期*/
    private String distMonth;
    /**当前日期的半旬编码*/
    private String halfCode;
    /**当前日期的半旬名称*/
    private String halfName;
    /**产品库存类型*/
    private String pdStockType;
    /**分销通道*/
    private Integer distType;
    /**产品名称 */
    private String pdName;
    /**产品编码 */
    private String pdCode;
    /**产品类别名称*/
    private String classesName;
    /**产品类别编码*/
    private String classesCode;
    /**产品品种名称 */
    private String breedName;
    /**产品品种编码 */
    private String breedCode;
    /**产品特征名称 */
    private String featureName;
    /**产品特征编码*/
    private String featureCode;
    /**产品等级名称 */
    private String gradeName;
    /**产品等级编码 */
    private String gradeCode;
    /**品牌类型 */
    private Integer brandType;
    /**品牌类型名称 */
    private String brandTypeName;
    /**产品规格名称 */
    private String productSpecifical;
    /**净重 */
    private String netWeight;
    /**包装编码 */
    private String packageCode;
    /**包装编码 */
    private String normsCode;
    /**箱数 */
    private BigDecimal packNum;
    /**分销数量*/
    private BigDecimal distNum;
    /**原实际数量*/
    private BigDecimal oldActualNum;
    /**新实际数量*/
    private BigDecimal newActualNum;
    /**原始计划数量*/
    private BigDecimal origPlanNum;
    /**原计划数量*/
    private BigDecimal oldPlanNum;
    /**新计划数量*/
    private BigDecimal newPlanNum;
    /**计划调整日期*/
    private Date adJustDate;
    /**实际录入日期*/
    private Date inputDate;
    private List<SC181103Param> sc181103List;

    public String getProductCode() {
        return pdCode;
    }

    public void setProductCode(String productCode) {
        this.pdCode = productCode;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }


    public String getProductSpecifical() {
        return productSpecifical;
    }

    public void setProductSpecifical(String productSpecifical) {
        this.productSpecifical = productSpecifical;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getPdStockType() {
        return pdStockType;
    }

    public void setPdStockType(String pdStockType) {
        this.pdStockType = pdStockType;
    }

    public Integer getDistType() {
        return distType;
    }

    public void setDistType(Integer distType) {
        this.distType = distType;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getNormsCode() {
        return normsCode;
    }

    public void setNormsCode(String normsCode) {
        this.normsCode = normsCode;
    }

    public BigDecimal getDistNum() {
        return distNum;
    }

    public void setDistNum(BigDecimal distNum) {
        this.distNum = distNum;
    }

    public BigDecimal getOldActualNum() {
        return oldActualNum;
    }

    public void setOldActualNum(BigDecimal oldActualNum) {
        this.oldActualNum = oldActualNum;
    }

    public BigDecimal getNewActualNum() {
        return newActualNum;
    }

    public void setNewActualNum(BigDecimal newActualNum) {
        this.newActualNum = newActualNum;
    }

    public BigDecimal getOrigPlanNum() {
        return origPlanNum;
    }

    public void setOrigPlanNum(BigDecimal origPlanNum) {
        this.origPlanNum = origPlanNum;
    }

    public BigDecimal getOldPlanNum() {
        return oldPlanNum;
    }

    public void setOldPlanNum(BigDecimal oldPlanNum) {
        this.oldPlanNum = oldPlanNum;
    }

    public BigDecimal getNewPlanNum() {
        return newPlanNum;
    }

    public void setNewPlanNum(BigDecimal newPlanNum) {
        this.newPlanNum = newPlanNum;
    }

    public Date getAdJustDate() {
        return adJustDate;
    }

    public void setAdJustDate(Date adJustDate) {
        this.adJustDate = adJustDate;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public void setBrandType(Integer brandType) {
        this.brandType = brandType;
    }

    public BigDecimal getPackNum() {
        return packNum;
    }

    public void setPackNum(BigDecimal packNum) {
        this.packNum = packNum;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String productName) {
        this.pdName = productName;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getDistMonth() {
        return distMonth;
    }

    public void setDistMonth(String distMonth) {
        this.distMonth = distMonth;
    }

    public String getHalfCode() {
        return halfCode;
    }

    public void setHalfCode(String halfCode) {
        this.halfCode = halfCode;
    }

    public Long getSuppDsId() {
        return suppDsId;
    }

    public void setSuppDsId(Long suppDsId) {
        this.suppDsId = suppDsId;
    }

    public Long getStockActualId() {
        return stockActualId;
    }

    public void setStockActualId(Long stockActualId) {
        this.stockActualId = stockActualId;
    }

    public Long getStockPlanId() {
        return stockPlanId;
    }

    public void setStockPlanId(Long stockPlanId) {
        this.stockPlanId = stockPlanId;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getHalfName() {
        return halfName;
    }

    public void setHalfName(String halfName) {
        this.halfName = halfName;
    }

    public String getBrandTypeName() {
        return brandTypeName;
    }

    public void setBrandTypeName(String brandTypeName) {
        this.brandTypeName = brandTypeName;
    }

    public List<SC181103Param> getSc181103List() {
        return sc181103List;
    }

    public void setSc181103List(List<SC181103Param> sc181103List) {
        this.sc181103List = sc181103List;
    }

    public String getLgcsName() {
        return lgcsName;
    }

    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }
}
