/**
 * SO151109Bean.java
 *
 * @screen
 * @author rwf
 */
package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

/** 
 * SO151109Bean.
 *
 * @author rwf
 */
public class SO151109Bean extends BaseBean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    //会员卡编码
    private String memberCode;
    //买家编码
    private String buyersCode;
    //买家名称
    private String buyersName;
    //是否已经激活
    private String activateFlag;
    //是否已经发放
    private String issueFlag;
    //发放日期
    private String issueDate;
    /**
     * Get the memberCode.
     *
     * @return memberCode
     *
     * @author rwf
     */
    public String getMemberCode() {
        return this.memberCode;
    }
    /**
     * Set the memberCode.
     *
     * @param memberCode memberCode
     *
     * @author rwf
     */
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }
    /**
     * Get the buyersCode.
     *
     * @return buyersCode
     *
     * @author rwf
     */
    public String getBuyersCode() {
        return this.buyersCode;
    }
    /**
     * Set the buyersCode.
     *
     * @param buyersCode buyersCode
     *
     * @author rwf
     */
    public void setBuyersCode(String buyersCode) {
        this.buyersCode = buyersCode;
    }
    /**
     * Get the buyersName.
     *
     * @return buyersName
     *
     * @author rwf
     */
    public String getBuyersName() {
        return this.buyersName;
    }
    /**
     * Set the buyersName.
     *
     * @param buyersName buyersName
     *
     * @author rwf
     */
    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }
    /**
     * Get the activateFlag.
     *
     * @return activateFlag
     *
     * @author rwf
     */
    public String getActivateFlag() {
        return this.activateFlag;
    }
    /**
     * Set the activateFlag.
     *
     * @param activateFlag activateFlag
     *
     * @author rwf
     */
    public void setActivateFlag(String activateFlag) {
        this.activateFlag = activateFlag;
    }
    /**
     * Get the issueFlag.
     *
     * @return issueFlag
     *
     * @author rwf
     */
    public String getIssueFlag() {
        return this.issueFlag;
    }
    /**
     * Set the issueFlag.
     *
     * @param issueFlag issueFlag
     *
     * @author rwf
     */
    public void setIssueFlag(String issueFlag) {
        this.issueFlag = issueFlag;
    }
    /**
     * Get the issueDate.
     *
     * @return issueDate
     *
     * @author rwf
     */
    public String getIssueDate() {
        return this.issueDate;
    }
    /**
     * Set the issueDate.
     *
     * @param issueDate issueDate
     *
     * @author rwf
     */
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    

}
