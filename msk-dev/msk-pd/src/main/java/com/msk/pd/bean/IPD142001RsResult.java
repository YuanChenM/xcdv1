package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * 销售状态一览对象
 * IPD141103RsParam.
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId", "actTime" })
public class IPD142001RsResult extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String constantTypeName; // 常量类型名称

    private List<IPD142001ChildRsResult> commList;

    /**
     * Getter method for property <tt>commList</tt>.
     *
     * @return property value of commList
     */
    public List<IPD142001ChildRsResult> getCommList() {
        return commList;
    }

    /**
     * Setter method for property <tt>commList</tt>.
     *
     * @param commList value to be assigned to property commList
     */
    public void setCommList(List<IPD142001ChildRsResult> commList) {
        this.commList = commList;
    }

    /**
     * Getter method for property <tt>constantTypeName</tt>.
     *
     * @return property value of constantTypeName
     */
    public String getConstantTypeName() {
        return constantTypeName;
    }

    /**
     * Setter method for property <tt>constantTypeName</tt>.
     *
     * @param constantTypeName value to be assigned to property constantTypeName
     */
    public void setConstantTypeName(String constantTypeName) {
        this.constantTypeName = constantTypeName;
    }
}