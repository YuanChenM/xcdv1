package com.msk.common.bean;

import com.msk.core.bean.BaseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BuyersType
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class BuyersType extends BaseBean{
    private String code;
    private String name;

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }
}
