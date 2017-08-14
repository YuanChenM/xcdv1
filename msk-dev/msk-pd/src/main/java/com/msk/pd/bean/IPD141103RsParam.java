package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.BaseEntity;

/**
 * 销售状态一览对象
 * IPD141103RsParam.
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId", "actTime" })
public class IPD141103RsParam extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String saleStatusCode; // 销售状态编码
    private String saleStatusName; // 销售状态名称

    /**
     * Get the saleStatusCode.
     *
     * @return saleStatusCode
     *
     * @author xhy
     */
    public String getSaleStatusCode() {
        return this.saleStatusCode;
    }

    /**
     * Set the saleStatusCode.
     *
     * @param saleStatusCode saleStatusCode
     *
     * @author xhy
     */
    public void setSaleStatusCode(String saleStatusCode) {
        this.saleStatusCode = saleStatusCode;
    }

    /**
     * Get the saleStatusName.
     *
     * @return saleStatusName
     *
     * @author xhy
     */
    public String getSaleStatusName() {
        return this.saleStatusName;
    }

    /**
     * Set the saleStatusName.
     *
     * @param saleStatusName saleStatusName
     *
     * @author xhy
     */
    public void setSaleStatusName(String saleStatusName) {
        this.saleStatusName = saleStatusName;
    }

}