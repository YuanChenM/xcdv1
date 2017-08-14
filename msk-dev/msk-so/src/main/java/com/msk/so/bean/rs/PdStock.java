package com.msk.so.bean.rs;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zhang_qiang1 on 2016/4/21.
 */
public class PdStock implements Serializable {

    private  String pdCode;// 产品编码

    private String pdName;//产品名称

    private BigDecimal stockQty;//商品库存

    private String classesCode;//产品类别


    private String classesName;//产品类别名称


    private String breedCode;//产品品种


    private String breedName;//产品品种名称


    private String lgcsName;//物流区名称

    private String warehouseName;//仓库名称


    private  String unit;// 单位


    private  BigDecimal  orderStock;// 订单 已发货库存

    private  BigDecimal   returnStock;// 退货入库库存

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public BigDecimal getStockQty() {
        return stockQty;
    }

    public void setStockQty(BigDecimal stockQty) {
        this.stockQty = stockQty;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getLgcsName() {
        return lgcsName;
    }

    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getOrderStock() {
        return orderStock;
    }

    public void setOrderStock(BigDecimal orderStock) {
        this.orderStock = orderStock;
    }

    public BigDecimal getReturnStock() {
        return returnStock;
    }

    public void setReturnStock(BigDecimal returnStock) {
        this.returnStock = returnStock;
    }
}
