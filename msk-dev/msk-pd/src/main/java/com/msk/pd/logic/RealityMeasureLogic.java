package com.msk.pd.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.RealityMeasureParam;
@Service
public class RealityMeasureLogic extends BaseLogic {
    @Override
    public int save(BaseParam baseParam) {
        RealityMeasureParam param = (RealityMeasureParam)baseParam;
        String pdRltMsrId = param.getPdRltMsrId();
        //新增主表信息
        if(StringUtil.isEmpty(pdRltMsrId)){
            int count = this.getPageCount(param);
            count ++;
            param.setPdRltMsrId(String.valueOf(count));
            return super.save(param);
        }
        return IntDef.INT_ZERO;
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
