package com.msk.common.consts;

/**
 * 资金池常量定义
 * *@author jiang_nan
 * *@version 1.0
 **/
public interface CapitalPoolConst {

    /**
     * 查询类型： 0：订单 1：管理费
     */
    public interface SearchType{
        String TYPE = "SearchType";
        // 订单
        String ORDER = "0";
        // 管理费
        String MANAGEMENT_COSTS = "1";
    }

    /**
     * 金额类型： 0：订单确认金额 1：卖家收款金额 2：平台仓储金额 3：用户退款金额
     */
    public interface AmountType{
        String TYPE = "AmountType";
        // 订单确认金额
        int ORDER_CONFIRM = 0;
        // 卖家收款金额
        int SELLER_RECEIVABLES = 1;
        // 平台仓储金额
        int PLATFORM_STORAGE = 2;
        // 用户退款金额
        int USER_REIMBURSE = 3;
    }

    /**
     * 收款方，付款方角色信息
     */
    public interface RoleType{
        String TYPE = "RoleType";
        //平台
        String ROLE_PLATFORM = "1";
        //买家
        String ROLE_BIDDER = "2";
        //卖家
        String ROLE_SELLER = "3";
        //买手
        String ROLE_BUYERE = "4";
    }

    /**
     * 平台类型： 0：神农客 1：美侍客
     */
    public interface PlateFormType{
        String TYPE = "PlateFormType";
        // 神农客
        String SNK = "0";
        // 美侍客
        String MSK = "1";
    }
}
