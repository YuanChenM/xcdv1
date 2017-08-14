package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.PdTncStdDiscussProvider;
import com.msk.core.entity.SlPdTncStdNew;
import com.msk.core.entity.SlProduct;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.*;
import com.msk.sl.logic.SL241106Logic;
import com.msk.sl.logic.SL241117Logic;
import com.msk.sl.logic.SL241119Logic;
import com.msk.sl.logic.Sl241116Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * SL241117Controller
 *
 * @author gyh
 */
@Controller
@RequestMapping("SL241117")
public class SL241117Controller extends BaseController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SL241117Controller.class);

    @Autowired
    private SL241117Logic sl241117Logic;
    @Autowired
    private Sl241116Logic sl241116Logic;
    @Autowired
    private CommonLogic commonLogic;

    /**
     * 初始化卖家产品加工质量标准设置
     *
     * @param sl241116Bean sl241116Bean
     * @param model        model
     * @return 加工质量标准页面
     * @author gyh
     */
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(SL241116Bean sl241116Bean, Model model) {
        logger.debug("卖家产品加工质量标准页面初始化");
        model.addAttribute("sl241116Bean", sl241116Bean);
        BaseParam param = new BaseParam();
        param.setFilter("classesCode", sl241116Bean.getPdClassesCode());
        param.setFilter("machiningCode", sl241116Bean.getMachiningCode());
        param.setFilter("breedCode", sl241116Bean.getPdBreedCode());
        param.setFilter("featureCode", sl241116Bean.getPdFeatureCode());
        param.setFilter("slCode", sl241116Bean.getSlCode());
        param.getFilterMap().put("slPdId", sl241116Bean.getSlPdId());
        List<SL241117Bean> sl241117Beans;
        if (isDebug) {
            sl241117Beans = sl241117Logic.getTncStdTestData();
        } else {
            sl241117Beans = sl241117Logic.getTncStd(param);
            if (CollectionUtils.isEmpty(sl241117Beans) || sl241117Beans.size() < 1) {
                param.getFilterMap().remove("featureCode");
                sl241117Beans = sl241117Logic.getTncStd(param);
                if (CollectionUtils.isEmpty(sl241117Beans) || sl241117Beans.size() < 1) {
                    throw new BusinessException("该产品不存在加工质量标准！");
                }
            }
        }
        model.addAttribute("sL241117Beans", sl241117Beans);
        return "sl/SL241117";
    }

    /**
     * 保存标准值数据
     *
     * @param sl241117Param sl241117Param
     * @param model         model
     * @return 实例化
     * @author gyh
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public
    @ResponseBody
    String save(SL241117Param sl241117Param, Model model) {
        //修改产品的加工质量等级
        SlProduct slProduct = new SlProduct();
        slProduct.setSlPdId(sl241117Param.getSlPdId());
        slProduct.setSlCode(sl241117Param.getSlCode());
        slProduct.setSlTncGradeCode(Integer.parseInt(sl241117Param.getAgreeFlg()));
        super.setCommonParam(slProduct);
        sl241117Logic.modifySlProduct(slProduct);
        BaseParam param = new BaseParam();
        //根据卖家编码、卖家产品id、产品标准ID、产品标准项目ID查询卖家该产品加工质量标准是否存在，存在则修改，不存在则新增
        param.setFilter("slCode", sl241117Param.getSlCode());
        param.getFilterMap().put("slPdId", sl241117Param.getSlPdId());
        param.getFilterMap().put("standardId", sl241117Param.getStandardId());
        String[] contentArray = sl241117Param.getContentArray();
        String[] checkArray = sl241117Param.getCheckArray();
        String[] pdTncTdItemIdArray = sl241117Param.getPdTncStdItemIdArray();
        for (int i = 0; i < pdTncTdItemIdArray.length; i++) {
            param.getFilterMap().put("stdItemId", pdTncTdItemIdArray[i]);
            List<SlPdTncStdNew> news = sl241117Logic.findSlPdTncStdNew(param);
            SlPdTncStdNew stdNew = new SlPdTncStdNew();
            if (!CollectionUtils.isEmpty(news)) {
                //修改
                stdNew = news.get(0);
                super.setCommonParam(stdNew);
                stdNew.setAgreeFlg(checkArray[i]);
                String stdVal = contentArray[i];
                stdVal = stdVal.replace("\r\n", "<br/>");
                stdNew.setStdVal(stdVal);
                if (null!=stdNew.getVer()) {
                    stdNew.setVer(stdNew.getVer() + 1);
                } else {
                    stdNew.setVer(1);
                }
                sl241117Logic.modify(stdNew);
            } else {
                //新增
                stdNew = sl241117Param;
                super.setCommonParam(stdNew);
                stdNew.setAgreeFlg(checkArray[i]);
                stdNew.setStdVal(contentArray[i]);
                stdNew.setVer(1);
                stdNew.setDelFlg("0");
                stdNew.setStdItemId(pdTncTdItemIdArray[i]);
                sl241117Logic.save(stdNew);
            }
            if ("0".equals(checkArray[i])) {
                PdTncStdDiscussProvider provide = new PdTncStdDiscussProvider();
                provide.setStandardId(sl241117Param.getStandardId().longValue());
                provide.setSlPdId(sl241117Param.getSlPdId());
                provide.setTncStdItemId(sl241117Param.getStdItemId());
                provide.setTncStdVal(contentArray[i]);
                provide.setProviderCode(sl241117Param.getSlCode());
                provide.setProviderName(sl241117Param.getSlShowName());
                provide.setDiscussStatus(0);
                stdNew.setStdItemId(pdTncTdItemIdArray[i]);
                provide.setVer(1);
                provide.setKeyId(commonLogic.maxId("PD_TNC_STD_DISCUSS_PROVIDER", "KEY_ID"));
                provide.setDelFlg("0");
                super.setCommonParam(provide);
                sl241117Logic.saveNotAgree(provide);
                slProduct.setSlTncGradeCode(5);
                sl241117Logic.modifySlProduct(slProduct);
            }
        }
        //全部同意判断其他标准是否符合要求
        BasePageParam basePageParam = new BasePageParam();
        basePageParam.setPaging(false);
        basePageParam.getFilterMap().put("slPdId", sl241117Param.getSlPdId());
        basePageParam.getFilterMap().put("slCode", sl241117Param.getSlCode());
        String checkRs=sl241117Logic.checkAgree(basePageParam);
        if ("1".equals(checkRs)) {
            //修改卖家产品为试销
//            slProduct.setStatus("4");
//            this.sl241116Logic.upSlPdStatus(slProduct);
        } else {
            //修改卖家产品为论证中
            slProduct.setStatus("2");
            this.sl241116Logic.upSlPdStatus(slProduct);
        }
        return "1";
    }

}
