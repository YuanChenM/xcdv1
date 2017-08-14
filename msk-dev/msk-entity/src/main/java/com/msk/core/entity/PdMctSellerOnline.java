/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_mct_seller_online对应的PdMctSellerOnline�?</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdMctSellerOnline extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 表格ID */
    private Long onlineId;
    /** 卖家ID */
    private String slId;
    /** 卖家CODE */
    private String slCodeDis;
    /** 卖家产品ID */
    private Long slPdId;
    /** 产品标准ID */
    private Long standardId;
    /** 产品批次 */
    private String pdLot;
    /** 加工�?术标准项目ID */
    private String mctStdItemId;
    /** 加工�?术标准项目名�? */
    private String mctStdItemName;
    /** �?测日�? */
    private java.util.Date checkDate;
    /** 0：不合格�?1：合格； */
    private Integer resultFlg;
    /** �?测结果描�? */
    private String resultInfo;
    /**
     * <p>默认构�?�函数�??</p>
     */
    public PdMctSellerOnline() {

    }

    /**
     * <p>表格ID�?</p>
     *
     * @return the 表格ID
     */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
     * <p>表格ID�?</p>
     *
     * @param onlineId 表格ID�?
     */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    /**
     * <p>卖家ID�?</p>
     *
     * @return the 卖家ID
     */
    public String getSlId() {
        return slId;
    }

    /**
     * <p>卖家ID�?</p>
     *
     * @param slId 卖家ID�?
     */
    public void setSlId(String slId) {
        this.slId = slId;
    }

    /**
     * <p>卖家CODE�?</p>
     *
     * @return the 卖家CODE
     */
    public String getSlCodeDis() {
        return slCodeDis;
    }

    /**
     * <p>卖家CODE�?</p>
     *
     * @param slCodeDis 卖家CODE�?
     */
    public void setSlCodeDis(String slCodeDis) {
        this.slCodeDis = slCodeDis;
    }

    /**
     * <p>卖家产品ID�?</p>
     *
     * @return the 卖家产品ID
     */
    public Long getSlPdId() {
        return slPdId;
    }

    /**
     * <p>卖家产品ID�?</p>
     *
     * @param slPdId 卖家产品ID�?
     */
    public void setSlPdId(Long slPdId) {
        this.slPdId = slPdId;
    }

    /**
     * <p>产品标准ID�?</p>
     *
     * @return the 产品标准ID
     */
    public Long getStandardId() {
        return standardId;
    }

    /**
     * <p>产品标准ID�?</p>
     *
     * @param standardId 产品标准ID�?
     */
    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    /**
     * <p>产品批次�?</p>
     *
     * @return the 产品批次
     */
    public String getPdLot() {
        return pdLot;
    }

    /**
     * <p>产品批次�?</p>
     *
     * @param pdLot 产品批次�?
     */
    public void setPdLot(String pdLot) {
        this.pdLot = pdLot;
    }

    /**
     * <p>加工�?术标准项目ID�?</p>
     *
     * @return the 加工�?术标准项目ID
     */
    public String getMctStdItemId() {
        return mctStdItemId;
    }

    /**
     * <p>加工�?术标准项目ID�?</p>
     *
     * @param mctStdItemId 加工�?术标准项目ID�?
     */
    public void setMctStdItemId(String mctStdItemId) {
        this.mctStdItemId = mctStdItemId;
    }

    /**
     * <p>加工�?术标准项目名称�??</p>
     *
     * @return the 加工�?术标准项目名�?
     */
    public String getMctStdItemName() {
        return mctStdItemName;
    }

    /**
     * <p>加工�?术标准项目名称�??</p>
     *
     * @param mctStdItemName 加工�?术标准项目名称�??
     */
    public void setMctStdItemName(String mctStdItemName) {
        this.mctStdItemName = mctStdItemName;
    }

    /**
     * <p>�?测日期�??</p>
     *
     * @return the �?测日�?
     */
    public java.util.Date getCheckDate() {
        return checkDate;
    }

    /**
     * <p>�?测日期�??</p>
     *
     * @param checkDate �?测日期�??
     */
    public void setCheckDate(java.util.Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * <p>0：不合格�?1：合格；�?</p>
     *
     * @return the 0：不合格�?1：合格；
     */
    public Integer getResultFlg() {
        return resultFlg;
    }

    /**
     * <p>0：不合格�?1：合格；�?</p>
     *
     * @param resultFlg 0：不合格�?1：合格；�?
     */
    public void setResultFlg(Integer resultFlg) {
        this.resultFlg = resultFlg;
    }

    /**
     * <p>�?测结果描述�??</p>
     *
     * @return the �?测结果描�?
     */
    public String getResultInfo() {
        return resultInfo;
    }

    /**
     * <p>�?测结果描述�??</p>
     *
     * @param resultInfo �?测结果描述�??
     */
    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

}
