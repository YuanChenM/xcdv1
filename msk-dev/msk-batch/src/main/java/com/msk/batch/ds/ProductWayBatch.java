package com.msk.batch.ds;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.ds.bean.ProductWayParam;
import com.msk.batch.ds.logic.ProductWayLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.HttpUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 *
 * ProductPricePlateBatch 获得产品通道配置和价盘Batch
 *
 * @author zhou_yajun
 */
@Component("BPD141102")
public class ProductWayBatch extends BaseBatch{

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ProductWayBatch.class);

    @Autowired
    private ProductWayLogic productWayLogic;

    @Override
    public BaseParam createParam(String[] args){
        logger.info("Bath开始取得数据");
        ProductWayParam param = new ProductWayParam();
        try {
            //获取通道配置json数据
           // String wayUrl = "http://121.196.237.83:8070/service/service/getWayGradeSpec";
            String wayUrl = ConfigManager.getBatchWayUrl();
            String jsonWayStr = HttpUtils.post(wayUrl,new HashMap<String, String>()).toString();//this.getJsonStr(wayUrl);

            JSONObject jsonWayObject = new JSONObject(jsonWayStr);

            param.setJsonWayData(jsonWayObject.toString());
        }catch (Exception e){
           e.printStackTrace();
        }
        return param;
    }
    @Override
    public void doOperate(BaseParam param){
        productWayLogic.JsonDataResolve(param);
    }
}
