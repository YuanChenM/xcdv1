/**
 * IMS112103RsResult.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;
import java.util.List;

/**
 * IMS112103RsResult.
 *
 * @author rwf
 */
public class IMS112103RsResult implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 通联返回的list集合 */
    private List<IMS112103RsResultArray> consumptionlist;

    /**
     * Get the consumptionlist.
     *
     * @return consumptionlist
     *
     * @author rwf
     */
    public List<IMS112103RsResultArray> getConsumptionlist() {
        return this.consumptionlist;
    }

    /**
     * Set the consumptionlist.
     *
     * @param consumptionlist consumptionlist
     *
     * @author rwf
     */
    public void setConsumptionlist(List<IMS112103RsResultArray> consumptionlist) {
        this.consumptionlist = consumptionlist;
    }

}
