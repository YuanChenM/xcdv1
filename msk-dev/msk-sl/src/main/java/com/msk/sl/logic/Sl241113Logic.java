package com.msk.sl.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.sl.bean.SL241109Bean;

public class Sl241113Logic extends BaseLogic {

    public List<SL241109Bean> getListInfo() {
        List<SL241109Bean> info=new ArrayList<SL241109Bean>();
        SL241109Bean sl241113Bean1=new SL241109Bean();
        sl241113Bean1.setChapNo(1);
        sl241113Bean1.setChapTitle("关于神农客商城分销");
        sl241113Bean1.setContent("神农客商城作为全国性冻品分销平台，利用自有的遍布全国的冷链物流分拨系统和已经开发各地涵盖批发市场、菜场及各类型餐饮用户等全网式客户资源，按照由卖家订价原则，依据所有签约卖价的出价，加权平均生成神农客分级标准价盘，对应各层级买家，为买家提供统一订货和配送到户服务，将签约卖家产品迅速分销到全国，神农客商城收取不超过2%分销管理费(以销售额计)。");
        info.add(sl241113Bean1);
        
        SL241109Bean sl241113Bean2=new SL241109Bean();
        sl241113Bean2.setChapNo(2);
        sl241113Bean2.setChapTitle("神农客商城分销产品品牌");
        sl241113Bean2.setContent("神农客商城为方便分销卖家产品，与卖家合作采用联合品牌模式确定分销产品品牌，即“卖家品牌-神农客”。");
        info.add(sl241113Bean2);
        
        SL241109Bean sl241113Bean3=new SL241109Bean();
        sl241113Bean3.setChapNo(3);
        sl241113Bean3.setChapTitle("产品标准与质量管控");
        sl241113Bean3.setContent("签约卖家在神农客平台上分销的产品，须遵守神农客卫士产品技术和质量系统制定的产品质量标准、技术标准和包装标准。");
        info.add(sl241113Bean3);
        
        SL241109Bean sl241113Bean4=new SL241109Bean();
        sl241113Bean4.setChapNo(4);
        sl241113Bean4.setChapTitle("卖家分销审批");
        sl241113Bean4.setContent("卖家自愿签署《神农客商城分销章程》，成为神农客商城卖家。");
        info.add(sl241113Bean4);
        return info;        
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
