package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.PdAppImg;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141149Result;
import com.msk.pd.bean.IPD141150Bean;
import com.msk.pd.bean.IPD141150Param;
import com.msk.pd.bean.IPD141150Result;
import com.msk.pd.logic.IPD141149Logic;
import com.msk.pd.logic.IPD141150Logic;
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
 * 产品详情轮播图片接口
 * Created by ren_qiang on 2016/11/03.
 */
@RestController
public class IPD141150RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IPD141146RsController.class);

    @Autowired
    private IPD141150Logic ipd141150Logic;
    /**
     * 查询产品详情轮播图片
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/bspp/pdCarousel/_get",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141150Validator")
    public RsResponse<IPD141150Result> queryScrollImgByPdCode(@RequestBody RsRequest<IPD141150Param> param) {
        logger.info("产品详情轮播图片接口");
        RsResponse<IPD141150Result> rs = new RsResponse<IPD141150Result>();

        IPD141150Result result = new IPD141150Result();
        List<IPD141150Bean> list = ipd141150Logic.queryScrollImgByPdCode(param.getParam());
        if(!CollectionUtils.isEmpty(list)){
            result.setPdScrollImgList(list);
        }
        rs.setMessage("查询数据正常！");
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setResult(result);
        return rs;
    }

}
