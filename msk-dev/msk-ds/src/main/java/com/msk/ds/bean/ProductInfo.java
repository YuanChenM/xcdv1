package com.msk.ds.bean;

import com.msk.core.bean.BaseBean;

import java.util.List;

/**
 * ProductInfo.
 *
 * @author yuan_chen
 */
public class ProductInfo extends BaseBean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 产品编码 */
    private String pdtCode;
    /** 产品名称 */
    private String pdtName;
    /** 产品库存 */
    private String stockCnt;
    /** 产品状态 */
    private String pdtStatus;
    /** 产品等级 */
    private String gradeLevel;
    /** 产品规格属性（对于神农客，返回一条数据，对于美侍客，会返回多条数据） */
    private List<ProductAttribute> productAttributes;

    /**
     * Getter method for property <tt>pdtCode</tt>.
     *
     * @return property value of pdtCode
     */
    public String getPdtCode() {
        return pdtCode;
    }

    /**
     * Setter method for property <tt>pdtCode</tt>.
     *
     * @param pdtCode value to be assigned to property pdtCode
     */
    public void setPdtCode(String pdtCode) {
        this.pdtCode = pdtCode;
    }

    /**
     * Getter method for property <tt>pdtName</tt>.
     *
     * @return property value of pdtName
     */
    public String getPdtName() {
        return pdtName;
    }

    /**
     * Setter method for property <tt>pdtName</tt>.
     *
     * @param pdtName value to be assigned to property pdtName
     */
    public void setPdtName(String pdtName) {
        this.pdtName = pdtName;
    }

    /**
     * Getter method for property <tt>stockCnt</tt>.
     *
     * @return property value of stockCnt
     */
    public String getStockCnt() {
        return stockCnt;
    }

    /**
     * Setter method for property <tt>stockCnt</tt>.
     *
     * @param stockCnt value to be assigned to property stockCnt
     */
    public void setStockCnt(String stockCnt) {
        this.stockCnt = stockCnt;
    }

    /**
     * Getter method for property <tt>pdtStatus</tt>.
     *
     * @return property value of pdtStatus
     */
    public String getPdtStatus() {
        return pdtStatus;
    }

    /**
     * Setter method for property <tt>pdtStatus</tt>.
     *
     * @param pdtStatus value to be assigned to property pdtStatus
     */
    public void setPdtStatus(String pdtStatus) {
        this.pdtStatus = pdtStatus;
    }

    /**
     * Getter method for property <tt>gradeLevel</tt>.
     *
     * @return property value of gradeLevel
     */
    public String getGradeLevel() {
        return gradeLevel;
    }

    /**
     * Setter method for property <tt>gradeLevel</tt>.
     *
     * @param gradeLevel value to be assigned to property gradeLevel
     */
    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    /**
     * Getter method for property <tt>productAttributes</tt>.
     *
     * @return property value of productAttributes
     */
    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    /**
     * Setter method for property <tt>productAttributes</tt>.
     *
     * @param productAttributes value to be assigned to property productAttributes
     */
    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }
}
