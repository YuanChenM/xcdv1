package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ISL231106Logic.
 *
 * @author gyh
 */
@Service
public class ISL231106Logic extends BaseLogic {
    @Autowired
    private Sl241116Logic sl241116Logic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private SL241118Logic sl241118Logic;
    @Autowired
    private SL241119Logic sl241119Logic;
    @Autowired
    private SL241117Logic sl241117Logic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_INSERT_SL_PD_ORG_STD = "insertSlPdOrgStd";
        static final String SQL_ID_MODIFY_SL_PD_ORG_STD = "modifySlPdOrgStd";
        static final String SQL_ID_FIND_SL_PD_ORG_STD = "findSlPdTncStd";
    }

    /**
     * 保存其他指标
     *
     * @param other 参数
     * @return 结果
     */
    public int insertSlPdOrgStd(SlPdTncStdOther other) {
        return this.save(SqlId.SQL_ID_INSERT_SL_PD_ORG_STD, other);
    }

    /**
     * 修改其他指标
     *
     * @param other 参数
     * @return 结果
     */
    public int modifySlPdOrgStd(SlPdTncStdOther other) {
        return this.modify(SqlId.SQL_ID_MODIFY_SL_PD_ORG_STD, other);
    }

    /**
     * 查询其他指标
     *
     * @param other 参数
     * @return 结果
     */
    public List<SlPdTncStdOther> findSlPdTncStd(BaseParam other) {
        return this.findList(SqlId.SQL_ID_FIND_SL_PD_ORG_STD, other);
    }

    /**
     * 卖家产品及卖家产品加工技术标准维护
     *
     * @param slPdQtyList 卖家产品加工技术标准信息
     * @return 操作结果
     */
    @Transactional(readOnly = false)
    public String mainTainSlPdQty(List<ISL231106RsSlPdQty> slPdQtyList) {
        String mainTail = "";
        for (ISL231106RsSlPdQty slPdQty : slPdQtyList) {
            SlProduct slProduct = new SlProduct();
            slProduct.setSlCode(slPdQty.getSlCode());
            slProduct.setSlPdId(slPdQty.getSlPdId());
            slProduct.setSlQltStd(slPdQty.getSlQltStd());
            slProduct.setSlQltGradeCode(slPdQty.getSlQltGradeCode());
            Integer maxId = null;
            BasePageParam basePageParam = new BasePageParam();
            basePageParam.setPaging(false);
            basePageParam.setFilter("slCode", slPdQty.getSlCode());
            basePageParam.getFilterMap().put("slPdId", slPdQty.getSlPdId());
            //执行卖家产品操作，如果产品存在则修改，不存在则新增
            List<SL241116Bean> sl241116Beans = sl241116Logic.findSlProductList(basePageParam);
            if (CollectionUtils.isEmpty(sl241116Beans) || sl241116Beans.size() < 1) {
                //不存在
                throw new BusinessException("卖家产品ID为" + slPdQty.getSlPdId() + "不存在！");
            } else {
                //存在,xiugai
                maxId = sl241116Beans.get(0).getSlPdId();
                slProduct = sl241116Beans.get(0);
                slProduct.setUpdId(slPdQty.getLoginId());
                slProduct.setSlQltStd(slPdQty.getSlQltStd());
                slProduct.setSlQltGradeCode(slPdQty.getSlQltGradeCode());
                Integer ver = sl241116Beans.get(0).getVer();
                if (ver != null) {
                    ver += 1;
                } else {
                    ver = 1;
                }
                slProduct.setVer(ver);
                sl241118Logic.modifySlProduct(slProduct);
            }
            //执行卖家产品加工技术标准维护
            List<ISL231106RsPdQltStd> slPdQtyStdList = slPdQty.getSlPdMctStdList();
            if (!CollectionUtils.isEmpty(slPdQtyStdList) && slPdQtyStdList.size() > 0) {
                BaseParam param = new BaseParam();
                //根据卖家编码、卖家产品id、产品标准ID、产品标准项目ID查询卖家该产品加工质量标准是否存在，存在则修改，不存在则新增
                param.setFilter("slCode", slPdQty.getSlCode());
                param.getFilterMap().put("slPdId", maxId);
                for (ISL231106RsPdQltStd std : slPdQtyStdList) {
                    param.getFilterMap().put("stdItemId", std.getStdItemId());
                    List<SlPdMctStdNew> news = sl241118Logic.findSlPdMctStdNew(param);
                    SlPdMctStdNew stdNew = new SlPdMctStdNew();
                    if (!CollectionUtils.isEmpty(news)) {
                        //修改
                        if (std.getVer() == null) {
                            std.setVer(news.get(0).getVer() + 1);
                        }
                        stdNew = std;
                        std.setSlPdId(maxId);
                        stdNew.setUpdId(std.getLoginId());
                        stdNew.setDelFlg(std.getDelFlg());
                        sl241118Logic.modify(stdNew);
                    } else {
                        //新增
                        stdNew = std;
                        stdNew.setVer(1);
                        stdNew.setDelFlg("0");
                        std.setSlPdId(maxId);
                        stdNew.setCrtId(std.getLoginId());
                        sl241118Logic.save(stdNew);
                    }
                    //不同意的处理方式
                    if ("0".equals(std.getAgreeFlg())) {
                        PdMctStdDiscussProvider provide = new PdMctStdDiscussProvider();
                        provide.setStandardId(std.getStandardId().longValue());
                        provide.setSlPdId(std.getSlPdId());
                        provide.setMctStdItemId(std.getStdItemId());
                        provide.setMctStdVal(std.getStdVal());
                        provide.setProviderCode(std.getSlCode());
                        provide.setProviderName(std.getSlCode());
                        provide.setDiscussStatus(0);
                        stdNew.setStdItemId(std.getStdItemId());
                        provide.setCrtId(std.getLoginId());
                        provide.setVer(1);
                        provide.setKeyId(commonLogic.maxId("PD_MCT_STD_DISCUSS_PROVIDER", "KEY_ID"));
                        provide.setDelFlg("0");
                        sl241118Logic.saveNotAgree(provide);
                        slProduct.setSlQltGradeCode(4);
                        sl241118Logic.modifySlProduct(slProduct);
                    }

                }
            }
            //全部同意判断其他标准是否符合要求
            String checkRs=sl241117Logic.checkAgree(basePageParam);
            if ("1".equals(checkRs)) {
                //修改卖家产品为试销
//                slProduct.setStatus("4");
//                this.sl241116Logic.upSlPdStatus(slProduct);
            } else {
                //修改卖家产品为论证中
                slProduct.setStatus("2");
                this.sl241116Logic.upSlPdStatus(slProduct);
            }
            mainTail = "更新卖家产品加工技术标准成功！";
        }
        return mainTail;
    }

    /**
     * 卖家产品维护
     *
     * @param slPdList 卖家产品信息
     * @return 操作名称
     */
    @Transactional(readOnly = false)
    public String mainTainSlProduct(List<ISL231106RsSlProduct> slPdList) {
        String mainTail = "";
        for (ISL231106RsSlProduct slProduct : slPdList) {
            BasePageParam basePageParam = new BasePageParam();
            basePageParam.setPaging(false);
            //如果删除标志不为空执行删除操作，为空执行其他操作
            if (!StringUtil.isNullOrEmpty(slProduct.getDelFlg())&&"1".equals(slProduct.getDelFlg())) {
                basePageParam.getFilterMap().put("slPdId", slProduct.getSlPdId());
                //执行卖家产品操作，如果产品存在则修改，不存在则新增
                List<SL241116Bean> sl241116Beans = sl241116Logic.findSlProductList(basePageParam);
                if (CollectionUtils.isEmpty(sl241116Beans) || sl241116Beans.size() < 1) {
                    throw new BusinessException("删除失败，卖家产品ID:"+slProduct.getSlPdId()+"不存在！");
                }
                SL241116Bean product=sl241116Beans.get(0);
                if(StringUtil.toSafeString(NumberConst.IntDef.INT_ONE).equals(product.getStatus())||StringUtil.toSafeString(NumberConst.IntDef.INT_TWO).equals(product.getStatus())){
                    mainTail = "删除卖家卖家产品成功！";
                    slProduct.setUpdId(slProduct.getLoginId());
                    this.sl241116Logic.deleteProduct(slProduct);
                }else{
                    mainTail = "删除卖家卖家产品失败！该产品状态不支持被删除。";
                }
            } else {
                basePageParam.setFilter("slCode", slProduct.getSlCode());
                basePageParam.setFilter("prodEpId", StringUtil.toSafeString(slProduct.getProdEpId()));
                basePageParam.setFilter("brandEpId", StringUtil.toSafeString(slProduct.getBrandEpId()));
                basePageParam.setFilter("brandId", StringUtil.toSafeString(slProduct.getBrandId()));
                basePageParam.setFilter("pdClassesCode", slProduct.getPdClassesCode());
                basePageParam.setFilter("machiningCode", slProduct.getMachiningCode());
                basePageParam.setFilter("pdBreedCode", slProduct.getPdBreedCode());
                basePageParam.setFilter("pdFeatureCode", slProduct.getPdFeatureCode());
                basePageParam.setFilter("weightCode", slProduct.getWeightCode());
                //执行卖家产品操作，如果产品存在则修改，不存在则新增
                List<SL241116Bean> sl241116Beans = sl241116Logic.findSlProductList(basePageParam);
                Integer maxId = commonLogic.maxId("sl_product", "SL_PD_ID").intValue();
                if (CollectionUtils.isEmpty(sl241116Beans) || sl241116Beans.size() < 1) {
                    mainTail = "新增产品标准成功";
                    //不存在，新增
                    slProduct.setCrtId(slProduct.getLoginId());
                    slProduct.setSlPdId(maxId);
                    slProduct.setStatus("1");
                    slProduct.setVer(1);
                    slProduct.setDelFlg("0");
                    this.sl241116Logic.save(slProduct);
                    basePageParam.setFilter("pdFeatureCode", "00");
                    sl241116Beans = sl241116Logic.findSlProductList(basePageParam);
                    if (CollectionUtils.isEmpty(sl241116Beans) || sl241116Beans.size() < 1) {
                        slProduct.setSlPdId(commonLogic.maxId("sl_product", "SL_PD_ID").intValue());
                        slProduct.setPdFeatureCode("00");
                        this.sl241116Logic.save(slProduct);
                    }
                } else {
                    //存在，修改
                    mainTail = "修改产品标准成功";
                    maxId = sl241116Beans.get(0).getSlPdId();
                    slProduct.setUpdId(slProduct.getLoginId());
                    Integer ver = sl241116Beans.get(0).getVer();
                    if (ver != null) {
                        ver += 1;
                    } else {
                        ver = 1;
                    }
                    slProduct.setVer(ver);
                    this.sl241116Logic.modify(slProduct);
                    basePageParam.setFilter("pdFeatureCode", "00");
                    sl241116Beans = sl241116Logic.findSlProductList(basePageParam);
                    if (CollectionUtils.isEmpty(sl241116Beans) || sl241116Beans.size() < 1) {
                        slProduct.setSlPdId(commonLogic.maxId("sl_product", "SL_PD_ID").intValue());
                        slProduct.setPdFeatureCode("00");
                        this.sl241116Logic.save(slProduct);
                    }
                }
            }
        }
        return mainTail;
    }

    /**
     * 卖家产品加工质量标准维护
     *
     * @param slPdTncList 卖家产品信息
     * @return 操作名称
     */
    public String mainTainSlPdTnc(List<ISL231106RsSlPdTnc> slPdTncList) {
        String mainTail = "";
        for (ISL231106RsSlPdTnc slPdTnc : slPdTncList) {
            SlProduct slProduct = new SlProduct();
            slProduct.setSlCode(slPdTnc.getSlCode());
            slProduct.setSlPdId(slPdTnc.getSlPdId());
            slProduct.setSlTncStd(slPdTnc.getSlTncStd());
            slProduct.setSlTncGradeCode(slPdTnc.getSlTncGradeCode());
            Integer maxId = null;
            BasePageParam basePageParam = new BasePageParam();
            basePageParam.setPaging(false);
            basePageParam.setFilter("slCode", slPdTnc.getSlCode());
            basePageParam.getFilterMap().put("slPdId", slPdTnc.getSlPdId());
            //执行卖家产品操作，如果产品存在则修改，不存在则新增
            List<SL241116Bean> sl241116Beans = sl241116Logic.findSlProductList(basePageParam);
            if (CollectionUtils.isEmpty(sl241116Beans) || sl241116Beans.size() < 1) {
                //不存在
                throw new BusinessException("卖家产品ID为" + slPdTnc.getSlPdId() + "不存在！");
            } else {
                //存在，修改
                maxId = sl241116Beans.get(0).getSlPdId();
                slProduct = sl241116Beans.get(0);
                slProduct.setUpdId(slPdTnc.getLoginId());
                slProduct.setSlTncStd(slPdTnc.getSlTncStd());
                slProduct.setSlTncGradeCode(slPdTnc.getSlTncGradeCode());
                Integer ver = sl241116Beans.get(0).getVer();
                if (ver != null) {
                    ver += 1;
                } else {
                    ver = 1;
                }
                slProduct.setVer(ver);
                this.sl241117Logic.modifySlProduct(slProduct);
            }
            //执行卖家产品加工质量标准维护
            List<ISL231106RsPdTncStd> pdTncStds = slPdTnc.getSlPdTncStdList();
            if (!CollectionUtils.isEmpty(pdTncStds)) {
                BaseParam param = new BaseParam();
                //根据卖家编码、卖家产品id、产品标准ID、产品标准项目ID查询卖家该产品加工质量标准是否存在，存在则修改，不存在则新增
                param.setFilter("slCode", slPdTnc.getSlCode());
                param.getFilterMap().put("slPdId", maxId);
                for (ISL231106RsPdTncStd tncStd : pdTncStds) {
                    param.getFilterMap().put("stdItemId", tncStd.getStdItemId());
                    List<SlPdTncStdNew> news = sl241117Logic.findSlPdTncStdNew(param);
                    SlPdTncStdNew stdNew = new SlPdTncStdNew();
                    if (!CollectionUtils.isEmpty(news)) {
                        //修改
                        if (tncStd.getVer() == null) {
                            tncStd.setVer(news.get(0).getVer() + 1);
                        }
                        stdNew = tncStd;
                        stdNew.setUpdId(tncStd.getLoginId());
                        stdNew.setSlPdId(maxId);
                        stdNew.setDelFlg(tncStd.getDelFlg());
                        sl241117Logic.modify(stdNew);
                    } else {
                        //新增
                        stdNew = tncStd;
                        stdNew.setVer(1);
                        stdNew.setDelFlg("0");
                        stdNew.setCrtId(tncStd.getLoginId());
                        stdNew.setSlPdId(maxId);
                        sl241117Logic.save(stdNew);
                    }
                    //不同意的处理方式
                    if ("0".equals(tncStd.getAgreeFlg())) {
                        PdTncStdDiscussProvider provide = new PdTncStdDiscussProvider();
                        provide.setStandardId(tncStd.getStandardId().longValue());
                        provide.setSlPdId(tncStd.getSlPdId());
                        provide.setTncStdItemId(tncStd.getStdItemId());
                        provide.setTncStdVal(tncStd.getStdVal());
                        provide.setProviderCode(tncStd.getSlCode());
                        provide.setProviderName(tncStd.getSlCode());
                        provide.setDiscussStatus(0);
                        stdNew.setStdItemId(tncStd.getStdItemId());
                        provide.setCrtId(tncStd.getLoginId());
                        provide.setVer(1);
                        provide.setKeyId(commonLogic.maxId("PD_TNC_STD_DISCUSS_PROVIDER", "KEY_ID"));
                        provide.setDelFlg("0");
                        sl241117Logic.saveNotAgree(provide);
                        slProduct.setSlTncGradeCode(4);
                        sl241117Logic.modifySlProduct(slProduct);
                    }
                }
            }
            //全部同意判断其他标准是否符合要求
            String checkRs=sl241117Logic.checkAgree(basePageParam);
            if ("1".equals(checkRs)) {
                //修改卖家产品为试销
//                slProduct.setStatus("4");
//                this.sl241116Logic.upSlPdStatus(slProduct);
            } else {
                //修改卖家产品为论证中
                slProduct.setStatus("2");
                this.sl241116Logic.upSlPdStatus(slProduct);
            }
            mainTail = "更新卖家产品加工质量标准成功！";
        }
        return mainTail;
    }

    /**
     * 卖家产品包装标准维护
     *
     * @param slPdPkgList 卖家产品信息
     * @return 操作名称
     */
    public String mainTainSlPdPkg(List<ISL231106RsSlPdPkg> slPdPkgList) {
        String mainTail = "";
        for (ISL231106RsSlPdPkg slPdPkg : slPdPkgList) {
            BasePageParam basePageParam = new BasePageParam();
            basePageParam.setPaging(false);
            basePageParam.setFilter("normsCode", slPdPkg.getPkgCode());
            basePageParam.setFilter("slCode", slPdPkg.getSlCode());
            basePageParam.getFilterMap().put("standardId", slPdPkg.getStandardId());
            basePageParam.setFilter("slPdId", StringUtil.toSafeString(slPdPkg.getSlPdId()));
            basePageParam.setFilter("slPdPkgId", StringUtil.toSafeString(slPdPkg.getSlPdPkgId()));
            //根据卖家产品id查询产品信息
            List<SL241116Bean> sl241116Beans = sl241116Logic.findPageList(basePageParam, SL241116Bean.class);
            if (!CollectionUtils.isEmpty(sl241116Beans) && sl241116Beans.size() > 0) {
                //卖家产品id存在
                SL241116Bean sl241116Bean = sl241116Beans.get(0);
                //根据条件查询产品包装及卖家产品包装ID
                List<SL241119Bean> sl241119Beans = sl241119Logic.findPageList(basePageParam, SL241119Bean.class);
                //产品包装存在则修改，不存在则提示产品包装不存在
                if (!CollectionUtils.isEmpty(sl241119Beans) && sl241119Beans.size() > 0) {
                    SL241119Bean sl241119Param = sl241119Beans.get(0);
                    SlPdPkg pdPkg = new SlPdPkg();
                    pdPkg.setSlCode(slPdPkg.getSlCode());
                    pdPkg.setSlPdId(slPdPkg.getSlPdId());
                    pdPkg.setPkgCode(slPdPkg.getPkgCode());
                    pdPkg.setStandardId(slPdPkg.getStandardId());
                    pdPkg.setProdEpId(sl241116Bean.getProdEpId());
                    pdPkg.setBrandEpId(sl241116Bean.getBrandEpId());
                    pdPkg.setBrandId(sl241116Bean.getBrandId());
                    pdPkg.setPdClassesCode(sl241116Bean.getPdClassesCode());
                    pdPkg.setPdBreedCode(sl241116Bean.getPdBreedCode());
                    pdPkg.setPdFeatureCode(sl241116Bean.getPdFeatureCode());
                    pdPkg.setInSglNw(sl241119Param.getNormsSuttle());
                    pdPkg.setInSglNwRange(sl241119Param.getNormsError());
                    pdPkg.setInNw(sl241119Param.getNetweightInner());
                    pdPkg.setInNumber(sl241119Param.getNormsNumber());
                    pdPkg.setInSize(sl241119Param.getNormsSize());
                    pdPkg.setInMts(sl241119Param.getNormsOutTexture());
                    pdPkg.setOutSpec(sl241119Param.getNormsOut());
                    pdPkg.setOutNw(sl241119Param.getNetweightOut());
                    pdPkg.setOutGw(sl241119Param.getNormsKg());
                    pdPkg.setOutSize(sl241119Param.getNormsOutSize());
                    pdPkg.setOutMts(sl241119Param.getNormsOutTexture());
                    pdPkg.setPkgTen(sl241119Param.getNormsTen());
                    pdPkg.setOutLength(sl241119Param.getNormsLength());
                    pdPkg.setOutWidth(sl241119Param.getNormsWidth());
                    pdPkg.setOutHeight(sl241119Param.getNormsHeight());
                    pdPkg.setOutVolume(sl241119Param.getNormsVolume());
                    //判断卖家产品包装是否存在，存在修改，不存在新增
                    if (sl241119Param.getSlPdPkgId() == null) {
                        pdPkg.setSlPdPkgId(commonLogic.maxId("sl_pd_pkg", "SL_PD_PKG_ID").intValue());
                        pdPkg.setCrtId(slPdPkg.getLoginId());
                        this.sl241116Logic.saveSlPdPkg(pdPkg);
                        mainTail = "新增卖家产品包装成功！";
                    } else {
                        //修改卖家产品包装
                        pdPkg.setUpdId(slPdPkg.getLoginId());
                        if(StringUtil.isNullOrEmpty(slPdPkg.getDelFlg())){
                            pdPkg.setDelFlg("0");
                        }else{
                            pdPkg.setDelFlg(slPdPkg.getDelFlg());
                        }
                        this.sl241116Logic.modifySlPdPkg(pdPkg);
                        mainTail = "更新卖家产品包装成功！";
                    }
                } else {
                    throw new BusinessException("产品包装" + slPdPkg.getPkgCode() + "产品标准" + slPdPkg.getStandardId() + "不存在！请检查后提交。");
                }
            } else {
                //卖家产品id不存在
                throw new BusinessException("卖家产品ID" + slPdPkg.getSlPdId() + "不存在！请检查后提交。");
            }
            //全部同意判断其他标准是否符合要求
            SlProduct slProduct = new SlProduct();
            slProduct.setSlPdId(slPdPkg.getSlPdId());
            slProduct.setSlCode(slPdPkg.getSlCode());
            String checkRs=sl241117Logic.checkAgree(basePageParam);
            if ("1".equals(checkRs)) {
                //修改卖家产品为试销
//                slProduct.setStatus("4");
//                this.sl241116Logic.upSlPdStatus(slProduct);
            } else {
                //修改卖家产品为论证中
                slProduct.setStatus("2");
                this.sl241116Logic.upSlPdStatus(slProduct);
            }
        }
        return mainTail;
    }

    /**
     * 卖家原种种源标准
     *
     * @param slPdOrgStdList 卖家原种种源标准信息
     * @return 结果
     */
    public String mainTainSlPdOrgStd(List<SlPdTncStdOther> slPdOrgStdList) {
        BasePageParam param = new BasePageParam();
        param.setPaging(false);
        param.getFilterMap().put("stdFlag", 1);
        for (SlPdTncStdOther other : slPdOrgStdList) {
            param.setFilter("slCode", other.getSlCode());
            param.getFilterMap().put("slPdId", other.getSlPdId());
            param.getFilterMap().put("standardId", other.getStandardId());
            param.setFilter("tncStdItemId", other.getTncStdItemId());
            List<SlPdTncStdOther> others = this.findSlPdTncStd(param);
            other.setStdFlag(1);
            if (CollectionUtils.isEmpty(others) || others.size() < 1) {
                this.insertSlPdOrgStd(other);
            } else {
                this.modifySlPdOrgStd(other);
            }
            SlProduct slProduct = new SlProduct();
            slProduct.setSlPdId(other.getSlPdId());
            slProduct.setSlCode(other.getSlCode());
            String checkRs=sl241117Logic.checkAgree(param);
            if ("1".equals(checkRs)) {
                //修改卖家产品为试销
//                slProduct.setStatus("4");
//                this.sl241116Logic.upSlPdStatus(slProduct);
            } else {
                //修改卖家产品为论证中
                slProduct.setStatus("2");
                this.sl241116Logic.upSlPdStatus(slProduct);
            }
        }
        return "更新卖家产品原种种源标准成功！";
    }

    /**
     * 卖家产品饲养标准
     *
     * @param slPdFedStdList 卖家产品饲养标准信息
     * @return 结果
     */
    public String mainTainSlPdFedStd(List<SlPdTncStdOther> slPdFedStdList) {
        BasePageParam param = new BasePageParam();
        param.getFilterMap().put("stdFlag", 2);
        for (SlPdTncStdOther other : slPdFedStdList) {
            param.setFilter("slCode", other.getSlCode());
            param.getFilterMap().put("slPdId", other.getSlPdId());
            param.getFilterMap().put("standardId", other.getStandardId());
            param.setFilter("tncStdItemId", other.getTncStdItemId());
            List<SlPdTncStdOther> others = this.findSlPdTncStd(param);
            other.setStdFlag(2);
            if (CollectionUtils.isEmpty(others) || others.size() < 1) {
                this.insertSlPdOrgStd(other);
            } else {
                this.modifySlPdOrgStd(other);
            }
            SlProduct slProduct = new SlProduct();
            slProduct.setSlPdId(other.getSlPdId());
            slProduct.setSlCode(other.getSlCode());
            String checkRs=sl241117Logic.checkAgree(param);
            if ("1".equals(checkRs)) {
                //修改卖家产品为试销
//                slProduct.setStatus("4");
//                this.sl241116Logic.upSlPdStatus(slProduct);
            } else {
                //修改卖家产品为论证中
                slProduct.setStatus("2");
                this.sl241116Logic.upSlPdStatus(slProduct);
            }
        }
        return "更新卖家产品饲养标准成功！";
    }

    /**
     * 卖家产品通用质量标准
     *
     * @param slPdGnqStdList 卖家产品通用质量标准信息
     * @return 结果
     */
    public String mainTainSlPdGnqStd(List<SlPdTncStdOther> slPdGnqStdList) {
        BasePageParam param = new BasePageParam();
        param.getFilterMap().put("stdFlag", 3);
        for (SlPdTncStdOther other : slPdGnqStdList) {
            param.setFilter("slCode", other.getSlCode());
            param.getFilterMap().put("slPdId", other.getSlPdId());
            param.getFilterMap().put("standardId", other.getStandardId());
            param.setFilter("tncStdItemId", other.getTncStdItemId());
            List<SlPdTncStdOther> others = this.findSlPdTncStd(param);
            other.setStdFlag(3);
            if (CollectionUtils.isEmpty(others) || others.size() < 1) {
                this.insertSlPdOrgStd(other);
            } else {
                this.modifySlPdOrgStd(other);
            }
            SlProduct slProduct = new SlProduct();
            slProduct.setSlPdId(other.getSlPdId());
            slProduct.setSlCode(other.getSlCode());
            String checkRs=sl241117Logic.checkAgree(param);
            if ("1".equals(checkRs)) {
                //修改卖家产品为试销
//                slProduct.setStatus("4");
//                this.sl241116Logic.upSlPdStatus(slProduct);
            } else {
                //修改卖家产品为论证中
                slProduct.setStatus("2");
                this.sl241116Logic.upSlPdStatus(slProduct);
            }
        }
        return "更新卖家产品通用质量标准成功！";
    }

    /**
     * 卖家产品储存运输标准
     *
     * @param slPdTspStdList 卖家产品储存运输标准信息
     * @return 结果
     */
    public String mainTainSlPdTspStd(List<SlPdTncStdOther> slPdTspStdList) {
        BasePageParam param = new BasePageParam();
        param.getFilterMap().put("stdFlag", 4);
        for (SlPdTncStdOther other : slPdTspStdList) {
            param.setFilter("slCode", other.getSlCode());
            param.getFilterMap().put("slPdId", other.getSlPdId());
            param.getFilterMap().put("standardId", other.getStandardId());
            param.setFilter("tncStdItemId", other.getTncStdItemId());
            List<SlPdTncStdOther> others = this.findSlPdTncStd(param);
            other.setStdFlag(4);
            if (CollectionUtils.isEmpty(others) || others.size() < 1) {
                this.insertSlPdOrgStd(other);
            } else {
                this.modifySlPdOrgStd(other);
            }
            SlProduct slProduct = new SlProduct();
            slProduct.setSlPdId(other.getSlPdId());
            slProduct.setSlCode(other.getSlCode());
            String checkRs=sl241117Logic.checkAgree(param);
            if ("1".equals(checkRs)) {
                //修改卖家产品为试销
//                slProduct.setStatus("4");
//                this.sl241116Logic.upSlPdStatus(slProduct);
            } else {
                //修改卖家产品为论证中
                slProduct.setStatus("2");
                this.sl241116Logic.upSlPdStatus(slProduct);
            }
        }
        return "更新卖家产品储存运输标准成功！";
    }

    /**
     * 卖家产品安全标准
     *
     * @param slPdSftStdList 卖家产品安全标准信息
     * @return 结果
     */
    public String mainTainSlPdSftStd(List<SlPdTncStdOther> slPdSftStdList) {
        BasePageParam param = new BasePageParam();
        param.getFilterMap().put("stdFlag", 5);
        for (SlPdTncStdOther other : slPdSftStdList) {
            param.setFilter("slCode", other.getSlCode());
            param.getFilterMap().put("slPdId", other.getSlPdId());
            param.getFilterMap().put("standardId", other.getStandardId());
            param.setFilter("tncStdItemId", other.getTncStdItemId());
            List<SlPdTncStdOther> others = this.findSlPdTncStd(param);
            other.setStdFlag(5);
            if (CollectionUtils.isEmpty(others) || others.size() < 1) {
                this.insertSlPdOrgStd(other);
            } else {
                this.modifySlPdOrgStd(other);
            }
            SlProduct slProduct = new SlProduct();
            slProduct.setSlPdId(other.getSlPdId());
            slProduct.setSlCode(other.getSlCode());
            String checkRs=sl241117Logic.checkAgree(param);
            if ("1".equals(checkRs)) {
                //修改卖家产品为试销
//                slProduct.setStatus("4");
//                this.sl241116Logic.upSlPdStatus(slProduct);
            } else {
                //修改卖家产品为论证中
                slProduct.setStatus("2");
                this.sl241116Logic.upSlPdStatus(slProduct);
            }
        }
        return "更新卖家产品安全标准成功！";
    }

    /**
     * 卖家产品信息维护
     *
     * @param param 参数
     * @return 结果
     */
    public RsResponse saveSlQlt(RsRequest<ISL231106RsParam> param) {
        RsResponse rs = new RsResponse();
        ISL231106RsParam iSL231106RsParam = param.getParam();
        List<ISL231106RsSlProduct> slPdList = iSL231106RsParam.getSlPdList();//卖家能销售的产品信息
        List<ISL231106RsSlPdQty> slPdQtyList = iSL231106RsParam.getSlPdMctList();//卖家产品质量标准信息List
        List<ISL231106RsSlPdTnc> slPdTncList = iSL231106RsParam.getSlPdTncList();//卖家产品加工技术标准指标
        List<ISL231106RsSlPdPkg> slPdPkgList = iSL231106RsParam.getSlPdPkgList();//卖家产品包装标准信息
        List<SlPdTncStdOther> slPdOrgStdList = iSL231106RsParam.getSlPdOrgStdList();//卖家原种种源标准
        List<SlPdTncStdOther> slPdFedStdList = iSL231106RsParam.getSlPdFedStdList();//卖家产品饲养标准
        List<SlPdTncStdOther> slPdGnqStdList = iSL231106RsParam.getSlPdGnqStdList();//卖家产品通用质量标准
        List<SlPdTncStdOther> slPdTspStdList = iSL231106RsParam.getSlPdTspStdList();//卖家产品储存运输标准
        List<SlPdTncStdOther> slPdSftStdList = iSL231106RsParam.getSlPdSftStdList();//卖家产品安全标准
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        String message="";
        //卖家能销售的产品信息
        if (!CollectionUtils.isEmpty(slPdList) && slPdList.size() > 0) {
//            rs.setMessage(this.mainTainSlProduct(slPdList));
            message+=this.mainTainSlProduct(slPdList);
        }
        //卖家产品质量标准信息List
        if (!CollectionUtils.isEmpty(slPdQtyList) && slPdQtyList.size() > 0) {
//            rs.setMessage(this.mainTainSlPdQty(slPdQtyList));
            message+=this.mainTainSlPdQty(slPdQtyList);
        }
        //卖家产品加工技术标准指标
        if (!CollectionUtils.isEmpty(slPdTncList) && slPdTncList.size() > 0) {
//            rs.setMessage(this.mainTainSlPdTnc(slPdTncList));
            message+=this.mainTainSlPdTnc(slPdTncList);
        }
        //卖家产品包装标准信息
        if (!CollectionUtils.isEmpty(slPdPkgList) && slPdPkgList.size() > 0) {
//            rs.setMessage(this.mainTainSlPdPkg(slPdPkgList));
            message+=this.mainTainSlPdPkg(slPdPkgList);
        }
        //卖家原种种源标准
        if (!CollectionUtils.isEmpty(slPdOrgStdList) && slPdOrgStdList.size() > 0) {
//            rs.setMessage(this.mainTainSlPdOrgStd(slPdOrgStdList));
            message+=this.mainTainSlPdOrgStd(slPdOrgStdList);
        }
        //卖家产品饲养标准
        if (!CollectionUtils.isEmpty(slPdFedStdList) && slPdFedStdList.size() > 0) {
//            rs.setMessage(this.mainTainSlPdFedStd(slPdFedStdList));
            message+=this.mainTainSlPdFedStd(slPdFedStdList);
        }
        //卖家产品通用质量标准
        if (!CollectionUtils.isEmpty(slPdGnqStdList) && slPdGnqStdList.size() > 0) {
//            rs.setMessage(this.mainTainSlPdGnqStd(slPdGnqStdList));
            message+=this.mainTainSlPdGnqStd(slPdGnqStdList);
        }
        //卖家产品储存运输标准
        if (!CollectionUtils.isEmpty(slPdTspStdList) && slPdTspStdList.size() > 0) {
//            rs.setMessage(this.mainTainSlPdTspStd(slPdTspStdList));
            message+=this.mainTainSlPdTspStd(slPdTspStdList);
        }
        //卖家产品安全标准
        if (!CollectionUtils.isEmpty(slPdSftStdList) && slPdSftStdList.size() > 0) {
//            rs.setMessage(this.mainTainSlPdSftStd(slPdSftStdList));
            message+=this.mainTainSlPdSftStd(slPdSftStdList);
        }
        if(StringUtil.isNullOrEmpty(message)){
            throw new BusinessException("接口参数不规范，请检查后提交！");
        }
        rs.setMessage(message);
        return rs;
    }
}
