/*
 * 2017/04/17 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.msk.pl.bean;


import com.msk.core.bean.BaseBean;

/**
 * <p>表pl_declare_task对应的实体PlDeclareTask</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PlDeclareTask extends BaseBean{

    /** ID */
    private Long dtId;
    /** 合伙人id */
    private Long partnerId;
    /** 物流区编码 */
    private String lgcsCode;
    /** 物流区名称 */
    private String lgcsName;
    /** 配送站id */
    private Long terminalId;
    /** 领地id */
    private Long domainId;
    /** 买手编码 */
    private String bsCode;
    /** 买手名称 */
    private String bsName;
    /** 填报期数id */
    private Long ppId;
    /** 填报期数 */
    private String pricePeriod;
    /** 填报日期 */
    private java.util.Date dtDate;
    /** 状态 */
    private Integer dtStatus;
    /** 版本号 */
    private Integer ver;

    /**
     * <p>默认构造函数</p>
     */
    public PlDeclareTask() {
    }

    /**
     * <p>ID</p>
     *
     * @return ID
     */
    public Long getDtId() {
        return dtId;
    }

    /**
     * <p>ID</p>
     *
     * @param dtId ID
     */
    public void setDtId(Long dtId) {
        this.dtId = dtId;
    }
    /**
     * <p>合伙人id</p>
     *
     * @return 合伙人id
     */
    public Long getPartnerId() {
        return partnerId;
    }

    /**
     * <p>合伙人id</p>
     *
     * @param partnerId 合伙人id
     */
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
    /**
     * <p>物流区编码</p>
     *
     * @return 物流区编码
     */
    public String getLgcsCode() {
        return lgcsCode;
    }

    /**
     * <p>物流区编码</p>
     *
     * @param lgcsCode 物流区编码
     */
    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }
    /**
     * <p>物流区名称</p>
     *
     * @return 物流区名称
     */
    public String getLgcsName() {
        return lgcsName;
    }

    /**
     * <p>物流区名称</p>
     *
     * @param lgcsName 物流区名称
     */
    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }
    /**
     * <p>配送站id</p>
     *
     * @return 配送站id
     */
    public Long getTerminalId() {
        return terminalId;
    }

    /**
     * <p>配送站id</p>
     *
     * @param terminalId 配送站id
     */
    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }
    /**
     * <p>领地id</p>
     *
     * @return 领地id
     */
    public Long getDomainId() {
        return domainId;
    }

    /**
     * <p>领地id</p>
     *
     * @param domainId 领地id
     */
    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }
    /**
     * <p>买手编码</p>
     *
     * @return 买手编码
     */
    public String getBsCode() {
        return bsCode;
    }

    /**
     * <p>买手编码</p>
     *
     * @param bsCode 买手编码
     */
    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }
    /**
     * <p>买手名称</p>
     *
     * @return 买手名称
     */
    public String getBsName() {
        return bsName;
    }

    /**
     * <p>买手名称</p>
     *
     * @param bsName 买手名称
     */
    public void setBsName(String bsName) {
        this.bsName = bsName;
    }
    /**
     * <p>填报期数id</p>
     *
     * @return 填报期数id
     */
    public Long getPpId() {
        return ppId;
    }

    /**
     * <p>填报期数id</p>
     *
     * @param ppId 填报期数id
     */
    public void setPpId(Long ppId) {
        this.ppId = ppId;
    }
    /**
     * <p>填报期数</p>
     *
     * @return 填报期数
     */
    public String getPricePeriod() {
        return pricePeriod;
    }

    /**
     * <p>填报期数</p>
     *
     * @param pricePeriod 填报期数
     */
    public void setPricePeriod(String pricePeriod) {
        this.pricePeriod = pricePeriod;
    }
    /**
     * <p>填报日期</p>
     *
     * @return 填报日期
     */
    public java.util.Date getDtDate() {
        return dtDate;
    }

    /**
     * <p>填报日期</p>
     *
     * @param dtDate 填报日期
     */
    public void setDtDate(java.util.Date dtDate) {
        this.dtDate = dtDate;
    }
    /**
     * <p>状态</p>
     *
     * @return 状态
     */
    public Integer getDtStatus() {
        return dtStatus;
    }

    /**
     * <p>状态</p>
     *
     * @param dtStatus 状态
     */
    public void setDtStatus(Integer dtStatus) {
        this.dtStatus = dtStatus;
    }
    /**
     * <p>版本号</p>
     *
     * @return 版本号
     */
    public Integer getVer() {
        return ver;
    }

    /**
     * <p>版本号</p>
     *
     * @param ver 版本号
     */
    public void setVer(Integer ver) {
        this.ver = ver;
    }

}
