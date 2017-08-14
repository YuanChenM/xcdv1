package com.msk.pd.rs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.core.web.consts.BusinessConst;
import com.msk.core.web.base.*;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.pd.bean.IPD141101RsParam;
import com.msk.pd.logic.IPD141101Logic;

/**
 * 产品分类一览查询接口
 * IPD141101RsController.
 * 
 * @author xhy
 */
@RestController
public class IPD141101RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IPD141101RsController.class);

    @Autowired
    private IPD141101Logic ipd141101Logic;

    /**
     * 产品分类一览查询接口
     * 
     * @return 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_classes",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<IPD141101RsParam>> createClasses() {
        // 查询所有产品类别信息
        RsResponse<List<IPD141101RsParam>> rs = new RsResponse<List<IPD141101RsParam>>();
        List<IPD141101RsParam> result = ipd141101Logic.findListPd();
        if (result.size() > IntDef.INT_ZERO && result != null) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("数据查询成功!");
            rs.setResult(result);
            logger.info("数据查询成功!");
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("产品类别没有查询到数据！");
        return rs;
    }

}
