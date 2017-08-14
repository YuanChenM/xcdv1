package com.msk.sl.controller;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.core.web.consts.CodeMasterConst;
import com.msk.pd.logic.ProductLogic;
import com.msk.sl.bean.SL241101Bean;
import com.msk.sl.bean.SL241116Bean;
import com.msk.sl.bean.SLUploadFile;
import com.msk.sl.logic.SL241117Logic;
import com.msk.sl.logic.Sl241101Logic;
import com.msk.sl.logic.Sl241116Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 卖家审批审核列表Controller.
 *
 * @author gyh
 */
@Controller
@RequestMapping(value = "SL241116")
public class SL241116Controller extends BaseUploadController {
    @Autowired
    private Sl241116Logic sl241116Logic;
    @Autowired
    private Sl241101Logic sl241101Logic;
    @Autowired
    private ProductLogic productLogic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private SL241117Logic sl241117Logic;

    /**
     * 实例化页面
     *
     * @return 卖家产品信息页面
     */
    @RequestMapping(value = "init/{slCode}",
            method = RequestMethod.POST)
    private String init(Model model, @PathVariable("slCode") String slCode) {
        BasePageParam basePageParam = new BasePageParam();
        basePageParam.setPaging(false);
        basePageParam.setFilter("slCode", slCode);
        List<SL241101Bean> sl241101Beans = this.sl241101Logic.findPageList(basePageParam, SL241101Bean.class);
        if (!CollectionUtils.isEmpty(sl241101Beans)) {
            if (sl241101Beans.size() > 0) {
                model.addAttribute("slShowName", sl241101Beans.get(0).getSlShowName());
            }
        }
        BaseParam param = new BaseParam();
        param.setFilter("slCode", slCode);
        //产品类别信息
        List<PdClasses> pdClassess = productLogic.findPdClasses(param);
        model.addAttribute("pdClasses", pdClassess);
        List<SlEnterprise> slEnterprises = this.sl241116Logic.findEpInfo(param);
        model.addAttribute("slEnterprise", slEnterprises);
        List<SlPdBrand> slPdBrands = this.sl241116Logic.findSlPdBrand(param);
        model.addAttribute("slPdBrand", slPdBrands);
        model.addAttribute("slCode", slCode);
        model.addAttribute("slProduct", new SL241116Bean());
        return "sl/SL241116";
    }

    /**
     * 查询二级分类信息
     *
     * @param param param
     * @return
     */
    @RequestMapping(value = "findPdMachining", method = RequestMethod.POST)
    public
    @ResponseBody
    List<PdMachining> findPdMachining(BaseParam param) {
        return this.productLogic.findPdMachining(param);
    }
    /**
     * 查询品种信息
     *
     * @param param param
     * @return
     */
    @RequestMapping(value = "findBreed", method = RequestMethod.POST)
    public
    @ResponseBody
    List<PdBreed> findBreed(BaseParam param) {
        return this.productLogic.findPdBreed(param);
    }

    /**
     * 查询特征信息
     *
     * @param param param
     * @return
     */
    @RequestMapping(value = "findFeature", method = RequestMethod.POST)
    public
    @ResponseBody
    List<PdFeature> findFeature(BaseParam param) {
        return this.productLogic.findPdFeature(param);
    }

    /**
     * 查询包装净重信息
     *
     * @param param param
     * @return
     */
    @RequestMapping(value = "findPdWeight", method = RequestMethod.POST)
    public
    @ResponseBody
    List<PdWeight> findPdWeight(BaseParam param) {
        return this.productLogic.findPdWeight(param);
    }
    /**
     * 查看产品品种图片信息
     * @param sl241116Bean 参数
     * @param model model
     * @return 结果
     */
    @RequestMapping(value = "showImage", method = RequestMethod.POST)
    public String showImage(SL241116Bean sl241116Bean, Model model) {
        model.addAttribute("sl241116Bean", sl241116Bean);
        return "sl/SL24111601";
    }
    /**
     * 保存卖家产品状态
     *
     * @param slProduct 参数
     */
    @RequestMapping(value = "upSlPdStatus", method = RequestMethod.POST)
    public @ResponseBody String upSlPdStatus(SL241116Bean slProduct){
        BasePageParam param=new BasePageParam();
        param.setPaging(false);
        param.setFilter("slCode", slProduct.getSlCode());
        param.getFilterMap().put("slPdId", slProduct.getSlPdId());
        param.setFilter("machiningCode",slProduct.getMachiningCode());
        if("4".equals(slProduct.getStatus())||"5".equals(slProduct.getStatus())){
            //全部同意判断其他标准是否符合要求
            String checkRs=sl241117Logic.checkAgree(param);
            if (!"1".equals(checkRs)) {
                return checkRs;
            }
        }

        SlProduct product=slProduct;
        product.setUpdId(this.getLoginUser().getUpdId());
        this.sl241116Logic.upSlPdStatus(product);
        return "1";
    }

    /**
     * 保存卖家产品信息
     *
     * @param slProduct 参数
     * @return 卖家产品页面
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void save(Model model, SL241116Bean slProduct, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String concatInfo = slProduct.getConcatInfo();
        String[] concatInfos = concatInfo.split("-");
        slProduct.setBrandEpId(Integer.parseInt(concatInfos[1]));
        slProduct.setBrandId(Integer.parseInt(concatInfos[0]));
        slProduct.setSlTncGradeCode(2);
//        slProduct.setDistFlg("1");
        //初始状态为申请中
        slProduct.setStatus(CodeMasterConst.slProductStatus.SQZ);

        BasePageParam basePageParam = new BasePageParam();
        basePageParam.setPaging(false);
        basePageParam.setFilter("slCode", slProduct.getSlCode());
        basePageParam.setFilter("prodEpId", StringUtil.toSafeString(slProduct.getProdEpId()));
        basePageParam.setFilter("brandEpId", StringUtil.toSafeString(slProduct.getBrandEpId()));
        basePageParam.setFilter("brandId", StringUtil.toSafeString(slProduct.getBrandId()));
        basePageParam.setFilter("pdClassesCode", slProduct.getPdClassesCode());
        basePageParam.setFilter("machiningCode", slProduct.getMachiningCode());
        basePageParam.setFilter("pdBreedCode", slProduct.getPdBreedCode());

        Integer maxId = 0;
        basePageParam.setFilter("pdFeatureCode", "00");
        int count = this.sl241116Logic.getPageCount(basePageParam);
        String pdfeatureCode = slProduct.getPdFeatureCode();
        super.setCommonParam(slProduct);
        slProduct.setVer(1);
        slProduct.setDelFlg("0");
        if (count<1) {
            maxId = commonLogic.maxId("sl_product", "SL_PD_ID").intValue();
            slProduct.setSlPdId(maxId);
            slProduct.setPdFeatureCode("00");
            this.sl241116Logic.save(slProduct);
        }
        basePageParam.setFilter("weightCode", slProduct.getWeightCode());
        basePageParam.setFilter("pdFeatureCode", pdfeatureCode);
        List<SL241116Bean> sl241116Beans = this.sl241116Logic.findPageList(basePageParam, SL241116Bean.class);
        if (!CollectionUtils.isEmpty(sl241116Beans)) {
            if (sl241116Beans.size() > 0) {
                throw new BusinessException("该产品已经存在！");
            }
        } else {
            maxId = commonLogic.maxId("sl_product", "SL_PD_ID").intValue();
            slProduct.setSlPdId(maxId);
            slProduct.setPdFeatureCode(pdfeatureCode);
            this.sl241116Logic.save(slProduct);
        }
        String uploadFilePath = BusinessConst.SLPath.SERVICEIMAGEPATH + "/" + BusinessConst.SLPath.SLIMAGEPATH + "/" + slProduct.getProdEpId() + "/" + BusinessConst.SLPath.PD + "/" + slProduct.getPdClassesCode() + "/" +slProduct.getMachiningCode()+ "/" + slProduct.getPdBreedCode() + '/';
        /**保存盘装图片*/
        if (slProduct.getLabFile1().getSize() != 0) {
            String uploadFileName = BusinessConst.SLPath.INTRAYFIGURE;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(slProduct.getLabFile1(), uploadFilePath, uploadFileName);
        }
        /**保存内袋图片*/

        if (slProduct.getLabFile2().getSize() != 0) {
            String uploadFileName = BusinessConst.SLPath.INSIDEOFFIGURE;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(slProduct.getLabFile2(), uploadFilePath, uploadFileName);
        }
        /**保存外箱开箱图片*/
        if (slProduct.getLabFile3().getSize() != 0) {
            String uploadFileName = BusinessConst.SLPath.OUTSIDEBOXFIGURE;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(slProduct.getLabFile3(), uploadFilePath, uploadFileName);
        }
        /**保存外箱外观图片*/
        if (slProduct.getLabFile4().getSize() != 0) {
            String uploadFileName = BusinessConst.SLPath.CARTONAPPEARANCEFIGURE;
            SLUploadFile slUploadFile = new SLUploadFile();
            slUploadFile.saveUploadFile(slProduct.getLabFile4(), uploadFilePath, uploadFileName);
        }
        super.callBack(null, "保存成功", response);
    }

    /**
     * 查询审批审核列表
     *
     * @param basePageParam basePageParam
     * @return 信息
     * @author gyh
     */
    @RequestMapping(value = "search/{slCode}",
            method = RequestMethod.POST)
    public
    @ResponseBody
    PageResult<SL241116Bean> search(BasePageParam basePageParam, @PathVariable(value = "slCode") String slCode) {
        basePageParam.setFilter("slCode", slCode);
        DbUtils.buildLikeCondition(basePageParam, "slPdArtNo", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "pdClassesName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "prodEpName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "brandName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "machiningName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "pdBreedName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "pdFeatureName", DbUtils.LikeMode.FRONT);
        DbUtils.buildLikeCondition(basePageParam, "weightName", DbUtils.LikeMode.FRONT);
        basePageParam.setFilter("searchArtno","1");
        String statusName=StringUtil.toSafeString(basePageParam.getFilterMap().get("status"));
        if(!StringUtil.isNullOrEmpty(statusName)){
            String[] statusNames=statusName.split(",");
            basePageParam.getFilterMap().put("statusNames",statusNames);
        }
        return this.sl241116Logic.findPage(basePageParam, SL241116Bean.class);
    }
}
