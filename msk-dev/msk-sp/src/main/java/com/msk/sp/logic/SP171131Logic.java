package com.msk.sp.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.sp.bean.SP171103Bean;
import com.msk.sp.bean.SP171131Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * xu_wei
 */
@Service
public class SP171131Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SP171131Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author yang_yang
     */
    private interface SqlId {
        String SQL_ID_FIND_ORDERLEVELLIST = "getOrderLevelList";
        String SQL_ID_GET_BREADS="getBreeds";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 价盘平台查看
     * @return
     */
    public PageResult<SP171131Bean> findSP171131List(BasePageParam pageParam) {
        logger.info("价盘平台查看");
        /*PageResult<SP171103Bean> result = this.findPage(pageParam, SP171103Bean.class);

        return result;*/

        PageResult<SP171131Bean> result = new PageResult<SP171131Bean>();
        logger.info("获取假数据");
        List<SP171131Bean> list = new ArrayList<SP171131Bean>();
        /*SO153201Bean sO253101Bean1 = new SO153201Bean();
        sO253101Bean1.setCreationTime("2015-1-10 9:20:30");
        sO253101Bean1.setMoney("2000.00");
        sO253101Bean1.setName("孜然脆皮鸡");
        sO253101Bean1.setOther("神龙客");
        sO253101Bean1.setState("进行中");
        sO253101Bean1.setTransactionNum("订单号:202_10764712576 | 交易号:2016012121001004150024726422");

        SO153201Bean sO253101Bean2 = new SO153201Bean();
        sO253101Bean2.setCreationTime("2014-10-12 10:10:10");
        sO253101Bean2.setMoney("2000.00");
        sO253101Bean2.setName("冻鸡腿");
        sO253101Bean2.setOther("神龙客");
        sO253101Bean2.setState("等待发货");
        sO253101Bean2.setTransactionNum("流水号:20160122293662080151");

        SO153201Bean sO253101Bean3 = new SO153201Bean();
        sO253101Bean3.setCreationTime("2013-2-20 12:20:30");
        sO253101Bean3.setMoney("2000.00");
        sO253101Bean3.setName("鸭血");
        sO253101Bean3.setOther("神龙客");
        sO253101Bean3.setState("等待付款");
        sO253101Bean3.setTransactionNum("流水号:20160122293662080151");

        SO153201Bean sO253101Bean4 = new SO153201Bean();
        sO253101Bean4.setCreationTime("2016-8-12 6:40:10");
        sO253101Bean4.setMoney("2000.00");
        sO253101Bean4.setName("鸭翅");
        sO253101Bean4.setOther("神龙客");
        sO253101Bean4.setState("交易成功");
        sO253101Bean4.setTransactionNum("订单号:202_10764712576 | 交易号:2016012121001004150024726422");
        list.add(sO253101Bean1);
        list.add(sO253101Bean2);
        list.add(sO253101Bean3);
        list.add(sO253101Bean4);*/
        result.setData(list);
        return result;
    }

}
