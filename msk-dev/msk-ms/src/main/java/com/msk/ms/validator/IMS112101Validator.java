/**
 * IMS112101Validator.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.ms.bean.IMS112101RsParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IMS112101Validator.
 *
 * @author rwf
 */
public class IMS112101Validator extends BaseValidator<RsRequest<IMS112101RsParam>> {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IMS112101Validator.class);

    /**
     * @param entity
     * @author rwf
     */
    @Override
    public void validatorData(RsRequest<IMS112101RsParam> rsRequest) {
        logger.info("校验用户ID 用户姓名");
        IMS112101RsParam rsParam = rsRequest.getParam();
        this.validatorRequired("用户ID", rsParam.getUserID());
        this.validatorRequired("用户姓名", rsParam.getUserName());
    }
}
