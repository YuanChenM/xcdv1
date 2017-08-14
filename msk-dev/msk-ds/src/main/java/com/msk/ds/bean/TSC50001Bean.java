package com.msk.ds.bean;

import com.msk.core.entity.BaseEntity;

/**
 * TSC50001Bean.
 *
 * @author XHY
 */
public class TSC50001Bean extends BaseEntity{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private String role;
    private String account;
    private String pepName;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>role</tt>.
     *
     * @return property value of role
     */
    public String getRole() {
        return role;
    }

    /**
     * Setter method for property <tt>role</tt>.
     *
     * @param role value to be assigned to property role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Getter method for property <tt>account</tt>.
     *
     * @return property value of account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Setter method for property <tt>account</tt>.
     *
     * @param account value to be assigned to property account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Getter method for property <tt>pepName</tt>.
     *
     * @return property value of pepName
     */
    public String getPepName() {
        return pepName;
    }

    /**
     * Setter method for property <tt>pepName</tt>.
     *
     * @param pepName value to be assigned to property pepName
     */
    public void setPepName(String pepName) {
        this.pepName = pepName;
    }
}
