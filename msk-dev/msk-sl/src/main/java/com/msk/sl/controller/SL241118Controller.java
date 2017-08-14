package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.PdMctStdDiscussProvider;
import com.msk.core.entity.SlPdMctStdNew;
import com.msk.core.entity.SlProduct;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseController;
import com.msk.sl.bean.SL241116Bean;
import com.msk.sl.bean.SL241118Bean;
import com.msk.sl.bean.SL241118Param;
import com.msk.sl.logic.SL241117Logic;
import com.msk.sl.logic.SL241118Logic;
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
 * SL241118Controller
 *
 * @author gyh
 */
@Controller
@RequestMapping("SL241118")
public class SL241118Controller extends BaseController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SL241118Controller.class);

    @Autowired
    private SL241118Logic sl241118Logic;
    @Autowired
    private SL241117Logic sl241117Logic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private Sl241116Logic sl241116Logic;

    /**
     * 初始化卖家产品加工技术标准
     *
     * @param sl241116Bean sl241116Bean
     * @param model        model
     * @return 技术标准
     * @author gyh
     */
    @RequestMapping(value = "init", method = RequestMethod.POST)
    public String init(SL241116Bean sl241116Bean, Model model) {
        logger.debug("卖家产品加工技术标准页面初始化");
        model.addAttribute("sl241116Bean", sl241116Bean);
        BaseParam param = new BaseParam();
        param.setFilter("classesCode", sl241116Bean.getPdClassesCode());
        param.setFilter("machiningCode", sl241116Bean.getMachiningCode());
        param.setFilter("breedCode", sl241116Bean.getPdBreedCode());
        param.setFilter("featureCode", sl241116Bean.getPdFeatureCode());
        param.setFilter("slCode", sl241116Bean.getSlCode());
        param.getFilterMap().put("slPdId", sl241116Bean.getSlPdId());
        List<SL241118Bean> sl241118Beans = null;
        if (isDebug) {
//            qltStdClas = sl241118Logic.findListByStandardId();
        } else {
            //根据一类、二类、品种和特征查询加工技术标准
            sl241118Beans = sl241118Logic.getMctStd(param);
            if (CollectionUtils.isEmpty(sl241118Beans) || sl241118Beans.size() < 1) {
                param.getFilterMap().remove("featureCode");
                sl241118Beans = sl241118Logic.getMctStd(param);
                if (CollectionUtils.isEmpty(sl241118Beans) || sl241118Beans.size() < 1) {
                    throw new BusinessException("该产品不存在加工技术标准！");
                }
            }
        }
        model.addAttribute("sL241118Beans", sl241118Beans);
        return "sl/SL241118";
    }

    /**
     * 保存加工技术标准
     *
     * @param sl241118Param sl241118Param
     * @param model         model
     * @return 实例化
     * @author gyh
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public
    @ResponseBody
    String save(SL241118Param sl241118Param, Model model) {
        //修改产品的加工技术标准等级
        SlProduct slProduct = new SlProduct();
        slProduct.setSlPdId(sl241118Param.getSlPdId());
        slProduct.setSlCode(sl241118Param.getSlCode());
        slProduct.setSlQltGradeCode(Integer.parseInt(sl241118Param.getAgreeFlg()));
        super.setCommonParam(slProduct);
        sl241118Logic.modifySlProduct(slProduct);
        BaseParam param = new BaseParam();
        //根据卖家编码、卖家产品id、产品标准ID、产品标准项目ID查询卖家该产品加工质量标准是否存在，存在则修改，不存在则新增
        param.setFilter("slCode", sl241118Param.getSlCode());
        param.getFilterMap().put("slPdId", sl241118Param.getSlPdId());
//        param.getFilterMap().put("standardId", sl241118Param.getStandardId());

        String[] contentArray = sl241118Param.getContentArray();
        String[] checkArray = sl241118Param.getCheckArray();
        String[] pdMctStdItemIdArray = sl241118Param.getPdMctStdItemIdArray();
        for (int i = 0; i < pdMctStdItemIdArray.length; i++) {
            param.getFilterMap().put("stdItemId", pdMctStdItemIdArray[i]);
            List<SlPdMctStdNew> news = sl241118Logic.findSlPdMctStdNew(param);
            SlPdMctStdNew stdNew = new SlPdMctStdNew();
            if (!CollectionUtils.isEmpty(news)) {
                //修改
                stdNew = news.get(0);
                super.setCommonParam(stdNew);
                stdNew.setAgreeFlg(checkArray[i]);
                stdNew.setStdVal(contentArray[i]);
                if (null!=stdNew.getVer()) {
                    stdNew.setVer(stdNew.getVer() + 1);
                } else {
                    stdNew.setVer(1);
                }
                sl241118Logic.modify(stdNew);
            } else {
                //新增
                stdNew = sl241118Param;
                super.setCommonParam(stdNew);
                stdNew.setAgreeFlg(checkArray[i]);
                stdNew.setStdVal(contentArray[i]);
                stdNew.setVer(1);
                stdNew.setDelFlg("0");
                stdNew.setStdItemId(pdMctStdItemIdArray[i]);
                sl241118Logic.save(stdNew);
            }
            if ("0".equals(checkArray[i])) {
                PdMctStdDiscussProvider provide = new PdMctStdDiscussProvider();
                provide.setStandardId(sl241118Param.getStandardId().longValue());
                provide.setSlPdId(sl241118Param.getSlPdId());
                provide.setMctStdItemId(sl241118Param.getStdItemId());
                provide.setMctStdVal(contentArray[i]);
                provide.setProviderCode(sl241118Param.getSlCode());
                provide.setProviderName(sl241118Param.getSlShowName());
                provide.setDiscussStatus(0);
                stdNew.setStdItemId(pdMctStdItemIdArray[i]);
                provide.setVer(1);
                provide.setKeyId(commonLogic.maxId("PD_MCT_STD_DISCUSS_PROVIDER", "KEY_ID"));
                provide.setDelFlg("0");
                super.setCommonParam(provide);
                sl241118Logic.saveNotAgree(provide);
                slProduct.setSlQltGradeCode(5);
                sl241118Logic.modifySlProduct(slProduct);
            }
        }
        //全部同意判断其他标准是否符合要求
        BasePageParam basePageParam = new BasePageParam();
        basePageParam.setPaging(false);
        basePageParam.getFilterMap().put("slPdId", sl241118Param.getSlPdId());
        basePageParam.getFilterMap().put("slCode", sl241118Param.getSlCode());
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
