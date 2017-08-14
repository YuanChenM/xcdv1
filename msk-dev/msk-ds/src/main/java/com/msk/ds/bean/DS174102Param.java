package com.msk.ds.bean;

import com.msk.core.bean.BasePageParam;

/**
 * DS174102Param.
 *
 * @author yuan_chen
 */
public class DS174102Param extends BasePageParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 生成数量 */
    private String lotNum;

    /** lotId */
    private String lotId;

    /** lotCode */
    private String lotCode;

    /**
     * Getter method for property <tt>lotNum</tt>.
     *
     * @return property value of lotNum
     */
    public String getLotNum() {
        return lotNum;
    }

    /**
     * Setter method for property <tt>lotNum</tt>.
     *
     * @param lotNum value to be assigned to property lotNum
     */
    public void setLotNum(String lotNum) {
        this.lotNum = lotNum;
    }

    /**
     * Getter method for property <tt>lotId</tt>.
     *
     * @return property value of lotId
     */
    public String getLotId() {
        return lotId;
    }

    /**
     * Setter method for property <tt>lotId</tt>.
     *
     * @param lotId value to be assigned to property lotId
     */
    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    /**
     * Getter method for property <tt>lotCode</tt>.
     *
     * @return property value of lotCode
     */
    public String getLotCode() {
        return lotCode;
    }

    /**
     * Setter method for property <tt>lotCode</tt>.
     *
     * @param lotCode value to be assigned to property lotCode
     */
    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }
}
