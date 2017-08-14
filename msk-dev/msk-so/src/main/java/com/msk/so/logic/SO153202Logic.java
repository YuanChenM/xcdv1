package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.SO153202Bean;
import com.msk.so.bean.SO153202Param;
import com.msk.so.bean.SO153202Param;
import com.msk.so.bean.SO153202Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
@Service
public class SO153202Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(SO153202Logic.class);


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 卖家订单详情
     * @param pageParam
     * @return
     */
    public PageResult<SO153202Bean> findSO153202List(BasePageParam pageParam) {
        logger.info("买家订单详情");
        List orderCodeList = this.findList("getChildOrderCode",pageParam);

        orderCodeList.add(pageParam.getFilterMap().get("orderCode"));
        pageParam.getFilterMap().put("orderCodeList",orderCodeList);

        PageResult<SO153202Bean> result = this.findPage(pageParam, SO153202Bean.class);

        List<SO153202Bean> list = result.getData();
        getNewList(list);
        result.setData(list);

        return result;
    }


    public void getNewList(List<SO153202Bean> list)
    {
        for(SO153202Bean bean : list){
            Long money = Long.valueOf(NumberConst.IntDef.INT_ZERO);
            //金额
            if(bean.getPdPrice()!= null)
            {
                Long returnQty = Long.valueOf(NumberConst.IntDef.INT_ZERO);
                Long orderQty = Long.valueOf(NumberConst.IntDef.INT_ZERO);
                Long pdPrice = bean.getPdPrice();

                if (bean.getOrderQty()!= null)
                {
                    orderQty = bean.getOrderQty();
                }
                if(bean.getReturnQty() != null)
                {
                    returnQty = bean.getReturnQty();
                }

                if((pdPrice*(orderQty-returnQty)) > NumberConst.IntDef.INT_ZERO)
                {
                    money = pdPrice*(orderQty-returnQty);
                }
            }

            bean.setMoney(String.valueOf(money));
        }
    }

    /**
     * 卖家订单详细信息
     * @param pageParam
     * @return
     */
    public SO153202Param findSO153202One(BasePageParam pageParam)
    {
        return this.findOne("findOne",pageParam);
    }
}
