package com.msk.ds.bean;

import com.msk.core.entity.BaseEntity;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * 收货入库通知单bean
 */
public class SC181103Bean extends BaseEntity {

    /**地区编码 */
    private String lgcsCode;
    /**地区名称 */
    private String lgcsName;
    /**供应商编码 */
    private String suppCode;
    /**供应商名称 */
    private String suppName;
    /**期*/
    private String distMonth;
    /**当前日期的半旬编码*/
    private String halfCode;
    /**半旬名称*/
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
    /**品牌类型 */
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
    /**产品标准质量定级*/
    private Integer slQltGradeCode;

    /**产品类别名称*/
    private String machiningCode;
    /**产品类别编码*/
    private String machiningName;
    private String weightCode;
    private String weightName;
    /** 应上海需求,添加生产商属性 create by likai1 on 2016/8/8 start */
    private String manuName;
    private String manuCode;
    /** 应上海需求,添加生产商属性 create by likai1 on 2016/8/8 end */

    /**
     * <p>默认构造函数。</p>
     */
    public SC181103Bean() {

    }

    /**
     * <p>半旬码。</p>
     *
     * @return the 半旬码
     */
    public String getHalfCode() {
        return halfCode;
    }
    public boolean isLeapYear(int year){
        if(year % 100 == 0){
            if(year % 400 == 0){
                return true;
            }
        }else {
            if(year % 4 == 0){
                return true;
            }
        }
        return false;
    }

    /**
     * <p>半旬码。</p>
     *
     * @param halfCode 半旬码。
     */
    public void setHalfCode(String halfCode) {
        this.halfCode = halfCode;
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


    public String getHalfName() {




        return halfName;
    }

    public void setHalfName(String halfName) {
        this.halfName = halfName;
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

    public String getPdName() {
        String name = this.classesName + "/" + this.machiningName + "/" + this.breedName + "/" + this.featureName + "/" + this.weightName;
        if(StringUtils.hasLength(this.gradeCode))
        {
            name += "/" + this.gradeName;
        }
        if(name.contains("null"))
            return null;
        return name;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
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

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
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

    public Integer getBrandType() {
        return brandType;
    }

    public void setBrandType(Integer brandType) {
        this.brandType = brandType;
    }

    public String getBrandTypeName() {
        return brandTypeName;
    }

    public void setBrandTypeName(String brandTypeName) {
        this.brandTypeName = brandTypeName;
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

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getNormsCode() {
        return normsCode;
    }

    public void setNormsCode(String normsCode) {
        this.normsCode = normsCode;
    }

    public BigDecimal getPackNum() {
        return packNum;
    }

    public void setPackNum(BigDecimal packNum) {
        this.packNum = packNum;
    }

    public BigDecimal getDistNum() {
        return distNum;
    }

    public void setDistNum(BigDecimal distNum) {
        this.distNum = distNum;
    }

    public Integer getSlQltGradeCode() {
        return slQltGradeCode;
    }

    public void setSlQltGradeCode(Integer slQltGradeCode) {
        this.slQltGradeCode = slQltGradeCode;
    }
	    public String getLgcsName() {
        return lgcsName;
    }

    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getWeightName() {
        return weightName;
    }

    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    public String getMachiningName() {
        return machiningName;
    }

    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    public String getWeightCode() {
        return weightCode;
    }

    public void setWeightCode(String weightCode) {
        this.weightCode = weightCode;
    }

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName;
    }

    public String getManuCode() {
        return manuCode;
    }

    public void setManuCode(String manuCode) {
        this.manuCode = manuCode;
    }
}
