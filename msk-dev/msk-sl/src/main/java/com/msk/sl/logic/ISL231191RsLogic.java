package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.exception.BusinessException;
import com.msk.sl.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pxg on 2016/4/26.
 */
@Service
public class ISL231191RsLogic extends BaseLogic {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(ISL231191RsLogic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询卖家产品货号信息
     * @param param param
     * @return 卖家产品货号信息
     * @author pxg
     */
    @Transactional(readOnly = true)
    public ISL231191Result queryData(RsRequest<ISL231191RsParam> param) {
        logger.debug("查询卖家产品货号信息");
        ISL231191RsParam isl231191RsParam=param.getParam();
        ISL231191Result isl231191Result=new ISL231191Result();
        if(null!=isl231191RsParam){
            BaseParam params=new BaseParam();
            params.setFilter("slCode",isl231191RsParam.getSlCode());
            params.setFilter("classesCode",isl231191RsParam.getClassesCode());
            params.setFilter("machiningCode",isl231191RsParam.getMachiningCode());
            params.setFilter("breedCode",isl231191RsParam.getBreedCode());
            params.setFilter("featureCode",isl231191RsParam.getFeatureCode());
            params.setFilter("weightCode",isl231191RsParam.getWeightCode());
            params.setFilter("gradeCode",isl231191RsParam.getGradeCode());
            params.setFilter("salesPlatform",isl231191RsParam.getSalesPlatform());
            isl231191Result=super.findOne(params);
            if(null==isl231191Result){
                throw new BusinessException("无对应货号数据!");
            }
        }
        return isl231191Result;
    }
}
