package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByBuyerBasicInfo;
import com.msk.core.entity.SoStockSl;
import com.msk.pd.bean.IPD141144RsParam;
import com.msk.pd.bean.IPD141144RsProductsResult;
import com.msk.pd.bean.IPD141144RsResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * 卖家产品库存查询
 * xhy
 */
@Service
public class IPD141144Logic extends BaseLogic {

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
    public IPD141144RsResult findListSl(IPD141144RsParam param) {
        if (param == null) param = new IPD141144RsParam();
        IPD141144RsResult result = new IPD141144RsResult();
        if (StringUtils.isNotBlank(param.getUserMobile())) {
            ByBuyerBasicInfo info = super.findOne(SqlId.SQL_FIND_ONE_NUMBER, param);
            //获取买家id
            if (null != info) {
                //当前的是稳定.或者申请中的数据    获取最大库存数
                if (param.getSellerType() == NumberConst.IntDef.INT_ONE) {
                    List<IPD141144RsProductsResult> results = super.findList(param);
                    if (results.size() > NumberConst.IntDef.INT_ZERO) {
                        IPD141144RsProductsResult isBean = results.get(NumberConst.IntDef.INT_ZERO);
                        result.setSellerCode(isBean.getSlCode());
                        result.setDistrictCode(isBean.getDistrictCode());
                        for (IPD141144RsProductsResult bean : results) {
                            bean.setDistrictCode(null);
                            bean.setSlCode(null);
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
                        }
                        result.setProducts(results);
                        return result;
                    }
                    return result;
                } else if (param.getSellerType() == NumberConst.IntDef.INT_TWO) {
                    IPD141144RsResult result1 = super.findOne(SqlId.SQL_ID_SP, param);
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
    private IPD141144RsResult mutualMethod(IPD141144RsParam param, IPD141144RsResult result) {
        if (param.getSellerType() == NumberConst.IntDef.INT_ONE) {
            List<IPD141144RsProductsResult> results = super.findList(param);
            if (results.size() > NumberConst.IntDef.INT_ZERO) {
                IPD141144RsProductsResult isBean = results.get(NumberConst.IntDef.INT_ZERO);
                result.setSellerCode(isBean.getSlCode());
                result.setDistrictCode(isBean.getDistrictCode());
                for (IPD141144RsProductsResult bean : results) {
                    bean.setDistrictCode(null);
                    bean.setSlCode(null);
                    if (bean.getStockCnt().intValue() <= NumberConst.IntDef.INT_ZERO) {
                        bean.setStockCnt(new BigDecimal(NumberConst.IntDef.INT_ZERO));
                    }
                }
                result.setProducts(results);
                return result;
            }
            return result;
        } else if (param.getSellerType() == NumberConst.IntDef.INT_TWO) {
            IPD141144RsResult result1 = super.findOne(SqlId.SQL_ID_SP, param);
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
     * @param result
     * @return
     */
    private IPD141144RsResult restResult(IPD141144RsResult result) {
        List<IPD141144RsProductsResult> results = result.getProducts();
        for (IPD141144RsProductsResult bean : results) {
            if (bean.getStockCnt().intValue() <= NumberConst.IntDef.INT_ZERO) {
                bean.setStockCnt(new BigDecimal(NumberConst.IntDef.INT_ZERO));
            }
        }
        result.setProducts(results);
        return result;
    }
    //Add Bug #2660 产品库存查询接口IPD141144 增加库存计算结果是负数的异常处理。 2016/09/13 BY杨春艳 Start
}
