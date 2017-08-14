/**
 * IMS112102RsResult.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * IMS112102RsResult.
 * 会员卡信息查询输出参数
 * @author rwf
 */
public class IMS112102RsResult extends BaseBean {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 用户姓名 */
    private String userName;
    /** 卡号 */
    private String cardNo;
    /** 失效日期 */
    private Date expireDate;
    /** 加密后的密码 */
    private String password;
    /** 会员卡余额 */
    private BigDecimal balance;
    /** 本月消费金额 */
    private BigDecimal monthUsedMoney;

    /**
     * Get the userName.
     *
     * @return userName
     *
     * @author rwf
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Set the userName.
     *
     * @param userName userName
     *
     * @author rwf
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the cardNo.
     *
     * @return cardNo
     *
     * @author rwf
     */
    public String getCardNo() {
        return this.cardNo;
    }

    /**
     * Set the cardNo.
     *
     * @param cardNo cardNo
     *
     * @author rwf
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * Get the password.
     *
     * @return password
     *
     * @author rwf
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set the password.
     *
     * @param password password
     *
     * @author rwf
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the balance.
     *
     * @return balance
     *
     * @author rwf
     */
    public BigDecimal getBalance() {
        return this.balance;
    }

    /**
     * Set the balance.
     *
     * @param balance balance
     *
     * @author rwf
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Get the monthUsedMoney.
     *
     * @return monthUsedMoney
     *
     * @author rwf
     */
    public BigDecimal getMonthUsedMoney() {
        return this.monthUsedMoney;
    }

    /**
     * Set the monthUsedMoney.
     *
     * @param monthUsedMoney monthUsedMoney
     *
     * @author rwf
     */
    public void setMonthUsedMoney(BigDecimal monthUsedMoney) {
        this.monthUsedMoney = monthUsedMoney;
    }

    /**
     * Get the expireDate.
     *
     * @return expireDate
     *
     * @author rwf
     */
    public Date getExpireDate() {
        return this.expireDate;
    }

    /**
     * Set the expireDate.
     *
     * @param expireDate expireDate
     *
     * @author rwf
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }



}
