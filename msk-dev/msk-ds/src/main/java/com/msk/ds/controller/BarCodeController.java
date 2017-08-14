package com.msk.ds.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.TempBarcode;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.ds.logic.BarCodeLogic;

/**
 * 条码列表
 *
 * @author yuan_chen
 */
@Controller
@RequestMapping("BarCode")
public class BarCodeController extends BaseController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BarCodeController.class);

    @Autowired
    private BarCodeLogic barCodeLogic;

    /**
     * 初始化页面
     *
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "init",
        method = RequestMethod.POST)
    public String init(Model model) {
        String environment = ConfigManager.getSystemEnvTitle();
        if(StringUtil.isNullOrEmpty(environment)){
            environment = "PROD";
        }else{
            environment = environment.toUpperCase();
        }
        model.addAttribute("environment", environment);
        return "ds/BarCode";
    }

    /**
     * 分页查询数据
     *
     * @param param pageParam
     * @return 分页查询数据
     */
    @RequestMapping(value = "search",
        method = RequestMethod.POST)
    public @ResponseBody PageResult<TempBarcode> search(BasePageParam param) {
        DbUtils.buildLikeCondition(param, "brand", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "grade", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "barcode", DbUtils.LikeMode.PARTIAL);
        DbUtils.buildLikeCondition(param, "readcode", DbUtils.LikeMode.PARTIAL);
        return barCodeLogic.findPage(param, TempBarcode.class);
    }

    /**
     * 新增
     *
     * @param bean bean
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "save",
        method = RequestMethod.POST)
    public String save(TempBarcode bean, Model model) {
        super.setCommonParam(bean);
        if (StringUtil.isNullOrEmpty(bean.getBarcodeId())) {
            UUID uuid = UUID.randomUUID();
            bean.setBarcodeId(String.valueOf(uuid));
        }
        bean.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
        bean.setCrtTime(DateTimeUtil.getCustomerDate());
        bean.setActTime(DateTimeUtil.getCustomerDate());
        bean.setUpdTime(DateTimeUtil.getCustomerDate());
        bean.setVer(NumberConst.IntDef.INT_ONE);
        int result = barCodeLogic.save(bean);
        if (result == NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("新增失败!");
        }
        return "ds/BarCode";
    }

    /**
     * 删除
     *
     * @param bean bean
     * @param model Model
     * @return 页面
     */
    @RequestMapping(value = "delete",
        method = RequestMethod.POST)
    public String delete(TempBarcode bean, Model model) {
        super.setCommonParam(bean);
        bean.setUpdTime(DateTimeUtil.getCustomerDate());
        int result = barCodeLogic.delete(bean);
        if (result == NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("删除失败,未找到该数据!");
        }
        return "ds/BarCode";
    }
}
