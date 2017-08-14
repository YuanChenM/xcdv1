package com.msk.so.logic;

import com.msk.core.base.BaseLogic;
import com.msk.so.bean.SO153205Bean;
import com.msk.so.bean.SO153205InfoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/29.
 */
@Service
public class SO153205Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(SO153205Logic.class);

    public List<SO153205Bean> findSO153205List(){
    List<SO153205Bean> list = new ArrayList<SO153205Bean>();

        List<SO153205InfoBean> listInfo = new ArrayList<SO153205InfoBean>();
        SO153205InfoBean SO153205InfoBean1 = new SO153205InfoBean();

        //鸡产品
        SO153205InfoBean1.setName("鸡肠");
        SO153205InfoBean1.setPrice("200.00");
        SO153205InfoBean1.setRemarks("新鲜");

        SO153205InfoBean SO153205InfoBean2 = new SO153205InfoBean();
        SO153205InfoBean2.setName("凤爪");
        SO153205InfoBean2.setPrice("2000.00");
        SO153205InfoBean2.setRemarks("冷冻");

        SO153205InfoBean SO153205InfoBean3 = new SO153205InfoBean();
        SO153205InfoBean3.setName("鸡块");
        SO153205InfoBean3.setPrice("1200.00");
        SO153205InfoBean3.setRemarks("冷冻");
        listInfo.add(SO153205InfoBean1);
        listInfo.add(SO153205InfoBean2);
        listInfo.add(SO153205InfoBean3);

        SO153205Bean SO153205Bean = new SO153205Bean();
        SO153205Bean.setName("鸡产品");
        SO153205Bean.setPrice("200.00");
        SO153205Bean.setRemarks("冷冻");
        SO153205Bean.setsO153205InfoBean(listInfo);


        //鸭产品
        List<SO153205InfoBean> listInfo1 = new ArrayList<SO153205InfoBean>();
        SO153205InfoBean SO153205InfoBean6 = new SO153205InfoBean();
        SO153205InfoBean6.setName("鸭脖");
        SO153205InfoBean6.setPrice("200.00");
        SO153205InfoBean6.setRemarks("新鲜");

        SO153205InfoBean SO153205InfoBean4 = new SO153205InfoBean();
        SO153205InfoBean4.setName("鸭掌");
        SO153205InfoBean4.setPrice("2000.00");
        SO153205InfoBean4.setRemarks("冷冻");

        SO153205InfoBean SO153205InfoBean5 = new SO153205InfoBean();
        SO153205InfoBean5.setName("鸭块");
        SO153205InfoBean5.setPrice("1200.00");
        SO153205InfoBean5.setRemarks("冷冻");
        listInfo1.add(SO153205InfoBean4);
        listInfo1.add(SO153205InfoBean5);
        listInfo1.add(SO153205InfoBean4);

        SO153205Bean SO153205Bean1 = new SO153205Bean();
        SO153205Bean1.setName("鸭产品");
        SO153205Bean1.setPrice("200.00");
        SO153205Bean1.setRemarks("新鲜");
        SO153205Bean1.setsO153205InfoBean(listInfo1);

        list.add(SO153205Bean);
        list.add(SO153205Bean1);
        return list;
    }
}
