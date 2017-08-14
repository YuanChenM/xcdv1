package com.msk.pd.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.pd.bean.PD141106Param;

@Service
public class PD141106Logic extends BaseLogic {
    @Autowired
    private RealityMeasureLogic realityMeasureLogic;
    interface SqlId{
        String SQL_ID_REMOVE_REALITY_QUALITY_VALUE = "removeRealityQualityValue";
    }
    
    
    
    @Override
    public int save(BaseParam baseParam) {
        PD141106Param param = (PD141106Param)baseParam;
        realityMeasureLogic.save(baseParam);
        super.remove(SqlId.SQL_ID_REMOVE_REALITY_QUALITY_VALUE, param);
        String [] pdQuaStdValIdArray = param.getPdQuaStdValIdArray();
        String [] pdReaValArray = param.getPdReaValArray();
        String [] remarkArray = param.getRemarkArray();
        int length = pdQuaStdValIdArray.length;
        String pdRltMsrId = param.getPdRltMsrId();
//        for (int i = 0; i < length; i++) {
//            String  pdQuaStdValId = pdQuaStdValIdArray[i];
//            String  pdReaVal = pdReaValArray[i];
//            String  remark = remarkArray[i];
//            PdRealityQualityValue realityQualityValue = new PdRealityQualityValue();
//            realityQualityValue.setPdRltMsrId(pdRltMsrId);
//            realityQualityValue.setPdQuaStdValId(pdQuaStdValId);
//            realityQualityValue.setPdReaVal(pdReaVal);
//            realityQualityValue.setRemark(remark);
//            super.save(realityQualityValue);
//        }
        return IntDef.INT_ONE;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
