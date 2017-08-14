/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.batch.wq.entity;

import com.msk.core.entity.BaseEntity;

/**
 * <p>表wq_order_product对应的WqOrderProduct。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class WqOrderProduct extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 表格ID */
    private Long tblId;
    /** 外勤超级表单子表ID */
    private String wqSubId;
    /** 外勤超级表单ID */
    private String wqId;
    /** 订单ID */
    private Long orderId;
    /** 产品编码 */
    private String pdCode;
    /** 产品名称 */
    private String pdName;
    /** 产品价格 */
    private String pdPrice;
    /** 订购数量 */
    private String orderQty;
    /**
     * <p>默认构造函数。</p>
     */
    public WqOrderProduct() {

    }

    /**
     * <p>表格ID。</p>
     *
     * @return the 表格ID
     */
    public Long getTblId() {
        return tblId;
    }

    /**
     * <p>表格ID。</p>
     *
     * @param tblId 表格ID。
     */
    public void setTblId(Long tblId) {
        this.tblId = tblId;
    }

    /**
     * <p>外勤超级表单子表ID。</p>
     *
     * @return the 外勤超级表单子表ID
     */
    public String getWqSubId() {
        return wqSubId;
    }

    /**
     * <p>外勤超级表单子表ID。</p>
     *
     * @param wqSubId 外勤超级表单子表ID。
     */
    public void setWqSubId(String wqSubId) {
        this.wqSubId = wqSubId;
    }

    /**
     * <p>外勤超级表单ID。</p>
     *
     * @return the 外勤超级表单ID
     */
    public String getWqId() {
        return wqId;
    }

    /**
     * <p>外勤超级表单ID。</p>
     *
     * @param wqId 外勤超级表单ID。
     */
    public void setWqId(String wqId) {
        this.wqId = wqId;
    }

    /**
     * <p>订单ID。</p>
     *
     * @return the 订单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * <p>订单ID。</p>
     *
     * @param orderId 订单ID。
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * <p>产品编码。</p>
     *
     * @return the 产品编码
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编码。</p>
     *
     * @param pdCode 产品编码。
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>产品名称。</p>
     *
     * @return the 产品名称
     */
    public String getPdName() {
        return pdName;
    }

    /**
     * <p>产品名称。</p>
     *
     * @param pdName 产品名称。
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    /**
     * <p>产品价格。</p>
     *
     * @return the 产品价格
     */
    public String getPdPrice() {
        return pdPrice;
    }

    /**
     * <p>产品价格。</p>
     *
     * @param pdPrice 产品价格。
     */
    public void setPdPrice(String pdPrice) {
        this.pdPrice = pdPrice;
    }

    /**
     * <p>订购数量。</p>
     *
     * @return the 订购数量
     */
    public String getOrderQty() {
        return orderQty;
    }

    /**
     * <p>订购数量。</p>
     *
     * @param orderQty 订购数量。
     */
    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

}
