package com.msk.md.utils;

import com.msk.core.bean.PageResult;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.md.logic.DistrictAreaLogic;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * DistrictAreaUtils
 *
 * @author yuan_chen
 **/
@Component("DistrictAreaUtils")
public class DistrictAreaUtils {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DistrictAreaUtils.class);

    /**
     * map转list
     *
     * @param param
     * @param <T>
     * @return
     */
    private static <T extends BaseEntity> List<T> mapToList(Map<String, Map<String, T>> param) {
        List<T> entities = new ArrayList<>();
        for (String keyCode : param.keySet()) {
            entities.addAll(param.get(keyCode).values());
        }
        return entities;
    }

    /**
     * map转list
     *
     * @param param
     * @param code
     * @param <T>
     * @return
     */
    private static <T extends BaseEntity> List<T> mapToList(Map<String, Map<String, T>> param, String code) {
        List<T> entities = new ArrayList<>();
        if (param.containsKey(code)) {
            entities.addAll(param.get(code).values());
        }
        return entities;
    }

    /**
     * 查询所有大区
     *
     * @return 所有大区的Map
     */
    public static Map<String, MdArea> getAreas() {
        logger.info("查询所有大区");
        return DistrictAreaLogic.getAreas();
    }

    /**
     * 查询所有大区
     *
     * @return 所有大区的列表
     */
    public static List<MdArea> getAreaList() {
        logger.info("查询所有大区");
        List<MdArea> mdAreas = new ArrayList<>();
        for (String keyCode : DistrictAreaLogic.getAreas().keySet()) {
            mdAreas.add(DistrictAreaLogic.getAreas().get(keyCode));
        }
        return mdAreas;
    }

    /**
     * 查询所有大区中的省
     *
     * @return 所有大区中的省的Map
     */
    public static Map<String, Map<String, MdProvince>> getProvinces() {
        logger.info("查询所有大区中的省");
        return DistrictAreaLogic.getProvinces();
    }

    /**
     * 查询指定大区中的省
     *
     * @param areaCode 大区编码
     * @return 指定大区中的省的Map
     */
    public static Map<String, MdProvince> getProvinces(String areaCode) {
        logger.info("查询指定大区中的省");
        if (StringUtil.isNullOrEmpty(areaCode)) {
            return new HashMap<>();
        }
        return DistrictAreaLogic.getProvinces().get(areaCode);
    }

    /**
     * 查询所有大区中的省
     *
     * @return 所有大区中的省的列表
     */
    public static List<MdProvince> getProvinceList() {
        logger.info("查询所有大区中的省");
        return mapToList(DistrictAreaLogic.getProvinces());
    }

    /**
     * 查询指定大区中的省
     *
     * @param areaCode 大区编码
     * @return 指定大区中的省的列表
     */
    public static List<MdProvince> getProvinceList(String areaCode) {
        logger.info("查询指定大区中的省");
        if (StringUtil.isNullOrEmpty(areaCode)) {
            return new ArrayList<>();
        }
        return mapToList(DistrictAreaLogic.getProvinces(), areaCode);
    }

    /**
     * 查询所有大区中的物流区
     *
     * @return 所有大区中的物流区的Map
     */
    public static Map<String, Map<String, MdLogisticsArea>> getLogisticsAreas() {
        logger.info("查询所有大区中的物流区");
        return DistrictAreaLogic.getLogisticsAreas();
    }

    /**
     * 查询指定大区中的物流区
     *
     * @param areaCode 大区编码
     * @return 指定大区中的物流区的Map
     */
    public static Map<String, MdLogisticsArea> getLogisticsAreas(String areaCode) {
        logger.info("查询指定大区中的物流区");
        if (StringUtil.isNullOrEmpty(areaCode)) {
            return new HashMap<>();
        }
        return DistrictAreaLogic.getLogisticsAreas().get(areaCode);
    }

    /**
     * 查询所有大区中的物流区
     *
     * @return 所有大区中的物流区的列表
     */
    public static List<MdLogisticsArea> getLogisticsAreaList() {
        logger.info("查询所有大区中的物流区");
        return mapToList(DistrictAreaLogic.getLogisticsAreas());
    }

    /**
     * 查询指定大区中的物流区
     *
     * @param areaCode 大区编码
     * @return 指定大区中的物流区的列表
     */
    public static List<MdLogisticsArea> getLogisticsAreaList(String areaCode) {
        logger.info("查询指定大区中的物流区");
        if (StringUtil.isNullOrEmpty(areaCode)) {
            return new ArrayList<>();
        }
        return mapToList(DistrictAreaLogic.getLogisticsAreas(), areaCode);
    }

    /**
     * 查询所有省中的城市(地区)
     *
     * @return 所有省中的城市(地区)的Map
     */
    public static Map<String, Map<String, MdCity>> getCitysInProvinces() {
        logger.info("查询所有省中的城市(地区)");
        return DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ZERO);
    }

    /**
     * 查询指定省中的城市(地区)
     *
     * @param provinceCode 省编码
     * @return 指定省中的城市(地区)的Map
     */
    public static Map<String, MdCity> getCitysInProvinces(String provinceCode) {
        logger.info("查询指定省中的城市(地区)");
        if (StringUtil.isNullOrEmpty(provinceCode)) {
            return new HashMap<>();
        }
        return DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ZERO).get(provinceCode);
    }

    /**
     * 查询所有省中的城市(地区)
     *
     * @return 所有省中的城市(地区)的列表
     */
    public static List<MdCity> getCityListInProvinces() {
        logger.info("查询所有省中的城市(地区)");
        return mapToList(DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ZERO));
    }

    /**
     * 查询指定省中的城市(地区)
     *
     * @param provinceCode 省编码
     * @return 指定省中的城市(地区)的列表
     */
    public static List<MdCity> getCityListInProvinces(String provinceCode) {
        logger.info("查询指定省中的城市(地区)");
        if (StringUtil.isNullOrEmpty(provinceCode)) {
            return new ArrayList<>();
        }
        return mapToList(DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ZERO), provinceCode);
    }

    /**
     * 查询所有物流区中的城市(地区)
     *
     * @return 所有物流区中的城市(地区)的Map
     */
    public static Map<String, Map<String, MdCity>> getCitysInLogisticsAreas() {
        logger.info("查询所有省中的城市(地区)");
        return DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ONE);
    }

    /**
     * 查询指定物流区中的城市(地区)
     *
     * @param logisticsAreaCode 物流区编码
     * @return 指定物流区中的城市(地区)的Map
     */
    public static Map<String, MdCity> getCitysInLogisticsAreas(String logisticsAreaCode) {
        logger.info("查询指定物流区中的城市(地区)");
        if (StringUtil.isNullOrEmpty(logisticsAreaCode)) {
            return new HashMap<>();
        }
        if (!DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ONE).containsKey(logisticsAreaCode)) {
            return new HashMap<>();
        }
        return DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ONE).get(logisticsAreaCode);
    }

    /**
     * 查询所有物流区中的城市(地区)
     *
     * @return 所有物流区中的城市(地区)的列表
     */
    public static List<MdCity> getCityListInLogisticsAreas() {
        logger.info("查询所有物流区中的城市(地区)");
        return mapToList(DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ONE));
    }

    /**
     * 查询指定物流区中的城市(地区)
     *
     * @param logisticsAreaCode 物流区编码
     * @return 指定物流区中的城市(地区)的列表
     */
    public static List<MdCity> getCityListInLogisticsAreas(String logisticsAreaCode) {
        logger.info("查询指定物流区中的城市(地区)");
        if (StringUtil.isNullOrEmpty(logisticsAreaCode)) {
            return new ArrayList<>();
        }
        return mapToList(DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ONE), logisticsAreaCode);
    }

    /**
     * 查询所有城市(地区)中的区(县)
     *
     * @return 所有城市(地区)中的区(县)的Map
     */
    public static Map<String, Map<String, MdDistrict>> getDistricts() {
        logger.info("查询所有城市(地区)中的区(县)");
        return DistrictAreaLogic.getDistricts(NumberConst.IntDef.INT_ZERO);
    }

    /**
     * 查询指定城市(地区)中的区(县)
     *
     * @param cityCode 城市(地区)编码
     * @return 指定城市(地区)中的区(县)的Map
     */
    public static Map<String, MdDistrict> getDistricts(String cityCode) {
        logger.info("查询指定城市(地区)中的区(县)");
        if (StringUtil.isNullOrEmpty(cityCode)) {
            return new HashMap<>();
        }
        if (!DistrictAreaLogic.getDistricts(NumberConst.IntDef.INT_ZERO).containsKey(cityCode)) {
            return new HashMap<>();
        }
        return DistrictAreaLogic.getDistricts(NumberConst.IntDef.INT_ZERO).get(cityCode);
    }

    /**
     * 查询所有城市(地区)中的区(县)
     *
     * @return 所有城市(地区)中的区(县)的列表
     */
    public static List<MdDistrict> getDistrictList() {
        logger.info("查询所有城市(地区)中的区(县)");
        return mapToList(DistrictAreaLogic.getDistricts(NumberConst.IntDef.INT_ZERO));
    }

    /**
     * 查询指定城市(地区)中的区(县)
     *
     * @param cityCode 城市(地区)编码
     * @return 指定城市(地区)中的区(县)的列表
     */
    public static List<MdDistrict> getDistrictList(String cityCode) {
        logger.info("查询指定城市(地区)中的区(县)");
        if (StringUtil.isNullOrEmpty(cityCode)) {
            return new ArrayList<>();
        }
        return mapToList(DistrictAreaLogic.getDistricts(NumberConst.IntDef.INT_ZERO), cityCode);
    }


    /**
     * 取得大区Map(一级行政区域Map)
     *
     * @return 大区Map(大区编码, 大区名称)
     */
    public static Map<String, String> getAreaMap() {
        return DistrictAreaLogic.getAreaMap();
    }

    /**
     * 取得省和物流区Map(二级行政区域Map)
     *
     * @return 省和物流区Map(大区编码, 大区名称)
     */
    public static Map<String, String> getPrLgcsMap() {
        return DistrictAreaLogic.getPrLgcsMap();
    }

    /**
     * 取得城市Map(三级行政区域Map)
     *
     * @return 城市Map(城市编码, 城市名称)
     */
    public static Map<String, String> getCityMap() {
        return DistrictAreaLogic.getCityMap();
    }

    /**
     * 通过大区编码取得大区名称
     *
     * @return 大区名称
     */
    public static String getAreaName(String areaCode) {
        return DistrictAreaLogic.getAreaMap().get(areaCode);
    }

    /**
     * 通过省编码取得省名称
     *
     * @return 省名称
     */
    public static String getProvinceName(String provinceCode) {
        if(DistrictAreaLogic.getPrLgcsMap().containsKey(provinceCode)){
            return DistrictAreaLogic.getPrLgcsMap().get(provinceCode);
        }
        return StringConst.EMPTY;
    }

    /**
     * 通过物流区编码取得物流区名称
     *
     * @return 物流区名称
     */
    public static String getLogisticsAreaName(String logisticsAreaCode) {
        if(DistrictAreaLogic.getPrLgcsMap().containsKey(logisticsAreaCode)){
            return DistrictAreaLogic.getPrLgcsMap().get(logisticsAreaCode);
        }
        return StringConst.EMPTY;
    }

    /**
     * 通过城市编码取得城市名称
     *
     * @return 城市名称
     */
    public static String getCityName(String cityCode) {
        if(DistrictAreaLogic.getCityMap().containsKey(cityCode)){
            return DistrictAreaLogic.getCityMap().get(cityCode);
        }
        return StringConst.EMPTY;
    }

    /**
     * 通过城市编码以及区(县)编码取得区(县)名称
     *
     * @return 区(县)名称
     */
    public static String getDistrictName(String cityCode, String districtCode) {
        if(DistrictAreaUtils.getDistricts(cityCode)!=null){
            if(DistrictAreaUtils.getDistricts(cityCode).containsKey(districtCode)){
                return DistrictAreaUtils.getDistricts(cityCode).get(districtCode).getDistrictName();
            }
        }
        return StringConst.EMPTY;
    }

    /**
     * 通过城市名称取得城市编码
     *
     * @return 区(县)名称
     */
    public static String getCityCodeByName(String cityName) {
        String left2CityName = StringConst.EMPTY;
        String left3CityName = StringConst.EMPTY;
        if (cityName.length() > NumberConst.IntDef.INT_TWO) {
            left2CityName = cityName.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_TWO);
            left3CityName = cityName.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_THREE);
        }
        for (MdCity mdCity : DistrictAreaUtils.getCityListInLogisticsAreas()) {
            String shortCityName = mdCity.getCityName();
            if (mdCity.getCityName().length() > NumberConst.IntDef.INT_TWO) {
                shortCityName = mdCity.getCityName().substring(NumberConst.IntDef.INT_ZERO,
                        NumberConst.IntDef.INT_THREE);
            }
            if (shortCityName.equals(cityName)) {
                return mdCity.getCityCode();
            } else if (shortCityName.equals(left3CityName)) {
                return mdCity.getCityCode();
            } else if (shortCityName.equals(left2CityName)) {
                return mdCity.getCityCode();
            }
        }
        return StringConst.EMPTY;
    }

    /**
     * 通过城市编码及区县名取得区县编码
     *
     * @return 区(县)名称
     */
    public static String getDistrictCodeByName(String cityCode, String districtName) {
        List<MdDistrict> districts = DistrictAreaUtils.getDistrictList(cityCode);
        for (MdDistrict mdDistrict : districts) {
            if (mdDistrict.getDistrictName().equals(districtName)) {
                return mdDistrict.getDistrictCode();
            }
        }
        return StringConst.EMPTY;
    }

    /**
     * 通过城市编码取得其物流区编码
     *
     * @return 物流区编码
     */
    public static String getLogisticsAreaCodeByCityCode(String cityCode) {
        Map<String, Map<String, MdCity>> citys = DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ONE);
        Map<String, MdCity> cityMap;
        for (String keyCode : citys.keySet()) {
            cityMap = citys.get(keyCode);
            if (cityMap.containsKey(cityCode)) {
                return keyCode;
            }
        }
        return StringConst.EMPTY;
    }

    /**
     * 通过城市编码取得其省编码
     *
     * @return 省编码
     */
    public static String getProvinceCodeByCityCode(String cityCode) {
        Map<String, Map<String, MdCity>> citys = DistrictAreaLogic.getCitys(NumberConst.IntDef.INT_ZERO);
        Map<String, MdCity> cityMap;
        for (String keyCode : citys.keySet()) {
            cityMap = citys.get(keyCode);
            if (cityMap.containsKey(cityCode)) {
                return keyCode;
            }
        }
        return StringConst.EMPTY;
    }
}
