package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByBuyerBasicInfo;
import com.msk.core.entity.SoStockSl;
import com.msk.so.bean.ISO151401RsParam;
import com.msk.so.bean.ISO151401RsProductsResult;
import com.msk.so.bean.ISO151401RsResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * 卖家产品库存查询
 * sjj
 */
@Service
public class ISO151401Logic extends BaseLogic {

    interface SqlId {
        static final String SQL_ID_SP = "findOneSp";
        static final String SQL_FIND_ONE_NUMBER = "findOnePhoneNumber";
        static final String SQL_FIND_ONE_EXIST_SL = "findOneSlOne";


    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 原种种源信息同步接口
     *
     * @return
     */
    @Transactional(readOnly = true)
    public ISO151401RsResult findListSl(ISO151401RsParam param) {
        if (param == null) param = new ISO151401RsParam();
        ISO151401RsResult result = new ISO151401RsResult();
        if (StringUtils.isNotBlank(param.getUserMobile())) {
            ByBuyerBasicInfo info = super.findOne(SqlId.SQL_FIND_ONE_NUMBER, param);
            //获取买家id
            if (null != info) {
                //当前的是稳定.或者申请中的数据    获取最大库存数
                if (param.getSellerType() == NumberConst.IntDef.INT_ONE) {
                    List<ISO151401RsProductsResult> results = super.findList(param);
                    if (results.size() > NumberConst.IntDef.INT_ZERO) {
                        ISO151401RsProductsResult isBean = results.get(NumberConst.IntDef.INT_ZERO);
                        result.setSellerCode(isBean.getSlCode());
                        result.setDistrictCode(isBean.getDistrictCode());
                        result.setDistrictName(isBean.getDistrictName());
                        for (ISO151401RsProductsResult bean : results) {
                            bean.setDistrictCode(null);
                            bean.setSlCode(null);
                            bean.setDistrictName(null);
                            //获取库存最大数
//                            param.setFilter("pdCodeInfo", bean.getPdCode());
//                            param.setFilter("slCodeBig", info.getBuyerCode());
//                            SoStockSl sp = super.findOne(SqlId.SQL_FIND_ONE_EXIST_SL, param);
//                            if (null != sp) {
//                                bean.setStockCnt(bean.getStockCnt().max(sp.getStockQty()));
//                            }
                            if (bean.getStockCnt().intValue() <= NumberConst.IntDef.INT_ZERO) {
                                bean.setStockCnt(new BigDecimal(NumberConst.IntDef.INT_ZERO));
                            }
                            bean.setOnhandQty(bean.getStockCnt());
                            bean.setAllocatedQty(BigDecimal.ZERO);
                        }
                        result.setProducts(results);
                        return result;
                    }
                    return result;
                } else if (param.getSellerType() == NumberConst.IntDef.INT_TWO) {
                    ISO151401RsResult result1 = super.findOne(SqlId.SQL_ID_SP, param);
                    if (result1 != null && result1.getProducts().size() > NumberConst.IntDef.INT_ZERO)
                        //Modify Bug #2660 产品库存查询接口IPD141144 增加库存计算结果是负数的异常处理。 2016/09/13 BY杨春艳 Start
                        return restResult(result1);
                    //Modify Bug #2660 产品库存查询接口IPD141144 增加库存计算结果是负数的异常处理。 2016/09/13 BY杨春艳 Start
                }
                return null;
            } else {
                return this.mutualMethod(param, result);
            }
        } else {
            return this.mutualMethod(param, result);
        }
    }


    /**
     * 查询库存共通方法
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    private ISO151401RsResult mutualMethod(ISO151401RsParam param, ISO151401RsResult result) {
        if (param.getSellerType() == NumberConst.IntDef.INT_ONE) {
            List<ISO151401RsProductsResult> results = super.findList(param);
            if (results.size() > NumberConst.IntDef.INT_ZERO) {
                ISO151401RsProductsResult isBean = results.get(NumberConst.IntDef.INT_ZERO);
                result.setSellerCode(isBean.getSlCode());
                result.setDistrictCode(isBean.getDistrictCode());
                result.setDistrictName(isBean.getDistrictName());
                for (ISO151401RsProductsResult bean : results) {
                    bean.setDistrictCode(null);
                    bean.setSlCode(null);
                    bean.setDistrictName(null);
                    if (bean.getStockCnt().intValue() <= NumberConst.IntDef.INT_ZERO) {
                        bean.setStockCnt(new BigDecimal(NumberConst.IntDef.INT_ZERO));
                    }
                    bean.setOnhandQty(bean.getStockCnt());
                    bean.setAllocatedQty(BigDecimal.ZERO);
                }
                result.setProducts(results);
                return result;
            }
            return result;
        } else if (param.getSellerType() == NumberConst.IntDef.INT_TWO) {
            ISO151401RsResult result1 = super.findOne(SqlId.SQL_ID_SP, param);
            if (result1 != null && result1.getProducts().size() > NumberConst.IntDef.INT_ZERO)
                //Modify Bug #2660 产品库存查询接口IPD141144 增加库存计算结果是负数的异常处理。 2016/09/13 BY杨春艳 Start
                return restResult(result1);
            //Modify Bug #2660 产品库存查询接口IPD141144 增加库存计算结果是负数的异常处理。 2016/09/13 BY杨春艳 Start
        }
        return null;
    }

    //Add Bug #2660 产品库存查询接口IPD141144 增加库存计算结果是负数的异常处理。 2016/09/13 BY杨春艳 Start

    /**
     * 重新组装
     *
     * @param result
     * @return
     */
    private ISO151401RsResult restResult(ISO151401RsResult result) {
        List<ISO151401RsProductsResult> results = result.getProducts();
        for (ISO151401RsProductsResult bean : results) {
            if (bean.getStockCnt().intValue() <= NumberConst.IntDef.INT_ZERO) {
                bean.setStockCnt(new BigDecimal(NumberConst.IntDef.INT_ZERO));
            }
            bean.setOnhandQty(bean.getStockCnt());
            bean.setAllocatedQty(BigDecimal.ZERO);
        }
        result.setProducts(results);
        return result;
    }
    //Add Bug #2660 产品库存查询接口IPD141144 增加库存计算结果是负数的异常处理。 2016/09/13 BY杨春艳 Start
}
