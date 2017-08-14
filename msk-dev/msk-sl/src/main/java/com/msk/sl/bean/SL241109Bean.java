package com.msk.sl.bean;

import com.msk.core.bean.BaseBean;
import com.msk.core.entity.SlDistReguChap;

public class SL241109Bean extends SlDistReguChap{
    private String content;//内容
    private String contentHref;//内容链接地址

    /**
     * 获得content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获得contentHref
     */
    public String getContentHref() {
        return contentHref;
    }

    /**
     * 设置contentHref
     */
    public void setContentHref(String contentHref) {
        this.contentHref = contentHref;
    }
}
