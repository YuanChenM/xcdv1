package com.msk.ds.logic;

import com.msk.core.base.BaseLogic;
import com.msk.ds.bean.TSC1000501Bean;
import com.msk.ds.bean.TSC1000502Bean;
import com.msk.ds.bean.TSC1000503Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/7.
 */
public class TSC20033Logic extends BaseLogic {


    /**
     * 查询合同订单信息
     * @return
     */
    public List<TSC1000501Bean> queryData(){
        List<TSC1000501Bean> list=new ArrayList<>();
        TSC1000501Bean tsc1000501Bean1=new TSC1000501Bean();
        tsc1000501Bean1.setAttribute1("带皮鸭胸");
        tsc1000501Bean1.setAttribute2("220-224g");
        tsc1000501Bean1.setAttribute3("0220102022");
        tsc1000501Bean1.setAttribute4("0220406201060005200111603600001~00500");
        tsc1000501Bean1.setAttribute5("10kg*1");
        tsc1000501Bean1.setAttribute6("A2");
        tsc1000501Bean1.setAttribute7("10");
        tsc1000501Bean1.setAttribute8("500");
        tsc1000501Bean1.setAttribute9("5");
        tsc1000501Bean1.setAttribute10("6.1");
        tsc1000501Bean1.setAttribute11("6.1");
        tsc1000501Bean1.setAttribute12("28975");
        tsc1000501Bean1.setAttribute13("0.2");
        tsc1000501Bean1.setAttribute14("4750");
        tsc1000501Bean1.setAttribute15("950");
        tsc1000501Bean1.setAttribute16("1137.15");
        tsc1000501Bean1.setAttribute17("31026.15");
        tsc1000501Bean1.setAttribute18("");
        tsc1000501Bean1.setAttribute22("鸭产品");
        tsc1000501Bean1.setAttribute23("分割品");
        tsc1000501Bean1.setAttribute19("2016-04-11");
        tsc1000501Bean1.setAttribute20("500");
        TSC1000501Bean tsc1000501Bean2=new TSC1000501Bean();
        tsc1000501Bean2.setAttribute1("鸭胗");
        tsc1000501Bean2.setAttribute2("220-240g");
        tsc1000501Bean2.setAttribute3("0220201012");
        tsc1000501Bean2.setAttribute4("0220406201060005200111603600001~00500");
        tsc1000501Bean2.setAttribute5("10kg*1");
        tsc1000501Bean2.setAttribute6("A2");
        tsc1000501Bean2.setAttribute7("10");
        tsc1000501Bean2.setAttribute8("500");
        tsc1000501Bean2.setAttribute9("5");
        tsc1000501Bean2.setAttribute10("6");
        tsc1000501Bean2.setAttribute11("6");
        tsc1000501Bean2.setAttribute12("45600");
        tsc1000501Bean2.setAttribute13("0.2");
        tsc1000501Bean2.setAttribute14("7600");
        tsc1000501Bean2.setAttribute15("1520");
        tsc1000501Bean2.setAttribute16("1879.44");
        tsc1000501Bean2.setAttribute17("48939.44");
        tsc1000501Bean2.setAttribute18("");
        tsc1000501Bean2.setAttribute22("鸭产品");
        tsc1000501Bean2.setAttribute23("副产品");
        tsc1000501Bean2.setAttribute19("2016-04-11");
        tsc1000501Bean2.setAttribute20("500");
        TSC1000501Bean tsc1000501Bean3=new TSC1000501Bean();
        tsc1000501Bean3.setAttribute1("鸭锁骨");
        tsc1000501Bean3.setAttribute2("220-240g");
        tsc1000501Bean3.setAttribute3("0220201012");
        tsc1000501Bean3.setAttribute4("0220406201060005200111603600001~00500");
        tsc1000501Bean3.setAttribute5("10kg*1");
        tsc1000501Bean3.setAttribute6("A2");
        tsc1000501Bean3.setAttribute7("10");
        tsc1000501Bean3.setAttribute8("500");
        tsc1000501Bean3.setAttribute9("5");
        tsc1000501Bean3.setAttribute10("6");
        tsc1000501Bean3.setAttribute11("6");
        tsc1000501Bean3.setAttribute12("45600");
        tsc1000501Bean3.setAttribute13("0.2");
        tsc1000501Bean3.setAttribute14("7600");
        tsc1000501Bean3.setAttribute15("1520");
        tsc1000501Bean3.setAttribute16("1879.44");
        tsc1000501Bean3.setAttribute17("48939.44");
        tsc1000501Bean3.setAttribute18("");
        tsc1000501Bean3.setAttribute22("鸭产品");
        tsc1000501Bean3.setAttribute23("分割品");
        tsc1000501Bean3.setAttribute19("2016-04-11");
        tsc1000501Bean3.setAttribute20("500");
        list.add(tsc1000501Bean1);
        list.add(tsc1000501Bean2);
        list.add(tsc1000501Bean3);
        return list;
    }
}
