/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_ec_team对应的SlEcTeam。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlEcTeam extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 卖家编码 */
    private java.lang.String slCode;
    /** 成员ID */
    private java.lang.Integer memberId;
    /** 1:是 */
    private java.lang.String leaderFlg;
    /** 姓名 */
    private java.lang.String memberName;
    /** 年龄 */
    private java.lang.Integer memberAge;
    /** 出生日期 */
    private java.util.Date birthday;
    /** 文化程度 */
    private java.lang.String memberEduc;
    /** 联系电话 */
    private java.lang.String memberTel;
    /**
     * <p>默认构造函数。</p>
     */
    public SlEcTeam() {

    }

    /**
     * <p>卖家编码。</p>
     *
     * @return the 卖家编码
     */
    public java.lang.String getSlCode() {
        return slCode;
    }

    /**
     * <p>卖家编码。</p>
     *
     * @param slCode 卖家编码。
     */
    public void setSlCode(java.lang.String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>成员ID。</p>
     *
     * @return the 成员ID
     */
    public java.lang.Integer getMemberId() {
        return memberId;
    }

    /**
     * <p>成员ID。</p>
     *
     * @param memberId 成员ID。
     */
    public void setMemberId(java.lang.Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * <p>1:是。</p>
     *
     * @return the 1:是
     */
    public java.lang.String getLeaderFlg() {
        return leaderFlg;
    }

    /**
     * <p>1:是。</p>
     *
     * @param leaderFlg 1:是。
     */
    public void setLeaderFlg(java.lang.String leaderFlg) {
        this.leaderFlg = leaderFlg;
    }

    /**
     * <p>姓名。</p>
     *
     * @return the 姓名
     */
    public java.lang.String getMemberName() {
        return memberName;
    }

    /**
     * <p>姓名。</p>
     *
     * @param memberName 姓名。
     */
    public void setMemberName(java.lang.String memberName) {
        this.memberName = memberName;
    }

    /**
     * <p>年龄。</p>
     *
     * @return the 年龄
     */
    public java.lang.Integer getMemberAge() {
        return memberAge;
    }

    /**
     * <p>年龄。</p>
     *
     * @param memberAge 年龄。
     */
    public void setMemberAge(java.lang.Integer memberAge) {
        this.memberAge = memberAge;
    }

    /**
     * <p>出生日期。</p>
     *
     * @return the 出生日期
     */
    public java.util.Date getBirthday() {
        return birthday;
    }

    /**
     * <p>出生日期。</p>
     *
     * @param birthday 出生日期。
     */
    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

    /**
     * <p>文化程度。</p>
     *
     * @return the 文化程度
     */
    public java.lang.String getMemberEduc() {
        return memberEduc;
    }

    /**
     * <p>文化程度。</p>
     *
     * @param memberEduc 文化程度。
     */
    public void setMemberEduc(java.lang.String memberEduc) {
        this.memberEduc = memberEduc;
    }

    /**
     * <p>联系电话。</p>
     *
     * @return the 联系电话
     */
    public java.lang.String getMemberTel() {
        return memberTel;
    }

    /**
     * <p>联系电话。</p>
     *
     * @param memberTel 联系电话。
     */
    public void setMemberTel(java.lang.String memberTel) {
        this.memberTel = memberTel;
    }

}
