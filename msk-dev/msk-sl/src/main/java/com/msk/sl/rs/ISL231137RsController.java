package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEpAgentAuth;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231137RsBean;
import com.msk.sl.bean.ISL231137RsResult;
import com.msk.sl.logic.ISL231106Logic;
import com.msk.sl.bean.ISL231137RsParam;
import com.msk.sl.logic.ISL231137Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * ISL231106RsController.
 * 查询卖家生产商
 *
 * @author gyh
 */
@RestController
public class ISL231137RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231137RsController.class);

    @Autowired
    private ISL231137Logic isl231137Logic;

    /**
     * 查询卖家生产商
     *
     * @param param param
     * @return 结果
     * @author gyh
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slProducer/search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231137Validator")
    public RsResponse<ISL231137RsResult> search(@RequestBody RsRequest<ISL231137RsParam> param) {
        logger.info("查询卖家生产商");
        RsResponse<ISL231137RsResult> rs = new RsResponse<ISL231137RsResult>();
        ISL231137RsResult bean=new ISL231137RsResult();
        bean.setSlEpAuthList(this.isl231137Logic.search(param.getParam()));
        rs.setResult(bean);
        rs.setMessage("查询卖家生产商成功");
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        return rs;
    }
}
