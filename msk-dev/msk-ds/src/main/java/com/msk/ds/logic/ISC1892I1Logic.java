package com.msk.ds.logic;

import com.msk.common.consts.StockConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.DsDeliveryStock;
import com.msk.core.entity.DsDeliveryStockDetail;
import com.msk.core.entity.DsPdVirtualStockActual;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.consts.BusinessConst;
import com.msk.ds.bean.ISC1892I1Param;
import com.msk.ds.bean.ISC1892I1RsParam;
import com.msk.ds.bean.ISC1892I1RsResult;
import com.msk.so.bean.StockParam;
import com.msk.so.logic.OrderLogic;
import com.msk.so.logic.StockLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * ISC1892I1I1Logic.
 *
 * @author xu_wei
 */
@Service
public class ISC1892I1Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISC1892I1Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private StockLogic stockLogic;

    @Autowired
    private OrderLogic orderLogic;

    /**
     * (non-Javadoc)
     *
     * @see com.msk.core.base.BaseLogic#setBaseDao(com.msk.core.base.BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 修改实际发货数量
     *
     * @param param param
     * @return
     */
    @Transactional
    public ISC1892I1RsResult modifyStock(RsRequest<ISC1892I1Param> param) {
        Date currentDate = DateTimeUtil.getCustomerDate();
        ISC1892I1RsResult isc1892I1RsResult = new ISC1892I1RsResult();
        //收货判断条件
        boolean flagLivery = true;

        BaseParam stockBaseParam = new BaseParam();
        stockBaseParam.getFilterMap().put("deliveryStockId", param.getParam().getDeliveryStockId());
        DsDeliveryStock deliveryStockBean = super.findOne(stockBaseParam);
        if (deliveryStockBean == null) {
            throw new BusinessException("发货入库管理信息:" + param.getParam().getDeliveryStockId() + "没有相关入库信息");
        }
        //查询条件
        ISC1892I1RsParam sc1892I1Param = new ISC1892I1RsParam();
        sc1892I1Param.setDistMonth(deliveryStockBean.getDistMonth());
        sc1892I1Param.setLgcsCode(deliveryStockBean.getLgcsCode());
        sc1892I1Param.setAreaCode(deliveryStockBean.getLgcsCode());
        sc1892I1Param.setSuppCode(deliveryStockBean.getSuppCode());
        sc1892I1Param.setHalfCode(deliveryStockBean.getHalfCode());
        sc1892I1Param.setStockMemo(param.getParam().getStockMemo());

//        sc1892I1Param.setInputDate(param.getParam().getInputDate().substring(0, 10));
        // create by likai on 2016/8/15 判断是否大于10位
        Date formatInputDate = DateTimeUtil.parseDate(param.getParam().getInputDate(),"yyyy/MM/dd HH:mm:ss");
        String parseInputDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(formatInputDate);
        sc1892I1Param.setInputDate(parseInputDate.substring(0, 10));

        sc1892I1Param.setPdStockType(NumberConst.IntDef.INT_THREE);
        sc1892I1Param.setDeliveryStockId(param.getParam().getDeliveryStockId());
        //产品相关的信息
        List<ISC1892I1RsParam> isc1892I1Product = param.getParam().getProductList();
        for (ISC1892I1RsParam isc1892I1Param : isc1892I1Product) {
            //库号
//            String sku = isc1892I1Param.getPdCode();
            /** #1919,create by likai on 2016/8/16 start */
            String sku = isc1892I1Param.getSkuCode();
            /** #1919,create by likai on 2016/8/16 end */
            /** slCodeDis(1-7) */
            String slCodeDis = sku.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_SEVEN);
            /** slPdArtno(8-12) */
            String slPdArtno = sku.substring(NumberConst.IntDef.INT_SEVEN, NumberConst.IntDef.INT_TWELVE);

            //产品编码
            String pdCode = orderLogic.getPdCode(slPdArtno, slCodeDis);

            //实际收货箱数
            int receiveActualNum = isc1892I1Param.getReceiveActualNum().intValue();

            //供应商编号
            sc1892I1Param.setPdCode(pdCode);

            //实际表ds_pd_virtual_stock_actual
            List<DsPdVirtualStockActual> productList = this.findList(SqlId.FIND_PRODUCT_LIST, sc1892I1Param);

            //细节表ds_delivery_stock_detail
            List<DsDeliveryStockDetail> detailtList = this.findList(SqlId.FIND_DETAIL_LIST, sc1892I1Param);

            for (DsDeliveryStockDetail detailtInfo : detailtList) {
                //实际发货箱数
                int sendActualNum = detailtInfo.getActualDeliveryNum().intValue();
                //实际收货箱数
                long receiveActualTail = receiveActualNum;
                //实际发货箱数=0的场合，跳出本次循环
                if (sendActualNum == 0) {
                    continue;
                }
                //实际发货箱数不能够小于实际收货箱数
                if (sendActualNum < receiveActualNum) {
                    throw new BusinessException(detailtInfo.getPdCode() + "实际发货箱数不能够小于实际收货箱数");
                } else if (sendActualNum == receiveActualNum) {
                    sendActualNum = 0;
                } else {
                    sendActualNum = sendActualNum - receiveActualNum;
                    flagLivery = false;
                }

                for (DsPdVirtualStockActual stockActualParam : productList) {
                    if (stockActualParam != null) {
                        if (stockActualParam.getPdCode().equals(detailtInfo.getPdCode())) {
                            //实际发货箱数等于实际收货箱数
                            if (receiveActualNum == 0) {
                                break;
                            }
                            //变化值
                            int changeNum = 0;
                            if (stockActualParam.getNewActualNum().intValue() <= receiveActualNum) {
                                receiveActualNum -= stockActualParam.getNewActualNum().intValue();
                                changeNum = -stockActualParam.getNewActualNum().intValue();
                            } else {
                                changeNum = changeNum - receiveActualNum;
                                receiveActualNum = 0;
                            }

                            //修改实际表中库存类型为3的数据到4类型的实际数量
                            //3
                            BaseParam baseParam = new BaseParam();
                            baseParam.getFilterMap().put("newActualNum", changeNum*stockActualParam.getOutNw().doubleValue());
                            baseParam.getFilterMap().put("distMonth", sc1892I1Param.getDistMonth());
                            baseParam.getFilterMap().put("areaCode", sc1892I1Param.getLgcsCode());
                            baseParam.getFilterMap().put("supplierCode", sc1892I1Param.getSuppCode());
                            baseParam.getFilterMap().put("pdStockType", NumberConst.IntDef.INT_THREE);
                            baseParam.getFilterMap().put("halfCode", sc1892I1Param.getHalfCode());
                            baseParam.getFilterMap().put("pdCode", stockActualParam.getPdCode());
                            baseParam.getFilterMap().put("inputDate", stockActualParam.getInputDate());
                            baseParam.setUpdId(param.getLoginId());
                            baseParam.setUpdTime(currentDate);
                            super.modify(SqlId.MODIFY_ACTUAL, baseParam);

                            //4
                            baseParam.getFilterMap().put("newActualNum", -changeNum*stockActualParam.getOutNw().doubleValue());
                            baseParam.getFilterMap().put("pdStockType", NumberConst.IntDef.INT_FOUR);
                            //ds_pd_virtual_stock_actual
                            int updateNums = super.modify(SqlId.MODIFY_ACTUAL, baseParam);
                            if (updateNums <= 0) {
                                long virtualStockActualId = this.commonLogic.maxId("DS_PD_VIRTUAL_STOCK_ACTUAL", "VIRTUAL_STOCK_ACTUAL_ID");
                                baseParam.getFilterMap().put("virtualStockActualId", String.valueOf(virtualStockActualId));
                                baseParam.getFilterMap().put("pdStockTypeFm", NumberConst.IntDef.INT_THREE);
                                baseParam.getFilterMap().put("pdStockTypeTo", NumberConst.IntDef.INT_FOUR);
                                baseParam.setCrtId(sc1892I1Param.getCrtId());
                                baseParam.setCrtTime(currentDate);
                                //ds_pd_virtual_stock_actual
                                save(SqlId.SAVE_ACTUAL_STOCK, baseParam);
                            }
                        }
                    }
                }
                //发货入库通知单ID
                BaseParam baseParam = new BaseParam();
                baseParam.getFilterMap().put("deliveryStockId", detailtInfo.getDeliveryStockId());
                baseParam.getFilterMap().put("pdCode", detailtInfo.getPdCode());
                baseParam.getFilterMap().put("normsCode", detailtInfo.getNormsCode());
                baseParam.getFilterMap().put("actualReceiveNum", receiveActualTail);
                baseParam.getFilterMap().put("memo", sc1892I1Param.getStockMemo());
                baseParam.setCrtId(param.getParam().getCrtId());
                baseParam.setCrtTime(currentDate);
                baseParam.setUpdId(param.getParam().getCrtId());
                baseParam.setUpdTime(currentDate);
                super.modify(SqlId.EDIT_RECEIVE_NUM, baseParam);
                //TODO
                //ds_pd_virtual_stock_actual
                //save(SqlId.SAVE_ACTUAL_STOCK, baseParam);
            }

            //修改销售库存
            List<StockParam> stockParamList = new ArrayList<StockParam>();
            for (DsDeliveryStockDetail detail : detailtList) {
                StockParam stockParam = new StockParam();
                stockParam.setLgcsCode(deliveryStockBean.getLgcsCode());
                stockParam.setWarehouseCode(StockConst.WarehouseCode.SH_CODE);
                stockParam.setWarehouseName(StockConst.WarehouseName.SH_NAME);
                //TODO
                stockParam.setSupplyPlatform(NumberConst.IntDef.INT_ONE);
                stockParam.setSlCode(StockConst.SL_Name.SL_CODE);
                stockParam.setSlName(StockConst.SL_Name.SL_NAME);
                stockParam.setStockType(StockConst.StockType.NORMAL_STOCK);
                stockParam.setSupplierCode(deliveryStockBean.getSuppCode());
                stockParam.setPdCode(detail.getPdCode());
                //stockParam.setStockNum(detail.getActualDeliveryNum());
                //实际收货数量
                stockParam.setStockNum(isc1892I1Param.getReceiveActualNum());
                stockParam.setFlowId(String.valueOf(deliveryStockBean.getDeliveryStockId()));
                stockParamList.add(stockParam);
            }
            //供应商库存SO_STOCK_SP
            //TODO
            stockLogic.saveStockOfSupplierList(stockParamList);
        }

        //已收货
        if (flagLivery == true) {
            deliveryStockBean.setDeliveryStockStatus(BusinessConst.DeliveryStockStatus.Delivery);
            deliveryStockBean.setStockMemo(sc1892I1Param.getStockMemo());
            deliveryStockBean.setUpdId(sc1892I1Param.getCrtId());
            deliveryStockBean.setUpdTime(currentDate);
            /** #1779 modify by likai on 2016/8/11 start */
            Date receiveTime = DateTimeUtil.parseDate(param.getParam().getInputDate(),"yyyy/MM/dd HH:mm:ss");
            if (DateTimeUtil.isValidDate(receiveTime)) {

                deliveryStockBean.setDeliveryReceiveStockTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(receiveTime));
            }
            /** #1779 modify by likai on 2016/8/11 end */
            super.modify(deliveryStockBean);
        } else {
            //部分收货
            deliveryStockBean.setDeliveryStockStatus(BusinessConst.DeliveryStockStatus.PartialDelivery);
            deliveryStockBean.setStockMemo(sc1892I1Param.getStockMemo());
            deliveryStockBean.setUpdId(sc1892I1Param.getCrtId());
            deliveryStockBean.setUpdTime(currentDate);
            /** #1779 modify by likai on 2016/8/11 start */
            Date receiveTime = DateTimeUtil.parseDate(param.getParam().getInputDate(),"yyyy/MM/dd HH:mm:ss");
            if (DateTimeUtil.isValidDate(receiveTime)) {

                deliveryStockBean.setDeliveryReceiveStockTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(receiveTime));
            }
            /** #1779 modify by likai on 2016/8/11 end */
            super.modify(deliveryStockBean);
        }

        isc1892I1RsResult.setDeliveryStockStatus(deliveryStockBean.getDeliveryStockStatus());
        return isc1892I1RsResult;
    }

    /**
     * SqlId.
     *
     * @author pxg
     */
    interface SqlId {
        String FIND_PRODUCT_LIST = "findProductList";

        String MODIFY_ACTUAL = "modifyActual";

        String FIND_DETAIL_LIST = "findDetailList";

        String SAVE_ACTUAL_STOCK = "saveActualStock";

        String EDIT_RECEIVE_NUM = "editReceiveNum";
    }
}
