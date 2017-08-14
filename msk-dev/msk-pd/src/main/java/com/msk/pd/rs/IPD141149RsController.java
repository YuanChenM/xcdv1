package com.msk.pd.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141146RsParam;
import com.msk.pd.bean.IPD141146RsResult;
import com.msk.pd.bean.IPD141149Result;
import com.msk.pd.logic.IPD141148Logic;
import com.msk.pd.logic.IPD141149Logic;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询轮播图和轮播高度设置
 * Created by ren_qiang on 2016/11/03.
 */
@RestController
public class IPD141149RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IPD141146RsController.class);

    @Autowired
    private IPD141149Logic ipd141149Logic;
    /**
     * 查询轮播图和轮播高度设置
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/bspp/mainCarousel/_get",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IPD141149Result> queryScrollImgInfo() {
        logger.info("查询轮播图和轮播高度设置");
        RsResponse<IPD141149Result> rs = new RsResponse<IPD141149Result>();
        IPD141149Result ipd141149Result = ipd141149Logic.queryScrollImgInfo();
        if (ipd141149Result == null) {
            ipd141149Result = new IPD141149Result();
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setResult(ipd141149Result);
        rs.setMessage("查询数据正常！");
        return rs;
    }

}
