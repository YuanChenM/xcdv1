/**
 * MS112102MsCarduploadlog.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import com.msk.core.entity.MsCarduploadlog;

/**
 * MS112102MsCarduploadlog.
 *
 * @author rwf
 */
public class MS112102MsCarduploadlog extends MsCarduploadlog {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    // 记录上传时间
    private String uploadTime;

    /**
     * Get the uploadTime.
     *
     * @return uploadTime
     *
     * @author rwf
     */
    public String getUploadTime() {
        return this.uploadTime;
    }

    /**
     * Set the uploadTime.
     *
     * @param uploadTime uploadTime
     *
     * @author rwf
     */
    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

}
