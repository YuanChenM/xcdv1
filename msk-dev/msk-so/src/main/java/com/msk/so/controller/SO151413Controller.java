package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.so.logic.SO151413Logic;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SO151413Controller
 *
 * @author sjj
 * @version 1.0
 */
@Controller
@RequestMapping("SO151413")
@SessionAttributes("param")
public class SO151413Controller extends BaseController {
    /**
     * logger
     *
     * @author sjj
     */
    private static Logger logger = LoggerFactory.getLogger(SO151413Controller.class);

    @Autowired
    private SO151413Logic so151413Logic;

    /**
     * 页面初始化
     *
     * @return String
     */
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init() {
        return "so/SO151413";
    }

    /**
     * 报表导出
     *
     * @param basePageParam
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "exportOrder", method = RequestMethod.POST)
    public void exportOrder(BasePageParam basePageParam, HttpServletResponse response, String slShowName,
                            String pdCode) throws Exception {
        basePageParam.getFilterMap().put("slShowName", slShowName);
        basePageParam.getFilterMap().put("pdCode", pdCode);

        Workbook workbook = this.so151413Logic.exportOrder(basePageParam);
        Date date = DateTimeUtil.getCustomerDate();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sf.format(date);
        OutputStream o = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=" + "BuyerStock-" + dateStr + ".xlsx");// the dialogbox of download file.
        response.setContentType("application/vnd.ms-excel");// set the MIME type.
        workbook.write(o);
    }
}