package com.msk.ds.controller;

import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.ItemBean;
import com.msk.ds.bean.ListBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by air on 2016/2/24.
 */
@Controller
@RequestMapping("DS174104")
public class DS174104Controller extends BaseController{
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS174103Controller.class);

    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        logger.debug("卖家产品列表初始化");

        List<ItemBean> data = new ArrayList<ItemBean>();
        ItemBean bean1 = new ItemBean();
        bean1.setClasses("单冻琵琶腿");
        bean1.setOne("100");
        bean1.setTwo("200g以上");
        bean1.setThree("300");
        bean1.setFour("400");
        bean1.setFive("500");
        bean1.setSix("600");
        bean1.setServen("700");
        bean1.setEight("800");
        bean1.setNine("900");
        bean1.setTen("1000");


        ItemBean bean2 = new ItemBean();
        bean2.setClasses("单冻琵琶腿");
        bean2.setOne("100");
        bean2.setTwo("300g以上");
        bean2.setThree("300");
        bean2.setFour("400");
        bean2.setFive("500");
        bean2.setSix("600");
        bean2.setServen("700");
        bean2.setEight("800");
        bean2.setNine("900");
        bean2.setTen("1000");


        ItemBean bean3 = new ItemBean();
        bean3.setClasses("单冻琵琶腿");
        bean3.setOne("100");
        bean3.setTwo("400g以上");
        bean3.setThree("300");
        bean3.setFour("400");
        bean3.setFive("500");
        bean3.setSix("600");
        bean3.setServen("700");
        bean3.setEight("800");
        bean3.setNine("900");
        bean3.setTen("1000");


        data.add(bean1);
        data.add(bean2);
        data.add(bean3);



        //------------------------------------------------------------
        List<ItemBean> data1 = new ArrayList<ItemBean>();
        ItemBean bean11 = new ItemBean();
        bean11.setClasses("大鸡腿");
        bean11.setOne("1100");
        bean11.setTwo("2200g以上");
        bean11.setThree("3300");
        bean11.setFour("4400");
        bean11.setFive("5500");
        bean11.setSix("6600");
        bean11.setServen("7700");
        bean11.setEight("8800");
        bean11.setNine("9900");
        bean11.setTen("10000");


        ItemBean bean22 = new ItemBean();
        bean22.setClasses("大鸡腿");
        bean22.setOne("100");
        bean22.setTwo("300g以上");
        bean22.setThree("300");
        bean22.setFour("400");
        bean22.setFive("500");
        bean22.setSix("600");
        bean22.setServen("700");
        bean22.setEight("800");
        bean22.setNine("900");
        bean22.setTen("1000");


        ItemBean bean33 = new ItemBean();
        bean33.setClasses("大鸡腿");
        bean33.setOne("100");
        bean33.setTwo("400g以上");
        bean33.setThree("300");
        bean33.setFour("400");
        bean33.setFive("500");
        bean33.setSix("600");
        bean33.setServen("700");
        bean33.setEight("800");
        bean33.setNine("900");
        bean33.setTen("1000");

        ItemBean bean44 = new ItemBean();
        bean44.setClasses("大鸡腿");
        bean44.setOne("100");
        bean44.setTwo("400g以上");
        bean44.setThree("300");
        bean44.setFour("400");
        bean44.setFive("500");
        bean44.setSix("600");
        bean44.setServen("700");
        bean44.setEight("800");
        bean44.setNine("900");
        bean44.setTen("1000");


        data1.add(bean11);
        data1.add(bean22);
        data1.add(bean33);
        data1.add(bean44);

        List<ListBean> biglist = new ArrayList<ListBean>();

        ListBean listBean = new ListBean();
        listBean.setList(data);

        ListBean listBean1 = new ListBean();
        listBean1.setList(data1);

        biglist.add(listBean);
        biglist.add(listBean1);

        model.addAttribute("biglist",biglist);
        model.addAttribute("data",data);
        return "ds/DS174104";
    }

}
