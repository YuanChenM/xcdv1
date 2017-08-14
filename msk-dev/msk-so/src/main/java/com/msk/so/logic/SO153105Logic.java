package com.msk.so.logic;

import com.msk.core.base.BaseLogic;
import com.msk.so.bean.SO153105Bean;
import com.msk.so.bean.SO153105InfoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
@Service
public class SO153105Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(SO153105Logic.class);

    public List<SO153105Bean> findSO153105List(){
    List<SO153105Bean> list = new ArrayList<SO153105Bean>();

        List<SO153105InfoBean> listInfo = new ArrayList<SO153105InfoBean>();
        SO153105InfoBean sO153105InfoBean1 = new SO153105InfoBean();
        //鸡产品
        sO153105InfoBean1.setName("鸡肠");
        sO153105InfoBean1.setPrice("200.00");
        sO153105InfoBean1.setRemarks("新鲜");

        SO153105InfoBean sO153105InfoBean2 = new SO153105InfoBean();
        sO153105InfoBean2.setName("凤爪");
        sO153105InfoBean2.setPrice("2000.00");
        sO153105InfoBean2.setRemarks("冷冻");

        SO153105InfoBean sO153105InfoBean3 = new SO153105InfoBean();
        sO153105InfoBean3.setName("鸡块");
        sO153105InfoBean3.setPrice("1200.00");
        sO153105InfoBean3.setRemarks("冷冻");
        listInfo.add(sO153105InfoBean1);
        listInfo.add(sO153105InfoBean2);
        listInfo.add(sO153105InfoBean3);

        SO153105Bean sO153105Bean = new SO153105Bean();
        sO153105Bean.setName("鸡产品");
        sO153105Bean.setPrice("200.00");
        sO153105Bean.setRemarks("冷冻");
        sO153105Bean.setsO153105InfoBean(listInfo);


        //鸭产品
        List<SO153105InfoBean> listInfo1 = new ArrayList<SO153105InfoBean>();
        SO153105InfoBean sO153105InfoBean6 = new SO153105InfoBean();
        sO153105InfoBean6.setName("鸭脖");
        sO153105InfoBean6.setPrice("200.00");
        sO153105InfoBean6.setRemarks("新鲜");

        SO153105InfoBean sO153105InfoBean4 = new SO153105InfoBean();
        sO153105InfoBean4.setName("鸭掌");
        sO153105InfoBean4.setPrice("2000.00");
        sO153105InfoBean4.setRemarks("冷冻");

        SO153105InfoBean sO153105InfoBean5 = new SO153105InfoBean();
        sO153105InfoBean5.setName("鸭块");
        sO153105InfoBean5.setPrice("1200.00");
        sO153105InfoBean5.setRemarks("冷冻");
        listInfo1.add(sO153105InfoBean4);
        listInfo1.add(sO153105InfoBean5);
        listInfo1.add(sO153105InfoBean4);

        SO153105Bean sO153105Bean1 = new SO153105Bean();
        sO153105Bean1.setName("鸭产品");
        sO153105Bean1.setPrice("200.00");
        sO153105Bean1.setRemarks("新鲜");
        sO153105Bean1.setsO153105InfoBean(listInfo1);

        list.add(sO153105Bean);
        list.add(sO153105Bean1);
        return list;
    }
}
