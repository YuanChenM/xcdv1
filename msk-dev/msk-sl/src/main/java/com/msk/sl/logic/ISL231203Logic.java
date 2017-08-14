package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlDistReguSug;
import com.msk.core.entity.SlDistSugHis;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231202RsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ISL231203Logic.
 *
 * @author gyh
 */
@Service
public class ISL231203Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private ISL231202Logic isl231202Logic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_MODIFY_SL_DIST_REGU_SUG = "modifySlDistReguSug";
        static final String SQL_ID_ADD_SL_DIST_SUG_HIS = "addSlDistSugHis";
    }

    public RsResponse modifySlDistSug(RsRequest<SlDistReguSug> param) {
        RsResponse rs = new RsResponse();
        SlDistReguSug slDistReguSug = param.getParam();
        SlDistSugHis sug = new SlDistSugHis();
        sug.setSlSugHisId(commonLogic.maxId("sl_dist_sug_his", "SL_SUG_HIS_ID"));
        sug.setSlSug(slDistReguSug.getSlSug());
        sug.setChapId(slDistReguSug.getChapId());
        sug.setAgreeFlg(slDistReguSug.getAgreeFlg());
        sug.setChapClass(slDistReguSug.getChapClass());
        sug.setSlCode(slDistReguSug.getSlCode());
        sug.setCrtId(slDistReguSug.getUpdId());
        //保存到章程卖家意见履历表
        isl231202Logic.save(SqlId.SQL_ID_ADD_SL_DIST_SUG_HIS, sug);
        this.modify(SqlId.SQL_ID_MODIFY_SL_DIST_REGU_SUG,slDistReguSug);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("更新分销章程卖家意见成功！");
        return rs;
    }
}
