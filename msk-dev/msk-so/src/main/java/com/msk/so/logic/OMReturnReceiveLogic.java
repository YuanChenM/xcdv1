
package com.msk.so.logic;

import org.springframework.stereotype.Service;

import com.msk.core.base.BaseLogic;
import com.msk.so.bean.ReturnReceiveBean;

/**
 * OMReturnReceive.java
 * 
 * @screen
 * @author rwf
 */
@Service
public class OMReturnReceiveLogic extends BaseLogic {

    /**
     *
     * 根据退货单ID获取退货单物流收货信息
     * 
     * @return ReturnReceiveBean
     * @author rwf
     */
    public ReturnReceiveBean getReturnReceive() {

        ReturnReceiveBean returnReceiveBean = new ReturnReceiveBean();

        returnReceiveBean.setVerification("是"); // 是否开动检证
        returnReceiveBean.setReturnWaitTime("5天"); // 退货等待时间
        returnReceiveBean.setNoticeTime("2天");// 提前通知时间
        returnReceiveBean.setDistance("1111米"); // 距离门店最近停车距离(米)
        returnReceiveBean.setNormalTime("8:00~18:00"); // 正常退货时间段
        returnReceiveBean.setReturnEarliestTime("2015-12-11");// 退货最早时间要求
        returnReceiveBean.setReturnLatestTime("2015-12-15"); // 退货最晚时间要求
        returnReceiveBean.setOtherReturnRequest("暂无"); // 其它退货服务要求
        returnReceiveBean.setThisTimeReturnRequest("请开出退货的证明,附带单位印章,谢谢"); // 本次退货服务要求

        return returnReceiveBean;

    }

}
