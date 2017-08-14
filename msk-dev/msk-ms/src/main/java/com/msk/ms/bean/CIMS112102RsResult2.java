/**
 * CIMS112102RsResult2.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;

/**
 * CIMS112102RsResult2.
 * 对应返回通联的json 卡信息查询
 * @author rwf
 */
public class CIMS112102RsResult2 implements Serializable{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    // 返回参数:"ppcs_cardinfo_get_response
    private CIMS112102RsResult ppcs_cardinfo_get_response;
    /**
     * Get the ppcs_cardinfo_get_response.
     *
     * @return ppcs_cardinfo_get_response
     *
     * @author rwf
     */
    public CIMS112102RsResult getPpcs_cardinfo_get_response() {
        return this.ppcs_cardinfo_get_response;
    }
    /**
     * Set the ppcs_cardinfo_get_response.
     *
     * @param ppcs_cardinfo_get_response ppcs_cardinfo_get_response
     *
     * @author rwf
     */
    public void setPpcs_cardinfo_get_response(CIMS112102RsResult ppcs_cardinfo_get_response) {
        this.ppcs_cardinfo_get_response = ppcs_cardinfo_get_response;
    }


}
