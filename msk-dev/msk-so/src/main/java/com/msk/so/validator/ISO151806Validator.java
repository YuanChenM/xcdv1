package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO151806ProductRsParam;
import com.msk.so.bean.ISO151806RsParam;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * zhang_qiang1  库存调整 接口参数检查
 */
public class ISO151806Validator extends BaseValidator<RsRequest<ISO151806RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151806RsParam> request) {
        ISO151806RsParam param = request.getParam();
        this.validatorRequired("业务参数", param);
        if (param != null) {
            this.validatorMaxLength(param.getSlCode(), 20, "卖家编码", true);
            this.validatorMaxLength(param.getLgcsCode(), 2, "物流区编码", true);
            this.validatorMaxLength(param.getAdjustCode(), 20, "WMS中调整单号", true);
            String adjustDate = param.getAdjustDate();
            this.validatorRequired("调整时间（YYYY-MM-DD HH:mm:ss）", adjustDate);
            if (!StringUtil.isEmpty(adjustDate)) {
                Date adjustTime = DateTimeUtil.parseDate(adjustDate, "yyyy-MM-dd HH:mm:ss");
                if (adjustTime == null) {
                    throw new BusinessException("调整时间 格式为：YYYY-MM-DD HH:mm:ss");
                }
            }
            this.validatorMaxLength(param.getAdjustPerson(), 20, "调整操作人", false);
            this.validatorMaxLength(param.getReasonCode(), 20, "调整原因编码", true);
            List<ISO151806ProductRsParam> productList = param.getProductList();
            this.validatorRequired("本次收货产品信息", productList);
            int rowNum = 0;
            if (!CollectionUtils.isEmpty(productList)) {
                for (ISO151806ProductRsParam productRsParam : productList) {
                    rowNum++;
                    String inboundBatch = productRsParam.getInboundBatch();
                    this.validatorMaxLength(inboundBatch, 50, "第" + rowNum + "个产品中,采购入库批次", true);
                    String supplierCode = productRsParam.getSupplierCode();
                    this.validatorMaxLength(supplierCode, 50, "第" + rowNum + "个产品中,供应商编码", true);
                    String skuCode = productRsParam.getSkuCode();
                    this.validatorBetween(new BigDecimal(skuCode==null?0:skuCode.length()),new BigDecimal(50),new BigDecimal(12),"第" + rowNum + "个产品中,调整产品的SKU编码长度",true);
                    String unit = productRsParam.getUnit();
                    this.validatorMaxLength(unit, 20, "第" + rowNum + "个产品中,产品单位", true);
                    BigDecimal adjustQty = productRsParam.getAdjustQty();
                    this.validatorRequired("第" + rowNum + "个产品中,库存调整数值",adjustQty);
                    if(adjustQty!=null){
                        if(DecimalUtil.isGreater(adjustQty,new BigDecimal("999999999999999999.99"))){
                            throw new BusinessException("库存调整数值超出最大值999999999999999999.99");
                        }
                    }
                    String fromInventoryStatus = productRsParam.getFromInventoryStatus();//出库
                    String toInventoryStatus = productRsParam.getToInventoryStatus();// 入库
                    if(StringUtil.isEmpty(fromInventoryStatus)&&StringUtil.isEmpty(toInventoryStatus)){
                        throw  new BusinessException("第" + rowNum + "个产品中" + "参数 ：fromInventoryStatus,toInventoryStatus至少填写一个！");
                    }
                }
            }
        }
    }
}
