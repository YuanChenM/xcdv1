package com.msk.bs.bean;

import com.msk.core.bean.RsPageParam;

/**
 * Created by gyh on 2016/4/12.
 */
public class IBS2101111RsParam extends RsPageParam{
    private String ownerSlCode;//联盟主买手ID
    private String allianceSlCode;//联盟方买手ID

    /**
     * Getter method for property <tt>ownerSlCode</tt>.
     *
     * @return property value of ownerSlCode
     */
    public String getOwnerSlCode() {
        return ownerSlCode;
    }

    /**
     * Setter method for property <tt>ownerSlCode</tt>.
     *
     * @param ownerSlCode value to be assigned to property ownerSlCode
     */
    public void setOwnerSlCode(String ownerSlCode) {
        this.ownerSlCode = ownerSlCode;
    }

    /**
     * Getter method for property <tt>allianceSlCode</tt>.
     *
     * @return property value of allianceSlCode
     */
    public String getAllianceSlCode() {
        return allianceSlCode;
    }

    /**
     * Setter method for property <tt>allianceSlCode</tt>.
     *
     * @param allianceSlCode value to be assigned to property allianceSlCode
     */
    public void setAllianceSlCode(String allianceSlCode) {
        this.allianceSlCode = allianceSlCode;
    }
}
