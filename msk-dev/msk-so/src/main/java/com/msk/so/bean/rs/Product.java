package com.msk.so.bean.rs;

import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;

/**
 * Created by zhang_qiang1 on 2016/4/8.
 */
public class Product extends BaseParam{
    public Product() {
    }

   private Long detailId;//退货明细ID
   private  String inboundBatch;//退货入库批次，退货入库单中INBOUNDBATCH
   private String   skuCode;//SKU编码
   private BigDecimal inboundQty;//入库数量
    private  Long returnId;//退货单id
   private Integer detailStatus;//退货明细状态
    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getInboundQty() {
        return inboundQty;
    }

    public void setInboundQty(BigDecimal inboundQty) {
        this.inboundQty = inboundQty;
    }

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public Integer getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(Integer detailStatus) {
        this.detailStatus = detailStatus;
    }

    public String getInboundBatch() {
        return inboundBatch;
    }

    public void setInboundBatch(String inboundBatch) {
        this.inboundBatch = inboundBatch;
    }
}
