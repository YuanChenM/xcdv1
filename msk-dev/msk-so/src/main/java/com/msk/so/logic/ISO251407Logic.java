package com.msk.so.logic;

import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SoOrder;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO251407RsParam;
import com.msk.so.bean.ISO251407RsResult;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.orderstatus.OrderStatusContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * 
 * ISO251407Logic.
 *
 * @author pxg
 */
@Service
public class ISO251407Logic extends BaseLogic {
    //引用共同文件，更新订单状态
    @Autowired
    private OrderStatusContext orderStatusContext;
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
    public ISO251407RsResult findAllList(RsRequest<ISO251407RsParam> param) {
        ISO251407RsResult iSO251407RsResult = new ISO251407RsResult();
        ISO251407RsParam iSO251407RsParam = new ISO251407RsParam();
        //判断参数状态是不是全部收货，然后进行下一步操作
        if(param.getParam().getOrderStatus()== StatusConst.OrderStatusDef.ALL_RECEIPT){
            //创建共通需要传递的对象
            OrderStatusParam statusParam=new OrderStatusParam();
            SoOrder soOrder=new SoOrder();
            BaseParam params=new BaseParam();
            params.setFilter("orderId", StringUtil.toSafeString(param.getParam().getOrderId()));
            params.setFilter("orderCode", param.getParam().getOrderCode());
            //根据传递的订单ID和订单Code查询对象的记录，取到当前订单的状态
            soOrder=super.findOne(params);
            if(null!=soOrder){
                statusParam.setOldStatus(soOrder.getOrderStatus());
                statusParam.setNewStatus(param.getParam().getOrderStatus());
                statusParam.setOrderId(param.getParam().getOrderId());
                statusParam.setOrderCode(StringUtil.toSafeString(param.getParam().getOrderCode()));
                statusParam.setVer(param.getParam().getVer());
                SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
                String date=sim.format(param.getParam().getReceiveTime());
                statusParam.setFilter("receiveTime",date);
                statusParam.setUpdId(param.getLoginId());
                //调用共通方法更新状态
                orderStatusContext.handle(statusParam);
                //更新完再次查询对象订单数据
                soOrder=super.findOne(params);
                //判断数据不为空，返回
                if(null!=soOrder){
                    iSO251407RsResult.setVer(param.getParam().getVer());
                    iSO251407RsResult.setUpdTime(soOrder.getUpdTime());
                    iSO251407RsResult.setOrderCode(soOrder.getOrderCode());
                    iSO251407RsResult.setOrderId(soOrder.getOrderId());
                    iSO251407RsResult.setOrderStatus(soOrder.getOrderStatus());
                }
            }else{
                throw new BusinessException("订单记录不存在，不能操作");
            }
        }else{
            throw new BusinessException("订单状态非全部收货，不能操作");
        }
        return iSO251407RsResult;
    }
}
