package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.PageResult;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.*;
import com.msk.pd.logic.IPD141150Logic;
import com.msk.pd.logic.IPD141151Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页产品楼层接口
 * Created by ren_qiang on 2016/11/03.
 */
@RestController
public class IPD141151RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IPD141146RsController.class);

    @Autowired
    private IPD141151Logic ipd141151Logic;
    /**
     * 查询产品楼层信息
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/bspp/floorInfo/_get",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141151Validator")
    public RsResponse<IPD141151Result> queryScrollImgByPdCode(@RequestBody RsRequest<IPD141151Param> param) {
        logger.info("首页产品楼层接口 ");
        RsResponse<IPD141151Result> rs = new RsResponse<IPD141151Result>();
        IPD141151Result result = new IPD141151Result();

        List<IPD14115103Bean> ipd14115103Beans = new ArrayList<IPD14115103Bean>();
        ipd14115103Beans = ipd141151Logic.getPriceUsefulCycleCode();
        IPD14115103Bean ipd14115103Bean =null;
        if(CollectionUtils.isEmpty(ipd14115103Beans)){
               ipd14115103Beans = ipd141151Logic.getPriceLatestCycleCode();
        }
        if(!CollectionUtils.isEmpty(ipd14115103Beans)){
               ipd14115103Bean = ipd14115103Beans.get(0);
        }
        if(ipd14115103Bean != null){
            if(StringUtils.hasLength(ipd14115103Bean.getPricePeriod())){
                  param.getParam().setPricePeriod(ipd14115103Bean.getPricePeriod());
            }
            else {
                  throw new BusinessException("价盘为空！");
            }
        }
        else {
            throw new BusinessException("价盘为空！");
        }
        List<IPD141151Bean> list= ipd141151Logic.findPdFloorList(param.getParam());
        if(!CollectionUtils.isEmpty(list)){
            int totalCount = this.ipd141151Logic.getPageCount(param.getParam());
            result.setTotalCount(totalCount);
            result.setTotalPage(totalCount, param.getParam().getPageCount());
            result.setPageNo(param.getParam().getPageNo());
            result.setFloorList(list);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询数据正常！");
        }
        else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("未查询到数据!");
        }
        rs.setResult(result);
        return rs;
    }

}
