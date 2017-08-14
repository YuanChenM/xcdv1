package com.msk.by.rs;

import com.msk.by.bean.IBY121102RsParam;
import com.msk.by.logic.IBY121102Logic;
import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.*;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.md.utils.DistrictAreaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * IBY121101RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121102RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121102RsController.class);

    @Autowired
    private IBY121102Logic iby121102Logic;

    @Autowired
    private DistrictAreaUtils districtAreaUtils;
    /**
     * 产品类别获取
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/common/pdClass",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<PdClasses>> pdClass(@RequestBody RsRequest<PdClasses> param){
        RsResponse<List<PdClasses>> rs = new RsResponse<>();
        List<PdClasses> pdClasses = iby121102Logic.pdClass(param.getParam());
        if(!CollectionUtils.isEmpty(pdClasses)){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("产品类别获取成功");
            rs.setResult(pdClasses);
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("产品类别没有记录");
        }
        return rs;
    }
    /**
     * 产品二级分类获取
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/common/pdMachining",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<PdMachining>> pdMachining(@RequestBody RsRequest<PdMachining> param){
        RsResponse<List<PdMachining>> rs = new RsResponse<>();
        List<PdMachining> pdMachining = iby121102Logic.pdMachining(param.getParam());
        if(!CollectionUtils.isEmpty(pdMachining)){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("产品二级分类获取成功");
            rs.setResult(pdMachining);
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("产品二级分类没有记录");
        }
        return rs;
    }
    /**
     * 产品品种获取
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/common/pdBreed",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<PdBreed>> pdBreed(@RequestBody RsRequest<PdBreed> param){
        RsResponse<List<PdBreed>> rs = new RsResponse<>();
        List<PdBreed> pdBreeds = iby121102Logic.pdBreed(param.getParam());
        if(!CollectionUtils.isEmpty(pdBreeds)){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("产品品种获取成功");
            rs.setResult(pdBreeds);
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("产品品种没有记录");
        }
        return rs;
    }
    /**
     * 产品特征获取
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/common/pdFeature",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<PdFeature>> pdFeature(@RequestBody RsRequest<PdFeature> param){
        RsResponse<List<PdFeature>> rs = new RsResponse<>();
        List<PdFeature> pdFeatures = iby121102Logic.pdFeature(param.getParam());
        if(!CollectionUtils.isEmpty(pdFeatures)){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("产品特征获取成功");
            rs.setResult(pdFeatures);
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("产品特征没有记录");
        }
        return rs;
    }
    /**
     * 产品规格获取
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/common/pdNormsStd",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<PdNormsStd>> pdNormsStd(@RequestBody RsRequest<PdWeight> param){
        RsResponse<List<PdNormsStd>> rs = new RsResponse<>();
        List<PdNormsStd> pdNormsStds = iby121102Logic.pdNormsStd(param.getParam());
        if(!CollectionUtils.isEmpty(pdNormsStds)){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("产品规格获取成功");
            rs.setResult(pdNormsStds);
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("产品规格没有记录");
        }
        return rs;
    }
    /**
     * 产品净重获取
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/common/pdWeight",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<PdWeight>> pdWeight(@RequestBody RsRequest<PdWeight> param){
        RsResponse<List<PdWeight>> rs = new RsResponse<>();
        List<PdWeight> pdWeight = iby121102Logic.pdWeight(param.getParam());
        if(!CollectionUtils.isEmpty(pdWeight)){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("产品净重获取成功");
            rs.setResult(pdWeight);
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("产品净重没有记录");
        }
        return rs;
    }

    /**
     * 根据定位获取当前位置
     * 然后获取当前位置属于的物流区
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/common/localPosition",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<IBY121102RsParam> localPosition(@RequestBody RsRequest<IBY121102RsParam> param){
        RsResponse<IBY121102RsParam> rs = new RsResponse<>();
        //通过城市名称获取城市编码
        String cityCode = districtAreaUtils.getCityCodeByName(param.getParam().getCityName());
        //通过城市名称获取物流区编码
        String lgcsAreaCode = districtAreaUtils.getLogisticsAreaCodeByCityCode(cityCode);
        //通过城市编码和区县名称获取区县编码
        String districtCode = districtAreaUtils.getDistrictCodeByName(cityCode,param.getParam().getDistrictName());
        IBY121102RsParam position = new IBY121102RsParam();
        position.setLgcsAreaCode(lgcsAreaCode);
        position.setCityCode(cityCode);
        position.setDistrictCode(districtCode);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setResult(position);

        return rs;
    }
}
