/**
 * CardMoneyInfo.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;

/**
 * CardMoneyInfo.
 * 通联返回json中卡状态信息 卡信息查询接口中的
 * @author rwf
 */
public class CIMS112102RsResultCardMoneyInfo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 产品状态 */
    private String product_stat;
    /** 产品编号 */
    private String product_id;
    /** 产品截止有效期 */
    private String product_date;
    /** 可用余额 */
    private String valid_balance;
    /** 卡号 */
    private String card_id;
    /** 账户余额 */
    private String account_balance;

    /**
     * Get the product_stat.
     *
     * @return product_stat
     *
     * @author rwf
     */
    public String getProduct_stat() {
        return this.product_stat;
    }

    /**
     * Set the product_stat.
     *
     * @param product_stat product_stat
     *
     * @author rwf
     */
    public void setProduct_stat(String product_stat) {
        this.product_stat = product_stat;
    }

    /**
     * Get the product_id.
     *
     * @return product_id
     *
     * @author rwf
     */
    public String getProduct_id() {
        return this.product_id;
    }

    /**
     * Set the product_id.
     *
     * @param product_id product_id
     *
     * @author rwf
     */
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    /**
     * Get the product_date.
     *
     * @return product_date
     *
     * @author rwf
     */
    public String getProduct_date() {
        return this.product_date;
    }

    /**
     * Set the product_date.
     *
     * @param product_date product_date
     *
     * @author rwf
     */
    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }

    /**
     * Get the valid_balance.
     *
     * @return valid_balance
     *
     * @author rwf
     */
    public String getValid_balance() {
        return this.valid_balance;
    }

    /**
     * Set the valid_balance.
     *
     * @param valid_balance valid_balance
     *
     * @author rwf
     */
    public void setValid_balance(String valid_balance) {
        this.valid_balance = valid_balance;
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
     * Get the account_balance.
     *
     * @return account_balance
     *
     * @author rwf
     */
    public String getAccount_balance() {
        return this.account_balance;
    }

    /**
     * Set the account_balance.
     *
     * @param account_balance account_balance
     *
     * @author rwf
     */
    public void setAccount_balance(String account_balance) {
        this.account_balance = account_balance;
    }
}
