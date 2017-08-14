package com.msk.so.rs;

import com.msk.common.consts.CapitalPoolConst;
import com.msk.core.annotation.Validator;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrder;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO251409RsReturnInfos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.so.bean.ISO251409RsParam;
import com.msk.so.bean.ISO251409RsResult;
import com.msk.so.logic.ISO251409Logic;

import java.util.List;

/**
 * ISO251404RsController.
 * 查询标准分销退货单
 *
 * @author pxg
 */
@RestController
public class ISO251409RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO251409RsController.class);
    @Autowired
    private ISO251409Logic ISO251409Logic;

    /**
     * 查询标准分销退货单
     *
     * @param request param
     * @return 结果
     * @author pxg
     */
    @RequestMapping(value = "/api/v1/so/sro/list", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ISO251409RsResult> modifyDbOrder(@RequestBody RsRequest<ISO251409RsParam> request) {
        logger.info("查询标准分销退货单");
        RsResponse<ISO251409RsResult> rs = new RsResponse<ISO251409RsResult>();
        ISO251409RsResult result = new ISO251409RsResult();
        ISO251409RsParam param = request.getParam();
        // Modify for bug#726 at 2016/06/02 by wangjianzhou Start.
        if (StringUtil.isEmpty(param.getBuyersId())) {
            throw new BusinessException("请输入买家ID");
        }
      /*  String roleType = param.getRoleType();
        if (!StringUtil.isEmpty(roleType)) {
            param.setRoleType(roleType.trim());
        } else {//
            throw new BusinessException("请输入角色类型");
        }*/
        //  默认  查询买家退货信息
        param.setRoleType(CapitalPoolConst.RoleType.ROLE_BIDDER);
        // Modify for bug#726 at 2016/06/02 by wangjianzhou end.
        List<ISO251409RsReturnInfos> dataList = ISO251409Logic.findPageList(param, result);
        result.setReturnInfos(dataList);
        rs.setResult(result);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("退货单列表查询成功");
        return rs;
    }
}
