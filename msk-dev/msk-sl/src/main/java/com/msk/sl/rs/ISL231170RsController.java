package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlProduct;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231169RsParam;
import com.msk.sl.bean.ISL231170RsResult;
import com.msk.sl.logic.ISL231169RsLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cx on 2016/2/23.
 */
@RestController
public class ISL231170RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231170RsController.class);
    @Autowired
    private ISL231169RsLogic iSL231169RsLogic;
    /**
     * 修改卖家产品接口
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slProduct/update",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231170Validator")
    public RsResponse<ISL231170RsResult> updateSLProduct(@RequestBody RsRequest<ISL231169RsParam> param) {
        logger.debug("修改卖家产品接口");
        RsResponse<ISL231170RsResult> rs = new RsResponse<ISL231170RsResult>();
        ISL231169RsParam iSL231169RsParam = param.getParam();
        List<SlProduct> slProductList = iSL231169RsParam.getSlPdList();
        for(int i = 0;i<slProductList.size();i++) {
            SlProduct slProduct = slProductList.get(i);
            int num = iSL231169RsLogic.updateSlProduct(slProduct);
            if(num==0){
                throw new BusinessException("更新失败，请输入正确的参数");
            }
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("修改卖家产品成功");
        return rs;
    }
}
