package com.msk.ds.bean;

import com.msk.core.bean.BaseBean;

/**
 *
 * 一览页面bean
 */
public class TSC30011Bean extends BaseBean{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    private String id;
    private String code;
    private String name;
    private String changshang;
    private String time;
    private String type;

    /**
     * Getter method for property <tt>serialVersionUID</tt>.
     *
     * @return property value of serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
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

    /**
     * Getter method for property <tt>changshang</tt>.
     *
     * @return property value of changshang
     */
    public String getChangshang() {
        return changshang;
    }

    /**
     * Setter method for property <tt>changshang</tt>.
     *
     * @param changshang value to be assigned to property changshang
     */
    public void setChangshang(String changshang) {
        this.changshang = changshang;
    }

    /**
     * Getter method for property <tt>time</tt>.
     *
     * @return property value of time
     */
    public String getTime() {
        return time;
    }

    /**
     * Setter method for property <tt>time</tt>.
     *
     * @param time value to be assigned to property time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Getter method for property <tt>type</tt>.
     *
     * @return property value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for property <tt>type</tt>.
     *
     * @param type value to be assigned to property type
     */
    public void setType(String type) {
        this.type = type;
    }
}
