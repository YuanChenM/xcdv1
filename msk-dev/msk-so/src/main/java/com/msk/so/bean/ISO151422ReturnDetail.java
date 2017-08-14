package com.msk.so.bean;

import com.msk.core.entity.SoReturnDetail;

import java.math.BigDecimal;

/**
 * ISO151422ReturnDetail 接口返回结果信息.
 *
 * @author sjj
 */
public class ISO151422ReturnDetail extends SoReturnDetail {
    // 是否为买手销售订单
    private Integer buyerFlg;
    // 买手code
    private String sellerCode;
    // 买手名称
    private String sellerNmae;
    // 退货金额
    private BigDecimal returnAmount;

    public Integer getBuyerFlg() {
        return buyerFlg;
    }

    public void setBuyerFlg(Integer buyerFlg) {
        this.buyerFlg = buyerFlg;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSellerNmae() {
        return sellerNmae;
    }

    public void setSellerNmae(String sellerNmae) {
        this.sellerNmae = sellerNmae;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }
}
