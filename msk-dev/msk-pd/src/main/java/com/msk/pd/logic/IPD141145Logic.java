package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsPageParam;
import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.BaseEntity;
import com.msk.pd.bean.IPD141145RsParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gyh on 2016/4/20.
 */
public class IPD141145Logic extends BaseLogic{

    @Override
    public <T extends BaseEntity> List<T> findPageList(RsPageParam param, RsPageResult pageResult) {
        IPD141145RsParam rsParam= (IPD141145RsParam) param;
        if (param.getPageCount() == 0 || param.getPageNo() == 0) {
            param.setPaging(false);
        } else {
            param.setPaging(true);
        }
        param.setFilter("sellerCode", rsParam.getSellerCode());
        return super.findPageList(param, pageResult);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
