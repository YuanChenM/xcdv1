package com.msk.common.bean;

import com.msk.core.bean.BaseBean;

/**
 * BaseStatus
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class BaseStatus extends BaseBean{
    private String tableName;
    private String tableFiled;
    private int oldStatus;
    private int newStatus;

    /**
     * Getter method for property <tt>tableName</tt>.
     *
     * @return property value of tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Setter method for property <tt>tableName</tt>.
     *
     * @param tableName value to be assigned to property tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * Getter method for property <tt>tableFiled</tt>.
     *
     * @return property value of tableFiled
     */
    public String getTableFiled() {
        return tableFiled;
    }

    /**
     * Setter method for property <tt>tableFiled</tt>.
     *
     * @param tableFiled value to be assigned to property tableFiled
     */
    public void setTableFiled(String tableFiled) {
        this.tableFiled = tableFiled;
    }

    /**
     * Getter method for property <tt>oldStatus</tt>.
     *
     * @return property value of oldStatus
     */
    public int getOldStatus() {
        return oldStatus;
    }

    /**
     * Setter method for property <tt>oldStatus</tt>.
     *
     * @param oldStatus value to be assigned to property oldStatus
     */
    public void setOldStatus(int oldStatus) {
        this.oldStatus = oldStatus;
    }

    /**
     * Getter method for property <tt>newStatus</tt>.
     *
     * @return property value of newStatus
     */
    public int getNewStatus() {
        return newStatus;
    }

    /**
     * Setter method for property <tt>newStatus</tt>.
     *
     * @param newStatus value to be assigned to property newStatus
     */
    public void setNewStatus(int newStatus) {
        this.newStatus = newStatus;
    }
}
