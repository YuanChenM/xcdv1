package com.msk.ds.controller;

import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC1000501Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 市场需求审核注册修改添加controller
 *
 * @author pxg
 */
@Controller
@RequestMapping(value = "TSC20034")
public class TSC20034Controller extends BaseController {

    /**
     * 实例化页面
     *
     * @param model model
     * @return 界面
     * @author pxg
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model,String type) {
        //查询发货单详细
        String address=null;
        if(!StringUtil.isNullOrEmpty(type) && "1".equals(type)){
            address="ds/TSC20034";
        }else if(!StringUtil.isNullOrEmpty(type) && "2".equals(type)){
            address="ds/TSC20035";
        }
        else if(!StringUtil.isNullOrEmpty(type) && "3".equals(type)){
            address="ds/TSC20036";
        }
        return address;
    }
}
