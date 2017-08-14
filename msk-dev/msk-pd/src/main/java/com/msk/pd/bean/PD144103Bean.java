package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

/**
 * Created by ren_qiang on 2016/10/27.
 */
public class PD144103Bean extends BaseEntity {
    //主键
    private Long id;
    //楼层名称
    private String floorName;
    //物流区编码
    private String lgcsCode;
    //物流区名称
    private String lgcsName;
    //取色码
    private String color;
    //显示色码
    private String showColor;
    //顺序号
    private String sort;
    //楼层产品数量
    private int pdNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getLgcsName() {
        return lgcsName;
    }

    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getPdNum() {
        return pdNum;
    }

    public void setPdNum(int pdNum) {
        this.pdNum = pdNum;
    }

    public String getShowColor() {
        return "<input style='width:80px;height:20px;background-color: " + color + ";border:0'disabled=\"disabled\"/>";
    }

    public void setShowColor(String showColor) {
        this.showColor = showColor;
    }
}
