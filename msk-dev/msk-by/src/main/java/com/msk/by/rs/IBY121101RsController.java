package com.msk.by.rs;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.CommConstant;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * IBY121101RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121101RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121101RsController.class);

    @Autowired
    private CommonLogic commonLogic;

    /**
     * master数据取得
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/by/common/master",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<CommConstant>> commMaster(@RequestBody RsRequest<CommConstant> param){
        RsResponse<List<CommConstant>> rs = new RsResponse<>();
        List<CommConstant> commList = commonLogic.findConstantList(param.getParam().getConstantType());
        if(!CollectionUtils.isEmpty(commList)){
            rs.setMessage(" master数据取得成功");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setResult(commList);
        }else{
            rs.setMessage(" master数据取得失败");
            rs.setStatus(BusinessConst.RsStatus.FAIL);
        }
        return rs;
    }
}
