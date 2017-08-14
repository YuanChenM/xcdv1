package com.msk.pd.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.pd.bean.PD141108Param;

@Service
public class PD141108Logic extends BaseLogic {

    @Autowired
    private RealityMeasureLogic realityMeasureLogic;

    interface SqlId {
        String SQL_ID_REMOVE_REALITY = "removeReality";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Override
    public int save(BaseParam baseParam) {
        PD141108Param param = (PD141108Param) baseParam;
        realityMeasureLogic.save(baseParam);
        super.remove(SqlId.SQL_ID_REMOVE_REALITY, param);

        int length = param.getPdTncStdIdArray().length;
        String pdRltMsrId = param.getPdRltMsrId();
//        for (int i = 0; i < length; i++) {
//
//            PdRealityTechnical realityTechnical = new PdRealityTechnical();
//            realityTechnical.setPdRltMsrId(pdRltMsrId);
//            realityTechnical.setPdTncStdId(param.getPdTncStdIdArray()[i]);
//            realityTechnical.setContent(param.getReaContentArray()[i]);
//            realityTechnical.setGradeCode("0");
//            realityTechnical.setStatus("0");
//            super.save(realityTechnical);
//        }
        return IntDef.INT_ONE;
    }
}
