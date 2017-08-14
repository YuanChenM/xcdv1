package com.msk.pd.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.BaseEntity;

/**
 * 产品标准包装档案卡查询参数
 * IPD141108RsParam.
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId" })
public class IPD141108RsParam extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    private Date actTime;

    /**
     * Getter method for property <tt>actTime</tt>.
     *
     * @return property value of actTime
     */
    @Override
    public Date getActTime() {
        return actTime;
    }

    /**
     * Setter method for property <tt>actTime</tt>.
     *
     * @param actTime value to be assigned to property actTime
     */
    @Override
    public void setActTime(Date actTime) {
        this.actTime = actTime;
    }
}