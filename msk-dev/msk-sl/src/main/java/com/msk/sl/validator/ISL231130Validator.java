package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231127CertInfoList;
import com.msk.sl.bean.ISL231129RsParam;
import com.msk.sl.bean.ISL231130RsParam;

import java.util.List;

/**
 * Created by rwf on 2016/2/23.
 */
public class ISL231130Validator extends BaseValidator<RsRequest<ISL231130RsParam>> {
    @Override
    public void validatorData(RsRequest<ISL231130RsParam> entity) {
        List<ISL231127CertInfoList> isl231127CertInfoLists = entity.getParam().getCertInfoList();
        for(ISL231127CertInfoList isl231127CertInfoList : isl231127CertInfoLists){
            this.validatorRequired("企业ID",isl231127CertInfoList.getEpId());
        }
    }
}
