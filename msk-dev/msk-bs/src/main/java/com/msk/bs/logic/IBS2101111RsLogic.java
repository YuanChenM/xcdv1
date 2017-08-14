package com.msk.bs.logic;

import com.msk.bs.bean.*;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsPageParam;
import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.SlHouseProduct;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gyh on 2016/4/12.
 */
public class IBS2101111RsLogic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Override
    public <T extends BaseEntity> List<T> findPageList(RsPageParam param, RsPageResult pageResult) {
        IBS2101111RsParam ibs2101111RsParam = (IBS2101111RsParam) param;
        if (param.getPageCount() == 0 || param.getPageNo() == 0) {
            param.setPaging(false);
        } else {
            param.setPaging(true);
        }
        param.setFilter("ownerSlCode", ibs2101111RsParam.getOwnerSlCode());
        param.setFilter("allianceSlCode", ibs2101111RsParam.getAllianceSlCode());
        return this.findPageList(param, pageResult);
    }

}
