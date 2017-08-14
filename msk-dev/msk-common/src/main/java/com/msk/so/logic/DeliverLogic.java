package com.msk.so.logic;

import java.util.List;

import com.msk.common.logic.CommonLogic;
import com.msk.core.utils.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.SoDeliver;
import com.msk.core.entity.SoDeliverDetail;

/**
 * 配送单处理共通
 * @author jiang_nan
 */
@Service
public class DeliverLogic extends BaseLogic{

    @Autowired
    private CommonLogic commonLogic;

    /**
     * sqlMap
     */
    interface SqlId{
        String SQL_ID_SAVE_DELIVER = "saveDeliver";
        String SQL_ID_SAVE_DELIVER_DETAIL = "saveDeliverDetail";
        String SQL_ID_UPDATE_DELIVER = "updateDeliver";
        String SQL_ID_UPDATE_DELIVER_DETAIL = "updateDeliverDetail";
    }




    /**
     *保存配送单数据
     * @param deliver 配送单
     * @param deliverDetailList 配送单明细
     */
    @Transactional
    public void saveDeliver(SoDeliver deliver, List<SoDeliverDetail> deliverDetailList){
        if (deliver != null){
            deliver.setCrtTime(DateTimeUtil.getCustomerDate());
            this.save(SqlId.SQL_ID_SAVE_DELIVER,deliver);
            for (SoDeliverDetail soDeliverDetail:deliverDetailList){
                soDeliverDetail.setDeliverDetailId(commonLogic.maxId("so_deliver_detail","DELIVER_DETAIL_ID"));
                soDeliverDetail.setCrtTime(DateTimeUtil.getCustomerDate());
                this.save(SqlId.SQL_ID_SAVE_DELIVER_DETAIL,soDeliverDetail);
            }
        }
    }

    /**
     *更新配送单状态
     * @param deliver 配送单
     */
    @Transactional
    public void updateDeliverStatus(SoDeliver deliver){
        deliver.setUpdTime(DateTimeUtil.getCustomerDate());
        this.save(SqlId.SQL_ID_UPDATE_DELIVER,deliver);
    }

    /**
     *更新配送单明细
     * @param soDeliverDetail 配送单明细
     */
    @Transactional
    public void updateDeliverDetail(SoDeliverDetail soDeliverDetail){
        soDeliverDetail.setUpdTime(DateTimeUtil.getCustomerDate());
        this.save(SqlId.SQL_ID_UPDATE_DELIVER_DETAIL,soDeliverDetail);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
