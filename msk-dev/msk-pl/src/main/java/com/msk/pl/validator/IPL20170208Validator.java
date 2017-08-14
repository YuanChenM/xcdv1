package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170208Param;

/**
 * Created by xuhongyang on 2017/2/7.
 *  上传图片参数校验
 *
 */
public class IPL20170208Validator extends BaseValidator<RsRequest<IPL20170208Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170208Param> entity) {
        IPL20170208Param param = entity.getParam();
       if (null != param) {
           if(param.getPlId() != null && param.getPlId().toString() != ""){
               //修改
               this.validatorRequired("买家名称 ", param.getBuyerName());
               this.validatorRequired("买手名称 ", param.getBsName());
               this.validatorRequired("配送站名称 ", param.getTerminalName());
             //  this.validatorRequired("配送站ID ", param.getTerminalId());
              // this.validatorRequired("买手编码 ", param.getBsCode());
           }else{
               this.validatorRequired("买家名称 ", param.getBuyerName());
               this.validatorRequired("买手名称 ", param.getBsName());
               this.validatorRequired("配送站名称 ", param.getTerminalName());
             //  this.validatorRequired("配送站ID ", param.getTerminalId());
               this.validatorRequired("买手编码 ", param.getBsCode());
               this.validatorRequired("图片上传路径 ", param.getFtpUrl());
               this.validatorRequired("时间 ", param.getTaskTime());
           }
       }
    }
}
