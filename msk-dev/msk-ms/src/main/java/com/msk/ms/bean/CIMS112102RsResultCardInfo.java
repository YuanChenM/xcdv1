/**
 * CardInfo.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;

/**
 * CardInfo.
 * 通联返回json中卡信息接收 卡信息查询接口
 * 
 * @author rwf
 */
public class CIMS112102RsResultCardInfo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 卡信息 */
    private String card_stat;
    /** 机构号 */
    private String brh_id;
    /** 卡品牌编号 */
    private String brand_id;
    /** 截止有效期 */
    private String validity_date;
    /** 卡号 */
    private String card_id;
    /** 卡产品列表 */
    private CIMS112102RsResultCardProductInfo card_product_info_arrays;

    /**
     * Get the card_stat.
     *
     * @return card_stat
     *
     * @author rwf
     */
    public String getCard_stat() {
        return this.card_stat;
    }

    /**
     * Set the card_stat.
     *
     * @param card_stat card_stat
     *
     * @author rwf
     */
    public void setCard_stat(String card_stat) {
        this.card_stat = card_stat;
    }

    /**
     * Get the brh_id.
     *
     * @return brh_id
     *
     * @author rwf
     */
    public String getBrh_id() {
        return this.brh_id;
    }

    /**
     * Set the brh_id.
     *
     * @param brh_id brh_id
     *
     * @author rwf
     */
    public void setBrh_id(String brh_id) {
        this.brh_id = brh_id;
    }

    /**
     * Get the brand_id.
     *
     * @return brand_id
     *
     * @author rwf
     */
    public String getBrand_id() {
        return this.brand_id;
    }

    /**
     * Set the brand_id.
     *
     * @param brand_id brand_id
     *
     * @author rwf
     */
    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    /**
     * Get the validity_date.
     *
     * @return validity_date
     *
     * @author rwf
     */
    public String getValidity_date() {
        return this.validity_date;
    }

    /**
     * Set the validity_date.
     *
     * @param validity_date validity_date
     *
     * @author rwf
     */
    public void setValidity_date(String validity_date) {
        this.validity_date = validity_date;
    }

    /**
     * Get the card_id.
     *
     * @return card_id
     *
     * @author rwf
     */
    public String getCard_id() {
        return this.card_id;
    }

    /**
     * Set the card_id.
     *
     * @param card_id card_id
     *
     * @author rwf
     */
    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    /**
     * Get the card_product_info_arrays.
     *
     * @return card_product_info_arrays
     *
     * @author rwf
     */
    public CIMS112102RsResultCardProductInfo getCard_product_info_arrays() {
        return this.card_product_info_arrays;
    }

    /**
     * Set the card_product_info_arrays.
     *
     * @param card_product_info_arrays card_product_info_arrays
     *
     * @author rwf
     */
    public void setCard_product_info_arrays(CIMS112102RsResultCardProductInfo card_product_info_arrays) {
        this.card_product_info_arrays = card_product_info_arrays;
    }

}
