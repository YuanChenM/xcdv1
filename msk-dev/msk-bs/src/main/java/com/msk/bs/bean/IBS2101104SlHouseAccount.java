package com.msk.bs.bean;

import com.msk.core.entity.SlHouseAccount;
import com.msk.core.entity.SlHouseArea;
import com.msk.core.entity.SlHouseProduct;

import java.util.List;

public class IBS2101104SlHouseAccount extends SlHouseAccount {
    /**
     * 等级
     */
    private String greade;
    /**
     * 登陆者id
     */
    private String loginId;

    /**
     * Getter method for property <tt>greade</tt>.
     *
     * @return property value of greade
     */
    public String getGreade() {
        return greade;
    }

    /**
     * Setter method for property <tt>greade</tt>.
     *
     * @param greade value to be assigned to property greade
     */
    public void setGreade(String greade) {
        this.greade = greade;
    }

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
