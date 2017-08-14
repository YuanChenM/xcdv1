package com.msk.so.logic.order.search;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.common.consts.OrderConst;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.order.*;
import com.msk.so.logic.rs.ISO151416Logic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * *BaseSearchOrder
 * *@author jiang_nan
 * *@version 1.0
 **/
public abstract class BaseSearchOrder{
    public interface SearchType{
        /**买家*/
        public String SEARCH_TYPE_BY = "by";
        /**卖家*/
        public String SEARCH_TYPE_SL = "sl";
        /**买手销售*/
        public String SEARCH_TYPE_BSS = "bss";
        /**买手囤货*/
        public String SEARCH_TYPE_BSSG = "bssg";
    }
    @Autowired
    private ISO151416Logic ISO151416Logic;

    public ViewOrderSearchResult search(BaseOrderSearchParam orderSearchParam){
        //买家APP需求增加
        if(orderSearchParam.getSearchType().equals(BaseSearchOrder.SearchType.SEARCH_TYPE_BY)
                && orderSearchParam.getSiteCode().equals(CommCodeMasterConst.SystemCode.SYSTEM_CODE_APP)){
            orderSearchParam.setOrderSource(String.valueOf(OrderConst.OrderSource.APP));
        }else {
            this.validateDetail(orderSearchParam);
        }

        List<BaseOrderSearchResult> orderInfo = this.ISO151416Logic.findList(orderSearchParam);
        for(BaseOrderSearchResult order : orderInfo){
            order.getDeliveryReq().setFilterMap(null);
            order.getReceiveInfo().setFilterMap(null);
            List<SoOrderDetail> childDetailList = new ArrayList<SoOrderDetail>();
            //讲子订单明细数据设置到返回结果中
            for(SoOrderDetail detail : order.getChildOrderDetaillist()){
                if(!StringUtil.isEmpty(detail.getPdCode())){
                    SoOrderDetail childDetail = new SoOrderDetail();
                    childDetail.setPdCode(detail.getPdCode());
                    childDetail.setPdName(detail.getPdName());
                    childDetail.setPdPrice(detail.getPdPrice());
                    childDetail.setNormsName(detail.getNormsName());
                    childDetail.setWeight(detail.getWeight());
                    childDetail.setPdGradeName(detail.getPdGradeName());
                    childDetail.setOrderQty(detail.getOrderQty());
                    childDetail.setSendQty(detail.getSendQty());
                    childDetail.setCancelQty(detail.getCancelQty());
                    childDetail.setReturnQty(detail.getReturnQty());
                    childDetail.setRejectionQty(detail.getRejectionQty());
                    childDetail.setReceiveQty(detail.getReceiveQty());
                    childDetailList.add(childDetail);
                }
           }
            //把主订单明细和子订单明细作为一个集合
            order.getOrderDetail().addAll(childDetailList);
            //把子订单明细集合设为空不返回
            order.setChildOrderDetaillist(null);
        }
        ViewOrderSearchResult result = new ViewOrderSearchResult();
        result.setOrders(orderInfo);
        return result;
    }

    public ListOrderSearchResult search(OrderListSearchParam searchParam){
        this.validateList(searchParam);
        ListOrderSearchResult result = new ListOrderSearchResult();
        List<BaseOrderSearchResult> orderInfo = ISO151416Logic.findPageList(searchParam,result);
        for(BaseOrderSearchResult order : orderInfo){
            order.setOrderDetail(null);
            order.getDeliveryReq().setFilterMap(null);
            order.getReceiveInfo().setFilterMap(null);
        }
        result.setOrders(orderInfo);
        return result;
    }

    /**
     * 验证数据有效性
     * @param param 参数
     */
    public abstract void validateDetail(BaseOrderSearchParam param);
    /**
     * 验证数据有效性
     * @param searchParam 参数
     */
    public abstract void validateList(OrderListSearchParam searchParam);

}
