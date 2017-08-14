package com.msk.core.web.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * DataGridColumn
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class DataGridColumn implements Serializable{
    private String colType;
    private String name;
    private boolean filter = Boolean.FALSE;
    private boolean edit = Boolean.FALSE;
    private String title;
    private Map<String,Object> attrMap;

    public DataGridColumn(String colType, String name, boolean filter, boolean edit, String title, Map<String, Object> attrMap) {
        this.colType = colType;
        this.name = name;
        this.filter = filter;
        this.edit = edit;
        this.title = title;
        this.attrMap = attrMap;
    }

    /**
     * Get Filter
     * @return filter
     */
    public boolean isFilter(){
        return this.filter;
    }
    /**
     * Get edit
     * @return edit
     */
    public boolean isEdit(){
        return this.edit;
    }
    /**
     * Setter method for property <tt>filter</tt>.
     *
     * @param filter value to be assigned to property filter
     */
    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    /**
     * Setter method for property <tt>edit</tt>.
     *
     * @param edit value to be assigned to property edit
     */
    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    /**
     * Getter method for property <tt>title</tt>.
     *
     * @return property value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property <tt>title</tt>.
     *
     * @param title value to be assigned to property title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for property <tt>attrMap</tt>.
     *
     * @return property value of attrMap
     */
    public Map<String, Object> getAttrMap() {
        return attrMap;
    }

    /**
     * Setter method for property <tt>attrMap</tt>.
     *
     * @param attrMap value to be assigned to property attrMap
     */
    public void setAttrMap(Map<String, Object> attrMap) {
        this.attrMap = attrMap;
    }

    /**
     * Getter method for property <tt>colType</tt>.
     *
     * @return property value of colType
     */
    public String getColType() {
        return colType;
    }

    /**
     * Setter method for property <tt>colType</tt>.
     *
     * @param colType value to be assigned to property colType
     */
    public void setColType(String colType) {
        this.colType = colType;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "<th " +
                "name='"+this.name+"' " +
                "coltype='"+this.colType+"' " +
                "filter='"+this.filter+"' " +
                "edit='"+this.edit+"' "+
                ">"+this.title+"</th>";
    }
}
