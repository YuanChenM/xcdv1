package com.msk.md.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.*;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.md.bean.DistrictAreaBean;
import com.msk.md.bean.IMD110001RsParam;
import com.msk.md.bean.IMD110001RsResult;
import com.msk.md.logic.DistrictAreaLogic;
import com.msk.md.utils.DistrictAreaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * IMD110001RsController
 *
 * @author yuan_chen
 */
@RestController
public class IMD110001RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IMD110001RsController.class);

    /**
     * 查询所有行政区域
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/md/allDistrictArea",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IMD110001RsResult> getAllDistrictArea(@RequestBody RsRequest<IMD110001RsParam> param) {
        logger.info("查询所有行政区域");
        RsResponse<IMD110001RsResult> rs = new RsResponse<IMD110001RsResult>();
        IMD110001RsResult result = new IMD110001RsResult();

        List<DistrictAreaBean> districtAreaBeans = new ArrayList<>();
        int type = param.getParam().getPrLgcsType();

        for (DistrictAreaBean districtArea : DistrictAreaLogic.getDistrictAreaBeans()) {
            if (type == districtArea.getPrLgcsType()) {
                districtAreaBeans.add(districtArea);
            }
        }
        result.setDistrictAreaBeans(districtAreaBeans);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询所有行政区域成功！");
        rs.setResult(result);
        return rs;
    }

    /**
     * 查询大区
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/md/getAreas",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IMD110001RsResult> getAreas(@RequestBody RsRequest<IMD110001RsParam> param) {

        RsResponse<IMD110001RsResult> rs = new RsResponse<>();
        IMD110001RsResult result = new IMD110001RsResult();

        List<MdArea> mdAreas = new ArrayList<>();
        if (StringUtil.isNullOrEmpty(param.getParam().getAreaCode())) {
            mdAreas = DistrictAreaUtils.getAreaList();
        } else {
            logger.info("查询指定大区");
            mdAreas.add(DistrictAreaUtils.getAreas().get(param.getParam().getAreaCode()));
        }

        result.setAreas(mdAreas);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询大区成功!");
        rs.setResult(result);
        return rs;
    }


    /**
     * 查询省
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/md/getProvinces",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IMD110001RsResult> getProvinces(@RequestBody RsRequest<IMD110001RsParam> param) {

        RsResponse<IMD110001RsResult> rs = new RsResponse<>();
        IMD110001RsResult result = new IMD110001RsResult();

        List<MdProvince> mdProvinces = new ArrayList<MdProvince>();
        if (StringUtil.isNullOrEmpty(param.getParam().getAreaCode())) {
            logger.info("查询所有大区中的省");
            mdProvinces = DistrictAreaUtils.getProvinceList();
        } else {
            logger.info("查询指定大区中的省");
            mdProvinces = DistrictAreaUtils.getProvinceList(param.getParam().getAreaCode());
        }
        result.setProvinces(mdProvinces);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询省成功!");
        rs.setResult(result);
        return rs;
    }


    /**
     * 查询物流区
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/md/getLogisticsAreas",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IMD110001RsResult> getLogisticsAreas(@RequestBody RsRequest<IMD110001RsParam> param) {

        RsResponse<IMD110001RsResult> rs = new RsResponse<>();
        IMD110001RsResult result = new IMD110001RsResult();

        List<MdLogisticsArea> mdLogisticsAreas = new ArrayList<>();
        if (StringUtil.isNullOrEmpty(param.getParam().getAreaCode())) {
            logger.info("查询所有大区中的物流区");
            mdLogisticsAreas = DistrictAreaUtils.getLogisticsAreaList();
        } else {
            logger.info("查询指定大区中的物流区");
            mdLogisticsAreas = DistrictAreaUtils.getLogisticsAreaList(param.getParam().getAreaCode());
        }
        result.setLogisticsAreas(mdLogisticsAreas);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询物流区成功!");
        rs.setResult(result);
        return rs;
    }

    /**
     * 查询城市
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/md/getCitys",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IMD110001RsResult> getCitys(@RequestBody RsRequest<IMD110001RsParam> param) {

        RsResponse<IMD110001RsResult> rs = new RsResponse<>();
        IMD110001RsResult result = new IMD110001RsResult();

        List<MdCity> mdCitys = new ArrayList<>();
        int prLgcsType = 0;
        String prLgcsCode = "";
        String cityCode = "";
        if(param.getParam() != null ) {
            prLgcsType = param.getParam().getPrLgcsType();
            if (!StringUtil.isNullOrEmpty(param.getParam().getPrLgcsCode())) {
                prLgcsCode = param.getParam().getPrLgcsCode();
            }
            if (!StringUtil.isNullOrEmpty(param.getParam().getCityCode())) {
                cityCode = param.getParam().getCityCode();
            }
        }
        if (StringUtil.isNullOrEmpty(prLgcsCode)) {
            logger.info("查询所有城市");
            for (String keyCode : DistrictAreaLogic.getCitys(prLgcsType).keySet()) {
                mdCitys.addAll(DistrictAreaLogic.getCitys(prLgcsType).get(keyCode).values());
            }
        } else {
            logger.info("查询指定省或物流区中的城市");
            if(DistrictAreaLogic.getCitys(prLgcsType).containsKey(prLgcsCode)){
                if(StringUtil.isNullOrEmpty(cityCode)){
                    mdCitys.addAll(DistrictAreaLogic.getCitys(prLgcsType).get(prLgcsCode).values());
                }else {
                    mdCitys.add(DistrictAreaLogic.getCitys(prLgcsType).get(prLgcsCode).get(cityCode));
                }
            }else{
                rs.setStatus(BusinessConst.RsStatus.FAIL);
                rs.setMessage("查询失败!");
                rs.setResult(result);
                return rs;
            }
        }
        result.setCitys(mdCitys);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询城市成功!");
        rs.setResult(result);
        return rs;
    }


    /**
     * 查询区
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/md/getDistricts",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IMD110001RsResult> getDistricts(@RequestBody RsRequest<IMD110001RsParam> param) {

        RsResponse<IMD110001RsResult> rs = new RsResponse<>();
        IMD110001RsResult result = new IMD110001RsResult();

        List<MdDistrict> mdDistricts = new ArrayList<>();
        int prLgcsType = 0;
        String cityCode = "";
        String districtCode = "";
        if(param.getParam() != null ) {
            prLgcsType = param.getParam().getPrLgcsType();
            if (!StringUtil.isNullOrEmpty(param.getParam().getCityCode())) {
                cityCode = param.getParam().getCityCode();
            }
            if (!StringUtil.isNullOrEmpty(param.getParam().getDistrictCode())) {
                districtCode = param.getParam().getDistrictCode();
            }
        }
        if (StringUtil.isNullOrEmpty(cityCode)) {
            logger.info("查询所有区信息");
                mdDistricts = DistrictAreaUtils.getDistrictList();
        } else {
            logger.info("查询指定省或物流区中的区");
            if(DistrictAreaLogic.getDistricts(prLgcsType).containsKey(cityCode)){
                if(StringUtil.isNullOrEmpty(districtCode)){
                    mdDistricts = DistrictAreaUtils.getDistrictList(cityCode);
                }else{
                    mdDistricts.add(DistrictAreaUtils.getDistricts(cityCode).get(districtCode));
                }
            }else{
                rs.setStatus(BusinessConst.RsStatus.FAIL);
                rs.setMessage("查询失败!");
                rs.setResult(result);
                return rs;
            }
        }
        result.setDistricts(mdDistricts);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询区信息成功!");
        rs.setResult(result);
        return rs;
    }
}
