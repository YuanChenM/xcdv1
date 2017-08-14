package com.msk.so.logic;

import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrder;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO251412RsParam;
import com.msk.so.bean.ISO251412RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ISO251412Logic.
 *
 * @author pxg
 */
@Service
public class ISO251412Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * @param param 保存参数
     * @return 返回值
     * @author pxg
     */
    public ISO251412RsResult findAllList(RsRequest<ISO251412RsParam> param) {
        ISO251412RsResult iSO251412RsResult = new ISO251412RsResult();
        ISO251412RsParam iSO251412RsParam = new ISO251412RsParam();
        SoOrder soOrder = new SoOrder();
        iSO251412RsParam.setOrderId(param.getParam().getOrderId());
        iSO251412RsParam.setVer(param.getParam().getVer());
        iSO251412RsParam.setOperateType(param.getParam().getOperateType());
        BaseParam params = new BaseParam();
        params.getFilterMap().put("iSO251412RsParam", iSO251412RsParam);
        //查询记录是否存在
        soOrder = super.findOne(params);
        if (null != soOrder) {
            // 判断订单状态是不是完成
            if (StatusConst.OrderStatusDef.ALL_RECEIPT == soOrder.getOrderStatus() || StatusConst.OrderStatusDef.CANCEL == soOrder.getOrderStatus()) {
                // 更新条件对象
                SoOrder soOrder2 = new SoOrder();
                // 获取更新后的数据
                SoOrder soOrder3 = new SoOrder();
                // 恢复操作
                if (iSO251412RsParam.getOperateType() == NumberConst.IntDef.INT_ONE) {
                    this.result(iSO251412RsResult, params, param, soOrder3, iSO251412RsParam, soOrder2, NumberConst.IntDef.INT_ZERO);
                }
                // 删除操作
                if (iSO251412RsParam.getOperateType() == NumberConst.IntDef.INT_ZERO) {
                    this.result(iSO251412RsResult, params, param, soOrder3, iSO251412RsParam, soOrder2, NumberConst.IntDef.INT_ONE);
                }
                // 彻底删除操作
                if (iSO251412RsParam.getOperateType() == NumberConst.IntDef.INT_TWO) {
                    if(Integer.parseInt(soOrder.getDustbinFlg())==NumberConst.IntDef.INT_ONE){
                        this.result(iSO251412RsResult, params, param, soOrder3, iSO251412RsParam, soOrder2, NumberConst.IntDef.INT_TWO);
                    }else{
                        throw new BusinessException("订单ID为："+param.getParam().getOrderId()+",回收状态不为删除,不能彻底删除");
                    }
                }
            } else {
                throw new BusinessException("订单状态非全部收货，不能操作");
            }
        } else {
            throw new BusinessException("订单记录不存在，不能取消/恢复");
        }
        return iSO251412RsResult;
    }

    /**
     * 测试代码
     *
     * @return 返回值
     * @author pxg
     */
    public ISO251412RsResult findAllList2() {
        ISO251412RsResult iSO251412RsResult = new ISO251412RsResult();
        iSO251412RsResult.setOrderId((long) NumberConst.IntDef.INT_ONE);
        iSO251412RsResult.setOrderStatus(NumberConst.IntDef.INT_ONE);
        iSO251412RsResult.setRequireOrderCode("re43432");
        iSO251412RsResult.setUpdTime(new Date());
        iSO251412RsResult.setVer(NumberConst.IntDef.INT_ONE);
        return iSO251412RsResult;
    }

    /**
     * result赋值操作
     */
    public void result(ISO251412RsResult iSO251412RsResult, BaseParam params, RsRequest<ISO251412RsParam> param, SoOrder soOrder3, ISO251412RsParam iSO251412RsParam, SoOrder soOrder2, Integer delFlg) {
        soOrder2.setOrderId((long) iSO251412RsParam.getOrderId());
        soOrder2.setVer(iSO251412RsParam.getVer());
        if(delFlg==NumberConst.IntDef.INT_TWO){
            soOrder2.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ONE));
        }else{
            soOrder2.setDustbinFlg(StringUtil.toSafeString(delFlg));
        }
        soOrder2.setUpdTime(DateTimeUtil.getCustomerDate());
        soOrder2.setUpdId(param.getLoginId());
        int num = super.modify(soOrder2);
        if (num > 0) {
            soOrder3 = super.findOne(params);
            iSO251412RsResult.setOrderId(param.getParam().getOrderId());
            iSO251412RsResult.setOrderStatus(soOrder3.getOrderStatus());
            iSO251412RsResult.setRequireOrderCode(soOrder3.getRequireOrderCode());
            iSO251412RsResult.setUpdTime(soOrder3.getUpdTime());
            iSO251412RsResult.setVer(param.getParam().getVer());
        }
    }
}
