package com.msk.common.consts;

/**
 * Created by zhang_lingbo on 2016/3/9.
 */
public interface StockConst {
    interface StockType{
        String TYPE = "StockType";
        int NORMAL_STOCK = 1;
    }
    interface WarehouseCode{
        String TYPE = "WarehouseCode";
        String SH_CODE = "021";
    }
    interface WarehouseName{
        String TYPE = "WarehouseName";
        String SH_NAME = "上海仓库";
    }
    interface SL_Name{
        String TYPE = "slName";
        String SL_CODE = "0000000";
        String SL_NAME = "神农客实业有限公司";
    }

    /**
     * 使用范围：在库存调整接口
     * 出仓，进仓的商品状态 AVAILABLE：良品
     */
    interface Inventory_Status{
        String TYPE = "inventoryStatus";
        String INVENTORY_STATUS = "AVAILABLE";
        String INVENTORY_STATUS_NAME = "仓库的库存类型";
    }
}
