package com.msk.so.controller;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.SystemConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.base.BaseController;
import com.msk.so.bean.SO151202Bean;
import com.msk.so.bean.SO151401Bean;
import com.msk.so.logic.SO151202Logic;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 分销正常库存
 */
@Controller
@RequestMapping("SO151202")
@SessionAttributes("param")
public class SO151202Controller extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SO151202Controller.class);

    @Autowired
    private SO151202Logic SO151202Logic;

    /**
     * 加载卖家库存管理页面
     *
     * @return String
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(BasePageParam param, Model model) {
        model.addAttribute("param", param);
        logger.debug("初始化页面");
        return "so/SO151202";
    }

    /**
     * @param basePageParam basePageParam
     * @return PageResult<SO151202Bean>
     */
    @RequestMapping(value = "search",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SO151202Bean> search(BasePageParam basePageParam) {
        DbUtils.buildLikeCondition(basePageParam, "lgcsCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "lgcsName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "warehouseName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "warehouseCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slCodeDis", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "pdCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "pdName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(basePageParam, "salePlatform", DbUtils.LikeMode.FRONT);

        if (isDebug) {
            logger.info("假数据");
            // 获取假数据
        }
        logger.info("查询数据库");
        return this.SO151202Logic.findPage(basePageParam, SO151202Bean.class);
    }

    /**
     * 库存保存
     */
    @RequestMapping(value = "save",
            method = RequestMethod.POST)
    public
    @ResponseBody
    String save(String stockId, String stockQty) {
        BasePageParam param = new BasePageParam();
        param.setFilter("stockId",stockId);
        param.setFilter("stockQty", stockQty);
        int result = this.SO151202Logic.saveStockSL(param);
        if(result > 0) {
            return SystemConst.RsStatus.SUCCESS;
        } else {
            return SystemConst.RsStatus.FAIL;
        }
    }



    @RequestMapping(value = "exportStock",
            method = RequestMethod.POST)
    public void exportStock(BasePageParam basePageParam,SO151202Bean bean, HttpServletResponse response) throws IOException {
        basePageParam.getFilterMap().put("lgcsCode",bean.getLgcsCode());
        basePageParam.getFilterMap().put("warehouseCode",bean.getWarehouseCode());
        basePageParam.getFilterMap().put("salePlatform",bean.getSalePlatform());
        basePageParam.getFilterMap().put("slCode",bean.getSlCode());
        basePageParam.getFilterMap().put("pdCode",bean.getPdCode());
        basePageParam.getFilterMap().put("lgcsName",bean.getLgcsName());
        basePageParam.getFilterMap().put("warehouseName",bean.getWarehouseName());
        basePageParam.getFilterMap().put("slName",bean.getSlName());
        basePageParam.getFilterMap().put("pdName",bean.getPdName());

        DbUtils.buildLikeCondition(basePageParam, "lgcsCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "lgcsName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "warehouseName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "warehouseCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slCodeDis", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "slName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "pdCode", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "pdName", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(basePageParam, "salePlatform", DbUtils.LikeMode.FRONT);
        logger.info("查询数据库");

        basePageParam.setPaging(false);
        PageResult<SO151202Bean> result = this.SO151202Logic.findPage(basePageParam, SO151202Bean.class);
        Workbook workbook= this.SO151202Logic.exprotStock(result.getData());
        Date date= DateTimeUtil.getCustomerDate();
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr=sf.format(date);
        OutputStream o =response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename="+ "seller_stock-"+dateStr+".xlsx");// the dialogbox of download file.
        response.setContentType("application/vnd.ms-excel");// set the MIME type.
        workbook.write(o);
    }
}
