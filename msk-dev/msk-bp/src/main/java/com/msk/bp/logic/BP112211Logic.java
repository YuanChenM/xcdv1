package com.msk.bp.logic;

import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.common.utils.PriceCycleUtils;
import com.msk.core.base.BaseDao;
import com.msk.core.bean.PageResult;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.exception.BusinessException;
import com.msk.pd.logic.ProductLogic;
import com.msk.bp.bean.BP112211Bean;
import com.msk.pd.bean.ProductBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.common.bean.PriceCycle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * Created by yang_chunyan on 2016/3/29.
 */
@Service
public class BP112211Logic extends BaseLogic{


    private static Logger logger = LoggerFactory.getLogger(BP112211Logic.class);

    @Autowired
    private ProductLogic productLogic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SqlId. 方法名
     */
    interface SqlId {
        String FINDQUOTATIONCOUNTBYPDCODE = "findQuotationCountByPDCode";
        String FINDDISTRICTNAMELIST = "findDistrictNameList";
    }

    /**
     * 美侍客卖家产品库存一览分页查询
     * @param pageParam
     * @return
     */
    public PageResult<BP112211Bean> findBP112211BeansList(BasePageParam pageParam) {
        logger.info("美侍客卖家产品库存一览");
        PageResult<BP112211Bean> result = this.findPage(pageParam, BP112211Bean.class);
        PageResult<BP112211Bean> newResult = new PageResult<BP112211Bean>();
        List<BP112211Bean> beans = result.getData();
        List<BP112211Bean> newList = new ArrayList<BP112211Bean>();
        int count = this.getPageCount(pageParam);
        for(BP112211Bean bean : beans){
            //根据产品Code获取产品信息
            String pdCode = bean.getPdCode();
            ProductBean product = this.productLogic.getProductInfo(pdCode);
            if (product == null) {
                logger.info("产品编号:" + pdCode + "没有相关产品");
                throw new BusinessException("产品编号:" + pdCode + "没有相关产品");
            }

            Date dateNow = DateTimeUtil.getCustomerDate();
            PriceCycle priceCycle = PriceCycleUtils.getNextPriceCycle(dateNow, NumberConst.IntDef.INT_ZERO);

            if(null != product.getPdWeight()){
                bean.setPdWeight(product.getPdWeight().getWeightName());
                bean.setWeightVal(product.getPdWeight().getWeightVal());
                bean.setStockWeight((product.getPdWeight().getWeightVal()).multiply(bean.getStockWeight()));
            }else{
                bean.setPdWeight("");
                bean.setWeightVal(BigDecimal.ZERO);
                bean.setStockWeight(BigDecimal.ZERO);
            }

            if(null != product.getPdFeature()){
                bean.setFeacherName(product.getPdFeature().getFeatureName());
            }else{
                bean.setFeacherName("");
            }
            if(null != product.getPdGrade()){
                bean.setPdLevel(product.getPdGrade().getGradeName());
            }else{
                bean.setPdLevel("");
            }
            if(null != product.getPdMachining()){
                bean.setMachining(product.getPdMachining().getMachiningName());
            }else{
                bean.setMachining("");
            }

            if(null != product.getPdBreed()){
                bean.setPdName(product.getPdBreed().getBreedName());
            }else{
                bean.setPdName("");
            }
            //报价状态
            BP112211Bean quoBean = findQuotationCountByPDCode(bean,priceCycle);
            if( quoBean.getNcount() == 0)
            {
                bean.setQuotationStatus("未报价");
                bean.setPricecycleId(0l);
            }
            else
            {
                bean.setQuotationStatus("报价中");
                bean.setPricecycleId(quoBean.getPricecycleId());
                bean.setCycleCode(quoBean.getCycleCode());
            }
            newList.add(bean);
        }
        newResult.setData(newList);
        newResult.setRecordsTotal(count);
        return newResult;
    }

    public BP112211Bean findQuotationCountByPDCode(BP112211Bean bean,PriceCycle priceCycle)
    {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pdCode",bean.getPdCode());
        map.put("slCode",bean.getSlCode());
        map.put("lgcsCode",bean.getLgcsCode());
        map.put("period",priceCycle.getCycleCode());
        return this.findOne(SqlId.FINDQUOTATIONCOUNTBYPDCODE, map);
    }

    public List<BP112211Bean> findDistrictNameList(){
          return this.findList(SqlId.FINDDISTRICTNAMELIST,null);
    }
}
