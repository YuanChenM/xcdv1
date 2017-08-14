package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.pl.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuhongyang on 2017/2/10.
 * 进货单删除接口
 */
@Service
public class IPL20170203Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    interface SqlId {
        static final String SQL_ID_UPDATE_PL_INFO = "updatePlInfoById";//进货单逻辑删除
        static final String SQL_ID_UPDATE_PL_INFO_PD = "updatePlInfoPdById";//修改产品为删除
    }

    /**
     * @param param
     * @return 进货单逻辑删除操作
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int deletePlinfoByPlId(IPL20170203Param param) {

        PLInfo info = super.findOne(param);
        param.setFilter("taskId", info.getTaskId().toString());
        int deleteFlg = super.modify(SqlId.SQL_ID_UPDATE_PL_INFO,param);
        //删除成功 修改任务表状态和填报数量
        if (deleteFlg == NumberConst.IntDef.INT_ONE) {
            super.modify(SqlId.SQL_ID_UPDATE_PL_INFO_PD,param);
            if (info != null && info.getStatus()==1) {
                super.modify(param);
            }
        }
        //查询对应产品删除
        return deleteFlg;
    }
}
