package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141104RsParam;
import com.msk.pd.bean.IPD141104RsResult;
import com.msk.pd.logic.IPD141104Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 产品加工程度查询接口
 * IPD141104RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141104RsController extends BaseRsController {

    @Autowired
    private IPD141104Logic ipd141104Logic;

    /**
     * 产品加工程度查询接口
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_machining",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141104Validator")
    public RsResponse<List<IPD141104RsResult>> findMachining(@RequestBody RsRequest<IPD141104RsParam> param) {
        RsResponse<List<IPD141104RsResult>> rs = new RsResponse<List<IPD141104RsResult>>();
        // 查询所有产品加工程度
        List<IPD141104RsResult> result = this.ipd141104Logic.findListMaching(param.getParam());
        if (result.size() > IntDef.INT_ZERO && result != null) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("产品二级分类一览查询接口,查询正常！");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("产品二级分类一览查询接口,没有查询到数据！");
        return rs;
    }
}
