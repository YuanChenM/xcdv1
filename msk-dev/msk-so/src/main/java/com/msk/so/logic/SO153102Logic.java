package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.SO153102Bean;
import com.msk.so.bean.SO153201Bean;
import com.msk.so.bean.SO153201Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Administrator on 2016/1/28.
 */
@Service
public class SO153102Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(SO153102Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 买家详细信息
     * @param param
     * @return
     */
    public SO153102Bean findSO153102One(BasePageParam param)
    {
        return this.findOne("findOne",param);
    }

    /**
     * 买家订单详细信息
     * @param param
     * @return
     */
    public PageResult<SO153102Bean> findSO153102List(BasePageParam param)
    {
        logger.info("买家订单详情");

        List orderCodeList = this.findList("getChildOrderCode",param);
        orderCodeList.add(param.getFilterMap().get("orderCode"));
        param.getFilterMap().put("orderCodeList",orderCodeList);

        PageResult<SO153102Bean> result = this.findPage(param, SO153102Bean.class);

        List<SO153102Bean> list = result.getData();
        getNewList(list);
        result.setData(list);
        return result;
    }

    public void getNewList(List<SO153102Bean> list)
    {
        for(SO153102Bean bean : list){
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
