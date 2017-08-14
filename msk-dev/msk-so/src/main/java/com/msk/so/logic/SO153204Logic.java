package com.msk.so.logic;

import com.msk.core.base.BaseLogic;
import com.msk.so.bean.SO153204Bean;
import com.msk.so.bean.SO153204InfoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
@Service
public class SO153204Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(SO153204Logic.class);

    public List<SO153204Bean> findSO153204List(){
    List<SO153204Bean> list = new ArrayList<SO153204Bean>();

        List<SO153204InfoBean> listInfo = new ArrayList<SO153204InfoBean>();
        SO153204InfoBean SO153204InfoBean1 = new SO153204InfoBean();

        //鸡产品
        SO153204InfoBean1.setName("鸡肠");
        SO153204InfoBean1.setPrice("500.00");
        SO153204InfoBean1.setRemarks("新鲜");

        SO153204InfoBean SO153204InfoBean2 = new SO153204InfoBean();
        SO153204InfoBean2.setName("凤爪");
        SO153204InfoBean2.setPrice("500.00");
        SO153204InfoBean2.setRemarks("冷冻");

        SO153204InfoBean SO153204InfoBean3 = new SO153204InfoBean();
        SO153204InfoBean3.setName("鸡块");
        SO153204InfoBean3.setPrice("1000.00");
        SO153204InfoBean3.setRemarks("冷冻");
        listInfo.add(SO153204InfoBean1);
        listInfo.add(SO153204InfoBean2);
        listInfo.add(SO153204InfoBean3);

        SO153204Bean SO153204Bean = new SO153204Bean();
        SO153204Bean.setName("鸡产品");
        SO153204Bean.setPrice("2000.00");
        SO153204Bean.setRemarks("冷冻");
        SO153204Bean.setsO153204InfoBean(listInfo);


        //鸭产品
        List<SO153204InfoBean> listInfo1 = new ArrayList<SO153204InfoBean>();
        SO153204InfoBean SO153204InfoBean6 = new SO153204InfoBean();
        SO153204InfoBean6.setName("鸭脖");
        SO153204InfoBean6.setPrice("700.00");
        SO153204InfoBean6.setRemarks("新鲜");

        SO153204InfoBean SO153204InfoBean4 = new SO153204InfoBean();
        SO153204InfoBean4.setName("鸭掌");
        SO153204InfoBean4.setPrice("500.00");
        SO153204InfoBean4.setRemarks("冷冻");

        SO153204InfoBean SO153204InfoBean5 = new SO153204InfoBean();
        SO153204InfoBean5.setName("鸭块");
        SO153204InfoBean5.setPrice("600.00");
        SO153204InfoBean5.setRemarks("冷冻");
        listInfo1.add(SO153204InfoBean4);
        listInfo1.add(SO153204InfoBean5);
        listInfo1.add(SO153204InfoBean4);

        SO153204Bean SO153204Bean1 = new SO153204Bean();
        SO153204Bean1.setName("鸭产品");
        SO153204Bean1.setPrice("1800.00");
        SO153204Bean1.setRemarks("新鲜");
        SO153204Bean1.setsO153204InfoBean(listInfo1);

        list.add(SO153204Bean);
        list.add(SO153204Bean1);
        return list;
    }
}
