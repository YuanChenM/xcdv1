package com.msk.so.logic;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import com.msk.so.bean.ISO251401RsParam;
import com.msk.so.bean.ISO251401RsProduct;
import com.msk.so.bean.ISO251401RsResult;
import com.msk.so.bean.StockParam;
import com.msk.so.bean.order.OrderListSearchParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 创建需求订单ISO251401Logic.
 *
 * @author gyh
 */
@Service
public class ISO251401Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO251401Logic.class);
    @Autowired
    private StockLogic stockLogic;
    @Autowired
    private OrderLogic orderLogic;
    @Autowired
    private ProductLogic productLogic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private com.msk.so.logic.rs.ISO151416Logic ISO151416Logic;

    /**
     * 创建购物需求订单
     *
     * @param iso251401RsParam 接口入参
     * @param siteCode 系统编码
     * @return 返回结果
     * @author gyh
     */
    @Transactional(readOnly = false)
    public ISO251401RsResult createSoPro(ISO251401RsParam iso251401RsParam ,String siteCode) {
        logger.debug("构建需求订单");
        ISO251401RsResult rs = new ISO251401RsResult();
//        String siteCode = param.getSiteCode();
//        ISO251401RsParam iso251401RsParam = param.getParam();
//        iso251401RsParam.setCrtId(param.getLoginId());
        iso251401RsParam.setCrtTime(DateTimeUtil.getCustomerDate());
        SoPro sopro = new SoPro();
        SoProDetail soProDetail = new SoProDetail();
        BaseParam param2 = new BaseParam();
        //获取需求最大ID
        Long proMaxId = commonLogic.maxId("so_pro", "PRO_ID");
        sopro.setProId(proMaxId + 1);
        // 需求订单编号
        sopro.setProCode(orderLogic.getProCode(iso251401RsParam.getBuyersCode()));
        sopro.setDistrictCode(iso251401RsParam.getDistrictCode());
        //当系统编号是110的时候为微商城平台，买家信息从买家基本信息表里获取
        if(CommCodeMasterConst.SystemCode.SYSTEM_CODE_WSC.equals(siteCode)){
            OrderListSearchParam orderListSearchParam = new OrderListSearchParam();
            orderListSearchParam.setTel(iso251401RsParam.getBuyersCode());
            ByBuyerBasicInfo buyerBasicInfo = this.ISO151416Logic.getBasicBuyerInfo(orderListSearchParam);
            if( null != buyerBasicInfo){
                sopro.setBuyersId(buyerBasicInfo.getBuyerId());
                sopro.setBuyersCode(buyerBasicInfo.getBuyerCode());
                sopro.setBuyersName(buyerBasicInfo.getBuyerName());
                sopro.setBuyersType(Integer.valueOf(buyerBasicInfo.getSuperiorType()));
            }
        }else {
            sopro.setBuyersId(iso251401RsParam.getBuyersId());
            sopro.setBuyersCode(iso251401RsParam.getBuyersCode());
            sopro.setBuyersName(iso251401RsParam.getBuyersName());
            sopro.setBuyersType(Integer.parseInt(iso251401RsParam.getBuyersType()));
        }
        sopro.setSellerCode(iso251401RsParam.getSellerCode());
        sopro.setSellerName(iso251401RsParam.getSellerName());
        sopro.setOrderSource(iso251401RsParam.getOrderSource());
        // 需求状态
        sopro.setStatus(NumberConst.IntDef.INT_ONE);
        sopro.setCrtId(iso251401RsParam.getCrtId());
        sopro.setCrtTime(iso251401RsParam.getCrtTime());
        int num = super.save(sopro);
        if (num > 0) {
            SoPro soProInfo = super.findOne(SqlId.SQL_ID_FIND_SO_PRO, param2);
            soProDetail.setProId(soProInfo.getProId());
            soProDetail.setProCode(soProInfo.getProCode());
            List<ISO251401RsProduct> products = iso251401RsParam.getProducts();
            // 获取卖家库存所需参数
            StockParam stockParam = new StockParam();
            // 买家编码
            stockParam.setSlCode(iso251401RsParam.getSellerCode());
            // 物流区编码
            stockParam.setLgcsCode(iso251401RsParam.getDistrictCode());
            for (ISO251401RsProduct iso251401RsProduct : products) {
                // 调用产品编码拆分方法
                Long proDetailMaxId = commonLogic.maxId("so_pro_detail", "PRO_DETAIL_ID");
                soProDetail.setProDetailId(proDetailMaxId);
                ProductBean productBean = productLogic.getProductInfo(iso251401RsProduct.getPdCode());
                if (null != productBean) {
                    // 产品类别对象
                    PdClasses pdClasses = productBean.getPdClasses();
                    // 产品品种对象
                    PdBreed pdBreed = productBean.getPdBreed();
                    // 产品特征对象
                    PdFeature pdFeature = productBean.getPdFeature();
                    // 产品等级对象
                    PdGrade pdGrade = productBean.getPdGrade();
                    // 产品包装
                    PdNormsStd pdNormsStd = productBean.getPdNormsStd();
                    // 产品编码
                    stockParam.setPdCode(iso251401RsProduct.getPdCode());
                    stockParam.setStockNum(iso251401RsProduct.getOrderQty());
//                    // 获取卖家库存并判断库存数量
//                    StockBean stockBean = stockLogic.getSlStock(stockParam);
//                    if (!CollectionUtils.isEmpty(stockBean.getSoSlStockList())) {
//                        if (!stockLogic.checkStockQty(stockParam)) {
//                            throw new BusinessException(iso251401RsProduct.getPdName() + "库存不足,请酌情减量！");
//                        }
//                    } else {
//                        throw new BusinessException(iso251401RsProduct.getPdName() + "无库存，请联系管理员处理！");
//                    }
                    if (null != pdClasses) {
                        soProDetail.setClassesCode(pdClasses.getClassesCode());
                        soProDetail.setClassesName(pdClasses.getClassesName());
                    }
//                    else {
//                        throw new BusinessException("该产品编码对应类别无记录:" + iso251401RsProduct.getPdCode());
//                    }
                    if (null != pdBreed) {
                        soProDetail.setBreedCode(pdBreed.getBreedCode());
                        soProDetail.setBreedName(pdBreed.getBreedName());
                    }
//                    else {
//                        throw new BusinessException("该产品编码对应品种无记录:" + iso251401RsProduct.getPdCode());
//                    }
                    if (null != pdFeature) {
                        soProDetail.setFeatureCode(pdFeature.getFeatureCode());
                        soProDetail.setFeatureName(pdFeature.getFeatureName());
                    }
//                    else {
//                        throw new BusinessException("该产品编码对应特征无记录:" + iso251401RsProduct.getPdCode());
//                    }
                    if (null != pdNormsStd) {
                        soProDetail.setNormsCode(pdNormsStd.getNormsCode());
                        soProDetail.setNormsName(pdNormsStd.getNormsOut());
                        // 单箱体积
                        soProDetail.setPackingVolume(pdNormsStd.getNormsVolume());
                        // 重量
                        soProDetail.setPdWeight(pdNormsStd.getNetweightOut());
                        // 体积
                        if (pdNormsStd.getNormsVolume() != null) {
                        soProDetail.setPdVolume(pdNormsStd.getNormsVolume().multiply(iso251401RsProduct.getOrderQty()));
                        } else {
                        soProDetail.setPdVolume(pdNormsStd.getNormsVolume());
                        }
                    }
//                    else {
//                        throw new BusinessException("该产品编码对应包装无记录:" + iso251401RsProduct.getPdCode());
//                    }
                    if (null != iso251401RsProduct) {
                        soProDetail.setPdCode(iso251401RsProduct.getPdCode());
                        soProDetail.setPdName(iso251401RsProduct.getPdName());
                    } else {
                        throw new BusinessException("该产品编码无记录:" + iso251401RsProduct.getPdCode());
                    }
                    if(null!=pdGrade){
                        soProDetail.setPdGradeCode(pdGrade.getGradeCode());
                        soProDetail.setPdGradeName(pdGrade.getGradeName());
                    }
                    // 产品单位，暂时取得单个产品净重
                    soProDetail.setPdUnit(null);

                    // 订单价格
                    soProDetail.setOrderPrice(iso251401RsProduct.getOrderPrice());
                    // 价盘周期
                    soProDetail.setPriceCycle(iso251401RsProduct.getPriceCycle());
                    // 订单数量
                    soProDetail.setOrderQty(iso251401RsProduct.getOrderQty());
                    soProDetail.setCrtId(iso251401RsParam.getCrtId());
                    soProDetail.setCrtTime(iso251401RsParam.getCrtTime());
                    super.save(SqlId.SQL_ID_FIND_PRO_DETAIL_SAVE, soProDetail);
                    rs.setProCode(soProInfo.getProCode());
                } else {
                    throw new BusinessException("该产品编码无记录:" + iso251401RsProduct.getPdCode());
                }
            }
        }
        return rs;
    }

    /**
     * 检查买手信息是否正确 并且查询买手基本信息
     * @param param
     */
    public void checkBuyersInfo(ISO251401RsParam param){
        if (StringUtils.isEmpty(param.getBuyersName())){
            throw new BusinessException("买手名称不能为空");
        }

        SoOrder soOrder = super.findOne(SqlId.SQL_ID_GET_BUYERS_INFO,param);
        if (null == soOrder){
            throw new BusinessException("这个买手不存在");
        }
        param.setBuyersId(soOrder.getBuyersId());
        param.setBuyersCode(soOrder.getBuyersCode());
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SqlId. sql定义
     *
     * @author gyh
     */
    interface SqlId {
        String SQL_ID_FIND_SO_PRO = "findPro";
        String SQL_ID_FIND_PRO_DETAIL_SAVE = "saveProDetail";
        String SQL_ID_GET_BUYERS_INFO = "getBuyersInfo";
    }

}
