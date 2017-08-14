/**
 * CardProductInfo.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;
import java.util.ArrayList;

/** 
 * CardProductInfo.
 *  卡信息查询接口中，通联返回数据中卡产品信息
 * @author rwf
 */
public class CIMS112102RsResultCardProductInfo implements Serializable{

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 卡产品信息集合*/
    private ArrayList<CIMS112102RsResultCardMoneyInfo> card_product_info;
    /**
     * Get the card_product_info.
     *
     * @return card_product_info
     *
     * @author rwf
     */
    public ArrayList<CIMS112102RsResultCardMoneyInfo> getCard_product_info() {
        return this.card_product_info;
    }
    /**
     * Set the card_product_info.
     *
     * @param card_product_info card_product_info
     *
     * @author rwf
     */
    public void setCard_product_info(ArrayList<CIMS112102RsResultCardMoneyInfo> card_product_info) {
        this.card_product_info = card_product_info;
    }
  
    
}
