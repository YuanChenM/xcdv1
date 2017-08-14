package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.msk.core.entity.BaseEntity;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ20170202Result extends BaseEntity{
    /**id**/
    private String id;
    /**类型**/
    private String constantType;
    /**类型名称**/
    private String constantTypeName;
    /**值**/
    private String constantValue;
    private String constantName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConstantType() {
        return constantType;
    }

    public void setConstantType(String constantType) {
        this.constantType = constantType;
    }

    public String getConstantTypeName() {
        return constantTypeName;
    }

    public void setConstantTypeName(String constantTypeName) {
        this.constantTypeName = constantTypeName;
    }

    public String getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }

    public String getConstantName() {
        return constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName;
    }
}
