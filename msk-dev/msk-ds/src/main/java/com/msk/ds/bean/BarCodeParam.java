package com.msk.ds.bean;

import com.msk.core.bean.BaseParam;

/**
 * yuan_chen on 2016/4/28.
 */
public class BarCodeParam extends BaseParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    //打印起始数据
    private int printStart;
    //打印结束数据
    private int printEnd;
    //打印UUID
    private String barcodeId;

    /**
     * Getter method for property <tt>printStart</tt>.
     *
     * @return property value of printStart
     */
    public int getPrintStart() {
        return printStart;
    }

    /**
     * Setter method for property <tt>printStart</tt>.
     *
     * @param printStart value to be assigned to property printStart
     */
    public void setPrintStart(int printStart) {
        this.printStart = printStart;
    }

    /**
     * Getter method for property <tt>printEnd</tt>.
     *
     * @return property value of printEnd
     */
    public int getPrintEnd() {
        return printEnd;
    }

    /**
     * Setter method for property <tt>printEnd</tt>.
     *
     * @param printEnd value to be assigned to property printEnd
     */
    public void setPrintEnd(int printEnd) {
        this.printEnd = printEnd;
    }

    /**
     * Getter method for property <tt>barcodeId</tt>.
     *
     * @return property value of barcodeId
     */
    public String getBarcodeId() {
        return barcodeId;
    }

    /**
     * Setter method for property <tt>barcodeId</tt>.
     *
     * @param barcodeId value to be assigned to property barcodeId
     */
    public void setBarcodeId(String barcodeId) {
        this.barcodeId = barcodeId;
    }
}
