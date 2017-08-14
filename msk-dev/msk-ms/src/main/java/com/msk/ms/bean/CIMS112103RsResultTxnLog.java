/**
 * TxnLog.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;

/**
 * TxnLog.
 * 卡消费信息查询接口中，通联返回json中消费信息查询
 * @author rwf
 */
public class CIMS112103RsResultTxnLog implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    // 产品编号
    private String prdt_no;
    // 交易日期
    private String int_txn_dt;
    // 交易名称
    private String txn_cd_name;
    // 交易编号
    private String txn_cd;
    // 账户余额
    private String acct_bal_at;
    // 品牌名称
    private String brand_id;
    // 终端号
    private String term_id;
    // 接入方参考号
    private String access_ref_seq_id;
    // 可用账户余额
    private String avail_bal_at;
    // 卡号
    private String card_id;
    // 系统交易时间
    private String int_txn_tm;
    // 交易状态
    private String txn_sta_cd;
    // 交易手续费
    private String txn_fee_at;
    // 接入渠道
    private String accept_brh_id;
    // 开户机构号
    private String open_brh_id;
    // 机构流水号
    private String access_txn_seq_id;
    // 系统交易流水号
    private String int_txn_seq_id;
    // 交易金额
    private Double txn_at;

    /**
     * Get the prdt_no.
     *
     * @return prdt_no
     *
     * @author rwf
     */
    public String getPrdt_no() {
        return this.prdt_no;
    }

    /**
     * Set the prdt_no.
     *
     * @param prdt_no prdt_no
     *
     * @author rwf
     */
    public void setPrdt_no(String prdt_no) {
        this.prdt_no = prdt_no;
    }

    /**
     * Get the txn_cd_name.
     *
     * @return txn_cd_name
     *
     * @author rwf
     */
    public String getTxn_cd_name() {
        return this.txn_cd_name;
    }

    /**
     * Set the txn_cd_name.
     *
     * @param txn_cd_name txn_cd_name
     *
     * @author rwf
     */
    public void setTxn_cd_name(String txn_cd_name) {
        this.txn_cd_name = txn_cd_name;
    }

    /**
     * Get the txn_cd.
     *
     * @return txn_cd
     *
     * @author rwf
     */
    public String getTxn_cd() {
        return this.txn_cd;
    }

    /**
     * Set the txn_cd.
     *
     * @param txn_cd txn_cd
     *
     * @author rwf
     */
    public void setTxn_cd(String txn_cd) {
        this.txn_cd = txn_cd;
    }

    /**
     * Get the acct_bal_at.
     *
     * @return acct_bal_at
     *
     * @author rwf
     */
    public String getAcct_bal_at() {
        return this.acct_bal_at;
    }

    /**
     * Set the acct_bal_at.
     *
     * @param acct_bal_at acct_bal_at
     *
     * @author rwf
     */
    public void setAcct_bal_at(String acct_bal_at) {
        this.acct_bal_at = acct_bal_at;
    }

    /**
     * Get the brand_id.
     *
     * @return brand_id
     *
     * @author rwf
     */
    public String getBrand_id() {
        return this.brand_id;
    }

    /**
     * Set the brand_id.
     *
     * @param brand_id brand_id
     *
     * @author rwf
     */
    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    /**
     * Get the term_id.
     *
     * @return term_id
     *
     * @author rwf
     */
    public String getTerm_id() {
        return this.term_id;
    }

    /**
     * Set the term_id.
     *
     * @param term_id term_id
     *
     * @author rwf
     */
    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    /**
     * Get the access_ref_seq_id.
     *
     * @return access_ref_seq_id
     *
     * @author rwf
     */
    public String getAccess_ref_seq_id() {
        return this.access_ref_seq_id;
    }

    /**
     * Set the access_ref_seq_id.
     *
     * @param access_ref_seq_id access_ref_seq_id
     *
     * @author rwf
     */
    public void setAccess_ref_seq_id(String access_ref_seq_id) {
        this.access_ref_seq_id = access_ref_seq_id;
    }

    /**
     * Get the avail_bal_at.
     *
     * @return avail_bal_at
     *
     * @author rwf
     */
    public String getAvail_bal_at() {
        return this.avail_bal_at;
    }

    /**
     * Set the avail_bal_at.
     *
     * @param avail_bal_at avail_bal_at
     *
     * @author rwf
     */
    public void setAvail_bal_at(String avail_bal_at) {
        this.avail_bal_at = avail_bal_at;
    }

    /**
     * Get the card_id.
     *
     * @return card_id
     *
     * @author rwf
     */
    public String getCard_id() {
        return this.card_id;
    }

    /**
     * Set the card_id.
     *
     * @param card_id card_id
     *
     * @author rwf
     */
    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    /**
     * Get the int_txn_tm.
     *
     * @return int_txn_tm
     *
     * @author rwf
     */
    public String getInt_txn_tm() {
        return this.int_txn_tm;
    }

    /**
     * Set the int_txn_tm.
     *
     * @param int_txn_tm int_txn_tm
     *
     * @author rwf
     */
    public void setInt_txn_tm(String int_txn_tm) {
        this.int_txn_tm = int_txn_tm;
    }

    /**
     * Get the txn_sta_cd.
     *
     * @return txn_sta_cd
     *
     * @author rwf
     */
    public String getTxn_sta_cd() {
        return this.txn_sta_cd;
    }

    /**
     * Set the txn_sta_cd.
     *
     * @param txn_sta_cd txn_sta_cd
     *
     * @author rwf
     */
    public void setTxn_sta_cd(String txn_sta_cd) {
        this.txn_sta_cd = txn_sta_cd;
    }

    /**
     * Get the txn_fee_at.
     *
     * @return txn_fee_at
     *
     * @author rwf
     */
    public String getTxn_fee_at() {
        return this.txn_fee_at;
    }

    /**
     * Set the txn_fee_at.
     *
     * @param txn_fee_at txn_fee_at
     *
     * @author rwf
     */
    public void setTxn_fee_at(String txn_fee_at) {
        this.txn_fee_at = txn_fee_at;
    }

    /**
     * Get the accept_brh_id.
     *
     * @return accept_brh_id
     *
     * @author rwf
     */
    public String getAccept_brh_id() {
        return this.accept_brh_id;
    }

    /**
     * Set the accept_brh_id.
     *
     * @param accept_brh_id accept_brh_id
     *
     * @author rwf
     */
    public void setAccept_brh_id(String accept_brh_id) {
        this.accept_brh_id = accept_brh_id;
    }

    /**
     * Get the open_brh_id.
     *
     * @return open_brh_id
     *
     * @author rwf
     */
    public String getOpen_brh_id() {
        return this.open_brh_id;
    }

    /**
     * Set the open_brh_id.
     *
     * @param open_brh_id open_brh_id
     *
     * @author rwf
     */
    public void setOpen_brh_id(String open_brh_id) {
        this.open_brh_id = open_brh_id;
    }

    /**
     * Get the access_txn_seq_id.
     *
     * @return access_txn_seq_id
     *
     * @author rwf
     */
    public String getAccess_txn_seq_id() {
        return this.access_txn_seq_id;
    }

    /**
     * Set the access_txn_seq_id.
     *
     * @param access_txn_seq_id access_txn_seq_id
     *
     * @author rwf
     */
    public void setAccess_txn_seq_id(String access_txn_seq_id) {
        this.access_txn_seq_id = access_txn_seq_id;
    }

    /**
     * Get the int_txn_seq_id.
     *
     * @return int_txn_seq_id
     *
     * @author rwf
     */
    public String getInt_txn_seq_id() {
        return this.int_txn_seq_id;
    }

    /**
     * Set the int_txn_seq_id.
     *
     * @param int_txn_seq_id int_txn_seq_id
     *
     * @author rwf
     */
    public void setInt_txn_seq_id(String int_txn_seq_id) {
        this.int_txn_seq_id = int_txn_seq_id;
    }

    /**
     * Get the txn_at.
     *
     * @return txn_at
     *
     * @author rwf
     */
    public Double getTxn_at() {
        return this.txn_at;
    }

    /**
     * Set the txn_at.
     *
     * @param txn_at txn_at
     *
     * @author rwf
     */
    public void setTxn_at(Double txn_at) {
        this.txn_at = txn_at;
    }

    /**
     * Get the int_txn_dt.
     *
     * @return int_txn_dt
     *
     * @author rwf
     */
    public String getInt_txn_dt() {
        return this.int_txn_dt;
    }

    /**
     * Set the int_txn_dt.
     *
     * @param int_txn_dt int_txn_dt
     *
     * @author rwf
     */
    public void setInt_txn_dt(String int_txn_dt) {
        this.int_txn_dt = int_txn_dt;
    }

}
