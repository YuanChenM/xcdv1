package com.msk.so.logic.rs;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.ISO151418ProductResult;
import com.msk.so.bean.ISO151418RsParam;
import com.msk.so.bean.ISO151418RsResult;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liutao on 2016/10/11.
 */
@Service
public class ISO151418Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    private static Logger logger = LoggerFactory.getLogger(ISO151418Logic.class);

    /**
     * 评价列表查询
     *
     * @param param
     * @return
     */
    @Transactional
    public ISO151418RsResult searchEvaluateList(ISO151418RsParam param) {
        checkParam(param);
        ISO151418RsResult result = new ISO151418RsResult();
        List<ISO151418ProductResult> products = this.findPageList(param, result);

        if (!CollectionUtils.isEmpty(products)) {
            for (ISO151418ProductResult productResult : products) {
                ISO151418ProductResult iso151418ProductResult = this.findOne(SqlId.SQL_ID_GET_ORDER_DETAIL_INFO, productResult);
                productResult.setPdName(iso151418ProductResult.getPdName());
                productResult.setBuyerId(iso151418ProductResult.getBuyerId());
                productResult.setBuyerName(iso151418ProductResult.getBuyerName());
                productResult.setOrderQty(iso151418ProductResult.getOrderQty());
                productResult.setFeatureCode(iso151418ProductResult.getFeatureCode());
                productResult.setFeatureName(iso151418ProductResult.getFeatureName());
            }
        }
        result.setProducts(products);
        return result;
    }

    /**
     * 检查输入参数
     *
     * @param param
     */
    @Transactional
    public void checkParam(ISO151418RsParam param) {
        if (null == param.getPdSearchMode()) {
            throw new BusinessException("产品查询模式不能为空");
        }

        if (!param.getPdSearchMode().equals(NumberConst.IntDef.INT_ONE) && !param.getPdSearchMode().equals(NumberConst.IntDef.INT_TWO)) {
            throw new BusinessException("产品查询模式输入不正确");
        }

        if (null != param.getProDate()) {
            if (null == DateTimeUtil.parseDate(param.getProDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDD)) {
                throw new BusinessException("配送日期格式不正确");
            }
        }
    }

    interface SqlId {
        String SQL_ID_GET_ORDER_DETAIL_INFO = "getOrderDetailInfo";
    }
}
