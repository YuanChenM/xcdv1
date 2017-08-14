package com.msk.plr.controller;

import com.msk.core.bean.PageResult;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseController;
import com.msk.plr.bean.PLR170201Bean;
import com.msk.plr.bean.PLR170201Param;
import com.msk.plr.logic.PLR170201Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * PC端财务人员计费查看Controller.
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "PLR170201")
public class PLR170201Controller extends BaseController {

    @Autowired
    private PLR170201Logic plr170201Logic;

    /**
     * 实例化页面
     *
     * @return 卖家审批审核页面
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init() {
        return "/plr/PLR170201";
    }

    /**
     * 实例化页面
     *
     * @return 卖家审批审核页面
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<PLR170201Bean> search(PLR170201Param param) {
        return plr170201Logic.findPage(param, PLR170201Bean.class);
    }
    /** #1931,create by likai on 2016/8/17 start */
    /**
     * 导出excel
     *
     * @param
     * @param response
     */
    @RequestMapping(value = "exportData", method = RequestMethod.POST)
    public void export(PLR170201Param param, HttpServletResponse response) throws IOException {
        String fileName = "result_" + DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, DateTimeUtil.getCustomerDate()) + ".xlsx";
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "ISO8859-1"));
        OutputStream outputStream = response.getOutputStream();
        plr170201Logic.exportData(outputStream, param);

    }

    /**
     * 查询合伙人
     *
     * @param param 参数
     * @return 结果
     */
    @RequestMapping(value = "findPartner",
            method = RequestMethod.POST)
    public
    @ResponseBody
    List<PLR170201Bean> findPartner(PLR170201Param param) {
        return plr170201Logic.findPartner(param);
    }

    /**
     * 查询合伙人
     *
     * @param param 参数
     * @return 结果
     */
    @RequestMapping(value = "findTerminal",
            method = RequestMethod.POST)
    public
    @ResponseBody
    List<PLR170201Bean> findTerminal(PLR170201Param param) {
        return plr170201Logic.findTerminal(param);
    }

    /**
     * 查询买手
     *
     * @param param 参数
     * @return 结果
     */
    @RequestMapping(value = "findBs",
            method = RequestMethod.POST)
    public
    @ResponseBody
    List<PLR170201Bean> findBs(PLR170201Param param) {
        return plr170201Logic.findBs(param);
    }


}
