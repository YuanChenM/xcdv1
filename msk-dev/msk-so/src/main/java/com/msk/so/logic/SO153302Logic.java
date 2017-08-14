package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.so.bean.SO153301Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.msk.so.bean.SO153302Bean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhou_ling on 2016/02/01.
 */
@Service
public class SO153302Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(SO153302Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public SO153302Bean findSO153302One(BasePageParam param)
    {
        return this.findOne("findOne",param);
    }
    /**
     * 收支平衡管理查询
     * @return
     */
    public PageResult<SO153302Bean> findSo153302List(BasePageParam param) {
        logger.info("买家订单详情");

        List orderCodeList = this.findList("getChildOrderCode",param);
        orderCodeList.add(param.getFilterMap().get("orderCode"));
        param.getFilterMap().put("orderCodeList", orderCodeList);

        PageResult<SO153302Bean> result = this.findPage(param, SO153302Bean.class);

        List<SO153302Bean> list = result.getData();
        getNewList(list);
        result.setData(list);
        return result;
    }

    public void getNewList(List<SO153302Bean> list)
    {
        for(SO153302Bean bean : list){
            Long money = Long.valueOf(NumberConst.IntDef.INT_ZERO);
            //金额
            if(bean.getPdPrice()!= null)
            {
                Long returnQty = Long.valueOf(NumberConst.IntDef.INT_ZERO);
                Long orderQty = Long.valueOf(NumberConst.IntDef.INT_ZERO);
                Long pdPrice = bean.getPdPrice();

                if (bean.getOrderQty() != null)
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
}
