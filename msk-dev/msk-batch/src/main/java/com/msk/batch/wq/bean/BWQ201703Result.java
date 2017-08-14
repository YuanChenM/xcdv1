package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
@JsonIgnoreProperties(value={"fax","vlgcsAreaId","vlgcsAreaCode","vprovinceId","vprovinceCode","vcityId","vcityCode","vdistrictId","vdistrictCode","vlgcsAreaName","vprovinceName","vcityName","vdistrictName","crtId","crtTime","updId","updTime","delFlg","actId","actTime","tblId","houseCode","houseCateGory"})
public class BWQ201703Result extends BWQ201702Result{
    /**传真号**/
    private String fax;
    /**物流区id**/
    private String  vlgcsAreaId;
    /**物流区编码**/
    private String  vlgcsAreaCode;
    /**省id**/
    private String vprovinceId;
    /**省编码**/
    private String vprovinceCode;
    /**市区Id**/
    private String vcityId;
    /**市区编码**/
    private String vcityCode;
    /**地区id**/
    private String vdistrictId;
    /**地区编码**/
    private String vdistrictCode;
    /**物流区名称**/
    private String vlgcsAreaName;
    /**省名称**/
    private String vprovinceName;
    /**市区，名称**/
    private String vcityName;
    /**地区名称**/
    private String vdistrictName;
    /**管家类型**/
    private String houseType;

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getVlgcsAreaCode() {
        return vlgcsAreaCode;
    }

    public void setVlgcsAreaCode(String vlgcsAreaCode) {
        this.vlgcsAreaCode = vlgcsAreaCode;
    }

    public String getVprovinceCode() {
        return vprovinceCode;
    }

    public void setVprovinceCode(String vprovinceCode) {
        this.vprovinceCode = vprovinceCode;
    }

    public String getVcityCode() {
        return vcityCode;
    }

    public void setVcityCode(String vcityCode) {
        this.vcityCode = vcityCode;
    }

    public String getVdistrictCode() {
        return vdistrictCode;
    }

    public void setVdistrictCode(String vdistrictCode) {
        this.vdistrictCode = vdistrictCode;
    }

    public String getVlgcsAreaName() {
        return vlgcsAreaName;
    }

    public void setVlgcsAreaName(String vlgcsAreaName) {
        this.vlgcsAreaName = vlgcsAreaName;
    }

    public String getVprovinceName() {
        return vprovinceName;
    }

    public void setVprovinceName(String vprovinceName) {
        this.vprovinceName = vprovinceName;
    }

    public String getVcityName() {
        return vcityName;
    }

    public void setVcityName(String vcityName) {
        this.vcityName = vcityName;
    }

    public String getVdistrictName() {
        return vdistrictName;
    }

    public void setVdistrictName(String vdistrictName) {
        this.vdistrictName = vdistrictName;
    }

    public String getVlgcsAreaId() {
        return vlgcsAreaId;
    }

    public void setVlgcsAreaId(String vlgcsAreaId) {
        this.vlgcsAreaId = vlgcsAreaId;
    }

    public String getVprovinceId() {
        return vprovinceId;
    }

    public void setVprovinceId(String vprovinceId) {
        this.vprovinceId = vprovinceId;
    }

    public String getVcityId() {
        return vcityId;
    }

    public void setVcityId(String vcityId) {
        this.vcityId = vcityId;
    }

    public String getVdistrictId() {
        return vdistrictId;
    }

    public void setVdistrictId(String vdistrictId) {
        this.vdistrictId = vdistrictId;
    }
}
