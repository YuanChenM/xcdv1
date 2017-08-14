package com.msk.ds.controller;

import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.DsSlPdLot;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.ds.bean.DS174102Param;
import com.msk.ds.logic.DS174101Logic;
import com.msk.ds.logic.DS174102Logic;
import com.msk.so.bean.StockParam;
import com.msk.so.logic.StockLogic;

/**
 * DS174102Controller
 *
 * @author yuan_chen
 *
 */
@Controller
@RequestMapping("DS174102")
public class DS174102Controller extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(DS174102Controller.class);

    /**
     * 注入DS174101Logic代理类
     */
    @Autowired
    private DS174101Logic ds174101Logic;
    @Autowired
    private StockLogic stockLogic;

    /**
     * 注入DS174102Logic代理类
     */
    @Autowired
    private DS174102Logic myLogic;

    @RequestMapping(value = "init/{lotId}",
        method = RequestMethod.POST)
    public String init(@PathVariable("lotId") String lotId, Model model) {
        logger.debug("批次编号生成画面初始化");

        DS174102Param param = new DS174102Param();
        param.getFilterMap().put("lotId", lotId);
        DsSlPdLot dsSlPdLot = ds174101Logic.findOne(param);
        String lotCode = ds174101Logic.getLotCode(dsSlPdLot);

        model.addAttribute("lotId", lotId);
        model.addAttribute("lotCode", lotCode);
        model.addAttribute("dsSlPdLot", dsSlPdLot);

        return "ds/DS174102";
    }

    /**
     *
     * 保存数据
     * 
     * @param param dsSlPdLot
     * @param model model
     * @return 实例化
     */
    @RequestMapping(value = "save",
        method = RequestMethod.POST)
    public String save(DS174102Param param, Model model) {
        int saveNum = this.myLogic.batchSave(param);
        // 更新库存
        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("lotId", param.getLotId());
        DsSlPdLot dp = this.ds174101Logic.findOne(baseParam);
        StockParam stockParam = new StockParam();
        stockParam.setLgcsCode(dp.getLgcsCode());
        stockParam.setLgcsName(dp.getLgcsName());
        stockParam.setWarehouseCode("01");
        stockParam.setWarehouseName("神龙客仓库");
        stockParam.setStockType(NumberConst.IntDef.INT_ONE);
        stockParam.setSlCode("0110188888");
        stockParam.setSlName("神农客");
        stockParam.setSupplierCode(dp.getSlCode());
        stockParam.setSupplierName(dp.getSlName());
        stockParam.setClassesName(dp.getClassesName());
        stockParam.setClassesCode(dp.getClassesCode());
        stockParam.setBreedCode(dp.getBreedCode());
        stockParam.setBreedName(dp.getBreedName());
        stockParam.setFeatureName(dp.getFeatureName());
        stockParam.setFeatureCode(dp.getFeatureCode());
        stockParam.setNormsCode(dp.getPkgCode());
        stockParam.setNormsName(dp.getPkgSpec());
        stockParam.setPdCode(dp.getPdCode());
        stockParam.setPdName(dp.getPdName());
        stockParam.setPdLevel(dp.getGradeCode());
        stockParam.setStockNum(StringUtil.toBigDecimal(saveNum));
        stockParam.setUnit("箱");
        stockParam.setDelFlg("0");
        stockParam.setCrtId("admin");
        stockParam.setCrtTime(DateTimeUtil.getCustomerDate());
        stockParam.setUpdId("admin");
        stockParam.setUpdTime(DateTimeUtil.getCustomerDate());
        stockParam.setActId("admin");
        stockParam.setActTime(DateTimeUtil.getCustomerDate());
        stockParam.setVer(NumberConst.IntDef.INT_ONE);
        stockLogic.increaseStock(stockParam);
        if (saveNum != StringUtil.toInteger(param.getLotNum())) {
            // 影响数量不正确,抛出业务异常
            String msg = "插入数量不正确,应插入";
            msg = msg.concat(param.getLotNum());
            msg = msg.concat("条,实际插入");
            msg = msg.concat(String.valueOf(saveNum));
            msg = msg.concat("条!");
            throw new BusinessException(msg);
        }
        return this.init(String.valueOf(param.getLotId()), model);
    }

    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search/{lotId}",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<DsSlPdLot> search(@PathVariable("lotId") String lotId, DS174102Param param) {
        logger.debug("卖家产品列表查询");
        param.setLotId(lotId);
        DbUtils.buildLikeCondition(param, "lotCode", DbUtils.LikeMode.FRONT);
        return myLogic.findPage(param, DsSlPdLot.class);
    }
}
