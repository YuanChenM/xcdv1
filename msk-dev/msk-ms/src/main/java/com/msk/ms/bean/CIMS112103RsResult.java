/**
 * CIMS112103RsResult.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;

/**
 * CIMS112103RsResult.
 * 卡消费信息查询中，通联返回json卡片交易信息
 * @author rwf
 */
public class CIMS112103RsResult implements Serializable{
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /**对应查询本月消费信息*/
    private CIMS11210301RsResult ppcs_txnlog_search_response;
    /**
     * Get the ppcs_txnlog_search_response.
     *
     * @return ppcs_txnlog_search_response
     *
     * @author rwf
     */
    public CIMS11210301RsResult getPpcs_txnlog_search_response() {
        return this.ppcs_txnlog_search_response;
    }
    /**
     * Set the ppcs_txnlog_search_response.
     *
     * @param ppcs_txnlog_search_response ppcs_txnlog_search_response
     *
     * @author rwf
     */
    public void setPpcs_txnlog_search_response(CIMS11210301RsResult ppcs_txnlog_search_response) {
        this.ppcs_txnlog_search_response = ppcs_txnlog_search_response;
    }
    

}
