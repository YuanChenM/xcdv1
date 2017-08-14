package com.msk.core.web.bean;

import com.msk.core.bean.BaseBean;

/**
 * 系统页面Bean
 * @author jiang_nan
 */
public class SystemPage extends BaseBean {
	private static final long serialVersionUID = 1L;
	private String sysNo;
    private String pageNo;
    private String pageName;
    private String pageUrl;
    private String isMenu;

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
     * *获得pageNo
     **/
    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * *获得pageName
     **/
    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    /**
     * *获得pageUrl
     **/
    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    /**
     * *获得isMenu
     **/
    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }
}
