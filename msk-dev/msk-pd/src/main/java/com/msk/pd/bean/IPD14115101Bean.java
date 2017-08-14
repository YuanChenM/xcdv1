package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * 首页产品楼层接口
 * Created by ren_qiang on 2016/11/3.
 */
public class IPD14115101Bean extends BaseEntity {

    private  Long  floorId;
    private   String floorName;

    private List<IPD14115102Bean>   products;

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public List<IPD14115102Bean> getProducts() {
        return products;
    }

    public void setProducts(List<IPD14115102Bean> products) {
        this.products = products;
    }


}
