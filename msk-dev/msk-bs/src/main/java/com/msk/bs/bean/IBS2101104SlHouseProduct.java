package com.msk.bs.bean;

import com.msk.core.entity.SlHouseArea;
import com.msk.core.entity.SlHouseProduct;

import java.util.List;

public class IBS2101104SlHouseProduct extends SlHouseProduct {

    /**
     * 登陆者id
     */
    private String loginId;

    /**
     * Getter method for property <tt>loginId</tt>.
     *
     * @return property value of loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Setter method for property <tt>loginId</tt>.
     *
     * @param loginId value to be assigned to property loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
