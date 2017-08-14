package com.msk.ds.controller;


import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC30001Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 市场需求审核注册修改添加controller
 *
 * @author XHY
 */
@Controller
@RequestMapping(value = "TSC20051")
public class TSC20051Controller extends BaseController {


    /**
     * 实例化页面
     *
     * @param model model
     * @return 界面
     * @author pxg
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model) {
        return "ds/TSC20051";
    }

    /**
     * 查询页面显示数据
     *
     * @return
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<TSC30001Bean> search() {

        PageResult<TSC30001Bean> bean = new PageResult<TSC30001Bean>();
        List<TSC30001Bean> list = new ArrayList<TSC30001Bean>();
        TSC30001Bean bean1 = new TSC30001Bean();
        bean1.setJsCode("1");
        bean1.setBargainCode("20160607001001");
        bean1.setBargainName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean1.setPlantName("河北某某畜禽养殖有限公司");
        bean1.setEffectTime("2016-3-20");
        bean1.setStateHt("已核销");
        TSC30001Bean bean2 = new TSC30001Bean();
        bean2.setJsCode("2");
        bean2.setBargainCode("20160607001002");
        bean2.setBargainName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean2.setPlantName("山东荣达农业发展有限公司");
        bean2.setEffectTime("2016-3-20");
        bean2.setStateHt("未核销");

        TSC30001Bean bean3 = new TSC30001Bean();
        bean3.setJsCode("3");
        bean3.setBargainCode("20160607001003");
        bean3.setBargainName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean3.setPlantName("山东硕昌食品有限公司");
        bean3.setEffectTime("2016-3-20");
        bean3.setStateHt("未核销");


        TSC30001Bean bean4 = new TSC30001Bean();
        bean4.setJsCode("4");
        bean4.setBargainCode("20160607001004");
        bean4.setBargainName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean4.setPlantName("萧县强英食品有限公司");
        bean4.setEffectTime("2016-3-20");
        bean4.setStateHt("未核销");

        TSC30001Bean bean5 = new TSC30001Bean();
        bean5.setJsCode("5");
        bean5.setBargainCode("20160607001005");
        bean5.setBargainName("2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标");
        bean5.setPlantName("寿光市圣德隆食品有限公司");
        bean5.setEffectTime("2016-3-20");
        bean5.setStateHt("未核销");

        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);

        bean.setRecordsTotal(list.size());
        bean.setData(list);
        return bean;
    }
}
