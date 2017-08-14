package com.msk.by.rs;

import com.msk.by.bean.IBY121207RsParam;
import com.msk.by.logic.IBY121207Logic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByBuyerEmployee;
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

import java.util.List;

/**
 * IBY121207RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121207RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121207RsController.class);

    @Autowired
    private IBY121207Logic iby121207Logic;

    /**
     * 买家雇员信息更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/employee/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Object> buyerEmployeeUpdate(@RequestBody RsRequest<List<IBY121207RsParam>> param){
        RsResponse<Object> rs = new RsResponse<>();
        int resultCount = iby121207Logic.buyerEmployeeModify(param.getParam());
        if(resultCount == NumberConst.IntDef.INT_ZERO){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家雇员信息更新失败！");
        }else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家雇员信息更新成功");
        }
        return rs;
    }
    /**
     * 买家雇员信息查询接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/employee/findList",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<IBY121207RsParam>> buyerEmployeeFindList(@RequestBody RsRequest<ByBuyerEmployee> param){
        RsResponse<List<IBY121207RsParam>> rs = new RsResponse<>();
        List<IBY121207RsParam> employeeList = iby121207Logic.buyerEmployeeFind(param.getParam());
        if(CollectionUtils.isEmpty(employeeList)){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家雇员信息不存在");
        }else{
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家雇员信息获取成功");
            rs.setResult(employeeList);
        }
        return rs;
    }
    /**
     * 通路注册雇员信息新增
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/employee/phoneSave",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<IBY121207RsParam> buyerEmployeePhoneSave(@RequestBody RsRequest<IBY121207RsParam> param){
        RsResponse<IBY121207RsParam> rs = new RsResponse<>();
        IBY121207RsParam employee = this.iby121207Logic.buyerEmployeePhoneInsert(param.getParam());
        if(employee == null){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家雇员信息新增失败！");
        } else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家雇员信息新增成功");
            rs.setResult(employee);
        }
        return rs;
    }
}
