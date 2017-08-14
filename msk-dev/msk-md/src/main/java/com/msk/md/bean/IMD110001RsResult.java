package com.msk.md.bean;

import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * IMD110001RsResult
 *
 * @author yuan_chen
 */
public class IMD110001RsResult extends RsPageResult {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 所有行政区域的列表 */
    private List<DistrictAreaBean> districtAreaBeans;
    /** 大区的列表 */
    private List<MdArea> areas;
    /** 省的列表 */
    private List<MdProvince> provinces;
    /** 物流区的列表 */
    private List<MdLogisticsArea> logisticsAreas;
    /** 城市的列表 */
    private List<MdCity> citys;
    /** 区的列表 */
    private List<MdDistrict> districts;

    /**
     * Getter method for property <tt>districtAreaBeans</tt>.
     *
     * @return property value of districtAreaBeans
     */
    public List<DistrictAreaBean> getDistrictAreaBeans() {
        return districtAreaBeans;
    }

    /**
     * Setter method for property <tt>districtAreaBeans</tt>.
     *
     * @param districtAreaBeans value to be assigned to property districtAreaBeans
     */
    public void setDistrictAreaBeans(List<DistrictAreaBean> districtAreaBeans) {
        this.districtAreaBeans = districtAreaBeans;
    }

    /**
     * Getter method for property <tt>areas</tt>.
     *
     * @return property value of areas
     */
    public List<MdArea> getAreas() {
        return areas;
    }

    /**
     * Setter method for property <tt>areas</tt>.
     *
     * @param areas value to be assigned to property areas
     */
    public void setAreas(List<MdArea> areas) {
        this.areas = areas;
    }

    /**
     * Getter method for property <tt>provinces</tt>.
     *
     * @return property value of provinces
     */
    public List<MdProvince> getProvinces() {
        return provinces;
    }

    /**
     * Setter method for property <tt>provinces</tt>.
     *
     * @param provinces value to be assigned to property provinces
     */
    public void setProvinces(List<MdProvince> provinces) {
        this.provinces = provinces;
    }

    /**
     * Getter method for property <tt>logisticsAreas</tt>.
     *
     * @return property value of logisticsAreas
     */
    public List<MdLogisticsArea> getLogisticsAreas() {
        return logisticsAreas;
    }

    /**
     * Setter method for property <tt>logisticsAreas</tt>.
     *
     * @param logisticsAreas value to be assigned to property logisticsAreas
     */
    public void setLogisticsAreas(List<MdLogisticsArea> logisticsAreas) {
        this.logisticsAreas = logisticsAreas;
    }

    /**
     * Getter method for property <tt>citys</tt>.
     *
     * @return property value of citys
     */
    public List<MdCity> getCitys() {
        return citys;
    }

    /**
     * Setter method for property <tt>citys</tt>.
     *
     * @param citys value to be assigned to property citys
     */
    public void setCitys(List<MdCity> citys) {
        this.citys = citys;
    }

    /**
     * Getter method for property <tt>districts</tt>.
     *
     * @return property value of districts
     */
    public List<MdDistrict> getDistricts() {
        return districts;
    }

    /**
     * Setter method for property <tt>districts</tt>.
     *
     * @param districts value to be assigned to property districts
     */
    public void setDistricts(List<MdDistrict> districts) {
        this.districts = districts;
    }
}