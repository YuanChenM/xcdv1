package com.msk.common.consts;

/**
 * 订单模块常量定义
 *
 * @author jiang_nan
 * @version 1.0
 **/
public interface OrderConst {
    /**
     * 付款方式
     */
    interface PaymentType {
        String TYPE = "PaymentType";
        /** 线上支付 */
        int PAYING_ONLINE = 1;
        /** 货到付款 */
        int CASH_ON_DELIVERY = 2;
    }
    interface OrderType{
        String TYPE = "OrderType";
        /**分销订单*/
        int DISTRIBUTION_ORDER = 1;
        /**第三方订单*/
        int THIRD_PARTY_ORDER = 2;
        /**大促会订单*/
        int BIG_PROMOTION_ORDER = 3;
        /**买手囤货订单*/
        int BUYER_STOCKPILING_ORDER=4;
        /**买手销售订单*/
        int BUYER_SALE_ORDER=5;
        /**第三方买手销售订单*/
        int THIRD_BUYER_SALE_ORDER = 6;
        /**第三方买手囤货订单*/
        int THIRD_BUYER_ORDER = 7;
    }
    interface OrderSource{
        int SNK = 1;
        int MSK = 2;
        int WSC = 3;
        int APP = 4;
        int NEW_WSC = 5;
        /**买家APP*/
        int BUYER_APP = 6;
        int DQS = 7;
    }

    interface ReturnSource{
        int SNK = 1;
        int MSK = 2;
        int WSC = 3;
        int APP = 4;
        int PDA = 99;
    }
    /**
     * 退货单类型
     */
    interface ReturnType{
        // 迟收
        String LATER = "1";
        // 现场退货
        String REJECT = "2";
        // 退货
        String RETURNED = "3";
    }

    /**
     * 退货方式
     */
    interface ReturnMode{
        // 1：全部
        int ALL = 1;
        // 2：部分
        int APART = 2;
    }
}
