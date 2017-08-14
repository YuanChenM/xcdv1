/**
 * IMS112101RsResult.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

/**
 * IMS112101RsResult.
 * 会员卡发卡接口输出参数
 * @author rwf
 */
public class IMS112101RsResult {
    //会员账号
    private String MSCode;
    //会员卡账号
    private String MSCardNo;
    //会员卡初始密码
    private String MSCardPassword;
    /**
     * Get the mSCode.
     *
     * @return mSCode
     *
     * @author rwf
     */
    public String getMSCode() {
        return this.MSCode;
    }
    /**
     * Set the mSCode.
     *
     * @param mSCode mSCode
     *
     * @author rwf
     */
    public void setMSCode(String mSCode) {
        MSCode = mSCode;
    }
    /**
     * Get the mSCardNo.
     *
     * @return mSCardNo
     *
     * @author rwf
     */
    public String getMSCardNo() {
        return this.MSCardNo;
    }
    /**
     * Set the mSCardNo.
     *
     * @param mSCardNo mSCardNo
     *
     * @author rwf
     */
    public void setMSCardNo(String mSCardNo) {
        MSCardNo = mSCardNo;
    }
    /**
     * Get the mSCardPassword.
     *
     * @return mSCardPassword
     *
     * @author rwf
     */
    public String getMSCardPassword() {
        return this.MSCardPassword;
    }
    /**
     * Set the mSCardPassword.
     *
     * @param mSCardPassword mSCardPassword
     *
     * @author rwf
     */
    public void setMSCardPassword(String mSCardPassword) {
        MSCardPassword = mSCardPassword;
    }

}
