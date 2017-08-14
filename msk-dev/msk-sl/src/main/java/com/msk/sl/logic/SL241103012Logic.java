package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.SlEpAgentAuthBean;
import com.msk.sl.bean.SlEpDdBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SL241103012Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private CommonLogic commonLogic;

    interface SqlId {
        String SQL_ID_SAVE_SL_EP_DD = "saveSlEpDd";
    }

    //保存数据
    public int saveData(Long epId,SlEpDdBean slEpDdBean) {
        BaseParam param = new BaseParam();
        slEpDdBean.setEpId(epId);
        slEpDdBean.setDdId(commonLogic.maxId("sl_ep_dd","DD_ID"));
        slEpDdBean.setVer(NumberConst.IntDef.INT_ONE);
        slEpDdBean.setDelFlg("0");
        return super.save(SqlId.SQL_ID_SAVE_SL_EP_DD,slEpDdBean);
    }
}