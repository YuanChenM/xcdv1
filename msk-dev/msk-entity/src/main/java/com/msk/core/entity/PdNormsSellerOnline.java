/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_norms_seller_online对应的PdNormsSellerOnline�?</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdNormsSellerOnline extends BaseEntity{
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
    /** 包装ID */
    private String normsId;
    /** 包装名称 */
    private String normsName;
    /** �?测日�? */
    private java.util.Date checkDate;
    /** 0：不合格�?1：合�? */
    private Integer resultInnerweightFlg;
    /** 单个产品规格�?�? �?测结果描�? */
    private String resultInnerweightInfo;
    /** 0：不合格�?1：合�? */
    private Integer resultInnererrorFlg;
    /** 单个产品�?重误差范�? �?测结果描�? */
    private String resultInnererrorInfo;
    /** 0：不合格�?1：合�? */
    private Integer resultInnercountFlg;
    /** 内包装净�?/个数 �?测结果描�? */
    private String resultInnercountInfo;
    /** 0：不合格�?1：合�? */
    private Integer resultInnersizeFlg;
    /** 内包装尺�? �?测结果描�? */
    private String resultInnersizeInfo;
    /** 0：不合格�?1：合�? */
    private Integer resultInnermatFlg;
    /** 内包装材�? �?测结果描�? */
    private String resultInnermatInfo;
    /** 0：不合格�?1：合�? */
    private Integer resultOutspecFlg;
    /** 外包装规�? �?测结果描�? */
    private String resultOutspecInfo;
    /** 0：不合格�?1：合�? */
    private Integer resultOutweightFlg;
    /** 外包装净�?/毛重 �?测结果描�? */
    private String resultOutweightInfo;
    /** 0：不合格�?1：合�? */
    private Integer resultOutsizeFlg;
    /** 外包装尺�? �?测结果描�? */
    private String resultOutsizeInfo;
    /** 0：不合格�?1：合�? */
    private Integer resultOutmatFlg;
    /** 外包装材�? �?测结果描�? */
    private String resultOutmatInfo;
    /**
     * <p>默认构�?�函数�??</p>
     */
    public PdNormsSellerOnline() {

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
     * <p>包装ID�?</p>
     *
     * @return the 包装ID
     */
    public String getNormsId() {
        return normsId;
    }

    /**
     * <p>包装ID�?</p>
     *
     * @param normsId 包装ID�?
     */
    public void setNormsId(String normsId) {
        this.normsId = normsId;
    }

    /**
     * <p>包装名称�?</p>
     *
     * @return the 包装名称
     */
    public String getNormsName() {
        return normsName;
    }

    /**
     * <p>包装名称�?</p>
     *
     * @param normsName 包装名称�?
     */
    public void setNormsName(String normsName) {
        this.normsName = normsName;
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
     * <p>0：不合格�?1：合格�??</p>
     *
     * @return the 0：不合格�?1：合�?
     */
    public Integer getResultInnerweightFlg() {
        return resultInnerweightFlg;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @param resultInnerweightFlg 0：不合格�?1：合格�??
     */
    public void setResultInnerweightFlg(Integer resultInnerweightFlg) {
        this.resultInnerweightFlg = resultInnerweightFlg;
    }

    /**
     * <p>单个产品规格�?�? �?测结果描述�??</p>
     *
     * @return the 单个产品规格�?�? �?测结果描�?
     */
    public String getResultInnerweightInfo() {
        return resultInnerweightInfo;
    }

    /**
     * <p>单个产品规格�?�? �?测结果描述�??</p>
     *
     * @param resultInnerweightInfo 单个产品规格�?�? �?测结果描述�??
     */
    public void setResultInnerweightInfo(String resultInnerweightInfo) {
        this.resultInnerweightInfo = resultInnerweightInfo;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @return the 0：不合格�?1：合�?
     */
    public Integer getResultInnererrorFlg() {
        return resultInnererrorFlg;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @param resultInnererrorFlg 0：不合格�?1：合格�??
     */
    public void setResultInnererrorFlg(Integer resultInnererrorFlg) {
        this.resultInnererrorFlg = resultInnererrorFlg;
    }

    /**
     * <p>单个产品�?重误差范�? �?测结果描述�??</p>
     *
     * @return the 单个产品�?重误差范�? �?测结果描�?
     */
    public String getResultInnererrorInfo() {
        return resultInnererrorInfo;
    }

    /**
     * <p>单个产品�?重误差范�? �?测结果描述�??</p>
     *
     * @param resultInnererrorInfo 单个产品�?重误差范�? �?测结果描述�??
     */
    public void setResultInnererrorInfo(String resultInnererrorInfo) {
        this.resultInnererrorInfo = resultInnererrorInfo;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @return the 0：不合格�?1：合�?
     */
    public Integer getResultInnercountFlg() {
        return resultInnercountFlg;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @param resultInnercountFlg 0：不合格�?1：合格�??
     */
    public void setResultInnercountFlg(Integer resultInnercountFlg) {
        this.resultInnercountFlg = resultInnercountFlg;
    }

    /**
     * <p>内包装净�?/个数 �?测结果描述�??</p>
     *
     * @return the 内包装净�?/个数 �?测结果描�?
     */
    public String getResultInnercountInfo() {
        return resultInnercountInfo;
    }

    /**
     * <p>内包装净�?/个数 �?测结果描述�??</p>
     *
     * @param resultInnercountInfo 内包装净�?/个数 �?测结果描述�??
     */
    public void setResultInnercountInfo(String resultInnercountInfo) {
        this.resultInnercountInfo = resultInnercountInfo;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @return the 0：不合格�?1：合�?
     */
    public Integer getResultInnersizeFlg() {
        return resultInnersizeFlg;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @param resultInnersizeFlg 0：不合格�?1：合格�??
     */
    public void setResultInnersizeFlg(Integer resultInnersizeFlg) {
        this.resultInnersizeFlg = resultInnersizeFlg;
    }

    /**
     * <p>内包装尺�? �?测结果描述�??</p>
     *
     * @return the 内包装尺�? �?测结果描�?
     */
    public String getResultInnersizeInfo() {
        return resultInnersizeInfo;
    }

    /**
     * <p>内包装尺�? �?测结果描述�??</p>
     *
     * @param resultInnersizeInfo 内包装尺�? �?测结果描述�??
     */
    public void setResultInnersizeInfo(String resultInnersizeInfo) {
        this.resultInnersizeInfo = resultInnersizeInfo;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @return the 0：不合格�?1：合�?
     */
    public Integer getResultInnermatFlg() {
        return resultInnermatFlg;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @param resultInnermatFlg 0：不合格�?1：合格�??
     */
    public void setResultInnermatFlg(Integer resultInnermatFlg) {
        this.resultInnermatFlg = resultInnermatFlg;
    }

    /**
     * <p>内包装材�? �?测结果描述�??</p>
     *
     * @return the 内包装材�? �?测结果描�?
     */
    public String getResultInnermatInfo() {
        return resultInnermatInfo;
    }

    /**
     * <p>内包装材�? �?测结果描述�??</p>
     *
     * @param resultInnermatInfo 内包装材�? �?测结果描述�??
     */
    public void setResultInnermatInfo(String resultInnermatInfo) {
        this.resultInnermatInfo = resultInnermatInfo;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @return the 0：不合格�?1：合�?
     */
    public Integer getResultOutspecFlg() {
        return resultOutspecFlg;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @param resultOutspecFlg 0：不合格�?1：合格�??
     */
    public void setResultOutspecFlg(Integer resultOutspecFlg) {
        this.resultOutspecFlg = resultOutspecFlg;
    }

    /**
     * <p>外包装规�? �?测结果描述�??</p>
     *
     * @return the 外包装规�? �?测结果描�?
     */
    public String getResultOutspecInfo() {
        return resultOutspecInfo;
    }

    /**
     * <p>外包装规�? �?测结果描述�??</p>
     *
     * @param resultOutspecInfo 外包装规�? �?测结果描述�??
     */
    public void setResultOutspecInfo(String resultOutspecInfo) {
        this.resultOutspecInfo = resultOutspecInfo;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @return the 0：不合格�?1：合�?
     */
    public Integer getResultOutweightFlg() {
        return resultOutweightFlg;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @param resultOutweightFlg 0：不合格�?1：合格�??
     */
    public void setResultOutweightFlg(Integer resultOutweightFlg) {
        this.resultOutweightFlg = resultOutweightFlg;
    }

    /**
     * <p>外包装净�?/毛重 �?测结果描述�??</p>
     *
     * @return the 外包装净�?/毛重 �?测结果描�?
     */
    public String getResultOutweightInfo() {
        return resultOutweightInfo;
    }

    /**
     * <p>外包装净�?/毛重 �?测结果描述�??</p>
     *
     * @param resultOutweightInfo 外包装净�?/毛重 �?测结果描述�??
     */
    public void setResultOutweightInfo(String resultOutweightInfo) {
        this.resultOutweightInfo = resultOutweightInfo;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @return the 0：不合格�?1：合�?
     */
    public Integer getResultOutsizeFlg() {
        return resultOutsizeFlg;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @param resultOutsizeFlg 0：不合格�?1：合格�??
     */
    public void setResultOutsizeFlg(Integer resultOutsizeFlg) {
        this.resultOutsizeFlg = resultOutsizeFlg;
    }

    /**
     * <p>外包装尺�? �?测结果描述�??</p>
     *
     * @return the 外包装尺�? �?测结果描�?
     */
    public String getResultOutsizeInfo() {
        return resultOutsizeInfo;
    }

    /**
     * <p>外包装尺�? �?测结果描述�??</p>
     *
     * @param resultOutsizeInfo 外包装尺�? �?测结果描述�??
     */
    public void setResultOutsizeInfo(String resultOutsizeInfo) {
        this.resultOutsizeInfo = resultOutsizeInfo;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @return the 0：不合格�?1：合�?
     */
    public Integer getResultOutmatFlg() {
        return resultOutmatFlg;
    }

    /**
     * <p>0：不合格�?1：合格�??</p>
     *
     * @param resultOutmatFlg 0：不合格�?1：合格�??
     */
    public void setResultOutmatFlg(Integer resultOutmatFlg) {
        this.resultOutmatFlg = resultOutmatFlg;
    }

    /**
     * <p>外包装材�? �?测结果描述�??</p>
     *
     * @return the 外包装材�? �?测结果描�?
     */
    public String getResultOutmatInfo() {
        return resultOutmatInfo;
    }

    /**
     * <p>外包装材�? �?测结果描述�??</p>
     *
     * @param resultOutmatInfo 外包装材�? �?测结果描述�??
     */
    public void setResultOutmatInfo(String resultOutmatInfo) {
        this.resultOutmatInfo = resultOutmatInfo;
    }

}
