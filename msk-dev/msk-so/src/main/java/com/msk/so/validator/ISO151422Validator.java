package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.rs.ISOReturnOrder;
import com.msk.so.bean.rs.Product;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 
 * ISO151422Validator.
 *
 * @author zhang_qiang1
 */
public class ISO151422Validator extends BaseValidator<RsRequest<ISOReturnOrder>> {

    @Override
    public void validatorData(RsRequest<ISOReturnOrder> request) {
        ISOReturnOrder returnOrder = request.getParam();
        this.validatorRequired("业务参数", returnOrder);
        if(null!=returnOrder){
            this.validatorRequired("退货单id", returnOrder.getReturnId());
            if(!this.checkDateFormat(returnOrder.getInboundTime())){
                this.validatorRequired("退货入库时间格式不对,正确格式为：yyyy-MM-dd HH:mm:ss", null);
            }
            this.validatorRequired("入库人ID", returnOrder.getInboundManId());
            this.validatorRequired("入库人名称", returnOrder.getInboundManName());
             List<Product>productList=  returnOrder.getProductList();
            if(productList.size()==0){
                this.validatorRequired("退货产品列表", null);
            }
            for(int i=1;i<productList.size()+1;i++){
                Product p=  productList.get(i - 1);
                this.validatorRequired(i,"退货明细ID",p.getDetailId());
                this.validatorRequired(i,"SKU编码",p.getSkuCode());
                this.validatorRequired(i,"入库数量",p.getInboundQty());
            }
        }
    }


    /**
     *
     * @param dateTime
     * @return
     */
    public boolean checkDateFormat(String dateTime){
        boolean result=true;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try {
          format.parse(dateTime);
      }catch (Exception e){
          result=false;
      }

        return  result;
    }

}
