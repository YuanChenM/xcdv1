package com.msk.so.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.so.bean.SO151406Bean;

/**
 * @author chen_xin
 * @version 创建时间：2015年12月23日 下午3:39:56
 *          查询退货单
 * 
 */
@Service
public class SO151406Logic extends BaseLogic {

    /**
     * 退货单列表假数据
     * 
     * @return PageResult<OM141106Bean>
     *
     * @author chen_xin
     */

    public PageResult<SO151406Bean> queryList() {
        PageResult<SO151406Bean> result = new PageResult<SO151406Bean>();
        List<SO151406Bean> list = new ArrayList<SO151406Bean>();
        SO151406Bean bean = new SO151406Bean();
        bean.setReturnId("1");
        bean.setOrderId("1");
        bean.setReturnCode("010-10111010110101-12");
        bean.setOrderCode("001-10111010110101-12");
        bean.setBuyersCode("10111010110101");
        bean.setBuyersName("李四");
        bean.setIsPaid("是");
        bean.setReturnMode("部分退");
        bean.setReturnAmount("100.00");
        bean.setReturnStatus("已退货");
        bean.setReturnSource("神农客平台");
        bean.setRefundMode("部分退货");
        bean.setReturnTime("2016-1-4 18:12:29");
        result.setRecordsTotal(list.size());
        list.add(bean);
        
        SO151406Bean bean1 = new SO151406Bean();
        bean1.setReturnId("2");
        bean1.setOrderId("2");
        bean1.setReturnCode("010-30111010110251-26");
        bean1.setOrderCode("001-30111010110251-26");
        bean1.setBuyersCode("20111010110011");
        bean1.setBuyersName("王五");
        bean1.setReturnMode("部分退");
        bean1.setIsPaid("是");
        bean1.setReturnAmount("12000.00");
        bean1.setReturnStatus("已退货");
        bean1.setReturnSource("配送运营APP");
        bean1.setRefundMode("部分退货");
        bean1.setReturnTime("2015-1-9 18:32:29");
        list.add(bean1);
        result.setData(list);
        result.setRecordsTotal(list.size());
        return result;

    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
