package com.msk.ds.bean;

import com.msk.core.entity.BaseEntity;

/**
 * Created by Administrator on 2016/6/7.
 */
public class TSC10004Bean extends BaseEntity {

    /**
     * 合同编号
     */
    private String contractNumber;
    /** 合同编号*/
    private String contractName;
    /** 生产商*/
    private String manufacture ;
    /** 合同生效日期*/
    private String contractDate;
    /** 状态*/
    private String status;

    /**
     * Getter method for property <tt>contractNumber</tt>.
     *
     * @return property value of contractNumber
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Setter method for property <tt>contractNumber</tt>.
     *
     * @param contractNumber value to be assigned to property contractNumber
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * Getter method for property <tt>contractName</tt>.
     *
     * @return property value of contractName
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * Setter method for property <tt>contractName</tt>.
     *
     * @param contractName value to be assigned to property contractName
     */
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    /**
     * Getter method for property <tt>manufacture</tt>.
     *
     * @return property value of manufacture
     */
    public String getManufacture() {
        return manufacture;
    }

    /**
     * Setter method for property <tt>manufacture</tt>.
     *
     * @param manufacture value to be assigned to property manufacture
     */
    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    /**
     * Getter method for property <tt>contractDate</tt>.
     *
     * @return property value of contractDate
     */
    public String getContractDate() {
        return contractDate;
    }

    /**
     * Setter method for property <tt>contractDate</tt>.
     *
     * @param contractDate value to be assigned to property contractDate
     */
    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     *
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
