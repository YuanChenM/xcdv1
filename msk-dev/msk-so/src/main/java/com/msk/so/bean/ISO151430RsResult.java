package com.msk.so.bean;

import com.msk.core.bean.RsPageResult;
import com.msk.so.bean.rs.PdStock;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * IISO151430RsResult接口返回结果信息.
 *
 * @author zhang_qiang1
 */
public class ISO151430RsResult extends RsPageResult {

    private BigDecimal sumStock;//商品总库存

    private BigDecimal  sumOrderStock;//订单取消的库存量
    private BigDecimal   sumReturnOrderStock;//退货入库的库存量

    private List<PdStock> pdStockList;


    public BigDecimal getSumStock() {
        return sumStock;
    }

    public void setSumStock(BigDecimal sumStock) {
        this.sumStock = sumStock;
    }

    public BigDecimal getSumOrderStock() {
        return sumOrderStock;
    }

    public void setSumOrderStock(BigDecimal sumOrderStock) {
        this.sumOrderStock = sumOrderStock;
    }

    public BigDecimal getSumReturnOrderStock() {
        return sumReturnOrderStock;
    }

    public void setSumReturnOrderStock(BigDecimal sumReturnOrderStock) {
        this.sumReturnOrderStock = sumReturnOrderStock;
    }

    public List<PdStock> getPdStockList() {
        return pdStockList;
    }

    public void setPdStockList(List<PdStock> pdStockList) {
        this.pdStockList = pdStockList;
    }
}
