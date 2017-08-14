/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_app_floor对应的PdAppFloor。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdAppFloor extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private java.lang.Long id;
    /** 名称 */
    private java.lang.String floorName;
    /** 物流区编码 */
    private java.lang.String lgcsCode;
    /** 物流区名称 */
    private java.lang.String lgcsName;
    /** 取色码 */
    private java.lang.String color;
    /** 顺序号 */
    private java.lang.String sort;
    /**
     * <p>默认构造函数。</p>
     */
    public PdAppFloor() {

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
     * <p>名称。</p>
     *
     * @return the 名称
     */
    public java.lang.String getFloorName() {
        return floorName;
    }

    /**
     * <p>名称。</p>
     *
     * @param floorName 名称。
     */
    public void setFloorName(java.lang.String floorName) {
        this.floorName = floorName;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @return the 物流区编码
     */
    public java.lang.String getLgcsCode() {
        return lgcsCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @param lgcsCode 物流区编码。
     */
    public void setLgcsCode(java.lang.String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    /**
     * <p>物流区名称。</p>
     *
     * @return the 物流区名称
     */
    public java.lang.String getLgcsName() {
        return lgcsName;
    }

    /**
     * <p>物流区名称。</p>
     *
     * @param lgcsName 物流区名称。
     */
    public void setLgcsName(java.lang.String lgcsName) {
        this.lgcsName = lgcsName;
    }

    /**
     * <p>取色码。</p>
     *
     * @return the 取色码
     */
    public java.lang.String getColor() {
        return color;
    }

    /**
     * <p>取色码。</p>
     *
     * @param color 取色码。
     */
    public void setColor(java.lang.String color) {
        this.color = color;
    }

    /**
     * <p>顺序号。</p>
     *
     * @return the 顺序号
     */
    public java.lang.String getSort() {
        return sort;
    }

    /**
     * <p>顺序号。</p>
     *
     * @param sort 顺序号。
     */
    public void setSort(java.lang.String sort) {
        this.sort = sort;
    }

}
