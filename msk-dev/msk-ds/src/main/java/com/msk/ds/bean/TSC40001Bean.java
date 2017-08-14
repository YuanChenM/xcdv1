package com.msk.ds.bean;

import com.msk.core.entity.BaseEntity;

/**
 * TSC40001Bean.
 *
 * @author XHY
 */
public class TSC40001Bean extends BaseEntity{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String producerCode;
    private String producerName;
    private String contactsName;
    private String contactsPhone;
    private String region;


    /**
     * Getter method for property <tt>producerCode</tt>.
     *
     * @return property value of producerCode
     */
    public String getProducerCode() {
        return producerCode;
    }

    /**
     * Setter method for property <tt>producerCode</tt>.
     *
     * @param producerCode value to be assigned to property producerCode
     */
    public void setProducerCode(String producerCode) {
        this.producerCode = producerCode;
    }

    /**
     * Getter method for property <tt>producerName</tt>.
     *
     * @return property value of producerName
     */
    public String getProducerName() {
        return producerName;
    }

    /**
     * Setter method for property <tt>producerName</tt>.
     *
     * @param producerName value to be assigned to property producerName
     */
    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    /**
     * Getter method for property <tt>contactsName</tt>.
     *
     * @return property value of contactsName
     */
    public String getContactsName() {
        return contactsName;
    }

    /**
     * Setter method for property <tt>contactsName</tt>.
     *
     * @param contactsName value to be assigned to property contactsName
     */
    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    /**
     * Getter method for property <tt>contactsPhone</tt>.
     *
     * @return property value of contactsPhone
     */
    public String getContactsPhone() {
        return contactsPhone;
    }

    /**
     * Setter method for property <tt>contactsPhone</tt>.
     *
     * @param contactsPhone value to be assigned to property contactsPhone
     */
    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

    /**
     * Getter method for property <tt>region</tt>.
     *
     * @return property value of region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Setter method for property <tt>region</tt>.
     *
     * @param region value to be assigned to property region
     */
    public void setRegion(String region) {
        this.region = region;
    }
}
