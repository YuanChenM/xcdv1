package com.msk.so.bean;

import java.math.BigDecimal;
import java.util.List;

import com.msk.core.entity.SoReturnDetail;
import com.msk.core.entity.SoReturnOrderDetailAvailability;

/**
 * 退货单产品明细
 * 
 * @author xhy
 * @version 创建时间：2015年12月25日 上午11:44:10
 *          类说明
 */
public class SO15140701Bean extends SoReturnDetail {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private List<SoReturnOrderDetailAvailability> availability;

    private BigDecimal pdPrice;

    /** 退货单明细ID */
    private java.lang.Long returnDetailId;
    /** 退货单编码 */
    private java.lang.String returnCode;


    public BigDecimal getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(BigDecimal pdPrice) {
        this.pdPrice = pdPrice;
    }

    /**
     * Get the availability.
     *
     * @return availability
     *
     * @author Administrator
     */
    public List<SoReturnOrderDetailAvailability> getAvailability() {
        return this.availability;
    }

    /**
     * Set the availability.
     *
     * @param availability availability
     *
     * @author Administrator
     */
    public void setAvailability(List<SoReturnOrderDetailAvailability> availability) {
        this.availability = availability;
    }

    public Long getReturnDetailId() {
        return returnDetailId;
    }

    public void setReturnDetailId(Long returnDetailId) {
        this.returnDetailId = returnDetailId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
}
