/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_ep_manager对应的SlEpManager。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlEpManager extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 企业ID */
    private java.lang.Long epId;
    /** 管理成员ID */
    private java.lang.Long memberId;
    /** 职务 */
    private java.lang.String memberDuties;
    /** 姓名 */
    private java.lang.String memberName;
    /** 年龄 */
    private java.lang.Integer memberAge;
    /** 文化程度 */
    private java.lang.String memberEduc;
    /** 联系电话 */
    private java.lang.String memberTel;
    /**
     * <p>默认构造函数。</p>
     */
    public SlEpManager() {

    }

    /**
     * <p>企业ID。</p>
     *
     * @return the 企业ID
     */
    public java.lang.Long getEpId() {
        return epId;
    }

    /**
     * <p>企业ID。</p>
     *
     * @param epId 企业ID。
     */
    public void setEpId(java.lang.Long epId) {
        this.epId = epId;
    }

    /**
     * <p>管理成员ID。</p>
     *
     * @return the 管理成员ID
     */
    public java.lang.Long getMemberId() {
        return memberId;
    }

    /**
     * <p>管理成员ID。</p>
     *
     * @param memberId 管理成员ID。
     */
    public void setMemberId(java.lang.Long memberId) {
        this.memberId = memberId;
    }

    /**
     * <p>职务。</p>
     *
     * @return the 职务
     */
    public java.lang.String getMemberDuties() {
        return memberDuties;
    }

    /**
     * <p>职务。</p>
     *
     * @param memberDuties 职务。
     */
    public void setMemberDuties(java.lang.String memberDuties) {
        this.memberDuties = memberDuties;
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
