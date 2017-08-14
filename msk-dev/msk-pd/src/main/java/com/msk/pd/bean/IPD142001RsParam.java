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
public class IPD142001RsParam extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String constantType; //分CodeMaster和Status


    /**
     * Getter method for property <tt>constantType</tt>.
     *
     * @return property value of constantType
     */
    public String getConstantType() {
        return constantType;
    }

    /**
     * Setter method for property <tt>constantType</tt>.
     *
     * @param constantType value to be assigned to property constantType
     */
    public void setConstantType(String constantType) {
        this.constantType = constantType;
    }
}