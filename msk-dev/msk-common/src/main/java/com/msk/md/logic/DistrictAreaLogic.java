package com.msk.md.logic;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.msk.core.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.md.bean.DistrictAreaBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * DistrictAreaLogic
 *
 * @author yuan_chen
 **/
@Service("districtAreaLogic")
public class DistrictAreaLogic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DistrictAreaLogic.class);

    /**
     * 所有行政区域的列表(服务启动时,加载在内存中的数据)
     */
    private static List<DistrictAreaBean> districtAreaBeans;

    /**
     * Getter method for property <tt>districtAreaBeans</tt>.
     *
     * @return property value of districtAreaBeans
     */
    public static List<DistrictAreaBean> getDistrictAreaBeans() {
        return districtAreaBeans;
    }

    /**
     * Setter method for property <tt>districtAreaBeans</tt>.
     *
     * @param districtAreaBeans value to be assigned to property districtAreaBeans
     */
    public static void setDistrictAreaBeans(List<DistrictAreaBean> districtAreaBeans) {
        DistrictAreaLogic.districtAreaBeans = districtAreaBeans;
    }

    /**
     * 所有大区Map
     */
    private static Map<String, String> areaMap;
    /**
     * 所有省和物流区的Map
     */
    private static Map<String, String> prLgcsMap;
    /**
     * 所有城市的Map
     */
    private static Map<String, String> cityMap;

    private static void setAllMap(){
        //初始化大区Map
        areaMap = new LinkedHashMap<>();
        //初始化省和物流区Map
        prLgcsMap = new LinkedHashMap<>();
        //初始化城市Map
        cityMap = new LinkedHashMap<>();

        for (DistrictAreaBean bean : DistrictAreaLogic.districtAreaBeans) {
            if (!areaMap.containsKey(bean.getAreaCode())) {
                areaMap.put(bean.getAreaCode(), bean.getAreaName());
            }
            if (!prLgcsMap.containsKey(bean.getPrLgcsCode())) {
                prLgcsMap.put(bean.getPrLgcsCode(), bean.getPrLgcsName());
            }
            if (!cityMap.containsKey(bean.getCityCode())) {
                cityMap.put(bean.getCityCode(), bean.getCityName());
            }
        }
    }

    /**
     * Getter method for property <tt>areas</tt>.
     *
     * @return property value of areas
     */
    public static Map<String, String> getAreaMap() {
        if (areaMap == null || areaMap.size() == NumberConst.IntDef.INT_ZERO) {
            setAllMap();
        }
        return areaMap;
    }

    /**
     * Getter method for property <tt>prLgcsMap</tt>.
     *
     * @return property value of prLgcsMap
     */
    public static Map<String, String> getPrLgcsMap() {
        if (prLgcsMap == null || prLgcsMap.size() == NumberConst.IntDef.INT_ZERO) {
            setAllMap();
        }
        return prLgcsMap;
    }

    /**
     * Getter method for property <tt>cityMap</tt>.
     *
     * @return property value of cityMap
     */
    public static Map<String, String> getCityMap() {
        if (cityMap == null || cityMap.size() == NumberConst.IntDef.INT_ZERO) {
            setAllMap();
        }
        return cityMap;
    }


    /**
     * 所有大区信息
     */
    private static Map<String, MdArea> areas;

    /**
     * Getter method for property <tt>areas</tt>.
     *
     * @return property value of areas
     */
    public static Map<String, MdArea> getAreas() {
        if (areas == null || areas.size() == NumberConst.IntDef.INT_ZERO) {
            areas = new LinkedHashMap<>();
            for (DistrictAreaBean bean : DistrictAreaLogic.districtAreaBeans) {
                if (!areas.containsKey(bean.getAreaCode())) {
                    MdArea mdArea = new MdArea();
                    mdArea.setAreaCode(bean.getAreaCode());
                    mdArea.setAreaName(bean.getAreaName());
                    areas.put(bean.getAreaCode(), mdArea);
                }
            }
        }
        return areas;
    }

    /**
     * 所有省信息
     */
    private static Map<String, Map<String, MdProvince>> provinces;

    /**
     * Getter method for property <tt>provinces</tt>.
     *
     * @return property value of provinces
     */
    public static Map<String, Map<String, MdProvince>> getProvinces() {
        if (provinces == null || provinces.size() == NumberConst.IntDef.INT_ZERO) {
            provinces = new LinkedHashMap<>();
            for (DistrictAreaBean bean : DistrictAreaLogic.districtAreaBeans) {
                if (bean.getPrLgcsType() == NumberConst.IntDef.INT_ZERO) {
                    MdProvince mdProvince = new MdProvince();
                    mdProvince.setProvinceCode(bean.getPrLgcsCode());
                    mdProvince.setProvinceName(bean.getPrLgcsName());
                    if (provinces.containsKey(bean.getAreaCode())) {
                        if (!provinces.get(bean.getAreaCode()).containsKey(bean.getPrLgcsCode())) {
                            provinces.get(bean.getAreaCode()).put(bean.getPrLgcsCode(), mdProvince);
                        }
                    } else {
                        Map<String, MdProvince> mdProvinces = new LinkedHashMap<>();
                        mdProvinces.put(bean.getPrLgcsCode(), mdProvince);
                        provinces.put(bean.getAreaCode(), mdProvinces);
                    }
                }
            }
        }
        return provinces;
    }

    /**
     * 所有物流区信息
     */
    private static Map<String, Map<String, MdLogisticsArea>> logisticsAreas;

    /**
     * Getter method for property <tt>logisticsAreas</tt>.
     *
     * @return property value of logisticsAreas
     */
    public static Map<String, Map<String, MdLogisticsArea>> getLogisticsAreas() {
        if (logisticsAreas == null || logisticsAreas.size() == NumberConst.IntDef.INT_ZERO) {
            logisticsAreas = new LinkedHashMap<>();
            for (DistrictAreaBean bean : DistrictAreaLogic.districtAreaBeans) {
                if (bean.getPrLgcsType() == NumberConst.IntDef.INT_ONE) {
                    MdLogisticsArea mdLogisticsArea = new MdLogisticsArea();
                    mdLogisticsArea.setLgcsAreaCode(bean.getPrLgcsCode());
                    mdLogisticsArea.setLgcsAreaName(bean.getPrLgcsName());
                    if (logisticsAreas.containsKey(bean.getAreaCode())) {
                        if (!logisticsAreas.get(bean.getAreaCode()).containsKey(bean.getPrLgcsCode())) {
                            logisticsAreas.get(bean.getAreaCode()).put(bean.getPrLgcsCode(), mdLogisticsArea);
                        }
                    } else {
                        Map<String, MdLogisticsArea> mdLogisticsAreas = new LinkedHashMap<>();
                        mdLogisticsAreas.put(bean.getPrLgcsCode(), mdLogisticsArea);
                        logisticsAreas.put(bean.getAreaCode(), mdLogisticsAreas);
                    }
                }
            }
        }
        return logisticsAreas;
    }

    /**
     * 所有物流区的城市地区信息
     */
    private static Map<String, Map<String, MdCity>> lgcsCitys;
    /**
     * 所有省的城市地区信息
     */
    private static Map<String, Map<String, MdCity>> prCitys;

    /**
     * Getter method for property <tt>citys</tt>.
     *
     * @param prLgcsType prLgcsType
     * @return property value of citys
     */
    public static Map<String, Map<String, MdCity>> getCitys(int prLgcsType) {
        Map<String, Map<String, MdCity>> citys;
        if(prLgcsType == NumberConst.IntDef.INT_ZERO){
            citys = prCitys;
        }else {
            citys = lgcsCitys;
        }

        if (citys == null || citys.size() == NumberConst.IntDef.INT_ZERO) {
            citys = new LinkedHashMap<>();
            for (DistrictAreaBean bean : DistrictAreaLogic.districtAreaBeans) {

                MdCity mdCity = new MdCity();
                mdCity.setCityCode(bean.getCityCode());
                mdCity.setCityName(bean.getCityName());

                if (bean.getPrLgcsType() == prLgcsType) {
                    if (citys.containsKey(bean.getPrLgcsCode())) {
                        if (!citys.get(bean.getPrLgcsCode()).containsKey(bean.getCityCode())) {
                            citys.get(bean.getPrLgcsCode()).put(bean.getCityCode(), mdCity);
                        }
                    } else {
                        Map<String, MdCity> mdCitys = new LinkedHashMap<>();
                        mdCitys.put(bean.getCityCode(), mdCity);
                        citys.put(bean.getPrLgcsCode(), mdCitys);
                    }
                }
            }
        }
        return citys;
    }

    /**
     * 所有物流区的城市地区的区县信息
     */
    private static Map<String, Map<String, MdDistrict>> lgcsDistricts;
    /**
     * 所有省的城市地区的区县信息
     */
    private static Map<String, Map<String, MdDistrict>> prDistricts;

    /**
     * Getter method for property <tt>districts</tt>.
     *
     * @return property value of districts
     */
    public static Map<String, Map<String, MdDistrict>> getDistricts(int prLgcsType) {
        Map<String, Map<String, MdDistrict>> districts;
        if(prLgcsType == NumberConst.IntDef.INT_ZERO){
            districts = prDistricts;
        }else {
            districts = lgcsDistricts;
        }

        if (districts == null || districts.size() == NumberConst.IntDef.INT_ZERO) {
            districts = new LinkedHashMap<>();
            for (DistrictAreaBean bean : DistrictAreaLogic.districtAreaBeans) {

                MdDistrict mdDistrict = new MdDistrict();
                mdDistrict.setDistrictCode(bean.getDistrictCode());
                mdDistrict.setDistrictName(bean.getDistrictName());

                if (bean.getPrLgcsType() == prLgcsType) {
                    if (districts.containsKey(bean.getCityCode())) {
                        if (!districts.get(bean.getCityCode()).containsKey(bean.getDistrictCode())) {
                            districts.get(bean.getCityCode()).put(bean.getDistrictCode(), mdDistrict);
                        }
                    } else {
                        Map<String, MdDistrict> mdDistricts = new LinkedHashMap<>();
                        mdDistricts.put(bean.getDistrictCode(), mdDistrict);
                        districts.put(bean.getCityCode(), mdDistricts);
                    }
                }
            }
        }
        return districts;
    }

    /**
     * (non-Javadoc)
     *
     * @see com.msk.core.base.BaseLogic#setBaseDao(com.msk.core.base.BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 取得view中所有数据
     *
     * @return
     */
    @Transactional
    public List<DistrictAreaBean> findList() {
        return super.findList(new BaseParam());
    }
}
