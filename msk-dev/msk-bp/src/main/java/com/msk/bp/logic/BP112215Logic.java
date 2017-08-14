package com.msk.bp.logic;

import com.msk.bp.bean.BP112215Bean;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * yang_yang
 */
@Service
public class BP112215Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BP112215Logic.class);

    @Autowired
    private ProductLogic productLogic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author yang_yang
     */
    private interface SqlId {
        String SQL_ID_FIND_ORDERLEVELLIST = "getOrderLevelList";
        String SQL_ID_GET_BREADS="getBreeds";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 价盘平台查看
     * @return
     */
    public PageResult<BP112215Bean> findBP112215List(BasePageParam pageParam) {
        logger.info("价盘平台查看");
        PageResult<BP112215Bean> result = this.findPage(pageParam, BP112215Bean.class);

        List<BP112215Bean> list = result.getData();
        for(BP112215Bean bean : list){

            //根据产品Code获取产品信息
            ProductBean product = this.productLogic.getProductInfo(bean.getPdCode());
            if (product == null) {
                logger.info("产品编号:" + bean.getPdCode() + "没有相关产品");
                throw new BusinessException("产品编号:" + bean.getPdCode() + "没有相关产品");
            }

            if(product.getPdBreed() != null){
                bean.setPdName(product.getPdBreed().getBreedName());
            }else{
                bean.setPdName("");
            }
            if(product.getPdFeature() != null){
                bean.setFeatureName(product.getPdFeature().getFeatureName());
            }else{
                bean.setFeatureName("");
            }
            if(product.getPdMachining() != null){
                bean.setMachining(product.getPdMachining().getMachiningName());
            }else{
                bean.setMachining("");
            }
            if(product.getPdGrade() != null){
                bean.setPdGrade(product.getPdGrade().getGradeName());
            }else{
                bean.setPdGrade("");
            }
            //折后报价
            //bean.setAfterPrice(bean.getPriceofkg().multiply(bean.getDiscount()));
        }

        return result;
    }

    /**
     * 获取订单等级列表
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<BP112215Bean> getOrderLevelList(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_ORDERLEVELLIST, param);
    }

    /**
     * 获取匹配的品名列表
     * @param breedName
     * @return
     */
    public List<BP112215Bean> getBreeds(String breedName){
        List<BP112215Bean> list = null;
        if(breedName != null && !"".equals(breedName)){
            list = new ArrayList<>();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("breedName",breedName);
            list = this.findList(map, SqlId.SQL_ID_GET_BREADS);
        }

        return list;
    }
}
