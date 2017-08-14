/**
 * IMS112103Validator.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.ms.bean.IMS112103RsParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * IMS112103Validator.
 *
 * @author rwf
 */
public class IMS112103Validator extends BaseValidator<RsRequest<IMS112103RsParam>> {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IMS112103Validator.class);

    /**
     *
     *
     * @param entity
     * @author rwf
     */
    @Override
    public void validatorData(RsRequest<IMS112103RsParam> entity) {
        logger.info("检测数据");
        IMS112103RsParam ims112103RsParam=entity.getParam();
        this.validatorRequired("查询用户的用户ID",ims112103RsParam.getUserID());
        this.validatorRequired("查询消费的起始日期", ims112103RsParam.getStartDate());
        this.validatorRequired("查询消费的截止日期", ims112103RsParam.getEndDate());
    }
}
