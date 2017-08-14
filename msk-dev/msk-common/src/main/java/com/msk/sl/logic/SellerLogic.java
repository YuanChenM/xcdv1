package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *SellerLogic
 * *@author jiang_nan
 * *@version 1.0
 **/
@Service
public class SellerLogic extends BaseLogic{
    /**
     * 根据买家信息获得关联买手信息
     * @param buyersId 买家编号
     * @return 买手编号
     */
    public List<String> findBuyer(String buyersId){
        return null;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
