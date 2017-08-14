package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170404Param;
import com.msk.pl.bean.IPL20170404Result;
import com.msk.pl.bean.IPL20170404RsPageResult;
import com.msk.pl.logic.IPL20170404Logic;
import com.msk.pl.util.beanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@RestController
public class IPL20170404RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170404RsController.class);

    @Autowired
    private IPL20170404Logic ipl20170404Logic;

    @RequestMapping(value = "/api/v1/pl/bs_declaration_period",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170404Validator")
    public RsResponse<IPL20170404RsPageResult> findDateList(@RequestBody RsRequest<IPL20170404Param> param) {
        RsResponse<IPL20170404RsPageResult> response = new RsResponse();
        List<IPL20170404Result> dataZeroList = new ArrayList<>();
        List<IPL20170404Result> dataFirstList = new ArrayList<>();
        IPL20170404RsPageResult result = ipl20170404Logic.searchPdInfo(param.getParam());
        String price;
        if (null != result) {
            List<IPL20170404Result> pdInfoList = result.getDataList();
            if (CollectionUtils.isNotEmpty(pdInfoList)) {
                for (int i = 0; i < pdInfoList.size(); i++) {
                    price = "1";
                    IPL20170404Param params = beanUtils.toBean(param.getParam(),IPL20170404Param.class);
                    params.setClassesCode(pdInfoList.get(i).getClassesCode());
                    params.setMachiningCode(pdInfoList.get(i).getMachiningCode());
                    List<IPL20170404Result> ipl20170404ResultList = ipl20170404Logic.findList(params);
                    pdInfoList.get(i).setTaskId(pdInfoList.get(i).getDtId());

                    for(IPL20170404Result rest : ipl20170404ResultList){
                        if (rest.getDeclarePrice() == null) {
                            price = "0";
                            break;
                        }
                    }
                    if (price.equals("0")) {
                        pdInfoList.get(i).setStatus("0");
                        dataZeroList.add(pdInfoList.get(i));
                    }
                    if (price.equals("1")) {
                        pdInfoList.get(i).setStatus("1");
                        dataFirstList.add(pdInfoList.get(i));
                    }
                }
            }
            result.setDataList(pdInfoList);
        }

        if(param.getParam().getStatus().equals("0")){
            result.setDataList(dataZeroList);
            result.setTotalCount(dataZeroList.size());
        }
        if(param.getParam().getStatus().equals("1")){
            result.setDataList(dataFirstList);
            result.setTotalCount(dataFirstList.size());
        }
        if (result != null && result.getDataList() != null && result.getDataList().size() > NumberConst.IntDef.INT_ZERO) {
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
            response.setMessage("查询成功！");
            response.setResult(result);
            return response;
        }
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("没有查询到数据！");
        return response;
    }

}
