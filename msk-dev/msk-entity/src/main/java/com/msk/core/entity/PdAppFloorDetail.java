/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_app_floor_detail对应的PdAppFloorDetail。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdAppFloorDetail extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private java.lang.Long id;
    /** 产品楼层ID */
    private java.lang.Long floorId;
    /** 产品编码 */
    private java.lang.String pdCode;
    /**
     * <p>默认构造函数。</p>
     */
    public PdAppFloorDetail() {

    }

    /**
     * <p>主键ID。</p>
     *
     * @return the 主键ID
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     * <p>主键ID。</p>
     *
     * @param id 主键ID。
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    /**
     * <p>产品楼层ID。</p>
     *
     * @return the 产品楼层ID
     */
    public java.lang.Long getFloorId() {
        return floorId;
    }

    /**
     * <p>产品楼层ID。</p>
     *
     * @param floorId 产品楼层ID。
     */
    public void setFloorId(java.lang.Long floorId) {
        this.floorId = floorId;
    }

    /**
     * <p>产品编码。</p>
     *
     * @return the 产品编码
     */
    public java.lang.String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编码。</p>
     *
     * @param pdCode 产品编码。
     */
    public void setPdCode(java.lang.String pdCode) {
        this.pdCode = pdCode;
    }

}
