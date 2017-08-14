package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.List;

/**
 * 
 * ISO251401Rs接口接收参数Param.
 *
 * @author gyh
 */
public class ISO251401RsParam extends BaseParam{
    /** 订单区域编码 */
    private String districtCode;
    /** 买家ID */
    private String buyersId;
    /** 买家编码 */
    private String buyersCode;
    /** 买家类别 */
    private String buyersType;
    /** 买家名称 */
    private String buyersName;
    /** 卖家编码 */
    private String sellerCode;
    /** 卖家名称 */
    private String sellerName;
    /** 产品列表 */
    private List<ISO251401RsProduct> products;
    /** 订单来源*/
    private Integer orderSource;

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    /**
     * Get the districtCode.
     *
     * @return districtCode
     *
     * @author gyh
     */
    public String getDistrictCode() {
        return this.districtCode;
    }

    /**
     * Set the districtCode.
     *
     * @param districtCode districtCode
     *
     * @author gyh
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * 获得buyersId
     */
    public String getBuyersId() {
        return buyersId;
    }

    /**
     * 设置buyersId
     */
    public void setBuyersId(String buyersId) {
        this.buyersId = buyersId;
    }

    /**
     * Get the buyersCode.
     *
     * @return buyersCode
     *
     * @author gyh

     */
    public String getBuyersCode() {
        return this.buyersCode;
    }

    /**
     * Set the buyersCode.
     *
     * @param buyersCode buyersCode
     *
     * @author gyh
     */
    public void setBuyersCode(String buyersCode) {
        this.buyersCode = buyersCode;
    }

    /**
     * Get the buyersName.
     *
     * @return buyersName
     *
     * @author gyh
     */
    public String getBuyersName() {
        return this.buyersName;
    }

    /**
     * Set the buyersName.
     *
     * @param buyersName buyersName
     *
     * @author gyh
     */
    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }

    /**
     * Get the sellerCode.
     *
     * @return sellerCode
     *
     * @author gyh
     */
    public String getSellerCode() {
        return this.sellerCode;
    }

    /**
     * Set the sellerCode.
     *
     * @param sellerCode sellerCode
     *
     * @author gyh
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * Get the sellerName.
     *
     * @return sellerName
     *
     * @author gyh
     */
    public String getSellerName() {
        return this.sellerName;
    }

    /**
     * Set the sellerName.
     *
     * @param sellerName sellerName
     *
     * @author gyh
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    /**
     * Get the products.
     *
     * @return products
     *
     * @author gyh
     */
    public List<ISO251401RsProduct> getProducts() {
        return this.products;
    }

    /**
     * Set the products.
     *
     * @param products products
     *
     * @author gyh
     */
    public void setProducts(List<ISO251401RsProduct> products) {
        this.products = products;
    }


    /**
     * 获得buyersType
     */
    public String getBuyersType() {
        return buyersType;
    }

    /**
     * 设置buyersType
     */
    public void setBuyersType(String buyersType) {
        this.buyersType = buyersType;
    }

}
