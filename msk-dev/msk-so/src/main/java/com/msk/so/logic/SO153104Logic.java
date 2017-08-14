package com.msk.so.logic;

import com.msk.core.base.BaseLogic;
import com.msk.so.bean.SO153104Bean;
import com.msk.so.bean.SO153104InfoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
@Service
public class SO153104Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(SO153104Logic.class);

    public List<SO153104Bean> findSO153104List(){
    List<SO153104Bean> list = new ArrayList<SO153104Bean>();

        List<SO153104InfoBean> listInfo = new ArrayList<SO153104InfoBean>();
        SO153104InfoBean sO153104InfoBean1 = new SO153104InfoBean();

        //鸡产品
        sO153104InfoBean1.setName("鸡肠");
        sO153104InfoBean1.setPrice("500.00");
        sO153104InfoBean1.setRemarks("新鲜");

        SO153104InfoBean sO153104InfoBean2 = new SO153104InfoBean();
        sO153104InfoBean2.setName("凤爪");
        sO153104InfoBean2.setPrice("500.00");
        sO153104InfoBean2.setRemarks("冷冻");

        SO153104InfoBean sO153104InfoBean3 = new SO153104InfoBean();
        sO153104InfoBean3.setName("鸡块");
        sO153104InfoBean3.setPrice("1000.00");
        sO153104InfoBean3.setRemarks("冷冻");
        listInfo.add(sO153104InfoBean1);
        listInfo.add(sO153104InfoBean2);
        listInfo.add(sO153104InfoBean3);

        SO153104Bean sO153104Bean = new SO153104Bean();
        sO153104Bean.setName("鸡产品");
        sO153104Bean.setPrice("2000.00");
        sO153104Bean.setRemarks("冷冻");
        sO153104Bean.setsO153104InfoBean(listInfo);


        //鸭产品
        List<SO153104InfoBean> listInfo1 = new ArrayList<SO153104InfoBean>();
        SO153104InfoBean sO153104InfoBean6 = new SO153104InfoBean();
        sO153104InfoBean6.setName("鸭脖");
        sO153104InfoBean6.setPrice("700.00");
        sO153104InfoBean6.setRemarks("新鲜");

        SO153104InfoBean sO153104InfoBean4 = new SO153104InfoBean();
        sO153104InfoBean4.setName("鸭掌");
        sO153104InfoBean4.setPrice("500.00");
        sO153104InfoBean4.setRemarks("冷冻");

        SO153104InfoBean sO153104InfoBean5 = new SO153104InfoBean();
        sO153104InfoBean5.setName("鸭块");
        sO153104InfoBean5.setPrice("600.00");
        sO153104InfoBean5.setRemarks("冷冻");
        listInfo1.add(sO153104InfoBean4);
        listInfo1.add(sO153104InfoBean5);
        listInfo1.add(sO153104InfoBean4);

        SO153104Bean sO153104Bean1 = new SO153104Bean();
        sO153104Bean1.setName("鸭产品");
        sO153104Bean1.setPrice("1800.00");
        sO153104Bean1.setRemarks("新鲜");
        sO153104Bean1.setsO153104InfoBean(listInfo1);

        list.add(sO153104Bean);
        list.add(sO153104Bean1);
        return list;
    }
}
