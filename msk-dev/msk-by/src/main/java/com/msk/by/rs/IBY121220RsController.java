package com.msk.by.rs;

import java.util.List;

import com.msk.by.bean.IBY121220Bean;
import com.msk.by.logic.IBY121220Logic;
import com.msk.core.bean.BaseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.ByResearchStdOrg;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;

/**
 * 买家产品调研用Controller.
 *
 * @author yuan_chen
 */
@RestController
public class IBY121220RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121220RsController.class);

    @Autowired
    private IBY121220Logic iby121220Logic;

    /**
     * 买家产品调研状态查询接口
     *
     * @param param param
     * @return 结果
     * @author yuan_chen
     */
    @RequestMapping(value = "/api/v1/by/research/findList",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<IBY121220Bean>> findBuyerResearch(@RequestBody RsRequest<IBY121220Bean> param) {
        logger.debug("调用买家产品调研状态查询接口");

        BaseParam baseParam = iby121220Logic.setParam(param.getParam());
        List<IBY121220Bean> iby121220Beans = iby121220Logic.findBuyerResearch(baseParam);
        RsResponse<List<IBY121220Bean>> rs = new RsResponse<>();
        rs.setResult(iby121220Beans);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("买家产品品种调研状态查询成功！");
        return rs;
    }

    /**
     * 买家产品新品种调研状态查询接口
     *
     * @param param param
     * @return 结果
     * @author yuan_chen
     */
    @RequestMapping(value = "/api/v1/by/research/findNewList",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<IBY121220Bean>> findBuyerResearchNew(@RequestBody RsRequest<IBY121220Bean> param) {
        logger.debug("调用买家产品新品种调研状态查询接口");

        BaseParam baseParam = iby121220Logic.setParam(param.getParam());
        List<IBY121220Bean> iby121220Beans = iby121220Logic.findBuyerResearchNew(baseParam);
        RsResponse<List<IBY121220Bean>> rs = new RsResponse<>();
        rs.setResult(iby121220Beans);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("买家产品新品种调研状态查询成功！");
        return rs;
    }
}
