package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.entity.PdBreed;
import com.msk.core.entity.PdFeature;
import com.msk.core.entity.PdNormsStd;
import com.msk.core.entity.PdWeight;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.pd.logic.ProductLogic;
import com.msk.sl.bean.SL241101Bean;
import com.msk.sl.bean.SL241129Bean;
import com.msk.sl.bean.SL241130Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by gyh on 2016/3/22.
 */
public class SL241130Logic extends BaseLogic {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(SL241117Logic.class);

    @Autowired
    private ProductLogic productLogic;
    @Autowired
    private SL241129Logic sl241129Logic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private Sl241101Logic sl241101Logic;

    /**
     * 卖家申请新品
     * @param paramList 参数
     * @return 结果
     */
    @Transactional(readOnly = false)
    public String saveNewPd(List<SL241130Param> paramList) {
        for(SL241130Param sl241128Param:paramList){
            BasePageParam param = new BasePageParam();
            param.setPaging(false);
            //1.申请品种2.申请特征3.申请净重4.申请报装，查询是否存在
            if(!StringUtil.isNullOrEmpty(sl241128Param.getNewFlag())){
                sl241128Param.setChooseInfo(sl241128Param.getNewFlag());
            }
            if(StringUtil.isNullOrEmpty(sl241128Param.getProviderCode())){
                sl241128Param.setProviderCode(sl241128Param.getCrtId());
                param.setFilter("slCode",sl241128Param.getCrtId());
                List<SL241101Bean> beans=sl241101Logic.findPageList(param, SL241101Bean.class);
                if(CollectionUtils.isEmpty(beans)||beans.size()<1){
                    throw new BusinessException("创建者ID/卖家编码为："+sl241128Param.getCrtId()+"不存在，请检查后提交！");
                }else{
                    SL241101Bean bean=beans.get(0);
                    sl241128Param.setProviderName(bean.getSlShowName());
                }
            }
            param.setFilter("classesCode", sl241128Param.getClassesCode());
            param.setFilter("machiningCode", sl241128Param.getMachiningCode());
            param.setFilter("breedCode", sl241128Param.getBreedCode());
            param.setFilter("featureCode", sl241128Param.getFeatureCode());
            param.setFilter("weightCode", sl241128Param.getWeightCode());
            if ("1".equals(sl241128Param.getChooseInfo())) {
                param.setFilter("breedName", sl241128Param.getBreedName());
                List<PdBreed> breeds = productLogic.findPdBreed(param);
                //查询产品是否存在该品种，存在则提示，不存在再检查是否已经注册过
                if (!CollectionUtils.isEmpty(breeds) && breeds.size() > 0) {
                    throw new BusinessException("申请品种名称为："+sl241128Param.getBreedName()+"已经存在！");
                } else {
                    List<SL241129Bean> beans = sl241129Logic.findPageList(param, SL241129Bean.class);
                    if (!CollectionUtils.isEmpty(beans) && beans.size() > 0) {
                        throw new BusinessException("申请品种名称为："+sl241128Param.getBreedName()+"已在申请中！");
                    }
                }
            } else if ("2".equals(sl241128Param.getChooseInfo())) {
                param.setFilter("featureName", sl241128Param.getFeatureName());
                List<PdFeature> features = productLogic.findPdFeature(param);
                if (!CollectionUtils.isEmpty(features) && features.size() > 0) {
                    throw new BusinessException("申请特征名称为："+sl241128Param.getFeatureName()+"已经存在！");
                } else {
                    List<SL241129Bean> beans = sl241129Logic.findPageList(param, SL241129Bean.class);
                    if (!CollectionUtils.isEmpty(beans) && beans.size() > 0) {
                        throw new BusinessException("申请特征名称为："+sl241128Param.getFeatureName()+"已在申请中！");
                    }
                }
            } else if ("3".equals(sl241128Param.getChooseInfo())) {
                param.setFilter("weightName", sl241128Param.getWeightName());
                param.getFilterMap().put("weightVal", sl241128Param.getWeightVal());
                List<PdWeight> weights = productLogic.findPdWeight(param);
                if (!CollectionUtils.isEmpty(weights) && weights.size() > 0) {
                    throw new BusinessException("申请净重名称为："+sl241128Param.getWeightName()+"已经存在！");
                } else {
                    List<SL241129Bean> beans = sl241129Logic.findPageList(param, SL241129Bean.class);
                    if (!CollectionUtils.isEmpty(beans) && beans.size() > 0) {
                        throw new BusinessException("申请净重名称为："+sl241128Param.getWeightName()+"已在申请中！");
                    }
                }
            } else{
                sl241128Param.setChooseInfo("4");
                sl241128Param.setNormsName(sl241128Param.getNormsOut());
                param.setFilter("normsSuttle", sl241128Param.getNormsSuttle());
                param.setFilter("normsError", sl241128Param.getNormsError());
                param.setFilter("normsNumber", sl241128Param.getNormsNumber());
                param.setFilter("normsSize", sl241128Param.getNormsSize());
                param.setFilter("normsTexture", sl241128Param.getNormsTexture());
                param.setFilter("normsOut", sl241128Param.getNormsOut());
                param.setFilter("normsKg", sl241128Param.getNormsKg());
                param.setFilter("normsOutSize", sl241128Param.getNormsOutSize());
                param.setFilter("normsOutTexture", sl241128Param.getNormsOutTexture());
                param.setFilter("normsTen", sl241128Param.getNormsTen());
                param.getFilterMap().put("normsLength", sl241128Param.getNormsLength());
                param.getFilterMap().put("normsWidth", sl241128Param.getNormsWidth());
                param.getFilterMap().put("normsHeight", sl241128Param.getNormsHeight());
                param.getFilterMap().put("normsVolume", sl241128Param.getNormsVolume());
                param.getFilterMap().put("netweightInner", sl241128Param.getNetweightInner());
                param.getFilterMap().put("netweightOut", sl241128Param.getNetweightOut());
                param.getFilterMap().put("grossweightOut", sl241128Param.getGrossweightOut());
                List<PdNormsStd> normsStds = productLogic.findPdNormsStd(param);
                if (!CollectionUtils.isEmpty(normsStds) && normsStds.size() > 0) {
                    throw new BusinessException("申请外包装规格为："+sl241128Param.getNormsOut()+"已经存在！");
                } else {
                    List<SL241129Bean> beans = sl241129Logic.findPageList(param, SL241129Bean.class);
                    if (!CollectionUtils.isEmpty(beans) && beans.size() > 0) {
                        throw new BusinessException("申请外包装规格为："+sl241128Param.getNormsOut()+"已在申请中！");
                    }
                }
            }
            sl241128Param.setTcProviderId(commonLogic.maxId("PD_TC_PROVIDER_PACKAGE", "TC_PROVIDER_ID"));
            sl241128Param.setFeatureFlg(0);
            sl241128Param.setDelFlg("0");
            sl241128Param.setAuditStatus(0);
            this.save(sl241128Param);
        }
        return "卖家申请新品成功！";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
