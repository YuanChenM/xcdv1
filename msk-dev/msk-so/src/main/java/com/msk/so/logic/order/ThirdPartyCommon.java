package com.msk.so.logic.order;

import com.msk.common.logic.CommonLogic;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.so.bean.order.BaseOrderDetailParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * *ThirdPartyBuyersOrder
 * *@author jiang_nan
 * *@version 1.0
 **/
public class ThirdPartyCommon {
    private CommonLogic commonLogic;
    public ThirdPartyCommon(CommonLogic commonLogic){
        this.commonLogic = commonLogic;
    }
    /**
     * 创建订单明细供货信息表
     * @param orderDetailParamList 订单信息
     * @return 订单明细供货信息表
     */
    public List<SoOrderDetailAvailability> createOrderDetailAvailability(List<BaseOrderDetailParam> orderDetailParamList){
        List<SoOrderDetailAvailability> orderDetailAvailabilityList = new ArrayList<SoOrderDetailAvailability>();

        for(BaseOrderDetailParam orderDetail : orderDetailParamList){
            SoOrderDetailAvailability SoOrderDetailAvailability = new SoOrderDetailAvailability();
            //供应商编码
            SoOrderDetailAvailability.setSupplierCode(orderDetail.getSupplierCode());
            //订单明细编号
            SoOrderDetailAvailability.setOrderDetailId(orderDetail.getOrderDetailId());
            //供货数量
            SoOrderDetailAvailability.setSuppQty(orderDetail.getOrderQty());
            //产品编码
            SoOrderDetailAvailability.setPdCode(orderDetail.getPdCode());
            //订单明细供货编号
            SoOrderDetailAvailability.setOrderDetailAvailabilityId(createSoOrderDetailAvailabilityId());
            //订单编号
            long orderId = orderDetail.getOrderId()==null?0:orderDetail.getOrderId();
            SoOrderDetailAvailability.setOrderId(orderId);

            //订单Code
            String orderCode = orderDetail.getOrderCode();
            SoOrderDetailAvailability.setOrderCode(orderCode);

            //create time
            Date customerDate = orderDetail.getCrtTime();
            SoOrderDetailAvailability.setCrtTime(customerDate);

            //供应商名称
            String supplierName = orderDetail.getSupplierName();
            SoOrderDetailAvailability.setSupplierName(supplierName);

            //产品类型
            String classesCode = orderDetail.getClassesCode();
            SoOrderDetailAvailability.setClassesCode(classesCode);

            //产品类型名称
            String classesName = orderDetail.getClassesName();
            SoOrderDetailAvailability.setClassesName(classesName);

            //产品品种
            String breedCode = orderDetail.getBreedCode();
            SoOrderDetailAvailability.setBreedCode(breedCode);

            //产品品种名称
            String breedName = orderDetail.getBreedName();
            SoOrderDetailAvailability.setBreedName(breedName);

            //特征编码
            String featureCode = orderDetail.getFeatureCode();
            SoOrderDetailAvailability.setFeatureCode(featureCode);

            //特征名称
            String featureName = orderDetail.getFeatureName();
            SoOrderDetailAvailability.setFeatureName(featureName);

            //产品包装编码
            String normsCode = orderDetail.getNormsCode();
            SoOrderDetailAvailability.setNormsCode(normsCode);

            //产品包装名称
            String normsName = orderDetail.getNormsName();
            SoOrderDetailAvailability.setNormsName(normsName);

            //产品名称
            String pdName = orderDetail.getPdName();
            SoOrderDetailAvailability.setPdName(pdName);

            //产品等级
            String pdLevel = orderDetail.getPdLevel();
            SoOrderDetailAvailability.setPdLevel(pdLevel);

            //产品等级编码
            String pdGradeCode = orderDetail.getPdGradeCode();
            SoOrderDetailAvailability.setPdGradeCode(pdGradeCode);

            //产品等级名称
            String pdGradeName = orderDetail.getPdGradeName();
            SoOrderDetailAvailability.setPdGradeName(pdGradeName);

            //产品单位
            String unit = orderDetail.getUnit();
            SoOrderDetailAvailability.setUnit(unit);

            //单箱体积
            BigDecimal packingVolume = orderDetail.getPackingVolume();
            SoOrderDetailAvailability.setPackingVolume(packingVolume);

            //重量
            BigDecimal weight = orderDetail.getWeight();
            SoOrderDetailAvailability.setWeight(weight);

            //体积
            BigDecimal volume = orderDetail.getVolume();
            SoOrderDetailAvailability.setVolume(volume);

            SoOrderDetailAvailability.setCrtId(orderDetail.getCrtId());
            SoOrderDetailAvailability.setCrtTime(orderDetail.getCrtTime());

            //设置订单状态
            //TODO
            SoOrderDetailAvailability.setStatus(orderDetail.getDetailStatus());
            orderDetailAvailabilityList.add(SoOrderDetailAvailability);
        }
        return orderDetailAvailabilityList;
    }

    /**
     * 创建订单要求表主键ID
     * @return 订单要求表主键ID
     */
    private Long createSoOrderDetailAvailabilityId(){
        return this.commonLogic.maxId("SO_ORDER_DETAIL_AVAILABILITY","ORDER_DETAIL_AVAILABILITY_ID");
    }
}
