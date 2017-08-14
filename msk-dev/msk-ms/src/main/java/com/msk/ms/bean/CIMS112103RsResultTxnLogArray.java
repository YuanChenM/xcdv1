/**
 * TxnLogArray.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * TxnLogArray.
 * 卡消费信息查询中，通联返回json中本月消费详细记录
 * @author rwf
 */
public class CIMS112103RsResultTxnLogArray implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 查询本月消费金额的list */
    private ArrayList<CIMS112103RsResultTxnLog> txn_log;

    /**
     * Get the txn_log.
     *
     * @return txn_log
     *
     * @author rwf
     */
    public ArrayList<CIMS112103RsResultTxnLog> getTxn_log() {
        return this.txn_log;
    }

    /**
     * Set the txn_log.
     *
     * @param txn_log txn_log
     *
     * @author rwf
     */
    public void setTxn_log(ArrayList<CIMS112103RsResultTxnLog> txn_log) {
        this.txn_log = txn_log;
    }
}
