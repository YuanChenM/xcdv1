package com.msk.so.bean;

import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.core.entity.SoReturnOrderDetail;

import java.math.BigDecimal;
import java.util.List;

/**
 * 退货单产品明细
 * 
 * @author xhy
 * @version 创建时间：2015年12月25日 上午11:44:10
 *          类说明
 */
public class SO15140704Bean extends SoReturnOrderDetail {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private String returnOrderGoodsId;// 货品编码

    private String goodsName; // 货品名称

    private String goodsStandard; // 货品规格

    private String packStandard; // 包装规格

    private String bulkOne;// 单件体积(/箱)

    private String unitPrice; // 单价(/箱)

    private String goodsNumber; // 数量

    private String goodsWeight; // 重量

    private String goodsBulkOnes; // 体积(箱)

    private String oneAllMoney; // 单种商品总价格

    private String allMoney; // 总价格

    private List<ReturnProductBreed> pdBreedList;// 假数据

    private List<SoOrderDetailAvailability> orderDetail;

    /**2016/02/26 zyj 追加*/
    private BigDecimal pdPrice;// 单价

    private BigDecimal orderQty;//数量

    /**
     * Get the returnOrderGoodsId.
     *
     * @return returnOrderGoodsId
     *
     * @author xhy
     */
    public String getReturnOrderGoodsId() {
        return this.returnOrderGoodsId;
    }

    /**
     * Set the returnOrderGoodsId.
     *
     * @param returnOrderGoodsId returnOrderGoodsId
     *
     * @author xhy
     */
    public void setReturnOrderGoodsId(String returnOrderGoodsId) {
        this.returnOrderGoodsId = returnOrderGoodsId;
    }

    /**
     * Get the goodsName.
     *
     * @return goodsName
     *
     * @author xhy
     */
    public String getGoodsName() {
        return this.goodsName;
    }

    /**
     * Set the goodsName.
     *
     * @param goodsName goodsName
     *
     * @author xhy
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * Get the goodsStandard.
     *
     * @return goodsStandard
     *
     * @author xhy
     */
    public String getGoodsStandard() {
        return this.goodsStandard;
    }

    /**
     * Set the goodsStandard.
     *
     * @param goodsStandard goodsStandard
     *
     * @author xhy
     */
    public void setGoodsStandard(String goodsStandard) {
        this.goodsStandard = goodsStandard;
    }

    /**
     * Get the packStandard.
     *
     * @return packStandard
     *
     * @author xhy
     */
    public String getPackStandard() {
        return this.packStandard;
    }

    /**
     * Set the packStandard.
     *
     * @param packStandard packStandard
     *
     * @author xhy
     */
    public void setPackStandard(String packStandard) {
        this.packStandard = packStandard;
    }

    /**
     * Get the bulkOne.
     *
     * @return bulkOne
     *
     * @author xhy
     */
    public String getBulkOne() {
        return this.bulkOne;
    }

    /**
     * Set the bulkOne.
     *
     * @param bulkOne bulkOne
     *
     * @author xhy
     */
    public void setBulkOne(String bulkOne) {
        this.bulkOne = bulkOne;
    }

    /**
     * Get the unitPrice.
     *
     * @return unitPrice
     *
     * @author xhy
     */
    public String getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Set the unitPrice.
     *
     * @param unitPrice unitPrice
     *
     * @author xhy
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Get the goodsNumber.
     *
     * @return goodsNumber
     *
     * @author xhy
     */
    public String getGoodsNumber() {
        return this.goodsNumber;
    }

    /**
     * Set the goodsNumber.
     *
     * @param goodsNumber goodsNumber
     *
     * @author xhy
     */
    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    /**
     * Get the goodsWeight.
     *
     * @return goodsWeight
     *
     * @author xhy
     */
    public String getGoodsWeight() {
        return this.goodsWeight;
    }

    /**
     * Set the goodsWeight.
     *
     * @param goodsWeight goodsWeight
     *
     * @author xhy
     */
    public void setGoodsWeight(String goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    /**
     * Get the goodsBulkOnes.
     *
     * @return goodsBulkOnes
     *
     * @author xhy
     */
    public String getGoodsBulkOnes() {
        return this.goodsBulkOnes;
    }

    /**
     * Set the goodsBulkOnes.
     *
     * @param goodsBulkOnes goodsBulkOnes
     *
     * @author xhy
     */
    public void setGoodsBulkOnes(String goodsBulkOnes) {
        this.goodsBulkOnes = goodsBulkOnes;
    }

    /**
     * Get the pdBreedList.
     *
     * @return pdBreedList
     *
     * @author Administrator
     */
    public List<ReturnProductBreed> getPdBreedList() {
        return this.pdBreedList;
    }

    /**
     * Set the pdBreedList.
     *
     * @param pdBreedList pdBreedList
     *
     * @author Administrator
     */
    public void setPdBreedList(List<ReturnProductBreed> pdBreedList) {
        this.pdBreedList = pdBreedList;
    }

    /**
     * Get the oneAllMoney.
     *
     * @return oneAllMoney
     *
     * @author Administrator
     */
    public String getOneAllMoney() {
        return this.oneAllMoney;
    }

    /**
     * Set the oneAllMoney.
     *
     * @param oneAllMoney oneAllMoney
     *
     * @author Administrator
     */
    public void setOneAllMoney(String oneAllMoney) {
        this.oneAllMoney = oneAllMoney;
    }

    /**
     * Get the orderDetail.
     *
     * @return orderDetail
     *
     * @author Administrator
     */
    public List<SoOrderDetailAvailability> getOrderDetail() {
        return this.orderDetail;
    }

    /**
     * Set the orderDetail.
     *
     * @param orderDetail orderDetail
     *
     * @author Administrator
     */
    public void setOrderDetail(List<SoOrderDetailAvailability> orderDetail) {
        this.orderDetail = orderDetail;
    }

    /**
     * Get the allMoney.
     *
     * @return allMoney
     *
     * @author Administrator
     */
    public String getAllMoney() {
        return this.allMoney;
    }

    /**
     * Set the allMoney.
     *
     * @param allMoney allMoney
     *
     * @author Administrator
     */
    public void setAllMoney(String allMoney) {
        this.allMoney = allMoney;
    }

    public BigDecimal getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(BigDecimal pdPrice) {
        this.pdPrice = pdPrice;
    }

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }
}
