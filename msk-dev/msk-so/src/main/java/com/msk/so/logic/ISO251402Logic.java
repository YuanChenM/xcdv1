package com.msk.so.logic;

import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.entity.SoOrderReceiveDemand;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import com.msk.so.bean.DeliveryReqParam;
import com.msk.so.bean.ISO251402RsParam;
import com.msk.so.bean.ISO251402RsResult;
import com.msk.so.bean.StockParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * ISO251402Logic.
 *
 * @author pxg
 */
@Service
public class ISO251402Logic extends BaseLogic {

    @Autowired
    private StockLogic stockLogic;
    @Autowired
    private ProductLogic productLogic;
    @Autowired
    private OrderLogic orderLogic;
    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * @param param 保存参数
     * @return 返回值大小
     * @author pxg
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public ISO251402RsResult save(RsRequest<ISO251402RsParam> param) {
        ISO251402RsResult iSO251402RsResult = new ISO251402RsResult();
        // 订单主表添加
        SoOrder soOrder = param.getParam();
        //BaseParam parm = new BaseParam();
        //SoOrder orderId = super.findOne(parm);
        String orderCode = orderLogic.getOrderCode(param.getParam().getOrderType(), param.getParam().getBuyersCode(), null);
        Date date = new Date();
        Long orderId = commonLogic.maxId("SO_ORDER", "ORDER_ID");
        soOrder.setOrderId(orderId);
        soOrder.setOrderCode(orderCode);
        //订单辅助码
        soOrder.setOrderViceCode(orderLogic.getOrderCode(date));
        //购物需求ID
        soOrder.setProId(param.getParam().getProId());
        //购物需求编码
        soOrder.setProCode(param.getParam().getProCode());
        //需求订单编码
        soOrder.setRequireOrderCode(soOrder.getOrderCode());
        //确认订单编码
        soOrder.setConfirmOrderCode("");
        //配送订单编码
        soOrder.setDeliveryOrderCode("");
        //卖家编码
        soOrder.setSellerCode(param.getParam().getSellerCode());
        //卖家名称
        soOrder.setSellerName(param.getParam().getSellerName());
        //买家ID
        soOrder.setBuyersId(param.getParam().getBuyersId());
        //买家编码
        soOrder.setBuyersCode(param.getParam().getBuyersCode());
        //买家名称
        soOrder.setBuyersName(param.getParam().getBuyersName());
        //买家类型
        soOrder.setBuyersType(param.getParam().getBuyersType());
        //是否需要发票
        soOrder.setNeedInvoice(param.getParam().getNeedInvoice());
        //订单状态
        if (param.getParam().getPaymentType() == NumberConst.IntDef.INT_ONE) {
            soOrder.setOrderStatus(StatusConst.OrderStatusDef.OBLIGATION);
        }
        if (param.getParam().getPaymentType() == NumberConst.IntDef.INT_TWO) {
            soOrder.setOrderStatus(StatusConst.OrderStatusDef.WAIT_DISTRIBUTION);
        }
        //订单所属区域
        soOrder.setDistrictCode(param.getParam().getDistrictCode());
        //订单来源
        soOrder.setOrderSource(Integer.parseInt(param.getSiteCode()));
        //订单类型
        soOrder.setOrderType(param.getParam().getOrderType());
        //订单创建时间
        soOrder.setOrderTime(date);
        //订单总金额
        soOrder.setOrderAmount(param.getParam().getOrderAmount());
        //付款类型
        soOrder.setPaymentType(param.getParam().getPaymentType());
        //直销员
        soOrder.setSellers(param.getParam().getSellers());
        //订单员
        soOrder.setOrderTaker(param.getParam().getOrderTaker());
        //是否自配送
        soOrder.setSelfDeliveryFlg(param.getParam().getSelfDeliveryFlg());
        //分批发货确认
        soOrder.setSplitDeliveryFlg(param.getParam().getSplitDeliveryFlg());
        //回收站标志
        soOrder.setDustbinFlg(param.getParam().getDustbinFlg());
        //退回标志
        soOrder.setReturnFlg(param.getParam().getReturnFlg());
        //订单发货时间
        soOrder.setOrderSendTime(param.getParam().getOrderSendTime());
        //订单收货时间
        soOrder.setOrderReceiveTime(param.getParam().getOrderReceiveTime());
        //取消类型
        soOrder.setCancelType(param.getParam().getCancelType());
        //取消原因
        soOrder.setCancelReason(param.getParam().getCancelReason());
        soOrder.setCrtTime(date);
        soOrder.setVer(NumberConst.IntDef.INT_ONE);
        soOrder.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
        orderLogic.saveOrder(soOrder);
        // 买家信息添加
        BaseParam parms = new BaseParam();
        SoOrderReceiveDemand receiveDemand = param.getParam().getReceiverInfo();
        DeliveryReqParam deliveryReqParam = param.getParam().getDeliveryReq();
        Long soOrderReceiveMaxId = commonLogic.maxId("so_order_receive_demand", "ID");
        //订单ID
        receiveDemand.setOrderId(Long.valueOf(orderId));
        //订单编码
        receiveDemand.setOrderCode(orderCode);
        receiveDemand.setId(soOrderReceiveMaxId);
        //动检证要求，1:要
        receiveDemand.setVicFlg(deliveryReqParam.getVicFlg());
        //装卸要求
        receiveDemand.setUnloadReq(deliveryReqParam.getUnloadReq());
        //包装要求
        receiveDemand.setPackingReq(deliveryReqParam.getPackingReq());
        //距离门店最近停车距离(米)
        receiveDemand.setParkingDistance(deliveryReqParam.getParkingDistance());
        //其它配送服务要求
        receiveDemand.setOtherDeliveryReq(deliveryReqParam.getOtherDeliveryReq());
        //本次配送服务要求
        receiveDemand.setThisDeliveryReq(deliveryReqParam.getThisDeliveryReq());
        orderLogic.saveOrderReceiveDemand(receiveDemand);
        // 获取卖家库存所需参数
        StockParam stockParam = new StockParam();
        // 买家编码
        stockParam.setSlCode(soOrder.getSellerCode());
        // 物流区编码
        stockParam.setLgcsCode(soOrder.getDistrictCode());
        // 订单明细添加
        List<SoOrderDetail> list = param.getParam().getProducts();
        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                BaseParam parmsThree = new BaseParam();
                SoOrderDetail soOrderDetailAdd = new SoOrderDetail();
                Long soOrderDetailMaxId = commonLogic.maxId("SO_ORDER_DETAIL", "ORDER_DETAIL_ID");
                soOrderDetailAdd.setOrderDetailId(soOrderDetailMaxId);
                SoOrderDetail soOrderDetail = list.get(i);
                //调用产品编码拆分方法
                ProductBean product = productLogic.getProductInfo(soOrderDetail.getPdCode());
                soOrderDetailAdd.setOrderId(Long.valueOf(orderId));
                soOrderDetailAdd.setOrderCode(orderCode);
                soOrderDetailAdd.setOrderDetailType(NumberConst.IntDef.INT_ONE);
                soOrderDetailAdd.setOrderDetailLevel(soOrderDetail.getOrderDetailLevel());
          /*      if (null != product) {
                    if (null != product.getPdClasses()) {
                        soOrderDetailAdd.setClassesCode(StringUtil.toSafeString(product.getPdClasses().getClassesCode()));
                        soOrderDetailAdd.setClassesName(StringUtil.toSafeString(product.getPdClasses().getClassesName()));
                    } else {
                        throw new BusinessException("该产品编码无记录:" + soOrderDetail.getPdCode());
                    }
                        if(null!=product.getPdBreed()){
                            soOrderDetailAdd.setBreedCode(StringUtil.toSafeString(product.getPdBreed().getBreedCode()));
                            soOrderDetailAdd.setBreedName(StringUtil.toSafeString(product.getPdBreed().getBreedName()));
                        }
                        else{
                            throw new BusinessException("该产品编码无记录:"+soOrderDetail.getPdCode());
                        }
                        if(null!=product.getPdFeature()){
                            soOrderDetailAdd.setFeatureCode(StringUtil.toSafeString(product.getPdFeature().getFeatureCode()));
                            soOrderDetailAdd.setFeatureName(StringUtil.toSafeString(product.getPdFeature().getFeatureName()));
                        }
                        else{
                            throw new BusinessException("该产品编码无记录:"+soOrderDetail.getPdCode());
                        }
                        if(null!=product.getPdNormsStd()){
                            soOrderDetailAdd.setNormsCode(product.getPdNormsStd().getNormsCode());
                            soOrderDetailAdd.setNormsName(product.getPdNormsStd().getNormsOut());
                        }
                } else {
                    throw new BusinessException("该产品编码无记录:" + soOrderDetail.getPdCode());
                }*/

                soOrderDetailAdd.setPdCode(soOrderDetail.getPdCode());
                soOrderDetailAdd.setPdName(soOrderDetail.getPdName());
                soOrderDetailAdd.setPdGradeCode(product.getPdGrade().getGradeCode());
                soOrderDetailAdd.setPdGradeName(product.getPdGrade().getGradeName());
                soOrderDetailAdd.setUnit(soOrderDetail.getUnit());

                if (null != product.getPdNormsStd()) {
                    // 单箱体积
                    soOrderDetailAdd.setPackingVolume(product.getPdNormsStd().getNormsVolume());
                    // 重量
                    soOrderDetailAdd.setWeight(new BigDecimal(product.getPdNormsStd().getNormsKg()));
                    // 体积
                    if (product.getPdNormsStd().getNormsVolume() != null) {
                        soOrderDetailAdd.setVolume(product.getPdNormsStd().getNormsVolume().multiply(soOrderDetail.getOrderQty()));
                    }
                }

                soOrderDetailAdd.setAgreeJoint(soOrderDetail.getAgreeJoint());
                soOrderDetailAdd.setIsJoint(soOrderDetail.getIsJoint());
                soOrderDetailAdd.setBuyersConfirmShipments(soOrderDetail.getBuyersConfirmShipments());
                soOrderDetailAdd.setPdPrice(soOrderDetail.getPdPrice());
                soOrderDetailAdd.setPriceCycle(soOrderDetail.getPriceCycle());
                soOrderDetailAdd.setOrderQty(soOrderDetail.getOrderQty());
                soOrderDetailAdd.setSendQty(soOrderDetail.getSendQty());
                soOrderDetailAdd.setReceiveQty(soOrderDetail.getReceiveQty());
                soOrderDetailAdd.setCancelQty(soOrderDetail.getCancelQty());
                soOrderDetailAdd.setReturnQty(soOrderDetail.getReturnQty());
                soOrderDetailAdd.setSendTime(soOrderDetail.getSendTime());
                soOrderDetailAdd.setReceivedTime(soOrderDetail.getReceivedTime());
                soOrderDetailAdd.setDetailStatus(StatusConst.OrderDetailStatusDef.WAIT_DISTRIBUTION);
                //第二版本取消配送顺序
                //soOrderDetailAdd.setDelivrySeq(NumberConst.IntDef.INT_ONE);
                soOrderDetailAdd.setCancelReason(soOrderDetail.getCancelReason());
                //第二版本取消退货标示
                //soOrderDetailAdd.setReturnFlg(soOrderDetail.getReturnFlg());
                soOrderDetailAdd.setCrtId(soOrderDetail.getCrtId());
                soOrderDetailAdd.setCrtTime(new Date());
                soOrderDetailAdd.setVer(NumberConst.IntDef.INT_ONE);
                soOrderDetailAdd.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
                // 获取卖家库存所需参数产品编码
                stockParam.setPdCode(soOrderDetail.getPdCode());
                stockParam.setStockNum(soOrderDetail.getOrderQty());
                // 获取卖家库存并判断库存数量
                com.msk.so.bean.StockBean stockBean = stockLogic.getSlStock(stockParam);

                  /* if (!CollectionUtils.isEmpty(stockBean.getSoSlStockList())) {
                        if (!stockLogic.checkStockQty(stockParam)) {
                            throw new BusinessException(soOrderDetail.getPdName() + "库存不足,请酌情减量！");
                        }
                    } else {
                        throw new BusinessException(soOrderDetail.getPdName() + "无库存，请联系管理员处理！");
                    }*/
                super.save(SqlId.SQL_ID_FIND_SAVE_SOORDER_DETAIL, soOrderDetailAdd);
            }
        }

        // 订单发票添加
            /*SoInvoice soInvoice = new SoInvoice();
            BaseParam parmsInvoice = new BaseParam();
            SoInvoice invoiceId=super.findOne(SqlId.SQ_ID_FIND_INVOICEID_MAX, parmsInvoice);
            if (null == invoiceId) {
                soInvoice.setInvoiceId(NumberConst.IntDef.INT_ONE);
            } else {
                Integer orderInvaiceId = invoiceId.getInvoiceId();
                soInvoice.setInvoiceId(orderInvaiceId + NumberConst.IntDef.INT_ONE);
            }
            soInvoice.setOrderId(Integer.parseInt(soId));
            soInvoice.setInvoiceType(param.getParam().getInvoiceReq().getInvoiceType());
            soInvoice.setInvoiceTitle(param.getParam().getInvoiceReq().getInvoiceTitle());
            soInvoice.setVatInvComp(param.getParam().getInvoiceReq().getVatInvComp());
            soInvoice.setVatTaxpayer(param.getParam().getInvoiceReq().getVatTaxpayer());
            soInvoice.setVatAddr(param.getParam().getInvoiceReq().getVatAddr());
            soInvoice.setVatTel(param.getParam().getInvoiceReq().getVatTel());
            soInvoice.setVatBank(param.getParam().getInvoiceReq().getVatBank());
            soInvoice.setVatAccount(param.getParam().getInvoiceReq().getVatAccount());
            soInvoice.setInvReceiverTel(param.getParam().getInvoiceReq().getInvReceiverTel());
            soInvoice.setInvTimeReq(param.getParam().getInvoiceReq().getInvTimeReq());
            soInvoice.setInvReceiverEmail(param.getParam().getInvoiceReq().getInvReceiverEmail());
            soInvoice.setInvoiceContent(param.getParam().getInvoiceReq().getInvoiceContent());
            soInvoice.setInvReceiverAddr(param.getParam().getInvoiceReq().getInvReceiverAddr());
            soInvoice.setInvoiceReq(param.getParam().getInvoiceReq().getInvoiceReq());
            soInvoice.setInvoiceCode(param.getParam().getInvoiceReq().getInvoiceCode());
            soInvoice.setRemark(param.getParam().getInvoiceReq().getRemark());
            soInvoice.setRemark2(param.getParam().getInvoiceReq().getRemark2());
            soInvoice.setRemark3(param.getParam().getInvoiceReq().getRemark3());
            //soInvoice.setInvTime(param.getParam().getInvoiceReq().getInvTime());
            soInvoice.setCrtId(param.getParam().getInvoiceReq().getCrtId());
            soInvoice.setCrtTime(new Date());
            soInvoice.setVer(NumberConst.IntDef.INT_ONE);
            soInvoice.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
            super.save(SqlId.SQL_ID_FIND_SAVE_SOINVOICE, soInvoice);
            iSO251402RsResult.setOrderId(soId);
            iSO251402RsResult.setOrderStatus(soOrder.getStatus());
            iSO251402RsResult.setOrderTime(soOrder.getCrtTime());
            iSO251402RsResult.setRequireOrderCode(soOrder.getOrderCode());
            iSO251402RsResult.setVer(soOrder.getVer());*/
        //  }
        iSO251402RsResult.setOrderId(orderId);
        iSO251402RsResult.setOrderStatus(soOrder.getOrderStatus());
        iSO251402RsResult.setOrderTime(soOrder.getCrtTime());
        iSO251402RsResult.setRequireOrderCode(soOrder.getOrderCode());
        iSO251402RsResult.setVer(soOrder.getVer());
        return iSO251402RsResult;
    }

    /**
     * SqlId.
     *
     * @author pxg
     */
    interface SqlId {
        /**
         * 订单明细
         */
        String SQL_ID_FIND_SAVE_SOORDER_DETAIL = "saveSoOrderDetail";
    }
}
