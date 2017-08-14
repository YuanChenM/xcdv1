/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_order_buyer_seq对应的SoOrderBuyerSeq。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoOrderBuyerSeq extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 顺序号ID */
    private java.lang.Long id;
    /** 买家编码 */
    private java.lang.String buyesCode;
    /** 订单顺序号 */
    private java.lang.Long buyCount;
    /**
     * <p>默认构造函数。</p>
     */
    public SoOrderBuyerSeq() {

    }

    /**
     * <p>顺序号ID。</p>
     *
     * @return the 顺序号ID
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     * <p>顺序号ID。</p>
     *
     * @param id 顺序号ID。
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    /**
     * <p>买家编码。</p>
     *
     * @return the 买家编码
     */
    public java.lang.String getBuyesCode() {
        return buyesCode;
    }

    /**
     * <p>买家编码。</p>
     *
     * @param buyesCode 买家编码。
     */
    public void setBuyesCode(java.lang.String buyesCode) {
        this.buyesCode = buyesCode;
    }

    /**
     * <p>订单顺序号。</p>
     *
     * @return the 订单顺序号
     */
    public java.lang.Long getBuyCount() {
        return buyCount;
    }

    /**
     * <p>订单顺序号。</p>
     *
     * @param buyCount 订单顺序号。
     */
    public void setBuyCount(java.lang.Long buyCount) {
        this.buyCount = buyCount;
    }

}
