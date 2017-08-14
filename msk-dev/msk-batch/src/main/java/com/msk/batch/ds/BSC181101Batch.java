package com.msk.batch.ds;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.ds.bean.BSC181101Param;
import com.msk.batch.ds.logic.BSC181101Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.exception.BusinessException;
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
 * SCMGetDataBatch 获得供应商分销数量Batch
 *
 * @author zhou_yajun
 */
@Component("BSC181101")
public class BSC181101Batch extends BaseBatch{

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BSC181101Batch.class);
    private static String JSON_STATUS_KEY = "status";
    private static String RESULT_SUCCESS = "S";
//    private static String SUP_DISTRIBUTE_DEMAND_URL = "http://121.196.237.83:8070/service/service/getSupDistributeDemand";
    @Autowired
    private BSC181101Logic bSC181101Logic;

    @Override
    public BaseParam createParam(String[] args){
        logger.info("Bath开始取得数据");

        BSC181101Param param = new BSC181101Param();
        JSONObject resultJson = null;
        if(args!=null && (args.length>0)){
            resultJson = new JSONObject(args[0]);
        }else{
            String apiUrl = ConfigManager.getDistributeUrl();
            resultJson = HttpUtils.post(apiUrl,new HashMap<String, String>());
            String status = resultJson.getString(JSON_STATUS_KEY);
            if(!RESULT_SUCCESS.equals(status)){
                throw new BusinessException("请求返回结果集失败");
            }
        }

        param.setJsonData(resultJson);
        return param;
    }
    @Override
    public void doOperate(BaseParam param){
        BSC181101Param BSC181101Param = (BSC181101Param)param;
        //JSONObject resultJson = BSC181101Param.getJsonData();
        //JsonUtils.getCollection(SC1811B1ResultParam.class,resultJson.getJSONArray("result"));
        bSC181101Logic.setSuppDistNum(param);
    }
}
