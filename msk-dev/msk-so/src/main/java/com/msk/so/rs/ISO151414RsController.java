package com.msk.so.rs;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.common.consts.OrderConst;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.order.BaseOrderDetailParam;
import com.msk.so.bean.order.BaseOrderParam;
import com.msk.so.bean.order.BaseOrderResult;
import com.msk.so.logic.order.BaseOrder;
import com.msk.so.logic.order.OrderFactory;
import com.msk.so.logic.rs.ISO151414Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * ISO151414RsController
 *
 * @author jiang_nan
 * @version 1.0
 */
@RestController
public class
        ISO151414RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151414RsController.class);
    private static Map<String, Integer> ORDER_TYPE_MAP = new HashMap<String, Integer>();
    @Autowired
    private OrderFactory orderFactory;

    @Autowired
    private ISO151414Logic iso151414Logic;

    static {
        //买手囤货订单
        ORDER_TYPE_MAP.put("buyer", OrderConst.OrderType.BUYER_STOCKPILING_ORDER);
        //第三方订单
        ORDER_TYPE_MAP.put("thirdparty", OrderConst.OrderType.THIRD_PARTY_ORDER);
        //第三方买手囤货订单
        ORDER_TYPE_MAP.put("thirdbuyer", OrderConst.OrderType.THIRD_BUYER_ORDER);
        //分销订单订单
        ORDER_TYPE_MAP.put("distribution", OrderConst.OrderType.DISTRIBUTION_ORDER);
    }

    /**
     * 创建订单。包含买手囤货订单，第三方订单，第三方囤货订单，和分销订单
     *
     * @param type    订单类型
     * @param request 请求参数
     * @return 创建订单结果
     */
    @RequestMapping(value = "/api/v1/so/sdo/{type}/create", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public synchronized RsResponse<BaseOrderResult> createOrder(@RequestBody RsRequest<BaseOrderParam> request, @PathVariable("type") String type) {
        logger.debug("创建订单,订单类型:" + type);
        String siteCode = request.getSiteCode();
        BaseOrderParam param = request.getParam();
        //根据Site Code设置订单来源
        if (CommCodeMasterConst.SystemCode.SYSTEM_CODE_SNK.equals(siteCode)) {
            param.setOrderSource(OrderConst.OrderSource.SNK);
        } else if (CommCodeMasterConst.SystemCode.SYSTEM_CODE_MSK.equals(siteCode)) {
            param.setOrderSource(OrderConst.OrderSource.MSK);
        } else if (CommCodeMasterConst.SystemCode.SYSTEM_CODE_WSC.equals(siteCode)) {
            param.setOrderSource(OrderConst.OrderSource.WSC);
            iso151414Logic.dealOrderInfo(param);
        } else if (CommCodeMasterConst.SystemCode.SYSTEM_CODE_NEW_WSC.equals(siteCode)) {
            param.setOrderSource(OrderConst.OrderSource.NEW_WSC);
        } else if (CommCodeMasterConst.SystemCode.SYSTEM_CODE_APP.equals(siteCode)) {
            param.setOrderSource(OrderConst.OrderSource.APP);
        }
        //买家APP
        else if(CommCodeMasterConst.SystemCode.SYSTEM_CODE_BUYER_APP.equals(siteCode)){
            param.setOrderSource(OrderConst.OrderSource.BUYER_APP);
        }else if (CommCodeMasterConst.SystemCode.SYSTEM_CODE_DQS.equals(siteCode)){
            param.setOrderSource(OrderConst.OrderSource.DQS);
            iso151414Logic.checkBuyersInfo(param);
        }
        param.setCrtId(request.getLoginId());
        Integer orderType = ORDER_TYPE_MAP.get(type);
        // 0:不分批,1:发生分批,2:买家同意分批,3:买家确认取消
        String splitDeliveryFlg = param.getSplitDeliveryFlg();
        if (!"2".equals(splitDeliveryFlg) || !"3".equals(splitDeliveryFlg)) {
            Set<Date> proDateSet = this.checkSplitDelivery(param.getProducts());
            if (proDateSet.size() > 1) {// 多个配送日
                param.setSplitDeliveryFlg("1");
            } else {// 单个
                param.setSplitDeliveryFlg("0");
            }
        }
        BaseOrder<BaseOrderParam> order = this.orderFactory.createOrder(orderType);
        param.setOrderType(orderType);
        BaseOrderResult result = order.doOperate(param);
        RsResponse<BaseOrderResult> response = new RsResponse<BaseOrderResult>();
        response.setMessage("订单创建成功");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setResult(result);
        return response;
    }


    /**
     * check 是否分批 发货时间
     *
     * @param products
     * @return
     */
    private Set<Date> checkSplitDelivery(List<BaseOrderDetailParam> products) {
        Set<Date> proDateSet = new HashSet<>();
        if (products != null) {
            for (BaseOrderDetailParam product : products) {
                Date proDate=product.getProDate();// 配送日
                if(proDate !=null){
                    proDateSet.add(proDate);
                }
            }
        }
        return proDateSet;
    }


}
