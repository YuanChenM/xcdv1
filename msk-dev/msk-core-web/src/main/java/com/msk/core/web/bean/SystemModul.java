package com.msk.core.web.bean;

import java.util.List;

import com.msk.core.bean.BaseBean;

/**
 * Created by jiangnan on 15/11/20.
 */
public class SystemModul extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String sysNo;
    private String sysName;
    private Integer sysLevel;
    private String parentSysNo;
    /** 模块对应的页面 */
    private List<SystemPage> pageList;

    /**
     * *获得sysNo
     **/
    public String getSysNo() {
        return sysNo;
    }

    public void setSysNo(String sysNo) {
        this.sysNo = sysNo;
    }

    /**
     * *获得sysName
     **/
    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    /**
     * *获得sysLevel
     **/
    public Integer getSysLevel() {
        return sysLevel;
    }

    public void setSysLevel(Integer sysLevel) {
        this.sysLevel = sysLevel;
    }

    /**
     * *获得parentSysNo
     **/
    public String getParentSysNo() {
        return parentSysNo;
    }

    public void setParentSysNo(String parentSysNo) {
        this.parentSysNo = parentSysNo;
    }

    /**
     * *获得pageList
     **/
    public List<SystemPage> getPageList() {
        return pageList;
    }

    public void setPageList(List<SystemPage> pageList) {
        this.pageList = pageList;
    }
}
