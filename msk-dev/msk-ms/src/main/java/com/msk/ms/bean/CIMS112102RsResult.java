/**
 * CIMS112102RsResult.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;

/** 
 * CIMS112102RsResult.
 * 通联返回数据接收 卡信息查询
 * @author rwf
 */
public class CIMS112102RsResult implements Serializable{

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /**通联返回json res_timestamp*/
    private String res_timestamp;
    /**通联返回json res_sign*/
    private String res_sign;
    /**通联返回json res_timestamp*/
    private CIMS112102RsResultCardInfo card_info;
    /**
     * Get the res_timestamp.
     *
     * @return res_timestamp
     *
     * @author rwf
     */
    public String getRes_timestamp() {
        return this.res_timestamp;
    }
    /**
     * Set the res_timestamp.
     *
     * @param res_timestamp res_timestamp
     *
     * @author rwf
     */
    public void setRes_timestamp(String res_timestamp) {
        this.res_timestamp = res_timestamp;
    }
    /**
     * Get the res_sign.
     *
     * @return res_sign
     *
     * @author rwf
     */
    public String getRes_sign() {
        return this.res_sign;
    }
    /**
     * Set the res_sign.
     *
     * @param res_sign res_sign
     *
     * @author rwf
     */
    public void setRes_sign(String res_sign) {
        this.res_sign = res_sign;
    }
    /**
     * Get the card_info.
     *
     * @return card_info
     *
     * @author rwf
     */
    public CIMS112102RsResultCardInfo getCard_info() {
        return this.card_info;
    }
    /**
     * Set the card_info.
     *
     * @param card_info card_info
     *
     * @author rwf
     */
    public void setCard_info(CIMS112102RsResultCardInfo card_info) {
        this.card_info = card_info;
    }
    
    
    
}
