package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

/**
 * 产品标准包装档案卡查询返回值
 * IPD141108RsResult
 *
 * @author xhy
 */
public class IPD141108RsResult extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String pdNormsCode;

    private String pdName;

    private String netweightOut;

    private String grossweightOut;
    /**
     * 外包装长
     */
    private String normsLength;
    /**
     * 外包装宽
     */
    private String normsWidth;

    /**
     * 外包装高
     */
    private String normsHeight;

    /**
     * 外包装体积
     */
    private String normsVolume;


    /**
     * Getter method for property <tt>pdNormsCode</tt>.
     *
     * @return property value of pdNormsCode
     */
    public String getPdNormsCode() {
        return pdNormsCode;
    }

    /**
     * Setter method for property <tt>pdNormsCode</tt>.
     *
     * @param pdNormsCode value to be assigned to property pdNormsCode
     */
    public void setPdNormsCode(String pdNormsCode) {
        this.pdNormsCode = pdNormsCode;
    }

    /**
     * Getter method for property <tt>pdName</tt>.
     *
     * @return property value of pdName
     */
    public String getPdName() {
        return pdName;
    }

    /**
     * Setter method for property <tt>pdName</tt>.
     *
     * @param pdName value to be assigned to property pdName
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    /**
     * Getter method for property <tt>netweightOut</tt>.
     *
     * @return property value of netweightOut
     */
    public String getNetweightOut() {
        return netweightOut;
    }

    /**
     * Setter method for property <tt>netweightOut</tt>.
     *
     * @param netweightOut value to be assigned to property netweightOut
     */
    public void setNetweightOut(String netweightOut) {
        this.netweightOut = netweightOut;
    }

    /**
     * Getter method for property <tt>grossweightOut</tt>.
     *
     * @return property value of grossweightOut
     */
    public String getGrossweightOut() {
        return grossweightOut;
    }

    /**
     * Setter method for property <tt>grossweightOut</tt>.
     *
     * @param grossweightOut value to be assigned to property grossweightOut
     */
    public void setGrossweightOut(String grossweightOut) {
        this.grossweightOut = grossweightOut;
    }

    /**
     * Getter method for property <tt>normsLength</tt>.
     *
     * @return property value of normsLength
     */
    public String getNormsLength() {
        return normsLength;
    }

    /**
     * Setter method for property <tt>normsLength</tt>.
     *
     * @param normsLength value to be assigned to property normsLength
     */
    public void setNormsLength(String normsLength) {
        this.normsLength = normsLength;
    }

    /**
     * Getter method for property <tt>normsWidth</tt>.
     *
     * @return property value of normsWidth
     */
    public String getNormsWidth() {
        return normsWidth;
    }

    /**
     * Setter method for property <tt>normsWidth</tt>.
     *
     * @param normsWidth value to be assigned to property normsWidth
     */
    public void setNormsWidth(String normsWidth) {
        this.normsWidth = normsWidth;
    }

    /**
     * Getter method for property <tt>normsHeight</tt>.
     *
     * @return property value of normsHeight
     */
    public String getNormsHeight() {
        return normsHeight;
    }

    /**
     * Setter method for property <tt>normsHeight</tt>.
     *
     * @param normsHeight value to be assigned to property normsHeight
     */
    public void setNormsHeight(String normsHeight) {
        this.normsHeight = normsHeight;
    }

    /**
     * Getter method for property <tt>normsVolume</tt>.
     *
     * @return property value of normsVolume
     */
    public String getNormsVolume() {
        return normsVolume;
    }

    /**
     * Setter method for property <tt>normsVolume</tt>.
     *
     * @param normsVolume value to be assigned to property normsVolume
     */
    public void setNormsVolume(String normsVolume) {
        this.normsVolume = normsVolume;
    }
}