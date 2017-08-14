package com.msk.by.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.ByBuyerLicence;
import com.msk.core.entity.ByBuyerPictures;

/**
 * IBY121205RsParam.
 *
 * @author zhou_yajun
 */
@JsonIgnoreProperties(value = { "crtTime","updTime"})
public class IBY121205RsParam extends ByBuyerLicence {

    private static final long serialVersionUID = 1L;
    //证照名称
    private String licDes;
    //法定代表人证件名称
    private String legalLicDes;

    /**
     * Getter method for property <tt>licDes</tt>.
     *
     * @return property value of licDes
     */
    public String getLicDes() {
        return licDes;
    }

    /**
     * Setter method for property <tt>licDes</tt>.
     *
     * @param licDes value to be assigned to property licDes
     */
    public void setLicDes(String licDes) {
        this.licDes = licDes;
    }

    /**
     * Getter method for property <tt>legalLicDes</tt>.
     *
     * @return property value of legalLicDes
     */
    public String getLegalLicDes() {
        return legalLicDes;
    }

    /**
     * Setter method for property <tt>legalLicDes</tt>.
     *
     * @param legalLicDes value to be assigned to property legalLicDes
     */
    public void setLegalLicDes(String legalLicDes) {
        this.legalLicDes = legalLicDes;
    }
}