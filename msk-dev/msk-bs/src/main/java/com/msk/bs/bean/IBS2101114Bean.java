package com.msk.bs.bean;

import com.msk.core.entity.SlBsBuyer;

/**
 * Created by zhu_kai1 on 2016/7/13.
 */
public class IBS2101114Bean  extends SlBsBuyer {

    // 管家显示名称
    private  String houseShowName;
    // 1-代表买手店管家买家关系履历表信息， 0-代表买手店管家专属会员表信息
    private  String flag;
    public String getHouseShowName() {
        return houseShowName;
    }

    public void setHouseShowName(String houseShowName) {
        this.houseShowName = houseShowName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
