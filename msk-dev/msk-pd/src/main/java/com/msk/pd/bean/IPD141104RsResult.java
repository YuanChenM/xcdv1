package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.BaseEntity;

/**
 * 查询产品主码 返回参数
 * IPD141105RsResult.
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId", "actTime", "standardId" })
public class IPD141104RsResult extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String machiningCode; // 产品加工程度编码
    private String machiningName; // 产品加工程度名称

    /**
     * Get the machiningCode.
     *
     * @return machiningCode
     *
     * @author xhy
     */
    public String getMachiningCode() {
        return this.machiningCode;
    }

    /**
     * Set the machiningCode.
     *
     * @param machiningCode machiningCode
     *
     * @author xhy
     */
    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    /**
     * Get the machiningName.
     *
     * @return machiningName
     *
     * @author xhy
     */
    public String getMachiningName() {
        return this.machiningName;
    }

    /**
     * Set the machiningName.
     *
     * @param machiningName machiningName
     *
     * @author xhy
     */
    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }
}