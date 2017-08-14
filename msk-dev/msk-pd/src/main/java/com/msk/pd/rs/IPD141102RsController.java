package com.msk.pd.rs;

import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141102RsParam;
import com.msk.pd.logic.IPD141102Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询产品等级
 * IPD141102RsController.
 * 
 * @author xhy
 */
@RestController
public class IPD141102RsController extends BaseRsController {

    @Autowired
    private IPD141102Logic ipd141102Logic;

    /**
     * 产品等级编码查询接口
     * 
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_grade",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<IPD141102RsParam>> findListGrade() {

        RsResponse<List<IPD141102RsParam>> rs = new RsResponse<List<IPD141102RsParam>>();
        // 查询所有产品等级信息
        List<IPD141102RsParam> res = this.ipd141102Logic.findListGrade();
        if (res.size() > IntDef.INT_ZERO && res != null) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询正常！");
            rs.setResult(res);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("产品等级没有查询到数据！");
        return rs;
    }
}
