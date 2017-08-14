package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.ds.bean.DS173103Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * zhou_yajun on 2016/1/28.
 */
@Service
public class DS173103Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC183102Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public List<DS173103Param> getSellerInfo(){
        List<DS173103Param> sellerList=new ArrayList<DS173103Param>();
        List<DS173103Param> productList1=new ArrayList<DS173103Param>();
        List<DS173103Param> productList2=new ArrayList<DS173103Param>();

        DS173103Param paramTest3 = new DS173103Param();
        paramTest3.setSellerCode("001");
        paramTest3.setProductCode("01");
        paramTest3.setProductName("鸡产品");
        paramTest3.setTotalPlanOnWayQty_1(new BigDecimal(10.0));
        paramTest3.setTotalActualOnWayQty_1(new BigDecimal(10.0));
        DS173103Param paramTest4 = new DS173103Param();
        paramTest4.setSellerCode("001");
        paramTest4.setProductCode("01");
        paramTest4.setProductName("鸭产品");
        paramTest4.setTotalActualOnWayQty_1(new BigDecimal(14.0));
        DS173103Param paramTest5 = new DS173103Param();
        paramTest5.setSellerCode("002");
        paramTest5.setProductCode("01");
        paramTest5.setProductName("鸡产品");
        paramTest5.setTotalActualOnWayQty_1(new BigDecimal(15.0));
        DS173103Param paramTest6 = new DS173103Param();
        paramTest6.setSellerCode("002");
        paramTest6.setProductCode("01");
        paramTest6.setProductName("鸭产品");
        paramTest6.setTotalActualOnWayQty_1(new BigDecimal(16.0));
        productList1.add(paramTest3);
        productList1.add(paramTest4);
        productList2.add(paramTest5);
        productList2.add(paramTest6);

        DS173103Param paramTest1 = new DS173103Param();
        paramTest1.setSellerCode("001");
        paramTest1.setSellerName("神农客");
        paramTest1.setTotalActualOnWayQty_1(new BigDecimal(10.0));
        paramTest1.setTotalActualProductionQty_1(new BigDecimal(20));
        paramTest1.setTotalActualPlanWaitStorageQty_1(new BigDecimal(20));
        paramTest1.setTotalActualWaitTranSportQty_1(new BigDecimal(20));
        paramTest1.setTotalPlanProductionQty_1(new BigDecimal(20));
        paramTest1.setTotalPlanOnWayQty_1(new BigDecimal(20));
        paramTest1.setTotalPlanWaitStorageQty_1(new BigDecimal(20));
        paramTest1.setTotalPlanWaitTranSportQty_1(new BigDecimal(20));

        paramTest1.setTotalActualOnWayQty_2(new BigDecimal(10.0));
        paramTest1.setTotalActualProductionQty_2(new BigDecimal(20));
        paramTest1.setTotalActualPlanWaitStorageQty_2(new BigDecimal(20));
        paramTest1.setTotalActualWaitTranSportQty_2(new BigDecimal(20));
        paramTest1.setTotalPlanProductionQty_2(new BigDecimal(20));
        paramTest1.setTotalPlanOnWayQty_2(new BigDecimal(20));
        paramTest1.setTotalPlanWaitStorageQty_2(new BigDecimal(20));
        paramTest1.setTotalPlanWaitTranSportQty_2(new BigDecimal(20));

        paramTest1.setTotalActualOnWayQty_3(new BigDecimal(10.0));
        paramTest1.setTotalActualProductionQty_3(new BigDecimal(20));
        paramTest1.setTotalActualPlanWaitStorageQty_3(new BigDecimal(20));
        paramTest1.setTotalActualWaitTranSportQty_3(new BigDecimal(20));
        paramTest1.setTotalPlanProductionQty_3(new BigDecimal(20));
        paramTest1.setTotalPlanOnWayQty_3(new BigDecimal(20));
        paramTest1.setTotalPlanWaitStorageQty_3(new BigDecimal(20));
        paramTest1.setTotalPlanWaitTranSportQty_3(new BigDecimal(20));

        paramTest1.setTotalActualOnWayQty_4(new BigDecimal(10.0));
        paramTest1.setTotalActualProductionQty_4(new BigDecimal(20));
        paramTest1.setTotalActualPlanWaitStorageQty_4(new BigDecimal(20));
        paramTest1.setTotalActualWaitTranSportQty_4(new BigDecimal(20));
        paramTest1.setTotalPlanProductionQty_4(new BigDecimal(20));
        paramTest1.setTotalPlanOnWayQty_4(new BigDecimal(20));
        paramTest1.setTotalPlanWaitStorageQty_4(new BigDecimal(20));
        paramTest1.setTotalPlanWaitTranSportQty_4(new BigDecimal(20));

        paramTest1.setTotalActualOnWayQty_5(new BigDecimal(10.0));
        paramTest1.setTotalActualProductionQty_5(new BigDecimal(20));
        paramTest1.setTotalActualPlanWaitStorageQty_5(new BigDecimal(20));
        paramTest1.setTotalActualWaitTranSportQty_5(new BigDecimal(20));
        paramTest1.setTotalPlanProductionQty_5(new BigDecimal(20));
        paramTest1.setTotalPlanOnWayQty_5(new BigDecimal(20));
        paramTest1.setTotalPlanWaitStorageQty_5(new BigDecimal(20));
        paramTest1.setTotalPlanWaitTranSportQty_5(new BigDecimal(20));

        paramTest1.setTotalActualOnWayQty_6(new BigDecimal(10.0));
        paramTest1.setTotalActualProductionQty_6(new BigDecimal(20));
        paramTest1.setTotalActualPlanWaitStorageQty_6(new BigDecimal(20));
        paramTest1.setTotalActualWaitTranSportQty_6(new BigDecimal(20));
        paramTest1.setTotalPlanProductionQty_6(new BigDecimal(20));
        paramTest1.setTotalPlanOnWayQty_6(new BigDecimal(20));
        paramTest1.setTotalPlanWaitStorageQty_6(new BigDecimal(20));
        paramTest1.setTotalPlanWaitTranSportQty_6(new BigDecimal(20));

        paramTest1.setTotalActualOnWayQty_7(new BigDecimal(10.0));
        paramTest1.setTotalActualProductionQty_7(new BigDecimal(20));
        paramTest1.setTotalActualPlanWaitStorageQty_7(new BigDecimal(20));
        paramTest1.setTotalActualWaitTranSportQty_7(new BigDecimal(20));
        paramTest1.setTotalPlanProductionQty_7(new BigDecimal(20));
        paramTest1.setTotalPlanOnWayQty_7(new BigDecimal(20));
        paramTest1.setTotalPlanWaitStorageQty_7(new BigDecimal(20));
        paramTest1.setTotalPlanWaitTranSportQty_7(new BigDecimal(20));

        paramTest1.setTotalActualOnWayQty_8(new BigDecimal(10.0));
        paramTest1.setTotalActualProductionQty_8(new BigDecimal(20));
        paramTest1.setTotalActualPlanWaitStorageQty_8(new BigDecimal(20));
        paramTest1.setTotalActualWaitTranSportQty_8(new BigDecimal(20));
        paramTest1.setTotalPlanProductionQty_8(new BigDecimal(20));
        paramTest1.setTotalPlanOnWayQty_8(new BigDecimal(20));
        paramTest1.setTotalPlanWaitStorageQty_8(new BigDecimal(20));
        paramTest1.setTotalPlanWaitTranSportQty_8(new BigDecimal(20));
        DS173103Param paramTest2 = new DS173103Param();
        paramTest2.setSellerCode("002");
        paramTest2.setSellerName("神农客2");
        paramTest2.setTotalActualOnWayQty_1(new BigDecimal(10.0));
        paramTest2.setTotalActualProductionQty_1(new BigDecimal(20));
        paramTest2.setTotalActualPlanWaitStorageQty_1(new BigDecimal(20));
        paramTest2.setTotalActualWaitTranSportQty_1(new BigDecimal(20));
        paramTest2.setTotalPlanProductionQty_1(new BigDecimal(20));
        paramTest2.setTotalPlanOnWayQty_1(new BigDecimal(20));
        paramTest2.setTotalPlanWaitStorageQty_1(new BigDecimal(20));
        paramTest2.setTotalPlanWaitTranSportQty_1(new BigDecimal(20));

        paramTest2.setTotalActualOnWayQty_2(new BigDecimal(10.0));
        paramTest2.setTotalActualProductionQty_2(new BigDecimal(20));
        paramTest2.setTotalActualPlanWaitStorageQty_2(new BigDecimal(20));
        paramTest2.setTotalActualWaitTranSportQty_2(new BigDecimal(20));
        paramTest2.setTotalPlanProductionQty_2(new BigDecimal(20));
        paramTest2.setTotalPlanOnWayQty_2(new BigDecimal(20));
        paramTest2.setTotalPlanWaitStorageQty_2(new BigDecimal(20));
        paramTest2.setTotalPlanWaitTranSportQty_2(new BigDecimal(20));

        paramTest2.setTotalActualOnWayQty_3(new BigDecimal(10.0));
        paramTest2.setTotalActualProductionQty_3(new BigDecimal(20));
        paramTest2.setTotalActualPlanWaitStorageQty_3(new BigDecimal(20));
        paramTest2.setTotalActualWaitTranSportQty_3(new BigDecimal(20));
        paramTest2.setTotalPlanProductionQty_3(new BigDecimal(20));
        paramTest2.setTotalPlanOnWayQty_3(new BigDecimal(20));
        paramTest2.setTotalPlanWaitStorageQty_3(new BigDecimal(20));
        paramTest2.setTotalPlanWaitTranSportQty_3(new BigDecimal(20));

        paramTest2.setTotalActualOnWayQty_4(new BigDecimal(10.0));
        paramTest2.setTotalActualProductionQty_4(new BigDecimal(20));
        paramTest2.setTotalActualPlanWaitStorageQty_4(new BigDecimal(20));
        paramTest2.setTotalActualWaitTranSportQty_4(new BigDecimal(20));
        paramTest2.setTotalPlanProductionQty_4(new BigDecimal(20));
        paramTest2.setTotalPlanOnWayQty_4(new BigDecimal(20));
        paramTest2.setTotalPlanWaitStorageQty_4(new BigDecimal(20));
        paramTest2.setTotalPlanWaitTranSportQty_4(new BigDecimal(20));

        paramTest2.setTotalActualOnWayQty_5(new BigDecimal(10.0));
        paramTest2.setTotalActualProductionQty_5(new BigDecimal(20));
        paramTest2.setTotalActualPlanWaitStorageQty_5(new BigDecimal(20));
        paramTest2.setTotalActualWaitTranSportQty_5(new BigDecimal(20));
        paramTest2.setTotalPlanProductionQty_5(new BigDecimal(20));
        paramTest2.setTotalPlanOnWayQty_5(new BigDecimal(20));
        paramTest2.setTotalPlanWaitStorageQty_5(new BigDecimal(20));
        paramTest2.setTotalPlanWaitTranSportQty_5(new BigDecimal(20));

        paramTest2.setTotalActualOnWayQty_6(new BigDecimal(10.0));
        paramTest2.setTotalActualProductionQty_6(new BigDecimal(20));
        paramTest2.setTotalActualPlanWaitStorageQty_6(new BigDecimal(20));
        paramTest2.setTotalActualWaitTranSportQty_6(new BigDecimal(20));
        paramTest2.setTotalPlanProductionQty_6(new BigDecimal(20));
        paramTest2.setTotalPlanOnWayQty_6(new BigDecimal(20));
        paramTest2.setTotalPlanWaitStorageQty_6(new BigDecimal(20));
        paramTest2.setTotalPlanWaitTranSportQty_6(new BigDecimal(20));

        paramTest2.setTotalActualOnWayQty_7(new BigDecimal(10.0));
        paramTest2.setTotalActualProductionQty_7(new BigDecimal(20));
        paramTest2.setTotalActualPlanWaitStorageQty_7(new BigDecimal(20));
        paramTest2.setTotalActualWaitTranSportQty_7(new BigDecimal(20));
        paramTest2.setTotalPlanProductionQty_7(new BigDecimal(20));
        paramTest2.setTotalPlanOnWayQty_7(new BigDecimal(20));
        paramTest2.setTotalPlanWaitStorageQty_7(new BigDecimal(20));
        paramTest2.setTotalPlanWaitTranSportQty_7(new BigDecimal(20));

        paramTest2.setTotalActualOnWayQty_8(new BigDecimal(10.0));
        paramTest2.setTotalActualProductionQty_8(new BigDecimal(20));
        paramTest2.setTotalActualPlanWaitStorageQty_8(new BigDecimal(20));
        paramTest2.setTotalActualWaitTranSportQty_8(new BigDecimal(20));
        paramTest2.setTotalPlanProductionQty_8(new BigDecimal(20));
        paramTest2.setTotalPlanOnWayQty_8(new BigDecimal(20));
        paramTest2.setTotalPlanWaitStorageQty_8(new BigDecimal(20));
        paramTest2.setTotalPlanWaitTranSportQty_8(new BigDecimal(20));

        paramTest1.setProductList(productList1);
        paramTest2.setProductList(productList2);

        sellerList.add(paramTest1);
        sellerList.add(paramTest2);

        return sellerList;
    }
}
