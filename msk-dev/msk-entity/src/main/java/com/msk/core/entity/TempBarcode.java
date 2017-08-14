/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表temp_barcode对应的TempBarcode。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class TempBarcode extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** ID */
    private java.lang.Long id;
    /** 条码ID */
    private java.lang.String barcodeId;
    /** 品牌 */
    private java.lang.String brand;
    /** 产品等级 */
    private java.lang.String grade;
    /** 条形码 */
    private java.lang.String barcode;
    /** 阅读码 */
    private java.lang.String readcode;
    /**
     * <p>默认构造函数。</p>
     */
    public TempBarcode() {

    }

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>barcodeId</tt>.
     *
     * @return property value of barcodeId
     */
    public String getBarcodeId() {
        return barcodeId;
    }

    /**
     * Setter method for property <tt>barcodeId</tt>.
     *
     * @param barcodeId value to be assigned to property barcodeId
     */
    public void setBarcodeId(String barcodeId) {
        this.barcodeId = barcodeId;
    }

    /**
     * <p>品牌。</p>
     *
     * @return the 品牌
     */
    public java.lang.String getBrand() {
        return brand;
    }

    /**
     * <p>品牌。</p>
     *
     * @param brand 品牌。
     */
    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    /**
     * <p>产品等级。</p>
     *
     * @return the 产品等级
     */
    public java.lang.String getGrade() {
        return grade;
    }

    /**
     * <p>产品等级。</p>
     *
     * @param grade 产品等级。
     */
    public void setGrade(java.lang.String grade) {
        this.grade = grade;
    }

    /**
     * <p>条形码。</p>
     *
     * @return the 条形码
     */
    public java.lang.String getBarcode() {
        return barcode;
    }

    /**
     * <p>条形码。</p>
     *
     * @param barcode 条形码。
     */
    public void setBarcode(java.lang.String barcode) {
        this.barcode = barcode;
    }

    /**
     * <p>阅读码。</p>
     *
     * @return the 阅读码
     */
    public java.lang.String getReadcode() {
        return readcode;
    }

    /**
     * <p>阅读码。</p>
     *
     * @param readcode 阅读码。
     */
    public void setReadcode(java.lang.String readcode) {
        this.readcode = readcode;
    }

}
