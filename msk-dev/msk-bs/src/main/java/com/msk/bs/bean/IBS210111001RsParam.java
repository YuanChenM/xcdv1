package com.msk.bs.bean;

import com.msk.core.entity.SlBsBuyerLeagues;

import java.util.List;

/**
 * Created by gyh on 2016/4/8.
 */
public class IBS210111001RsParam extends SlBsBuyerLeagues{
    private String loginId;//创建者ID/更新者ID
    private Long hisId;//履历ID

    /**
     * Getter method for property <tt>hisId</tt>.
     *
     * @return property value of hisId
     */
    public Long getHisId() {
        return hisId;
    }

    /**
     * Setter method for property <tt>hisId</tt>.
     *
     * @param hisId value to be assigned to property hisId
     */
    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    /**
     * Getter method for property <tt>loginId</tt>.
     *
     * @return property value of loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Setter method for property <tt>loginId</tt>.
     *
     * @param loginId value to be assigned to property loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
