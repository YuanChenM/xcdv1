package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SlSeller;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.ISL231122RsParam;
import com.msk.sl.bean.ISL231122RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/15.
 */
@Service
public class ISL231122RsLogic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    /**
     *
     * SqlId.
     *
     * @author cx
     */
    interface SqlId {
        /** 查询所有的卖家基本信息 */
        static final String SQL_ID_FIND_ALL_SL_SELLER = "findAllSlSeller";
    }

    public ISL231122RsResult findAllList(RsRequest<ISL231122RsParam> param) {
        // 创建输入参数
        ISL231122RsParam iSL231122RsParam = param.getParam();
        // 创建输出参数
        ISL231122RsResult iSL231122RsResult = new ISL231122RsResult();
       // SlSeller  slSeller = new  SlSeller();
        BaseParam params = new BaseParam();
        params.setFilter("slAccount", StringUtil.toSafeString(iSL231122RsParam.getSlAccount()));
        params.setFilter("slTel", StringUtil.toSafeString(iSL231122RsParam.getSlTel()));
        params.setFilter("slCode", StringUtil.toSafeString(iSL231122RsParam.getSlCode()));
        params.setFilter("slAreaCode", StringUtil.toSafeString(iSL231122RsParam.getSlAreaCode()));
        params.setFilter("epName", StringUtil.toSafeString(iSL231122RsParam.getEpName()));
        List<SlSeller> slSellerList = new ArrayList<SlSeller>();
        slSellerList = super.findList(SqlId.SQL_ID_FIND_ALL_SL_SELLER,params);
        iSL231122RsResult.setSlSellerList(slSellerList);
        return iSL231122RsResult;
    }
}
