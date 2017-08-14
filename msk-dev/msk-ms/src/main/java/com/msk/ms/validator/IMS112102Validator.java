/**
 * IMS112102Validator.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.ms.bean.IMS112102RsParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * IMS112102Validator.
 *
 * @author rwf
 */
public class IMS112102Validator extends BaseValidator<RsRequest<IMS112102RsParam>> {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IMS112102Validator.class);

    /**
     *
     *
     * @param entity
     * @see com.msk.core.base.BaseValidator#validatorData(Object)
     *
     * @author rwf
     */
    @Override
    public void validatorData(RsRequest<IMS112102RsParam> rsRequest) {
        logger.info("校验用户ID");
        IMS112102RsParam ims112102RsParam=rsRequest.getParam();
        this.validatorRequired("用户id", ims112102RsParam.getUserID());
        
    }
}
