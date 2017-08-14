package com.msk.ds.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.TSC10004Bean;
import com.msk.ds.bean.TSC20041Bean;
import com.msk.ds.logic.TSC20041Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TSC20041Controller
 *
 * @author gyh
 *
 */
@Controller
@RequestMapping("TSC20041")
public class TSC20041Controller extends BaseController {

    @Autowired
    private TSC20041Logic tsc20041Logic;
    /**
     * 实例化页面
     *
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init() {
        return "ds/TSC20041";
    }

    /**
     * 实例化页面
     *
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "initPrint",
            method = RequestMethod.POST)
    public String initPrint() {
        return "ds/TSC20043";
    }
    /**
     * 实例化页面
     *
     * @return 界面
     * @author gyh
     */
    @RequestMapping(value = "initDetail",
            method = RequestMethod.POST)
    public String initDetail() {
        return "ds/TSC20042";
    }
    /**
     * 查询列表数据
     * @param pageParam 分页参数
     * @return PageResult
     * @author gyh
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public @ResponseBody
    PageResult<TSC20041Bean> search(BasePageParam pageParam) {
        return this.tsc20041Logic.findInfo();
    }
}
