package com.msk.pd.bean;

import com.msk.core.bean.RsPageParam;

/**
 * IPD141113RsParam.
 *
 * @author yuan_chen
 */
public class IPD141113RsParam extends RsPageParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** LGCS_CODE */
    private String lgcsCode;

    /**
     * Getter method for property <tt>lgcsCode</tt>.
     *
     * @return property value of lgcsCode
     */
    public String getLgcsCode() {
        return lgcsCode;
    }

    /**
     * Setter method for property <tt>lgcsCode</tt>.
     *
     * @param lgcsCode value to be assigned to property lgcsCode
     */
    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }
}
