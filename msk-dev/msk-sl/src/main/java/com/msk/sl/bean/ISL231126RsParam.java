package com.msk.sl.bean;

import com.msk.core.bean.BaseParam;

/**
 * Created by Administrator on 2016/2/16.
 */
public class ISL231126RsParam extends BaseParam {
    /**
     * 证照ID
     */
    public Long certId;
    /**
     * 证照名称
     */
    public String certName;

    /**
     * Getter method for property <tt>certId</tt>.
     *
     * @return property value of certId
     */
    public Long getCertId() {
        return certId;
    }

    /**
     * Setter method for property <tt>certId</tt>.
     *
     * @param certId value to be assigned to property certId
     */
    public void setCertId(Long certId) {
        this.certId = certId;
    }

    /**
     * Getter method for property <tt>certName</tt>.
     *
     * @return property value of certName
     */
    public String getCertName() {
        return certName;
    }

    /**
     * Setter method for property <tt>certName</tt>.
     *
     * @param certName value to be assigned to property certName
     */
    public void setCertName(String certName) {
        this.certName = certName;
    }
}
