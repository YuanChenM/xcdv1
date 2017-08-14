package com.msk.ds.controller;

import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC10001Bean;
import com.msk.ds.bean.TSC10002Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by air on 2016/6/7.
 */
@Controller
@RequestMapping("TSC10002")
public class TSC10002Controller extends BaseController{
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(@RequestParam(value = "zbid", required = false) String zbid,TSC10001Bean tsc10001Bean,Model model){

        /*if(Integer.valueOf(tsc10001Bean.getZbid())!=0 || tsc10001Bean.getZbid()!=null){*/
        if(zbid.equals("0")){
            TSC10001Bean tsc10001Bean1 = new TSC10001Bean();
            tsc10001Bean1.setZbid("0");
            model.addAttribute("list",tsc10001Bean1);
        }else{
            TSC10001Bean tsc10001Bean1 = new TSC10001Bean();
            tsc10001Bean1.setZbid("1");
            tsc10001Bean1.setProjectName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
            tsc10001Bean1.setCheckTime("2016.3.22");
            tsc10001Bean1.setWinner("河北创融公司");
            tsc10001Bean1.setBeginTime("2016.3.13");
            tsc10001Bean1.setEndTime("2016.3.16");

            List<TSC10002Bean> lists = new ArrayList<TSC10002Bean>();

            TSC10002Bean tsc10002Bean = new TSC10002Bean();
            tsc10002Bean.setXuhao("1");
            tsc10002Bean.setYjfl("鸭产品");
            tsc10002Bean.setEjfl("分割品");
            tsc10002Bean.setXsm("带皮鸭胸");
            tsc10002Bean.setXm("带皮鸭胸");
            tsc10002Bean.setSm("");
            tsc10002Bean.setTz("220-240g");

            tsc10002Bean.setJz("10");
            tsc10002Bean.setGg("10kg*1");
            tsc10002Bean.setDj("A2");
            tsc10002Bean.setZlbz("1、独立包装后单冻，冷库温度—30℃以下；<br/>2、人工修剪边皮；<br/>3、产品解冻失水率(包冰率)≤6%；<br/>4、单个产品规格净重±5g；<br/>5、完整度95%以上；");
            tsc10002Bean.setSl("5");
            tsc10002Bean.setXs("500");

            tsc10002Bean.setBhlaj("9.2");
            tsc10002Bean.setCb("0.2");
            tsc10002Bean.setLaj("9.4");
            tsc10002Bean.setYf("0.4");
            tsc10002Bean.setDaj("9.8");

            tsc10002Bean.setBzj("9.8");
            tsc10002Bean.setHz("49000");
            tsc10002Bean.setBz("");

            TSC10002Bean tsc10002Bean2 = new TSC10002Bean();

            tsc10002Bean2.setXuhao("2");
            tsc10002Bean2.setYjfl("鸭产品");
            tsc10002Bean2.setEjfl("分割品");
            tsc10002Bean2.setXsm("带皮鸭胸");
            tsc10002Bean2.setXm("带皮鸭胸");
            tsc10002Bean2.setSm("");
            tsc10002Bean2.setTz("220-240g");

            tsc10002Bean2.setJz("10");
            tsc10002Bean2.setGg("10kg*1");
            tsc10002Bean2.setDj("A2");
            tsc10002Bean2.setZlbz("1、独立包装后单冻，冷库温度—30℃以下；<br/>2、人工修剪边皮；<br/>3、产品解冻失水率(包冰率)≤6%；<br/>4、单个产品规格净重±5g；5、完整度95%以上；");
            tsc10002Bean2.setSl("5");
            tsc10002Bean2.setXs("500");

            tsc10002Bean2.setBhlaj("9.2");
            tsc10002Bean2.setCb("0.2");
            tsc10002Bean2.setLaj("9.4");
            tsc10002Bean2.setYf("0.4");
            tsc10002Bean2.setDaj("9.8");

            tsc10002Bean2.setBzj("9.8");
            tsc10002Bean2.setHz("49000");
            tsc10002Bean2.setBz("");


            TSC10002Bean tsc10002Bean23 = new TSC10002Bean();

            tsc10002Bean23.setXuhao("");
            tsc10002Bean23.setYjfl("");
            tsc10002Bean23.setEjfl("");
            tsc10002Bean23.setXsm("");
            tsc10002Bean23.setXm("");
            tsc10002Bean23.setSm("");
            tsc10002Bean23.setTz("");

            tsc10002Bean23.setJz("");
            tsc10002Bean23.setGg("");
            tsc10002Bean23.setDj("");
            tsc10002Bean23.setZlbz("");
            tsc10002Bean23.setSl("");
            tsc10002Bean23.setXs("");

            tsc10002Bean23.setBhlaj("");
            tsc10002Bean23.setCb("");
            tsc10002Bean23.setLaj("");
            tsc10002Bean23.setYf("");
            tsc10002Bean23.setDaj("");

            tsc10002Bean23.setBzj("");
            tsc10002Bean23.setHz("");
            tsc10002Bean23.setBz("");


            lists.add(tsc10002Bean2);
            lists.add(tsc10002Bean);

            model.addAttribute("list",tsc10001Bean1);
            model.addAttribute("lists",lists);
        }
        return "ds/TSC10002";
    }




}
