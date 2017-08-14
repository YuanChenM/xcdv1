package com.msk.bp.logic;

import com.msk.bp.bean.IBP11291IProducts;
import com.msk.bp.bean.IBP11291IProductsRsResult;
import com.msk.bp.bean.IBP11291IRsParam;
import com.msk.bp.bean.IBP11291IRsResult;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 美侍客价盘查询IBP11291ILogic
 *
 * @author xu_wei
 */
@Service
public class IBP11291ILogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBP11291ILogic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SqlId. sql定义
     *
     * @author xu_wei
     */
    interface SqlId {
        String SQL_ID_FIND_PD_INFO = "findpdInfo";
        String SQL_ID_FIND_PRICE_LIST = "findPriceList";
    }

    private String itemLengthValue = "_";
    /**
     * 美侍客价盘查询
     *
     * @param param param
     * @return 返回结果
     * @author xu_wei
     */
    public IBP11291IRsResult findAllList(RsRequest<IBP11291IRsParam> param) {
        IBP11291IRsResult rs = new IBP11291IRsResult();
        IBP11291IRsParam ibp11291IRsParam = param.getParam();
        BaseParam params = new BaseParam();
        params.setFilter("pricePeriod", ibp11291IRsParam.getPricePeriod());
        params.setFilter("logiAreaCode", ibp11291IRsParam.getLogiAreaCode());
        params.setFilter("slCode", ibp11291IRsParam.getSlCode());
        params.setFilter("pdCode", validatorData(ibp11291IRsParam));
        List<IBP11291IProducts> productsInfolist = super.findList(SqlId.SQL_ID_FIND_PD_INFO, params);
        if (!CollectionUtils.isEmpty(productsInfolist)) {
            for(IBP11291IProducts ibp11291IProducts:productsInfolist){
                params.setFilter("productCode", ibp11291IProducts.getProductCode());
                List<IBP11291IProductsRsResult> productsDetaillist = super.findList(SqlId.SQL_ID_FIND_PRICE_LIST, params);
                if (CollectionUtils.isEmpty(productsDetaillist)) {
                    throw new BusinessException("美侍客卖家产品价盘详细没有对应的记录");
                }
                ibp11291IProducts.setPricelist(productsDetaillist);
            }
        }else{
            throw new BusinessException("美侍客卖家产品价盘没有对应的记录");
        }
        rs.setProductslist(productsInfolist);
        return rs;
    }

    public String validatorData(IBP11291IRsParam ibp11291IRsParam) {
        String pdCode = null;
        if(null!= ibp11291IRsParam){
            //产品类别编码
            String classesCode = checkValue(ibp11291IRsParam.getClassesCode(), NumberConst.IntDef.INT_TWO);
            //产品二级分类编码
            String machiningCode = checkValue(ibp11291IRsParam.getMachiningCode(), NumberConst.IntDef.INT_ONE);
            //产品种类编码
            String breedCode = checkValue(ibp11291IRsParam.getBreedCode(), NumberConst.IntDef.INT_TWO);
            //产品特征编码
            String featureCode = checkValue(ibp11291IRsParam.getFeatureCode(), NumberConst.IntDef.INT_TWO);
            //产品净重编码
            String weightCode = checkValue(ibp11291IRsParam.getWeightCode(), NumberConst.IntDef.INT_TWO);
            //产品等级编码
            String gradeCode = checkValue(ibp11291IRsParam.getGradeCode(), NumberConst.IntDef.INT_ONE);
            pdCode = classesCode + machiningCode + breedCode + featureCode + weightCode + gradeCode;
        }
        return pdCode;
    }

    public String checkValue(String item, int length) {
        String itemValue = "";
        if(item != null){
            return checkLength(item, length);
        }
        for(int i=0;i<length;i++){
            itemValue  = itemValue.toString() + itemLengthValue.toString();
        }
        return itemValue;
    }
    public String checkLength(String item, int length) {
        if(item.length() != length){
            throw new BusinessException("参数位数不正确。");
        }
        return item;
    }
}
