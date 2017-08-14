/**
 * CIMS11210301RsResult.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;

/**
 * CIMS11210301RsResult.
 * 卡消费信息查询接口中，对应通联系统返回的json值
 * 
 * @author rwf
 */
public class CIMS11210301RsResult implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 时间戳 */
    private String res_timestamp;
    /** res_sign */
    private String res_sign;
    /** 总记录数 */
    private String total;
    /** txn_log列表 */
    private CIMS112103RsResultTxnLogArray txn_log_arrays;

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
     * Get the total.
     *
     * @return total
     *
     * @author rwf
     */
    public String getTotal() {
        return this.total;
    }

    /**
     * Set the total.
     *
     * @param total total
     *
     * @author rwf
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * Get the txn_log_arrays.
     *
     * @return txn_log_arrays
     *
     * @author rwf
     */
    public CIMS112103RsResultTxnLogArray getTxn_log_arrays() {
        return this.txn_log_arrays;
    }

    /**
     * Set the txn_log_arrays.
     *
     * @param txn_log_arrays txn_log_arrays
     *
     * @author rwf
     */
    public void setTxn_log_arrays(CIMS112103RsResultTxnLogArray txn_log_arrays) {
        this.txn_log_arrays = txn_log_arrays;
    }

}
