package com.msk.sp.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.sp.bean.SP171129Bean;
import com.msk.sp.bean.SP171130Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SP171129Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SP171129Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     */
    private interface SqlId {

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
     public List<SP171129Bean> findSP171129List(BaseParam param) {
        logger.info("神农客价盘平台查看");

        List<SP171129Bean>  list = new ArrayList<SP171129Bean>();
        for (int i=1;i<=10;i++){
            SP171129Bean bean = new SP171129Bean();
            String level = "";
            switch (i){
                case 1: level = "超级大宗订单";
                    break;
                case 2: level = "大宗订单1级";
                    break;
                case 3: level = "大宗订单2级";
                    break;
                case 4: level = "大额订单3级";
                    break;
                case 5: level = "大额订单4级";
                    break;
                case 6: level = "大额订单5级";
                    break;
                case 7: level = "标准订单6级";
                    break;
                case 8: level = "标准订单7级";
                    break;
                case 9: level = "标准订单8级";
                    break;
                case 10: level = "标准订单9级";
                    break;

            }
            bean.setOrderLevelName(level);
            bean.setLevelStandMin(888L);
            bean.setLevelStandMax(9999L);
            bean.setGuidePricesMin(new BigDecimal("777"));
            bean.setGuidePricesMax(new BigDecimal("8888"));
            bean.setStandardCoefficient(97L);
            bean.setCurrentCoefficient(96L);
            bean.setLastPriceOfKg(new BigDecimal("100.99"));
            bean.setPriceOfKg(new BigDecimal("100.99"));
            bean.setDisCount(new BigDecimal("97.00"));

            List<SP171130Param> sp171130ParamList = new ArrayList<SP171130Param>();
            for (int j=0;j<2;j++){
                SP171130Param sp1730 = new SP171130Param();
                switch (j){
                    case 0:
                        sp1730.setSupperCode("0000010");
                        sp1730.setSupperName("雨润集团");
                        sp1730.setSupPriceOfKgTd(new BigDecimal("99.99"));
                        break;
                    case 1:
                        sp1730.setSupperCode("0000020");
                        sp1730.setSupperName("三包集团");
                        sp1730.setSupPriceOfKgTd(new BigDecimal("77.99"));
                        break;
                    case 2:
                        sp1730.setSupperCode("0000030");
                        sp1730.setSupperName("万达集团");
                        sp1730.setSupPriceOfKgTd(new BigDecimal("66.99"));
                        break;

             }
                sp171130ParamList.add(sp1730);

           }

            bean.setSuppList(sp171130ParamList);

            list.add(bean);
        }
        return list;
    }

}
