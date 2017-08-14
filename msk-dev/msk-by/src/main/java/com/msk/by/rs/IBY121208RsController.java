package com.msk.by.rs;

import com.msk.by.logic.IBY121208Logic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByBuyerRecAddr;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * IBY121208RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121208RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121208RsController.class);

    @Autowired
    private IBY121208Logic iby121208Logic;

    /**
     * 买家收货地址更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/receiveAddr/update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByBuyerRecAddr>> buyerReceiveAddrUpdate(@RequestBody RsRequest<List<ByBuyerRecAddr>> param) {
        RsResponse<List<ByBuyerRecAddr>> rs = new RsResponse<>();
        List<ByBuyerRecAddr> recAddrList = new ArrayList<>();
        int resultCount = iby121208Logic.buyerReceiveAddrModify(param.getParam(), recAddrList);
        if (resultCount == NumberConst.IntDef.INT_ZERO) {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家收货地址更新失败");
        } else {
            rs.setResult(recAddrList);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家收货地址更新成功");
        }
        return rs;
    }

    /**
     * 买家收货地址查询接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/receiveAddr/findList",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByBuyerRecAddr>> buyerReceiveAddrFindList(@RequestBody RsRequest<ByBuyerRecAddr> param) {
        RsResponse<List<ByBuyerRecAddr>> rs = new RsResponse<>();
        List<ByBuyerRecAddr> receiveAddrList = iby121208Logic.buyerReceiveAddrFind(param.getParam());
        if (CollectionUtils.isEmpty(receiveAddrList)) {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家收货地址信息不存在");
        } else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家收货地址获取成功");
            rs.setResult(receiveAddrList);
        }
        return rs;
    }

    /**
     * 通路注册买家收货地址新增
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/receiveAddr/phoneSave",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ByBuyerRecAddr> buyerEmployeePhoneSave(@RequestBody RsRequest<ByBuyerRecAddr> param) {
        RsResponse<ByBuyerRecAddr> rs = new RsResponse<>();
        ByBuyerRecAddr recAddr = this.iby121208Logic.buyerEmployeePhoneInsert(param.getParam());
        if (recAddr == null) {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家收货地址新增失败！");
        } else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家收货地址新增成功");
            rs.setResult(recAddr);
        }
        return rs;
    }

    /**
     * 通路注册买家收货地址删除
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/receiveAddr/delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Object> buyerReceiveAddrDelete(@RequestBody RsRequest<ByBuyerRecAddr> param) {
        RsResponse<Object> rs = new RsResponse<>();
        int deleteResult = this.iby121208Logic.buyerReceiveAddrDelete(param.getParam());
        if (deleteResult == NumberConst.IntDef.INT_ONE) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家收货地址删除成功!");
        } else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家收货地址删除失败!");
        }
        return rs;
    }
}
