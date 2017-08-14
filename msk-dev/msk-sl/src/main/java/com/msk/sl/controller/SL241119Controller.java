package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.PdNormsStd;
import com.msk.core.entity.PdStandard;
import com.msk.core.entity.SlPdPkg;
import com.msk.core.entity.SlProduct;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.pd.logic.ProductLogic;
import com.msk.sl.bean.SL241116Bean;
import com.msk.sl.bean.SL241118Param;
import com.msk.sl.bean.SL241119Bean;
import com.msk.sl.bean.SL241119Param;
import com.msk.sl.logic.SL241117Logic;
import com.msk.sl.logic.SL241119Logic;
import com.msk.sl.logic.Sl241116Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 产品包装信息controller
 *
 * @author pxg
 */
@Controller
@RequestMapping("SL241119")
public class SL241119Controller extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SL241119Controller.class);
    @Autowired
    private SL241119Logic sl241119Logic;
    @Autowired
    private SL241117Logic sl241117Logic;
    @Autowired
    private ProductLogic productLogic;

    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private Sl241116Logic sl241116Logic;


    /**
     * 进入列表页面*
     *
     * @param model        model
     * @param sl241116Bean 产品标准ID
     * @return "pd/PD141111"页面
     * @author pxg
     */
    @RequestMapping(value = "init",
            method = RequestMethod.POST)
    public String init(Model model, SL241116Bean sl241116Bean) {
        model.addAttribute("sl241116Bean", sl241116Bean);
        BaseParam param = new BaseParam();
        param.setFilter("classesCode", sl241116Bean.getPdClassesCode());
        param.setFilter("breedCode", sl241116Bean.getPdBreedCode());
        param.setFilter("featureCode", sl241116Bean.getPdFeatureCode());
        param.setFilter("machiningCode", sl241116Bean.getMachiningCode());
        param.setFilter("weightCode", sl241116Bean.getWeightCode());
        List<PdStandard> pdStandardList = sl241117Logic.findStandardInfo(param);
        if (CollectionUtils.isEmpty(pdStandardList) || pdStandardList.size() < 1) {
            throw new BusinessException("该产品不存在卫生标准！");
        }
        model.addAttribute("standardId", pdStandardList.get(0).getStandardId());
        return "sl/SL241119";
    }

    /**
     * 查询列表数据*
     *
     * @param pageParam 分页参数
     * @return PageResult
     * @author pxg
     */
    @RequestMapping(value = "search/{standardId}",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SL241119Bean> search(@PathVariable(value = "standardId") String standardId, BasePageParam pageParam) {
        logger.debug("产品包装检索");
        pageParam.setFilter("standardId", standardId);
        return sl241119Logic.findPage(pageParam, SL241119Bean.class);
    }

    /**
     * 保存标准值数据
     *
     * @param sl241119Param sl241119Param
     * @param model         model
     * @return 实例化
     * @author gyh
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public
    @ResponseBody
    String save(SL241119Param sl241119Param, Model model) {
        BasePageParam param = new BasePageParam();
        param.setPaging(false);
        param.setFilter("classesCode", sl241119Param.getClassesCode());
        param.setFilter("breedCode", sl241119Param.getBreedCode());
        param.setFilter("featureCode", sl241119Param.getFeatureCode());
        param.setFilter("machiningCode", sl241119Param.getMachiningCode());
        param.setFilter("weightCode", sl241119Param.getWeightCode());
        param.setFilter("slCode", sl241119Param.getSlCode());
        param.getFilterMap().put("standardId", sl241119Param.getStandardId());
        param.getFilterMap().put("slPdId", sl241119Param.getSlPdId());
        String[] normsArray = sl241119Param.getNormsArray();
        if(normsArray==null||normsArray.length<1){
            throw new BusinessException("请选择产品包装！");
        }
        for (int i = 0; i < normsArray.length; i++) {
            param.setFilter("normsCode", normsArray[i]);
            List<SL241119Bean> sl241119Beans = sl241119Logic.findPageList(param, SL241119Bean.class);
            if (!CollectionUtils.isEmpty(sl241119Beans) && sl241119Beans.size() > 0) {
                if (sl241119Beans.get(0).getSlPdPkgId() != null) {
                    continue;
                }
            }
            List<PdNormsStd> normsStds = productLogic.findPdNormsStd(param);
            if (!CollectionUtils.isEmpty(normsStds)) {
                for (PdNormsStd pdNormsStd : normsStds) {
                    SlPdPkg slPdPkg = new SlPdPkg();
                    slPdPkg.setSlCode(sl241119Param.getSlCode());
                    slPdPkg.setSlPdId(sl241119Param.getSlPdId());
                    slPdPkg.setSlPdPkgId(commonLogic.maxId("sl_pd_pkg", "SL_PD_PKG_ID").intValue());
                    slPdPkg.setPkgCode(pdNormsStd.getNormsCode());
                    slPdPkg.setProdEpId(sl241119Param.getProdEpId());
                    slPdPkg.setStandardId(sl241119Param.getStandardId());
                    slPdPkg.setBrandEpId(sl241119Param.getBrandEpId());
                    slPdPkg.setBrandId(sl241119Param.getBrandId());
                    slPdPkg.setPdClassesCode(sl241119Param.getClassesCode());
                    slPdPkg.setPdBreedCode(sl241119Param.getBreedCode());
                    slPdPkg.setPdFeatureCode(sl241119Param.getFeatureCode());
                    slPdPkg.setInSglNw(pdNormsStd.getNormsSuttle());
                    slPdPkg.setInSglNwRange(pdNormsStd.getNormsError());
                    slPdPkg.setInNw(pdNormsStd.getNetweightInner());
                    slPdPkg.setInNumber(pdNormsStd.getNormsNumber());
                    slPdPkg.setInSize(pdNormsStd.getNormsSize());
                    slPdPkg.setInMts(pdNormsStd.getNormsOutTexture());
                    slPdPkg.setOutSpec(pdNormsStd.getNormsOut());
                    slPdPkg.setOutNw(pdNormsStd.getNetweightOut());
                    slPdPkg.setOutGw(pdNormsStd.getNormsKg());
                    slPdPkg.setOutSize(pdNormsStd.getNormsOutSize());
                    slPdPkg.setOutMts(pdNormsStd.getNormsOutTexture());
                    slPdPkg.setPkgTen(pdNormsStd.getNormsTen());
                    slPdPkg.setOutLength(pdNormsStd.getNormsLength());
                    slPdPkg.setOutWidth(pdNormsStd.getNormsWidth());
                    slPdPkg.setOutHeight(pdNormsStd.getNormsHeight());
                    slPdPkg.setOutVolume(pdNormsStd.getNormsVolume());
                    slPdPkg.setVer(1);
                    this.setCommonParam(slPdPkg);
                    this.sl241116Logic.saveSlPdPkg(slPdPkg);
                }
            }
        }
        SlProduct slProduct = new SlProduct();
        slProduct.setSlPdId(sl241119Param.getSlPdId());
        slProduct.setSlCode(sl241119Param.getSlCode());
        this.setCommonParam(slProduct);
        //全部同意判断其他标准是否符合要求
        BasePageParam basePageParam = new BasePageParam();
        basePageParam.setPaging(false);
        basePageParam.getFilterMap().put("slPdId", sl241119Param.getSlPdId());
        basePageParam.getFilterMap().put("slCode", sl241119Param.getSlCode());
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
