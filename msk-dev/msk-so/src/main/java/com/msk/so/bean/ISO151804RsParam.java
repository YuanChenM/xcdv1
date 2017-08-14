package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

/**
 * 可退货数据查询接口，根据订单编号等查询出当前可退货的订单详情信息
 */
public class ISO151804RsParam extends BaseParam {
    private String returnType;//退货类型1-迟收退货，2-拒收退货，3-平台退货

    public String getReturnType() {
        return returnType;//退货类型1-迟收退货，2-拒收退货，3-平台退货
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
}
