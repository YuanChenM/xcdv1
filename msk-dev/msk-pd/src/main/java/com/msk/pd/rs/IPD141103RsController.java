package com.msk.pd.rs;

import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141103RsParam;
import com.msk.pd.logic.IPD141103Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 销售状态一览查询接口
 * IPD141103RsController.
 * 
 * @author xhy
 */
@RestController
public class IPD141103RsController extends BaseRsController {

    @Autowired
    private IPD141103Logic ipd141103Logic;

    /**
     * 查询销售订单状态
     * 
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_sale_status",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<IPD141103RsParam>> findListSaleStatus() {
        RsResponse<List<IPD141103RsParam>> rs = new RsResponse<List<IPD141103RsParam>>();
        // 查询所有销售状态信息

        List<IPD141103RsParam> result = ipd141103Logic.findListSaleStatus();
        if (result.size() > IntDef.INT_ZERO && result != null) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询正常！");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("销售状态没有查询到数据！");
        return rs;
    }
}
