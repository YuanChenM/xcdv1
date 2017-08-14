package com.msk.sl.logic;

import java.util.List;

import com.msk.core.entity.SlPdTncStdNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlProduct;
import com.msk.sl.bean.ISL231106RsParam;

/**
 * ISL231107Logic.
 *
 * @author gyh
 */
@Service
public class ISL231107Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    public RsResponse saveSlQlt(RsRequest<ISL231106RsParam> param){
        ISL231106RsParam isl231106RsParam=param.getParam();
        List<SlProduct> slPdQtyList;
        //卖家产品质量标准值信息List
        List<SlPdTncStdNew> slPdQtyStdList;
        return null;
    }
}
