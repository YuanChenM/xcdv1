package com.msk.bp.utils;


import com.msk.bp.bean.BP112212Bean;
import com.msk.core.utils.ConfigManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 美侍客卖家产品报价信息Detail初始化
 * SellerQuotationUtil
 * liu_tao2
 */
public class SellerQuotationUtil {
    public static BP112212Bean sellerQuotationZero()
    {
        BP112212Bean bp112212Bean = new BP112212Bean();
        bp112212Bean.setOrderLevelCode("0");
        bp112212Bean.setOrderLevelName("超级大宗订单");
        bp112212Bean.setLevelStandMin(new Long(ConfigManager.getLevelStandMinZero()));
        bp112212Bean.setLevelStandMax(new Long(ConfigManager.getLevelStandMaxZero()));
        bp112212Bean.setStandardCoefficient(new Long(ConfigManager.getStandardCoefficientZero()));
        bp112212Bean.setCurrentCoefficient(new Long(ConfigManager.getStandardCoefficientZero()));
        bp112212Bean.setDisCount(new BigDecimal(ConfigManager.getDisCountZero()));

        return bp112212Bean;
    }

    public static BP112212Bean sellerQuotationOne()
    {
        BP112212Bean bp112212Bean = new BP112212Bean();
        bp112212Bean.setOrderLevelCode("1");
        bp112212Bean.setOrderLevelName("大宗订单1 级");
        bp112212Bean.setLevelStandMin(new Long(ConfigManager.getLevelStandMinOne()));
        bp112212Bean.setLevelStandMax(new Long(ConfigManager.getLevelStandMaxOne()));
        bp112212Bean.setStandardCoefficient(new Long(ConfigManager.getStandardCoefficientOne()));
        bp112212Bean.setCurrentCoefficient(new Long(ConfigManager.getStandardCoefficientOne()));
        bp112212Bean.setDisCount(new BigDecimal(ConfigManager.getDisCountOne()));

        return bp112212Bean;
    }

    public static BP112212Bean sellerQuotationTwo()
    {
        BP112212Bean bp112212Bean = new BP112212Bean();
        bp112212Bean.setOrderLevelCode("2");
        bp112212Bean.setOrderLevelName("大宗订单2 级");
        bp112212Bean.setLevelStandMin(new Long(ConfigManager.getLevelStandMinTwo()));
        bp112212Bean.setLevelStandMax(new Long(ConfigManager.getLevelStandMaxTwo()));
        bp112212Bean.setStandardCoefficient(new Long(ConfigManager.getStandardCoefficientTwo()));
        bp112212Bean.setCurrentCoefficient(new Long(ConfigManager.getStandardCoefficientTwo()));
        bp112212Bean.setDisCount(new BigDecimal(ConfigManager.getDisCountTwo()));

        return bp112212Bean;
    }

    public static BP112212Bean sellerQuotationThree()
    {
        BP112212Bean bp112212Bean = new BP112212Bean();
        bp112212Bean.setOrderLevelCode("3");
        bp112212Bean.setOrderLevelName("大额订单3 级");
        bp112212Bean.setLevelStandMin(new Long(ConfigManager.getLevelStandMinThree()));
        bp112212Bean.setLevelStandMax(new Long(ConfigManager.getLevelStandMaxThree()));
        bp112212Bean.setStandardCoefficient(new Long(ConfigManager.getStandardCoefficientThree()));
        bp112212Bean.setCurrentCoefficient(new Long(ConfigManager.getStandardCoefficientThree()));
        bp112212Bean.setDisCount(new BigDecimal(ConfigManager.getDisCountThree()));

        return bp112212Bean;
    }

    public static BP112212Bean sellerQuotationFour()
    {
        BP112212Bean bp112212Bean = new BP112212Bean();
        bp112212Bean.setOrderLevelCode("4");
        bp112212Bean.setOrderLevelName("大额订单4 级");
        bp112212Bean.setLevelStandMin(new Long(ConfigManager.getLevelStandMinFour()));
        bp112212Bean.setLevelStandMax(new Long(ConfigManager.getLevelStandMaxFour()));
        bp112212Bean.setStandardCoefficient(new Long(ConfigManager.getStandardCoefficientFour()));
        bp112212Bean.setCurrentCoefficient(new Long(ConfigManager.getStandardCoefficientFour()));
        bp112212Bean.setDisCount(new BigDecimal(ConfigManager.getDisCountFour()));

        return bp112212Bean;
    }

    public static BP112212Bean sellerQuotationFive()
    {
        BP112212Bean bp112212Bean = new BP112212Bean();
        bp112212Bean.setOrderLevelCode("5");
        bp112212Bean.setOrderLevelName("大额订单5 级");
        bp112212Bean.setLevelStandMin(new Long(ConfigManager.getLevelStandMinFive()));
        bp112212Bean.setLevelStandMax(new Long(ConfigManager.getLevelStandMaxFive()));
        bp112212Bean.setStandardCoefficient(new Long(ConfigManager.getStandardCoefficientFive()));
        bp112212Bean.setCurrentCoefficient(new Long(ConfigManager.getStandardCoefficientFive()));
        bp112212Bean.setDisCount(new BigDecimal(ConfigManager.getDisCountFive()));
        bp112212Bean.setRemark("参照等级");

        return bp112212Bean;
    }

    public static BP112212Bean sellerQuotationSix()
    {
        BP112212Bean bp112212Bean = new BP112212Bean();
        bp112212Bean.setOrderLevelCode("6");
        bp112212Bean.setOrderLevelName("标准订单6 级");
        bp112212Bean.setLevelStandMin(new Long(ConfigManager.getLevelStandMinSix()));
        bp112212Bean.setLevelStandMax(new Long(ConfigManager.getLevelStandMaxSix()));
        bp112212Bean.setStandardCoefficient(new Long(ConfigManager.getStandardCoefficientSix()));
        bp112212Bean.setCurrentCoefficient(new Long(ConfigManager.getStandardCoefficientSix()));
        bp112212Bean.setDisCount(new BigDecimal(ConfigManager.getDisCountSix()));

        return bp112212Bean;
    }

    public static BP112212Bean sellerQuotationSeven()
    {
        BP112212Bean bp112212Bean = new BP112212Bean();
        bp112212Bean.setOrderLevelCode("7");
        bp112212Bean.setOrderLevelName("标准订单7 级");
        bp112212Bean.setLevelStandMin(new Long(ConfigManager.getLevelStandMinSeven()));
        bp112212Bean.setLevelStandMax(new Long(ConfigManager.getLevelStandMaxSeven()));
        bp112212Bean.setStandardCoefficient(new Long(ConfigManager.getStandardCoefficientSeven()));
        bp112212Bean.setCurrentCoefficient(new Long(ConfigManager.getStandardCoefficientSeven()));
        bp112212Bean.setDisCount(new BigDecimal(ConfigManager.getDisCountSeven()));

        return bp112212Bean;
    }

    public static BP112212Bean sellerQuotationEight()
    {
        BP112212Bean bp112212Bean = new BP112212Bean();
        bp112212Bean.setOrderLevelCode("8");
        bp112212Bean.setOrderLevelName("标准订单8 级");
        bp112212Bean.setLevelStandMin(new Long(ConfigManager.getLevelStandMinEight()));
        bp112212Bean.setLevelStandMax(new Long(ConfigManager.getLevelStandMaxEight()));
        bp112212Bean.setStandardCoefficient(new Long(ConfigManager.getStandardCoefficientEight()));
        bp112212Bean.setCurrentCoefficient(new Long(ConfigManager.getStandardCoefficientEight()));
        bp112212Bean.setDisCount(new BigDecimal(ConfigManager.getDisCountEight()));

        return bp112212Bean;
    }

    public static BP112212Bean sellerQuotationNine()
    {
        BP112212Bean bp112212Bean = new BP112212Bean();
        bp112212Bean.setOrderLevelCode("9");
        bp112212Bean.setOrderLevelName("标准订单9 级");
        bp112212Bean.setLevelStandMin(new Long(ConfigManager.getLevelStandMinNine()));
        bp112212Bean.setLevelStandMax(new Long(ConfigManager.getLevelStandMaxNine()));
        bp112212Bean.setStandardCoefficient(new Long(ConfigManager.getStandardCoefficientNine()));
        bp112212Bean.setCurrentCoefficient(new Long(ConfigManager.getStandardCoefficientNine()));
        bp112212Bean.setDisCount(new BigDecimal(ConfigManager.getDisCountNine()));

        return bp112212Bean;
    }

    public static List<BP112212Bean> getSellerQuotationList()
    {
        List<BP112212Bean> bp112212Beans = new ArrayList<BP112212Bean>();

        bp112212Beans.add(sellerQuotationZero());
        bp112212Beans.add(sellerQuotationOne());
        bp112212Beans.add(sellerQuotationTwo());
        bp112212Beans.add(sellerQuotationThree());
        bp112212Beans.add(sellerQuotationFour());
        bp112212Beans.add(sellerQuotationFive());
        bp112212Beans.add(sellerQuotationSix());
        bp112212Beans.add(sellerQuotationSeven());
        bp112212Beans.add(sellerQuotationEight());
        bp112212Beans.add(sellerQuotationNine());

        return bp112212Beans;
    }
}
