package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.so.bean.HouseAccountBean;
import com.msk.so.bean.HouseAccountSalesResult;
import com.msk.so.bean.ISO151406RsParam;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * *ISO151406Logic
 * *@author sunjiaju
 * *@version 1.0
 */
public class ISO151406Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 冻品管家旗下买家月销售额查询
     *
     * @param param
     */
    @Transactional(readOnly = true)
    public List<HouseAccountSalesResult> searchSales(ISO151406RsParam param) {
        List<HouseAccountSalesResult> results = new ArrayList<>();
        BigDecimal tenThousand = new BigDecimal(10000);
        for (HouseAccountBean bean : param.getHouseAccountList()) {
            if (DateTimeUtil.parseDate(bean.getSaleMonth(), "yyyy-MM") == null) {
                throw new BusinessException("请传递正确格式的销售月份！");
            }
            List<HouseAccountSalesResult> resultList = super.findList(SqlId.SQL_ID_FIND_SALES, bean);
            if (CollectionUtils.isNotEmpty(resultList)) {
                for (HouseAccountSalesResult result : resultList) {
                    result.setSales(DecimalUtil.divide(result.getBigDecimalSales(), tenThousand).toString());
                    result.setBigDecimalSales(null);
                    results.add(result);
                }
            }
        }
        return results;
    }

    interface SqlId {
        String SQL_ID_FIND_SALES = "findSales";
    }
}
